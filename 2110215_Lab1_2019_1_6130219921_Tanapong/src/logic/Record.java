package logic;

public class Record {
	String foodName;
	int soldPrice;
	
	public Record(String menu,int price) {
		this.foodName = menu;
		this.soldPrice = price;
	}
	
	public String toString() {
		return "Menu : "+foodName+" sold in "+soldPrice+" THB";
	}

	public String getFoodName() {
		return foodName;
	}

	public int getSoldPrice() {
		return soldPrice;
	}
	
	
}
