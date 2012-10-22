
package com.example.usingcamera;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;

import android.os.Environment;
import android.util.Log;

/* --- controlling persisted files by list --- */

public class FolderDataBase
{
    
    private Storage SDCARD;
    
    private String  database_name;
    
    private String  folder_name;
    
    public FolderDataBase ( String folde_name_to_save_file , String file_name_to_save_references )
    {
        
        this.folder_name = folde_name_to_save_file;
        
        this.database_name = file_name_to_save_references;
        
        this.SDCARD = new Storage ( this.folder_name );
        
        this.load_database ( );
        
    }
    
    public void add_reference ( String file_name )
    {
        this.fileindex_db.addNewFileNameToBeReferenced ( file_name );
        
        this.SDCARD.saveAsTextFile ( database_name , this.fileindex_db.toString ( ) );
    }
    
    public LinkedList < String > getFilenameList()
    {
        return this.fileindex_db.getFilenameList ( );
    }
    
    private final String base_path = Environment.getExternalStorageDirectory().getPath();
    
    private void load_database ( )
    {
        Log.d ( "FolderDB" ,
                "Executing : loadFileXMLReference" );
        
        String fake_database_already_saved_content = "";
        
        try
        {
            
            File myFile = new File ( this.base_path + folder_name + "/" + database_name );
            
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
                    "Done reading SD 'SINBIO/" + database_name + "'" );
            
        }
        catch ( Exception e )
        {
            Log.d ( "FolderDB" ,
                    "Something went wrong on the reading index refence xml file!!!'" );
        }
        
        this.fileindex_db = new FileIndex ( fake_database_already_saved_content );
        
    }
    
    private FileIndex fileindex_db;
    
    private class FileIndex
    {
        
        LinkedList < String > rows = new LinkedList < String > ( );
        
        public FileIndex ( String fileindex_string_content )

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
        
        public LinkedList < String > getFilenameList()
        {
            return this.rows;
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
