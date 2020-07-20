package jamila.app.mealsearcher;
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
	Button btnSearch, btnRecipeWeblink, ARaddRecipebtn;
	TextField txtIngredient1, txtIngredient2, ARnametxt, ARurltxt, ARamountxt, ARingredienttxt, ARinstructionstxt;
	Label lblIngredient1, lblIngredient2, ARnamelbl, ARurllbl, ARingredientlbl, ARinstructionslbl, ARamountlbl, ARingredient;
	TextArea displayRezept;
	
	public MealSearcherView(Stage stage, MealSearcherModel model) {
		this.stage = stage;
		this.model = model;
		
		VBox root = new VBox();
		
		VBox searchRecipe = new VBox(15);
		this.lblIngredient1 = new Label("Ingredient 1");
		this.lblIngredient2 = new Label("Ingredient 2");
		this.txtIngredient1 = new TextField();
		this.txtIngredient2 = new TextField();
		this.btnSearch = new Button("Search");
		this.displayRezept = new TextArea();
		this.btnRecipeWeblink = new Button("Find this recipe online!");
		
		searchRecipe.getChildren().addAll(lblIngredient1, txtIngredient1, lblIngredient2, txtIngredient2, btnSearch, displayRezept, btnRecipeWeblink);
		
		VBox addNewRecipe = new VBox(15);
		
		VBox labels = new VBox(15);
		this.ARnamelbl = new Label("Name");
		this.ARinstructionslbl = new Label ("Instructions");
		this.ARurllbl = new Label("Weblink to Recipe");
		this.ARingredientlbl = new Label ("Ingredients");
		labels.getChildren().addAll(ARnamelbl, ARinstructionslbl, ARurllbl, ARingredientlbl);
		
		VBox textfields = new VBox();
		this.ARnametxt = new TextField();
		this.ARinstructionstxt = new TextField();
		this.ARurltxt = new TextField();
		
		VBox amount = new VBox();
		this.ARamountxt = new TextField();
		this.ARamountlbl = new Label ("Amount");
		amount.getChildren().addAll(ARamountlbl, ARamountxt);
		
		VBox ingredient = new VBox();
		this.ARingredient = new Label ("Ingredient");
		this.ARingredienttxt = new TextField();
		ingredient.getChildren().addAll(ARingredient, ARingredienttxt);
		
		HBox h = new HBox();
		h.getChildren().addAll(amount, ingredient);
		
		textfields.getChildren().addAll(ARnametxt, ARinstructionstxt, ARurltxt, h);
		
		HBox hbox = new HBox();
		hbox.getChildren().addAll(labels, textfields);
		
		this.ARaddRecipebtn = new Button ("Add Recipe");
		
		addNewRecipe.getChildren().addAll(hbox, ARaddRecipebtn);
		
		Tab searchRecipeTab = new Tab ("Search for Recipes");
		searchRecipeTab.setContent(searchRecipe);
		searchRecipeTab.setClosable(false);
		
		Tab addRecipe = new Tab("Add new Recipe");
		addRecipe.setContent(addNewRecipe);
		addRecipe.setClosable(false);
		
		TabPane tabPane = new TabPane();
		tabPane.getTabs().addAll(searchRecipeTab, addRecipe);
		
		root.getChildren().addAll(tabPane, searchRecipe, addNewRecipe);
		
		Scene scene = new Scene(root, 900, 500);
		stage.setScene(scene);
		stage.setTitle("Meal Searcher");
		stage.setResizable(true);
	}
	
	public void start() {
		stage.show();
	}
}
