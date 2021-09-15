package yegin.alert;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class alertController {
	public static void atler(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
}
