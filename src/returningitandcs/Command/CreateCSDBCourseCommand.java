package returningitandcs.Command;

import returningitandcs.AdvisingSystem;
import returningitandcs.Course;


public class CreateCSDBCourseCommand implements Command{
    
    AdvisingSystem advisingSystem;
    Course newCourse;
    
    public CreateCSDBCourseCommand(AdvisingSystem advisingSystem, Course newCourse) {
        this.advisingSystem = advisingSystem;
        this.newCourse = newCourse;
    }
    
    public void execute() {
        advisingSystem.addToCSCourseCollection(newCourse);
    }
    
}
