package fire.bolt.gridlayouttest;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.LinearLayout.LayoutParams;

public class SourceCode extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_source_code);
        
        GridLayout gl = (GridLayout) findViewById(R.id.GridLayout1);
        
        EditText source = new EditText(this);
        
        source.setText("LinearLayout ll = new LinearLayout(this);"+"\n"+
        
        "ll.setOrientation(LinearLayout.VERTICAL);"+"\n"+
        
        "Button b = new Button(this);"+"\n"+
        "b.setText(textView_value);"+"\n"+
        "TextView tv = new TextView(this);"+"\n"+
        "tv.setText(button_value);"+"\n"+
        
        "ll.addView(tv);"+"\n"+
        "ll.addView(b);"+"\n"+
        
        //LinearLayout.LayoutParams params = (LayoutParams) LinearLayout.setLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        "LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);"+"\n"+
        "ll.setLayoutParams(params);"+"\n"+
        

        "if( swp_color == Color.BLACK )"+"\n"+
        "{"+"\n"+
        	"swp_color = Color.DKGRAY;"+"\n"+
        "}"+"\n"+
        "else"+"\n"+
        "{"+"\n"+
        	"swp_color = Color.BLACK;"+"\n"+
        "}"+"\n"+
        
        "ll.setBackgroundColor(swp_color);"+"\n"+
        "return ll;"+"\n");
        
        gl.addView(source);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_source_code, menu);
        return true;
    }
}
