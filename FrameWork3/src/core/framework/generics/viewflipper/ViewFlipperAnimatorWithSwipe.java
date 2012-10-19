package core.framework.generics.viewflipper;

import core.framework.generics.viewflipper.listeners.SimpleGestureFilter;
import android.app.Activity;
import android.util.Log;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.ViewFlipper;

public class ViewFlipperAnimatorWithSwipe extends SimpleOnGestureListener {

	private ViewFlipper viewFlipper;

	private Activity activity;

	public ViewFlipperAnimatorWithSwipe(Activity activity,
			SimpleGestureListener gestureListener, ViewFlipper viewFlipper) {

		this.activity = activity;

		this.listener = gestureListener;

		this.viewFlipper = viewFlipper;

		this.detector = new GestureDetector(this.activity, this);

	}

	/* --- Gesture Filter --- [BGN] */

	public final static int SWIPE_UP = 1;
	public final static int SWIPE_DOWN = 2;
	public final static int SWIPE_LEFT = 3;
	public final static int SWIPE_RIGHT = 4;

	public final static int MODE_TRANSPARENT = 0;
	public final static int MODE_SOLID = 1;
	public final static int MODE_DYNAMIC = 2;

	private final static int ACTION_FAKE = -13; // just an unlikely number
	/*
	 * private int swipe_Min_Distance = 100; private int swipe_Max_Distance =
	 * 350; private int swipe_Min_Velocity = 100;
	 */

	private int swipe_Min_Distance = 50;
	private int swipe_Max_Distance = 350;
	private int swipe_Min_Velocity = 50;

	private int mode = MODE_DYNAMIC;
	private boolean running = true;
	private boolean tapIndicator = false;

	private GestureDetector detector;
	private SimpleGestureListener listener;

	public void onTouchEvent(MotionEvent event) {

		if (!this.running)
			return;

		boolean result = this.detector.onTouchEvent(event);

		if (this.mode == MODE_SOLID)
			event.setAction(MotionEvent.ACTION_CANCEL);
		else if (this.mode == MODE_DYNAMIC) {

			if (event.getAction() == ACTION_FAKE)
				event.setAction(MotionEvent.ACTION_UP);
			else if (result)
				event.setAction(MotionEvent.ACTION_CANCEL);
			else if (this.tapIndicator) {
				event.setAction(MotionEvent.ACTION_DOWN);
				this.tapIndicator = false;
			}

		}
		// else just do nothing, it's Transparent
	}

	public void setMode(int m) {
		this.mode = m;
	}

	public int getMode() {
		return this.mode;
	}

	public void setEnabled(boolean status) {
		this.running = status;
	}

	public void setSwipeMaxDistance(int distance) {
		this.swipe_Max_Distance = distance;
	}

	public void setSwipeMinDistance(int distance) {
		this.swipe_Min_Distance = distance;
	}

	public void setSwipeMinVelocity(int distance) {
		this.swipe_Min_Velocity = distance;
	}

	public int getSwipeMaxDistance() {
		return this.swipe_Max_Distance;
	}

	public int getSwipeMinDistance() {
		return this.swipe_Min_Distance;
	}

	public int getSwipeMinVelocity() {
		return this.swipe_Min_Velocity;
	}

	@Override
	public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX,
			float velocityY) {

		final float xDistance = Math.abs(e1.getX() - e2.getX());
		final float yDistance = Math.abs(e1.getY() - e2.getY());

		if (xDistance > this.swipe_Max_Distance
				|| yDistance > this.swipe_Max_Distance)
			return false;

		velocityX = Math.abs(velocityX);
		velocityY = Math.abs(velocityY);
		boolean result = false;

		if (velocityX > this.swipe_Min_Velocity
				&& xDistance > this.swipe_Min_Distance) {
			if (e1.getX() > e2.getX()) // right to left
				this.listener.onSwipe(SWIPE_LEFT);
			else
				this.listener.onSwipe(SWIPE_RIGHT);

			result = true;
		} else if (velocityY > this.swipe_Min_Velocity
				&& yDistance > this.swipe_Min_Distance) {
			if (e1.getY() > e2.getY()) // bottom to up
				this.listener.onSwipe(SWIPE_UP);
			else
				this.listener.onSwipe(SWIPE_DOWN);

			result = true;
		}

		return result;
	}

	@Override
	public boolean onSingleTapUp(MotionEvent e) {
		this.tapIndicator = true;
		return false;
	}

	@Override
	public boolean onDoubleTap(MotionEvent arg0) {
		this.listener.onDoubleTap();
		;
		return true;
	}

	@Override
	public boolean onDoubleTapEvent(MotionEvent arg0) {
		return true;
	}

	@Override
	public boolean onSingleTapConfirmed(MotionEvent arg0) {

		if (this.mode == MODE_DYNAMIC) { // we owe an ACTION_UP, so we fake an
			arg0.setAction(ACTION_FAKE); // action which will be converted to an
											// ACTION_UP later.
			this.activity.dispatchTouchEvent(arg0);
		}

		return false;
	}

	public static interface SimpleGestureListener {
		void onSwipe(int direction);

		void onDoubleTap();
	}

	/* --- Gesture Filter --- [END] */

	/* ------------------------------------------------ */

	private Animation inFromRightAnimation() {

		Animation inFromRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromRight.setDuration(500);
		inFromRight.setInterpolator(new AccelerateInterpolator());
		return inFromRight;
	}

	private Animation outToLeftAnimation() {
		Animation outtoLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoLeft.setDuration(500);
		outtoLeft.setInterpolator(new AccelerateInterpolator());
		return outtoLeft;
	}

	private Animation inFromLeftAnimation() {
		Animation inFromLeft = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, -1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		inFromLeft.setDuration(500);
		inFromLeft.setInterpolator(new AccelerateInterpolator());
		return inFromLeft;
	}

	private Animation outToRightAnimation() {
		Animation outtoRight = new TranslateAnimation(
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, +1.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f,
				Animation.RELATIVE_TO_PARENT, 0.0f);
		outtoRight.setDuration(500);
		outtoRight.setInterpolator(new AccelerateInterpolator());
		return outtoRight;
	}

	public void AnimateIt(int direction) {
		// TODO Auto-generated method stub

		String str = "";

		switch (direction) {

		case SimpleGestureFilter.SWIPE_RIGHT: {

			str = "Swipe Right";

			this.viewFlipper.setInAnimation(inFromLeftAnimation());
			this.viewFlipper.setOutAnimation(outToRightAnimation());
			this.viewFlipper.showPrevious();
		}
			break;

		case SimpleGestureFilter.SWIPE_LEFT: {

			str = "Swipe Left";

			this.viewFlipper.setInAnimation(inFromRightAnimation());
			this.viewFlipper.setOutAnimation(outToLeftAnimation());
			this.viewFlipper.showNext();
		}
			break;
		case SimpleGestureFilter.SWIPE_DOWN:
			str = "Swipe Down";
			break;
		case SimpleGestureFilter.SWIPE_UP:
			str = "Swipe Up";
			break;

		}
		// Toast.makeText(this, str, Toast.LENGTH_SHORT).show();
		Log.d("ViewFipplerSwipe", str);

	}

	/* --- unimplementes methods from gesturelistener */

}
