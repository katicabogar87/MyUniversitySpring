package edu.progmatic.backend.MyUniversitySpring.module;

import edu.progmatic.backend.MyUniversitySpring.model.Course;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
/**
 * Írj metódust, amely visszaadja az összes legtöbb előfeltétellel rendelkező tanegységeket
 */


@Component
public class MostRequirement {

    public List<Course> findMostRequirementCourses(Map<String, List<Course>> inputMap) {
        int maxSize = maxSizeInMap(inputMap);
        if (maxSize != -1) {

            List<Course> result = new ArrayList<>();
            for (int i = 0; i < inputMap.size(); i++) {
                List<Course> courseList = inputMap.get(inputMap.keySet().toArray()[i]);

                for (int j = 0; j < courseList.size(); j++) {

                    if (courseList.get(j).getRequirements().size() == maxSize) {
                        result.add(courseList.get(j));
                    }
                }
            }
            return result;
        }
        return new ArrayList<>();
    }

    public int maxSizeInMap(Map<String, List<Course>> inputMap) {
        if(inputMap.isEmpty()){return -1;}
        int maxSize = 0;
        for (int i = 0; i < inputMap.size(); i++) {
            List<Course> courseList = inputMap.get(inputMap.keySet().toArray()[i]);
            maxSize = getMaxSizeInList(courseList);
        }

        return maxSize;
    }

    public int getMaxSizeInList(List<Course> courseList) {
        if(courseList.isEmpty()){return -1;}
        int maxSize=0;
        for (Course currentCourse : courseList) {
            if (currentCourse.getRequirements().size() > maxSize) {
                maxSize = currentCourse.getRequirements().size();
            }
        }
        return maxSize;
    }
}
