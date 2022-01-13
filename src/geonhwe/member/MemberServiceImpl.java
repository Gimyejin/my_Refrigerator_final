package geonhwe.member;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import geonhwe.member.*;
import geonhwe.common.*;
import geonhwe.db.teamproject;

public class MemberServiceImpl implements MemberService{
   Parent root;
   Parent memberRoot;
   teamproject tpj = new teamproject();

   public void memberCancle() {
      CommonService cs = new CommonServiceImpl();
      cs.setRoot(root);
      cs.windowClose();
   }

   public void alertMethod(String msg) {
      Alert alert = new Alert(AlertType.INFORMATION);
      alert.setContentText(msg);
      alert.show();
   }

   public void membershipProc() {
      TextField id = (TextField) root.lookup("#fxId");
      TextField pwd = (TextField) root.lookup("#fxPw");
      TextField name = (TextField) root.lookup("#fxName");
      // 노랑색부분은 바꿀 수 있지만 파란색은 신빌더랑 맞춰줘야한다.
      MemberDTO dto = new MemberDTO();

      dto.setId(id.getText());
      dto.setPwd(pwd.getText());
      dto.setName(name.getText());

      // = 하나는 저장, == 앞과 뒤가 같은지 확인하는 용도 / 오른쪽의 값을 좌측에 넣겠다.

      int result = tpj.insert(dto);
      MemberDTO ggdto = tpj.loginChk(id.getId());
      
      if(result == 0) { 
    	  System.out.println(tpj.loginChk(id.getText())+"확인용");
    	  if(tpj.loginChk(id.getText())!=null) {
    		  alertMethod("이미 가입된 아이디입니다.");
    	  }else {
    		  alertMethod("회원가입이 실패하였습니다.");
    	  }
      }else if(result == 1) {
         System.out.println("회원가입 가능!");
        // if(ggdto.getId().equals(id.getId())) {
            alertMethod("회원가입이 되었습니다.");
            Stage stage = (Stage)root.getScene().getWindow();
            stage.close();
            
            result = 1;
            
            MemberController mmc = new MemberController();
            mmc.setRoot(memberRoot);
            
         

      }
      
      System.out.println("아이디"+dto.getId()); // set = 넣다 get = 꺼내다
      System.out.println(dto.getName());
      System.out.println(dto.getPwd());
   }

   public void setRoot(Parent root) {
      this.root = root;
   }
}

// 그 fxid를 설정을 하고나서 이제 찾을 때 #memberid로
// 한 .. 60%넘게 이해한거같습니다

//lookup 찾다/ "#~~~"를 텍스트필드를갑 줄건데 id라는 변수에 담는다
// ((TextField)root.lookup("#fxId")) 이 값만 가지고 내용을 찾을거다