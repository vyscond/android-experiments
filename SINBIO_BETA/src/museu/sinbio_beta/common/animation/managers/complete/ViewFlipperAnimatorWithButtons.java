
package museu.sinbio_beta.common.animation.managers.complete;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ViewFlipper;

public class ViewFlipperAnimatorWithButtons
{
    
    private ViewFlipper viewFlipper;
    
    private Button      toLeftButton;
    
    private Button      toRightButton;
    
    // private Context context;
    
    public ViewFlipperAnimatorWithButtons ( Context context , Button toLeftButton , Button toRightButton )
    {
        
        // this.context = context;
        
        this.toLeftButton = toLeftButton;
        
        this.toRightButton = toRightButton;
        
        /* ------------------------------ */

        this.toRightButton.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                
                viewFlipper.setInAnimation ( inFromRightAnimation ( ) );
                viewFlipper.setOutAnimation ( outToLeftAnimation ( ) );
                viewFlipper.showNext ( );
                
            }
        } );
        
        this.toLeftButton.setOnClickListener ( new OnClickListener ( )
        {
            
            public void onClick ( View v )
            {
                // TODO Auto-generated method stub
                
                viewFlipper.setInAnimation ( inFromLeftAnimation ( ) );
                viewFlipper.setOutAnimation ( outToRightAnimation ( ) );
                viewFlipper.showPrevious ( );
                
            }
        } );
        
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
    
    private Animation outToRightAnimation ( )
    {
        Animation outtoRight = new TranslateAnimation (
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , + 1.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f ,
                Animation.RELATIVE_TO_PARENT , 0.0f );
        outtoRight.setDuration ( 500 );
        outtoRight.setInterpolator ( new AccelerateInterpolator ( ) );
        return outtoRight;
    }
    
}
