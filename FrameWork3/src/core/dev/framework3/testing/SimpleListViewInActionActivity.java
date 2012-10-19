package core.dev.framework3.testing;

import java.util.ArrayList;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import core.dev.framework3.R;
import core.framework.generics.adaptableviews.SimpleListView;
import core.framework.generics.adaptableviews.adapters.GenericItemList;

public class SimpleListViewInActionActivity extends Activity {

	private SimpleListView simpleListView;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_simple_list_view_in_action);

		this.BuildUI();

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

	public void BuildUI() {
		LinearLayout ll = (LinearLayout) findViewById(R.id.LinearLayoutSimpleListInAction);

		// ArrayList<GenericItemList> items = (ArrayList<GenericItemList>)
		// this.getLastNonConfigurationInstance();

		// simpleListView = new SimpleListView(this ,
		// this.getLastInstanceOfItemList() );

		simpleListView = new SimpleListView(this);

		ll.addView(this.simpleListView.getListView());
	}

	@Override
	public Object onRetainNonConfigurationInstance() {
		// return this.m_adapter.getItems();
		return this.simpleListView.getAdapter().getItems();
	}

	public ArrayList<GenericItemList> getLastInstanceOfItemList() {
		return (ArrayList<GenericItemList>) this
				.getLastNonConfigurationInstance();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_simple_list_view_in_action,
				menu);
		return true;
	}
}
