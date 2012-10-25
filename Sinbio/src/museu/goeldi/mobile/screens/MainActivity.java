package museu.goeldi.mobile.screens;

import museu.goeldi.mobile.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;


public class MainActivity extends Activity {
	
		
	private TextView textView_criar_registro_amostra;
	private TextView textView_editar_registro_amostra;

	private Intent screen_criar_registro_amostra;
	private Intent screen_editar_registro_amostra;
	
	public static final String __FLAG__ = "SINBIO";
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	
    	super.onCreate(savedInstanceState);
        
    	setContentView(R.layout.activity_main);
        
    	
    	
        this.textView_criar_registro_amostra = (TextView) findViewById(R.id.textView_acessar_criar_registro_amostra);
        
        this.textView_criar_registro_amostra.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				acessar_criar_registro_amostra_screen_onClick(v);
				
			}
		});
        
        /*----------------------------------------------------------------------------------------------------- */
        
        this.textView_editar_registro_amostra = (TextView) findViewById(R.id.TextView_acessar_editar_registro_amostra);
        
        this.textView_editar_registro_amostra.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				acessar_editar_registro_amostra_screen_onClick(v);
				
			}
		});
        
       
        
    }
    
    private void acessar_criar_registro_amostra_screen_onClick(View v)
    {
    	this.screen_criar_registro_amostra = new Intent(this , CriarRegistroAmostra.class); //---working
    	//this.screen_criar_registro_amostra = new Intent(this , SwipeCriarRegistroAmostra.class); //---working
    	//this.screen_criar_registro_amostra = new Intent(this , SimpleSwipeCriarRegistro.class); //---working
    	//this.screen_criar_registro_amostra = new Intent(this , NewSimpleSwipeCriarRegistroAmostra.class); //---working
    	this.startActivityAndGetBackToMe(this.screen_criar_registro_amostra);
    	
    }
    
    private void acessar_editar_registro_amostra_screen_onClick(View v)
    {
    	this.screen_editar_registro_amostra = new Intent(this , EditarRegistroAmostra.class);
    	
    	this.startActivityAndGetBackToMe(this.screen_editar_registro_amostra);
    	
    }

    private void startActivityAndGetBackToMe(Intent activity)
    {
    	startActivityForResult(activity, Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
    	
    	finishActivity(Intent.FLAG_ACTIVITY_PREVIOUS_IS_TOP);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
