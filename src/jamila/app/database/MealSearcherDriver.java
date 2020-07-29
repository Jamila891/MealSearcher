package jamila.app.database;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import jamila.app.mealsearcherMVC.MealSearcherView;
import jamila.app.recipe.Ingredient;
import jamila.app.recipe.Recipe;

public class MealSearcherDriver {
	
	private MealSearcherView view;
	public Connection myConn;
	
	public MealSearcherDriver () {
		try {
			myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MealSearcher?serverTimezone=CET", "root", "badweg17!");
		} catch (Exception e) {
				e.printStackTrace();
		}
	}
	
	public ArrayList<Recipe> readDatabase() {
		Statement myStatement;
		ArrayList<Recipe> listWithAllRecipesFromDatabase = new ArrayList<Recipe>();
		try {
			myStatement = myConn.createStatement();
			ResultSet myRs = myStatement.executeQuery("SELECT * FROM Recipe INNER JOIN Ingredient ON Recipe.RecipeNo = PK_Ingredient_ID");
			while(myRs.next()) {
				int ID = myRs.getInt(1);
				String name = myRs.getString(2);
				String instructions = myRs.getString(3);
				String URL = myRs.getString(4);
				String amount = myRs.getString(6);
				String in = myRs.getString(7);
				Ingredient ingredient = new Ingredient(amount, in);
				Recipe recipe = new Recipe(ID, name, instructions, URL, ingredient);
				boolean recipeAlreadyExists = false;
				
				for (Recipe r : listWithAllRecipesFromDatabase) {
					if (r.getID() == recipe.getID()) {
						r.addIngredientToRecipe(ingredient);
						recipeAlreadyExists = true;
					}
				}
				
				if (!recipeAlreadyExists) {
					listWithAllRecipesFromDatabase.add(recipe);
				}
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return listWithAllRecipesFromDatabase;
	}
	
	public void updateDatabase () {
		String sqlStatement = "INSERT INTO Recipe RecipeNo, Name, Instructions, URL, Ingredient VALUES (?,?,?,?,?)";
		PreparedStatement ps;
		try {
			ps = myConn.prepareStatement(sqlStatement);
			ps.setString(2, view.ARnametxt.getText());
			ps.setString(3, view.ARinstructionstxt.getText());
			ps.setString(4, view.ARurltxt.getText());
			ps.setString(6, view.ARamountxt.getText());
			ps.setString(7, view.ARingredienttxt.getText());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}