
package core.dev.virtualphotolist;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;
import core.dev.virtualphotolist.photoengine.manager.VirtualPhotoAlbumManager;

public class MainActivity extends Activity
{
    
    public static String             __FLAG__ = "VirtualPhotoList";
    
    private VirtualPhotoAlbumManager virtualAlbum;
    
    @ Override
    public void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        
        GridView gridView = (GridView) findViewById ( R.id.gridView1 );
        
        this.virtualAlbum = new VirtualPhotoAlbumManager ( this , gridView , 3 , R.layout.photo , "" , "IMG_TEST_" );
        
        Button button_take_pic = (Button) findViewById ( R.id.button1 );
        
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
        
    }
    
    public void onActivityResult ( int requestCode , int resultCode , Intent data )
    {
        if ( requestCode == 2 )
        {
            
            try
            
            {
                Bitmap photo = (Bitmap) data.getExtras ( ).get ( "data" );
                
                virtualAlbum.addPhoto ( photo );
            }
            catch ( Exception e )
            {
                // TODO: handle exception
                Toast.makeText ( MainActivity.this , "Photo Canceled" , Toast.LENGTH_SHORT ).show ( );
            }
            
        }
    }
    
    @ Override
    public boolean onCreateOptionsMenu ( Menu menu )
    {
        getMenuInflater ( ).inflate ( R.menu.activity_main , menu );
        return true;
    }
}
