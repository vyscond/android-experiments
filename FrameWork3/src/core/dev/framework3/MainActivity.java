package core.dev.framework3;

import core.dev.framework3.testing.SimpleListViewInActionActivity;
import core.dev.framework3.testing.SimpleSpinnerInActionActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		this.buildMenu();
		
	}
	
	public void buildMenu()
	{
		/* --- Menu --- */
		
		TextView simpleListViewLink = (TextView) findViewById(R.id.textView_SimpleListView);
		
		simpleListViewLink.setText("Simple List View");

		simpleListViewLink.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(MainActivity.this, SimpleListViewInActionActivity.class);
				
				startActivity(i);
				
			}
		});
		
		TextView simpleSpinnerLink = (TextView) findViewById(R.id.textView_SimpleSpinner);
		
		simpleSpinnerLink.setText("Simple Spinner");
		
		simpleSpinnerLink.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				Intent i = new Intent(MainActivity.this, SimpleSpinnerInActionActivity.class);
				
				startActivity(i);
				
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
