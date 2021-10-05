package edu.progmatic.backend.MyUniversitySpring.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InfoSplitter {

    private static String regex = "\\|";
    private static String nullString = "NULL";

    public static List<String> splitRequirements(String requirements){

        if (requirements.equals(nullString)){
            return new ArrayList<>();
        }

        return Arrays.asList(requirements.split(regex));
    }


    public static List<Integer> splitSemesters(String semesters) {
        List<Integer> result = new ArrayList<>();
        List<String> parts = Arrays.asList(semesters.split(regex));
       parts.forEach(part ->result.add(Integer.parseInt(part)));

        return result;
    }
}
