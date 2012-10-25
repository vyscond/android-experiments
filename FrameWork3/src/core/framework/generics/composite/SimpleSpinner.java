package core.framework.generics.composite;

import core.framework.generics.composite.adapter.GenericAdapter;
import core.framework.generics.composite.base.Simple;
import core.framework.generics.composite.pojo.GenericItemList;
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
		this.adapter.notifyDataSetChanged ( );
	}
	
	public Spinner getSpinner()
	{
		return this.spinner;
	}

	
	
}
