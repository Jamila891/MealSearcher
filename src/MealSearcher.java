import javafx.application.Application;
import javafx.stage.Stage;

public class MealSearcher extends Application {
	
	private MealSearcherView view;
	private MealSearcherModel model;
	private MealSearcherController controller;

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		model = new MealSearcherModel();
		view = new MealSearcherView(stage, model);
		controller = new MealSearcherController(view, model);
		
		view.start();
	}	
}
