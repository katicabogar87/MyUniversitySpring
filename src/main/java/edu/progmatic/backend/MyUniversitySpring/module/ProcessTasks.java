package edu.progmatic.backend.MyUniversitySpring.module;

import edu.progmatic.backend.MyUniversitySpring.model.Course;
import edu.progmatic.backend.MyUniversitySpring.model.CourseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ProcessTasks {

    Map<String, List<Course>> majors;
    NoRequirements noRequirements;
    ListChosenType listChosenType;
    MostRequirement mostRequirement;

    @Autowired
    public ProcessTasks(  Map<String, List<Course>> majors,
                          NoRequirements noRequirements,
                          ListChosenType listChosenType,
                          MostRequirement mostRequirement){
    this.majors = majors;
    this.noRequirements = noRequirements;
    this.listChosenType = listChosenType;
    this.mostRequirement = mostRequirement;

    runAllTasks();
    }


    public void runAllTasks(){
        System.out.println("--------------task 2.------------------");
        //noRequirements.createCoursesNoRequirement(majors);
        //System.out.println(noRequirements.createCoursesNoRequirement(majors).entrySet());
        System.out.println(noRequirements.createCoursesNoRequirement(majors).entrySet());

        System.out.println("--------------task 3.------------------");
        //listChosenType.findTypeInList((List<Course>) majors.keySet().toArray()[1], CourseType.G);
        String key = (String) majors.keySet().toArray()[0];
        System.out.println(key);
        System.out.println(listChosenType.findTypeInList(majors.get(key), CourseType.G));

        System.out.println("--------------task 4.------------------");
        //mostRequirement.findMostRequirementCourses(majors);
        System.out.println(mostRequirement.findMostRequirementCourses(majors));
    }
}
