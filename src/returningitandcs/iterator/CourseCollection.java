
package returningitandcs.iterator;

import java.util.ArrayList;
import returningitandcs.Course;

public class CourseCollection implements CContainer{
    private ArrayList<Course> course = new ArrayList<Course>();

    public CIterator createIterator() {
        CourseIterator newIter = new CourseIterator();
        return newIter;
    }
    
    private class CourseIterator implements CIterator {
        
        private int currPos;
        
        public boolean hasNext() {
            if (currPos < course.size()) {
                return true;
            }
            return false;
        }
        
        public Course next() {
            if (this.hasNext()) {
                return course.get(currPos++);
            }
            return null;
        }
        
    }
    
    public void addCourse(Course c) {
        course.add(c);
    }
}
