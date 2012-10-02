package museu.goeldi.mobile.kiss;

import museu.goeldi.mobile.R;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.InputType;
import android.widget.EditText;
import android.widget.TextView;

public class ViewGenerator {

	public TextView getTextViewTitle(Context context, String label, String color) {

		TextView textView = new TextView(context);

		Drawable d = (((Activity) context).getResources()
				.getDrawable(R.drawable.background_color_normal_rounded_top_right_bottom_left));

		textView.setBackgroundResource(R.drawable.background_color_normal_rounded_top_right_bottom_left);

		textView.setText((CharSequence) label);

		return textView;

	}

	public EditText getTextFieldSignedFloatNumber(Context context,
			String label, String color) {

		EditText editText = new EditText(context);

		Drawable d = (((Activity) context).getResources()
				.getDrawable(R.drawable.background_color_normal_rounded_top_right_bottom_left));

		editText.setBackgroundResource(R.drawable.background_color_normal_rounded_full);

		editText.setTypeface(Typeface.MONOSPACE);
		editText.setRawInputType(InputType.TYPE_NUMBER_FLAG_SIGNED
				| InputType.TYPE_NUMBER_FLAG_DECIMAL);

		return editText;

	}

	public EditText getTextFieldSignedIntegerNumber(Context context,
			String label, String color) {

		EditText editText = new EditText(context);

		Drawable d = (((Activity) context).getResources()
				.getDrawable(R.drawable.background_color_normal_rounded_top_right_bottom_left));

		editText.setBackgroundResource(R.drawable.background_color_normal_rounded_full);

		editText.setTypeface(Typeface.MONOSPACE);
		editText.setRawInputType(InputType.TYPE_NUMBER_FLAG_SIGNED);

		return editText;

	}

}
