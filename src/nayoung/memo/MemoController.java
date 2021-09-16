package nayoung.memo;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MemoController implements Initializable{
	Parent root;
	MemoListImpl ml;
	public void setRoot(Parent root) {
		this.root = root;
		ml.setRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ml = new MemoListImpl();
	}
	public void memoProc() {
		System.out.println("장보기 메모 클릭");
		ml.memoProc();
		
	}

}
