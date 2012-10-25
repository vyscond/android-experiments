
package core.dev.xfiles.composite.pojo;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import android.widget.Toast;
import core.dev.xfiles.R;
import core.dev.xfiles.composite.pojo.base.GenericItemList;

public class XFolder extends GenericItemList
{
    
    private String name;
    
    public String getName ( )
    {
        return name;
    }
    
    public void setName ( String name )
    {
        this.name = name;
    }
    
    private int layout;
    
    public XFolder ( int layout , String name )
    {
        this.layout = layout;
        this.name = name;
        
        this.buildOnClickEvent ( );
        
    }
    
    View.OnClickListener onClick;
    
    private void buildOnClickEvent()
    {
        this.onClick  =
            new OnClickListener ( )
            {
            
                public void onClick ( View v )
                {
                    // TODO Auto-generated method stub
                    
                    Toast.makeText ( v.getContext ( ) , "Chage directory" , Toast.LENGTH_SHORT ).show ( );
                    
                }
            };
    }
    
    @ Override
    public View initializeWidgets ( View v )
    {
        // TODO Auto-generated method stub
        
        TextView t = ( (TextView) v.findViewById ( R.id.textView_folder_name ) );
        
        t.setText ( this.name );
        t.setOnClickListener ( onClick );
        return v;
    }
    
    @ Override
    public int getLayout ( )
    {
        // TODO Auto-generated method stub
        return this.layout;
    }
    
    @ Override
    public void setLayout ( int layout_id )
    {
        // TODO Auto-generated method stub
        this.layout = layout_id;
    }
    
    private long id;
    
    @ Override
    public long getId ( )
    {
        // TODO Auto-generated method stub
        return this.id;
    }
    
    @ Override
    public void setId ( long id )
    {
        // TODO Auto-generated method stub
        this.id = id;
    }
    
}
