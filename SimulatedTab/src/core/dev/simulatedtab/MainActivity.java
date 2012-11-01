package core.dev.simulatedtab;

import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.widget.Button;

public class MainActivity extends Activity {

    private ViewStub viewStub;
    private ViewStub viewStub2;
    private Button b1;
    private Button b2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        b1 = (Button) findViewById ( R.id.button1 );
        
        b2 = (Button) findViewById ( R.id.button2 );
        
        viewStub = (ViewStub) findViewById ( R.id.viewStub1 );
        
        viewStub2 = (ViewStub) findViewById ( R.id.viewStub2 );
        
        b1.setOnClickListener ( new OnClickListener( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                
        button1OnClick ( v );
                
            }
        });
        
        b2.setOnClickListener ( new OnClickListener( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                button2OnClick ( v );
                
            }
        });
        
    }
    
    public void button1OnClick(View v)
    {
        this.viewStub2.setVisibility ( View.GONE );


        this.viewStub.setVisibility ( View.VISIBLE );
        
        b1.setBackground ( getResources ( ).getDrawable ( R.drawable.background_color_pressed_tab ) );
        b1.setTextColor ( Color.WHITE );
        b2.setBackground ( getResources ( ).getDrawable ( R.drawable.background_color_unpressed_tab ) );
        b2.setTextColor ( Color.BLACK );
    }
    
    public void button2OnClick(View v)
    {
        this.viewStub.setVisibility ( View.GONE );

        
        this.viewStub2.setVisibility ( View.VISIBLE );
        
        b2.setBackground ( getResources ( ).getDrawable ( R.drawable.background_color_pressed_tab ) );
        b2.setTextColor ( Color.WHITE );
        b1.setBackground ( getResources ( ).getDrawable ( R.drawable.background_color_unpressed_tab ) );
        b1.setTextColor ( Color.BLACK );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}

