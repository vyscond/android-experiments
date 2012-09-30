package museu.goeldi.mobile.cadastro;

import museu.goeldi.mobile.R;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.ViewStub;

public class CadastroAmostra extends Activity {

	private ViewStub viewStub_general_data;
	private ViewStub viewStub_gps_localizacao;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_amostra);
      
        this.viewStub_general_data = (ViewStub) findViewById(R.id.viewStub_activity_cadastro_amostra);
        this.viewStub_general_data.setLayoutResource(R.layout.cadastro_amostra_general_data);
        this.viewStub_general_data.inflate();
        
        this.viewStub_gps_localizacao = (ViewStub) findViewById(R.id.viewStub_activity_localizacao_da_amostra);
        this.viewStub_gps_localizacao.setLayoutResource(R.layout.cadastro_amostra_localizacao_da_amostra);
        this.viewStub_gps_localizacao.inflate();
        
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_cadastro_amostra, menu);
        return true;
    }
}