<<<<<<< HEAD
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

=======
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

>>>>>>> 31984e95ca50f26e3426c2a3987c1e85d903d458
}