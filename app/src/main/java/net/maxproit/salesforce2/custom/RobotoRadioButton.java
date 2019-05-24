package net.maxproit.salesforce2.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatRadioButton;
import android.util.AttributeSet;


public class RobotoRadioButton extends AppCompatRadioButton {


    public RobotoRadioButton(Context context) {
        super(context);
        init();
    }

    public RobotoRadioButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoRadioButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/roboto/Roboto-Regular.ttf");
        setTypeface(tf);
    }
}