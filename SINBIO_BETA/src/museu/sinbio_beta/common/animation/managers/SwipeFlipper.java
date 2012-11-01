
package museu.sinbio_beta.common.animation.managers;

import museu.sinbio_beta.common.animation.base.SimpleGestureFilter;
import museu.sinbio_beta.common.animation.base.SimpleGestureListener;
import museu.sinbio_beta.common.animation.base.SimpleViewFlipper;
import museu.sinbio_beta.common.animation.managers.complete.ViewFlipperDirections;
import android.app.Activity;
import android.widget.ViewFlipper;

public class SwipeFlipper extends SimpleViewFlipper implements ViewFlipperDirections
{
    
    private SimpleGestureFilter gestureFilter;
    
    public SimpleGestureFilter getGestureFilter ( )
    {
        return gestureFilter;
    }
    
    public SwipeFlipper ( ViewFlipper viewFlipper , Activity activity ,
            SimpleGestureListener gestureListener )
    {
        
        super ( viewFlipper );
        // TODO Auto-generated constructor stub
        
        this.gestureFilter = new SimpleGestureFilter ( activity , gestureListener );
        
    }
    
    public void toRight ( )
    {
        // TODO Auto-generated method stub
        
        getViewFlipper ( ).setInAnimation ( inFromLeftAnimation ( ) );
        getViewFlipper ( ).setOutAnimation ( outToRightAnimation ( ) );
        getViewFlipper ( ).showPrevious ( );
        
    }
    
    public void toLeft ( )
    {
        // TODO Auto-generated method stub
        
        getViewFlipper ( ).setInAnimation ( inFromRightAnimation ( ) );
        getViewFlipper ( ).setOutAnimation ( outToLeftAnimation ( ) );
        getViewFlipper ( ).showNext ( );
    }
    
}
