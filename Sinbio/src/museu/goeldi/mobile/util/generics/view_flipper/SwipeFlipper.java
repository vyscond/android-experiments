package museu.goeldi.mobile.util.generics.view_flipper;

import museu.goeldi.mobile.util.generics.gesture.SimpleGestureFilter;
import museu.goeldi.mobile.util.generics.gesture.SimpleGestureListener;
import android.app.Activity;
import android.widget.ViewFlipper;

public class SwipeFlipper extends SimpleViewFlipper implements
		ViewFlipperDirections {

	private SimpleGestureFilter gestureFilter;

	
	
	public SimpleGestureFilter getGestureFilter() {
		return gestureFilter;
	}

	public SwipeFlipper(ViewFlipper viewFlipper, Activity activity,
			SimpleGestureListener gestureListener) {

		super(viewFlipper);
		// TODO Auto-generated constructor stub

		this.gestureFilter = new SimpleGestureFilter(activity, gestureListener);

	}

	public void toRight() {
		// TODO Auto-generated method stub

		getViewFlipper().setInAnimation(inFromLeftAnimation());
		getViewFlipper().setOutAnimation(outToRightAnimation());
		getViewFlipper().showPrevious();

	}

	public void toLeft() {
		// TODO Auto-generated method stub
		
		
		getViewFlipper().setInAnimation(inFromRightAnimation());
		getViewFlipper().setOutAnimation(outToLeftAnimation());
		getViewFlipper().showNext();
	}

}
