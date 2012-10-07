package com.example.openingurlonwebbrowser;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	Button reverter;
    
    Button open_browser;
    
    TextView possible_url;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*
        
        ClipboardManager clipboard = (ClipboardManager)  getSystemService(Context.CLIPBOARD_SERVICE);
        
        String possible_url = (String) (clipboard.getPrimaryClip().getItemAt(0)).getText();
        
        possible_url = (new StringBuffer(possible_url)).reverse().toString();
        
        TextView tv = (TextView) findViewById(R.id.editText1);
        
        tv.setText(possible_url);
        */
        
        this.reverter = (Button) findViewById(R.id.button_revert_it);
        
        this.open_browser = (Button) findViewById(R.id.button_browser_caller);
        
        this.possible_url = (TextView) findViewById(R.id.editText_possible_url);
        
        this.reverter.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				String p_url = MainActivity.this.possible_url.getText().toString();
				
				if(! p_url.equals(""))
				{
					
					MainActivity.this.possible_url.setText( (new StringBuffer(p_url)).reverse().toString() );
				}
				else
				{
					Toast t = new Toast( MainActivity.this  );
					
					t.makeText(MainActivity.this, "Chupa negao" , Toast.LENGTH_SHORT);
					t.show();
					
					reverter.setEnabled(false);
					try {
						reverter.wait(t.getDuration());
						reverter.setEnabled(true);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				
				
				
			}
		});
        
        this.open_browser.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				
				Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse( ("http://"+(possible_url.getText().toString())) ));
				startActivity(browserIntent);
				
			}
		});
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
