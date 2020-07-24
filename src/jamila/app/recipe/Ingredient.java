package jamila.app.recipe;

public class Ingredient {
	
	private String amount;
	private String ingredient;
	
	public Ingredient (String amount, String ingredient) {
		this.amount = amount;
		this.ingredient = ingredient;
	}
	
	public String getAmount() {
		return this.amount;
	}
	
	public String getIngredient() {
		return this.ingredient;
	}
	
	public void setAmount(String amount) {
		this.amount = amount;
	}
	
	public void setIngredient() {
		this.ingredient = ingredient;
	}
	
	public String toString() {
		String IngredientString = this.amount + " " + this.ingredient;
		return IngredientString;
	}
}