package yegin.member;

import java.io.IOException;

import geonhwe.Login.LoginServiceImpl;
import geonhwe.member.MemberDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yegin.alert.AlertController;
import yegin.common.Method;
import yegin.shelf_life.ShelfLife_Method;

public class MemberChange {
	Parent root;
	Parent newRoot;
	Label id;
	Label name;
	TextField pw1;
	PasswordField pw2;
	ShelfLife_Method sm;
	MemberDTO dto;
	public void setRoot(Parent root) {
		this.root = root;
	}

	private void setRoot2(Parent newRoot) {
		this.newRoot = newRoot;
		sm = new ShelfLife_Method();
		id = (Label) newRoot.lookup("#id");
		name = (Label) newRoot.lookup("#name");

		pw1 = (TextField) newRoot.lookup("#pw1");
		pw2 = (PasswordField) newRoot.lookup("#pw2");
		labelView();
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

	public void labelView() {
		id.setText(LoginServiceImpl.staticid);
		name.setText(sm.loginChk(LoginServiceImpl.staticid).getName());
	}
	public void ok() {
		System.out.println("눌림");
		if (pw1.getText().equals(pw2.getText())) {
			 dto = new MemberDTO();
			dto.setId(id.getText());
			dto.setName(name.getText());
			dto.setPwd(pw1.getText());
			int result = sm.updatePw(dto);
			if (result == 1) {
				AlertController.atler("패스워드가 수정되었습니다", "회원정보");
			} else {
				AlertController.atler("패스워드가 수정이 실패하였습니다.", "회원정보");
			}
		}
		else {
			AlertController.atler("서로 다른 암호입니다.\n 다시 확인해주세요", "회원정보");
		}
	}

	public void back() {
		System.out.println("root값(이전페이지 루트임) " + root);
		System.out.println("newroot값" + newRoot);
		Method mt = new Method();
		mt.mfc((Stage) newRoot.getScene().getWindow(), "/main/frozenStorage_function.fxml");

		System.out.println("뒤로가기");
	}
}
