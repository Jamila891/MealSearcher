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
	public Ingredients ingredients;
	
	public MealSearcherModel() {
		this.ingredient1 = new SimpleStringProperty();
		this.ingredient2 = new SimpleStringProperty();
		
		this.recipe = new ArrayList<Recipe>();
		recipe.add(new Recipe("Omlette", "Öl in die Pfanne und Teig rein", "https://www.swissmilk.ch/de/rezepte-kochideen/rezepte/HWL_TEIG1996_02/omeletten/", new Ingredients("300ml", "Milch")));
		recipe.add(new Recipe("Zürich Geschnetzeltes", "Ein bisschen Fleisch, Nudeln und Rahmsauce in die Pfanne", "https://www.swissmilk.ch/de/rezepte-kochideen/rezepte/LM201401_83/zuercher-geschnetzeltes/", new Ingredients("5kg", "Rindfleisch")));
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
		return ingredients.getIngredient();
	}
	
	public String getIngredient2() {
		
		for (int i = 0; i < recipe.size(); i++) {
			Recipe r = recipe.get(i);
			Ingredients[] in = r.getIngredient();
		}
		return ingredients.getIngredient();
	}
	
	public void setChosenRecipe(Recipe r) {
		this.chosenRecipe = r;
	}
	
	public Recipe getChosenRecipe() {
		return this.chosenRecipe;
	}
	
	public Recipe findYourRecipe() {
		String searchString1 = getIngredient1();// wählt falsches Feld aus deswegen gibt es eine NullPointerException
		String searchString2 = getIngredient2();
		
		String re;
		
		for (Recipe r : recipe) {
			re = r.toString();
			
			if (re.contains(searchString1)) {
				r = this.chosenRecipe;
			}
			if (re.contains(searchString2)) {
				r = this.chosenRecipe;
			}
		}
		return this.chosenRecipe;
	}
	
	public String getURL() {
		String url = chosenRecipe.getUrlToRecipe();
		return url;
	}	
}

/* this method should read all recipes in the Package "recipes" and use a searchString, which is the value 
from ingredient Property, to search through the content of every recipe and eventually show
the matching recipe in the view.displayRezept TextArea

open questions:
- how can I iterate through all recipes with the searchString?
- how can I iterate with two searchStrings through the recipe?
- what possibilities do I have if multiple recipes match the two searchStrings?
*/



