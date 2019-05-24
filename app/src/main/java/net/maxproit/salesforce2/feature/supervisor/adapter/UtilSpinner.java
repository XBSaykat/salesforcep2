package net.maxproit.salesforce2.feature.supervisor.adapter;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;

import net.maxproit.salesforce2.R;

import java.util.List;

public class UtilSpinner extends ArrayAdapter<String> {


    LayoutInflater flater;

    public UtilSpinner(Activity context, List<String> list) {
        super(context, R.layout.spinner_row, R.id.title, list);
        flater = context.getLayoutInflater();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        String rowItem = getItem(position);
        View rowview = flater.inflate(R.layout.spinner_row, null, true);
        RelativeLayout relativeLayout = rowview.findViewById(R.id.spinnerView);
        TextView txtTitle = rowview.findViewById(R.id.title);

        if (position == 0)
            relativeLayout.setBackgroundColor(Color.parseColor("#EEEEEE"));

        txtTitle.setText(rowItem);

        return rowview;
    }
}
