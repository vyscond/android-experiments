
package core.dev.xfiles.manager.engine;

import java.io.File;
import java.util.Vector;

import android.os.Environment;

public class Xfiles
{
    
    private String BASE_PATH = Environment.getExternalStorageDirectory ( ).getPath ( ) + "/";
    
    private File         SDCARD    = Environment.getExternalStorageDirectory ( );
    
    // --- Checando se o SDCARD está montado :D
    public boolean sdcardReadyToUse ( )
    {
        if ( ! this.SDCARD.equals ( Environment.MEDIA_MOUNTED ) )
        {
            
            return false;
            
        }
        
        return true;
    }
    
    public String getActualPathString()
    {
        return this.SDCARD.getAbsolutePath ( );
    }
    
    public String toStringFolders ( )
    {
        String tmp = "";
        
        File[] files = this.SDCARD.listFiles ( );
        
        for ( File file : files )
        {
            if ( file.isDirectory ( ) )
            {
                tmp += file.getName ( ) + "\n";
            }
            
        }
        
        return tmp;
    }
    
    public String toStringFiles ( )
    {
        String tmp = "";
        
        File[] files = this.SDCARD.listFiles ( );
        
        for ( File file : files )
        {
            if ( !file.isDirectory ( ) )
            {
                tmp += file.getName ( ) + "\n";
            }
            
        }
        
        return tmp;
    }
    
    public Vector toVectorFolders ( )
    {
        Vector < String > folders = new Vector < String > ( );
        
        for ( File file : this.SDCARD.listFiles ( ) )
        {
            if ( file.isDirectory ( ) )
            {
                folders.add ( file.getName ( ) );
            }
            
        }
        
        return folders;
    }
    
    public Vector toVectorFiles ( )
    {
        Vector < String > files = new Vector < String > ( );
        
        for ( File file : this.SDCARD.listFiles ( ) )
        {
            if ( ! file.isDirectory ( ) )
            {
                files.add ( file.getName ( ) );
            }
            
        }
        
        return files;
    }
    
    public String[] toStringArrayFolders ( )
    {
        return this.toStringFolders ( ).split ( "\n" );
    }
    
    public String[] toStringArrayFiles ( )
    {        
        return this.toStringFiles ( ).split ( "\n" );
    }
}
