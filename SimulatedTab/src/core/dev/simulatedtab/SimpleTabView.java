
package core.dev.simulatedtab;

import java.util.ArrayList;

import android.graphics.Color;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;

public class SimpleTabView
{
    
    private ArrayList < Button >   tabSelectorButton = new ArrayList < Button > ( );
    
    private ArrayList < ViewStub > tabsView          = new ArrayList < ViewStub > ( );
    
    private LinearLayout           linearLayoutForTabButtons;
    
    private LinearLayout           linearLayoutBase;
    
    private Color                  selectedTabColor , unselectedTabColor;
    
    public SimpleTabView ( LinearLayout linearLayoutBase , LinearLayout linearLayoutForTabButtons ,
            ArrayList < String > tabNames , int pojoLayoutTabButtonId , ArrayList < ViewStub > tabViews , Color selectedTabColor , Color unselectedTabColor )

    {
        
        this.linearLayoutBase = linearLayoutBase;
        
        this.linearLayoutForTabButtons = linearLayoutForTabButtons;
        
        this.selectedTabColor = selectedTabColor;
        
        this.unselectedTabColor = unselectedTabColor;
        
        this.build( tabNames , tabViews );
        
    }

    private void build ( ArrayList < String > tabNames , ArrayList < ViewStub > tabViews )
    {
        // TODO Auto-generated method stub
        
    }
}
