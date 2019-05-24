package net.maxproit.salesforce2.masum.activity.daviation.adapter;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import net.maxproit.salesforce2.R;
import net.maxproit.salesforce2.databinding.DaviationRequestRowBinding;
import net.maxproit.salesforce2.masum.model.api.deviation.deviationlist.DeviationList;
import net.maxproit.salesforce2.model.login.LocalLogin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class DaviationAdapter extends RecyclerView.Adapter<DaviationAdapter.ViewFilesHolder> {
    private static final String TAG = "MyLeadAdapter";
    LocalLogin localLogin;
    private Context context;
    private List<DeviationList> list;
    private LayoutInflater layoutInflater;
    private String referrenceid;
    private String tempDeviationSetId;
    private int color = 0;
    private int colorPostion = 0;
    ArrayList<Integer> colorArray;

    boolean color1 = true;
    boolean color2 = false;


    private Map<String, Integer> clr = new HashMap<>();


    /**
     * Returns adapter instance
     *
     * @param context  the context calling this adapter
     * @param dataList array list containing path of files
     */
    public DaviationAdapter(Context context, List<DeviationList> dataList, String referrenceid) {
        this.context = context;
        this.list = dataList;
        localLogin = new LocalLogin(context);
        this.referrenceid = referrenceid;
        tempDeviationSetId = list.get(0).getDeviationSetID();
        colorArray = new ArrayList<>();
        colorArray.add(ContextCompat.getColor(context, R.color.black_overlay_2));
        colorArray.add(ContextCompat.getColor(context, R.color.blueGrey));
        colorArray.add(ContextCompat.getColor(context, R.color.blue_clicked));
        color = colorArray.get(0);

        layoutInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);


        colorSet();
    }

    @Override
    public ViewFilesHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (layoutInflater == null) {
            layoutInflater = LayoutInflater.from(parent.getContext());
        }
        DaviationRequestRowBinding binding =
                DataBindingUtil.inflate(layoutInflater, R.layout.daviation_request_row, parent, false);
        return new ViewFilesHolder(binding);


    }

    @Override
    public void onBindViewHolder(ViewFilesHolder holder, int position) {

        holder.binding.setModel(list.get(position));

        holder.binding.clLeadItem.setBackgroundColor(clr.get(list.get(position).getDeviationSetID()));


    }


    @Override
    public int getItemCount() {
        return list == null ? 0 : list.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getItemViewType(int position) {
        return position;
    }

    public class ViewFilesHolder extends RecyclerView.ViewHolder {

        private final DaviationRequestRowBinding binding;

        public ViewFilesHolder(final DaviationRequestRowBinding itemBinding) {
            super(itemBinding.getRoot());
            this.binding = itemBinding;

        }
    }

    private void colorSet() {


        for (int pos = 0; pos < list.size(); pos++) {

            if (tempDeviationSetId.equals(list.get(pos).getDeviationSetID())) {


                if (color1) {

                    clr.put(list.get(pos).getDeviationSetID(), colorArray.get(0));

                }
                if (color2) {
                    clr.put(list.get(pos).getDeviationSetID(), colorArray.get(1));

                }


            } else {

                color1 = !color1;
                color2 = !color2;


                if (color1) {

                    clr.put(list.get(pos).getDeviationSetID(), colorArray.get(0));

                }
                if (color2) {
                    clr.put(list.get(pos).getDeviationSetID(), colorArray.get(1));

                }

            }

            tempDeviationSetId = list.get(pos).getDeviationSetID();
        }
    }

}