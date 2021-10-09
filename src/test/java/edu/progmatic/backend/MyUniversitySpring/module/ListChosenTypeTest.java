package edu.progmatic.backend.MyUniversitySpring.module;

import edu.progmatic.backend.MyUniversitySpring.config.ConfigReader;
import edu.progmatic.backend.MyUniversitySpring.model.Course;
import edu.progmatic.backend.MyUniversitySpring.model.CourseType;
import edu.progmatic.backend.MyUniversitySpring.testHelper.CompareHelper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest // (classes = {ListChosenType.class, CourseHandler.class, ConfigReader.class})
class ListChosenTypeTest {

    @Autowired
    ListChosenType listChosenType;

    @Test
    public void findTypeInListTest(){

        Course course1 = new Course(new String[]{
                "történelem", "TÖR-271","Jelenkori magyar történelem 1.","K","5","3","NULL"});
        Course course2 = new Course(new String[]{
                "történelem", "TÖR-272", "Jelenkori magyar történelem 2.", "G", "5", "2", "TÖR-271"});
        Course course3 = new Course(new String[]{
                "magyar", "MNY16-221", "Kommunikáció szóban és írásban", "G", "2", "3", "XKO16-106"});

        List<Course> inputCourseList =  List.of(course1, course2, course3);

        List<Course> expectedCourseList =  List.of(course2, course3);  // G type

        Assertions.assertTrue(listChosenType.findTypeInList(inputCourseList, CourseType.EF).isEmpty());
        Assertions.assertTrue(CompareHelper.compareLists(expectedCourseList,
                                            listChosenType.findTypeInList(inputCourseList, CourseType.G)));
    }
}
