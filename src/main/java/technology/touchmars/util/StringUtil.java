package technology.touchmars.util;

import technology.touchmars.model.WalletType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {
    public static final String EMAIL_REGEXP =
            "^[_A-Za-z0-9-]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public static final String PHONE_REGEXP = "\\+?^[0-9\\-]*$";

    public static boolean isValidEmail(String email){
        if (email==null)
            return false;
        Pattern pattern = Pattern.compile(EMAIL_REGEXP);
        Matcher m = pattern.matcher(email.trim());
        return m.matches();
    }

    public static boolean isValidPhone(String phone){
        if (phone==null)
            return false;
        Pattern pattern = Pattern.compile(PHONE_REGEXP);
        Matcher m = pattern.matcher(phone.trim());
        return m.matches();
    }

    public static boolean notEmpty(String s) {
        return s!=null && s.trim().length()>0;
    }

    public static WalletType convertString2WalletType(String s) {
        if (s==null)
            return null;
        if (s.equals(WalletType.PAYPAL.name()))
            return WalletType.PAYPAL;
        else if (s.equals(WalletType.VENMO.name()))
            return WalletType.VENMO;
        else
            return null;
    }

}
