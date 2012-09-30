package museu.goeldi.mobile;

import museu.goeldi.mobile.cadastro.CadastroAmostra;
import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnHoverListener;
import android.widget.TextView;


public class MainActivity extends Activity {
	
	private TextView textView_acessar_cadastro_amostra;

	private Intent screen_cadastro_amostra;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        
    	setContentView(R.layout.activity_main);
        
        this.textView_acessar_cadastro_amostra = (TextView) findViewById(R.id.textView_acessar_cadastro_amostra);
        
        this.textView_acessar_cadastro_amostra.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				
				
				acessar_cadastro_amostra_onClick(v);
				
			}
		});
        
       
        
    }
    
    private void acessar_cadastro_amostra_onClick(View v)
    {
    	this.screen_cadastro_amostra = new Intent(this , CadastroAmostra.class);
    	
    	this.startActivityAndGetBackToMe(this.screen_cadastro_amostra);
    	
    }

    private void startActivityAndGetBackToMe(Intent activity)
    {
    	startActivityForResult(this.screen_cadastro_amostra, Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
    	
    	finishActivity(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
