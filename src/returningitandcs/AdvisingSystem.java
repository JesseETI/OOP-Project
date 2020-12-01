package returningitandcs;

public class AdvisingSystem {
    Student student;
    
    public AdvisingSystem() { 
    }
    
    public boolean createStudent(String major, int year, int sem) {
        try {
            student.setMajor(major);
            student.setYear(year);
            student.setSem(sem);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }
}
