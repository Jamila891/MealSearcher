package jamila.app.mealsearcher;
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

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;

public class MealSearcherModel {
	
	public SimpleStringProperty ingredient1;
	public SimpleStringProperty ingredient2;
	public ArrayList<Recipe> recipe;
	public Recipe r;
	public File file;
	
	public MealSearcherModel() {
		this.ingredient1 = new SimpleStringProperty();
		this.ingredient2 = new SimpleStringProperty();
		
		this.recipe = new ArrayList<Recipe>();
		recipe.add(new Recipe("Omlette", "Öl in die Pfanne und Teig rein", "https://www.swissmilk.ch/de/rezepte-kochideen/rezepte/HWL_TEIG1996_02/omeletten/", new Ingredients("300ml", "Milch")));
		recipe.add(new Recipe("Zürich Geschnetzeltes", "Ein bisschen Fleisch, Nudeln und Rahmsauce in die Pfanne", "https://www.swissmilk.ch/de/rezepte-kochideen/rezepte/LM201401_83/zuercher-geschnetzeltes/", new Ingredients("5kg", "Rindfleisch")));
		recipe.add(new Recipe("Milchreis", "Milch und Reis in die Pfanne geben und Hob de Bäse", "https://www.google.com/?client=safari", new Ingredients("5l", "Milch"), new Ingredients("2 Körner", "Reis")));
		//recipe.add(new Recipe("Milch", "Milch trinken", "www.milch.ch", new Ingredients("5l", "Milch")));
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
	
	public void FileReader() {
		URL url = MealSearcherModel.class.getResource("recipe.txt");
		Path path = null;
		try {
			path = Paths.get(url.toURI());
		} catch (URISyntaxException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		List<String> lines = null;
		try {
			lines = Files.readAllLines(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		lines.forEach(System.out::println);
	}
}



