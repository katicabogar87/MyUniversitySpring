package edu.progmatic.backend.MyUniversitySpring.module;

import edu.progmatic.backend.MyUniversitySpring.config.ConfigReader;
import edu.progmatic.backend.MyUniversitySpring.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Service
public class CourseHandler {

    ConfigReader configReader;



    @Autowired
    public CourseHandler(ConfigReader configReader) {
        this.configReader = configReader;

    }

    @Bean
    public  Map<String, List<Course>> createMajors(){
        Map<String, List<Course>> majors = new HashMap<>();


        try (Stream<String> lines = Files.lines(configReader.getResource())) {
            lines.forEach(line -> {
                Course course = new Course(line.split(configReader.getCoursesSplitRegex()));
                majors.putIfAbsent(course.getMajor(), new ArrayList<>());
                majors.get(course.getMajor()).add(course);

            });
        } catch (NoSuchFileException e) {
            System.out.println("Error with file path!");
        } catch (IOException e) {
            System.out.println("Error with file!");
           // e.printStackTrace();
        }

        return majors;
    }
}
