
package core.dev.rawphotoalbum;

import java.io.File;
import java.io.FilenameFilter;
import java.util.Collection;
import java.util.Vector;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Environment;
import android.util.Log;
import android.view.Display;
import android.widget.GridView;

public class SimplePhotoAlbumView extends Simple
{
    
    private GridView gridView;
    
    private int      columns_qtt;
    
    public GridView getGridView ( )
    {
        return gridView;
    }
    
    public void setGridView ( GridView gridView )
    {
        this.gridView = gridView;
    }
    
    private int      layout;
    
    private Activity activity;
    
    public SimplePhotoAlbumView ( Context context , Activity activity , int layout , String folder_name , int column_qtt )
    {
        super ( context );
        // TODO Auto-generated constructor stub
        
        this.layout = layout;
        
        this.activity = activity;
        
        this.gridView = new GridView ( this.context );
        
        
        
        
        this.adapter = new GenericAdapter ( this.context );
        
        this.gridView.setAdapter ( this.adapter );
        
        this.gridView.setNumColumns ( GridView.AUTO_FIT );
        
        this.echo ( "Columns -->> " + this.gridView.getColumnWidth ( ) );
        
        //this.gridView.setStretchMode(GridView.STRETCH_COLUMN_WIDTH);
        
        this.columns_qtt = column_qtt;
        
        this.fetchPhotosAt ( folder_name );
    }
    
    private class Metric
    {
        
        public int for_width;
        
        public int for_height;
    }
    
    private Metric adjustMetrics ( int factor )// API 8+
    {
        Metric m = new Metric ( );
        
        Display display = this.activity.getWindowManager ( ).getDefaultDisplay ( );
        int width = display.getWidth ( ); // deprecated
        int height = display.getHeight ( ); // deprecated
        
        width = width / factor;
        
        height = height / factor;
        
        m.for_width = width;
        
        m.for_height = height;
        
        return m;
    }
    
    /*
     * private Metric adjustMetrics(int factor)// Olny for API 13+ { Metric m =
     * new Metric ( );
     * 
     * Display display = this.activity.getWindowManager().getDefaultDisplay();
     * Point size = new Point(); display.getSize(size); int width = size.x; int
     * height = size.y;
     * 
     * m.for_width = width;
     * 
     * m.for_height = height;
     * 
     * return m;
     * 
     * }
     */

    private String base_path = Environment.getExternalStorageDirectory ( ).getPath ( );
    
    private void fetchPhotosAt ( String folder_name )
    {
        
        String absolute_path;
        
        if ( folder_name.charAt ( folder_name.length ( ) - 1 ) == '/' )
        {
            absolute_path = this.base_path + "/" + folder_name;
        }
        else
        {
            absolute_path = this.base_path + "/" + folder_name + "/";
        }
        
        this.echo ( "Trying to load images from : " + absolute_path );
        
        File[] allMatchingFilesByFilter = this.listFilesAsArray ( new File ( absolute_path ) , this.imageFilters ( ) ,
                - 1 );
        
        this.fillAdapter ( allMatchingFilesByFilter );
        
    }
    
    private void fillAdapter ( File[] files )
    {
        this.echo ( "Filling Adapater with the Photos" );
        
        Photo p;
        
        this.echo ( "Columns quantity set : " + GridView.AUTO_FIT );
        
        Metric m = this.adjustMetrics ( GridView.AUTO_FIT );
        
        for ( File file : files )
        {
            
            String imagePath = file.getAbsolutePath ( );
            
            String imageName = file.getName ( );
            
            this.echo ( "Working on file : " + imageName + " [" + imagePath + "]" );
            
            p = new Photo ( this.layout , imagePath , imageName , m.for_width , m.for_height );
            
            this.adapter.addItem ( p );
        }
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
    
    private void echo ( String msg )
    {
        Log.d ( "SimplePhotoAlbum" , msg );
    }
    
}
