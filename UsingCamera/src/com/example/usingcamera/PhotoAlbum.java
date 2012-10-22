package com.example.usingcamera;

import android.content.Context;
import android.widget.GridView;


public class PhotoAlbum
{
    private FolderDataBase database;
    
    private GridView gridView;
    
    private GenericAdapter adapter;
    
    private Context context;
    
    public PhotoAlbum( Context context , GridView gridView ,  int columns , String folder_with_pictures )
    {
        this.context = context;
        
        this.gridView = new GridView ( this.context );
        
        this.gridView.setColumnWidth ( columns );
        
        this.adapter = new GenericAdapter ( this.context );
        
        this.gridView.setAdapter ( this.adapter );
        
        /* ---------------------------------------------------- */
        
        this.database = new FolderDataBase ( folder_with_pictures , "photo_index" );
        
    }
    
    
    
    
    
}
