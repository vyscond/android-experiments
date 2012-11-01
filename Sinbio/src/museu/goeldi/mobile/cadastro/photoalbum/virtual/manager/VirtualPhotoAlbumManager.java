package museu.goeldi.mobile.cadastro.photoalbum.virtual.manager;

import java.util.HashMap;

import museu.goeldi.mobile.cadastro.photoalbum.virtual.composite.SimplePhotoAlbumView;
import museu.goeldi.mobile.cadastro.photoalbum.virtual.composite.pojo.Photo;
import museu.goeldi.mobile.screens.MainActivity;
import museu.goeldi.mobile.util.SdcardManager;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.text.format.Time;
import android.util.Log;
import android.view.Display;
import android.widget.GridView;



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

    private int photo_width;

    private int photo_height;
    
    
    
    public VirtualPhotoAlbumManager( Activity activity , GridView gridView ,  int photo_per_line , int layout_model_ID_for_photos , String prefix )
    {
        
        this.prefix = prefix;
        
        this.echo ( "Pointing to main context" );
        Context context = (Context) activity; 
        
        this.echo ( "Creating a new GridView" );
        this.photoAlbum = new SimplePhotoAlbumView ( context , activity , gridView , photo_per_line );
        
        this.echo ( "Creating a new SdcardManager" );
        this.sdcardManager = new SdcardManager ( );
        
        this.sdcardManager.changeDirectory ( MainActivity.BASE_FOLDER );
        
        this.echo ( "Change directory from : ["+this.sdcardManager.getBackPath ( )+"] to ["+this.sdcardManager.getWorkingDirectoryPath ( )+"/]" );
        
        
        
        this.echo ( "Set base path for manipulation : "+ this.sdcardManager.getWorkingDirectoryPath ( ) );
        this.echo ( "Set ID reference for POJO builds" );
        this.layout_model_ID_for_photos = layout_model_ID_for_photos;
        
        
        photo_width = MainActivity.DIPLAY_WIDTH / photo_per_line;
        photo_height = MainActivity.DISPLAY_HEIGHT / (photo_per_line + 2);
       
        
    }
    
    public void addPhoto( Bitmap photo  )
    {
        
        Time now = new Time();
        now.setToNow();
        
        String date  = "day_"+now.monthDay+"_month_"+now.month+"_year_"+now.year+"_hour_"+now.hour+"_min_"+now.minute;
        
        String fileName  = this.prefix + date;
        
        this.photosTaked.put ( fileName , photo );
        
        this.photoAlbum.addPhoto ( new Photo ( layout_model_ID_for_photos , photo , fileName , photo_width , photo_height ) );
    }
    
    public GridView getGridView()
    {
        this.echo ( "Returning workingOn stance of GridView" );
        
        return this.photoAlbum.getGridView ( );
    }
    
    public void saveAllPhotos( String registroFolderName )
    {
        this.echo ( "Trying to save photos");
        
        this.echo ( "verifying for folder existence :D" );
        
        if ( ! this.sdcardManager.isFolderReachable ( registroFolderName ) ) // diretorio não existe
        {
            this.echo ( "folder was created" );
            this.sdcardManager.createFolder( registroFolderName );
        }
        
        this.echo ( "changing directory" );
        
        this.sdcardManager.changeDirectory ( registroFolderName );
        
        this.echo ( "Behold the dragon! Foreach is comming!" );
        
        for ( String label : this.photosTaked.keySet ( ) )
        {
            
            
            
            this.sdcardManager.saveBitmapAsJPEG ( this.photosTaked.get ( label ) , label , SdcardManager.IMAGE_QUALITY_OK_THATS_FINE );
            
        }
    }
    
}

