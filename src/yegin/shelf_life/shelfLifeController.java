package yegin.shelf_life;

import java.io.IOException;
import java.util.ArrayList;

import hayong.FoodDTO;
import hayong.HyDB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.MainFunction_Controller;
import yegin.common.Method;

public class shelfLifeController {
	//클릭시 해당 리스트로 넘어가기?
	Parent root;
	Parent newRoot;
	ListView<String> fxListview;
	ListView<String> fxListview1;
	ObservableList<String> listView;
	ObservableList<String> listView1;

	public void setRoot(Parent root) {// 밖에서 이걸 건드림
		this.root = root;
		
	}

	private void setRoot2(Parent newRoot) {// 내부에서 건드림
		this.newRoot = newRoot;
		fxListview = (ListView) newRoot.lookup("#viewList");
		fxListview1 = (ListView) newRoot.lookup("#viewList1");
		
		setList();
	}

	public void shelfLifeList() {
		System.out.println("유통기한 페이지로 넘어옴");
		
		System.setProperty("prism.lcdtext", "false");

		Font.loadFont(getClass().getResourceAsStream("/resources/Arial_Black.ttf"), 10);
		Font.loadFont(getClass().getResourceAsStream("/resources/Arial_Narrow.ttf"), 10);
////////////////////////////////////////////////////////////////////////////////////////////////////
		
		FXMLLoader loader = new FXMLLoader(getClass().getResource("shelfLife.fxml"));
		Parent newRoot = null;
		Scene sc = null;
		try {
			newRoot = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sc = new Scene(newRoot);
		sc.getStylesheets().add(getClass().getResource("../css/design.css").toString());
		
		Stage stage = (Stage) root.getScene().getWindow();
		shelfLifeController slc = loader.getController();// 페이지가 또 만들어짐
		slc.setRoot2(newRoot);

		stage.setScene(sc);
		stage.show();
	}

	private void setList() {
		System.out.println("list까지옴");
		listView = FXCollections.observableArrayList();
		listView1 = FXCollections.observableArrayList();
		HyDB db = new HyDB();
		ArrayList<FoodDTO> list = new ArrayList<FoodDTO>();
		list =db.DbValue();
		
		
		
		for (int i = 0; i < list.size(); i++) {
			listView.add(list.get(i).getFoodName());
			listView1.add( list.get(i).getShelfLife());
			//System.out.println(listView);
		}
		System.out.println(fxListview);
		fxListview.setItems(listView);
		fxListview1.setItems(listView1);
	}
	public void  back() {
		System.out.println("뒤로 버튼");
		Method mt = new Method();
		mt.mfc((Stage) newRoot.getScene().getWindow(),"/main/coldStorage_function.fxml");
		
	}
	public void chage() {
		System.out.println("수정버튼");
	}
}
