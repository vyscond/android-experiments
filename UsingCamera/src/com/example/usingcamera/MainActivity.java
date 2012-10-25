
package com.example.usingcamera;

import java.io.File;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity
{
    
   
    private DummyCam cam;
    
    @ Override
    public void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        
        this.cam = new DummyCam ( this , "SINBIO" );
        
        Button call_CAM = (Button) findViewById ( R.id.button1 );
        
        call_CAM.setOnClickListener ( new OnClickListener( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                cam.takePictureSaveAs (  "oh_lawd.png" );
            
                try
                {
                    Uri uriSavedImage=Uri.fromFile(new File("/sdcard/SINBIO/oh_lawd.png"));
                    ImageView iv = (ImageView) findViewById ( R.id.imageView1 );
                    
                    iv.setImageURI ( uriSavedImage );

                }
                catch ( Exception e )
                {
                    // TODO: handle exception
                    Log.d ( "DummyCamm" , "ImgNotFound" );
                }
                
            }
            
            
        });
        
       
        
    }
    
    @ Override
    public boolean onCreateOptionsMenu ( Menu menu )
    {
        getMenuInflater ( ).inflate ( R.menu.activity_main , menu );
        return true;
    }
}
