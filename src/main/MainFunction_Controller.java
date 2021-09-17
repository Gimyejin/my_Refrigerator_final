package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import yegin.alert.AlertController;
import yegin.shelf_life.shelfLifeController;

public class MainFunction_Controller implements Initializable {
	Parent root;
	Parent newRoot;

	public void setRoot(Parent root) {
		this.root = root;
	}

	public void setRoot2(Parent root) {
		this.newRoot = root;
	}

	public void frozen_Storage() {
		System.out.println("냉동고 버튼 눌림");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("frozenStorage_function.fxml"));
		newRoot = null;
		Scene sc = null;
		try {
			// newRoot = loader.load();
			this.newRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc = new Scene(newRoot);
		Stage stage = (Stage) root.getScene().getWindow();

		MainFunction_Controller mc = loader.getController();// 페이지가 또 만들어짐
		mc.setRoot2(newRoot);
		stage.setScene(sc);
		stage.show();
	}

	public void alert() {
		System.out.println("알람");
		AlertController ac = new AlertController();
		ac.setRoot(newRoot);
		ac.alert();
	}

	public void cold_Storage() {
		System.out.println("냉장고 버튼 눌림");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("coldStorage_function.fxml"));
		newRoot = null;
		Scene sc = null;
		try {
			// newRoot = loader.load();
			this.newRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc = new Scene(newRoot);
		Stage stage = (Stage) root.getScene().getWindow();

		MainFunction_Controller mc = loader.getController();// 페이지가 또 만들어짐
		mc.setRoot2(newRoot);
		stage.setScene(sc);
		stage.show();
	}

	public void shelfLife() {
		System.out.println("유통기한버튼");
		shelfLifeController sc = new shelfLifeController();
		System.out.println(newRoot);
		sc.setRoot(newRoot);
		sc.shelfLifeList();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
