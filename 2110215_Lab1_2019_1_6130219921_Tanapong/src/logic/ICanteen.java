package logic;
import java.util.*;
public class ICanteen {
	public static List<Store>stores = new ArrayList<>();
	public static Scanner kb ;
	
	public static void main(String[] args) {
		while (true) {
			//FILL CODE
		  try {
			printMain();
			System.out.print("Select a program to do : ");
			Scanner kb = new Scanner(System.in);
			int program = kb.nextInt();
			switch (program) {
			case 1:
				System.out.println("---------------------------");
				addStoreHandle();
				System.out.println("---------------------------");
				break;
			case 2:
				System.out.println("---------------------------");
				manageStoreHandle();
				System.out.println("---------------------------");
				break;
			case 3:
				System.out.println("---------------------------");
				buyFoodHandle();
				System.out.println("---------------------------");
				break;
			case 4:
				System.exit(0);
			default:
				System.out.println("Invalid input!!");
			}
		  } catch(Exception e) {
			  System.out.println(e);
			  System.out.println("Error occured, please try again");
		  }
		} 

	}

	private static boolean addStoreHandle() {		
		try {
			System.out.print("Store Name : ");
		//FILL CODE
			Scanner kb = new Scanner(System.in);
			String name = kb.nextLine();
			stores.add(new Store(name));
			System.out.println("The store named " + name + " was added!");
			return true;
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error occured, please try again");
			return false;
		}
	}

	private static boolean manageStoreHandle() {
		//FILL CODE
		try {
			showStores();
			System.out.print("Please select store :");
			Scanner kb = new Scanner(System.in);
			int index = kb.nextInt();
			if(index > stores.size()) {
				System.out.println("There is no store at your selection. Please add store first.");
				return false;
			}else if(index<=0) {
				System.out.println("Your selection is invalid. Please try again.");
				return false;
			}else {
			stores.get(index-1).manageProcessHandle();
			return true;
			}
		} catch (Exception e) {
			System.out.println(e);
			System.out.println("Error occured, please try again");
			return false;
		}
	}

	private static boolean buyFoodHandle() {
		//FILL CODE
		try {
			showStores();
			System.out.print("Please select store :");
			Scanner kb = new Scanner(System.in);
			int index = kb.nextInt();
			stores.get(index-1).sellProcessHandle();
			return true;
		} catch(Exception e) {
			System.out.println(e);
			System.out.println("Error occured, please try again");
			return false;
		}
	}

	public static void printMain() {
		System.out.println("=========== Main Menu ==========");
		System.out.println("What to do?");
		System.out.println("1. Add Store");
		System.out.println("2. Manage Store");
		System.out.println("3. Buy food");
		System.out.println("4. Exit program");
	}

	public static boolean showStores() {
		//FILL CODE
		try {
			System.out.println("Here are all stores");
			for(int i =0 ; i<stores.size();i++) {
				System.out.println((i+1)+". "+ (stores.get(i)).getName());
			}
			return true;
		}catch (Exception e){
			System.out.println(e);
			System.out.println("Error occured, please try again");
			return false;
		}
	}
}
