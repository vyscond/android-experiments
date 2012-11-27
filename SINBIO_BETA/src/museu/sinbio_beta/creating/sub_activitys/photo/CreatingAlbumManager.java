package museu.sinbio_beta.creating.sub_activitys.photo;

import museu.sinbio_beta.MenuActivity;
import museu.sinbio_beta.R;
import museu.sinbio_beta.common.photo.manager.PhotoAlbumManager;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.widget.GridView;


public class CreatingAlbumManager
{
    private PhotoAlbumManager photoAlbumManager;

    
    
    public CreatingAlbumManager ( Activity activity , GridView gridView , int photoPerLines )
    {
        super ( );
        
        
        this.photoAlbumManager = new PhotoAlbumManager ( activity , gridView , photoPerLines , R.layout.pojo_picture , "SINBIO_AMOSTRA_PIC_" );
    }
    
    
    public void deletePhoto( String photoPath , int position)
    {
        
        this.photoAlbumManager.deletePhotoFromVirtualList ( position );
        
        //this.photoAlbumManager.deletePhotoFromFolder ( photoPath );
    }
    
    public PhotoAlbumManager getPhotoAlbumManager ( )
    {
        return photoAlbumManager;
    }



    public void addPhoto( Bitmap pic )
    {
        this.photoAlbumManager.addPhoto ( pic );
    }
    
    public void saveTakedPictures( String absolutePath )
    {
        this.photoAlbumManager.saveAllPhotos ( absolutePath );
    }
    
    public void echo (String msg)
    {
        Log.d ( MenuActivity.__FLAG__ , "CreatingAlbumManager : " + msg );
    }
}
