package jamila.app.database;

import jamila.app.mealsearcherMVC.MealSearcherView;
import jamila.app.recipe.Ingredient;
import jamila.app.recipe.Recipe;
import javafx.event.ActionEvent;

public class MealSearcherDatabaseController {
	
	private MealSearcherView view;
	private Recipe recipe;
	private static int RecipeNo = 0;

	public void addNewRecipeToDatabase (ActionEvent e) {
		RecipeNo++;
		String Name = view.ARnametxt.getText();
		String Instructions = view.ARinstructionstxt.getText();
		String URL = view.ARurltxt.getText();
		String amount = view.ARamountxt.getText();
		String ingredient = view.ARingredienttxt.getText();
		Ingredient Ingredient = new Ingredient(amount, ingredient);
		
		String qu = "INSERT INTO MEALSEARCHER.Recipe (" +
		" ' " + RecipeNo +
		" ' " + Name +
		" ' " + Instructions +
		" ' " + URL +
		" ' " + Ingredient + "" +
		")";
	}
}