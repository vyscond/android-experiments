package core.dev.rawphotoalbum;

import core.dev.rawphotoalbum.manager.PhotoAlbumManager;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.GridView;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends Activity {

    public static final String __FLAG__ = "GeneralDebug";
    
    public final String class_in = "MainActivity : ";
    
    public GridView myGridView;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //ScrollView ll = (ScrollView) findViewById ( R.id.scrollView1 );
        
        this.myGridView = (GridView) findViewById ( R.id.gridView1 );
        
        LinearLayout ll = (LinearLayout) findViewById ( R.id.LinearLayout1 );
        
        //HorizontalScrollView ll = (HorizontalScrollView) findViewById ( R.id.horizontalScrollView1 );

        
        Log.d ( __FLAG__ , class_in + "Creating new stance of PhotoAlbumManager" );
        
        PhotoAlbumManager photoAlbum = new PhotoAlbumManager ( this , this.myGridView , 3 , R.layout.photo , "CHERRY_IMG" );
        
        Log.d ( __FLAG__ , class_in +  "PhotoAlbumManager stance created with success" );
        
        Log.d ( __FLAG__ ,  class_in + "Inserting view into Base Layout" );
        
        //ll.addView ( photoAlbum.getGridView ( ) );
        
        Log.d ( __FLAG__ ,  class_in + "Insertion procceded with success" );
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
