package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class insertdata {
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
            String sql = "insert into "+scr.next()+"(id,name,email) values(?,?,?)";
            
            // Prepare the SQL statement
            PreparedStatement pmst = conn.prepareStatement(sql);
            System.out.println("Enter id :");
            pmst.setInt(1,scr.nextInt());
            System.out.println("Enter name :");
            pmst.setString(2,scr.next());
            System.out.println("Enter email :");
            pmst.setString(3,scr.next());
            
            // Execute the update
            int i = pmst.executeUpdate();
            if (i>0) {
            	System.out.println("Data is inserted");
            }
			else {
					System.out.println("Data is not inserted");
				
			}

            // Close the resources
            pmst.close();
            conn.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
}


