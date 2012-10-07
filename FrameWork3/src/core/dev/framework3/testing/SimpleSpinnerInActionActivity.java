package core.dev.framework3.testing;

import core.dev.framework3.R;
import core.dev.framework3.R.layout;
import core.dev.framework3.R.menu;
import core.framework.generics.SimpleSpinner;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

public class SimpleSpinnerInActionActivity extends Activity {

	private SimpleSpinner simpleSpinner;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_spinner_in_action);
        
        LinearLayout ll = (LinearLayout) findViewById(R.id.LinearLayout_spinner);
        
        this.simpleSpinner = new SimpleSpinner(this);
        
        ll.addView(this.simpleSpinner.getSpinner());
        
        /* --- add button --- */

		Button addPeople = (Button) findViewById(R.id.button_spinner_add_people);

		addPeople.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				PeopleItem p = new PeopleItem();

				p.setFirstName(((EditText) findViewById(R.id.editText_spinner_first_name))
						.getText().toString());
				p.setSecondName(((EditText) findViewById(R.id.editText_spinner_second_name))
						.getText().toString());
				
				p.setLayout(R.layout.item_model_people);

				simpleSpinner.addItem(p);

			}
		});
    }

    @Override
	public Object onRetainNonConfigurationInstance() {
		// return this.m_adapter.getItems();
		return this.simpleSpinner.getAdapter().getItems();
	}
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_simple_spinner_in_action, menu);
        return true;
    }
}
