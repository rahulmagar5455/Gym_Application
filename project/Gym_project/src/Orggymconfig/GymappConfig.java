package Orggymconfig;

import java.sql.*;
import java.util.Properties;
import java.io.*;
public class GymappConfig {
	protected Connection conn;
	protected PreparedStatement stmt;
	protected ResultSet rs;
	protected CallableStatement cstmt;
	
	public GymappConfig() {
		try {   

			String driverclassName=PathHelper.p.getProperty("db.driverClass");
			String username= PathHelper.p.getProperty("db.username");
			String password= PathHelper.p.getProperty("db.password");
			String url=PathHelper. p.getProperty("db.url");
			
//			System.out.println(driverclassName);
//			System.out.println(username);
//			System.out.println(password);
//			System.out.println(url);
//			
			
			

			Class.forName(PathHelper.p.getProperty("db.driverClass"));
	
		
			conn = DriverManager.getConnection(PathHelper. p.getProperty("db.url"),PathHelper.p.getProperty("db.username"),PathHelper.p.getProperty("db.password"));
			
//	Class.forName(driverclassName);
		
//       		conn = DriverManager.getConnection(url,username,password);
			
//			com.mysql.cj.jdbc.Driver d=new com.mysql.cj.jdbc.Driver();
			if(conn!=null)
			{
//				System.out.println("Connected");
				
//				stmt=conn.prepareStatement("insert into abc values(?,'A')");
//				stmt.setInt(1, 1);
//			
//				int val=stmt.executeUpdate();
//				if(val>0)
//				{
//					System.err.println("Sucsess..........");
//				}
//				else
//				{
//					System.err.println("Not Sucsess..........");
//				}
				
			}
			else
			{
				System.out.println("Not Connected");
			}
		}
		catch(Exception ex) {
		System.out.println("Error is a "+ex);
		}
	}
		
	public static void main(String x[]) {
		new GymappConfig();
	}

	
}
