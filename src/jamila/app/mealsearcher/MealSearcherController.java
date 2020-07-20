package jamila.app.mealsearcher;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MealSearcherController {
	
	private MealSearcherModel model;
	private MealSearcherView view;
	
	public MealSearcherController(MealSearcherView view, MealSearcherModel model) {
		this.view = view;
		this.model = model;
		
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		
		view.btnSearch.setOnAction(this::setTextOfChosenRecipe);
		view.btnRecipeWeblink.setOnAction(this::openRecipeWeblink);
		view.ARaddRecipebtn.setOnAction(this::addNewRecipeToArrayList);
	}
	
	public void setTextToProperty (String newValue) {
		model.setIngredient1(newValue);
		model.setIngredient2(newValue);
	}
	
	public void setTextOfChosenRecipe(ActionEvent event) {
		ArrayList<Recipe> r = model.findYourRecipe();
	
		view.displayRezept.setText(r.toString());
	}
	
	public void openRecipeWeblink(ActionEvent e) {
		String url = model.getURL();
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
	
	public void addNewRecipeToArrayList (ActionEvent e) {
		
		String name = view.ARnametxt.getText();
		String instructions = view.ARinstructionstxt.getText();
		String url = view.ARurltxt.getText();
		String amount = view.ARamountxt.getText();
		String ingredient = view.ARingredienttxt.getText();
		
		Recipe recipe = new Recipe(name, instructions, url, new Ingredients(amount, ingredient));
		model.recipe.add(recipe);
	}
}







