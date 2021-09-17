package main;

import java.net.URL;
import java.util.ResourceBundle;

import geonhwe.Login.LoginProc;
import geonhwe.Login.LoginService;
import geonhwe.Login.LoginServiceImpl;
import geonhwe.member.MemberProc;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

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
	

}
