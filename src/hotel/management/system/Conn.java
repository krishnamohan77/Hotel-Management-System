package hotel.management.system;

import java.sql.*;

public class Conn {
    Connection c;
    Statement s;

    Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "krishna098");
            s = c.createStatement();
            
           
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new Conn();
    }
}
//package hotel.management.system;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.Statement;
//import java.sql.SQLException;
//
//public class Conn {
//    Connection c;
//    Statement s;
//
//    Conn() {
//        try {
//            Class.forName("com.mysql.cj.jdbc.Driver");
//            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotelmanagementsystem", "root", "krishna2004+");
//            s = c.createStatement();
//        } catch (Exception e) {
//            e.printStackTrace();
//            // Handle the exception appropriately in a real application
//        }
//    }
//
//    public void close() {
//        try {
//            if (s != null) {
//                s.close();
//            }
//            if (c != null) {
//                c.close();
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//            // Handle the exception appropriately in a real application
//        }
//    }
//
//    public static void main(String[] args) {
//        Conn conn = new Conn();
//
//        // Perform database operations
//
//        conn.close(); // Close the database resources when done
//    }
//}
