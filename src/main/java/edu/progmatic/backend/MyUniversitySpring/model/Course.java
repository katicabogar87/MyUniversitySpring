package edu.progmatic.backend.MyUniversitySpring.model;

import edu.progmatic.backend.MyUniversitySpring.util.InfoSplitter;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

public class Course {
    @Getter @Setter
    private String major;
    @Getter @Setter
    private String courseCode;
    @Getter @Setter
    private String courseName;
    @Getter @Setter
    private CourseType courseType;
    @Getter @Setter
    private List<Integer> semesteres;
    @Getter @Setter
    private int credit;
    @Getter @Setter
    private List<String> requirements;

   // public Course() {    }

    public Course(String[] parts){
       major = parts[0];
       courseCode = parts[1];
       courseName = parts[2];
       courseType = CourseType.valueOf(parts[3]);
       semesteres = InfoSplitter.splitSemesters(parts[4]);
       credit = Integer.parseInt(parts[5]);
       requirements = InfoSplitter.splitRequirements(parts[6]);
    }

    @Override
    public String toString() {
        return this.getCourseName() + " " + this.getCourseCode() + "\n";
    }
}
