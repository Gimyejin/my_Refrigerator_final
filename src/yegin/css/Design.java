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
	ImageView id,name;
	Parent root;
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
		id = (ImageView) newRoot.lookup("#fxid");
		name = (ImageView) newRoot.lookup("#fxname");
		item.setImage(new Image("/yegin/resources/내용물.png"));
		count.setImage(new Image("/yegin/resources/수량.png"));
		id.setImage(new Image("/yegin/resources/아이디.png"));
		name.setImage(new Image("/yegin/resources/이름.png"));
	}
	
	
}
