package yegin.alert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AlertController implements Initializable {
	Parent root;
	Parent newRoot;

	public void setRoot(Parent root) {
		this.root = root;
		System.out.println("root:" + root);// 값 잇음
	}

	public void setRoot2(Parent newRoot) {
		this.newRoot = newRoot;
		System.out.println("newRoot:" + newRoot);
	}

	public void alert() {
		System.out.println("알람 페이지로 넘어옴");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("alertList.fxml"));
		Parent newRoot = null;
		Scene sc = null;

		try {
			newRoot = loader.load();
			System.out.println("작동 여부");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc = new Scene(newRoot);
		sc.getStylesheets().add(getClass().getResource("../css/design.css").toString());
		

		Stage stage = (Stage) root.getScene().getWindow();
		AlertController ac = loader.getController();// 페이지가 또 만들어짐
		ac.setRoot2(newRoot);

		stage.setScene(sc);
		stage.show();
	}

	public static void atler(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}

	public void turnOnOff() {

	}

	public void back() {

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
