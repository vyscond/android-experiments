package museu.goeldi.mobile.cadastro.photomanagement.the_album;

import java.io.File;

import museu.goeldi.mobile.cadastro.photomanagement.storage.SdcardManager;
import museu.goeldi.mobile.cadastro.photomanagement.the_album.gridview.SimplePhotoAlbumView;
import museu.goeldi.mobile.cadastro.photomanagement.the_album.item.RawPhoto;
import museu.goeldi.mobile.screens.MainActivity;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.widget.GridView;



public class PhotoAlbumManager
{
    
    private final String class_in = "PhotoAlbumManager : ";
    
    private SimplePhotoAlbumView photoAlbum;
    
    private SdcardManager sdcardManager;
    
    private String folder_path;
    
    private int layout_model_ID_for_photos;
    
    public void echo(String msg)
    {
        Log.d ( MainActivity.__FLAG__  , class_in + msg );
    }
    
    public PhotoAlbumManager( Activity activity , GridView gridView ,  int photo_per_line , int layout_model_ID_for_photos , String folder_path )
    {
        this.echo ( "Pointing to main context" );
        Context context = (Context) activity; 
        
        this.echo ( "Creating a new GridView" );
        this.photoAlbum = new SimplePhotoAlbumView ( context , activity , gridView , layout_model_ID_for_photos , folder_path , photo_per_line );
        
        this.echo ( "Creating a new SdcardManager" );
        this.sdcardManager = new SdcardManager ( );
        
        this.echo ( "Set base path for manipulation : "+folder_path );
        this.folder_path = folder_path;
        
        this.echo ( "Set ID reference for POJO builds" );
        this.layout_model_ID_for_photos = layout_model_ID_for_photos;
        
        this.echo ( "Try : initializing GridView" );
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
        
        File[] files = this.sdcardManager.fetchPhotosInFileFormatAt ( this.folder_path );
        
        this.echo ( "paths are fetched" );
        
        for ( File file : files )
        {
            RawPhoto p = new RawPhoto ( layout_model_ID_for_photos , file.getAbsolutePath ( ) , file.getName ( ) , 30 , 30 );
            
            this.photoAlbum.addPhoto ( p );
        }
        
    }
}

