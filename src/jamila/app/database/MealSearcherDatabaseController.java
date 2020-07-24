package jamila.app.database;

import jamila.app.mealsearcherMVC.MealSearcherView;
import jamila.app.recipe.Ingredient;
import jamila.app.recipe.Recipe;
import javafx.event.ActionEvent;

public class MealSearcherDatabaseController {
	
	private MealSearcherView view;
	private Recipe recipe;

	public void addNewRecipeToDatabase (ActionEvent e) {
		String name = view.ARnametxt.getText();
		String instructions = view.ARinstructionstxt.getText();
		String url = view.ARurltxt.getText();
		String amount = view.ARamountxt.getText();
		String ingredient = view.ARingredienttxt.getText();
		
		recipe = new Recipe (name, instructions, url, new Ingredient(amount, ingredient));
		
//		String qu = "INSERT INTO MEALSEARCHER (" +
//		" ' " + RecipeNo +
//		" ' " + Name +
//		" ' " + Instructions +
//		" ' " + URL +
//		" ' " + Ingredient + "" +
//		")";
	}
}