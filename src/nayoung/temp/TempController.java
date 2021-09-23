package nayoung.temp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class TempController implements Initializable{
	Parent root;
	TempFunc tf;
	public void setRoot(Parent root) {
		this.root = root;
		tf.setRoot(root);
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tf = new TempFuncImpl();
	}
	public void tempProc() {
		System.out.println("온도조절 버튼 클릭");
		tf.tempProc();
	}

}
