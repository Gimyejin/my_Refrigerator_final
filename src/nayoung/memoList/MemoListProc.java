package nayoung.memoList;

//import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
//import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class MemoListProc{
	public void memolist() {
		System.out.println("장보기 메모로 이동");
	
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(getClass().getResource("/nayoung/memoList/MainLayout.fxml"));
			//
			Parent root = loader.load();

			//AnchorPane ap = (AnchorPane)loader.load();
			//
			Scene scene = new Scene(root,600,400);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			//MemoListController mlcl = loader.getController();
			//mlcl.setRoot(root);
			
			primaryStage.setTitle("Shopping List");
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	// 내가 test로 썼던거
//	public class MemoListProc extends Application{
//
//		@Override
//		public void start(Stage primaryStage) throws Exception {
//			try {
//				FXMLLoader loader = new FXMLLoader();
//				loader.setLocation(getClass().getResource("MainLayout.fxml"));
//				AnchorPane ap = (AnchorPane)loader.load();
//				Scene scene = new Scene(ap,600,400);
//				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
//				
//				primaryStage.setTitle("Shopping List");
//				primaryStage.setScene(scene);
//				primaryStage.show();
//			} catch(Exception e) {
//				e.printStackTrace();
//			}
//			
//		}
	
	//기존 memo로 연결때 썼던거
	//public class MemoProc {
//	public void memo() {
//		System.out.println("장보기 메모로 이동");
//		try {
//			Stage primaryStage = new Stage();
//			FXMLLoader loader = new FXMLLoader(getClass().getResource("memo.fxml"));
//			Parent root = loader.load();
//			Scene scene = new Scene(root);
//			
//			MemoController mcl = loader.getController();
//			mcl.setRoot(root);
//			
//			primaryStage.setScene(scene);
//			primaryStage.show();
//
//		}catch (Exception e) {
//			// TODO: handle exception
//			e.printStackTrace();
//		}
//	}
//}

}
=======
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

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

