package returningitandcs;
import java.util.HashMap;
import java.util.Iterator;

public class Student {
    
    private String major;
    private int enrollYear, enrollSem;
    private HashMap<String, Integer> courses;
    private double gpa;
    
    public Student(String major, int enrollYear,int enrollSem) {
        this.major = major;
        this.enrollYear = enrollYear;
        this.enrollSem = enrollSem;
        courses = new HashMap<String, Integer>();
        courses.put("COMP3605", 90);
    }
    
    public void setMajor(String major) {
        this.major = major;
    }
    
    public void setYear(int year) {
        this.enrollYear = year;
    }
    
    public void setSem(int sem) {
        this.enrollSem = sem;
    }
    
    public String getMajor() {
        return this.major;
    }
    
    public int getYear() {
        return this.enrollYear;
    }
    
    public String getSem() {
        return this.enrollSem;
    }
    
    private void calculateGPA() {
        Iterator studentCourseIterator = courses.entrySet().iterator();
        
        while (studentCourseIterator.hasNext()) { 
            HashMap.Entry mapElement = (HashMap.Entry) studentCourseIterator.next(); 
            int grade = ((int) mapElement.getValue()); 
            System.out.println(mapElement.getKey() + " : " + grade); 
        } 
    }
    
    /*
    public static void main(String args[]) {
        Student s = new Student("Comp sci", 3, 2);
        s.calculateGPA();
    }
    */
    
}
