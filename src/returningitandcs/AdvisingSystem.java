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
    }
    
    public void createStudent(String major, int year, int sem, double gpa) {
        newStudent = new Student(major, year, sem, gpa);
    }
    
    public void addCompletedStudentCourses(String courseCode, int grade) {
        CIterator iterator;
        String degree = newStudent.getMajor();
        
        if (degree.equals("Computer Science")) {
            iterator = csDBCollection.createIterator();
            
            while (iterator.hasNext()) {
                Course compCourse = iterator.next();
                
                if (compCourse.getCode() == courseCode) {
                    newStudent.addCourse(compCourse, grade);
                }
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
    public CourseCollection getSuggestedCourses() {
        CIterator iterator  = csDBCollection.createIterator();
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
