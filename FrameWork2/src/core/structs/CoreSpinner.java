package core.structs;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.Toast;
import core.base.CommonItemListBehavior;
import core.base.GenericAdapter;



public class CoreSpinner /*implements OnItemSelectedListener{*/
{
	protected Spinner spinner;
	
	protected GenericAdapter adapter;
	
	protected Context context;
	
	protected int lastElementSelectedIndex;
	
	public CoreSpinner(Context context , Spinner spinner)
	{
		this.lastElementSelectedIndex = 0;
		
		this.context = context;
		
		this.spinner = spinner;
		
		this.adapter = new GenericAdapter(context, (new ArrayList<CommonItemListBehavior>()) );
		
		this.spinner.setAdapter(adapter);
	}
	
	public CoreSpinner(Context context , Spinner spinner , ArrayList<CommonItemListBehavior> itemsOnList)
	{
		
		this.lastElementSelectedIndex = 0;
		
		this.context = context;
		
		this.spinner = spinner;
		
		this.adapter = new GenericAdapter(context, itemsOnList );
		
		this.spinner.setAdapter(adapter);
	
		this.spinner.setOnItemSelectedListener(
				
				new OnItemSelectedListener() {

					public void onItemSelected(AdapterView<?> parent, View v, int position, long id) {
						// TODO Auto-generated method stub
						
						
						/*CharSequence text = "You've selected ["+position+"]";
						int duration = Toast.LENGTH_SHORT;

						Toast toast = Toast.makeText(v.getContext(), text, duration);
						toast.show();*/
						
						customSpinnerOnItemSelected(parent, v, position, id);
						
					}

					public void onNothingSelected(AdapterView<?> arg0) {
						// TODO Auto-generated method stub
						
					}
				}
				
		);
		
	}
	
	public void testingRef()
	{
		CharSequence text = "You've selected []";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(this.context, text, duration);
		toast.show();

	}
	
	
	
	public void customSpinnerOnItemSelected(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		this.lastElementSelectedIndex = position;
		
		CharSequence text = "You've selected ["+position+"]";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(this.context, text, duration);
		toast.show();
		
		
	}

	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

	public Spinner getSpinner() {
		return spinner;
	}

	public void setSpinner(Spinner spinner) {
		this.spinner = spinner;
	}

	public GenericAdapter getAdapter() {
		return adapter;
	}

	public void setAdapter(GenericAdapter adapter) {
		this.adapter = adapter;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public int getLastElementSelectedIndex() {
		return lastElementSelectedIndex;
	}

	public void setLastElementSelectedIndex(int lastElementSelectedIndex) {
		this.lastElementSelectedIndex = lastElementSelectedIndex;
	}
	
	

	
	
}
