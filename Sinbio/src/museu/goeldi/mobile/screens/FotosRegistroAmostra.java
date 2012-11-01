package museu.goeldi.mobile.screens;

import museu.goeldi.mobile.R;
import museu.goeldi.mobile.cadastro.photoalbum.virtual.manager.VirtualPhotoAlbumManager;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class FotosRegistroAmostra extends Activity {

    private VirtualPhotoAlbumManager virtualPhotoAlbumManager;
    private String class_in = "FotosRegistroAmostra : ";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fotos_registro_amostra);
        
        GridView gridView = (GridView) findViewById ( R.id.gridView_registro_amostra_galeria_de_fotos );
        
        this.virtualPhotoAlbumManager = new VirtualPhotoAlbumManager ( this , gridView , 2 , R.layout.photo , "FOTO_REGISTRO_" );
        
        /*--------------------------------------------------------------------------------*
         * 
         *                                   TAKING PICS 
         *                              
         *--------------------------------------------------------------------------------*/
        
        TextView button_take_pic = (TextView) findViewById ( R.id.TextView_capturar_imagem );
        
        button_take_pic.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                Intent cameraIntent = new Intent (
                        android.provider.MediaStore.ACTION_IMAGE_CAPTURE );
                startActivityForResult ( cameraIntent , 2 );
            }
        } );
        
        /*--------------------------------------------------------------------------------*
         * 
         *                                   SAVING PICS
         *                              
         *--------------------------------------------------------------------------------*/
        
        
        final TextView saving_pics = (TextView) findViewById ( R.id.textView_salvar_fotos );
        
        saving_pics.setOnClickListener ( new OnClickListener( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                
                showPopUpSelectFolder ( saving_pics );
                
            }
        });
        
        /*--------------------------------------------------------------------------------*
         * 
         *                                   CANCEL PICS
         *                              
         *--------------------------------------------------------------------------------*/
        
        final TextView cancel_pics = (TextView) findViewById ( R.id.textView_descartar_fotos );
        
        cancel_pics.setOnClickListener ( new OnClickListener( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                
                finish ( );
                
            }
        });
        
        
    }
    
    public void showPopUpSelectFolder( View v )
    {
        View contentView;
        
        contentView = (LayoutInflater.from(this )).inflate(R.layout.fotos_pop_up_selecao_folder, null);

        Spinner spinner = (Spinner) contentView.findViewById ( R.id.spinner_fotos_pop_up_selecao_folder_pastas_disponiveis );
        
        PopupWindow pop =new PopupWindow ( contentView , MainActivity.DIPLAY_WIDTH - 15 , MainActivity.DISPLAY_HEIGHT - 15 , true);
        
        if( contentView.getParent ( ) == null )
        {
            this.echo ( "FODA-SE :DDD" );
        }
        
        pop.showAtLocation( v, Gravity.CENTER, 0 , 0);
    }
    
    public void onActivityResult ( int requestCode , int resultCode , Intent data )
    {
        if ( requestCode == 2 )
        {
            
            try
            
            {
                Bitmap photo = (Bitmap) data.getExtras ( ).get ( "data" );
                
                virtualPhotoAlbumManager.addPhoto ( photo );
            }
            catch ( Exception e )
            {
                // TODO: handle exception
                Toast.makeText ( FotosRegistroAmostra.this , "Photo Canceled" , Toast.LENGTH_SHORT ).show ( );
            }
            
        }
    }

    public void echo ( String msg )
    {
        Log.d ( MainActivity.__FLAG__ , class_in  + msg );
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_fotos_registro_amostro, menu);
        return true;
    }
}
