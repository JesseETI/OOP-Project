/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package returningitandcs.Command;

import returningitandcs.AdvisingSystem;

/**
 *
 * @author sandman
 */
public class SuggestRecommendedCoursesCommand implements Command{
    AdvisingSystem advisingSystem;
    String major;
    int year, sem;
    double gpa;
    
    public SuggestRecommendedCoursesCommand(AdvisingSystem advisingSystem) {
        this.advisingSystem = advisingSystem;
    }
    
    public void execute() {
        advisingSystem.suggestCourses();
    }

}
