package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import nayoung.memo.MemoProc;
import nayoung.temp.TempProc;

import geonhwe.Login.LoginService;
import geonhwe.Login.LoginServiceImpl;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import geonhwe.member.*;


public class MainFunction_Controller implements Initializable{
	Parent root;
	//Parent newRoot;
	MemberService ms;
	MemoProc mc;
	TempProc tc;
	public void setRoot(Parent root) {
		this.root = root;
		ms.setRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ms = (MemberService) new MemberServiceImpl();
		mc = new MemoProc();
		tc = new TempProc();
	}
	public void membershipProc() {
		System.out.println("회원가입 클릭");
		ms.membershipProc();
	}
	public void memberCancle() {
		System.out.println("취소 클릭");
		ms.memberCancle();
	}
	
	public void btnMemo() {
		mc.memo();
	}
	
	public void btnTemp() {
		tc.temp();
	}
}
