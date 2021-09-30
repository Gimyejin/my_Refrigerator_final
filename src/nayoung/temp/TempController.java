package nayoung.temp;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.Spinner;

public class TempController implements Initializable{
	Parent root;
	TempFunc tf;
	
	public void setRoot(Parent root) {
		this.root = root;
		tf.setRoot(root);
	}
	
	@FXML
	private Label myLabel01, myLabel02;
	
	@FXML
	private Slider mySlider01, mySlider02;
	
	@FXML
	private Spinner mySpinner01, mySpinner02;
	
//	Slider mySlider01;
//	Label myLabel01;
//	
	int myTemperature;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		tf = new TempFuncImpl();
		
		
		myTemperature = (int) mySlider01.getValue();
		myLabel01.setText(Integer.toString(myTemperature)+ "°C");
		
		mySlider01.valueProperty().addListener(new ChangeListener<Number>(){
			
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				myTemperature = (int) mySlider01.getValue();
				myLabel01.setText(Integer.toString(myTemperature)+ "°C");
			}
		});
		
		myTemperature = (int) mySlider02.getValue();
		myLabel02.setText(Integer.toString(myTemperature)+ "°C");
		
		mySlider02.valueProperty().addListener(new ChangeListener<Number>(){
			
			public void changed(ObservableValue<? extends Number> arg0, Number arg1, Number arg2) {
				myTemperature = (int) mySlider02.getValue();
				myLabel02.setText(Integer.toString(myTemperature)+ "°C");
			}
		});
		
		
		
		mySlider01.valueProperty().bindBidirectional(
			    mySpinner01.getValueFactory().valueProperty());
		
		mySlider02.valueProperty().bindBidirectional(
			    mySpinner02.getValueFactory().valueProperty());
		
	}
	public void tempProc() {
		System.out.println("온도조절 버튼 클릭");
		tf.tempProc();
	}

}
