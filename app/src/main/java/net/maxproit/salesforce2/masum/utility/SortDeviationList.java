package net.maxproit.salesforce2.masum.utility;

import net.maxproit.salesforce2.masum.model.api.deviation.deviationlist.DeviationList;

import java.util.Comparator;

public class SortDeviationList implements Comparator<DeviationList> {

    @Override
    public int compare(DeviationList o1, DeviationList o2) {
        return o1.getDeviationSetID().compareTo(o2.getDeviationSetID());
    }
}
