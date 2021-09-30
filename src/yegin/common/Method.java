package yegin.common;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.LoginButton_Controller;
import main.MainFunction_Controller;
<<<<<<< HEAD
import yegin.css.Design;

public class Method {
	Design design = new Design();;
	
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

	public void mfc2(Stage primaryStage, String fxml) {// 메뉴 디자인이 필요함
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));

			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/yegin/css/design.css").toString());

			MainFunction_Controller ctl = loader.getController();
			ctl.setRoot4(root);
			design = new Design();
			design.menu(root);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void mfc3(Stage primaryStage, String fxml) {// setRoot4에 루트값 넘김용
		try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));

			Parent root = loader.load();
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/yegin/css/design.css").toString());

			MainFunction_Controller ctl = loader.getController();
			ctl.setRoot4(root);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
