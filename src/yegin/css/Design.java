package yegin.css;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Design {
	ImageView log;
	ImageView item;
	ImageView count;
	ImageView id,name,log2 ,log3,date;
	ImageView test,list;
	ImageView changlog;
	ImageView fxmemo,temp,add;
	Parent root;//메인 화면 log용
	Parent newRoot;

	public void setRoot(Parent root) {
		this.root = root;
		log = (ImageView) root.lookup("#logIm");
	}

	public void log() {
		log.setImage(new Image("/yegin/resources/test3.png"));
	}


	public void item(Parent newRoot) {
		this.newRoot=newRoot;
		item = (ImageView) newRoot.lookup("#item");
		count = (ImageView) newRoot.lookup("#itemcount");
		//id = (ImageView) newRoot.lookup("#fxid");
		//name = (ImageView) newRoot.lookup("#fxname");
		log2 = (ImageView) newRoot.lookup("#log2");
		item.setImage(new Image("/yegin/resources/내용물.png"));
		count.setImage(new Image("/yegin/resources/수량.png"));
		//id.setImage(new Image("/yegin/resources/아이디.png"));
		//name.setImage(new Image("/yegin/resources/이름.png"));
		log2.setImage(new Image("/yegin/resources/회원정보.png"));
	}
	
	public void time(Parent newRoot) {
		this.newRoot=newRoot;
		log3 = (ImageView) newRoot.lookup("#log3");
		date = (ImageView) newRoot.lookup("#date");
		item = (ImageView) newRoot.lookup("#name");
		item.setImage(new Image("/yegin/resources/내용물.png"));
		log3.setImage(new Image("/yegin/resources/유통기한.png"));
		date.setImage(new Image("/yegin/resources/날짜.png"));
	}
	public void menu(Parent newRoot) {
		this.newRoot=newRoot;
		test= (ImageView) newRoot.lookup("#test");
		list= (ImageView) newRoot.lookup("#list");
		test.setImage(new Image("/yegin/resources/food.png"));
		list.setImage(new Image("/yegin/resources/유통기한리스트.png"));
		
	}
	public void change(Parent newRoot) {
		this.newRoot=newRoot;
		changlog= (ImageView) newRoot.lookup("#changlog");
		changlog.setImage(new Image("/yegin/resources/수정.png"));
	}
	
	public void menuHome(Parent newRoot) {
		this.newRoot=newRoot;
		fxmemo= (ImageView) newRoot.lookup("#fxmemo");
		temp= (ImageView) newRoot.lookup("#temp");
		add= (ImageView) newRoot.lookup("#add");
		fxmemo.setImage(new Image("/yegin/resources/memo.png"));
		temp.setImage(new Image("/yegin/resources/tmp.png"));
		add.setImage(new Image("/yegin/resources/입고.png"));
	}
}
