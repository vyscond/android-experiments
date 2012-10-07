
package core.dev.beesort;

import java.lang.reflect.Method;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.util.Log;

public class WingedCap
{
    
    private WifiManager wifiManager;
    
    private Context     context;
    
    public WingedCap(Context context)
    {
    
        this.context = context;
    }
    
    private void toggleWifiStatus() {
    
        if (this.wifiManager.isWifiEnabled())
        {
            this.wifiManager.setWifiEnabled(false);
        }
        
        else
        {
            this.wifiManager.setWifiEnabled(true);
        }
        
    }
    
    public void takeOff() {
    
        this.wifiManager = (WifiManager) this.context.getSystemService(Context.WIFI_SERVICE);
        
        if (this.wifiManager.isWifiEnabled())
        {
            Log.d(LogLabels.wingedCap, "wifi is on");
        }
        
        else
        {
            Log.d(LogLabels.wingedCap, "wifi is off");
            
            this.resquestTurnOnWifiPopUp();
            
        }
        
        
        
        //this.startTetheringService();
    }
    
    
    
    private void resquestTurnOnWifiPopUp() {
    
        DialogInterface.OnClickListener dialogClickListener = new DialogInterface.OnClickListener()
            {
                
                public void onClick(DialogInterface dialog, int which) {
                
                    switch (which) {
                    
                        case DialogInterface.BUTTON_POSITIVE:
                        {
                            // Yes button clicked
                            wifiManager.setWifiEnabled(true);
                            Log.d(LogLabels.wingedCap, "wifi turned up");
                        }
                        break;
                        
                        case DialogInterface.BUTTON_NEGATIVE:
                        {
                            // No button clicked
                            wifiManager.setWifiEnabled(false);
                            Log.d(LogLabels.wingedCap, "wifi turned down");
                        }
                        break;
                    }
                }
            };
        
        AlertDialog.Builder builder = new AlertDialog.Builder(this.context);
        builder.setMessage("Need to wake up wifi! pls? *_*")
                .setPositiveButton("Yes", dialogClickListener)
                .setNegativeButton("No", dialogClickListener).show();
        
    }
    
    public void startTetheringService() {
    
        Method[] wifiMethods = this.wifiManager.getClass().getMethods();
        
        Log.d(LogLabels.wingedCap, "finding the goddammit method ò_ó");
        
        for (Method m : wifiMethods) // hacking private methods .-.
        {
            Log.d( LogLabels.wingedCap , m.getName() );
            
            if (m.getName().equals("setWifiApEnabled"))
            {
                
                Log.d(LogLabels.wingedCap, "Found!");
                /*
                try
                {
                    
                    Log.d(LogLabels.wingedCap, "Invoking");
                    
                    m.invoke(this.wifiManager, null, true);
                    
                }
                catch (Exception e)
                {
                    // TODO: handle exception
                }
                */
                
            }
            
        }
    }
    
}
