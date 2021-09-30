package hayong;

public class FoodDTO {
	private String foodName;
	private String foodNum;
	private String foodTime;
	private String oldName;
	private String shelfLife;
	
	public String getOldName() {
		return oldName;
	}
	public void setOldName(String oldName) {
		this.oldName = oldName;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	public String getFoodNum() {
		return foodNum;
	}
	public void setFoodNum(String foodNum) {
		this.foodNum = foodNum;
	}
	public String getFoodTime() {
		return foodTime;
	}
	public void setFoodTime(String foodTime) {
		this.foodTime = foodTime;
	}
	
	public String getShelfLife() {
		return shelfLife;
	}
	public void setShelfLife(String shelfLife) {
		this.shelfLife = shelfLife;
	}
}
