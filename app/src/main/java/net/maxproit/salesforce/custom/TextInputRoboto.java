package net.maxproit.salesforce.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.support.design.widget.TextInputLayout;
import android.util.AttributeSet;


public class TextInputRoboto extends TextInputLayout {
    public TextInputRoboto(Context context) {
        super(context);
        init();
    }

    public TextInputRoboto(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextInputRoboto(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(), "fonts/robotocondensed/roboto_condensed_regular.ttf");
        setTypeface(tf);
    }
}
