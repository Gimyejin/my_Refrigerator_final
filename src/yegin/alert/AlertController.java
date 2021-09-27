package yegin.alert;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import yegin.common.Method;

public class AlertController implements Initializable {
	Parent root;
	Parent newRoot;
	ListView<String> fxListview;
	ObservableList<String> listView;
	Scene sc;

	public void setRoot(Parent root) {
		this.root = root;// 이전 페이지 root
		System.out.println("root:" + root);
	}

	public void setRoot2(Parent newRoot) {
		this.newRoot = newRoot;// 현재 페이지 root

		fxListview = (ListView) newRoot.lookup("#viewList");
		System.out.println("fxListview:" + fxListview);
		setList();
	}

	private void setList() {
		System.out.println("알람 list임");
		listView = FXCollections.observableArrayList();
		for (int i = 1; i < 8; i++) {
			// 물품 들어갈때 수정할 것!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
			listView.add("갤럭시S" + i);

		}
		System.out.println(fxListview);
		fxListview.setItems(listView);
	}

	public void alert() {
		System.out.println("알람 페이지로 넘어옴");

		FXMLLoader loader = new FXMLLoader(getClass().getResource("alertList.fxml"));
		Parent newRoot = null;
		Scene sc = null;

		try {
			newRoot = loader.load();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		sc = new Scene(newRoot);
		sc.getStylesheets().add(getClass().getResource("../css/design.css").toString());

		Stage stage = (Stage) root.getScene().getWindow();
		AlertController ac = loader.getController();// 페이지가 또 만들어짐
		ac.setRoot(root);
		ac.setRoot2(newRoot);

		stage.setScene(sc);
		stage.show();
	}

	public static void atler(String mss, String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setHeaderText(msg);// 헤더 메시지
		alert.setContentText(mss);// 메시지 메인내용
		alert.show();
	}

	public void add() {
		System.out.println("추가");
	}
	public void del() {
		System.out.println("삭제");
	}

	public void turnOnOff() {
		System.out.println("전원 on/off");
	}

	public void back() {
		System.out.println("root값(이전페이지 루트임) " + root);
		System.out.println("newroot값" + newRoot);
		Method mt = new Method();
		mt.mfc((Stage) newRoot.getScene().getWindow(),"/main/frozenStorage_function.fxml");
		//sc = new Scene(root);
		
		//Stage stage = (Stage) root.getScene().getWindow();
		//System.out.println(root.getScene());
		//stage.setScene(sc);
		//stage.show();
		System.out.println("뒤로가기");
		
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {

	}

}
