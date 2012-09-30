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
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
    	
        getMenuInflater().inflate(R.menu.activity_vizualizar_amostras, menu);
        
        return true;
        
    }
}
