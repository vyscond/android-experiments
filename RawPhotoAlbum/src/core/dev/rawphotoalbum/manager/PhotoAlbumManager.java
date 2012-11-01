package core.dev.rawphotoalbum.manager;

import java.io.File;
import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.util.Log;
import android.view.Display;
import android.widget.GridView;
import core.dev.rawphotoalbum.MainActivity;
import core.dev.rawphotoalbum.composite.SimplePhotoAlbumView;
import core.dev.rawphotoalbum.composite.pojo.Photo;
import core.dev.rawphotoalbum.manager.engine.SdcardManager;


public class PhotoAlbumManager
{
    
    private final String class_in = "PhotoAlbumManager : ";
    
    private SdcardManager sdcardManager;
    
    private SimplePhotoAlbumView photoAlbum;
    
    private int layout_model_ID_for_photos;
    
    public void echo(String msg)
    {
        Log.d ( MainActivity.__FLAG__  , class_in + msg );
    }
    
    private int photo_width , photo_height;
    
    public PhotoAlbumManager( Activity activity , GridView gridView ,  int photo_per_line , int layout_model_ID_for_photos , String folder_path )
    {
        this.echo ( "Pointing to main context" );
        Context context = (Context) activity; 
        
        this.echo ( "Creating a new GridView" );
        this.photoAlbum = new SimplePhotoAlbumView ( context , activity , gridView , photo_per_line );
        
        this.echo ( "Creating a new SdcardManager" );
        this.sdcardManager = new SdcardManager ( );
        this.echo ( "Change directory from : ["+this.sdcardManager.getWorkingDirectoryPath ( )+"] to ["+this.sdcardManager.getWorkingDirectoryPath ( )+"/"+folder_path+"]" );
        
        this.sdcardManager.changeDirectory ( folder_path );
        
        this.echo ( "Set base path for manipulation : "+folder_path );
        this.echo ( "Set ID reference for POJO builds" );
        this.layout_model_ID_for_photos = layout_model_ID_for_photos;
        
        this.echo ( "Try : initializing GridView" );
        
        //Display display = activity.getWindowManager().getDefaultDisplay();
        //Point size = new Point(); 
        //display.getSize(size);
        
        Display display = activity.getWindowManager ( ).getDefaultDisplay ( );
        
        photo_width = display.getWidth ( ) / photo_per_line;
        photo_height = display.getHeight ( ) / (photo_per_line + 2);
        
        
        this.initializeGridView();
        
    }

    public GridView getGridView()
    {
        this.echo ( "Returning workingOn stance of GridView" );
        
        return this.photoAlbum.getGridView ( );
    }
    
    private void initializeGridView ( )
    {
        // TODO Auto-generated method stub
        
        this.echo ( "Try : fecth all the valid file paths related for photos" );
        
        Vector < File > pictures = this.sdcardManager.getPictures ( );
        
        this.echo ( "paths are fetched" );
        
        for ( File pic : pictures )
        {
            BitmapFactory.Options options = new BitmapFactory.Options ( );
            
            options.inSampleSize = 1;
            
            //
            
            Bitmap bmImg = BitmapFactory.decodeFile ( pic.getAbsolutePath ( )  , options);
            
            Photo p = new Photo ( layout_model_ID_for_photos ,  bmImg , photo_width ,  photo_height);
            
            this.photoAlbum.addPhoto ( p );
        }
        
    }
}

