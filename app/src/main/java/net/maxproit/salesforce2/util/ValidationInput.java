package net.maxproit.salesforce2.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Rezwan Khan Chowdhury on 4/12/18.
 */

public class ValidationInput {
    private static final String EMAIL_EXPRATION = "^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    public static boolean isValidEmailId(String email) {
        Pattern p = Pattern.compile(EMAIL_EXPRATION);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
