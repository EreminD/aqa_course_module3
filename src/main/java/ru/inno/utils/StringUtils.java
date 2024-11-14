package ru.inno.utils;

public class StringUtils {
    // ""       -> true
    // " "      -> true
    // "   "    -> true
    // "  ."    -> false
    public boolean isBlank(String str){
        return str.trim().equals("");
    }

    // "test@"          -> false
    // "test@test"      -> false
    // "test.ru"        -> false
    // "test@test.ru"   -> true
    public boolean isValidEmail(String str){
        return true;
    }
}
