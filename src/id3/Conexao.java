package id3;

import java.sql.*;
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
		this.statement = (Statement) this.connection.createStatement();
	
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
	public void listarDados() {
		try {
			String query = "SELECT * FROM dados";
			this.resultSet = this.statement.executeQuery(query);
			this.statement = this.connection.createStatement();
			ResultSetMetaData meta = this.resultSet.getMetaData();
			for(int x =1; x <= meta.getColumnCount();x++) {
				System.out.println(meta.getColumnName(x));
			}
			while(this.resultSet.next()) {
				System.out.println("ID:" + this.resultSet.getString("id") +  "|" + this.resultSet.getString("RISCO")+  "|" + this.resultSet.getString("HCREDITO")+  "|" + this.resultSet.getString("DIVIDA") +  "|:" + this.resultSet.getString("RENDA"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
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
