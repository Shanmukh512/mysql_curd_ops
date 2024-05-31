package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class dropdb {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/";
	private static final String Username = "root";
	private static final String Password = "root";

    public static void main(String[] args) {
        try {
        	Scanner scr = new Scanner(System.in);
            // Load MySQL JDBC driver
            Class.forName(DRIVER);
            // Connect to the database
            Connection conn = DriverManager.getConnection(URL, Username, Password);
            System.out.println("Enter database name :");

            // Example SQL statement
            String sql = "drop database "+scr.next();
            
            // Prepare the SQL statement
            PreparedStatement pmst = conn.prepareStatement(sql);
            
            // Execute the update
            int i = pmst.executeUpdate();
            if (i==0) {
            	System.out.println("Database is dropped");
            }
			else {
					System.out.println("Database is not dropped");
				
			}

            // Close the resources
            pmst.close();
            conn.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}


