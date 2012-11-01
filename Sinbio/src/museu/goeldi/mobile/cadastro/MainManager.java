
package museu.goeldi.mobile.cadastro;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import museu.goeldi.mobile.cadastro.database.fileindex.FileIndexBasedDB;
import museu.goeldi.mobile.cadastro.database.sqlite.SqliteManager;
import museu.goeldi.mobile.cadastro.java_metadata_object.base.RegistroAmostra;
import museu.goeldi.mobile.cadastro.photoalbum.virtual.manager.VirtualPhotoAlbumManager;
import museu.goeldi.mobile.screens.MainActivity;
import museu.goeldi.mobile.util.Storage;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.widget.Toast;

public class MainManager
{
    
    private String           class_in = "MainManager : ";
    
    private SqliteManager    monalisa;
    
    private FileIndexBasedDB fakeDataBase;
    
    private Storage                  SDCARD;
    
    private String                   folderPath;
    
    private Context          context;
    
    private VirtualPhotoAlbumManager virtualPhotoAlbumManager;
    
    public MainManager ( Context context , String folderPath )
    {
        this.echo ( "Building MainManager Stance :D" );
        
        this.context = context;
        
        this.folderPath = folderPath;
        
        this.echo ( "Creating FileIndexBasedDB Stance" );
        
        // this.fakeDataBase = new FileIndexBasedDB ( folderPath , "xml_reference" );
        
    }
    
    
    
    
    public VirtualPhotoAlbumManager getVirtualPhotoAlbumManager ( )
    {
        return virtualPhotoAlbumManager;
    }



    
    public void setVirtualPhotoAlbumManager ( VirtualPhotoAlbumManager virtualPhotoAlbumManager )
    {
        this.virtualPhotoAlbumManager = virtualPhotoAlbumManager;
    }



    public void saveOnSQLite ( RegistroAmostra r )
    {
        monalisa.persistJMO ( r );
    }
    
    private FileIndexBasedDB hellena;
    
    public void saveNewRegisterOnSDCARD ( RegistroAmostra r )
    {
        Log.d ( "SaveXML" , "Tentando salvar na pasta [" + folderPath + "]" );
        
        String file_name , content;
        
        Log.d ( "SaveXML" , "Gereando o Obj de RegistroAmostra" );
        
        if ( r == null )
        {
            Log.d ( "SaveXML" , "Obj RegistroAmostra não foi gerado com sucesso" );
        }
        else
        {
            Log.d ( "SaveXML" , "Obj RegistroAmostra foi gerado com sucesso" );
        }
        
        file_name = "amostra_" + r.getId_da_amostra_dado_pelo_coletor ( ) + "_.registro";
        
        Log.d ( "SaveXML" , "Salvar obj RegistroAmostra como : " + file_name + "_.registro" );
        
        Log.d ( "SaveXML" , "Gerando XML" );
        
        content = r.getLangageDeBalisageExtensible ( );
        
        Log.d ( "SaveXML" , "String XML gerada :D" );
        
        this.SDCARD = new Storage ( folderPath );
        
        this.SDCARD.saveAsTextFile ( file_name , content );
        
        Log.d ( "SaveXML" , "Salvo!" );
        
        // this.SDCARD.appendTextToTheFile ( "index_xml_files" , file_name );
        this.fakeDataBase.add_reference ( file_name );
        
        Log.d ( "SaveXML" , "XML sincronizado no arquivo de referencia" );
        
        this.SDCARD = null;
    }
    
    /*
     * --------------------------------------------------------------------------
     */

    private String result;
    
    private String saveFileName = "eventlist_savefile";
    
    public String writeToFile ( String contentToSave )
    {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        
        try
        {
            File root = Environment.getExternalStorageDirectory ( );
            
            if ( root.canWrite ( ) )
            {
                fos = new FileOutputStream ( saveFileName );
                out = new ObjectOutputStream ( fos );
                out.writeObject ( contentToSave );
                
                result = "File written";
                
                out.close ( );
            }
            else
            {
                result = "file cant write";
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace ( );
            result = "file not written";
        }
        
        return result;
    }
    
    public boolean readFromFile ( )
    {
        return false;
    }
    
    /*public void addPhotoToVirtualAlbum ( Bitmap photo )
    {
        // TODO Auto-generated method stub
        try
        {
            this.virtualPhotoAlbumManager.addPhoto ( photo );
        }
        catch ( Exception e )
        {
            // TODO: handle exception
            Toast.makeText ( this.context , "No virtualAlbum valid stance :D" , Toast.LENGTH_SHORT ).show ( );
            
            this.echo ( "No virtualAlbum valid stance :D" );
        }
    }*/
    
    private void echo ( String msg )
    {
        Log.d ( MainActivity.__FLAG__ , class_in + msg );
    }

    public void addPhotoToVirtualAlbum ( Bitmap photo )
    {
        // TODO Auto-generated method stub
        
        this.virtualPhotoAlbumManager.addPhoto ( photo );
        
    }
    
}
