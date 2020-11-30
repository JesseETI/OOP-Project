/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package returningitandcs.Composite;

import java.util.ArrayList;

/**
 *
 * @author sandman
 */
public class AdvancedCourse implements Course{
    
    ArrayList<Course> courses = new ArrayList<Course>();
    
    public void addCourse(Course c) {
        courses.add(c);
    }
    
    public boolean accessCourse() {
        return true;
    }
    
}
