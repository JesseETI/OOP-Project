package returningitandcs;
import java.sql.*;
import returningitandcs.Composite.*;
import returningitandcs.iterator.*;

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
    static AdvisingSystem advisingSys;
    
    public Database(AdvisingSystem as) {
        advisingSys = as;
    }
    
    public static void main(String[] args) throws SQLException {

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
                String credit = myRs.getString("credit");
                String year = myRs.getString("year");
                String semester = myRs.getString("semester");
                String prerequisite = myRs.getString("prerequisite");

                //Display values
                System.out.print(", Code: " + code);
                System.out.print(", title: " + title);
                System.out.println(", type: " + type);
                System.out.println(", credit: " + credit);
                System.out.println(", year: " + year);
                System.out.println(", semester: " + semester);
                System.out.println(", prerequisite: " + prerequisite);
                
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
                
                //BasicCourse
                if (year == 1) {
                    AdvancedCourse newCourse = new AdvancedCourse(code, title, type, credit, year, semester);
                    advisingSys.addToCollection(newCourse);
                    System.out.println("Basic course added");
                }
                else {
                    //Advanced Course
                    
                    if (prerequisite.contains(",")) {
                    
                        String[] preqReqCourses = prerequisite.split(",");
                        newCourse.setPreReqType("AND");
                

                        for (String preReqCourse : preqReqCourses) {
                            sql = "SELECT id, code, title, type, credit, year, semester, prerequisite FROM `Information Technology` WHERE code = " + preReqCourse;
                            ResultSet preReqRs = myStmt.executeQuery(sql);
                            //Extract data from result set
                        }
                    }
                    
                }
                
            }
            myRs.close();
            
        }
        catch(SQLException e){  
            //JDBC Errors
            System.out.println("Error found: " + e);
       }
        catch(Exception e){
            //Handle errors for Class.forName
            System.out.println("Error found: " + e);   
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
