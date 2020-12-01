package returningitandcs;

public class AdvisingSystem {
    Student student;
    
    public AdvisingSystem() {
        
    }
    
    public void createStudent(String major, int year, int sem) {
        student = new Student(major, year, sem);
    }
}
