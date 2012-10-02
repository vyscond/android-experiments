package core.framework.generics;

import core.framework.generics.adapter.GenericAdapter;
import core.framework.generics.adapter.GenericItemList;
import android.content.Context;
import android.widget.ListView;

public class SimpleListView {
	
	private Context context;
	
	private ListView listView;
	
	private GenericAdapter adapter;
	
	public SimpleListView( Context context )
	{
		this.context = context;
		
		this.listView = new ListView(this.context);
		
		this.adapter = new GenericAdapter(this.context);
		
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
