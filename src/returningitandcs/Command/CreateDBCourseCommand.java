package returningitandcs.Command;

import returningitandcs.AdvisingSystem;
import returningitandcs.Course;


public class CreateDBCourseCommand implements Command{
    
    AdvisingSystem advisingSystem;
    Course newCourse;
    
    public CreateDBCourseCommand(AdvisingSystem advisingSystem, Course newCourse) {
        this.advisingSystem = advisingSystem;
        this.newCourse = newCourse;
    }
    
    public void execute() {
        advisingSystem.addToCourseCollection(newCourse);
    }
    
}
