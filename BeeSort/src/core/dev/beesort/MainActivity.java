
package core.dev.beesort;

import android.app.Activity;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends Activity
{
    
    BlackTooth bt;
    
    WingedCap  wingedCap;
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
    
    	
    	
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        EditText et = (EditText) findViewById(R.id.editText1);
        
        // this.wingedCap = new WingedCap(this);
        
        // this.wingedCap.takeOff();
        
        this.riseSettingWindow_Wireless();
        
    }
    
    public void riseSettingWindow_Wireless() {
    
        ToggleButton ThreeG, Wifi;
        
        ThreeG = (ToggleButton) findViewById(R.id.toggleButton1);
        Wifi = (ToggleButton) findViewById(R.id.toggleButton2);
        
        TextView ThreeGView , WifiView;
        
        ThreeGView = (TextView) findViewById(R.id.textView1);
        
        WifiView = (TextView) findViewById(R.id.textView2);
        
        
        ThreeGView.setText("3G is connected");
        
        WifiView.setText("Wifi is connected");     
        
        ConnectivityManager manager = (ConnectivityManager) getSystemService(MainActivity.CONNECTIVITY_SERVICE);
        
        /*
         * 3G confirm
         */
        Boolean is3g = manager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE)
                .isConnectedOrConnecting();
        
        /*
         * wifi confirm
         */
        Boolean isWifi = manager.getNetworkInfo(ConnectivityManager.TYPE_WIFI)
                .isConnectedOrConnecting();
        
        Wifi.setClickable(false);
        ThreeG.setClickable(false);
        
        if (is3g)
        {
            Log.d(LogLabels.wingedCap, "3G is working");
            
            ThreeG.setChecked(true);
        }
        else
            if (isWifi)
            {
                Log.d(LogLabels.wingedCap, "WIFI is working");
                Wifi.setChecked(true);
            }
            /*
            else
            {
                
                Wifi.setClickable(false);
                Log.d(LogLabels.wingedCap, "both network interface are down");
                // Activity transfer to wifi settings
                startActivity(new Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS));
                // android.net.wifi.WifiManager.ACTION_PICK_WIFI_NETWORK
                
            }
            */
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
