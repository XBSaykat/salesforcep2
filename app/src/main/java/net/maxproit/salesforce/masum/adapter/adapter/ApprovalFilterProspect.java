package net.maxproit.salesforce.masum.adapter.adapter;

import android.widget.Filter;

import net.maxproit.salesforce.model.myprospect.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SadiqMdAsif on 07-Jun-18.
 * asifsadiqmd@gmail.com
 */

public class ApprovalFilterProspect extends Filter {

    MyProspectAdapter adapter;
    List<Data> filterList;

    public ApprovalFilterProspect(List<Data> filterList, MyProspectAdapter myProspectAdapter) {
        this.adapter = myProspectAdapter;
        this.filterList = filterList;
    }


    //FILTERING OCURS
    @Override
    protected FilterResults performFiltering(CharSequence constraint) {
        FilterResults results = new FilterResults();

        //CHECK CONSTRAINT VALIDITY
        if (constraint != null && constraint.length() > 0) {
            //CHANGE TO UPPER
            constraint = constraint.toString().toUpperCase();
            //STORE OUR FILTERED PLAYERS
            ArrayList<Data> filteredSurveys = new ArrayList<>();

            for (int i = 0; i < filterList.size(); i++) {
                //CHECK
           /*     if (constraint.equals(Constant.SURVEY_APPROVED)){
                    if (filterList.get(i).isApproved()
                            ) {
                        //ADD PLAYER TO FILTERED PLAYERS
                        filteredSurveys.add(filterList.get(i));
                    }
                }else if (constraint.equals(Constant.SURVEY_REJECTED)){

                    if (filterList.get(i).isRejected()
                            ) {
                        //ADD PLAYER TO FILTERED PLAYERS
                        filteredSurveys.add(filterList.get(i));
                    }

                }else if (constraint.equals(Constant.SURVEY_PENDING)){

                    if (!filterList.get(i).isApproved() && !filterList.get(i).isRejected()
                            ) {
                        //ADD PLAYER TO FILTERED PLAYERS
                        filteredSurveys.add(filterList.get(i));
                    }

                }else {*/
                if (filterList.get(i).getName().toUpperCase().contains(constraint)
                        | filterList.get(i).getApprovalSetID().toUpperCase().contains(constraint)
                        | filterList.get(i).getBranch().toUpperCase().contains(constraint)

                        ) {
                    //ADD PLAYER TO FILTERED PLAYERS
                    filteredSurveys.add(filterList.get(i));
                }
                /* }*/
            }

            results.count = filteredSurveys.size();
            results.values = filteredSurveys;
        } else {
            results.count = filterList.size();
            results.values = filterList;

        }

        return results;
    }

    @Override
    protected void publishResults(CharSequence constraint, FilterResults results) {

        adapter.list = (ArrayList<Data>) results.values;

        //REFRESH
        adapter.notifyDataSetChanged();
    }
}