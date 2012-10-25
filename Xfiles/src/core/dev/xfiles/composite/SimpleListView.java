package core.dev.xfiles.composite;

import java.util.ArrayList;

import android.content.Context;
import android.widget.ListView;
import core.dev.xfiles.composite.adapter.GenericAdapter;
import core.dev.xfiles.composite.base.Simple;
import core.dev.xfiles.composite.pojo.base.GenericItemList;

public class SimpleListView extends Simple {
	
	private ListView listView;
	
	public SimpleListView( Context context )
	{
		
		super(context);
		
		this.listView = new ListView(this.context);
		
		this.adapter = new GenericAdapter(this.context);
		
		this.listView.setAdapter(this.adapter);
		
	}
	
	public SimpleListView( Context context , ListView listView )
    {
        
        super(context);
        
        this.listView = listView;
        
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
