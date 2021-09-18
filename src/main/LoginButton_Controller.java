package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

<<<<<<< HEAD
import javafx.fxml.FXMLLoader;
=======
import geonhwe.Login.LoginProc;
import geonhwe.Login.LoginService;
import geonhwe.Login.LoginServiceImpl;
import geonhwe.member.MemberProc;
>>>>>>> 4ccacdeb75be3f91b9244213f81d37759141efc3
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginButton_Controller implements Initializable{
	Parent root;
	MemberProc mp;
	LoginProc lp;
	
	public void setRoot(Parent root) {
		this.root=root;
	/*	lp = new LoginProc();
		mp = new MemberProc(); */
	}
	public void btnLogin() {
		//lp.setRoot(root);
		//lp.loginCheck();
		
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
