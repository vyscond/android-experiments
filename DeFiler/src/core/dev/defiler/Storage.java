package core.dev.defiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.util.Log;

public class Storage
{
    private String folder_name;
    
    
    private String base_path = "/sdcard/";
    
    public void saveAsTextFile( String file_name , String content )
    {
        String absolute_path = base_path+folder_name;
        
        try {
        
            // verifying if the folder was created or not :D
            
            File dir = new File(absolute_path);
            
            if( dir.mkdir() )
            {
                Log.d("Storage", "Folder ["+absolute_path+"] ja foi criado! D:");
            }
            else
            {
                Log.d("Storage", "Folder ["+absolute_path+"] esta sendo criado! :D");
            }
            
            
            // persistindo o arquivo!
            
            File raw_text_file = new File(absolute_path+"/"+file_name);
            
            
            
            if( raw_text_file.createNewFile() )
            {
                Log.d("Storage", "Arquivo ["+file_name+"] ja foi criado! D:");
            }
            else
            {
                Log.d("Storage", "Arquivo ["+file_name+"] esta sendo criado! :D");
            }
            
            FileOutputStream fOut = new FileOutputStream(raw_text_file);
            
            // adicionando conteudo
            
            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
            
            myOutWriter.append( content );
            
            myOutWriter.close();
            
            fOut.close();
            
            // finnish :D
            
            
        } catch (Exception e) {

        }
    }
    
    public Storage( String folder_name )
    {
        this.folder_name = folder_name;
    }
}
