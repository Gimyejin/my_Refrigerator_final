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
import javafx.scene.layout.BorderPane;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import main.MainFunction_Controller;
import yegin.alert.AlertController;
import yegin.common.Method;
import yegin.css.Design;

public class shelfLifeController  extends BorderPane{
	// 클릭시 해당 리스트로 넘어가기?
	Parent root;
	Parent newRoot;
	Parent otherRoot;
	ListView<String> fxListview;// 품목 명
	ListView<String> fxListview1;// 유통기한
	Label itemName;
	Label old_time;
	ObservableList<String> listView;
	ObservableList<String> listView1;
	ObservableList<Time> item;
	ArrayList<FoodDTO> list;
	HyDB db;
	String shelfday;
	ShelfLife_Method sm;
	AlertController ac;
	shelfLifeController ctl;
	String itemN, itemT;
	Design design;
	
	public void setRoot(Parent root) {// 밖에서 이걸 건드림
		this.root = root;

	}

	private void setRoot2(Parent newRoot) {// 내부에서 건드림
		this.newRoot = newRoot;
		
		design = new Design();
		design.time(newRoot);
		
		fxListview = (ListView) newRoot.lookup("#viewList");
		fxListview1 = (ListView) newRoot.lookup("#viewList1");
		setList();
	}

	private void setRoot3(Parent otherRoot) {// 업데이트 창 용
		this.otherRoot = otherRoot;
		shelfLifeComboBox();
		sm = new ShelfLife_Method();
		ac = new AlertController();
		itemName = (Label) otherRoot.lookup("#itemName");
		old_time = (Label) otherRoot.lookup("#old_time");

	}

	private void setItems(String itemN, String itemT) {
		this.itemN = itemN;
		this.itemT = itemT;

		itemName.setText(itemN);
		old_time.setText(itemT);
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
		// System.out.println(listView);
		fxListview.setItems(listView);
		fxListview1.setItems(listView1);

		fxListview1.getSelectionModel().selectedIndexProperty().addListener((observable, oldValue, newValue) -> {
			// System.out.println("observable(형식)" + observable);
			// System.out.println("oldValue(이전값)" + oldValue);

			System.out.println("newValue(현재값)" + newValue);
			System.out.println(listView1.get((int) newValue));

			System.out.println("품목 " + item.get((int) newValue).getItemName().getValue());
			System.out.println("유통기한 " + item.get((int) newValue).getLifeTime().getValue());
			 
			itemN = item.get((int) newValue).getItemName().getValue();
			itemT = item.get((int) newValue).getLifeTime().getValue();
		});

	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////

	public void back() {
		System.out.println("뒤로 버튼");
		Method mt = new Method();
		mt.mfc2((Stage) newRoot.getScene().getWindow(), "/main/coldStorage_function.fxml");
		
		
	}

	public void chage() {
		System.out.println("수정버튼");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("change_time.fxml"));
			otherRoot = loader.load();
			Scene scene = new Scene(otherRoot);

			shelfLifeController ctl = loader.getController();
			ctl.setRoot3(otherRoot);
			ctl.setItems(itemN, itemT);
			ctl.setRoot2(newRoot);

			primaryStage.setScene(scene);
			primaryStage.show();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void change() {
		if (shelfday==null) {
			ac.atler("유통기한을 입력하세요.", "수정");
		} else {
			FoodDTO dto = new FoodDTO();
			dto.setShelfLife(itemT);
			dto.setFoodName(itemN);
			int result = sm.update(shelfday, dto);
			if (result == 1) {
				ac.atler("유통기한 수정이 완료되었습니다.", "수정");
				close();
				setList();
			} else {
				ac.atler("유통기한 수정이 실패하였습니다.", "수정");
			}
		}
	}

	public void close() {
		System.out.println("닫힘");
		Stage stage = (Stage) otherRoot.getScene().getWindow();
		stage.close();
		setRoot2(newRoot);
		setList();
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
				shelfday = year.getValue() + "년 " + month.getValue() + "월 " + day.getValue() + "일";
				System.out.println("수정된 유통기한 체크: " + shelfday);
			});

		});
	}
}

