package net.maxproit.salesforce.masum.utility;

public class MasumCommonUtils {


    public static boolean isNullStr(String str){
        boolean isnull=true;
        if (str ==null || str.equals("")) {
            isnull = true;
        }
        else {
            isnull=false;
        }
        return isnull;
    }


}
