package com.universalelements.Utilities;

import com.sanctionco.jmail.EmailValidator;
import com.sanctionco.jmail.JMail;

public class Utilities {
    static final int MIN_LOGIN_LENGTH = 6;
    static final int MAX_LOGIN_LENGTH = 16; //Actually 30 but the client doesn't want that sadge
    static final int MIN_PASSWORD_LENGTH = 6;
    static final int MAX_PASSWORD_LENGTH = 16; //sadge again but users will use 123456 anyway xdd
    static final int MIN_SOCIAL_ID_LENGTH = 7;
    public static boolean isValidEmail(String email){
        EmailValidator validator = JMail.strictValidator();
        return validator.isValid(email);
    }
    public static boolean isValidCharDeletionCodeLow(String charDeletionCode){
        return !(charDeletionCode.length() < MIN_SOCIAL_ID_LENGTH);
    }

    public static boolean isValidCharDeletionCodeHigh(String charDeletionCode){
        return !(charDeletionCode.length() > MIN_SOCIAL_ID_LENGTH);
    }

    public static boolean isValidUserNameLow(String userName){
        return !(userName.length() < MIN_LOGIN_LENGTH);
    }

    public static boolean isValidUserNameHigh(String userName){
        return !(userName.length() > MAX_LOGIN_LENGTH);
    }
}
