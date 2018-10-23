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
	public void conectar() {
		String servidor = "jdbc:mysql://192.168.50.238:3306/id3?useSSL=false";
		String usuario = "user";
		String senha = "user" ;
		String driver =  "com.mysql.jdbc.Driver";
		String ssl = "useSSL=false";
	
	try {
		Class.forName(driver);
		this.connection = DriverManager.getConnection(servidor, usuario, senha);

	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
		
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println(e.getMessage());
	}
	}
	
	
	
	
	public boolean estaConectado() {
		if(this.connection != null) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
//	static String ok = null;
//	
//	public static Connection geConnection() {
//		
//		Connection conn =null;
//		
//		
//		try {
//			Class.forName("com.mysql.jdbc.Driver").newInstance();
//			String url =  "jdbc:mysql://192.168.50.238:3306/id3/user&password=user";
//			conn = DriverManager.getConnection(url);
//			ok = "OK";
//			
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println(e.getMessage());
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
