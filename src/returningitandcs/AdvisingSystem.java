package returningitandcs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import returningitandcs.iterator.CIterator;
import returningitandcs.iterator.CourseCollection;


public class AdvisingSystem {
    CourseCollection dbCollection, suggestedCollection;
    Student newStudent;
    
    public AdvisingSystem() {
        dbCollection = new CourseCollection();
    }
    
    public void createStudent(String major, int year, int sem, double gpa) {
        newStudent = new Student(major, year, sem, gpa);
    }
    
    public void addCompletedStudentCourses(Course c, int grade) {
        newStudent.addCourse(c, grade);
    }
    
    public String getCourses() {
        CIterator iterator  = dbCollection.createIterator();
        String s = "";
        while (iterator.hasNext()) {
            Course c = iterator.next();
            s+= c.getCode();
        }
        return s;
    }
    
    public void addToCourseCollection(Course c) {
        dbCollection.addCourse(c);
    }
    
    public String[] filterCourseList(int year, int sem) {
        CIterator iterator  = dbCollection.createIterator();
        ArrayList<String> courseList = new ArrayList<String>();
        
        
        while (iterator.hasNext()) {
            Course c = iterator.next();
            
            if (c.getYear() == year && c.getSem() == sem) {
                courseList.add(c.getCode());
            }
        }
        
        String[] courseListArray = new String[courseList.size()];
        
        int count = 0;
        for (String course: courseList) {
            courseListArray[count] = course;
            count++;
        }
        
        return courseListArray;
    }
    
    /* get course from db
    check if student did course from db
        skip
    else 
        look at pre-req for said course in db
        check to see if completed courses contains said pre-req
    */
    public CourseCollection getSuggestedCourses() {
        CIterator iterator  = dbCollection.createIterator();
        Double gpa = newStudent.getGPA();
        HashMap<Course, Integer> studentCourseList = newStudent.getCourseList();
        
        if (gpa < 2.00) {
            return null;
        }

        while (iterator.hasNext()) {
            Course currDBCourse = iterator.next();
            
            for (int i = 0; i < studentCourseList.size(); i++) {
                HashMap.Entry mapElement = (HashMap.Entry) studentCourseList;
                Course currStudentCourse = (Course) mapElement.getValue();
                String currCourseCode = currStudentCourse.getCode();
                
                if (!currDBCourse.getCode().equals(currCourseCode)) {
                    
                    for (int j = 0; j < studentCourseList.size(); j++) {
                        mapElement = (HashMap.Entry) studentCourseList;
                        currStudentCourse = (Course) mapElement.getValue();
                        
                        if (currStudentCourse.getPreRequisites().contains(currDBCourse.getCode())) {
                            suggestedCollection.addCourse(currDBCourse);
                        }
                        
                    } 
                    
                }
            }
        }
        return suggestedCollection;
    }
        
}
