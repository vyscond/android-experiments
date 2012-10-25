
package core.dev.xfiles.manager;

import java.util.Vector;

import android.content.Context;
import android.util.Log;
import android.widget.ListView;
import core.dev.xfiles.R;
import core.dev.xfiles.composite.SimpleListView;
import core.dev.xfiles.composite.pojo.XFile;
import core.dev.xfiles.composite.pojo.XFolder;
import core.dev.xfiles.manager.engine.Xfiles;

public class XFileManager
{
    
    private Xfiles           fileManager;
    
    private SimpleListView   simpleListView;
    
    private static final int XFOLDER_LAYOUT = R.layout.xfolder;
    
    private static final int XFILE_LAYOUT   = R.layout.xfile;
    
    public XFileManager ( Context context , ListView listView )
    {
        this.simpleListView = new SimpleListView ( context , listView );
        
        this.fileManager = new Xfiles ( );
    }
    
    public String getActualPathString ( )
    {
        return this.fileManager.getActualPathString ( );
    }
    
    public static final int DIRECTORY_FOLDERS_ONLY      = 1;
    
    public static final int DIRECTORY_FILES_ONLY        = 2;
    
    public static final int DIRECTORY_FOLDERS_AND_FILES = 3;
    
    public void generateDirectory ( int diretoryPresentationType )
    {
        
        Vector < XFolder > folders = this.toXFolderArray ( this.fileManager.toStringArrayFolders ( ) );
        
        Vector < XFile > files  = this.toXFileArray ( this.fileManager.toStringArrayFiles ( ) );
        
        switch ( diretoryPresentationType )
        {
            case DIRECTORY_FOLDERS_ONLY :
            {
                this.refreshFolders ( folders );
                
            }
                
                break;
                
            case DIRECTORY_FILES_ONLY :
            {
                
                this.refreshFiles ( files );
                
            }
                break;
                
            case DIRECTORY_FOLDERS_AND_FILES :
            {
                
                
                this.refreshFolders ( folders );
                
                this.refreshFiles ( files );
                
                
            }
                
                break;
            
            default :

                break;
        }
        
    }
    
    private void refreshFiles( Vector < XFile > files )
    {
        for ( XFile xFile : files )
        {
            this.simpleListView.addItem ( xFile );
        }
    }
    
    private void refreshFolders( Vector < XFolder > folders )
    {
        for ( XFolder xFolder : folders )
        {
            this.simpleListView.addItem ( xFolder );
        }
    }
    
    public Vector < XFile >  toXFileArray ( String[] file_name )
    {
        Vector < XFile > files = new Vector < XFile > ( );
        
        
        
        for ( String name : file_name )
        {
            
            Log.d ( "XFile" , "Building XFile Obj : " + name );
            
            files.add ( new XFile ( XFileManager.XFILE_LAYOUT , name ) );
            
        }
        
        return files;
    }
    
    public Vector< XFolder > toXFolderArray ( String[] folders_name )
    {
        Vector < XFolder > folders = new Vector < XFolder > ( );
        
        
        
        for ( String name : folders_name )
        {
            Log.d ( "XFile" , "Building XFolder Obj : " + name );
            
            folders.add( new XFolder ( XFileManager.XFOLDER_LAYOUT , name ) );
            
        }
        
        return folders;
    }
}
