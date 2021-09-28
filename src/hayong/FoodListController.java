package hayong;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

import geonhwe.Login.LoginServiceImpl;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import main.MainFunction_Controller;
import yegin.common.Method;

public class FoodListController implements Initializable{
	Parent root;
	ListView<String> fxNameView;
	ListView<String> fxcntView;
	ListView<String> fxtimeView;
	ArrayList<FoodDTO> dtolist;
	AnchorPane pane;
	ObservableList<String> NameString,timeString, cntString, lifeString;
	HyDB hb;
	Button btnmod, btnrm;
	ComboBox<String> year, month, day;
	String shelfday;

	public void setRoot(Parent root) {
		this.root = root;
		fxNameView = (ListView)root.lookup("#fxNameView");
		fxcntView = (ListView)root.lookup("#fxcntView");
		fxtimeView = (ListView)root.lookup("#fxtimeView");
		addComboBox();
		shelfLifeComboBox();
		Label fxname = (Label)root.lookup("#fxname");
		fxname.setText(LoginServiceImpl.staticid+" 님의 냉장고");
		setListView();
		btnmod = (Button)root.lookup("#mod");
		btnrm = (Button)root.lookup("#rm");
		btnmod.setDisable(true);
		btnrm.setDisable(true);
		fxNameView.setOnMousePressed(e->{
			btnmod.setDisable(false);
			btnrm.setDisable(false);
		});
		pane = (AnchorPane)root.lookup("#pane");
		pane.setOnMousePressed(e->{
			btnmod.setDisable(true);
			btnrm.setDisable(true);
		});

	}
	public void addComboBox() {
		ComboBox<String> cnt = (ComboBox<String>)root.lookup("#fxcount");
		if(cnt != null) {
			cnt.getItems().addAll("1","2","3","4","5","6","7","8","9","10"
					,"11","12","13","14","15","16","17","18","19","20");
	}

	}
	
	public void setListView() { //디비에서값을받아와 fx리스트에 세팅
		fxNameView.getItems().clear();
		fxcntView.getItems().clear();
		fxtimeView.getItems().clear();
		NameString = FXCollections.observableArrayList();
		cntString = FXCollections.observableArrayList();
		timeString = FXCollections.observableArrayList();
		lifeString = FXCollections.observableArrayList();
		NameString.add("음식");
		cntString.add("수량");
		timeString.add("추가날짜");
		
		ArrayList<FoodDTO> list = hb.DbValue();
		//for(int i=0;i<list.size();i++) {
		//	System.out.println(list.get(i).getFoodName());
		//	System.out.println(list.get(i).getFoodNum());
		//	System.out.println(list.get(i).getFoodTime());
		//}
		if(list!=null) {
			for(int i=0;i<list.size();i++) {
				NameString.add(list.get(i).getFoodName());
				cntString.add(list.get(i).getFoodNum());
				timeString.add(list.get(i).getFoodTime());
				lifeString.add(list.get(i).getOldName());
			}
		} 
			fxNameView.setItems(NameString);
			fxcntView.setItems(cntString);
			fxtimeView.setItems(timeString);
		
			
	}
	
	public void fxadd() { //추가기능
		
		TextArea food = (TextArea)root.lookup("#fxaddtext");
		ComboBox<String> com = (ComboBox<String>)root.lookup("#fxcount"); //입력값 set
		FoodDTO dto = new FoodDTO(); 
		if(food==null) {
			Alert alt = new Alert(AlertType.INFORMATION);
			alt.setContentText("추가할 음식과 수량을 입력해주세요");
			alt.show(); return;
		}
		dto.setFoodName(food.getText());
		dto.setFoodNum(getComboBox());
		dto.setShelfLife(shelfday);
		Date date = new Date(); 
		SimpleDateFormat s = new SimpleDateFormat("MM월 dd일 aa hh시"); //현재시간
		String str = s.format(date);
		dto.setFoodTime(str);
		System.out.println(dto.getFoodName()+" "+dto.getFoodNum());
		int result = hb.insert(dto);
		if(result==1) {
			Label fxmsg = (Label)root.lookup("#fxmsg");
			fxmsg.setText("추가되었습니다");
		} else {
			Alert alt = new Alert(AlertType.INFORMATION);
			alt.setContentText("실패");
			alt.show();
		}
		setListView();

	}

