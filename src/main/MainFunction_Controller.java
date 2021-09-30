package main;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import nayoung.memo.MemoProc;
import nayoung.memoList.MemoListProc;
import nayoung.temp.TempProc;

import geonhwe.Login.LoginService;
import geonhwe.Login.LoginServiceImpl;

import geonhwe.member.MemberService;
import geonhwe.member.MemberServiceImpl;

import hayong.FoodListController;
import hayong.HyMain;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

import javafx.scene.image.ImageView;

import javafx.stage.Stage;
import yegin.alert.AlertController;

import yegin.shelf_life.shelfLifeController;
import yegin.common.Method;

import yegin.css.Design;
import yegin.member.MemberChange;
import yegin.member.MemberList;
import yegin.shelf_life.shelfLifeController;

public class MainFunction_Controller implements Initializable {
	Parent root;
	Parent newRoot;
	MemberService ms;
	MemoListProc mlc;
	TempProc tc;
	hayong.HyMain hy;
	ImageView food;
	Design design;

	public void setRoot(Parent root) {
		this.root = root;
		ms.setRoot(root);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

		ms = new MemberServiceImpl();
		mlc = new MemoListProc();
		tc = new TempProc();
		hy = new HyMain();

	}
	public void logout() {
		LoginServiceImpl.staticid = null;
		MainClass mc = new MainClass();
		Stage primaryStage = new Stage();
		try {
			mc.start(primaryStage);
			Stage stage = (Stage) root.getScene().getWindow();
			stage.close();
			AlertController.atler("로그아웃 합니다", "로그아웃");

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		mlc.memolist();
	}

	public void btnTemp() {
		tc.temp();
	}

	public void setRoot2(Parent root) {
		this.newRoot = root;

		design = new Design();
		design.menu(newRoot);	
	}
	public void setRoot3(Parent root) {
		this.newRoot = root;
	}

	public void frozen_Storage() {
		System.out.println("냉동고 버튼 눌림");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("frozenStorage_function.fxml"));
		newRoot = null;
		Scene sc = null;
		try {
			// newRoot = loader.load();
			this.newRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc = new Scene(newRoot);
		Stage stage = (Stage) root.getScene().getWindow();

		MainFunction_Controller mc = loader.getController();

		mc.setRoot3(newRoot);
		sc.getStylesheets().add(getClass().getResource("/yegin/css/design.css").toString());// 화면 꾸미기 연결 코드

		stage.setScene(sc);
		stage.show();
	}

	public void memberchange() {
		MemberChange memberC = new MemberChange();
		memberC.setRoot(newRoot);
		memberC.change();
	}

	/*
	 * public void alert() { System.out.println("알람"); AlertController ac = new
	 * AlertController(); ac.setRoot(newRoot); ac.alert(); }
	 */

	public void member() {
		MemberList ml = new MemberList();
		ml.setRoot(newRoot);
		ml.view();
	}

	public void cold_Storage() {
		System.out.println("냉장고 버튼 눌림");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("coldStorage_function.fxml"));
		newRoot = null;
		Scene sc = null;
		try {
			// newRoot = loader.load();
			this.newRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc = new Scene(newRoot);
		Stage stage = (Stage) root.getScene().getWindow();
		sc.getStylesheets().add(getClass().getResource("/yegin/css/design.css").toString());// 화면 꾸미기 연결 코드

		MainFunction_Controller mc = loader.getController();
		mc.setRoot2(newRoot);
		stage.setScene(sc);
		stage.show();
	}

	public void shelfLife() {
		System.out.println("유통기한버튼");
		shelfLifeController sc = new shelfLifeController();
		System.out.println(newRoot);
		sc.setRoot(newRoot);
		sc.shelfLifeList();

	}

	public void food() {
		System.out.println("관리로이동");
		hy.foodScene();
	}

	public void back() {
		Method mt = new Method();
		if (newRoot == null) {
			mt.mfc((Stage) root.getScene().getWindow(), "/main/menu.fxml");
		} else {
			mt.mfc((Stage) newRoot.getScene().getWindow(), "/main/menu.fxml");
		}

	}


	public void setRoot4(Parent root) {
		this.newRoot = root;
	}

	public void setRoot5(Parent root) {
		this.newRoot = root;
		design = new Design();
		design.menuHome(newRoot);
	}
}
