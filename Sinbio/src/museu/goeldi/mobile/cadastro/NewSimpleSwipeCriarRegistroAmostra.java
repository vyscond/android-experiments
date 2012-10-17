package museu.goeldi.mobile.cadastro;

import museu.goeldi.mobile.R;
import museu.goeldi.mobile.simple.swipe.SimpleGestureFilter;
import museu.goeldi.mobile.simple.swipe.SimpleGestureListener;
import museu.goeldi.mobile.simple.viewflipper.SwipeFlipper;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class NewSimpleSwipeCriarRegistroAmostra extends Activity implements
		SimpleGestureListener{

	
	private SwipeFlipper flipper;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_criar_registro_amostra_fragmented);
		
		ViewFlipper f = (ViewFlipper) findViewById(R.id.viewFlipper_registro_amostra_fragmented);
		
		flipper = new SwipeFlipper(f, this , this);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(
				R.menu.activity_new_simple_swipe_criar_registro_amostra, menu);
		return true;
	}

	public void onSwipe(int direction) {
		// TODO Auto-generated method stub

		switch (direction) {
		case SimpleGestureFilter.SWIPE_LEFT:{

			this.flipper.toLeft();
			
		}
			break;

		case SimpleGestureFilter.SWIPE_RIGHT: {

			this.flipper.toRight();
			
		}
			break;
		default:
			break;
		}

	}

	public void onDoubleTap() {
		// TODO Auto-generated method stub

	}
	
	@Override
	public boolean dispatchTouchEvent(MotionEvent me) {
		this.flipper.getGestureFilter().onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}
}
