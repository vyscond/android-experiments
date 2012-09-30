package core.structs;

import java.util.ArrayList;

import museu.goeldi.sinbiomobile.R;
import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewStub;
import android.widget.AdapterView;
import android.widget.Spinner;
import android.widget.Toast;
import core.base.CommonItemListBehavior;

public class CoreDynamicSpinnerViewer extends CoreSpinner {
	
	private ArrayList<Integer> loadableLayoutsID;
	
	private ViewStub viewExhibitor;
	
	public CoreDynamicSpinnerViewer(Context context, Spinner spinner) {
		super(context, spinner);
		// TODO Auto-generated constructor stub
	}

	public CoreDynamicSpinnerViewer(Context context , Spinner spinner , ArrayList<CommonItemListBehavior> itemsOnList)
	{
		super(context, spinner, itemsOnList);
	}

	public CoreDynamicSpinnerViewer(Context context , Spinner spinner,  ViewStub viewExhibitor, ArrayList<CommonItemListBehavior> itemsOnList, ArrayList<Integer> loadableLayoutsID)
	{
		super(context, spinner, itemsOnList);
		
		this.loadableLayoutsID = loadableLayoutsID;
		
		this.viewExhibitor = viewExhibitor;
		
		this.viewExhibitor.setLayoutResource(this.loadableLayoutsID.get(0));
		
		this.viewExhibitor.inflate();
	}
	
	@Override
	public void customSpinnerOnItemSelected(AdapterView<?> parent, View v, int position, long id) {
		// TODO Auto-generated method stub
		
		this.lastElementSelectedIndex = position;	
		
		//this.change_viewer(position);
		
		//((Activity) this.context).findViewById(R.id.viewStub1);
		
		((ViewStub) ((Activity) this.context).findViewById(R.id.viewStub1)).setLayoutResource(R.layout.spinnerselectionlayout_testando_02);
		
		CharSequence text = "You've selected []";
		int duration = Toast.LENGTH_SHORT;

		Toast toast = Toast.makeText(this.context, text, duration);
		toast.show();
		//Sthis.loadableScreens.get(position).inflate();
	}
	
	private void change_viewer(int position)
	{
		
		if( position < this.loadableLayoutsID.size() )
		{
		
			
			this.viewExhibitor.invalidate();
			this.viewExhibitor.setLayoutResource( this.loadableLayoutsID.get(position) );
			this.viewExhibitor.forceLayout();
			
			
			
		}
		
		else
		{
			
		}
		
	}
	
	
	
	
}
