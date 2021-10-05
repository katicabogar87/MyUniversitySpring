package edu.progmatic.backend.MyUniversitySpring.module;

import edu.progmatic.backend.MyUniversitySpring.model.Course;
import edu.progmatic.backend.MyUniversitySpring.model.CourseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Írj metódust, amely két bemeneti paramétert kap: egy szakhoz tartozó tanegységek listáját és egy típust,
 * és visszaadja (adatszerkezetben) az összes olyan típusú tanegységet a bemeneti paraméterként kapott listából.*/

@Component
public class ListChosenType {

    CourseHandler courseHandler;

    public ListChosenType(@Autowired CourseHandler courseHandler){
        this.courseHandler=courseHandler;
    }

    public List<Course> findTypeInList(List<Course> inputList, CourseType courseType){
        List<Course> result = new ArrayList<>();

        for (Course currentCourse: inputList) {
            if(currentCourse.getCourseType().equals(courseType)){
                result.add(currentCourse);
            }
        }
        return  result;
    }
}
