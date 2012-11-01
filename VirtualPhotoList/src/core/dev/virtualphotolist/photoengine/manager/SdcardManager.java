
package core.dev.virtualphotolist.photoengine.manager;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Vector;

import android.os.Environment;
import android.util.Log;

public class SdcardManager
{
    
    private File working_path = Environment.getExternalStorageDirectory ( );
    
    public String getWorkingDirectoryAbsolutePath ( )
    {
        return this.working_path.getAbsolutePath ( );
    }
    
    public String getWorkingDirectoryPath ( )
    {
        return this.working_path.getName ( );
    }
    
    public void changeDirectory ( String folderName )
    {
        this.working_path = new File ( this.working_path.getAbsolutePath ( ) + "/" + folderName );
        
        if ( this.working_path == null )
        {
            this.echo ( "Cant reach new Path" );
        }
        
        else
        {
            this.echo ( "New Path reached" );
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
    
    private void echo ( String string )
    {
        Log.d ( "SdcardManager" , string );
        
    }
    
}
