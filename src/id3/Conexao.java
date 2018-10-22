package id3;

import java.sql.Connection;

public class Conexao {

	String Status="";
	
	public static Connection geConnection() {
		Connection conn=null;
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			
			
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
			
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
