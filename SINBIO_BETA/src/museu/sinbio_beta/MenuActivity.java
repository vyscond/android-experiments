
package museu.sinbio_beta;

import museu.sinbio_beta.creating.CreateRegisterActivity;
import museu.sinbio_beta.maintaining.MaintainRegisterActivity;
import museu.sinbio_beta.sending.SendRegisterActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MenuActivity extends Activity
{
    
    public static final String __FLAG__       = "SINBIO_BETA";
    
    public static final String BASE_FOLDER    = "SINBIO";
    
    public static int          DIPLAY_WIDTH   = 0;
    
    public static int          DISPLAY_HEIGHT = 0;
    
    private TextView           textViewCallCreateRegisterScreen , textViewCallMaintainRegisterScreen ,
            textViewSendRegisterScreen;
    
    @ Override
    public void onCreate ( Bundle savedInstanceState )
    {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_menu );
        
        Display display = this.getWindowManager ( ).getDefaultDisplay ( );
        
        DIPLAY_WIDTH = display.getWidth ( );
        DISPLAY_HEIGHT = display.getHeight ( );
        
        /*-------------------------------------------------------------
         * 
         *                      BUTTON CALLS
         * 
         *-------------------------------------------------------------*/

        textViewCallCreateRegisterScreen = (TextView) findViewById ( R.id.textView_invoke_createregister_activity );
        
        Log.d ( "FODASE" , "MAN" );
        
        textViewCallCreateRegisterScreen.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                startActivity ( new Intent ( MenuActivity.this , CreateRegisterActivity.class ) );
            }
        } );
        
        textViewCallMaintainRegisterScreen = (TextView) findViewById ( R.id.textView_invoke_maintainregister_activity);
        
        textViewCallMaintainRegisterScreen.setOnClickListener ( new OnClickListener ( )
        {
              
              public void onClick ( View v )
              {
                  // TODO Auto-generated method stub
                  startActivity ( new Intent ( MenuActivity.this , MaintainRegisterActivity.class ) );
              
              }
              
          } );
        
        /*
         * textViewSendRegisterScreen = (TextView) findViewById ( R.id.textView_invoke_createregister_activity );
         * 
         * textViewSendRegisterScreen.setOnClickListener ( new OnClickListener ( )
         * {
         * 
         * public void onClick ( View v )
         * {
         * // TODO Auto-generated method stub
         * invokeScreen_onClick ( v , SCREEN_SEND );
         * }
         * } );
         */

    }
    
    @ Override
    public boolean onCreateOptionsMenu ( Menu menu )
    {
        getMenuInflater ( ).inflate ( R.menu.activity_menu , menu );
        return true;
    }
    
    /*------------------------------------------------------------
     * 
     *                ACESSANDO AS TELAS BASES
     * 
     *-----------------------------------------------------------*/

    private void startActivityAndGetBackToMe ( Intent activity )
    {
        startActivityForResult ( activity , Intent.FLAG_ACTIVITY_REORDER_TO_FRONT );
        
        finishActivity ( Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP );
        
    }
}
