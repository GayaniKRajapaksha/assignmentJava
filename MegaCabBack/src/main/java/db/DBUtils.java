/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package db;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import db.Booking;
/**
 *
 * @author Administrator
 */
public class DBUtils {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/mega"; 
    private static final String USER = "root";
    private static final String PASS = "";

    // Load MySQL driver (Optional but good practice)
    static {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // Method to get all users
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM user"; // Ensure 'user' table has the correct columns
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    User user = new User();
                    user.setUserID(rs.getInt("UserID"));
                    user.setNic(rs.getInt("nic"));
                    user.setName(rs.getString("name"));
                    user.setUserType(rs.getString("userType"));
                    user.setUsername(rs.getString("Username"));
                    user.setPassword(rs.getInt("password"));
                    users.add(user);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Method to add a user
    public boolean addUser(User user) {
        boolean isAdded = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO user (nic, name, userType, Username, password) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, user.getNic());
                stmt.setString(2, user.getName());
                stmt.setString(3, user.getUserType());
                stmt.setString(4, user.getUsername());
                stmt.setInt(5, user.getPassword());
                int rows = stmt.executeUpdate();
                isAdded = rows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
    public boolean validateUserLogin(String username, int password) {
        boolean isValid = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM user WHERE Username = ? AND password = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                stmt.setInt(2, password);
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    isValid = true; // User found, valid login
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isValid;
    }

    // Method to get the userType based on username
    public String getUserType(String username) {
        String userType = null;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT userType FROM user WHERE Username = ?";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, username);
                ResultSet rs = stmt.executeQuery();
                
                if (rs.next()) {
                    userType = rs.getString("userType");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userType;
    }
    
    // Method to get all bookings
    public List<Booking> getBookings() {
        List<Booking> bookings = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM booking";  // Ensure 'booking' table exists with correct columns
            try (Statement stmt = conn.createStatement(); 
                    ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Booking booking = new Booking(
                        rs.getString("vehicleType"),
                        rs.getString("pickup"),
                        rs.getString("dropOff"),
                        rs.getInt("contactNo")
                    );
                    booking.setBookingID(rs.getInt("bookingID"));
                    booking.setVehicleType(rs.getString("vehicleType")); // **
                   booking.setPickup(rs.getString("pickup")); // **
                    booking.setDropOff(rs.getString("dropOff"));
//                   booking.setContactNo(rs.getString("contactNo"));

bookings.add(booking);
                }
                
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }

    // Method to add a booking
    public boolean addBooking(Booking booking) {
        boolean isAdded = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO booking (vehicleType, pickup, dropOff, contactNo) VALUES (?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, booking.getVehicleType());
                stmt.setString(2, booking.getPickup());
                stmt.setString(3, booking.getDropOff());
                stmt.setInt(4, booking.getContactNo());
                
                int rows = stmt.executeUpdate();
                isAdded = rows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }
    
     // Method to get all bills
    public List<Bill> getBills() {
        List<Bill> bills = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM bill"; // Ensure 'bill' table has the correct columns
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Bill bill = new Bill();
                    bill.setBillID(rs.getInt("billID"));
                    bill.setContactNo(rs.getInt("contactNo"));
                    bill.setPickupLocation(rs.getString("pickupLocation"));
                    bill.setDropLocation(rs.getString("dropLocation"));
                    bill.setDistance(rs.getBigDecimal("distance"));
                    bill.setTotal(rs.getBigDecimal("total"));
                    bills.add(bill);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bills;
    }

    // Method to add a bill
    public boolean addBill(Bill bill) {
        boolean isAdded = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO bill (contactNo, pickupLocation, dropLocation, distance, total) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setInt(1, bill.getContactNo());
                stmt.setString(2, bill.getPickupLocation());
                stmt.setString(3, bill.getDropLocation());
                stmt.setBigDecimal(4, bill.getDistance());
                stmt.setBigDecimal(5, bill.getTotal());
                int rows = stmt.executeUpdate();
                isAdded = rows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }

// Method to get all vehicles
    public List<Vehicle> getVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "SELECT * FROM vehicle"; // Ensure 'vehicle' table has the correct columns
            try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
                while (rs.next()) {
                    Vehicle vehicle = new Vehicle();
                    vehicle.setVehicleID(rs.getInt("vehicleID"));
                    vehicle.setVehicleType(rs.getString("vehicleType"));
                    vehicle.setPlateNo(rs.getString("plateNo"));
                    vehicle.setSeats(rs.getInt("seats"));
                    vehicles.add(vehicle);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return vehicles;
    }

    // Method to add a vehicle
    public boolean addVehicle(Vehicle vehicle) {
        boolean isAdded = false;
        try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS)) {
            String sql = "INSERT INTO vehicle (vehicleType, plateNo, seats) VALUES (?, ?, ?)";
            try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                stmt.setString(1, vehicle.getVehicleType());
                stmt.setString(2, vehicle.getPlateNo());
                stmt.setInt(3, vehicle.getSeats());
                int rows = stmt.executeUpdate();
                isAdded = rows > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdded;
    }
}
