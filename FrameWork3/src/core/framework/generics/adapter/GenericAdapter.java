package core.framework.generics.adapter;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GenericAdapter extends BaseAdapter {

	ArrayList<GenericItemList> items;

	Context context;

	/* --- mah methods --- */
	
	public void addItem(GenericItemList item)
	{
		this.items.add(item);
	}
	
	public void removeItemByIndex( int position )
	{
		this.items.remove(position);
	}
	
	public void removeItemById( long id )
	{
		for( GenericItemList item : this.items )
		{
			if( item.getId() == id )
			{
				this.items.remove( this.items.indexOf(item) );
				
				break;
			}
		}
	}
	

	public GenericAdapter(Context context, ArrayList<GenericItemList> items) {
		super();
		this.items = items;
		this.context = context;

	}
	
	public GenericAdapter(Context context) {
		super();
		this.context = context;
		
		this.items = new ArrayList<GenericItemList>();

	}

	public int getCount() {
		// TODO Auto-generated method stub
		return this.items.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return this.items.get(position);
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return this.items.get(position).getId();
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		
		int layout = this.items.get(position).getLayout();
		
		this.items.get(position).setId(position);
		
		View rowView = convertView;
		
		if (rowView == null) {
			
			rowView = (LayoutInflater.from(context)).inflate(layout, null);

			rowView.setId(position);
			
			
		}

		rowView = this.items.get(position).initializeWidgets(rowView);

		return rowView;

	}

}
