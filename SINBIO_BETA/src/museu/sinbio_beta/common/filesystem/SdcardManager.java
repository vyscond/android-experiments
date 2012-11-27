
package museu.sinbio_beta.common.filesystem;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Vector;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import museu.sinbio_beta.MenuActivity;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;

public class SdcardManager
{
    
    private File   working_path = Environment.getExternalStorageDirectory ( );
    
    private String back_path    = working_path.getAbsolutePath ( );
    
    public Vector toVectorFolders ( String absolutePath )
    {
        Vector < String > folders = new Vector < String > ( );
        
        File f = new File ( this.getBasePath ( ) + "/" + absolutePath );
        
        for ( File file : f.listFiles ( ) )
        {
            if ( file.isDirectory ( ) )
            {
                folders.add ( file.getName ( ) );
            }
            
        }
        
        return folders;
    }
    
    public ArrayList < String > toArrayListFolders ( String absolutePath )
    {
        ArrayList < String > folders = new ArrayList < String > ( );
        
        this.echo ( "Scanning >> " + this.getBasePath ( ) + "/" + absolutePath );
        
        File f = new File ( this.getBasePath ( ) + "/" + absolutePath );
        
        for ( File file : f.listFiles ( ) )
        {
            if ( file.isDirectory ( ) )
            {
                folders.add ( file.getName ( ) );
            }
            
        }
        
        return folders;
    }
    
    public Vector toVectorFiles ( String absolutePath )
    {
        Vector < String > files = new Vector < String > ( );
        
        File f = new File ( this.getBasePath ( ) + "/" + absolutePath );
        
        for ( File file : f.listFiles ( ) )
        {
            if ( ! file.isDirectory ( ) )
            {
                files.add ( file.getName ( ) );
            }
            
        }
        
        return files;
    }
    
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
    
    public String getBasePath ( )
    {
        return Environment.getExternalStorageDirectory ( ).getAbsolutePath ( );
    }
    
    public void changeDirectory ( String folderPath )
    {
        
        if ( this.isFolderReachable ( folderPath ) )
        {
            
            this.back_path = this.working_path.getAbsolutePath ( );
            
            this.working_path = new File ( this.working_path.getAbsolutePath ( ) + "/" + folderPath );
            
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
    
    public Vector < File > getPictures ( String absolutePath )
    {
        
        return this.getVectorPictures ( new File ( absolutePath ) , this.getImageFilters ( ) , - 1 );
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
    
    public void saveBitmapAsJPEG ( Bitmap image , String fileName , int quality , String absolutePath )
    {
        
        ByteArrayOutputStream bytes = new ByteArrayOutputStream ( );
        image.compress ( Bitmap.CompressFormat.JPEG , quality , bytes );
        
        // you can create a new file name "test.jpg" in sdcard folder.
        File f = new File ( absolutePath
                                + File.separator + fileName + ".jpg" );
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
        Log.d ( MenuActivity.__FLAG__ , "SdcardManager : " + string );
        
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
    
    public File getFileAsFile ( String filename , String absolutePath )
    {
        // Get the text file
        return new File ( Environment.getExternalStorageDirectory ( ).getAbsolutePath ( ) + absolutePath , filename );
        
    }
    
    public String getFileAsString ( String filename , String extension , String absolutePath )
    {
        // Get the text file
        
        this.echo ( "Man! Lets try open a file at [" + absolutePath + "]" );
        
        File file = new File ( absolutePath , filename + "." + extension );
        
        if ( file == null )
        {
            this.echo ( "Caralho velho! .-. " );
        }
        
        // Read text from file
        StringBuilder text = new StringBuilder ( );
        
        try
        {
            BufferedReader br = new BufferedReader ( new FileReader ( file ) );
            String line;
            
            while ( ( line = br.readLine ( ) ) != null )
            {
                
                this.echo ( "BUffering line from file : " + line );
                
                text.append ( line );
                text.append ( '\n' );
            }
        }
        catch ( IOException e )
        {
            // You'll need to add proper error handling here
        }
        
        return text.toString ( );
    }
    
    public void saveAs ( String fileName , String content , String extension , String absolutePath )
    {
        // TODO Auto-generated method stub
        try
        {
            
            // verifying if the folder was created or not :D
            
            File dir = new File ( absolutePath );
            
            if ( dir.mkdir ( ) )
            {
                Log.d ( "Storage" , "Folder [" + absolutePath + "] ja foi criado! D:" );
            }
            else
            {
                Log.d ( "Storage" , "Folder [" + absolutePath + "] esta sendo criado! :D" );
            }
            
            // persistindo o arquivo!
            
            File raw_text_file = new File ( absolutePath + "/" + fileName + "." + extension );
            
            if ( raw_text_file.createNewFile ( ) )
            {
                Log.d ( "Storage" , "Arquivo [" + fileName + "] ja foi criado! D:" );
            }
            else
            {
                Log.d ( "Storage" , "Arquivo [" + fileName + "] esta sendo criado! :D" );
            }
            
            FileOutputStream fOut = new FileOutputStream ( raw_text_file );
            
            // adicionando conteudo
            
            OutputStreamWriter myOutWriter = new OutputStreamWriter ( fOut );
            
            myOutWriter.write ( content );
            
            myOutWriter.close ( );
            
            fOut.close ( );
            
            // finnish :D
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            
        }
    }
    
    public void removeFile ( String path )
    {
        // TODO Auto-generated method stub
        
        try
        {
            File f = new File ( path );
            
            f.delete ( );
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            
            this.echo ( "Ups! :X cant delete .-." );
        }
        
    }
    
    /*--------------------------------------------------------------------
     * 
     *                             ZIP/UNZIP
     *                             
     *--------------------------------------------------------------------*/

    public void zipDirectory ( String folderPath , String zipPath ) throws IOException
    {
        
        this.echo ( "ZIP PROCESS STARTING" );
        
        File directory = new File ( folderPath );
        File zip = new File ( zipPath );    
        ZipOutputStream zos = new ZipOutputStream ( new FileOutputStream ( zip ) );
        zip ( directory , directory , zos );
        zos.close ( );
        
        this.echo ( "ZIP PROCESS DONE" );
    }
    
    private static final void zip ( File directory , File base ,
            ZipOutputStream zos ) throws IOException
    {
        File[] files = directory.listFiles ( );
        byte[] buffer = new byte[ 8192 ];
        int read = 0;
        for ( int i = 0 , n = files.length ; i < n ; i++ )
        {
            if ( files [ i ].isDirectory ( ) )
            {
                zip ( files [ i ] , base , zos );
            }
            else
            {
                FileInputStream in = new FileInputStream ( files [ i ] );
                ZipEntry entry = new ZipEntry ( files [ i ].getPath ( ).substring (
                        base.getPath ( ).length ( ) + 1 ) );
                zos.putNextEntry ( entry );
                while ( - 1 != ( read = in.read ( buffer ) ) )
                {
                    zos.write ( buffer , 0 , read );
                }
                in.close ( );
            }
        }
    }
    
}
