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

public class MealSearcherModel {
	
	public SimpleStringProperty ingredient1;
	public SimpleStringProperty ingredient2;
	
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
	
	/* this method should read all recipes in the Package "recipes" and use a searchString, which is the value 
	 from ingredient Property, to search through the content of every recipe and eventually show
	 the matching recipe in the view.displayRezept TextArea
	 
	 open questions:
	 - how can I iterate through all recipes with the searchString?
	 - how can I iterate with two searchStrings through the recipe?
	 - what possibilities do I have if multiple recipes match the two searchStrings?
	*/
	
	public List<String> readAllFilesFromPackage() {	
		List<String> lines = null;
		List<String> allFiles = new ArrayList<String>();
		
		File sourcePackage = new File("src/recipes/");
		//String path = sourcePackage.getAbsolutePath();
		
		for (File sourceFile : sourcePackage.listFiles()) {
			try {
				lines = Files.readAllLines(Paths.get(sourceFile.getPath()));
			} catch (IOException e) {
				e.printStackTrace();
			}
		} for (String f : lines) {
			allFiles.add(f);
		}
		System.out.println(allFiles);
		return allFiles;
	}
}