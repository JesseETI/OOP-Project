package returningitandcs.Composite;

import java.util.ArrayList;
import returningitandcs.Student;


public class StudentManager implements Course{
    
    ArrayList<Course> courses;
    Student student;
    
    public StudentManager() {
        courses = new ArrayList<Course>();
    }
    
    public void addCourse(Course c) {
        courses.add(c);
    }
    
    public void setStudent(Student s) {
        this.student = s;
    }
    
    
    public boolean requirementsMet() {
        //check if gpa too low
        return true;
    }

}