	public void fxmod() { //수정기능
		FoodDTO dtomod = new FoodDTO(); 
		//fxNameView.getSelectionModel().selectedIndexProperty().
		//addListener((observable, oldValue, newValue)->{
		//	dtomod.setOldName(NameString.get((int)newValue));	//마우스로 선택한값 set
		//});
		System.out.println(dtomod.getOldName());
		ObservableList<String> a = fxNameView.getSelectionModel().getSelectedItems();
		dtomod.setOldName(a.get(0));
		TextArea food = (TextArea)root.lookup("#fxaddtext");
		ComboBox<String> com = (ComboBox<String>)root.lookup("#fxcount"); //입력값 set	
		System.out.println(dtomod.getFoodName()+" "+dtomod.getFoodNum());
		dtomod.setFoodName(food.getText());
		dtomod.setFoodNum(getComboBox());
		int result = hb.update(dtomod);
		if(result==1) {
			Label fxmsg = (Label)root.lookup("#fxmsg");
			fxmsg.setText("수정되었습니다");
		}else {
			Alert alt = new Alert(AlertType.INFORMATION);
			alt.setContentText("실패");
			alt.show(); return;
		}
		setListView();

	}
	
	public void fxrm() { //삭제기능
		FoodDTO dtorm = new FoodDTO(); 
		//fxNameView.getSelectionModel().selectedIndexProperty().
		//addListener((observable, oldValue, newValue)->{
		//	dtorm.setFoodName(NameString.get((int)newValue));	//마우스로 선택한값 set
		//	dtorm.setFoodNum(cntString.get((int)newValue));
		//	dtorm.setFoodTime(timeString.get((int)newValue));
		//});
		ObservableList<String> a = fxNameView.getSelectionModel().getSelectedItems();
		dtorm.setFoodName(a.get(0));
		System.out.println(dtorm.getFoodName()+" "+dtorm.getFoodNum());
		int result = hb.remove(dtorm);
		if(result==1) {
			Label fxmsg = (Label)root.lookup("#fxmsg");
			fxmsg.setText("삭제되었습니다");
		}else {
			Alert alt = new Alert(AlertType.INFORMATION);
			alt.setContentText("실패");
			alt.show(); 
		}
		fxNameView.getItems().remove(dtorm.getFoodName());
		fxcntView.getItems().remove(dtorm.getFoodNum());
		fxtimeView.getItems().remove(dtorm.getFoodTime());
		setListView();
		
		
	}
	public void fxCan() { //뒤로가기
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}
	public String getComboBox() {
		ComboBox<String> cnt = (ComboBox<String>)root.lookup("#fxcount");
		String su = null;
		if(cnt.getValue() == null) {
			su= "1";
		}else {
			su = cnt.getValue().toString();
		}
		return su;
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		hb = new HyDB();
		
	}
	
	public void shelfLifeComboBox() {// 유통기한
		ComboBox<String> year = (ComboBox<String>) root.lookup("#year");
		if (year != null) {
			year.getItems().addAll("2021", "2022", "2023", "2024", "2025", "2026", "2027", "2028", "2029", "2030");
		}
		ComboBox<String> month = (ComboBox<String>) root.lookup("#month");
		if (month != null) {
			month.getItems().addAll("01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12");
		}

		ComboBox<String> day = (ComboBox<String>) root.lookup("#day");
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
				 shelfday = year.getValue() +"년 "+ month.getValue() + "월 "+day.getValue()+"일";
				System.out.println(shelfday);
			});

		});
	}
}	

