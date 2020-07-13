import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javafx.event.ActionEvent;

public class MealSearcherModel {
	
	private URL url;
	private Path path;
	private List<String> lines;
	
	public List<String> readFile(String name) {
		url = this.getClass().getResource(name);
		try {
			path = Paths.get(url.toURI());
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		try {
			lines = Files.readAllLines(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}
	
	public void readAllFilesFromPackage() {
		
		File sourcePackage = new File("\\receips");
		
		for (File sourceFile : sourcePackage.listFiles()) {
		
			
		}
	}
}