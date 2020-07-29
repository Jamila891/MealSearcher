package jamila.app.database;

import java.sql.*;

public class MealSearcherDriver {

	public void executeDatabase () {
		
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MealSearcher?serverTimezone=CET", "root", "badweg17!");
			Statement myStatement = myConn.createStatement();
			ResultSet myRs = myStatement.executeQuery("SELECT * FROM Recipe LEFT JOIN Ingredient ON Recipe.RecipeNo = PK_Ingredient_ID");
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}