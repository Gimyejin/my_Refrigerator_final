package nayoung.memoList;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;

public class MemoListController implements Initializable{
	Parent root;
	MemoList ml;
	public void setRoot(Parent root) {
		this.root = root;
		ml.setRoot(root);
	}
	
	@FXML
    public Label  myLabel;
    
    @FXML
    public ComboBox<String> combobox;
    
    @FXML
    public ListView<String> listView;
    
    ObservableList<String> list = FXCollections.observableArrayList("우유", "계란", "양파", "사과");

	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		ml = new MemoListImpl();
		
		//combobox.setItems(list);
        //listView.setItems(list);
        listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

	}
	public void memoListProc() {
		System.out.println("리스트 클릭");
		ml.memoListProc();
	}
	
	public void comboChange(ActionEvent event) {
        myLabel.setText(combobox.getValue());
    }
    public void buttonAction(ActionEvent event) {
        //combobox.getItems().addAll("ㄱ", "ㄴ", "ㄷ", "ㄹ");
        //listView.getItems().addAll("ㄱ", "ㄴ", "ㄷ", "ㄹ");
        ObservableList<String> names;
        names = listView.getSelectionModel().getSelectedItems();
        for (String name : names) {
            System.out.println(name);
        }
    }



}
