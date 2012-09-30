package museu.goeldi.sinbiomobile;

import java.util.ArrayList;

import TestingSpinner.SpinnerItem;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.ViewStub;
import android.widget.Spinner;
import core.base.CommonItemListBehavior;
import core.structs.CoreDynamicSpinnerViewer;
import core.structs.CoreSpinner;

public class TestSpinnerViewer extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        
    	super.onCreate(savedInstanceState);
        
        setContentView(R.layout.activity_test_spinner_viewer);
        
        Spinner sp = (Spinner) findViewById(R.id.spinner1);
        
        ArrayList<CommonItemListBehavior> arr = new ArrayList<CommonItemListBehavior>();
        
        arr.add(new SpinnerItem("Opção 1"));
        arr.add(new SpinnerItem("Opção 2"));
        arr.add(new SpinnerItem("Opção 3"));
        arr.add(new SpinnerItem("Opção 4"));
        
        // --- working good :D
        
        
        CoreSpinner cs = new CoreSpinner(this, sp , arr);
        
        //CustomSpinner cs = new CustomSpinner(this, sp, arr);
        
        
        
        
        
     
         
       ArrayList<Integer> loadableViewsID = new ArrayList<Integer>();
       
       loadableViewsID.add(R.layout.spinnerselectionlayout_testando_01);
       loadableViewsID.add(R.layout.spinnerselectionlayout_testando_02);
       
       ViewStub vs = (ViewStub) findViewById( R.id.viewStub1);
       
       CoreDynamicSpinnerViewer cdsv = new CoreDynamicSpinnerViewer(this, sp,  vs, arr, loadableViewsID);
       
      
        /*  beta test with viewstub :D 
       
       
       
       ViewStub vs = (ViewStub) findViewById( R.id.viewStub1);
       
       vs.setLayoutResource(R.layout.spinnerselectionlayout_testando_01);
       
       vs.inflate();*/
       
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_test_spinner_viewer, menu);
        return true;
    }
}
