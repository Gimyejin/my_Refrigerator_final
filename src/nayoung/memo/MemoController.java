package nayoung.memo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import nayoung.memoList.MemoListProc;

public class MemoController implements Initializable{
	Parent root;
	Memo m;
	MemoListProc mlc;
	public void setRoot(Parent root) {
		this.root = root;
		m.setRoot(root);
	}
	public void memoProc() {
		System.out.println("장보기 메모 클릭");
		m.memoProc();	
	}
	public void btnList01() {
		mlc.memoList();
	}
	public void btnList02() {
		mlc.memoList();
	}
	public void btnList03() {
		mlc.memoList();
	}
	public void btnList04() {
		mlc.memoList();
	}
	public void btnList05() {
		mlc.memoList();
	}
	public void btnList06() {
		mlc.memoList();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		m = new MemoImpl();
		mlc = new MemoListProc();
	}
}
