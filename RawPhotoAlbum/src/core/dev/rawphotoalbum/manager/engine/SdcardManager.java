
package core.dev.rawphotoalbum.manager.engine;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;
import java.util.Vector;

import android.os.Environment;
import android.util.Log;

public class SdcardManager
{
    
    private String base_path = Environment.getExternalStorageDirectory ( ).getPath ( );
    
    public String getAbsolutePathFor ( String folder_path )
    {
        String absolute_path;
        
        if ( folder_path.charAt ( folder_path.length ( ) - 1 ) == '/' )
        {
            absolute_path = this.base_path + "/" + folder_path;
        }
        else
        {
            absolute_path = this.base_path + "/" + folder_path + "/";
        }
        
        return absolute_path;
    }
    
    public File[] fetchPhotosInFileFormatAt ( String folder_path )
    {
        
        String absolute_path = this.getAbsolutePathFor ( folder_path );
        
        this.echo ( "Trying to load images from : " + absolute_path );
        
        File[] allMatchingFilesByFilter = this.listFilesAsArray ( new File ( absolute_path ) , this.imageFilters ( ) ,
                - 1 );
        
        return allMatchingFilesByFilter;
    }
    
    public String[] fetchPhotosAbsolutePathsAt ( String folder_path )
    {
        
        String absolute_path;
        
        if ( folder_path.charAt ( folder_path.length ( ) - 1 ) == '/' )
        {
            absolute_path = this.base_path + "/" + folder_path;
        }
        else
        {
            absolute_path = this.base_path + "/" + folder_path + "/";
        }
        
        this.echo ( "Trying to load images from : " + absolute_path );
        
        File[] allMatchingFilesByFilter = this.listFilesAsArray ( new File ( absolute_path ) , this.imageFilters ( ) ,
                - 1 );
        
        String[] photo_path = new String[ allMatchingFilesByFilter.length ];
        
        for ( int i = 0 ; i < allMatchingFilesByFilter.length ; i++ )
        {
            photo_path [ i ] = allMatchingFilesByFilter [ i ].getAbsolutePath ( );
        }
        
        return photo_path;
    }
    
    private FilenameFilter[] imageFilters ( )
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
    
    private File[] listFilesAsArray ( File directory , FilenameFilter[] filter , int recurse )
    {
        this.echo ( "Generating a Collection of files with filter procedures" );
        
        Collection < File > files = listFiles ( directory , filter , recurse );
        
        this.echo ( "Collection was generated with success" );
        
        File[] arr = new File[ files.size ( ) ];
        
        this.echo ( "Returning Collection as a File[]" );
        
        return files.toArray ( arr );
    }
    
    public Collection < File > listFiles ( File directory , FilenameFilter[] filter , int recurse )
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
                    files.addAll ( listFiles ( entry , filter , recurse ) );
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
