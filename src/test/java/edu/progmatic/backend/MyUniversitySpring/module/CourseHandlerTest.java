
package edu.progmatic.backend.MyUniversitySpring.module;

import edu.progmatic.backend.MyUniversitySpring.model.Course;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
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

        assertTrue(compareMaps(expected, courseHandler.createMajors()));

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
/*

        for(Map.Entry<String,List<Course>> entry : expected.entrySet()) {
            if (!compareLists(entry.getValue(), actual.get(entry.getKey()))) {
                return false;
            }
        }
*/


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