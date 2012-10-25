
package core.dev.gridview;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.Button;
import android.widget.GridView;

public class MainActivity extends Activity
{
    
    @ Override
    public void onCreate ( Bundle savedInstanceState )
    {
        
        super.onCreate ( savedInstanceState );
        
        setContentView ( R.layout.activity_main );
        
        GridView gv = (GridView) findViewById ( R.id.gridView1 );
        
        GenericAdapter adapter = new GenericAdapter ( this );
        
        gv.setAdapter ( adapter );
        
        gv.setNumColumns ( 3 );
        
        /*
         * --- The buttons
         * 
         * 1 - apesar de ainda estarmos usando o generic adapter as coisas
         * continuam simples. dê olho no metodo getView do GenericAdapter
         * 
         * 3 - agora os botões abaixo fazem sentido :D
         */

        ButtonOption b1 = new ButtonOption ( );
        
        b1.setText ( "Llol" );
        
        b1.setLayout ( R.layout.item_option_button );
        
        ButtonOption b2 = new ButtonOption ( );
        
        b2.setText ( "Llol" );
        
        b2.setLayout ( R.layout.item_option_button );
        
        ButtonOption b3 = new ButtonOption ( );
        
        b3.setText ( "Llol" );
        
        b3.setLayout ( R.layout.item_option_button );
        
        ButtonOption b4 = new ButtonOption ( );
        
        b4.setText ( "Llol" );
        
        b4.setLayout ( R.layout.item_option_button );
        
        ButtonOption b5 = new ButtonOption ( );
        
        b5.setText ( "Llol" );
        
        b5.setLayout ( R.layout.item_option_button );
        
        ButtonOption b6 = new ButtonOption ( );
        
        b6.setText ( "Llol" );
        
        b6.setLayout ( R.layout.item_option_button );
        
        ButtonOption b7 = new ButtonOption ( );
        
        b7.setText ( "Llol" );
        
        b7.setLayout ( R.layout.item_option_button );
        
        ButtonOption b8 = new ButtonOption ( );
        
        b8.setText ( "Llol" );
        
        b8.setLayout ( R.layout.item_option_button );
        
        ButtonOption b9 = new ButtonOption ( );
        
        b9.setText ( "Llol" );
        
        b9.setLayout ( R.layout.item_option_button );
        
        ButtonOption b10 = new ButtonOption ( );
        
        b10.setText ( "Llol" );
        
        b10.setLayout ( R.layout.item_option_button );
        
        ButtonOption b11 = new ButtonOption ( );
        
        b11.setText ( "Llol" );
        
        b11.setLayout ( R.layout.item_option_button );
        ButtonOption b12 = new ButtonOption ( );
        
        b12.setText ( "Llol" );
        
        b12.setLayout ( R.layout.item_option_button );
        ButtonOption b13 = new ButtonOption ( );
        
        b13.setText ( "Llol" );
        
        b13.setLayout ( R.layout.item_option_button );
        ButtonOption b14 = new ButtonOption ( );
        
        b14.setText ( "Llol" );
        
        b14.setLayout ( R.layout.item_option_button );
        ButtonOption b15 = new ButtonOption ( );
        
        b15.setText ( "Llol" );
        
        b15.setLayout ( R.layout.item_option_button );
        ButtonOption b16 = new ButtonOption ( );
        
        b16.setText ( "Llol" );
        
        b16.setLayout ( R.layout.item_option_button );
        ButtonOption b17 = new ButtonOption ( );
        
        b17.setText ( "Llol 2" );
        
        b17.setLayout ( R.layout.item_option_button );
        
        ButtonOption b18 = new ButtonOption ( );
        
        b18.setText ( "Llol 2" );
        
        b18.setLayout ( R.layout.item_option_button );
        
        ButtonOption b19 = new ButtonOption ( );
        
        b19.setText ( "Llol 2" );
        
        b19.setLayout ( R.layout.item_option_button );
        
        ButtonOption b20 = new ButtonOption ( );
        
        b20.setText ( "Llol 20" );
        
        b20.setLayout ( R.layout.item_option_button );
        
        ButtonOption b21 = new ButtonOption ( );
        
        b21.setText ( "Llol 20" );
        
        b21.setLayout ( R.layout.item_option_button );
        
        ButtonOption b22 = new ButtonOption ( );
        
        b22.setText ( "Llol 20" );
        
        b22.setLayout ( R.layout.item_option_button );
        
        ButtonOption b23 = new ButtonOption ( );
        
        b23.setText ( "Llol 20" );
        
        b23.setLayout ( R.layout.item_option_button );
        
        adapter.addItem ( b1 );
        adapter.addItem ( b2 );
        adapter.addItem ( b3 );
        adapter.addItem ( b4 );
        adapter.addItem ( b5 );
        adapter.addItem ( b6 );
        adapter.addItem ( b7 );
        adapter.addItem ( b8 );
        adapter.addItem ( b9 );
        adapter.addItem ( b10 );
        adapter.addItem ( b11 );
        adapter.addItem ( b12 );
        adapter.addItem ( b13 );
        adapter.addItem ( b14 );
        adapter.addItem ( b15 );
        adapter.addItem ( b16 );
        adapter.addItem ( b17 );
        adapter.addItem ( b18 );
        adapter.addItem ( b19 );
        adapter.addItem ( b20 );
        adapter.addItem ( b21 );
        adapter.addItem ( b22 );
        adapter.addItem ( b23 );
        
        
        
    }
    
    @ Override
    public boolean onCreateOptionsMenu ( Menu menu )
    {
        getMenuInflater ( ).inflate ( R.menu.activity_main , menu );
        return true;
    }
}
