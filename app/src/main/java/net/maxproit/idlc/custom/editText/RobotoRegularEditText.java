package net.maxproit.idlc.custom.editText;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Custom EditText for Roboto_light font
 */
public class RobotoRegularEditText extends android.support.v7.widget.AppCompatEditText {

    public RobotoRegularEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoRegularEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoRegularEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto/Roboto-Regular.ttf");
            setTypeface(tf);
        }
    }

}
