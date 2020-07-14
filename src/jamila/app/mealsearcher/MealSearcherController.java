package jamila.app.mealsearcher;
import java.nio.file.Path;
import java.util.List;

import javafx.event.ActionEvent;

public class MealSearcherController {
	
	private MealSearcherModel model;
	private MealSearcherView view;
	
	public MealSearcherController(MealSearcherView view, MealSearcherModel model) {
		this.view = view;
		this.model = model;
		
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		
		view.btnSearch.setOnAction(this::searchForReceipe);
		
	}
	
	public void setTextToProperty (String newValue) {
		model.setIngredient1(newValue);
		model.setIngredient2(newValue);
	}
	
	public void searchForReceipe(ActionEvent event) {
		String searchString = model.getIngredient1();
		
		List<String> list = model.readAllFilesFromPackage();
		
		
		
		String recipe = " ";
		
		for (String s : list) {
			recipe += s + "\n";
		}
		
		if (recipe.contains(searchString)) {
			view.displayRezept.setText(recipe);
		} else {
			view.displayRezept.setText("Kein passendes Rezept vorhanden.");
		}
	}

}