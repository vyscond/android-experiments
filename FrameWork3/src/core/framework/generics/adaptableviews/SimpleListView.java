package core.framework.generics.adaptableviews;

import java.util.ArrayList;

import core.framework.generics.adaptableviews.adapters.GenericAdapter;
import core.framework.generics.adaptableviews.adapters.GenericItemList;
import core.framework.generics.adaptableviews.base.Simple;
import android.content.Context;
import android.widget.ListView;

public class SimpleListView extends Simple {
	
	private ListView listView;
	
	public SimpleListView( Context context )
	{
		
		super(context);
		
		this.listView = new ListView(this.context);
		
		this.adapter = new GenericAdapter(this.context);
		
		this.listView.setAdapter(this.adapter);
		
	}
	
	public SimpleListView( Context context , ArrayList<GenericItemList> items )
	{
		super(context);
		
		this.listView = new ListView(this.context);
		
		this.adapter = new GenericAdapter(this.context , items);
		
		this.listView.setAdapter(this.adapter);
		
	}
	
	public void addItem(GenericItemList item)
	{
		this.adapter.addItem(item);
		
		this.adapter.notifyDataSetChanged();
	}
	
	public ListView getListView()
	
	{
		return this.listView;
	}

	
}
