package edu.progmatic.backend.MyUniversitySpring.testHelper;

import edu.progmatic.backend.MyUniversitySpring.model.Course;

import java.util.List;
import java.util.Map;

public class CompareHelper {

    public static boolean compareMajorMaps(Map<String, List<Course>> expected, Map<String, List<Course>> actual) {

        if (expected.size() != actual.size()) {
            System.out.println(expected.size());
            System.out.println(actual.size());
            return false;
        }

        for (int i = 0; i < expected.keySet().size(); i++) {
            {
                if (!expected.keySet().toArray()[i].equals(actual.keySet().toArray()[i])) {
                    System.out.println(expected.keySet().toArray()[i]);
                    System.out.println(actual.keySet().toArray()[i]);

                    return false;
                }
            }
        }

        for(Map.Entry<String,List<Course>> entry : expected.entrySet()) {
            if (!CompareHelper.compareCourseLists(entry.getValue(), actual.get(entry.getKey()))) {
                return false;
            }
        }



        return true;
    }

    public static boolean compareCourseLists(List <Course> expected, List <Course> actual){
        if(expected.size()!=actual.size()){return false;}

        for (int i = 0; i < expected.size(); i++) {
            if(!(compareCourses(expected.get(i), (actual.get(i))))){
                return false;
            }
        }
        return true;
    }

    public static boolean compareCourses(Course expected, Course actual){
        return expected.getMajor().equals(actual.getMajor()) ||
                expected.getCourseName().equals(actual.getCourseName()) ||
                expected.getCourseCode().equals(actual.getCourseCode()) ||
                expected.getCourseType().equals(actual.getCourseType()) ||
                expected.getCredit() == actual.getCredit() ||
                compareLists(expected.getSemesteres(), actual.getSemesteres()) ||
                compareLists(expected.getRequirements(), actual.getRequirements());
    }

    public static <T> boolean compareLists(List<T> expected, List <T> actual){
        if(expected.size()!=actual.size()){return false;}

        for (int i = 0; i < expected.size(); i++) {
            if(!expected.get(i).equals(actual.get(i))){
                return false;
            }
        }
        return true;

    }
}
