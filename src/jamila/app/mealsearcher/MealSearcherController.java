package jamila.app.mealsearcher;
import java.awt.Desktop;
import java.net.URI;
import java.nio.file.Path;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;

public class MealSearcherController {
	
	private MealSearcherModel model;
	private MealSearcherView view;
	
	public MealSearcherController(MealSearcherView view, MealSearcherModel model) {
		this.view = view;
		this.model = model;
		
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		
		view.btnSearch.setOnAction(this::searchForReceipe);
		view.recipeWeblink.setOnAction(this::openRecipeWeblink);
		
	}
	
	public void setTextToProperty (String newValue) {
		model.setIngredient1(newValue);
		model.setIngredient2(newValue);
	}
	
	public void searchForReceipe(ActionEvent event) {
		String ingredientName1 = model.getIngredient1();
		String ingredientName2 = model.getIngredient2();
		
		String searchString = null;
		
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
	
	public void openRecipeWeblink(ActionEvent e) {
		String url = "https://www.swissmilk.ch/de/rezepte-kochideen/rezepte/HWL_TEIG1996_02/omeletten/";
		try {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI(url);
			  desktop.browse(oURL);
			} catch (Exception ex) {
			  ex.printStackTrace();
			}
	}

}