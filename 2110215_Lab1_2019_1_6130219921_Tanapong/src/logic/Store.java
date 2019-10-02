
package logic;
import java.util.*;  
import java.util.Scanner;
public class Store {
	
private String name;
private int totalSales;
private List<Record> records;
private List<Menu> menus;
private int cost;
private boolean up;

	public Store(String name) {
		this.name = name;
		this.totalSales = 0;
		this.records = new ArrayList<>();
		this.menus = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getTotalSales() {
		return totalSales;
	}

	public void setTotalSales(int totalSales) {
		this.totalSales = totalSales;
	}

	public List<Record> getRecords() {
		return records;
	}

	public void setRecords(List<Record> records) {
		this.records = records;
	}

	public List<Menu> getMenus() {
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public void showAllMenu() {
		for(Object m:menus) {
			System.out.println(m.toString());
		}
	}
	
	public boolean addMenu(Menu menu) {
		if(menus.contains(menu)) {
			return false;
		} else {
			menus.add(menu);
			return true;
		}
	}
	
	public void addRecord(Record record) {
		records.add(record);
	}
	
	
	public void sell(Menu menu, boolean isSpecial) {
		//FILL CODE
		if(isSpecial) {
			cost = menu.getSpecialPrice();
		} else {
			cost = menu.getPrice();
		}

		System.out.println("Thank you for buying " + menu.getName() + " " + cost + " Bath");
		totalSales += cost;
		records.add(new Record(menu.getName(),cost));
	}
	
	public void showRecord() {
		for(Object r:records) {
			System.out.println(r.toString());
		}
	}

	public void sellProcessHandle() {
		//FILL CODE
		System.out.println("---------------------------");
		System.out.println("Welcome to "+this.name);
		System.out.println("---------------------------");
		for(int i =0 ; i<menus.size();i++) {
			System.out.println(i+1+". "+ (menus.get(i)).toString());
		}
		
		System.out.print("Please select menu : ");
		Scanner myObj = new Scanner(System.in);
		int userMenu = myObj.nextInt();
		if(userMenu <= 0) {
			System.out.print("Your selection is invalid. Please try again.");
		}else if(userMenu >menus.size()) {
			System.out.print("There is no menu at your selection, Please try again.");
		}else {
		System.out.print("Upgrade to special ? (Y/N) :");
		char upgrade = myObj.next().charAt(0);
		if(upgrade == 'Y') {
			up = true;
		} else {
			up = false;
		}
		sell(menus.get(userMenu-1),up);
		}
	}

	public void manageProcessHandle() {
		System.out.println("---------------------------");
		System.out.println("Welcome to "+this.name);
		System.out.println("---------------------------");
		System.out.println("1. Add menu");
		System.out.println("2. Show summary");
		System.out.println("Select a program to do : ");
		Scanner myObj = new Scanner(System.in);
		int program = myObj.nextInt();
		if(program == 1) {
			addMenuHandle();
		}else if(program == 2) {
			showSummary();
		}else {
			System.out.println("Your selection is invalid. Please try again.");
		}
	}
	
	private void addMenuHandle() {
		//FILL HERE
		System.out.println("Please enter menu name :");
		Scanner myObj = new Scanner(System.in);
		String name = myObj.nextLine();
		System.out.println("Please enter price :");
		int menuPrice = myObj.nextInt();
		addMenu(new Menu(name,menuPrice));
		System.out.println("New menu " + name + " added!");
	}

	private void showSummary() {
		//FILL CODE
		System.out.println("Total Sales : " + this.totalSales +"\n");
		showRecord();
	}
	
}
