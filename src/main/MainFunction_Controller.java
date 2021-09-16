package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import nayoung.memo.MemoProc;

public class MainFunction_Controller implements Initializable{
	Parent newRoot;
	MemoProc mc;
	
	public void setRoot(Parent root) {
		this.newRoot = newRoot;
	}
	
	public void btnMemo() {
		mc.memo();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mc = new MemoProc();
	}
}
