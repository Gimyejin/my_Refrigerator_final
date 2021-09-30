package geonhwe.member;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import geonhwe.member.MemberController;

public class MemberProc {
	Parent root; //빈껍데기 root생성
	public void memberShip() {
		System.out.println("회원으로 이동");
		try {
			Stage primaryStage = new Stage();
			FXMLLoader loader = 
					new FXMLLoader(getClass().getResource("membership.fxml"));
			Parent root1 = loader.load();
			Scene scene = new Scene(root1);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			MemberController ctl = loader.getController();
			ctl.setRoot(root1);
			
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
						//이형태로 내용을 가지고오겠다, root라는 변수 안에 내용들을 넣어준다.
	public void setRoot(Parent root) { //매개변수 매개변수를 빈껍데기 root에 넣겠다.
		this.root = root; //위에다 정의한 root안에 메소드 안으로 들고온 root를 넣어주겠다.
	}
}
// .말고 /로 경고
