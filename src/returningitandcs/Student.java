package returningitandcs;
import java.util.HashMap;
import java.util.Iterator;

public class Student {
    
    String major;
    int enrollYear, enrollSem;
    HashMap<String, Integer> courses;
    double gpa;
    
    public Student(String major, int enrollYear,int enrollSem) {
        this.major = major;
        this.enrollYear = enrollYear;
        this.enrollSem = enrollSem;
        courses = new HashMap<String, Integer>();
        courses.put("COMP3605", 90);
    }
    
    private void calculateGPA() {
        Iterator studentCourseIterator = courses.entrySet().iterator();
        
        while (studentCourseIterator.hasNext()) { 
            HashMap.Entry mapElement = (HashMap.Entry) studentCourseIterator.next(); 
            int grade = ((int) mapElement.getValue()); 
            System.out.println(mapElement.getKey() + " : " + grade); 
        } 
    }
    
    public static void main(String args[]) {
        Student s = new Student("Comp sci", 3, 2);
        s.calculateGPA();
    }
    
}
