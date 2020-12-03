package returningitandcs.Command;

import returningitandcs.AdvisingSystem;
import returningitandcs.Course;


public class CreateITDBCourseCommand implements Command{
    
    AdvisingSystem advisingSystem;
    Course newCourse;
    
    public CreateITDBCourseCommand(AdvisingSystem advisingSystem, Course newCourse) {
        this.advisingSystem = advisingSystem;
        this.newCourse = newCourse;
    }
    
    public void execute() {
        advisingSystem.addToITCourseCollection(newCourse);
    }
    
}
