package core.dev.defiler;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        Button b = (Button) findViewById(R.id.button1);
        
        b.setOnClickListener(new OnClickListener()
        {
            
            public void onClick(View v)
            {
                // TODO Auto-generated method stub
                
                
                String file_name = "test123.txt";
                
                
                Storage SDCARD = new Storage("SINBIO");
                
                SDCARD.saveAsTextFile(file_name, "opa! lol man!!!");
                
                Toast.makeText( getBaseContext(), "Storage"+"Done writing [" + file_name +"]",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void writeFile()
    {
     // write on SD card file data in the text box
        try {
            
            File dir = new File("/sdcard/SINBIO");
            
            dir.mkdir();
            
            File myFile = new File("/sdcard/SINBIO/mysdfile.txt");
            myFile.createNewFile();
            FileOutputStream fOut = new FileOutputStream(myFile);
            OutputStreamWriter myOutWriter = 
                                    new OutputStreamWriter(fOut);
            EditText txtData = (EditText) findViewById(R.id.editText1);
            myOutWriter.append(txtData.getText());
            myOutWriter.close();
            fOut.close();
            Toast.makeText(getBaseContext(),
                    "Done writing SD 'mysdfile.txt'",
                    Toast.LENGTH_SHORT).show();
        } catch (Exception e) {
            Toast.makeText(getBaseContext(), e.getMessage(),
                    Toast.LENGTH_SHORT).show();
        }
    }
    
    public boolean readFromFile(){
     return false;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
