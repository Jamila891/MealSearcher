package jamila.app.mealsearcherMVC;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import jamila.app.database.MealSearcherDriver;
import jamila.app.recipe.Ingredient;
import jamila.app.recipe.Recipe;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

public class MealSearcherModel {
	
	public SimpleStringProperty ingredient1;
	public SimpleStringProperty ingredient2;
	public ArrayList<Recipe> recipe;
	public Recipe r;
	
	public MealSearcherModel() {
		this.ingredient1 = new SimpleStringProperty();
		this.ingredient2 = new SimpleStringProperty();
	}
	
	public SimpleStringProperty ingredient1Property() {		
		return ingredient1;
	}
	
	public SimpleStringProperty ingredient2Property() {
		return ingredient2;
	}
	
	public void setIngredient1(String newValue) {
		ingredient1.set(newValue);
	}
	
	public void setIngredient2(String newValue) {
		ingredient2.set(newValue);
	}
	
	public String getIngredient1() {
		return ingredient1.get();
	}
	
	public String getIngredient2() {
		return ingredient2.get();
	}
	
	public Recipe getChosenRecipe() {
		ArrayList<Recipe> re = findYourRecipe();
		Recipe chosenRecipe = null;
		for (Recipe cr : re) {
			chosenRecipe = cr;
		}
		return chosenRecipe;
	}
	
	public void setRecipes(ArrayList<Recipe> r) {
		this.recipe = r;
	}
	
	public ArrayList<Recipe> findYourRecipe() {
		String searchString1 = getIngredient1();
		String searchString2 = getIngredient2();
		
		ArrayList<Recipe> matchingRecipe = new ArrayList<Recipe>();
		
		for (Recipe r : recipe) {
			if (r.hasIngredient(searchString1) && r.hasIngredient(searchString2)) {
				matchingRecipe.add(r);
			}
		}
		return matchingRecipe;
	}
	
	public String getURL() {
		Recipe r = getChosenRecipe();
		String url = r.getUrlToRecipe();
		System.out.println(url);
		return url;
	}
}



