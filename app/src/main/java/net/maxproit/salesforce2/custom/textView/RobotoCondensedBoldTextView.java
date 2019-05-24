package net.maxproit.salesforce2.custom.textView;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;


/**
 * Custom TextView for roboto_condensed_bold font
 */
public class RobotoCondensedBoldTextView extends AppCompatTextView {


    public RobotoCondensedBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public RobotoCondensedBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoCondensedBoldTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/robotocondensed/roboto_condensed_bold.ttf");
        setTypeface(tf);
    }

}
