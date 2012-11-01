package core.dev.virtualphotolist.photoengine.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.widget.GridView;
import core.dev.virtualphotolist.MainActivity;
import core.dev.virtualphotolist.photoengine.composite.SimplePhotoAlbumView;
import core.dev.virtualphotolist.photoengine.composite.pojo.Photo;


public class VirtualPhotoAlbumManager
{
    
    private final String class_in = "PhotoAlbumManager : ";
    
    private SdcardManager sdcardManager;
    
    private SimplePhotoAlbumView photoAlbum;
    
    private int layout_model_ID_for_photos;
    
    private HashMap < String , Bitmap > photosTaked = new HashMap < String , Bitmap > ( );
    
    public void echo(String msg)
    {
        Log.d ( MainActivity.__FLAG__  , class_in + msg );
    }
    
    private String prefix;
    
    
    
    public VirtualPhotoAlbumManager( Activity activity , GridView gridView ,  int photo_per_line , int layout_model_ID_for_photos , String folder_path , String prefix )
    {
        
        this.prefix = prefix;
        
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
        
   
       
        
    }

    
    public void addPhoto( Bitmap photo  )
    {
        this.photosTaked.put ( this.prefix + this.photosTaked.size ( ) , photo );
        
        this.photoAlbum.addPhoto ( new Photo ( layout_model_ID_for_photos , photo ) );
    }
    
    public GridView getGridView()
    {
        this.echo ( "Returning workingOn stance of GridView" );
        
        return this.photoAlbum.getGridView ( );
    }
    
    
}

