
package museu.sinbio_beta.common.photo.manager;

import java.io.File;
import java.util.HashMap;
import java.util.Vector;

import museu.sinbio_beta.MenuActivity;
import museu.sinbio_beta.common.filesystem.SdcardManager;
import museu.sinbio_beta.common.photo.composite.SimplePhotoAlbumView;
import museu.sinbio_beta.common.photo.manager.pojo.SimplePojoPicture;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.format.Time;
import android.util.Log;
import android.widget.GridView;

public class PhotoAlbumManager
{
    
    private final String                class_in    = "PhotoAlbumManager : ";
    
    private SdcardManager               sdcardManager;
    
    private SimplePhotoAlbumView        photoAlbum;
    
    private int                         layout_model_ID_for_photos;
    
    private HashMap < String , Bitmap > photosTaked = new HashMap < String , Bitmap > ( );
    
    public void echo ( String msg )
    {
        Log.d ( MenuActivity.__FLAG__ , class_in + msg );
    }
    
    private String prefix;
    
    private int    photo_width;
    
    private int    photo_height;
    
    public SimplePojoPicture getPhoto( File f )
    {
        BitmapFactory.Options options = new BitmapFactory.Options ( );
        
        options.inSampleSize = 1;
        
        Bitmap bmImg = BitmapFactory.decodeFile ( f.getAbsolutePath ( ) , options );
        
        SimplePojoPicture p = new SimplePojoPicture ( layout_model_ID_for_photos , bmImg , f.getName ( ) );
        
        p.setImagePath ( f.getAbsolutePath ( ) );
        
        return p;
    }
    
    public PhotoAlbumManager ( Activity activity , GridView gridView , int photoPerLine ,
            int layout_model_ID_for_photos , String prefix )
    {
        
        this.prefix = prefix;
        
        this.echo ( "Pointing to main context" );
        Context context = (Context) activity;
        
        this.echo ( "Creating a new GridView" );
        this.photoAlbum = new SimplePhotoAlbumView ( context , activity , gridView , photoPerLine );
        
        this.echo ( "Creating a new SdcardManager" );
        this.sdcardManager = new SdcardManager ( );
        
        this.sdcardManager.changeDirectory ( MenuActivity.BASE_FOLDER );
        
        this.echo ( "Change directory from : [" + this.sdcardManager.getBackPath ( ) + "] to [" + this.sdcardManager.getWorkingDirectoryPath ( ) + "/]" );
        
        this.echo ( "Set base path for manipulation : " + this.sdcardManager.getWorkingDirectoryPath ( ) );
        this.echo ( "Set ID reference for POJO builds" );
        this.layout_model_ID_for_photos = layout_model_ID_for_photos;
        
        photo_width = MenuActivity.DIPLAY_WIDTH / photoPerLine;
        photo_height = MenuActivity.DISPLAY_HEIGHT / ( photoPerLine + 2 );
        
    }
    
    public void addPhoto ( Bitmap pic )
    {
        
        Time now = new Time ( );
        now.setToNow ( );
        
        String date = "day_" + now.monthDay + "_month_" + now.month + "_year_" + now.year + "_hour_" + now.hour + "_min_" + now.minute + "_sec_" + now.second;
        
        String fileName = this.prefix + date;
        
        this.photosTaked.put ( fileName , pic );
        
        this.photoAlbum.addPhoto ( new SimplePojoPicture ( layout_model_ID_for_photos , pic , fileName , photo_width , photo_height ) );
    }
    
    public void addPhoto(SimplePojoPicture p)
    {
        this.photosTaked.put ( p.getImageName ( ) , p.getImage ( ) );
     
        p.setWidth ( this.photo_width );
        
        p.setHeight ( this.photo_height );
        
        this.photoAlbum.addPhoto ( p );
    }
    
    public GridView getGridView ( )
    {
        this.echo ( "Returning workingOn stance of GridView" );
        
        return this.photoAlbum.getGridView ( );
    }
    
    public void showPicturesAtFolder ( String absolutePath )
    {
        // TODO Auto-generated method stub
        
       
        
        this.echo ( "Try : fecth all the valid file paths related for photos" );
        
        if ( this.sdcardManager.isFolderReachable ( absolutePath ) )
        {
            this.sdcardManager.changeDirectory ( absolutePath );
            
            Vector < File > pictures = this.sdcardManager.getPictures ( );
            
            this.echo ( "Pictures at path are fetched" );
            
            for ( File pic : pictures )
            {
                BitmapFactory.Options options = new BitmapFactory.Options ( );
                
                options.inSampleSize = 1;
                
                Bitmap bmImg = BitmapFactory.decodeFile ( pic.getAbsolutePath ( ) , options );
                
                SimplePojoPicture p = new SimplePojoPicture ( layout_model_ID_for_photos , bmImg , pic.getName ( ) );
                
                p.setImagePath ( absolutePath );
                
                this.echo ( "Adding photo with path ["+p.getImagePath ( )+"]" );
                
                this.photoAlbum.addPhoto ( p );
            }
        }
        else
        {
            this.echo ( "no valid operation" );
        }
        
    }
    
    public void deletePhotoFromVirtualList( int position )
    {
        SimplePojoPicture photoToDelete = this.photoAlbum.getPhoto ( position );
        this.photoAlbum.remove( position );
        this.photosTaked.remove ( photoToDelete.getImageName ( ) );
    }
    
    public void saveAllPhotos ( String absolutePath )
    {
        this.echo ( "Trying to save photos" );
        
        this.echo ( "Behold the dragon! Foreach is comming!" );
        
        try
        {
        
            for ( String label : this.photosTaked.keySet ( ) )
            {
                this.echo ( "Saving on sdcard : "+absolutePath  );
                
                this.sdcardManager.saveBitmapAsJPEG ( this.photosTaked.get ( label ) , label , SdcardManager.IMAGE_QUALITY_OK_THATS_FINE , absolutePath );
                
            }
        }
        catch (Exception e) {

            // TODO: handle exception
            
            this.echo ( "No photos on the adapter list" );
        }
    }

    public void deletePhotoFromFolder ( String photoPath )
    {
        // TODO Auto-generated method stub
        this.sdcardManager.removeFile( photoPath );
    }
    
}
