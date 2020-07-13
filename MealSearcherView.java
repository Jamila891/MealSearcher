package main;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MealSearcherView {
	
	private Stage stage;
	private MealSearcherModel model;
	Button btnSearch;
	TextField txtIngredient1, txtIngredient2;
	Label lblIngredient1, lblIngredient2;
	TextArea displayRezept;
	
	public MealSearcherView(Stage stage, MealSearcherModel model) {
		this.stage = stage;
		this.model = model;
		
		VBox root = new VBox(15);
		this.lblIngredient1 = new Label("Ingredient 1");
		this.lblIngredient2 = new Label("Ingredient 2");
		this.txtIngredient1 = new TextField();
		this.txtIngredient2 = new TextField();
		this.btnSearch = new Button("Search");
		this.displayRezept = new TextArea();
		
		root.getChildren().addAll(lblIngredient1, txtIngredient1, lblIngredient2, txtIngredient2, btnSearch, displayRezept);
		
		Scene scene = new Scene(root, 500, 500);
		stage.setScene(scene);
		stage.setTitle("Meal Searcher");
		stage.setResizable(false);
	}
	
	public void start() {
		stage.show();
	}
}
