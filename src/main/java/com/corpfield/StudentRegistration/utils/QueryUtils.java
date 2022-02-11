package com.corpfield.StudentRegistration.utils;

public class QueryUtils {

    public static String ConvertObjToString(Object object) {
        if (object == null) {
            return "";
        } else {
            return String.valueOf(object);
        }
    }
}
