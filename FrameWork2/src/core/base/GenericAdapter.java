package core.base;

import java.util.ArrayList;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

public class GenericAdapter extends BaseAdapter {

	ArrayList<CommonItemListBehavior> itemsOnList;

	Context context;


	public GenericAdapter(Context context, ArrayList<CommonItemListBehavior> itemsOnList) {
		super();
		this.itemsOnList = itemsOnList;
		this.context = context;

	}

	public int getCount() {
		// TODO Auto-generated method stub
		return this.itemsOnList.size();
	}

	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return 0;
	}

	public View getView(int position, View convertView, ViewGroup parent) {

		int layout = this.itemsOnList.get(position).getLayout();
		
		View rowView = convertView;

		if (rowView == null) {
			
			rowView = (LayoutInflater.from(context)).inflate(layout, null);

			rowView.setId(position);
		}

		rowView = this.itemsOnList.get(position).initializeWidgets(rowView);

		return rowView;

	}

}
