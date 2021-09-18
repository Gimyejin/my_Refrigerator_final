package geonhwe.Login;

import java.io.IOException;

import geonhwe.db.teamproject;
import geonhwe.member.MemberDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import main.MainFunction_Controller;


public class LoginServiceImpl implements LoginService {
	Parent root;
	Parent mainRoot;
	teamproject tpj = new teamproject(); 
	int result = 0;
	public void setRoot(Parent root) {
		this.root = root;
		System.out.println(root);
	}

	@Override
	public int loginCheck() {
		System.out.println("로그인하겠습니다");
		TextField id = (TextField) root.lookup("#fxId");
		TextField pw = (TextField) root.lookup("#fxPwd");
		MemberDTO dto = new MemberDTO();
		dto.setId(id.getText());
		dto.setPwd(pw.getText());
		System.out.println(id.getText());
		System.out.println(pw.getText());
		
		MemberDTO getdto = tpj.loginChk(id.getText()); //TextField에 적은 값으로 DB안에 있는 데이터를 가져온다.
		if(getdto == null) {
			System.out.println("아이디일치X");
		}else {
			System.out.println("아이디 일치");
			if(getdto.getPwd().equals(pw.getText()) ) { //equals 서로 비교하여 일치하는지 확인해주는 역할
				System.out.println("로그인 성공");
				Stage stage = (Stage)root.getScene().getWindow();
				stage.close();//로그인 성공시 해당 창 닫음
				
				result = 1;
				System.out.println("메뉴페이지로 넘어감");

				FXMLLoader loader = new FXMLLoader(getClass().getResource("../../main/menu.fxml"));
				Parent newRoot = null;
				Scene sc = null;
				try {
					newRoot = loader.load();//여기서 에러
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				sc = new Scene(newRoot);

				// scene만 바꿔치기
				Stage stage2 = (Stage) mainRoot.getScene().getWindow();
				
				MainFunction_Controller mc=loader.getController();
				mc.setRoot(newRoot);
				
				stage2.setScene(sc);
				stage2.show();
				
			}else {
				System.out.println("로그인 실패");
				result = 0;
			} 
		} return result; 
		//나중에 합칠 때 이제 변수에 값을 줘서 로그인 성공 실패 여부 정하고 조원분들에게 알려드리고 확인하기
	} 
	public void alertMethod(String mss) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(mss);
		alert.show();
	}

	public void setMainRoot(Parent mainRoot) {
		this.mainRoot=mainRoot;
		
	}
} 