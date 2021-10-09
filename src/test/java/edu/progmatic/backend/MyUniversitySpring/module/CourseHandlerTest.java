

package edu.progmatic.backend.MyUniversitySpring.module;

import edu.progmatic.backend.MyUniversitySpring.config.ConfigReader;
import edu.progmatic.backend.MyUniversitySpring.model.Course;
import edu.progmatic.backend.MyUniversitySpring.testHelper.CompareHelper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest//(classes = {CourseHandler.class, ConfigReader.class})
class CourseHandlerTest {
    @Autowired
    CourseHandler courseHandler;

    @Test
    public void createMajorsTest() {
        Map<String, List<Course>> expected = new HashMap<>();
        Course course1 = new Course(
                new String[]{
                        "informatikus könyvtáros",
                        "DIG-001",
                        "Digitális bölcsész kompetenciák",
                        "G",
                        "4",
                        "2",
                        "NULL"});

        Course course2 = new Course(new String[]{
                "informatikus könyvtáros",
                "IKT19-101",
                "Bevezetés a könyvtár- és információtudományba",
                "K",
                "1",
                "4",
                "NULL"});


        Course course3 = new Course(new String[]{
                "japán",
                "JAP-104",
                "Mai japán nyelvképzés 4.",
                "G",
                "2",
                "2",
                "JAP-101"});


        expected.put(course1.getMajor(), List.of(course1, course2));
        expected.put(course3.getMajor(), List.of(course3));

        assertTrue(CompareHelper.compareMajorMaps(expected, courseHandler.createMajors()));

    }
}