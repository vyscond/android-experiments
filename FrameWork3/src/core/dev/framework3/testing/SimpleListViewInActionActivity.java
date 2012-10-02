package core.dev.framework3.testing;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import core.dev.framework3.R;
import core.framework.generics.SimpleListView;

public class SimpleListViewInActionActivity extends Activity {

	private SimpleListView simpleListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_list_view_in_action);

		LinearLayout ll = (LinearLayout) findViewById(R.id.LinearLayoutSimpleListInAction);

		simpleListView = new SimpleListView(this);

		//

		ll.addView(simpleListView.getListView());

		// simpleListView.addItem(p1);

		/* --- add button --- */

		Button addPeople = (Button) findViewById(R.id.button_add_people);

		addPeople.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

				PeopleItem p = new PeopleItem();

				p.setFirstName(((EditText) findViewById(R.id.editText_first_name))
						.getText().toString());
				p.setSecondName(((EditText) findViewById(R.id.editText_second_name))
						.getText().toString());
				
				p.setLayout(R.layout.item_model_people);

				simpleListView.addItem(p);

			}
		});

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_simple_list_view_in_action,
				menu);
		return true;
	}
}
