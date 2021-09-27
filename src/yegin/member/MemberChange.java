package yegin.member;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yegin.alert.AlertController;
import yegin.common.Method;

public class MemberChange {
	Parent root;
	Parent newRoot;
	Label id;
	Label name;
	TextField pw1;
	TextField pw2;

	public void setRoot(Parent root) {
		this.root = root;
	}

	private void setRoot2(Parent newRoot) {
		this.newRoot = newRoot;
		id = (Label)newRoot.lookup("#id");
	}

	public void change() {
		System.out.println("회원수정으로 넘어옴");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("mc.fxml"));
		Parent newRoot = null;
		Scene sc = null;

		try {
			newRoot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		sc = new Scene(newRoot);
		sc.getStylesheets().add(getClass().getResource("../css/design.css").toString());

		Stage stage = (Stage) root.getScene().getWindow();
		MemberChange mc = loader.getController();// 페이지가 또 만들어짐
		mc.setRoot(root);
		mc.setRoot2(newRoot);

		stage.setScene(sc);
		stage.show();
	}

	public void ok() {
		
	}
	public void back() {
		System.out.println("root값(이전페이지 루트임) " + root);
		System.out.println("newroot값" + newRoot);
		Method mt = new Method();
		mt.mfc((Stage) newRoot.getScene().getWindow(),"/main/frozenStorage_function.fxml");
		
		System.out.println("뒤로가기");
	}
}
