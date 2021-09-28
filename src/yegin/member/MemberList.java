package yegin.member;

import java.io.IOException;

import geonhwe.member.MemberDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.MainFunction_Controller;
import yegin.common.Method;
import yegin.shelf_life.ShelfLife_Method;

public class MemberList {
	Parent root;
	Parent newRoot;

	ShelfLife_Method sm;
	MemberDTO dto;

	public void setRoot(Parent root) {
		this.root = root;
	}
	public void setRoot2(Parent newRoot) {
		this.newRoot = newRoot;
	}
	public void view() {
		System.out.println("회원 정보 버튼 눌림");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("memberList.fxml"));
		newRoot = null;
		Scene sc = null;
		try {
			this.newRoot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc = new Scene(newRoot);
		Stage stage = (Stage) root.getScene().getWindow();
		sc.getStylesheets().add(getClass().getResource("/yegin/css/design.css").toString());// 화면 꾸미기 연결 코드

		MemberList ml = loader.getController();
		ml.setRoot2(newRoot);
		stage.setScene(sc);
		stage.show();
	}
	
	public void del() {
		
	}
	public void back() {
		Method mt = new Method();
		mt.mfc((Stage) newRoot.getScene().getWindow(), "/main/frozenStorage_function.fxml");

		System.out.println("뒤로가기");
	}
}
