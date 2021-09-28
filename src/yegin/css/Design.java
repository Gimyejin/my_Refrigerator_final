package yegin.css;

import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
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
	/*@FXML
    Button button;
    public void initialize (){
        ImageView imageView = new ImageView(getClass().getResource("/yegin/resources/arrow.png").toExternalForm());
        button.setGraphic(imageView);
    }*/
}
