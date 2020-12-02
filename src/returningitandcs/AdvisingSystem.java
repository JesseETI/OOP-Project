package returningitandcs;

import returningitandcs.Composite.Course;
import returningitandcs.Composite.StudentManager;
import returningitandcs.iterator.CIterator;
import returningitandcs.iterator.CourseCollection;


public class AdvisingSystem {
    CourseCollection collection;
    StudentManager studentManager;
    
    public AdvisingSystem() {
        collection = new CourseCollection();
    }
    
    public void createStudent(String major, int year, int sem) {
        Student newStudent = new Student(major, year, sem);
        studentManager.setStudent(newStudent);
    }
    
    public void addToCollection(Course c) {
        collection.addCourse(c);
    }
    
    /* get course from db
    check if student did course from db
        skip
    else 
        look at pre-req for said course in db
        check to see if completed courses contains said pre-req
    */
    public void suggestCourses() {
        CIterator iterator  = collection.createIterator();
        if (iterator.hasNext()) {
            Course currCourse = iterator.Next();
            
        }
    }
        
}
