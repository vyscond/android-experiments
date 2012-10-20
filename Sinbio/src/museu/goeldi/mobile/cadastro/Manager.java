package museu.goeldi.mobile.cadastro;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import museu.goeldi.mobile.cadastro.database.Monalisa;
import museu.goeldi.mobile.cadastro.java_metadata_object.base.RegistroAmostra;
import museu.goeldi.mobile.util.Storage;
import android.os.Environment;
import android.util.Log;

public class Manager
{
    
    private Monalisa monalisa;
    
    Storage          SDCARD;
    
    public void saveOnSQLite(RegistroAmostra r)
    {
        monalisa.persistJMO(r);
    }
    
    public void saveOnSDCARD(String folder_name, RegistroAmostra r)
    {
        Log.d("SaveXML", "Tentando salvar na pasta [" + folder_name + "]");
        
        String file_name, content;
        
        Log.d("SaveXML", "Gereando o Obj de RegistroAmostra");
        
        if (r == null)
        {
            Log.d("SaveXML", "Obj RegistroAmostra não foi gerado com sucesso");
        } else
        {
            Log.d("SaveXML", "Obj RegistroAmostra foi gerado com sucesso");
        }
        
        file_name = "amostra_" + r.getId_da_amostra_dado_pelo_coletor() + "_.registro";
        
        Log.d("SaveXML", "Salvar obj RegistroAmostra como : " + file_name + "_.registro");
        
        Log.d("SaveXML", "Gerando XML");
        
        content = r.getLangageDeBalisageExtensible();
        
        Log.d("SaveXML", "String XML gerada :D");
        
        this.SDCARD = new Storage(folder_name);
        
        this.SDCARD.saveAsTextFile(file_name, content);
        
        Log.d("SaveXML", "Salvo!");
        
        this.SDCARD = null;
    }
    
    /*
     * --------------------------------------------------------------------------
     * -----
     */
    
    private String result;
    private String saveFileName = "eventlist_savefile";
    
    public String writeToFile(String contentToSave)
    {
        FileOutputStream fos = null;
        ObjectOutputStream out = null;
        
        try
        {
            File root = Environment.getExternalStorageDirectory();
            
            if (root.canWrite())
            {
                fos = new FileOutputStream(saveFileName);
                out = new ObjectOutputStream(fos);
                out.writeObject(contentToSave);
                
                result = "File written";
                
                out.close();
            } else
            {
                result = "file cant write";
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            result = "file not written";
        }
        
        return result;
    }
    
    public boolean readFromFile()
    {
        return false;
    }
    
}
