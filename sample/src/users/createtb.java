package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class createtb {
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String Username = "root";
	private static final String Password = "root";

    public static void main(String[] args) {
        try {
        	Scanner scr = new Scanner(System.in);
        	System.out.println("Enter database name :");
        	String URL = "jdbc:mysql://localhost:3306/"+scr.next();
       	
            // Load MySQL JDBC driver
            Class.forName(DRIVER);
            // Connect to the database
            Connection conn = DriverManager.getConnection(URL, Username, Password);
            System.out.println("Enter table name :");

            // Example SQL statement
            String sql = "create table "+scr.next()+"(id int, name varchar(20),email varchar(30))";
            
            // Prepare the SQL statement
            PreparedStatement pmst = conn.prepareStatement(sql);
            
            // Execute the update
            int i = pmst.executeUpdate();
            if (i==0) {
            	System.out.println("Table is created");
            }
			else {
					System.out.println("Table is not created");
				
			}

            // Close the resources
            pmst.close();
            conn.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}


