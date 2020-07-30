package jamila.app.mealsearcherMVC;
import java.awt.Dimension;

import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MealSearcherView {
	
	private Stage stage;
	private MealSearcherModel model;
	public Button btnSearch, btnRecipeWeblink1, btnRecipeWeblink2, ARaddRecipebtn, addAnotherIngredient;
	public TextField txtIngredient1, txtIngredient2, ARnametxt, ARurltxt, ARamountxt, ARingredienttxt, ARinstructionstxt;
	public Label lblIngredient1, lblIngredient2, ARnamelbl, ARurllbl, ARingredientlbl, ARinstructionslbl, ARamountlbl, ARingredient, lblrecipe1, lblrecipe2;
	public TextArea recipe1, recipe2;
	public VBox anotherIngredient;
	
	public MealSearcherView(Stage stage, MealSearcherModel model) {
		this.stage = stage;
		this.model = model;
		
		VBox root = new VBox();
		
		VBox searchRecipe = new VBox(15);
		searchRecipe.setPadding(new Insets(20.0, 20.0, 20.0, 20.0));
		this.lblIngredient1 = new Label("Ingredient 1");
		this.lblIngredient2 = new Label("Ingredient 2");
		this.txtIngredient1 = new TextField();
		this.txtIngredient2 = new TextField();
		this.btnSearch = new Button("Search");
		this.recipe1 = new TextArea();
		this.recipe2 = new TextArea();
		this.btnRecipeWeblink1 = new Button("Find this recipe online!");
		this.btnRecipeWeblink2 = new Button("Find this recipe online!");
		this.lblrecipe1 = new Label("Recipe 1");
		this.lblrecipe2 = new Label("Recipe 2");
		
		searchRecipe.getChildren().addAll(lblIngredient1, txtIngredient1, lblIngredient2, txtIngredient2, btnSearch, lblrecipe1, recipe1, btnRecipeWeblink1, lblrecipe2, recipe2, btnRecipeWeblink2);
		
		VBox addNewRecipe = new VBox(50);
		addNewRecipe.setPadding(new Insets(20.0, 20.0, 20.0, 20.0));
		
		VBox labels = new VBox(15);
		this.ARnamelbl = new Label("Name");
		this.ARnametxt = new TextField();
		this.ARinstructionslbl = new Label ("Instructions");
		this.ARinstructionstxt = new TextField();
		this.ARurllbl = new Label("Weblink to Recipe");
		this.ARurltxt = new TextField();
		this.ARingredientlbl = new Label ("Ingredients");
		this.addAnotherIngredient = new Button("+");
		this.ARaddRecipebtn = new Button ("Add Recipe");
		anotherIngredient = new VBox();
		
		labels.getChildren().addAll(ARnamelbl,ARnametxt, ARinstructionslbl, ARinstructionstxt, ARurllbl, ARurltxt, ARingredientlbl, addAnotherIngredient, anotherIngredient, ARaddRecipebtn);
		
		addNewRecipe.getChildren().add(labels);
		
		Tab searchRecipeTab = new Tab ("Search for Recipes");
		searchRecipeTab.setContent(searchRecipe);
		searchRecipeTab.setClosable(false);
		
		Tab addRecipe = new Tab("Add new Recipe");
		addRecipe.setContent(addNewRecipe);
		addRecipe.setClosable(false);
		
		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(searchRecipeTab, addRecipe);
		
		root.getChildren().addAll(tabPane, searchRecipe, addNewRecipe);
		
		Scene scene = new Scene(root, 1280, 839);
		stage.setScene(scene);
		stage.setTitle("Meal Searcher");
		stage.setResizable(true);
		
		scene.getStylesheets().add(getClass().getResource("mealsearcher.css").toExternalForm());
	}
	
	public void addAnotherIngredient() {
		VBox amount = new VBox();
		ARamountxt = new TextField();
		ARamountlbl = new Label ("Amount");
		amount.getChildren().addAll(ARamountlbl, ARamountxt);
		
		VBox ingredient = new VBox();
		ARingredient = new Label ("Ingredient");
		ARingredienttxt = new TextField();
		ingredient.getChildren().addAll(ARingredient, ARingredienttxt);
		
		HBox h = new HBox(15);
		h.getChildren().addAll(amount, ingredient);
		anotherIngredient.getChildren().add(h);
	}
	
	public void start() {
		stage.show();
	}
}
