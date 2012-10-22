
package museu.goeldi.mobile.cadastro;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import museu.goeldi.mobile.cadastro.database.fileindex.Hellena;
import museu.goeldi.mobile.cadastro.database.sqlite.Monalisa;
import museu.goeldi.mobile.cadastro.java_metadata_object.base.RegistroAmostra;
import museu.goeldi.mobile.util.Storage;
import android.os.Environment;
import android.util.Log;

public class Manager
{
    
    private Monalisa monalisa;
    
    private Hellena  fakeDataBase;
    
    Storage          SDCARD;
    
    String           folder_name;
    
    public Manager ( String folde_name )
    {
        this.folder_name = folde_name;
        
        this.fakeDataBase = new Hellena ( folder_name , "xml_reference" );
        
    }
    
    public void saveOnSQLite ( RegistroAmostra r )
    {
        monalisa.persistJMO ( r );
    }
    
    private Hellena hellena;
    
    public void saveNewRegisterOnSDCARD ( RegistroAmostra r )
    {
        Log.d ( "SaveXML" , "Tentando salvar na pasta [" + folder_name + "]" );
        
        String file_name , content;
        
        Log.d ( "SaveXML" , "Gereando o Obj de RegistroAmostra" );
        
        if ( r == null )
        {
            Log.d ( "SaveXML" , "Obj RegistroAmostra n�o foi gerado com sucesso" );
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
        
        this.SDCARD = new Storage ( folder_name );
        
        this.SDCARD.saveAsTextFile ( file_name , content );
        
        Log.d ( "SaveXML" , "Salvo!" );
        
        // this.SDCARD.appendTextToTheFile ( "index_xml_files" , file_name );
        this.fakeDataBase.add_reference ( file_name );
        
        Log.d ( "SaveXML" , "XML sincronizado no arquivo de referencia" );
        
        this.SDCARD = null;
    }
    
    /*
     * --------------------------------------------------------------------------
     * -----
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
    
}
