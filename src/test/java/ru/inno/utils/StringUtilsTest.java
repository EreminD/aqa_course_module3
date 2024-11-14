package ru.inno.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StringUtilsTest {
    @Test
    public void isBlankTrueForEmptyString(){
        StringUtils stringUtils = new StringUtils();
        assertTrue(stringUtils.isBlank(""));
    }

    @Test
    public void isBlankTrueForSpace(){
        StringUtils stringUtils = new StringUtils();
        assertTrue(stringUtils.isBlank(" "));
    }

    @Test
    public void isBlankTrueForManySpaces(){
        StringUtils stringUtils = new StringUtils();
        assertTrue(stringUtils.isBlank("              "));
    }

    @Test
    public void isBlankFalseForLineWithChar(){
        StringUtils stringUtils = new StringUtils();
        assertFalse(stringUtils.isBlank("       .       "));
    }
}
