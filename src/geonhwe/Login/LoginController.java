package geonhwe.Login;

import java.net.URL;
import java.util.ResourceBundle;

import geonhwe.db.teamproject;
import geonhwe.member.MemberDTO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class LoginController implements Initializable {

	Parent root;
	LoginService ls;
	ToMenuProc tmp;
	
	public void setRoot(Parent root) {
		this.root = root;
		ls.setRoot(root); // root.값 넘기기
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ls = new LoginServiceImpl();
		tmp = new ToMenuProc();
	}

	public void login() {
		System.out.println("로그인");
		tmp.toMenu();
	}

}
