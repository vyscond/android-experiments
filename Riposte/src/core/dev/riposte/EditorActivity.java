
package core.dev.riposte;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.widget.EditText;
import android.widget.Toast;

public class EditorActivity extends Activity
{
    
    @ Override
    public void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_editor );

        // Get intent, action and MIME type
        Intent intent = getIntent();
        String action = intent.getAction();
        String type = intent.getType();
        
        // Figure out what to do based on the intent type
        if ( Intent.ACTION_SEND.equals ( action ) && type != null )
        {
            if ( "text/plain".equals ( type ) )
            {
                handleSendText ( intent ); // Handle text being sent
            }
            else if ( type.startsWith ( "image/" ) )
            {
                Toast.makeText ( this , "Mr. Wong says : \"Its Wrong!\"" , Toast.LENGTH_SHORT ).show ( );
            }
        }
        
//        Intent result = new Intent("com.example.RESULT_ACTION", Uri.parse("content://result_uri"));
//        setResult(Activity.RESULT_OK, result);
//        finish();
    }
    
    void handleSendText ( Intent intent )
    {
        String sharedText = intent.getStringExtra ( Intent.EXTRA_TEXT );
        if ( sharedText != null )
        {
            // Update UI to reflect text being shared
            
            ((EditText) findViewById ( R.id.editText1 )).setText ( sharedText );
        }
    }
    
    @ Override
    public boolean onCreateOptionsMenu ( Menu menu )
    {
        getMenuInflater ( ).inflate ( R.menu.activity_editor , menu );
        return true;
    }
}
