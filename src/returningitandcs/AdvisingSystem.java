package returningitandcs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import returningitandcs.iterator.CIterator;
import returningitandcs.iterator.CourseCollection;


public class AdvisingSystem {
    CourseCollection csDBCollection, itDBCollection, suggestedCollection;
    Student newStudent;
    
    public AdvisingSystem() {
        csDBCollection = new CourseCollection();
        itDBCollection = new CourseCollection();
        suggestedCollection =  new CourseCollection();
    }
    
    public void createStudent(String major, int year, int sem, double gpa) {
        newStudent = new Student(major, year, sem, gpa);
    }
    
    public void addCompletedStudentCourses(String courseCode, Integer currCourseGrade) {
        CIterator iterator;
        String degree = newStudent.getMajor();
           
        System.out.println(courseCode);
            
        if (degree.equals("Computer Science")) {
            iterator = csDBCollection.createIterator();
        }
        else {
            iterator = itDBCollection.createIterator();
        }     

        while (iterator.hasNext()) {    
            Course dbCourse = iterator.next();

            if (dbCourse.getCode().equals(courseCode)) {
                newStudent.addCourse(dbCourse, currCourseGrade);
                System.out.println("Course added");
            }
        }
        
    }
    
    public String getCourses() {
        CIterator iterator  = csDBCollection.createIterator();
        String s = "";
        while (iterator.hasNext()) {
            Course c = iterator.next();
            s+= c.getCode();
        }
        return s;
    }
    
    public void addToCSCourseCollection(Course c) {
        csDBCollection.addCourse(c);
    }
    
    public void addToITCourseCollection(Course c) {
        itDBCollection.addCourse(c);
    }
    
    public String[] filterCourseList(int year, int sem) {
        CIterator iterator;
        CourseCollection filteredCollection = new CourseCollection();
        ArrayList<String> courseList = new ArrayList<String>();
        
        if (newStudent.getMajor().equals("Computer Science")) {
            iterator = csDBCollection.createIterator();
            
            while (iterator.hasNext()) {
                Course prospectCourse = iterator.next();
                
                if (prospectCourse.getYear() == year && prospectCourse.getSem() == sem) {
                    filteredCollection.addCourse(prospectCourse);
                }
            }
        }    
        else if (newStudent.getMajor().equals("Information Technology")) {
            iterator = itDBCollection.createIterator();
            
            while (iterator.hasNext()) {
                Course prospectCourse = iterator.next();
                
                if (prospectCourse.getYear() == year && prospectCourse.getSem() == sem) {
                    filteredCollection.addCourse(prospectCourse);
                }
            }
        }
        else 
            return new String[]{"Error"};
        
        iterator = filteredCollection.createIterator();
        
        while (iterator.hasNext()) {
            Course c = iterator.next();
            courseList.add(c.getCode()); 
        }
        
        courseList.add("NON-DCIT COURSE");
        
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
    public String[] suggestCourses() {
        CIterator iterator;
        Double gpa = newStudent.getGPA();
        int year = newStudent.getYear();
        int sem = newStudent.getSem();
        String[] courseListArray;
        
        ArrayList<String> generatedCourseList = new ArrayList<String>();
        
        if (gpa < 2.00) {
            return new String[]{"GPA Too Low. Required to Withdraw"};
        }
        
        if (newStudent.getMajor().equals("Computer Science")) {
            iterator = csDBCollection.createIterator();
        }
        else if (newStudent.getMajor().equals("Information Technology")){
            iterator = itDBCollection.createIterator();
        }
        else {
            return new String[]{"Error"};
        }
        
        courseListArray = filterCourseList(year, sem);
        
        return courseListArray;
        
    }
        
}
