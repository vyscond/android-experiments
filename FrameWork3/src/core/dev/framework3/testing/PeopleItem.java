package core.dev.framework3.testing;

import android.view.View;
import android.widget.TextView;
import core.dev.framework3.R;
import core.framework.generics.adaptableviews.adapters.GenericItemList;

public class PeopleItem extends GenericItemList {

	String firstName, secondName;

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	private long id;

	private int layout;

	@Override
	public View initializeWidgets(View v) {
		// TODO Auto-generated method stub

		((TextView) v.findViewById(R.id.textView_item_model_people_firstname))
				.setText("First name : " + this.firstName + "\nSecond name : "
						+ this.secondName);
		((TextView) v.findViewById(R.id.textView_item_model_people_lastname))
				.setText("My ID [" + id + "]\n" + "My Layout [" + layout + "]");

		return v;
	}

	@Override
	public int getLayout() {
		// TODO Auto-generated method stub
		return this.layout;
	}

	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

	@Override
	public void setLayout(int layout_id) {
		// TODO Auto-generated method stub

		this.layout = layout_id;

	}

}
