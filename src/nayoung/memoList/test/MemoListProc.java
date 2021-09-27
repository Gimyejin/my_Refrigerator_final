package nayoung.memoList.test;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import nayoung.memoList.MemoListController;

public class MemoListProc {
	public void memoList() {
		System.out.println("메모리스트창 열기");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("memolist.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			MemoListController mlcl = loader.getController();
			mlcl.setRoot(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

}
