package net.maxproit.salesforce.custom.editText;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Custom EditText for Roboto_bold font
 */
public class RobotoBoldEditText extends android.support.v7.widget.AppCompatEditText {

    public RobotoBoldEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoBoldEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoBoldEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto/roboto_bold.ttf");
            setTypeface(tf);
        }
    }

}
