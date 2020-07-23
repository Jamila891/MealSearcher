package jamila.app.mealsearcher;

import java.net.URL;

public class Recipe {
	
	private String name;
	private Ingredient[] ingredients;
	private String instructions;
	private String urlToRecipe;
	// TODO: amount change depending on how many people are eating
	
	public Recipe (String name, String instructions, String urlToRecipe, Ingredient...in) {
		this.name = name;
		this.instructions = instructions;
		this.ingredients = in;
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
	
	public Ingredient[] getIngredient() {
		return ingredients;
	}
	
	public boolean hasIngredient (String chosenIngredient) {
		boolean hasIngredient = false;
		for (int i = 0; i<ingredients.length; i++) {
			String in = ingredients[i].getIngredient();
			if (in.contains(chosenIngredient)) {
				hasIngredient = true;
			}
		}
		return hasIngredient;
	}
	
	public String toString() {
		String ingredient = "";
		for (Ingredient i : ingredients) {
			ingredient += i + "\n";
		}
		
		String recipeAsString = this.name + " \n " + " \n " + this.instructions + " \n" + ingredient + " \n";
		return recipeAsString;
	}
}
