package yegin.css;

import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Design {
	ImageView log;
	Parent root;

	public void setRoot(Parent root) {
		this.root = root;
		log = (ImageView) root.lookup("#logIm");
	}

	public void log() {
		log.setImage(new Image("/yegin/resources/test3.png"));
	}
}
