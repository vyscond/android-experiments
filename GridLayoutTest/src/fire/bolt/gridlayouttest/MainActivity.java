package fire.bolt.gridlayouttest;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        GridLayout gl = (GridLayout) findViewById(R.id.GridLayout1);
        
        
        // --------------------------------
        
        gl.setColumnCount(5);
        gl.setColumnOrderPreserved(true);
        
        
        
        gl.addView( this.getTextAndButtonView("tv1", "b1"));
        gl.addView( this.getTextAndButtonView("tv2", "b2"));
        gl.addView( this.getTextAndButtonView("tv3", "b3"));
        gl.addView( this.getTextAndButtonView("tv4", "b4"));
        gl.addView( this.getTextAndButtonView("tv5", "b5"));
        gl.addView( this.getTextAndButtonView("tv6", "b5"));
        gl.addView( this.getTextAndButtonView("tv7", "b5"));
        gl.addView( this.getTextAndButtonView("tv8", "b5"));
        gl.addView( this.getTextAndButtonView("tv9", "b5"));
        gl.addView( this.getTextAndButtonView("tv10", "b5"));
        
    }

    private int swp_color = Color.BLACK;
    
    public LinearLayout getTextAndButtonView(String textView_value, String button_value)
    {
    	LinearLayout ll = new LinearLayout(this);
        
        ll.setOrientation(LinearLayout.VERTICAL);
        
        Button b = new Button(this);
        b.setText(textView_value);
        
        b.setOnClickListener(new OnClickListener() {
			
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(MainActivity.this , SourceCode.class);
				startActivity(i);
				
			}
		});
        
        TextView tv = new TextView(this);
        tv.setText(button_value);
        
        ll.addView(tv);
        ll.addView(b);
        
        //LinearLayout.LayoutParams params = (LayoutParams) LinearLayout.setLayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.MATCH_PARENT);
        LinearLayout.LayoutParams params = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        ll.setLayoutParams(params);
        

        if( swp_color == Color.BLACK )
        {
        	swp_color = Color.DKGRAY;
        }
        else
        {
        	swp_color = Color.BLACK;
        }
        
        ll.setBackgroundColor(swp_color);
        return ll;
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

