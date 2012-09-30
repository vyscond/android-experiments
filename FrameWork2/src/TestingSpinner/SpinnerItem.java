package TestingSpinner;

import museu.goeldi.sinbiomobile.R;
import android.view.View;
import android.widget.TextView;
import core.base.CommonItemListBehavior;

public class SpinnerItem extends CommonItemListBehavior {
	
	@Override
	public View initializeWidgets(View v) {
		// TODO Auto-generated method stub
		
		TextView tv = (TextView) v.findViewById(R.id.textView1);
		
		tv.setText(this.text);
		
		/*
		tv.setOnClickListener(new View.OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				CharSequence text = "You've selected !";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(v.getContext(), text, duration);
				toast.show();
			}
		});
		*/
		return v;
	}

	@Override
	public int getLayout() {
		// TODO Auto-generated method stub
		return R.layout.simple_view_to_be_loaded;
	}

	
	private String text;


	public SpinnerItem(String text) {
		super();
		this.text = text;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}
	
	
}
