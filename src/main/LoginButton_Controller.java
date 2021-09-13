package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginButton_Controller implements Initializable{
	Parent root;
	public void setRoot(Parent root) {
		this.root=root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	public void login() {
		System.out.println("메뉴페이지로 넘어감");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
		Parent newRoot = null;
		Scene sc = null;
		try {
			newRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc = new Scene(newRoot);

		// scene만 바꿔치기
		Stage stage = (Stage) root.getScene().getWindow();
		
		MainFunction_Controller mc=loader.getController();
		mc.setRoot(newRoot);
		
		stage.setScene(sc);
		stage.show();

	}

}
