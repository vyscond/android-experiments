package museu.goeldi.mobile.cadastro;

import museu.goeldi.mobile.R;
import museu.goeldi.mobile.simple.viewflipper.ViewFlipperAnimatorWithSwipe;
import museu.goeldi.mobile.simple.viewflipper.ViewFlipperAnimatorWithSwipe.SimpleGestureListener;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

public class SimpleSwipeCriarRegistro extends Activity implements SimpleGestureListener {

	private ViewFlipperAnimatorWithSwipe flipper ;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_criar_registro_amostra_fragmented);
        
        ViewFlipper f = (ViewFlipper) findViewById(R.id.viewFlipper_registro_amostra_fragmented);
        
        flipper = new ViewFlipperAnimatorWithSwipe(this, this , f);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_simple_swipe_criar_registro, menu);
        return true;
    }

	
	
    @Override
	public boolean dispatchTouchEvent(MotionEvent me) {
		this.flipper.onTouchEvent(me);
		return super.dispatchTouchEvent(me);
	}

	public void onSwipe(int direction) {
		
		this.flipper.AnimateIt(direction);
		
	}

	public void onDoubleTap() {
		// Toast.makeText(this, "Double Tap", Toast.LENGTH_SHORT).show();
		
	}
}
