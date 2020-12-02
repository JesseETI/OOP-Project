/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package returningitandcs.Composite;

/**
 *
 * @author sandman
 */
public class BeginnerCourse implements Course{
    
    private String code, title, type;
    private int credit, year, semester;
    
    public BeginnerCourse(String code, String title, String type, int credit, int year, int semester) {
        this.code = code;
        this.title = title;
        this.type = type;
        this.credit = credit;
        this.year = year;
        this.semester = semester;
    }
    
    public boolean requirementsMet() {
       //if gpa too low 
       return true;
    }
    
    
    
    
}