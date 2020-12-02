package returningitandcs;

import returningitandcs.Composite.Course;
import returningitandcs.Composite.StudentManager;
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
    
}
