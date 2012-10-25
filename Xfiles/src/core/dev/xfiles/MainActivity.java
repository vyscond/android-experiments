package core.dev.xfiles;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;
import android.widget.TextView;
import core.dev.xfiles.manager.XFileManager;

public class MainActivity extends Activity {

    private XFileManager m;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        ListView listView = (ListView) findViewById ( R.id.listView_directory );
        
        m = new XFileManager ( this , listView );
        
        m.generateDirectory ( XFileManager.DIRECTORY_FOLDERS_AND_FILES );
        
        TextView t = (TextView) findViewById ( R.id.textView1 );
        
        t.setText ( m.getActualPathString ( ) );
        
        
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
