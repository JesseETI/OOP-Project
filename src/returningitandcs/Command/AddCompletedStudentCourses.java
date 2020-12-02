package returningitandcs.Command;

import returningitandcs.AdvisingSystem;
import returningitandcs.Course;


public class AddCompletedStudentCourses implements Command{
    
    AdvisingSystem advisingSystem;
    Course newCourse;
    int grade;
    
    public AddCompletedStudentCourses(AdvisingSystem advisingSystem, Course newCourse, int grade) {
        this.advisingSystem = advisingSystem;
        this.newCourse = newCourse;
        this.grade = grade;
    }
    
    public void execute() {
        advisingSystem.addCompletedStudentCourses(newCourse, grade);
    }
    
}
