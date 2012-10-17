package museu.goeldi.mobile.simple.viewflipper;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ViewFlipper;

public class ButtonFlipper extends SimpleViewFlipper {

	private Button left, right;

	public ButtonFlipper(ViewFlipper viewFlipper, Button left, Button right) {
		super(viewFlipper);
		// TODO Auto-generated constructor stub

		this.left = left;
		this.right = right;

		this.configureAction();
	}

	@Override
	public void configureAction() {
		
		this.right.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				getViewFlipper().setInAnimation(inFromRightAnimation());
				getViewFlipper().setOutAnimation(outToLeftAnimation());
				getViewFlipper().showNext();

			}
		});

		this.left.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// TODO Auto-generated method stub

				getViewFlipper().setInAnimation(inFromLeftAnimation());
				getViewFlipper().setOutAnimation(outToRightAnimation());
				getViewFlipper().showPrevious();

			}
		});
	}

}
