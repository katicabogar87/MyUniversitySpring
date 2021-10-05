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

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class MostRequirementTest {

    @Autowired
    MostRequirement mostRequirement;

    public List<Course> getInputCourseList1(){
        Course course1 = new Course(new String[]{
                "történelem", "TÖR-271","Jelenkori magyar történelem 1.","K","5","3","NULL"});
        Course course2 = new Course(new String[]{
                "történelem", "TÖR-272", "Jelenkori magyar történelem 2.", "G", "5", "2", "NULL"});

        return  List.of(course1, course2);
    }
    public List<Course> getInputCourseList2(){

        Course course3 = new Course(new String[]{
                "magyar", "MNY16-221", "Kommunikáció szóban és írásban", "G", "2", "3", "XKO16-106"});
        Course course4 = new Course(new String[]{
                "magyar", "MNY19-264", "Magyar grammatika", "K", "3", "4", "MNY11-263|MNY19-265*"});

        return  List.of(course3, course4);
    }
    public List<Course> getInputCourseList3(){

        Course course5 = new Course(new String[]{
                "skandinavisztika", "SKD16-108", "Dán nyelv 2D", "G", "2", "2", "SKD-101|SKD-102|SKD16-103|SKD16-104"});
        Course course6 = new Course(new String[]{
                "skandinavisztika", "SKN16-108", "Norvég nyelv 2D", "G", "2", "2", "SKN-101|SKN-102|SKN16-103|SKN16-104"});

        return  List.of(course5, course6);
    }



    public Map<String, List<Course>> getInputMap(){

        List<Course> inputCourseList1 =  getInputCourseList1();
        List<Course> inputCourseList2 =  getInputCourseList2();
        List<Course> inputCourseList3 = getInputCourseList3();

        Map<String, List<Course>> inputMap= new HashMap<>();
        inputMap.put(getInputCourseList1().get(0).getMajor(), inputCourseList1);
        inputMap.put(getInputCourseList2().get(0).getMajor(), inputCourseList2);
        inputMap.put(getInputCourseList3().get(0).getMajor(), inputCourseList3);

        return inputMap;
    }

    @Test
    public void findMostRequirementCoursesTest(){

        List<Course> expected = getInputCourseList3();
        Assertions.assertTrue(compareCourseLists(expected, mostRequirement.findMostRequirementCourses(getInputMap())));

        Map<String, List<Course>> nullInputMap= new HashMap<>();
        Assertions.assertTrue(mostRequirement.findMostRequirementCourses(nullInputMap).isEmpty());


    }



    @Test
    public void maxSizeInMapTest(){

        Assertions.assertEquals(4, mostRequirement.maxSizeInMap(getInputMap()) );

        Map<String, List<Course>> nullInputMap= new HashMap<>();
        Assertions.assertEquals(-1, mostRequirement.maxSizeInMap(nullInputMap) );
    }


    @Test
    public void maxSizeInListTest(){

        Assertions.assertEquals(0, mostRequirement.getMaxSizeInList(getInputCourseList1()) );
        Assertions.assertEquals(2, mostRequirement.getMaxSizeInList(getInputCourseList2()) );
        Assertions.assertEquals(4, mostRequirement.getMaxSizeInList(getInputCourseList3()) );

        List<Course> nullInputList= new ArrayList<>();
        Assertions.assertEquals(-1, mostRequirement.getMaxSizeInList(nullInputList));
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



    public  boolean compareCourseLists(List <Course> expected, List <Course> actual){
        if(expected.size()!=actual.size()){return false;}

        for (int i = 0; i < expected.size(); i++) {
            if(!(compareCourses(expected.get(i), (actual.get(i))))){
                return false;
            }
        }
        return true;
    }

    public boolean compareCourses(Course expected, Course actual){
        return expected.getMajor().equals(actual.getMajor()) ||
                expected.getCourseName().equals(actual.getCourseName()) ||
                expected.getCourseCode().equals(actual.getCourseCode()) ||
                expected.getCourseType().equals(actual.getCourseType()) ||
                expected.getCredit() == actual.getCredit() ||
                compareLists(expected.getSemesteres(), actual.getSemesteres()) ||
                compareLists(expected.getRequirements(), actual.getRequirements());
    }



}