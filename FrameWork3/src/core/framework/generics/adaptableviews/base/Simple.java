package core.framework.generics.adaptableviews.base;

import core.framework.generics.adaptableviews.adapters.GenericAdapter;
import android.content.Context;

public class Simple {
	
	protected Context context;
	
	protected GenericAdapter adapter;

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public Simple(Context context) {
		super();
		this.context = context;
	}

	public GenericAdapter getAdapter() {
		// TODO Auto-generated method stub
		return this.adapter;
	}
	
	
}
