package jamila.app.database;

import java.sql.*;

public class MealSearcherDriver {

	public void executeDatabase () {
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MealSearcher?serverTimezone=CET", "root", "badweg17!");
			Statement myStatement = myConn.createStatement();
			ResultSet myRs = myStatement.executeQuery("SELECT * FROM MealSearcher.Recipe");
			
			while (myRs.next()) {
				System.out.println("Hallo");
				System.out.println(myRs.getString("Name") + " " + myRs.getString("URL") + " " + myRs.getString("Ingredient"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}