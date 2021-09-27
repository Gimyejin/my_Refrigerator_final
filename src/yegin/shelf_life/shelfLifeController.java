package yegin.shelf_life;

import java.io.IOException;
import java.util.ArrayList;

import hayong.FoodDTO;
import hayong.FoodListController;
import hayong.HyDB;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.MainFunction_Controller;
import yegin.alert.AlertController;
import yegin.common.Method;

public class shelfLifeController {
	// 클릭시 해당 리스트로 넘어가기?
	Parent root;
	Parent newRoot;
	Parent otherRoot;
	ListView<String> fxListview;// 품목 명
	ListView<String> fxListview1;// 유통기한
	ObservableList<String> listView;
	ObservableList<String> listView1;
	ObservableList<Time> item;
	ArrayList<FoodDTO> list;
	HyDB db;
	String shelfday;
	ShelfLife_Method sm;
	AlertController ac;

	String itemN, itemT;

	public void setRoot(Parent root) {// 밖에서 이걸 건드림
		this.root = root;

	}

	private void setRoot2(Parent newRoot) {// 내부에서 건드림
		this.newRoot = newRoot;
		fxListview = (ListView) newRoot.lookup("#viewList");
		fxListview1 = (ListView) newRoot.lookup("#viewList1");

		setList();
	}

	private void setRoot3(Parent otherRoot) {// 업데이트 창 용
		this.otherRoot = otherRoot;
		shelfLifeComboBox();
		sm = new ShelfLife_Method();
		ac = new AlertController();

	}
	
	private void setItems(String itemN, String itemT) {
		this.itemN=itemN;
		this.itemT=itemT;
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
		// 품목명과 유통기한을 합침
		item = FXCollections.observableArrayList();
		db = new HyDB();
		list = new ArrayList<FoodDTO>();
		list = db.DbValue();

		for (int i = 0; i < list.size(); i++) {
			listView.add(list.get(i).getFoodName());
			listView1.add(list.get(i).getShelfLife());
			Time t = new Time(list.get(i).getFoodName(), list.get(i).getShelfLife());
			item.add(t);
			// System.out.println(listView);
		}
		fxListview.setItems(listView);
		fxListview1.setItems(listView1);

		fxListview1.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
			// System.out.println("observable(형식)" + observable);
			// System.out.println("oldValue(이전값)" + oldValue);

			System.out.println("newValue(현재값)" + newValue);
			System.out.println(listView1.get((int) newValue));
			//chlick(newValue, listView1.get((int) newValue));// 현재index와 현재 값
			System.out.println("품목 " + item.get((int) newValue).getItemName().getValue());
			System.out.println("유통기한 " + item.get((int) newValue).getLifeTime().getValue());

			itemN = item.get((int) newValue).getItemName().getValue();
			itemT = item.get((int) newValue).getLifeTime().getValue();

			
		});

		/*
		 * fxListview1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		 * 
		 * @Override public void handle(MouseEvent arg0) { chlick();
		 * 
		 * }
		 * 
		 * });
		 */

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	public void back() {
		System.out.println("뒤로 버튼");
		Method mt = new Method();
		mt.mfc((Stage) newRoot.getScene().getWindow(), "/main/coldStorage_function.fxml");

	}

	public void chage() {
		System.out.println("수정버튼");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("change_time.fxml"));
			otherRoot = loader.load();
			Scene scene = new Scene(otherRoot);

			shelfLifeController ctl = loader.getController();
			System.out.println("oterroot" + otherRoot);
			ctl.setRoot3(otherRoot);
			ctl.setItems(itemN, itemT);
			
			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		/*
		 * fxListview.getSelectionModel().selectedIndexProperty().addListener(new
		 * ChangeListener() { public void changed(ObservableValue observable, Object
		 * oldVal, Object newVal) { // 수행할 처리 }
		 * 
		 * ShelfLife_Method sm = new ShelfLife_Method();
		 * 
		 * //sm.update(list); } });
		 */
	}

	public void change() {// 수정시켜야함!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
		FoodDTO dto = new FoodDTO();
		dto.setShelfLife(shelfday);
		int result = sm.update(dto);
		if (result == 1) {
			ac.atler("성공", "수정");
		} else {
			ac.atler("실패", "수정");

		}
	}

	public void close() {
		System.out.println("눌림");
		Stage stage = (Stage) otherRoot.getScene().getWindow();
		stage.close();
	}

	public void shelfLifeComboBox() {// 유통기한
		ComboBox<String> year = (ComboBox<String>) otherRoot.lookup("#year");
		if (year != null) {
			year.getItems().addAll("2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030");
		}
		ComboBox<String> month = (ComboBox<String>) otherRoot.lookup("#month");
		if (month != null) {
			month.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
		}

		ComboBox<String> day = (ComboBox<String>) otherRoot.lookup("#day");
		ArrayList<String> allDay = new ArrayList<String>();

		month.setOnAction(e -> {
			System.out.println(month.getValue());
			day.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09");
			if (month.getValue() == "01" || month.getValue() == "03" || month.getValue() == "05"
					|| month.getValue() == "07" || month.getValue() == "08" || month.getValue() == "10"
					|| month.getValue() == "12") {

				for (int i = 10; i < 32; i++) {
					allDay.add(Integer.toString(i));
				}
			} else if (month.getValue() == "02") {
				for (int i = 10; i < 29; i++) {
					allDay.add(Integer.toString(i));
				}
			} else {
				for (int i = 10; i < 31; i++) {
					allDay.add(Integer.toString(i));
				}
			}
			for (String chday : allDay) {
				day.getItems().add(chday);
			}

			day.setOnAction(a -> {
				shelfday = year.getValue() + "년" + month.getValue() + "월" + day.getValue() + "일";
				System.out.println(shelfday);
			});

		});
	}

	/*public void chlick(Number newValue2, String time) {
		System.out.println(newValue2 + " " + time);
	}*/
}
