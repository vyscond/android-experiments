
package core.dev.xfiles.composite.pojo;

import android.view.View;
import android.widget.TextView;
import core.dev.xfiles.R;
import core.dev.xfiles.composite.pojo.base.GenericItemList;

public class XFile extends GenericItemList
{
    
    private int    layout;
    
    private String name;
    
    public XFile ( int layout , String name )
    {
        super ( );
        this.layout = layout;
        this.name = name;
    }
    
    @ Override
    public View initializeWidgets ( View v )
    {
        // TODO Auto-generated method stub
        
        ( (TextView) v.findViewById ( R.id.textView_file_name ) ).setText ( this.name );
        
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
