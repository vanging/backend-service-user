package com.vanging.www.user.util;

import java.util.regex.Pattern;

public class Validator
{
    private static String email = "^[a-z0-9A-Z_]([-_.]?[a-z0-9A-Z]+)*@[a-z0-9A-Z]([-]?[a-z0-9A-Z]+)?\\.[a-zA-Z]{2,}$";
    private static Pattern emailPattern = Pattern.compile(email);

    public static boolean email(String email)
    {
        return emailPattern.matcher(email).matches();
    }
}
