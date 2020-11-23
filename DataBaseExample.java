package JavaLearning;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBaseExample {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection = DriverManager.getConnection
				("jdbc:mysql://localhost:3306/login", "root" , "rajidivi@4499");

		Statement statement = connection.createStatement();

		ResultSet results = statement.executeQuery("SELECT * FROM demo_login");

		while (results.next()) {

			System.out.println("Username :" +results.getString(1)+"Password :"+ results.getString(2));

		}

	}


}
