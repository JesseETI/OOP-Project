package returningitandcs.Composite;

import java.util.ArrayList;
import returningitandcs.Student;


public class StudentManager implements Course{
    
    ArrayList<Course> completedCourses;
    ArrayList<Course> suggestedCourses;
    Student student;
    
    public StudentManager() {
        completedCourses = new ArrayList<Course>();
    }
    
    public void setStudent(Student s) {
        this.student = s;
    }
    
    public int getCredits() {
        
        int totalCreditHrs = 0;
        
        for (Course c : completedCourses) {
            totalCreditHrs+= c.getCredits();
        }
        return totalCreditHrs;
    }
    
    public String toString() {
        String res = "\n\nPAST COURSES\n\n";
        
        for (Course c: completedCourses) {
            res += c.toString();
        }
        
        res += "\n\nSUGGESTED COURSES\n\n";
        
        for (Course c: suggestedCourses) {
            res += c.toString();
        }
        
        return res;
    }
    

    public void setSuggestedCourses(ArrayList<Course> courses) {
        suggestedCourses = courses;
    }
    
}
