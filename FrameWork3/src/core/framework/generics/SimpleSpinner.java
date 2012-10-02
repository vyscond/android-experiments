package core.framework.generics;

import core.framework.generics.adapter.GenericAdapter;
import core.framework.generics.adapter.GenericItemList;
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
	
	private GenericAdapter adapter;
	
	public void addItem( GenericItemList item )
	{
		this.adapter.addItem(item);
	}
	
	public Spinner getSpinner()
	{
		return this.spinner;
	}
	
}
