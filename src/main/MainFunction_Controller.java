package main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import nayoung.memo.MemoProc;
import nayoung.temp.TempProc;

public class MainFunction_Controller implements Initializable{
	Parent newRoot;
	MemoProc mc;
	TempProc tc;
	public void setRoot(Parent root) {
		this.newRoot = newRoot;
	}
	
	public void btnMemo() {
		mc.memo();
	}
	
	public void btnTemp() {
		tc.temp();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		mc = new MemoProc();
		tc = new TempProc();
	}
}
