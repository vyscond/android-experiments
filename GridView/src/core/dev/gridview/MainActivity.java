package core.dev.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_main);

		GridView gv = (GridView) findViewById(R.id.gridView1);
		
		GenericAdapter adapter = new GenericAdapter(this);
		
		gv.setAdapter(adapter);
		
		gv.setColumnWidth(3);
		
		/* --- The buttons
		 * 
		 * 1 - apesar de ainda estarmos usando o generic adapter as coisas continuam simples.
		 * dê olho no metodo getView do GenericAdapter
		 *  
		 * 3 - agora os botões abaixo fazem sentido :D
		 *  
		 */
		
		ButtonOption b1 = new ButtonOption();
		
		b1.setText("Llol");
		
		b1.setLayout(R.layout.item_option_button);
		
		ButtonOption b2 = new ButtonOption();
		
		b2.setText("Llol");
		
		b2.setLayout(R.layout.item_option_button);
		
		ButtonOption b3 = new ButtonOption();
		
		b3.setText("Llol");
		
		b3.setLayout(R.layout.item_option_button);
		
		ButtonOption b4 = new ButtonOption();
		
		b4.setText("Llol");
		
		b4.setLayout(R.layout.item_option_button);

		adapter.addItem(b1);
		adapter.addItem(b2);
		adapter.addItem(b3);
		adapter.addItem(b4);
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
