package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class getbyemail {
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
            String sql = "select * from "+scr.next() +" where email = ? ";
            
            // Prepare the SQL statement
            PreparedStatement pmst = conn.prepareStatement(sql);
            System.out.println("enter email :");
            pmst.setString(1, scr.next());
            ResultSet rs = pmst.executeQuery();
            while(rs.next()) {
            	System.out.println("#################");
            	System.out.println("Id : "+rs.getInt("id"));
            	System.out.println("Name : "+rs.getString("name"));
            	System.out.println("Email : "+rs.getString("email"));
            	System.out.println("#################");

            }
          
            // Close the resources
            pmst.close();
            conn.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }
} 


