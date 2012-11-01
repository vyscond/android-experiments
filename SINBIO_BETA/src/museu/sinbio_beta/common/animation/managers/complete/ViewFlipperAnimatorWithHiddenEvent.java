package museu.sinbio_beta.common.animation.managers.complete;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ViewFlipper;


public class ViewFlipperAnimatorWithHiddenEvent
{
    private ViewFlipper viewFlipper;
    
    
    // private Context context;
    
    

    
    public void tunToRight()
    {
        viewFlipper.setInAnimation ( inFromRightAnimation ( ) );
        viewFlipper.setOutAnimation ( outToLeftAnimation ( ) );
        viewFlipper.showNext ( );
    }
    
    public ViewFlipperAnimatorWithHiddenEvent ( ViewFlipper viewFlipper )
    {
        super ( );
        this.viewFlipper = viewFlipper;
    }

    public void turnToLeft()
    {
        viewFlipper.setInAnimation ( inFromLeftAnimation ( ) );
        viewFlipper.setOutAnimation ( outToRightAnimation ( ) );
        viewFlipper.showPrevious ( );
    }
    
    /* ------------------------------------------------ */

    private Animation inFromRightAnimation ( )
    {
        
        Animation inFromRight = new TranslateAnimation (
                Animation.RELATIVE_TO_PARENT , + 1.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f );
        inFromRight.setDuration ( 500 );
        inFromRight.setInterpolator ( new AccelerateInterpolator ( ) );
        return inFromRight;
    }
    
    private Animation outToRightAnimation ( )
    {
        //TranslateAnimation.TranslateAnimation(int fromXType, float fromXValue, int   toXType, float toXValue, int fromYType, float fromYValue, int toYType, float toYValue)
        
        
        Animation outtoRight = new TranslateAnimation (
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , + 1.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f );
        outtoRight.setDuration ( 500 );
        outtoRight.setInterpolator ( new AccelerateInterpolator ( ) );
        return outtoRight;
    }
    
    private Animation outToLeftAnimation ( )
    {
        Animation outtoLeft = new TranslateAnimation (
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , - 1.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f );
        outtoLeft.setDuration ( 500 );
        outtoLeft.setInterpolator ( new AccelerateInterpolator ( ) );
        return outtoLeft;
    }
    
    private Animation inFromLeftAnimation ( )
    {
        Animation inFromLeft = new TranslateAnimation (
                Animation.RELATIVE_TO_PARENT , - 1.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f );
        inFromLeft.setDuration ( 500 );
        inFromLeft.setInterpolator ( new AccelerateInterpolator ( ) );
        return inFromLeft;
    }
    
    
}
