package edu.progmatic.backend.MyUniversitySpring.module;

import edu.progmatic.backend.MyUniversitySpring.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Írj metódust, amely visszaadja (adatszerkezetben) azokat a tanegységeket, amelyeknek nincs semmilyen előfeltétele.*/
@Component
public class NoRequirements {
    
    CourseHandler courseHandler;
    
    public NoRequirements(@Autowired CourseHandler courseHandler){
        this.courseHandler=courseHandler;
    }


    //@Bean
    public  Map<String, List<Course>> createCoursesNoRequirement(Map< String, List < Course >> majorsMap){
        Map<String, List<Course>> result = new HashMap<>();

        for (int i = 0; i < majorsMap.size(); i++) {
            List<Course> courseList =  majorsMap.get(majorsMap.keySet().toArray()[i]);

            for (int j = 0; j < courseList.size(); j++) {

                if (courseList.get(j).getRequirements().isEmpty()) {
                    String majorName = courseList.get(j).getMajor();
                    result.putIfAbsent(majorName, new ArrayList<>());
                    result.get(majorName).add(courseList.get(j));
                }

            }
            //TODO az alábbi kódrészlet nem alkalmazható: a majors Map-re a forEach nem engedélyezett -> miért?
        /*for (Map.Entry<String, List < Course >> entry : majors) {
            String key = entry.getKey();
            List<Course> value = entry.getValue();

            for (int i = 0; i < value.size(); i++) {
                if (value.get(i).getRequirements().isEmpty()) {
                    String majorName = value.get(i).getMajor();
                    result.putIfAbsent(majorName, new ArrayList<>());
                    result.get(majorName).add(value.get(i));
                }
            }*/
        }
        return result;
    }


    

}

