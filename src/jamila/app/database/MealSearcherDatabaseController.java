package jamila.app.database;

import jamila.app.mealsearcher.MealSearcherView;
import javafx.event.ActionEvent;

public class MealSearcherDatabaseController {
	
	private MealSearcherView view;

	public void addNewRecipeToDatabase (ActionEvent e) {
		String name = view.ARnametxt.getText();
		String instructions = view.ARinstructionstxt.getText();
		String url = view.ARurltxt.getText();
		String amount = view.ARamountxt.getText();
		String ingredient = view.ARingredienttxt.getText();
		
//		String qu = "INSERT INTO MEALSEARCHER (" +
//		" ' " + RecipeNo +
//		" ' " + Name +
//		" ' " + Instructions +
//		" ' " + URL +
//		" ' " + Ingredient + "" +
//		")";
	}
}