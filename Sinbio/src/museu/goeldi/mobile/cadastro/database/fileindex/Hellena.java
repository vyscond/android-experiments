
package museu.goeldi.mobile.cadastro.database.fileindex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import museu.goeldi.mobile.util.Storage;
import android.util.Log;

/* --- controlling persisted files by list --- */

public class Hellena
{
    
    private Storage SDCARD;
    
    private String  fake_database_name;
    
    private String  folder_name;
    
    public Hellena ( String folde_name_to_save_file , String file_name_to_save_references )
    {
        
        this.folder_name = folde_name_to_save_file;
        
        this.fake_database_name = file_name_to_save_references;
        
        this.SDCARD = new Storage ( this.folder_name );
        
        this.load_fake_database ( );
        
    }
    
    public void add_reference ( String file_name )
    {
        this.FakeDataBase.addNewFileNameToBeReferenced ( file_name );
        
        this.SDCARD.saveAsTextFile ( fake_database_name , this.FakeDataBase.toString ( ) );
    }
    
    private void load_fake_database ( )
    {
        Log.d ( "SaveXML" ,
                "Executing : loadFileXMLReference" );
        
        String fake_database_already_saved_content = "";
        
        try
        {
            
            File myFile = new File ( "/sdcard/" + folder_name + "/" + fake_database_name );
            
            FileInputStream fIn = new FileInputStream ( myFile );
            
            BufferedReader file_reader = new BufferedReader ( new InputStreamReader ( fIn ) );
            
            String single_file_line = "";
            
            String file_content_buffer = "";
            
            while ( ( single_file_line = file_reader.readLine ( ) ) != null )
            {
                
                file_content_buffer += single_file_line + "\n";
            }
            
            fake_database_already_saved_content = file_content_buffer;
            
            file_reader.close ( );
            Log.d ( "SaveXML" ,
                    "Done reading SD 'SINBIO/" + fake_database_name + "'" );
            
        }
        catch ( Exception e )
        {
            Log.d ( "SaveXML" ,
                    "Something went wrong on the reading index refence xml file!!!'" );
        }
        
        this.FakeDataBase = new FileXMLReference ( fake_database_already_saved_content );
        
    }
    
    private FileXMLReference FakeDataBase;
    
    private class FileXMLReference
    {
        
        LinkedList < String > rows = new LinkedList < String > ( );
        
        public FileXMLReference ( String fileindex_string_content )

        {
            for ( String referenced_file_name : fileindex_string_content.split ( "\n" ) )
            {
                rows.add ( referenced_file_name );
            }
        }
        
        public void addNewFileNameToBeReferenced ( String file_name )
        {
            this.rows.add ( file_name );
        }
        
        public String toString ( )
        {
            String tmp = "";
            
            for ( String s : this.rows )
            {
                tmp += s + "\n";
            }
            
            return tmp;
        }
        
    }
    
}
