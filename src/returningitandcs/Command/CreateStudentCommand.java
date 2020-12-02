package returningitandcs.Command;

import returningitandcs.AdvisingSystem;

public class CreateStudentCommand implements Command{
    
    AdvisingSystem advisingSystem;
    String major;
    int year, sem;
    double gpa;
    
    public CreateStudentCommand(AdvisingSystem advisingSystem, String major, int year, int sem, double gpa) {
        this.advisingSystem = advisingSystem;
        this.major = major;
        this.year = year;
        this.sem = sem;
        this.gpa = gpa;
    }
    
    public void execute() {
        advisingSystem.createStudent(major, year, sem, gpa);
    }
    
}
