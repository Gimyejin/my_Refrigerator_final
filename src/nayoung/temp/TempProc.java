package nayoung.temp;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class TempProc{
	public void temp() {
		System.out.println("온도조절로 이동");
		
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("temp.fxml"));
			
			Parent root = loader.load();
			
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			primaryStage.setTitle("INTERACTIVE DISPLAY");
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	

	

}
