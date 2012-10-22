package core.dev.rawphotoalbum;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.LinearLayout;
import android.widget.ScrollView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ScrollView ll = (ScrollView) findViewById ( R.id.scrollView1 );
        
        
        
        SimplePhotoAlbumView spav = new SimplePhotoAlbumView ( this , this , R.layout.photo , "CHERRY_IMG" , 3);
        
        ll.addView ( spav.getGridView ( ) );
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
