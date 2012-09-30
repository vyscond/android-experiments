package core.dev.tabhosttest;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class FirstGroupActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_group);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_first_group, menu);
        return true;
    }
}
