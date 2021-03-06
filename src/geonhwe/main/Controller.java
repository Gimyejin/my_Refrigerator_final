package geonhwe.main;

import java.net.URL;
import java.util.ResourceBundle;

import geonhwe.db.*;
import geonhwe.member.*;
import geonhwe.member.MemberDTO;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;

public class Controller implements Initializable{
	Parent root;
	public static teamproject db;
	public void setRoot(Parent root) {
		this.root = root;
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		db = new teamproject();
		
	}
	public void membership() {
		TextField id = (TextField)root.lookup("#memberId");
		TextField name = (TextField)root.lookup("#memberName");
		TextField pwd = (TextField)root.lookup("#memberPwd");
		
		MemberDTO dto = new MemberDTO();
		dto.setId( id.getText() );
		dto.setPwd( pwd.getText() );
		dto.setName( name.getText() );
		
		int result = db.insert(dto);
		if(result ==1) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("회원가입에 성공하셨습니다");
			alert.show();
		}else {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("동일한 아이디가 존재합니다");
			alert.show();
		}
	}
	public void login() {

		TextField id = (TextField)root.lookup("#fxId");
		TextField pwd = (TextField)root.lookup("#fxPwd");
		TextField name = (TextField)root.lookup("#fxName");
		
		MemberDTO dto = db.loginChk(id.getText());
		if(dto == null) {
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setContentText("존재하지 않는 아이디 입니다");
			alert.show();
		}else {
			if( dto.getPwd().equals(pwd.getText()) ) {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("인증 성공 입니다");
				alert.show();
			}else {
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setContentText("비밀번호가 틀립니다.");
				alert.show();
			}
		}
	}
}
