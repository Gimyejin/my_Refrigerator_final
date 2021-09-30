<<<<<<< HEAD
package geonhwe.member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import geonhwe.common.*;
import geonhwe.member.*;

public class MemberController implements Initializable{
	Parent root;
	MemberServiceImpl ms;
	public void setRoot(Parent root) {
		this.root = root;
		}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MemberServiceImpl();
	}
	public void membershipProc() {
		ms.setRoot(root);
		System.out.println("회원가입 클릭");
		ms.membershipProc();
	}
	public void memberCancle() {
		System.out.println("취소 클릭");
		ms.setRoot(root);
		ms.memberCancle();
	}
}




=======
package geonhwe.member;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import geonhwe.common.*;
import geonhwe.member.*;

public class MemberController implements Initializable{
	Parent root;
	MemberServiceImpl ms;
	public void setRoot(Parent root) {
		this.root = root;
		}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = new MemberServiceImpl();
	}
	public void membershipProc() {
		ms.setRoot(root);
		System.out.println("회원가입 클릭");
		ms.membershipProc();
	}
	public void memberCancle() {
		System.out.println("취소 클릭");
		ms.setRoot(root);
		ms.memberCancle();
	}
}




>>>>>>> 31984e95ca50f26e3426c2a3987c1e85d903d458
