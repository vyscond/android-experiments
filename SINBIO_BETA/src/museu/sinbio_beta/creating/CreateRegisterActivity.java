
package museu.sinbio_beta.creating;

import museu.sinbio_beta.MenuActivity;
import museu.sinbio_beta.R;
import museu.sinbio_beta.common.xml.pojo.RegisterXml;
import museu.sinbio_beta.creating.sub_activitys.photo.CreatingAlbumManager;
import museu.sinbio_beta.creating.sub_activitys.xml.CreatingRegisterXMLManager;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.TextView;
import android.widget.Toast;

public class CreateRegisterActivity extends Activity
{
    
    private TextView                   saveAll;
    
    private View                       viewStubPhotoAlbumView;
    
    private View                       viewStubFormView;
    
    private Button                     buttonTabPhotoAlbumView;
    
    private Button                     buttonTabFormView;
    
    private TextView                   textViewTakingPhoto;
    
    private CreatingAlbumManager       creatingAlbumManager;
    
    private CreatingRegisterXMLManager creatingRegisterXMLManager;
    
    /* --- forms --- */

    private EditText                   editTextIdAmostra;
    
    private EditText                   editTextData;
    
    private EditText                   editTextHora;
    
    public void onCreate ( Bundle savedInstanceState )
    {
        
        super.onCreate ( savedInstanceState );
        
        setContentView ( R.layout.activity_create_register );
        
        /*-------------------------------------------------
         * 
         *               BUILDING TAB
         * 
         *-------------------------------------------------*/

        viewStubPhotoAlbumView = ( (ViewStub) findViewById ( R.id.viewStub_createregister_photo_album ) ).inflate ( );
        
        viewStubFormView = ( (ViewStub) findViewById ( R.id.viewStub_createregister_form ) ).inflate ( );
        
        GridView gV = ( (GridView) viewStubPhotoAlbumView.findViewById ( R.id.gridView_photo_gallery ) );
        
        // viewStubFormView.setVisibility ( View.GONE );
        
        /*------------------------------------------------------
         * 
         *                  Building Managers
         * 
         *-----------------------------------------------------*/

        this.creatingAlbumManager = new CreatingAlbumManager ( this , gV , 2 );
        
        this.creatingRegisterXMLManager = new CreatingRegisterXMLManager ( );
        
        /*------------------------------------------------------
         * 
         *                   BUILDING FORMS LINKS
         * 
         *------------------------------------------------------*/

        this.echo ( "Build forms links" );
        
        
        this.editTextIdAmostra = ( (EditText) viewStubFormView.findViewById ( R.id.editText_register_form_ID_AMOSTRA ) );
        this.editTextData = ( (EditText) viewStubFormView.findViewById ( R.id.editText_register_form_DATE ) );
        this.editTextHora = ( (EditText) viewStubFormView.findViewById ( R.id.editText_register_form_HOUR ) );
        
        if ( this.editTextIdAmostra == null || this.editTextHora == null || this.editTextData == null )
        {
            Toast.makeText ( CreateRegisterActivity.this , "NUll LINKS" , Toast.LENGTH_SHORT ).show ( );
        }
        
        /*-----------------------------------------------------
         *                   
         *                   Button Tabs
         *                   
         *-----------------------------------------------------*/

        buttonTabPhotoAlbumView = (Button) findViewById ( R.id.button_createregister_invoke_photo_album );
        
        buttonTabFormView = (Button) findViewById ( R.id.button_createregister_invoke_forms );
        
        buttonTabPhotoAlbumView.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                switchFromFormToPhotoAlbum ( );
            }
        } );
        
        buttonTabFormView.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                switchFromPhotoAlbumToForm ( );
            }
        } );
        
        /*-------------------------------------------------
         * 
         *           TAKE PHOTOS... EVERY DAY
         *  
         *-------------------------------------------------*/

        textViewTakingPhoto = (TextView) viewStubPhotoAlbumView.findViewById ( R.id.textView_photo_album_take_pic );
        
        if ( textViewTakingPhoto == null )
        {
            Toast.makeText ( CreateRegisterActivity.this , "LUls" , Toast.LENGTH_SHORT ).show ( );
        }
        
        textViewTakingPhoto.setOnClickListener ( new OnClickListener ( )
         {
             
             public void onClick ( View v )
             {
                 
                 // TODO Auto-generated method stub
                 takingPhoto ( v );
             }
             
         } );
        
        /*-------------------------------------------------
         *
         *                SAVE ALL / CANCEL ALL
         *                
         *-------------------------------------------------*/

        this.saveAll = (TextView) findViewById ( R.id.textView_createregister_save_all );
        
        this.saveAll.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                saveAll ( );
            }
        } );
        
        this.switchFromFormToPhotoAlbum ( );
    }
    
    protected void takingPhoto ( View v )
    {
        // TODO Auto-generated method stub// this.registerFormActivity.getInfoFromUI ( );
        
        // --- Recuperando a activity atualmente selecionanda no tabhost
        // String tabTag = getTabHost().getCurrentTabTag();
        
        
        Intent cameraIntent = new Intent (
                android.provider.MediaStore.ACTION_IMAGE_CAPTURE );
        startActivityForResult ( cameraIntent , 2 );
        
    }
    
    public void onActivityResult ( int requestCode , int resultCode , Intent data )
    {
        if ( requestCode == 2 )
        {
            
            try
            
            {
                Bitmap pic = (Bitmap) data.getExtras ( ).get ( "data" );
                
                this.creatingAlbumManager.addPhoto ( pic );
            }
            catch ( Exception e )
            {
                // TODO: handle exception
                Toast.makeText ( CreateRegisterActivity.this , "Photo Canceled" , Toast.LENGTH_SHORT ).show ( );
            }
            
        }
    }
    
    public void switchFromPhotoAlbumToForm ( )
    {
        this.viewStubPhotoAlbumView.setVisibility ( View.GONE );
        this.viewStubFormView.setVisibility ( View.VISIBLE );
        
        Resources r = getResources ( );
        
        this.buttonTabFormView.setBackground ( r.getDrawable ( R.drawable.background_shape_color_144d3c_borders_no_rounded ) );
        this.buttonTabFormView.setTextColor ( Color.WHITE );
        
        this.buttonTabPhotoAlbumView.setBackground ( r.getDrawable ( R.drawable.background_shape_color_ffffff_borders_no_rounded ) );
        this.buttonTabPhotoAlbumView.setTextColor ( Color.BLACK );
        
    }
    
    public void switchFromFormToPhotoAlbum ( )
    {
        this.viewStubFormView.setVisibility ( View.GONE );
        this.viewStubPhotoAlbumView.setVisibility ( View.VISIBLE );
        
        Resources r = getResources ( );
        
        this.buttonTabPhotoAlbumView.setBackground ( r.getDrawable ( R.drawable.background_shape_color_144d3c_borders_no_rounded ) );
        this.buttonTabPhotoAlbumView.setTextColor ( Color.WHITE );
        
        this.buttonTabFormView.setBackground ( r.getDrawable ( R.drawable.background_shape_color_ffffff_borders_no_rounded ) );
        this.buttonTabFormView.setTextColor ( Color.BLACK );
    }
    
    public void saveAll ( )
    {
        // --- criando um XML
        
        
        
        this.echo ( "Save All running" );
        
        Toast.makeText ( this , "Building XML" , Toast.LENGTH_SHORT ).show ( );
        
        String idString = this.editTextIdAmostra.getText ( ).toString ( );
        String dataString  = this.editTextData.getText ( ).toString ( );
        String horaString = this.editTextHora.getText ( ).toString ( );
        
                
        String folderPath = Environment.getExternalStorageDirectory ( ).getAbsolutePath ( )+"/"+MenuActivity.BASE_FOLDER+"/"+"REGISTRO_"+this.editTextIdAmostra.getText ( ).toString ( );
        
        String fileName = "registro_"+this.editTextIdAmostra.getText ( ).toString ( );
        
        RegisterXml reg = new RegisterXml ( idString , dataString , horaString , fileName , folderPath );
        
        
        Toast.makeText ( this , "Saving XML in Folder ["+folderPath+"]" , Toast.LENGTH_SHORT ).show ( );
        
        this.creatingRegisterXMLManager.saveNewXml (  reg  );
        
        Toast.makeText ( this , "Saving Images" , Toast.LENGTH_SHORT ).show ( );
        
        this.creatingAlbumManager.saveTakedPictures ( folderPath );
        
        Toast.makeText ( this , "Its on mothafucka []" , Toast.LENGTH_SHORT ).show ( );
    }
    
    @ Override
    public boolean onCreateOptionsMenu ( Menu menu )
    {
        getMenuInflater ( ).inflate ( R.menu.activity_create_register , menu );
        return true;
    }
    
    public void echo ( String msg )
    {
        Log.d ( MenuActivity.__FLAG__ , "CreateReg : " + msg );
    }
}
