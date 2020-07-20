package jamila.app.mealsearcher;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

public class MealSearcherModel {
	
	public SimpleStringProperty ingredient1;
	public SimpleStringProperty ingredient2;
	public ArrayList<Recipe> recipe;
	public Recipe chosenRecipe;
	
	public MealSearcherModel() {
		this.ingredient1 = new SimpleStringProperty();
		this.ingredient2 = new SimpleStringProperty();
		
		this.recipe = new ArrayList<Recipe>();
		recipe.add(new Recipe("Omlette", "Öl in die Pfanne und Teig rein", "https://www.swissmilk.ch/de/rezepte-kochideen/rezepte/HWL_TEIG1996_02/omeletten/", new Ingredients("300ml", "Milch")));
		recipe.add(new Recipe("Zürich Geschnetzeltes", "Ein bisschen Fleisch, Nudeln und Rahmsauce in die Pfanne", "https://www.swissmilk.ch/de/rezepte-kochideen/rezepte/LM201401_83/zuercher-geschnetzeltes/", new Ingredients("5kg", "Rindfleisch")));
		recipe.add(new Recipe("Milchreis", "Milch und Reis in die Pfanne geben und Hob de Bäse", "www.google.com", new Ingredients("5l", "Milch"), new Ingredients("2 Körner", "Reis")));
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
	
	public void setChosenRecipe(Recipe r) {
		this.chosenRecipe = r;
	}
	
	public Recipe getChosenRecipe() {
		
		ArrayList<Recipe> re = findYourRecipe();
		for (Recipe r : re) {
			this.chosenRecipe = r;
		}
		return this.chosenRecipe;
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
		String url = chosenRecipe.getUrlToRecipe();
		return url;
	}	
}



