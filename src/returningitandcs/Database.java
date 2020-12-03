package returningitandcs;
import java.sql.*;
import returningitandcs.Command.Command;
import returningitandcs.Command.CreateCSDBCourseCommand;
import returningitandcs.Command.CreateITDBCourseCommand;
import returningitandcs.Command.RemoteControl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author sandman
 */
public class Database {
    public AdvisingSystem advisingSystem;
    public RemoteControl systemControl;
    
    public Database(AdvisingSystem advisingSystem, RemoteControl systemControl) {
        this.advisingSystem = advisingSystem;
        this.systemControl = systemControl;
    }
    
    public void readDB() {

        Connection myConn = null;
        Statement myStmt = null;
        ResultSet myRs = null;

        String user = "root";
        String pass = "";

        try {
            // Get a connection to database
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/courseDB", user, pass);
            System.out.println("Connected to database successfully");

            System.out.println("Creating statement...");
            myStmt = myConn.createStatement();
            
            System.out.println("\n\n COMP SCI DB \n\n");
            
            String sql = "SELECT id, code, title, type, credit, year, semester, prerequisite FROM `Computer Science`";
            myRs = myStmt.executeQuery(sql);

            //Extract data from result set
            while(myRs.next()){
                //Retrieve by column name
                String code = myRs.getString("code");
                String title = myRs.getString("title");
                String type = myRs.getString("type");
                int credit = Integer.parseInt(myRs.getString("credit"));
                int year = Integer.parseInt(myRs.getString("year"));
                int semester = Integer.parseInt(myRs.getString("semester"));
                String prerequisite = myRs.getString("prerequisite");

               Course newCSCourse = new Course(code, title, type, credit, year, semester, prerequisite);
               System.out.println(newCSCourse.toString());
               Command createCSDBCourse = new CreateCSDBCourseCommand(advisingSystem, newCSCourse);
               systemControl.setCommand(createCSDBCourse);
               systemControl.pressButton();
                
            }
            myRs.close();
            
            sql = "SELECT id, code, title, type, credit, year, semester, prerequisite FROM `Information Technology`";
            myRs = myStmt.executeQuery(sql);
            
            System.out.println("\n\n INFO TECH DB \n\n");
            
            //Extract data from result set
            while(myRs.next()){
                //Retrieve by column name
                String code = myRs.getString("code");
                String title = myRs.getString("title");
                String type = myRs.getString("type");
                int credit = Integer.parseInt(myRs.getString("credit"));
                int year = Integer.parseInt(myRs.getString("year"));
                int semester = Integer.parseInt(myRs.getString("semester"));
                String prerequisite = myRs.getString("prerequisite");
                
               Course newITCourse = new Course(code, title, type, credit, year, semester, prerequisite);
               System.out.println(newITCourse.toString());
               Command createITDBCourse = new CreateITDBCourseCommand(advisingSystem, newITCourse);
               systemControl.setCommand(createITDBCourse);
               systemControl.pressButton();
            }
            myRs.close();
            
        }
        catch(SQLException e){  
            //JDBC Errors
            System.out.println("SQL Error found: " + e);
       }

       finally {
            //finally block used to close resources
            try {
                if(myStmt != null)
                myConn.close();
            }
            catch(SQLException e){
                System.out.println("Error found: " + e);
            }//end finally try

            try{
                if(myConn != null)
                    myConn.close();
            }
            catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }
    
    }    
    
}
