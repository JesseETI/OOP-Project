package returningitandcs;

public class Course {
    
    String code, title, type, preRequisites;
    int credit, year, sem;
    
    public Course(String code, String title, String type, int credit, int year, int sem, String preRequisites) {
        this.code = code;
        this.title = title;
        this.type = type;
        this.credit = credit;
        this.year = year;
        this.sem = sem;
        this.preRequisites = preRequisites;
    }
    
    public String getCode() {
        return code;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getType() {
        return type;
    }
    
    public int getCredit() {
        return credit;
    }
    
    public int getYear() {
        return year;
    }
    
    public int getSem() {
        return sem;
    } 
    
    public String getPreRequisites() {
        return preRequisites;
    }
    
    public String toString() {
        String res = "Code: " + code + " title: " + title + " Preq: " + preRequisites;
        return res;
    }
    
}
