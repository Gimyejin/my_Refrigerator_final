package yegin.member;

import java.io.IOException;

import geonhwe.member.MemberDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yegin.alert.AlertController;
import yegin.shelf_life.ShelfLife_Method;

public class MemberDel {
	Parent root;
	Parent newRoot;
	TextField pw1;
	PasswordField pw2;
	MemberDTO dto;
	ShelfLife_Method sm;
	public void setRoot(Parent root) {
		this.root=root;
	}
	public void setRoot2(Parent newRoot) {
		this.newRoot=newRoot;
		pw1=(TextField)newRoot.lookup("#pw1");
		pw2=(PasswordField)newRoot.lookup("#pw2");
		sm=new ShelfLife_Method();
				
	}
	public void cancel() {
		Stage stage = (Stage)newRoot.getScene().getWindow();
	     stage.close();
	}
	public void memberdel() {
		if(pw1.getText().equals(pw2.getText())) {
			int result=sm.memberDel();
			if(result==1) {AlertController.atler("[나의 냉장고]를 이용해 주셔서 감사합니다.", "회원 탈퇴");
			Stage stage = (Stage)newRoot.getScene().getWindow();
		     stage.close();
			}
			else System.out.println("실패");
		}else {
			AlertController.atler("패스워드 확인을 다시 확인해주세요.", "불일치");
		}
	}
	public void delView() {
		System.out.println("회원탈퇴 비번입력창");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("memberDel.fxml"));
		newRoot = null;
		Scene sc = null;
		try {
			this.newRoot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc = new Scene(newRoot);
		Stage stage = (Stage) root.getScene().getWindow();
		

		MemberDel md = loader.getController();
		md.setRoot2(newRoot);
		stage.setScene(sc);
		stage.show();
		
	}

}
