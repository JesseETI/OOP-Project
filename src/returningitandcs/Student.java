package returningitandcs;
import java.util.HashMap;
import java.util.Iterator;

public class Student {
    
    private String major;
    private int enrollYear, enrollSem;
    private HashMap<Course, Integer> completedCourses;
    private Iterator studentCourseIterator;
    private double gpa;
    
    public Student(String major, int enrollYear,int enrollSem, double gpa) {
        this.major = major;
        this.enrollYear = enrollYear;
        this.enrollSem = enrollSem;
        this.gpa = gpa;
        completedCourses = new HashMap<Course, Integer>();
        this.studentCourseIterator = completedCourses.entrySet().iterator();
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
    
    public int getSem() {
        return this.enrollSem;
    }
    
    public double getGPA() {
        return this.gpa;
    }
    
    public void addCourse(Course c, int grade) {
        completedCourses.put(c, grade);
    }
    
    public HashMap<Course, Integer> getCourseList() {
        return completedCourses;
    }
    
    public Iterator getIterator() {
        return studentCourseIterator;
    }
    
    /*
    public static void main(String args[]) {
        Student s = new Student("Comp sci", 3, 2);
        s.calculateGPA();
    }
    */
    
}
