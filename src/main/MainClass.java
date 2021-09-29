package main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainClass extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("login_page.fxml"));

		Parent root = loader.load();
		Scene scene = new Scene(root);

		LoginButton_Controller ctl = loader.getController();
		ctl.setRoot(root);
		scene.getStylesheets().add(getClass().getResource("/yegin/css/design.css").toString());
		primaryStage.setScene(scene);
		primaryStage.show();

	}

	public static void main(String[] args) {
		launch(args);

	}
}
