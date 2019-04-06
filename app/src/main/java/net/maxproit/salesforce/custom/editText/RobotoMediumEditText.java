package net.maxproit.salesforce.custom.editText;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Custom EditText for Roboto_medium font
 */
public class RobotoMediumEditText extends android.support.v7.widget.AppCompatEditText {

    public RobotoMediumEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoMediumEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoMediumEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/roboto/roboto_medium.ttf");
            setTypeface(tf);
        }
    }

}
