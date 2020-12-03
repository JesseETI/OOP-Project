package returningitandcs.Command;

import returningitandcs.AdvisingSystem;
import returningitandcs.Course;


public class AddCompletedStudentCourses implements Command{
    
    AdvisingSystem advisingSystem;
    String courseCode;
    int grade;
    
    public AddCompletedStudentCourses(AdvisingSystem advisingSystem, String courseCode, int grade) {
        this.advisingSystem = advisingSystem;
        this.courseCode = courseCode;
        this.grade = grade;
    }
    
    public void execute() {
        advisingSystem.addCompletedStudentCourses(courseCode, grade);
    }
    
}
