package returningitandcs;


public class AdvisingApplication {
    
    public static void main(String[] args) {
       AdvisingSystem system = new AdvisingSystem();
       AdvisingPortal portal = new AdvisingPortal(system);
       portal.setVisible(true);
    }
}
