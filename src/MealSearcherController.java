import java.nio.file.Path;
import java.util.List;

import javafx.event.ActionEvent;

public class MealSearcherController {
	
	private MealSearcherModel model;
	private MealSearcherView view;
	
	public MealSearcherController(MealSearcherView view, MealSearcherModel model) {
		this.view = view;
		this.model = model;
		
		view.btnSearch.setOnAction(this::executeSearch);
		
	}
	
	public void executeSearch(ActionEvent event) {
		String ingredient1 = view.txtIngredient1.getText();
		String ingredient2 = view.txtIngredient2.getText();
		
		List<String> list = model.readFile(ingredient1);
		String recipe = "";
		
		for (String s : list) {
			recipe += s +"\n";
		}
		
		if (recipe.contains(ingredient2)) {
			view.displayRezept.setText(recipe);
		} if (recipe.contains(ingredient1)) {
			view.displayRezept.setText(recipe);
		}
	}

}