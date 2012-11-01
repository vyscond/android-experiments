
package museu.goeldi.mobile.cadastro.database.fileindex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

import museu.goeldi.mobile.screens.MainActivity;
import museu.goeldi.mobile.util.Storage;
import android.util.Log;

/* --- controlling persisted files by list --- */

public class FileIndexBasedDB
{
    
    private String class_in = "FileIndexBasedDB : ";
    
    private Storage SDCARD;
    
    private String  fake_database_name;
    
    private String  folder_name;
    
    public FileIndexBasedDB ( String folde_name_to_save_file , String file_name_to_save_references )
    {
        
        this.echo( "Building new Stance FileIndexBasedDB" );
        
        this.folder_name = folde_name_to_save_file;
        
        this.fake_database_name = file_name_to_save_references;
        
        this.echo ( "Creating new Stance Storage" );
        
        this.SDCARD = new Storage ( this.folder_name );
        
        this.load_fake_database ( );
        
    }
    
    private void echo ( String string )
    {
        // TODO Auto-generated method stub
        Log.d ( MainActivity.__FLAG__ , class_in + string ) ;
        
    }

    public void add_reference ( String file_name )
    {
        this.FakeDataBase.addNewFileNameToBeReferenced ( file_name );
        
        this.SDCARD.saveAsTextFile ( fake_database_name , this.FakeDataBase.toString ( ) );
    }
    
  
    
    private void load_fake_database ( )
    {
        
        
        
        
        String fake_database_already_saved_content = "";
        
        this.echo ( "Loading FakeDataBase on /sdcard/" + folder_name + "/" + fake_database_name );
        
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
           this.echo  ( 
                    "Done reading SD 'SINBIO/" + fake_database_name + "'" );
            
        }
        catch ( Exception e )
        {
            this.echo  ( 
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
