package main;

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
		List<String> list = model.readFile();
		String recipe = " ";
		
		for (String s : list) {
			recipe += s;
		}
	
		String ingredient1 = view.txtIngredient1.getText();
		String ingredient2 = view.txtIngredient2.getText();
		
		if (recipe.contains(ingredient2)) {
			view.displayRezept.setText(recipe);
		} if (recipe.contains(ingredient1)) {
			view.displayRezept.setText(recipe);
		}
	}
}
