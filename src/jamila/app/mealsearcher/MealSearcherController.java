package jamila.app.mealsearcher;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
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
		
		view.btnSearch.setOnAction(this::setTextOfChosenRecipe);
		view.recipeWeblink.setOnAction(this::openRecipeWeblink);
		
	}
	
	public void setTextToProperty (String newValue) {
		model.setIngredient1(newValue);
		model.setIngredient2(newValue);
	}
	
	public void setTextOfChosenRecipe(ActionEvent event) {
		String recipe = "";
	
//		if (recipe.contains(model.searchRecipe())) {
//			view.displayRezept.setText(recipe);
//		} else {
//			view.displayRezept.setText("Kein passendes Rezept vorhanden.");
//		}
	}
	
	public void openRecipeWeblink(ActionEvent e) {
		String url = "https://www.swissmilk.ch/de/rezepte-kochideen/rezepte/HWL_TEIG1996_02/omeletten/";
		try {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI(url);
			  try {
				desktop.browse(oURL);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			} catch (URISyntaxException ex) {
			  ex.printStackTrace();
			}
	}

}