package geonhwe.Login;


import geonhwe.main.Controller;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class LoginProc {
	Parent root;
   public void Login() {
      System.out.println("로그인창 열기");
      try {
         Stage primaryStage = new Stage();
         FXMLLoader loader = new FXMLLoader(getClass().getResource("Login.fxml"));
         Parent root = loader.load();
         Scene scene = new Scene(root);
         
         LoginController ctl = loader.getController();
         ctl.setRoot(root);
         
         primaryStage.setScene(scene);
         primaryStage.show();

      }catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      }
   }
   public void setRoot(Parent root) {
	   this.root = root;
   }

}