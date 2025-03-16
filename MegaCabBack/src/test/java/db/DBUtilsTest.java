/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package db;

import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Administrator
 */
public class DBUtilsTest {
    
    public DBUtilsTest() {
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
     * Test of getUsers method, of class DBUtils.
     */
    @Test
    public void testGetUsers() {
        System.out.println("getUsers");
        DBUtils instance = new DBUtils();
        List<User> expResult = null;
        List<User> result = instance.getUsers();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUser method, of class DBUtils.
     */
    @Test
    public void testAddUser() {
        System.out.println("addUser");
        User user = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addUser(user);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of validateUserLogin method, of class DBUtils.
     */
    @Test
    public void testValidateUserLogin() {
        System.out.println("validateUserLogin");
        String username = "";
        int password = 0;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.validateUserLogin(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserType method, of class DBUtils.
     */
    @Test
    public void testGetUserType() {
        System.out.println("getUserType");
        String username = "";
        DBUtils instance = new DBUtils();
        String expResult = "";
        String result = instance.getUserType(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBookings method, of class DBUtils.
     */
    @Test
    public void testGetBookings() {
        System.out.println("getBookings");
        DBUtils instance = new DBUtils();
        List<Booking> expResult = null;
        List<Booking> result = instance.getBookings();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBooking method, of class DBUtils.
     */
    @Test
    public void testAddBooking() {
        System.out.println("addBooking");
        Booking booking = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addBooking(booking);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBills method, of class DBUtils.
     */
    @Test
    public void testGetBills() {
        System.out.println("getBills");
        DBUtils instance = new DBUtils();
        List<Bill> expResult = null;
        List<Bill> result = instance.getBills();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addBill method, of class DBUtils.
     */
    @Test
    public void testAddBill() {
        System.out.println("addBill");
        Bill bill = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addBill(bill);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getVehicles method, of class DBUtils.
     */
    @Test
    public void testGetVehicles() {
        System.out.println("getVehicles");
        DBUtils instance = new DBUtils();
        List<Vehicle> expResult = null;
        List<Vehicle> result = instance.getVehicles();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addVehicle method, of class DBUtils.
     */
    @Test
    public void testAddVehicle() {
        System.out.println("addVehicle");
        Vehicle vehicle = null;
        DBUtils instance = new DBUtils();
        boolean expResult = false;
        boolean result = instance.addVehicle(vehicle);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
