package museu.sinbio_beta.common.animation.managers;

import museu.sinbio_beta.common.animation.managers.complete.ViewFlipperAnimatorWithHiddenEvent;
import android.widget.ViewFlipper;


public class HiddenFlipper extends ViewFlipperAnimatorWithHiddenEvent {

    public HiddenFlipper ( ViewFlipper viewFlipper )
    {
        super ( viewFlipper );
        // TODO Auto-generated constructor stub
    }
    
    public void turnToRight()
    {
        this.tunToRight ( );
    }

    public void turnToLeft()
    {
        this.turnToLeft ( );
    }

}

