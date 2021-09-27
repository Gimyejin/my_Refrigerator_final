package yegin.common;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.LoginButton_Controller;
import main.MainFunction_Controller;

public class Method {
	public void mfc(Stage primaryStage, String fxml) {//MainFunction_Controller와 연결
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));

			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/yegin/css/design.css").toString());
			
			MainFunction_Controller ctl = loader.getController();
			ctl.setRoot(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
}
