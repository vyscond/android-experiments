package com.example.usingcamera;

import android.view.View;

public abstract class GenericItemList {
	
	public abstract View initializeWidgets(View v);

	public abstract int getLayout();
	
	public abstract void setLayout(int layout_id);
	
	public abstract long getId();
	
	public abstract void setId(long id);

}
