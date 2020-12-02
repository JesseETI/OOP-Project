package returningitandcs;

import returningitandcs.Command.RemoteControl;


public class ReturningITAndCS {
    
    public static void main(String[] args) {
       AdvisingSystem system = new AdvisingSystem();
       RemoteControl systemControl = new RemoteControl();
       Database db = new Database(system, systemControl);
       db.readDB();
       AdvisingPortal portal = new AdvisingPortal(system, systemControl);
       portal.setVisible(true);
    }
}
