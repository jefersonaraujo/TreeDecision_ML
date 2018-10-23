package id3;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Conexao {
	private Connection connection = null;
	private Statement statement = null;
	private ResultSet resultSet = null;
	

	static String ok = null;
	
//	public static Connection geConnection() {
//		
//		
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			String url =  "jdbc:mysql://192.168.50.238:3306/id3/root&password=test";
//			conn = DriverManager.getConnection(url);
//			ok = "OK";
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			
//			
//		} catch (ClassNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return conn;
//	}
}
