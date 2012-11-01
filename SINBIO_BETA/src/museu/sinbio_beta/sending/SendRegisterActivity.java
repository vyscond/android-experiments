package museu.sinbio_beta.sending;

import museu.sinbio_beta.R;
import museu.sinbio_beta.R.layout;
import museu.sinbio_beta.R.menu;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class SendRegisterActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_register);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_send_register, menu);
        return true;
    }
}
