
package core.dev.thegame.coregame.scene;

import org.andengine.entity.scene.Scene;
import org.andengine.ui.activity.SimpleBaseGameActivity;

public class BaseScene extends Scene 
{
    
    private SimpleBaseGameActivity simpleBaseGameActivity;
    
    private int                    touchX , touchY;
    
    public int getTouchX ( )
    {
        return touchX;
    }
    
    public void setTouchX ( int touchX )
    {
        this.touchX = touchX;
    }
    
    public int getTouchY ( )
    {
        return touchY;
    }
    
    public void setTouchY ( int touchY )
    {
        this.touchY = touchY;
    }
    
    public BaseScene ( SimpleBaseGameActivity simpleBaseGameActivity )
    {
        super ( );
        this.simpleBaseGameActivity = simpleBaseGameActivity;
    }
    
    public SimpleBaseGameActivity getSimpleBaseGameActivity ( )
    {
        return simpleBaseGameActivity;
    }
    
    public void setSimpleBaseGameActivity ( SimpleBaseGameActivity simpleBaseGameActivity )
    {
        this.simpleBaseGameActivity = simpleBaseGameActivity;
    }

    
    
    
}
