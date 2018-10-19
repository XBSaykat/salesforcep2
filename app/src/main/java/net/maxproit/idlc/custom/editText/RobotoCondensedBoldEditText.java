package net.maxproit.idlc.custom.editText;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Custom EditText for Roboto_condensed_bold font
 */
public class RobotoCondensedBoldEditText extends android.support.v7.widget.AppCompatEditText {

    public RobotoCondensedBoldEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoCondensedBoldEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoCondensedBoldEditText(Context context) {
        super(context);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/robotocondensed/roboto_condensed_bold.ttf");
            setTypeface(tf);
        }
    }

}
