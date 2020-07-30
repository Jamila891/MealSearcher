package jamila.app.recipe;

import java.net.URL;
import java.util.ArrayList;

public class Recipe {
	
	private String name;
	private ArrayList<Ingredient> ingredients;
	private String instructions;
	private String urlToRecipe;
	private int ID;
	// TODO: amount change depending on how many people are eating
	
	public Recipe (int ID, String name, String instructions, String urlToRecipe, Ingredient in) {
		this.ID = ID;
		this.name = name;
		this.instructions = instructions;
		this.ingredients = new ArrayList<Ingredient>();
		this.ingredients.add(in);
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
	
	public int getID() {
		return this.ID;
	}
	
	public void setID(int ID) {
		this.ID = ID;
	}
	
	public ArrayList<Ingredient> getIngredient() {
		return ingredients;
	}
	
	public boolean hasIngredient (String chosenIngredient) {
		boolean hasIngredient = false;
		for (int i = 0; i<ingredients.size(); i++) {
			Ingredient in = ingredients.get(i);
			if (in.getIngredient().contains(chosenIngredient)) {
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
	
	public void addIngredientToRecipe(Ingredient i) {
		ingredients.add(i);
	}
}
