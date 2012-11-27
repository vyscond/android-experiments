package museu.sinbio_beta.maintaining.photo;

import java.io.File;
import java.util.Vector;

import museu.sinbio_beta.R;
import museu.sinbio_beta.common.photo.manager.PhotoAlbumManager;
import museu.sinbio_beta.common.photo.manager.pojo.SimplePojoPicture;
import android.app.Activity;
import android.graphics.Bitmap;
import android.widget.GridView;


public class EditingAlbumManager
{
    
    private PhotoAlbumManager photoAlbumManager;

    public EditingAlbumManager ( Activity activity , GridView gridView , int photoPerLines )
    {
        super ( );
        
        
        this.photoAlbumManager = new PhotoAlbumManager ( activity , gridView , photoPerLines , R.layout.pojo_picture , "SINBIO_AMOSTRA_PIC_" );
    }
    
    public void showAllAvailablePhotosAtPath(String absolutePath)
    {
        this.photoAlbumManager.showPicturesAtFolder ( absolutePath );
    }
    
    public void addPhotoVector( Vector < File > images )
    {
        
        for ( File file : images )
        {
            this.photoAlbumManager.addPhoto ( this.photoAlbumManager.getPhoto ( file ) );
        }
        
    }
    public void addPhoto( Bitmap pic )
    {
        this.photoAlbumManager.addPhoto ( pic );
    }
    public void deletePhoto( String photoPath , int position)
    {
        
        this.photoAlbumManager.deletePhotoFromVirtualList ( position );
        
        this.photoAlbumManager.deletePhotoFromFolder ( photoPath );
    }

    public void saveTakedPictures( String absolutePath )
    {
        this.photoAlbumManager.saveAllPhotos ( absolutePath );
    }
}
