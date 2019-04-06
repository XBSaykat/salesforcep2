package net.maxproit.salesforce.custom.textView;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


/**
 * Custom TextView for roboto_condensed_light font
 */
public class RobotoCondensedLightTextView extends AppCompatTextView {


    public RobotoCondensedLightTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoCondensedLightTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoCondensedLightTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/robotocondensed/roboto_condensed_light.ttf");
        setTypeface(tf);
    }

}
