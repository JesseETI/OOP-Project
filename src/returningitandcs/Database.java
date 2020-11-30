package returningitandcs;
import java.sql.*;

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
    
    public static void main(String[] args) throws SQLException {

    Connection myConn = null;
    Statement myStmt = null;
    ResultSet myRs = null;

    String user = "root";
    String pass = "";

    try {
        // 1. Get a connection to database
        myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/", user, pass);
        System.out.println("Connected to database successfully");

    } 
    catch (Exception e) {
        System.out.println("Failed to connect to database. Error: " + e);
    }
}    
    
}
