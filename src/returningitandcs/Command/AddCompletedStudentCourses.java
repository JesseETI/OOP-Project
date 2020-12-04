package returningitandcs.Command;

import java.util.HashMap;
import returningitandcs.AdvisingSystem;
import returningitandcs.Course;


public class AddCompletedStudentCourses implements Command{
    
    AdvisingSystem advisingSystem;
    String courseCode;
    int courseGrade;
    
    public AddCompletedStudentCourses(AdvisingSystem advisingSystem, String courseCode, Integer grade) {
        this.advisingSystem = advisingSystem;
        this.courseCode = courseCode;
        this.courseGrade = grade;
    }
    
    public void execute() {
        advisingSystem.addCompletedStudentCourses(courseCode, courseGrade);
    }
    
}
