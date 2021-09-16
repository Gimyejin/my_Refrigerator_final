package nayoung.memoList;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MemoListController implements Initializable{
	Parent root;
	MemoList ml;
	public void setRoot(Parent root) {
		this.root = root;
		ml.setRoot(root);
	}
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ml = new MemoListImpl();
		
	}
	public void memoListProc() {
		System.out.println("리스트 클릭");
		ml.memoListProc();
	}

}
