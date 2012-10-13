package museu.goeldi.mobile.cadastro;

import museu.goeldi.mobile.R;
import museu.goeldi.mobile.cadastro.SimpleGestureFilter.SimpleGestureListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import android.widget.ViewFlipper;

public class SwipeCriarRegistroAmostra extends Activity implements
		SimpleGestureListener {

	private SimpleGestureFilter detector;

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

	ViewFlipper f;

	@Override
	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_criar_registro_amostra_fragmented);

		f = (ViewFlipper) findViewById(R.id.viewFlipper_registro_amostra_fragmented);

		detector = new SimpleGestureFilter(this, this);

		// --- the buttons

		TextView left, right;
		/*
		 * left = (TextView) findViewById(R.id.textView_left);
		 * 
		 * right = (TextView) findViewById(R.id.textView_right);
		 * 
		 * right.setOnClickListener( new OnClickListener() {
		 * 
		 * public void onClick(View v) { // TODO Auto-generated method stub
		 * 
		 * f.setInAnimation(inFromRightAnimation());
		 * f.setOutAnimation(outToLeftAnimation()); f.showNext();
		 * 
		 * } } );
		 * 
		 * left.setOnClickListener( new OnClickListener() {
		 * 
		 * public void onClick(View v) { // TODO Auto-generated method stub
		 * 
		 * f.setInAnimation(inFromLeftAnimation());
		 * f.setOutAnimation(outToRightAnimation()); f.showPrevious();
		 * 
		 * } } );
		 */

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_cadastro_amostra, menu);
		return true;
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent me) {
		this.detector.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}

	public void onSwipe(int direction) {
		String str = "";

		switch (direction) {

		case SimpleGestureFilter.SWIPE_RIGHT: {
			
			str = "Swipe Right";
			
			f.setInAnimation(inFromLeftAnimation());
			f.setOutAnimation(outToRightAnimation());
			f.showPrevious();
		}
			break;
		
		case SimpleGestureFilter.SWIPE_LEFT: {
			
			str = "Swipe Left";

			
			f.setInAnimation(inFromRightAnimation());
			f.setOutAnimation(outToLeftAnimation());
			f.showNext();
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
		
	}

	public void onDoubleTap() {
		// Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
		
	}
}
