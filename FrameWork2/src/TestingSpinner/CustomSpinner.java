package TestingSpinner;

import java.util.ArrayList;

import android.content.Context;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import core.base.CommonItemListBehavior;
import core.structs.CoreSpinner;

public class CustomSpinner extends CoreSpinner {

	public CustomSpinner(Context context, Spinner spinner) {
		super(context, spinner);
		// TODO Auto-generated constructor stub
	}
	
	public CustomSpinner(Context context, Spinner spinner, ArrayList<CommonItemListBehavior> arrayList) {
		super(context, spinner, arrayList);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void customSpinnerOnItemSelected(AdapterView<?> parent, View v, int position, long id) {
	
		
		CharSequence text = "You've selected ["+position+"]";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(this.context, text, duration);
		toast.show();
	}
	
	
}
