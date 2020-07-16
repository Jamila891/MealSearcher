package jamila.app.mealsearcher;

public class Recipe {
	
	private String name;
	private Ingredients[] ingredient;
	private String instructions;
	
	public Recipe (String name, String instructions, Ingredients...in) {
		this.name = name;
		this.instructions = instructions;
		this.ingredient = in;
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
	
	public String convertRecipeToString() {
		String recipeAsString = " ";
		
		return recipeAsString;
	}
	
	

}
