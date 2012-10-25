package museu.goeldi.mobile.cadastro.photomanagement.the_album.gridview;

import java.util.ArrayList;

import museu.goeldi.mobile.cadastro.photomanagement.the_album.item.GenericItemList;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GenericAdapter extends BaseAdapter {

	ArrayList<GenericItemList> items;

	Context context;

	/* --- mah methods --- */
	
	public ArrayList<GenericItemList> getItems()
	{
		return this.items;
	}
	
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
	

	/*-------------------------------------------------------------------------
	 * 
	 *                           CONSTRUCTORS
	 * 
	 *------------------------------------------------------------------------*/
	
	public GenericAdapter(Context context, ArrayList<GenericItemList> items) {
		super();
		
		this.context = context;
		
		/* --- REDRAW ROUTINE --- */
		
		Log.d("GenericAdapter", "Building Adapter with context");		
		
		//ArrayList<GenericItemList> sResultsArr = (ArrayList<GenericItemList>) ((Activity) this.context).getLastNonConfigurationInstance();

		Log.d("GenericAdapter", "Verifying stance of \"last array of items\"");
		
		if (items == null) {
			
			Log.d("GenericAdapter", "Making new stance for items");
			
			items = new ArrayList<GenericItemList>(); // or some other
															// initialization
		}
		
		Log.d("GenericAdapter", "Valid stance :D");
		
		this.items = items;

	}
	
	public GenericAdapter(Context context) {
		
		super();
		
		Log.d("GenericAdapter", "Building Adapter with context");
		
		this.context = context;
		
		/* --- REDRAW ROUTINE --- */
		
		
		ArrayList<GenericItemList> items = (ArrayList<GenericItemList>) ( (Activity) this.context).getLastNonConfigurationInstance();

		Log.d("GenericAdapter", "Verifying last stance of items");
		
		if (items == null) {
			
			Log.d("GenericAdapter", "Making new stance for items");
			
			items = new ArrayList<GenericItemList>(); // or some other
															// initialization
		}
		
		Log.d("GenericAdapter", "Valid stance :D");
		
		this.items = items;
		
		//this.items = new ArrayList<GenericItemList>();

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
		
		View itemView = convertView;
		
		if (itemView == null) {
			
			itemView = (LayoutInflater.from(context)).inflate(layout, null);

			itemView.setId(position);
			
			
		}

		itemView = this.items.get(position).initializeWidgets(itemView);

		return itemView;

	}

}
