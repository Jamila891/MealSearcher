package jamila.app.mealsearcher;

import java.net.URL;

public class Recipe {
	
	private String name;
	private Ingredients[] ingredient;
	private String instructions;
	private String urlToRecipe;
	// TODO: amount change depending on how many people are eating
	
	public Recipe (String name, String instructions, String urlToRecipe, Ingredients...in) {
		this.name = name;
		this.instructions = instructions;
		this.ingredient = in;
		this.urlToRecipe = urlToRecipe;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getInstructions () {
		return this.instructions;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public void setInstructions(String instructions) {
		this.instructions = instructions;
	}
	
	public String getUrlToRecipe() {
		return this.urlToRecipe;
	}
	
	public void setUrlToRecipe() {
		this.urlToRecipe = urlToRecipe;
	}
	
	public Ingredients[] getIngredient() {
		return ingredient;
	}
	
	public String toString() {
		String recipeAsString = this.name + " \n" + this.instructions + " \n" + this.ingredient + " \n" + this.urlToRecipe;
		return recipeAsString;
	}

}
