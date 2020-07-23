package jamila.app.recipes;

import java.sql.*;

public class MealSearcherDriver {

	public static void main(String[] args) {
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MealSearcher", "jamila", "jamila");
			Statement myStatement = myConn.createStatement();
			ResultSet myRs = myStatement.executeQuery("select * from recipe");
			
			while (myRs.next()) {
				System.out.println(myRs.getString("Name") + " " + myRs.getString("URL") + " " + myRs.getString("Ingredient"));
			}
			
		} catch (Exception e) {
			// do nothing yet
		}

	}

}
