package parkingManagementSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class ConnectionToMySQL {
	Connection c;
	Statement s;
	
	public ConnectionToMySQL(){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql:///parkinggroup","root","g@nu2002MYSQL");
			//System.out.println("Connection succesfull.");
			s = c.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void main(String args[]) {
		new ConnectionToMySQL();
	}
}
