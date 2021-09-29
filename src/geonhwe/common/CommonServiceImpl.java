package geonhwe.common;

import javafx.scene.Parent;
import javafx.stage.Stage;

public class CommonServiceImpl implements CommonService{
	Parent root;
	@Override
	public void setRoot(Parent root) {
				this.root = root;
	}

	@Override
	public void windowClose() 
	{System.out.println(root);
		Stage stage = (Stage)root.getScene().getWindow();
		stage.close();
	}

}