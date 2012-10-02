package core.dev.gridview;

import android.view.View;
import android.widget.Button;

public class ButtonOption extends GenericItemList {

	int layout;
	
	String text;
	
	
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	@Override
	public View initializeWidgets(View v) {
		// TODO Auto-generated method stub
		
		((Button) v.findViewById(R.id.button_my_button)).setText(this.text+ " - Hello - "+this.id);
		
		return v;
	}

	@Override
	public int getLayout() {
		// TODO Auto-generated method stub
		return this.layout;
	}

	@Override
	public void setLayout(int layout_id) {
		// TODO Auto-generated method stub
		
		this.layout = layout_id;
	}

	private long id;
	
	@Override
	public long getId() {
		// TODO Auto-generated method stub
		return this.id;
	}

	@Override
	public void setId(long id) {
		// TODO Auto-generated method stub
		this.id = id;
	}

}
