package logic;

public class Menu {
	private String name;
	private int price;
	private int specialPrice;
	
	public Menu(String name,int price) {
		this.name = name;
		if(price > 200) {
			price = 200;
		} else if(price<0) {
			price = 0;
		}
		this.price = price;
		if(price <= 50) {
			this.specialPrice = price+5;
		} else if(price<=100) {
			this.specialPrice = price+10;
		} else {
			this.specialPrice = price + 20;
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		if(price > 200) {
			price = 200;
		} else if(price<0) {
			price = 0;
		}
		this.price = price;
		this.setSpecialPrice();
	}

	public int getSpecialPrice() {
		return specialPrice;
	}

	private void setSpecialPrice() {
		if(price <= 50) {
			this.specialPrice = price+5;
		} else if(price<=100) {
			this.specialPrice = price+10;
		} else {
			this.specialPrice = price + 20;
		}
	}
	
	public String toString() {
		return name+" Price : "+price+" (special "+specialPrice+")";
	}
	
}
