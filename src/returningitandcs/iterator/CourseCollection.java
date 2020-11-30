
package returningitandcs.iterator;

import java.util.HashMap;


public class CourseCollection implements CContainer{
    private HashMap<String, String> courses = new HashMap<String, String>();
    
    public CIterator createIterator() {
        CourseIterator newIter = new CourseIterator();
        return newIter;
    }
    
    private class CourseIterator implements CIterator {
        
        private int currPos;
        
        public boolean hasNext() {
            return true;
        }
        
        public Object Next() {
            return new Object();
        }
        
    }
}
