package edu.progmatic.backend.MyUniversitySpring.module;

import edu.progmatic.backend.MyUniversitySpring.model.Course;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
class NoRequirementsTest {

    @Autowired NoRequirements noRequirements;

    @Test
    public void createCoursesNoRequirementTest(){

        Course course1 = new Course(new String[]{
                "történelem", "TÖR-271","Jelenkori magyar történelem 1.","K","5","3","NULL"});
        Course course2 = new Course(new String[]{
                "történelem", "TÖR-272", "Jelenkori magyar történelem 2.", "G", "5", "2", "TÖR-271"});
        Course course3 = new Course(new String[]{
                "magyar", "MNY16-221", "Kommunikáció szóban és írásban", "G", "2", "3", "XKO16-106"});
        Course course4 = new Course(new String[]{
                "magyar", "MNY11-233", "Finnugrisztika", "G", "2","3","NULL"});
        Course course5 = new Course(new String[]{
                "magyar","MNY11-200","Helyesírás (alapvizsga","V","1","0","NULL"});

        List<Course> inputCourseList1 =  List.of(course1, course2);
        List<Course> inputCourseList2 =  List.of(course3, course4, course5);

        List<Course> expectedCourseList1 =  List.of(course1);
        List<Course> expectedCourseList2 =  List.of(course4, course5);

        Map<String, List<Course>> inputMap= new HashMap<>();
        inputMap.put(course1.getMajor(), inputCourseList1);
        inputMap.put(course3.getMajor(), inputCourseList2);

        Map<String, List<Course>> expectedMap= new HashMap<>();
        expectedMap.put(course1.getMajor(), expectedCourseList1);
        expectedMap.put(course4.getMajor(), expectedCourseList2);


        Assertions.assertTrue(compareMaps(expectedMap, noRequirements.createCoursesNoRequirement(inputMap)));



    }

    public boolean compareMaps(Map<String, List<Course>> expected, Map<String, List<Course>> actual) {

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

        return true;
    }

    public <T> boolean compareLists(List <T> expected, List <T> actual){
        if(expected.size()!=actual.size()){return false;}

        for (int i = 0; i < expected.size(); i++) {
            if(!expected.get(i).equals(actual.get(i))){
                return false;
            }
        }
        return true;
    }


}