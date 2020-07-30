package jamila.app.mealsearcherMVC;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import jamila.app.database.MealSearcherDriver;
import jamila.app.recipe.Recipe;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MealSearcherController {
	
	private MealSearcherModel model;
	private MealSearcherView view;
	Recipe recipe1 = null, recipe2 = null;
	private MealSearcherDriver driver;
	
	public MealSearcherController(MealSearcherView view, MealSearcherModel model) {
		this.view = view;
		this.model = model;
		driver = new MealSearcherDriver(view);
		model.setRecipes(driver.readDatabase());
		
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		
		view.btnSearch.setOnAction(this::setTextOfChosenRecipe);
		view.ARaddRecipebtn.setOnAction(this::addNewRecipe);
		view.addAnotherIngredient.setOnAction(this::addAnotherIngredient);
	}
	
	public void setTextToProperty (String newValue) {
		model.setIngredient1(newValue);
		model.setIngredient2(newValue);
	}
	
	public void setTextOfChosenRecipe(ActionEvent event) {
		try {
			
		ArrayList<Recipe> r = model.findYourRecipe();
		
		view.recipe1.clear();
		view.recipe2.clear();
		view.recipe2.setVisible(true);
		view.btnRecipeWeblink2.setVisible(true);
		view.lblrecipe2.setVisible(true);
		
		switch (r.size()) {
		
		case 0: view.recipe1.setText("No recipe available. Please add new Recipe in other Tab.");
				break;
		
		case 1: recipe1 = r.get(0);
				view.recipe1.setText(recipe1.toString());
				view.btnRecipeWeblink1.setOnAction(e -> openRecipeWeblink(recipe1.getUrlToRecipe()));
				view.recipe2.setVisible(false);
				view.btnRecipeWeblink2.setVisible(false);
				view.lblrecipe2.setVisible(false);
				break;
		
		case 2: recipe1 = r.get(0);
				recipe2 = r.get(1);
				view.recipe1.setText(recipe1.toString());
				view.btnRecipeWeblink1.setOnAction(e -> openRecipeWeblink(recipe1.getUrlToRecipe()));
				view.recipe2.setText(recipe2.toString());
				view.btnRecipeWeblink2.setOnAction(e -> openRecipeWeblink(recipe2.getUrlToRecipe()));
				break;
		
		default: view.recipe1.setText("There are more than 2 recipe according to your Searchterm. Please specify.");
		}
		
		} catch (NullPointerException e) {
			view.recipe1.setText(e.getMessage());
		}
	}
	
	public void openRecipeWeblink(String url) {		
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
	
	public void addNewRecipe (ActionEvent e) {
		driver.updateDatabase();
	}
	
	public void addAnotherIngredient (ActionEvent e) {
		view.addAnotherIngredient();
	}

}







