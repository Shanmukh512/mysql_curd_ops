package application;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class curdops {
	
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String Username = "root";
	private static final String Password = "root";
	public static void main(String[] args) {
		int sh;
		do {
			System.out.println("CURD Operations :");
			System.out.println("####################");
			System.out.println("\t1.Create Database");
			System.out.println("\t2.Drop Database");
			System.out.println("\t3.Create Table");
			System.out.println("\t4.Delete Table");
			System.out.println("\t5.Insert Data");
			System.out.println("\t6.Delete Data");
			System.out.println("\t7.Update Data");
			System.out.println("\t8.Get All");
			System.out.println("\t9.Get By Email");
			System.out.println("\t10.Exit");
			Scanner scr = new Scanner(System.in);
			System.out.println("Enter your choice :");
			sh = Integer.parseInt(scr.next());
			System.out.println("###################");
			switch (sh) {
			case 1:
				createdatabase();
				break;
			case 2:
				dropdatabase();
				break;
			case 3:
				createtable();
				break;
			case 4:
				deletetable();
				break;
			case 5:
				insertdata();
				break;
			case 6:
				deletedata();
				break;
			case 7:
				updatedata();
				break;
			case 8:
				getall();
				break;
			case 9:
				getbyemail();
				break;
			case 10:
				System.exit(0);
				break;

			default:
				System.out.println("Invalid");
				break;
			}
		} while (sh>0);
	}

	private static void getbyemail() {
		// TODO Auto-generated method stub
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

	private static void getall() {
		// TODO Auto-generated method stub
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
	            String sql = "select * from " +scr.next();
	            
	            // Prepare the SQL statement
	            PreparedStatement pmst = conn.prepareStatement(sql); 
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

	private static void updatedata() {
		// TODO Auto-generated method stub
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
            String sql = "update " +scr.next()+ " set name = ?, email = ? where id = ?";
            
            // Prepare the SQL statement
            PreparedStatement pmst = conn.prepareStatement(sql);
            System.out.println("Enter name :");
            pmst.setString(1,scr.next());
            System.out.println("Enter email :");
            pmst.setString(2,scr.next());
            System.out.println("Enter id :");
            pmst.setInt(3,scr.nextInt());
            
            // Execute the update
            int i = pmst.executeUpdate();
            if (i>0) {
            	System.out.println("Table is Updated");
            }
			else {
					System.out.println("Table is not updated");
				
			}

            // Close the resources
            pmst.close();
            conn.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
		
	}

	private static void deletedata() {
		// TODO Auto-generated method stub
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
            String sql = "delete from "+scr.next() + " where email = ?";
            
            // Prepare the SQL statement
            PreparedStatement pmst = conn.prepareStatement(sql);
            System.out.println("Enter email :");
            pmst.setString(1, scr.next());
            
            // Execute the update
            int i = pmst.executeUpdate();
            if (i>0) {
            	System.out.println("Data is deleted");
            }
			else {
					System.out.println("Data is not deleted");
				
			}

            // Close the resources
            pmst.close();
            conn.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
		
	}

	private static void insertdata() {
		// TODO Auto-generated method stub
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

	private static void deletetable() {
		// TODO Auto-generated method stub
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
	            String sql = "drop table "+scr.next();
	            
	            // Prepare the SQL statement
	            PreparedStatement pmst = conn.prepareStatement(sql);
	            
	            // Execute the update
	            int i = pmst.executeUpdate();
	            if (i==0) {
	            	System.out.println("Table is dropped");
	            }
				else {
						System.out.println("Table is not dropped");
					
				}

	            // Close the resources
	            pmst.close();
	            conn.close();
	        } catch (Exception exp) {
	            exp.printStackTrace();
	        }
		
	}

	private static void createtable() {
		// TODO Auto-generated method stub
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

	private static void dropdatabase() {
		// TODO Auto-generated method stub
		 try {
	        	Scanner scr = new Scanner(System.in);
	            // Load MySQL JDBC driver
	            Class.forName(DRIVER);
	            String URL = "jdbc:mysql://localhost:3306/";
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

	private static void createdatabase() {
		// TODO Auto-generated method stub
		 try {
	        	Scanner scr = new Scanner(System.in);
	            // Load MySQL JDBC driver
	            Class.forName(DRIVER);
	            String URL = "jdbc:mysql://localhost:3306/";
	            // Connect to the database
	            Connection conn = DriverManager.getConnection(URL, Username, Password);
	            System.out.println("Enter database name :");

	            // Example SQL statement
	            String sql = "create database "+scr.next();
	            
	            // Prepare the SQL statement
	            PreparedStatement pmst = conn.prepareStatement(sql);
	            
	            // Execute the update
	            int i = pmst.executeUpdate();
	            if (i>0) {
	            	System.out.println("Database is created");
	            }
				else {
						System.out.println("Database is not created");
					
				}

	            // Close the resources
	            pmst.close();
	            conn.close();
	        } catch (Exception exp) {
	            exp.printStackTrace();
	        }
		
	}
  
}
