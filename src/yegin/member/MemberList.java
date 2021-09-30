package yegin.member;

import java.io.IOException;
import java.util.ArrayList;

import geonhwe.Login.LoginServiceImpl;
import geonhwe.db.teamproject;
import geonhwe.member.MemberDTO;
import hayong.FoodDTO;
import hayong.HyDB;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import main.MainFunction_Controller;
import yegin.common.Method;
import yegin.shelf_life.ShelfLife_Method;

public class MemberList {
   Parent root;
   Parent newRoot;
   ObservableList<String> list;
   ObservableList<String> listCount;
   ListView<String> lv;
   ListView<String> count;
   Label id,name;
   ShelfLife_Method sm;
   MemberDTO dto;
   HyDB hb;
   teamproject tp;
   public void setRoot(Parent root) {
      this.root = root;
   }
   public void setRoot2(Parent newRoot) {
      this.newRoot = newRoot;
      hb=new HyDB();
      dto = new MemberDTO();
      tp = new teamproject();
      listView();
      
   }
   public void view() {
      System.out.println("회원 정보 버튼 눌림");

      FXMLLoader loader = new FXMLLoader(getClass().getResource("memberList.fxml"));
      newRoot = null;
      Scene sc = null;
      try {
         this.newRoot = loader.load();
      } catch (IOException e) {
         e.printStackTrace();
      }
      sc = new Scene(newRoot);
      Stage stage = (Stage) root.getScene().getWindow();
      sc.getStylesheets().add(getClass().getResource("/yegin/css/design.css").toString());// 화면 꾸미기 연결 코드

      MemberList ml = loader.getController();
      ml.setRoot2(newRoot);
      stage.setScene(sc);
      stage.show();
   }
   
   public void listView() {
      dto = tp.loginChk(LoginServiceImpl.staticid);
      id = (Label)newRoot.lookup("#id");
      name = (Label)newRoot.lookup("#name");
      id.setText(dto.getId());
      name.setText(dto.getName());
      
      lv=(ListView)newRoot.lookup("#food");
      count=(ListView)newRoot.lookup("#count");
      list=FXCollections.observableArrayList();
      listCount=FXCollections.observableArrayList();
      //list.add("내 냉장고 음식");
      ArrayList<FoodDTO> foodList = hb.DbValue();//db 다 들어옴.
      
      if(foodList !=null) {
         for(int i=0;i <foodList.size();i++) {
            System.out.println(foodList.get(i).getFoodName());
            list.add(foodList.get(i).getFoodName());
            listCount.add(foodList.get(i).getFoodNum()+"개");
         }
      }lv.setItems(list); count.setItems(listCount);
   }
   public void del() {
      MemberDel md = new MemberDel();
      md.setRoot(newRoot);
      md.delView();
   }
   public void back() {
      Method mt = new Method();
      mt.mfc((Stage) newRoot.getScene().getWindow(), "/main/frozenStorage_function.fxml");

      System.out.println("뒤로가기");
   }
   
}
