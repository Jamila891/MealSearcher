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
		view.btnRecipeWeblink1.setOnAction(this::openRecipeWeblink);
		view.btnRecipeWeblink2.setOnAction(this::openRecipeWeblink);
		view.ARaddRecipebtn.setOnAction(this::addNewRecipeToArrayList);
	}
	
	public void setTextToProperty (String newValue) {
		model.setIngredient1(newValue);
		model.setIngredient2(newValue);
	}
	
	public void setTextOfChosenRecipe(ActionEvent event) {
		ArrayList<Recipe> r = model.findYourRecipe();
		
		/* Wenn ich Rindfleisch (Ingredient1) und Milch (Ingredient2) eingebe, dann bekomme ich nur das Rezept Rindfleisch 
		aber wenn ich Milch und Rindfleisch eingebe, bekomme ich alle 4 Rezepte. Why?
		*/
		
		for (Recipe re : r) {
			System.out.println(re);
		}

		Recipe recipe1 = null, recipe2 = null;
		
		switch (r.size()) {
		
		case 0: view.recipe1.setText("No recipe available. Please add new Recipe in other Tab.");
			break;
		
		case 1: recipe1 = r.get(0);
		view.recipe1.setText(recipe1.toString());
			break;
		
		case 2: recipe1 = r.get(0);
		recipe2 = r.get(1);
		view.recipe1.setText(recipe1.toString());
		view.recipe2.setText(recipe2.toString());
			break;
		
		default: view.recipe1.setText("There are more than 2 recipe according to your Searchterm. Please specify.");
		
		}
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







