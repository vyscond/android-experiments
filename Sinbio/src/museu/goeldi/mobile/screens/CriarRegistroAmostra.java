
package museu.goeldi.mobile.screens;

import museu.goeldi.mobile.R;
import museu.goeldi.mobile.cadastro.MainManager;
import museu.goeldi.mobile.cadastro.java_metadata_object.base.RegistroAmostra;
import museu.goeldi.mobile.cadastro.photoalbum.virtual.manager.VirtualPhotoAlbumManager;
import museu.goeldi.mobile.util.generics.gesture.SimpleGestureFilter;
import museu.goeldi.mobile.util.generics.gesture.SimpleGestureListener;
import museu.goeldi.mobile.util.generics.view_flipper.SwipeFlipper;
import android.app.Activity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewStub;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewFlipper;
import android.content.Intent;

public class CriarRegistroAmostra extends Activity implements SimpleGestureListener
{
    
    private SwipeFlipper flipper;
    
    
    private String       class_in = "CriarRegistroAmostra : ";
    
    @ Override
    public void onCreate ( Bundle savedInstanceState )
    {
        
        super.onCreate ( savedInstanceState );
        
        setContentView ( R.layout.activity_criar_registro_amostra_fragmented );
        
                
        ViewFlipper f = (ViewFlipper) findViewById ( R.id.viewFlipper_registro_amostra_fragmented );
        
        /* - [BGN] --- setting flip animations --- */

        flipper = new SwipeFlipper ( f , this , this );
        
        /* - [END] --- setting flip animations --- */

     
        
        
        /* - [BGN] --- configuring button actions --- */

        /* --- Descartar registro --- (fechar activity e retorna para o menu) */

        TextView textView_descartar_registro = (TextView) findViewById ( R.id.textView_descartar_registro );
        
        textView_descartar_registro.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                
                finish ( );
                
            }
        } );
        
        /*
         * --- Salvar/Persistir registro --- (salvar dado no banco ou no SDCARD e depois sair da activity)
         */

        TextView textView_salvar_registro = (TextView) findViewById ( R.id.textView_salvar_registro );
        
        textView_salvar_registro.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                
                echo( "Pressionado foi o botao de salvar" );
                
                Toast.makeText ( CriarRegistroAmostra.this , "Saving things .-." , Toast.LENGTH_SHORT ).show ( );
                
                // manager.saveOnSQLite();
                
                echo( "chamando a classe Manager para salvar o conteudo editado" );
                
                MainActivity.manager.saveNewRegisterOnSDCARD ( getInfoFromUI_and_MountNewRegistroAmostra ( ) );
                
                Toast.makeText ( CriarRegistroAmostra.this , "Done on Saving things .-." , Toast.LENGTH_SHORT ).show ( );
                
            }
        } );

    }
    
    
    
    @ Override
    public boolean onCreateOptionsMenu ( Menu menu )
    {
        
        getMenuInflater ( ).inflate ( R.menu.activity_new_simple_swipe_criar_registro_amostra , menu );
        
        return true;
    }
    
    public void onSwipe ( int direction )
    {
        // TODO Auto-generated method stub
        
        switch ( direction )
        {
            case SimpleGestureFilter.SWIPE_LEFT :
            {
                
                this.flipper.toLeft ( );
                
            }
                break;
            
            case SimpleGestureFilter.SWIPE_RIGHT :
            {
                
                this.flipper.toRight ( );
                
            }
                break;
            
            default :
            {
                
            }
                break;
        }
        
    }
    
    private void echo(String msg)
    {
        Log.d ( MainActivity.__FLAG__ , class_in + msg);
    }
    
    public RegistroAmostra getInfoFromUI_and_MountNewRegistroAmostra ( )
    {
        
        this.echo( "Function [getInfoFromUI_and_MountNewRegistroAmostra] was called" );
        
        RegistroAmostra r = new RegistroAmostra ( );
        
        /* --- collecting :D --- */

        String data = ( (EditText) findViewById ( R.id.editText_criar_registro_amostra_general_data_DATA_COLETA ) )
                .getText ( ).toString ( );
        
        r.setData_da_coleta ( data );
        
        String hora = ( (EditText) findViewById ( R.id.editText_criar_registro_amostra_general_data_HORA_COLETA ) )
                .getText ( ).toString ( );
        
        r.setHora_da_coleta ( hora );
        
        String id = ( (EditText) findViewById ( R.id.editText_criar_registro_amostra_general_data_ID_AMOSTRA ) )
                .getText ( )
                .toString ( );
        
        r.setId_da_amostra_dado_pelo_coletor ( id );
        return r;
    }
    
    public void onDoubleTap ( )
    {
        // TODO Auto-generated method stub
        
    }
    
    @ Override
    public boolean dispatchTouchEvent ( MotionEvent me )
    {
        this.flipper.getGestureFilter ( ).onTouchEvent ( me );
        return super.dispatchTouchEvent ( me );
    }
}
