package net.maxproit.idlc.custom.editText;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Custom EditText for Roboto_light font
 */
public class RobotoEditText extends android.support.v7.widget.AppCompatEditText {

    public RobotoEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto/roboto_light.ttf");
            setTypeface(tf);
        }
    }

}
