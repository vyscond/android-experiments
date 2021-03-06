package core.dev.tabhosttest;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// tabs
//		firstButton = (Button) findViewById(R.id.firstButton);
//		secondButton = (Button) findViewById(R.id.secondButton);
//		thirdButton = (Button) findViewById(R.id.thirdButton);
//		forthButton = (Button) findViewById(R.id.forthButton);

		Resources res = getResources(); // Resource object to get Drawables
		final TabHost tabHost = (TabHost) findViewById(R.id.tabhost); // The activity TabHost
		TabHost.TabSpec spec; // Resusable TabSpec for each tab
		Intent intent; // Reusable Intent for each tab

		intent = new Intent().setClass(this, FirstGroupActivity.class);
		spec = tabHost.newTabSpec("first").setIndicator("First")
				.setContent(intent);
		tabHost.addTab(spec);
		/*intent = new Intent().setClass(this, SecondGroupActivity.class);
		spec = tabHost.newTabSpec("second").setIndicator("Second")
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ThirdGroupActivity.class);
		spec = tabHost.newTabSpec("third").setIndicator("Third")
				.setContent(intent);
		tabHost.addTab(spec);

		intent = new Intent().setClass(this, ForthActivity.class);
		spec = tabHost.newTabSpec("forth").setIndicator("Forth")
				.setContent(intent);
		tabHost.addTab(spec);*/

		tabHost.setCurrentTab(0);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
}
