/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package returningitandcs;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author sandman
 */
public class AdvisingSystemTest {
    
    public AdvisingSystemTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of createStudent method, of class AdvisingSystem.
     */
    @Test
    public void testCreateStudent() {
        System.out.println("createStudent");
        String major = "";
        int year = 0;
        int sem = 0;
        double gpa = 0.0;
        AdvisingSystem instance = new AdvisingSystem();
        instance.createStudent(major, year, sem, gpa);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addCompletedStudentCourses method, of class AdvisingSystem.
     */
    @Test
    public void testAddCompletedStudentCourses() {
        System.out.println("addCompletedStudentCourses");
        String courseCode = "";
        Integer currCourseGrade = null;
        AdvisingSystem instance = new AdvisingSystem();
        instance.addCompletedStudentCourses(courseCode, currCourseGrade);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCourses method, of class AdvisingSystem.
     */
    @Test
    public void testGetCourses() {
        System.out.println("getCourses");
        AdvisingSystem instance = new AdvisingSystem();
        String expResult = "";
        String result = instance.getCourses();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToCSCourseCollection method, of class AdvisingSystem.
     */
    @Test
    public void testAddToCSCourseCollection() {
        System.out.println("addToCSCourseCollection");
        Course c = null;
        AdvisingSystem instance = new AdvisingSystem();
        instance.addToCSCourseCollection(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToITCourseCollection method, of class AdvisingSystem.
     */
    @Test
    public void testAddToITCourseCollection() {
        System.out.println("addToITCourseCollection");
        Course c = null;
        AdvisingSystem instance = new AdvisingSystem();
        instance.addToITCourseCollection(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of filterCourseList method, of class AdvisingSystem.
     */
    @Test
    public void testFilterCourseList() {
        System.out.println("filterCourseList");
        int year = 0;
        int sem = 0;
        AdvisingSystem instance = new AdvisingSystem();
        String[] expResult = null;
        String[] result = instance.filterCourseList(year, sem);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of suggestCourses method, of class AdvisingSystem.
     */
    @Test
    public void testSuggestCourses() {
        System.out.println("suggestCourses");
        AdvisingSystem instance = new AdvisingSystem();
        String[] expResult = null;
        String[] result = instance.suggestCourses();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
