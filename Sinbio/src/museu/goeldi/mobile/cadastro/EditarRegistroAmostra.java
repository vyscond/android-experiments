package museu.goeldi.mobile.cadastro;

import museu.goeldi.mobile.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class EditarRegistroAmostra extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
    	
        super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_editar_registro_amostra);
        
        /* testando o recebimento de texto --- agora devemos chamar a classe Util
        
        String text = this.assetToString("testfile.cml");
        
        TextView tv = new TextView(this);
        
        tv.setText(text);
        
        LinearLayout ll = (LinearLayout) findViewById(R.id.LinearLayout1);
        
        ll.addView(tv); 
        
        */
        
    }
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
        getMenuInflater().inflate(R.menu.activity_vizualizar_amostras, menu);
        
        return true;
        
    }
}
