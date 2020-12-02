package returningitandcs;


public class AdvisingApplication {
    
    public static void main(String[] args) {
       AdvisingSystem system = new AdvisingSystem();
       //for student data
       AdvisingPortal portal = new AdvisingPortal(system);
       //for course data
       Database db = new Database(system);
       portal.setVisible(true);
    }
}
