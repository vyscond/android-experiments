
package com.example.usingcamera;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;

public class DummyCam
{
    
    private String folder_name;
    
    private Activity         activity;
    
    private static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 100;
    
    private static final int CAPTURE_VIDEO_ACTIVITY_REQUEST_CODE = 200;
    
    private static final String    TAG                                 = "DummyCam";
    
    public static final int  MEDIA_TYPE_IMAGE                    = 1;
    
    public static final int  MEDIA_TYPE_VIDEO                    = 2;
    
    
    
    
    public String getFolder_name ( )
    {
        return folder_name;
    }

    
    public void setFolder_name ( String folder_name )
    {
        this.folder_name = folder_name;
    }

    public void takePictureSaveAs ( String file_name )
    {
        // create Intent to take a picture and return control to the calling
        // application
        Intent camera = new Intent ( MediaStore.ACTION_IMAGE_CAPTURE );
        Uri uriSavedImage = Uri.fromFile ( new File ( "/sdcard/"+this.folder_name+"/"+file_name ) );
        camera.putExtra ( "output" , uriSavedImage );
        // startActivityForResult(camera, 1);
        // start the image capture Intent
        this.activity.startActivityForResult ( camera , CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE );
    }
    
    public DummyCam ( Activity activity , String base_folder_name )
    {
        super ( );
        this.activity = activity;
        this.folder_name = base_folder_name;
    }
    
}
