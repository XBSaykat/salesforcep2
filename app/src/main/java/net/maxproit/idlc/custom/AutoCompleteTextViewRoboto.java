package net.maxproit.idlc.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;


/**
 * Custom AutoCompleteTextViewR for roboto font
 */
public class AutoCompleteTextViewRoboto extends android.support.v7.widget.AppCompatAutoCompleteTextView {
    public AutoCompleteTextViewRoboto(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public AutoCompleteTextViewRoboto(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public AutoCompleteTextViewRoboto(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/robotocondensed/roboto_condensed_regular.ttf");
        setTypeface(tf);
    }
}
