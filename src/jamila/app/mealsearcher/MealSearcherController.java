package jamila.app.mealsearcher;
import java.awt.Desktop;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.List;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.control.Hyperlink;
import javafx.scene.layout.VBox;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class MealSearcherController {
	
	private MealSearcherModel model;
	private MealSearcherView view;
	private Recipe recipe;
	
	public MealSearcherController(MealSearcherView view, MealSearcherModel model) {
		this.view = view;
		this.model = model;
		
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		view.txtIngredient1.textProperty().addListener((observable, oldValue, newValue) -> setTextToProperty(newValue));
		
		view.btnSearch.setOnAction(this::setTextOfChosenRecipe);
		view.btnRecipeWeblink.setOnAction(this::openRecipeWeblink);
		view.btnAddRecipe.setOnAction(this::addRecipe);
		
	}
	
	public void setTextToProperty (String newValue) {
		model.setIngredient1(newValue);
		model.setIngredient2(newValue);
	}
	
	public void setTextOfChosenRecipe(ActionEvent event) {
		Recipe r = model.findYourRecipe();
		System.out.println(r.toString());
	
		//view.displayRezept.setText(r.toString());
	}
	
	public void openRecipeWeblink(ActionEvent e) {
		String url = model.getURL();
		try {
			  Desktop desktop = java.awt.Desktop.getDesktop();
			  URI oURL = new URI(url);
			  try {
				desktop.browse(oURL);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			} catch (URISyntaxException ex) {
			  ex.printStackTrace();
			}
	}
	
	public void addRecipe (ActionEvent e) {
		
	
	}
}







