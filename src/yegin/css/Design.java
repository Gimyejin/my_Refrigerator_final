package yegin.css;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Design {
	ImageView log;
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
		log = (ImageView) newRoot.lookup("#item");
		log.setImage(new Image("/yegin/resources/내용물.png"));
	}
}
