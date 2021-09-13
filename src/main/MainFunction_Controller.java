package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import yegin.shelf_life.shelfLifeController;

public class MainFunction_Controller implements Initializable {
	Parent root;

	public void setRoot(Parent root) {
		this.root = root;

	}

	public void cold_Storage() {
		System.out.println("냉장고 버튼 눌림");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("coldStorage_function.fxml"));
		Parent newRoot = null;
		Scene sc = null;
		try {
			newRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc = new Scene(newRoot);

		Stage stage = (Stage) root.getScene().getWindow();
		// stage에서 null이 나옴
		stage.setScene(sc);// 여기서 오류남
		stage.show();
	}

	public void shelfLife() {
		System.out.println("유통기한버튼");
		shelfLifeController sc = new shelfLifeController();
		sc.setRoot(root);
		sc.shelfLifeList();

	}

	public void alert() {
		System.out.println("알람");
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}

}
