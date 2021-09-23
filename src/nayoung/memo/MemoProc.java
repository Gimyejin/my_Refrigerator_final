package nayoung.memo;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MemoProc {
	public void memo() {
		System.out.println("장보기 메모로 이동");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader(getClass().getResource("memo.fxml"));
			Parent root = loader.load();
			Scene scene = new Scene(root);
			
			MemoController mcl = loader.getController();
			mcl.setRoot(root);
			
			primaryStage.setScene(scene);
			primaryStage.show();

		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
