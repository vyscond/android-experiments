package core.framework.generics.adaptableviews;

import core.framework.generics.adaptableviews.adapters.GenericAdapter;
import core.framework.generics.adaptableviews.adapters.GenericItemList;
import core.framework.generics.adaptableviews.base.Simple;
import android.content.Context;
import android.widget.Spinner;

public class SimpleSpinner extends Simple {

	public SimpleSpinner(Context context) {
		
		super(context);
		
		this.spinner = new Spinner(this.getContext());
		
		this.adapter = new GenericAdapter(this.getContext());
		
		this.spinner.setAdapter(this.adapter);
		
	}

	private Spinner spinner;
	
	public void addItem( GenericItemList item )
	{
		this.adapter.addItem(item);
	}
	
	public Spinner getSpinner()
	{
		return this.spinner;
	}

	
	
}
