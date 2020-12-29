package com.epam.ta.service;

import org.openqa.selenium.WebElement;

import java.util.List;

public class FindContains {
    public static boolean findMatches(String string, String format){
        return string.equals(format);
    }

    public static boolean findContains(String string, String searchedString){
        return string.contains(searchedString) ? true : false;
    }

    public static boolean findMatchesInList(List<WebElement> list, String format){
        boolean matches = false;
        for (int i = 0; i < list.size(); i++) {
            matches = list.get(i).equals(format);
        }
        return matches;
    }
}
