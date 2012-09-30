package core.structs;

import java.util.ArrayList;

import core.base.CommonItemListBehavior;
import core.base.GenericAdapter;

import android.content.Context;
import android.widget.ListView;

public class CoreList {
	
	private ListView listView;
	
	private GenericAdapter adapter;
	
	public CoreList(Context context , ListView listView)
	{
		this.listView = listView;
		
		this.adapter = new GenericAdapter(context, (new ArrayList<CommonItemListBehavior>()) );
		
		this.listView.setAdapter(adapter);
	}
	
	public CoreList(Context context , ListView listView , ArrayList<CommonItemListBehavior> itemsOnList)
	{
		this.listView = listView;
		
		this.adapter = new GenericAdapter(context, itemsOnList );
		
		this.listView.setAdapter(adapter);
	}
	
	/* --------------------------------------------------------------- */
	
	

}
