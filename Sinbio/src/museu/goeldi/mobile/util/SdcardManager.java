
package museu.goeldi.mobile.util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.util.Vector;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

public class SdcardManager
{
    
    private File   working_path = Environment.getExternalStorageDirectory ( );
    
    private String back_path    = working_path.getAbsolutePath ( );
    
    public String getWorkingDirectoryAbsolutePath ( )
    {
        return this.working_path.getAbsolutePath ( );
    }
    
    public String getWorkingDirectoryPath ( )
    {
        return this.working_path.getName ( );
    }
    
    public String getBackPath ( )
    {
        return back_path;
    }
    
    public void setBack_path ( String back_path )
    {
        this.back_path = back_path;
    }
    
    public boolean isFolderReachable ( String folderName )
    {
        if ( new File ( this.working_path.getAbsolutePath ( ) + "/" + folderName ) == null )
        {
            return false;
        }
        
        else
        {
            return true;
        }
    }
    
    public void changeDirectory ( String folderName )
    {
        
        if ( this.isFolderReachable ( folderName ) )
        {
            
            this.back_path = this.working_path.getAbsolutePath ( );
            
            this.working_path = new File ( this.working_path.getAbsolutePath ( ) + "/" + folderName );
            
        }
        
        else
        {
            
            this.echo ( "New Path reached" );
            
            this.echo ( "Cant reach new Path" );
            
            this.echo ( "still working on this old path -> " + this.working_path.getAbsolutePath ( ) );
        }
    }
    
    public Vector < String > toVectorPictures ( )
    {
        Vector < String > folders = new Vector < String > ( );
        
        for ( File file : this.working_path.listFiles ( ) )
        {
            if ( file.isDirectory ( ) )
            {
                folders.add ( file.getName ( ) );
            }
            
        }
        
        return folders;
    }
    
    public Vector < File > getPictures ( )
    {
        
        return this.getVectorPictures ( working_path , this.getImageFilters ( ) , - 1 );
    }
    
    public Vector < String > getPicturesAbsolutePath ( )
    {
        
        Vector < File > allMatchingFilesByFilter = this.getPictures ( );
        
        Vector < String > picturesPath = new Vector < String > ( );
        
        for ( File file : allMatchingFilesByFilter )
        {
            picturesPath.add ( file.getAbsolutePath ( ) );
        }
        
        return picturesPath;
    }
    
    private FilenameFilter[] getImageFilters ( )
    {
        this.echo ( "Generanting FilterList for images :D" );
        
        String[] imageTypes = { "png" , "jpg" };
        
        FilenameFilter[] filter = new FilenameFilter[ imageTypes.length ];
        
        int i = 0;
        
        for ( final String type : imageTypes )
        {
            
            this.echo ( "Build accept method for type : " + type );
            
            filter [ i ] = new FilenameFilter ( )
            {
                
                public boolean accept ( File dir , String name )
                {
                    return name.endsWith ( "." + type );
                }
            };
            
            i += 1;
        }
        
        this.echo ( "Returning the FilenameFilter[]" );
        
        return filter;
    }
    
    public Vector < File > getVectorPictures ( File directory , FilenameFilter[] filter , int recurse )
    {
        
        this.echo ( "Build a Collection of Files (list)" );
        
        Vector < File > files = new Vector < File > ( );
        
        this.echo ( "Getting the file entries relative to directory : " + directory.getName ( ) );
        
        File[] entries = directory.listFiles ( );
        
        if ( entries != null )
        {
            this.echo ( "directory is not empty!" );
            
            for ( File entry : entries )
            {
                
                this.echo ( "Scanning file : " + entry.getName ( ) );
                
                this.echo ( "Put file on filter procedure" );
                
                for ( FilenameFilter filefilter : filter )
                {
                    this.echo ( "Trying validate [" + entry.getName ( ) + "] with extension [" + filefilter.toString ( )
                            + "]" );
                    
                    if ( filter == null || filefilter.accept ( directory , entry.getName ( ) ) )
                    {
                        
                        this.echo ( "File is matched with the extension!" );
                        
                        files.add ( entry );
                        
                        this.echo ( "File is stored" );
                        
                        // Log.v ( "ImageViewFlipper" , "Added: " +
                        // entry.getName ( ) );
                    }
                }
                
                this.echo ( "~ mysterious validation about recursive level ~" );
                
                if ( ( recurse <= - 1 ) || ( recurse > 0 && entry.isDirectory ( ) ) )
                {
                    recurse-- ;
                    files.addAll ( this.getVectorPictures ( entry , filter , recurse ) );
                    recurse++ ;
                }
            }
        }
        return files;
    }
    
    public static final int IMAGE_QUALITY_EXCELLENT            = 100;
    
    public static final int IMAGE_QUALITY_GOOD                 = 80;
    
    public static final int IMAGE_QUALITY_OK_THATS_FINE        = 50;
    
    public static final int IMAGE_QUALITY_GIVING_A_FLYING_FUCK = 20;
    
    public void saveBitmapAsJPEG ( Bitmap image , String fileName , int quality )
    {
        
        ByteArrayOutputStream bytes = new ByteArrayOutputStream ( );
        image.compress ( Bitmap.CompressFormat.JPEG , quality , bytes );
        
        // you can create a new file name "test.jpg" in sdcard folder.
        File f = new File ( Environment.getExternalStorageDirectory ( )
                                + File.separator + fileName );
        try
        {
            f.createNewFile ( );
            // write the bytes in file
            FileOutputStream fo = new FileOutputStream ( f );
            fo.write ( bytes.toByteArray ( ) );
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            this.echo ( "Cant save goddammit bitmap as jpeg .-." );
        }
    }
    
    private void echo ( String string )
    {
        Log.d ( "SdcardManager" , string );
        
    }
    
    public void createFolder ( String folderName )
    {
        // TODO Auto-generated method stub
        File dir = new File ( folderName );
        
        if ( dir.mkdir ( ) )
        {
            this.echo ( "Folder [" + folderName + "] ja foi criado! D:" );
        }
        else
        {
            this.echo ( "Folder [" + folderName + "] esta sendo criado! :D" );
        }
    }
    
}
