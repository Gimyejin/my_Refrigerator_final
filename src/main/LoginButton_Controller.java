package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


import javafx.fxml.FXMLLoader;

import geonhwe.Login.LoginProc;
import geonhwe.Login.LoginService;
import geonhwe.Login.LoginServiceImpl;
import geonhwe.member.MemberProc;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import yegin.css.Design;

public class LoginButton_Controller implements Initializable {
	Parent root;
	MemberProc mp;
	LoginProc lp;

	public void setRoot(Parent root) {
		this.root = root;
		System.out.println("로그인 컨트롤 버튼"+root);
		/*
		 * lp = new LoginProc(); mp = new MemberProc();
		 */

		Design design = new Design();
		design.setRoot(root);
		design.log();
	}

	public void btnLogin() {
		// lp.setRoot(root);
		// lp.loginCheck();
		lp.setRoot(root);
		lp.Login();
	}

	public void btnMemberShip() {
		mp.setRoot(root);
		mp.memberShip();

	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		mp = new MemberProc();
		lp = new LoginProc();

	}

	public void login() {
		System.out.println("메뉴페이지로 넘어감");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("menu.fxml"));
		Parent newRoot = null;
		Scene sc = null;
		try {
			newRoot = loader.load();
		} catch (IOException e) { // TODO Auto-generated catch block
			e.printStackTrace();
		}
		sc = new Scene(newRoot);
		sc.getStylesheets().add(getClass().getResource("/yegin/css/design.css").toString());//화면 꾸미기 연결 코드
		
		// scene만 바꿔치기
		Stage stage = (Stage) root.getScene().getWindow();

		MainFunction_Controller mc = loader.getController();
		mc.setRoot(newRoot);

		stage.setScene(sc);
		stage.show();

	}

}
