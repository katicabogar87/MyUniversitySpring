package edu.progmatic.backend.MyUniversitySpring;

import edu.progmatic.backend.MyUniversitySpring.model.Course;
import edu.progmatic.backend.MyUniversitySpring.model.CourseType;
import edu.progmatic.backend.MyUniversitySpring.module.CourseHandler;
import edu.progmatic.backend.MyUniversitySpring.module.ProcessTasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class MyUniversitySpringApplication {
	private static CourseHandler courseHandler;
	private static Map<String, List< Course >> majors;
	private static ProcessTasks processTasks;

	public MyUniversitySpringApplication(
					@Autowired CourseHandler courseHandler,
					@Autowired ProcessTasks processTasks,
					@Qualifier("createMajors") Map< String, List < Course >> majors) {
		MyUniversitySpringApplication.courseHandler = courseHandler;
		MyUniversitySpringApplication.processTasks = processTasks;
		MyUniversitySpringApplication.majors = majors;
	}

	@Autowired
	public static void main(String[] args) {
		SpringApplication.run(MyUniversitySpringApplication.class, args);

		//MyUniversitySpringApplication app = new MyUniversitySpringApplication(courseHandler, processTasks, majors );

		//System.out.println(majors.size());

		//processTasks.runAllTasks();



	}


}
