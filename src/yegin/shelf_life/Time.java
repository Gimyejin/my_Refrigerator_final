
package yegin.shelf_life;

import javafx.beans.property.SimpleStringProperty;

public class Time {
	private SimpleStringProperty itemName;
	private SimpleStringProperty lifeTime;

	public Time(String itemName, String lifeTime) {
		this.itemName = new SimpleStringProperty(itemName);
		this.lifeTime = new SimpleStringProperty(lifeTime);
	}

	public SimpleStringProperty getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = new SimpleStringProperty(itemName);
	}

	public SimpleStringProperty getLifeTime() {
		return lifeTime;
	}

	public void setLifeTime(String lifeTime) {
		this.lifeTime = new SimpleStringProperty(lifeTime);
	}

}