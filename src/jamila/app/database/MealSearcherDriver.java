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
	
	public MealSearcherDriver (MealSearcherView view) {
		this.view = view;
		
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
			ResultSet myRs = myStatement.executeQuery("SELECT r.*, i.Amount, i.Ingredient_Name FROM Recipe r INNER JOIN Ingredient i ON r.RecipeNo = i.RecipeID");
			while(myRs.next()) {
				int ID = myRs.getInt(1);
				String name = myRs.getString(2);
				String instructions = myRs.getString(3);
				String URL = myRs.getString(4);
				String amount = myRs.getString(5);
				String in = myRs.getString(6);
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
		String recipeQuery = "INSERT INTO Recipe (Name, Instructions, URL) VALUES (?,?,?)";
		String ingredientQuery = "INSERT INTO Ingredient (Amount, Ingredient_Name, RecipeID) VALUES (?,?,?)";
		PreparedStatement rq,iq;
		
		try {
			rq = myConn.prepareStatement(recipeQuery, Statement.RETURN_GENERATED_KEYS);
			rq.setString(1, view.ARnametxt.getText());
			rq.setString(2, view.ARinstructionstxt.getText());
			rq.setString(3, view.ARurltxt.getText());
			rq.executeUpdate();
			
			iq = myConn.prepareStatement(ingredientQuery);
			iq.setString(1, view.ARamountxt.getText());
			iq.setString(2, view.ARingredient.getText());
			ResultSet rs = rq.getGeneratedKeys();
			rs.next();
			int id = rs.getInt(1);
			iq.setInt(3, id);
			iq.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}