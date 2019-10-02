package application;

import java.util.Scanner;
import logic.*;

//	//Uncomment this to enable Blacksmith
import blacksmith.Blacksmith;

public class Application {

	public static Scanner kb = new Scanner(System.in);
	private Hero heroA = new Hero("DefaultHero A",1,1);
	private Hero heroB = new Hero("DefaultHero B",1,1);	
	
	public Application() {}

	public void start() {
		System.out.println("Welcome to CPArena");
		while(true) {			
			mainmenu();
			System.out.println("### Returning to main menu ###");
		}
	};
	
	public void mainmenu() {
		try {
			System.out.println("==============================================");
			System.out.println("[1] Change Hero A");
			System.out.println("[2] Change Hero B");
			System.out.println("[3] Start The Battle");
			System.out.print("Please select your option:\t");
			int option = kb.nextInt();
			kb.nextLine();
			System.out.println("==============================================");
			switch (option) {
			case 1:
				heroA = setHero();
				break;
			case 2:
				heroB = setHero();
				break;
			case 3:
				new Battle(heroA, heroB).start();
				break;
			default:
				System.out.println("### Invalid input ###");
			}
		} catch(Exception e) {
			System.out.println("### Invalid input ###");
			kb = new Scanner(System.in);
		}
	}
	
	public Hero setHero() {
		Hero hero = new Hero("DefaultHero",1,1);
		try {
			System.out.print("Please enter new hero name:\t");
			String name = kb.nextLine();
			System.out.println("[1] Normal");
			System.out.println("[2] Tank");
			System.out.println("[3] Robot");
//			//Uncomment this to enable Blacksmith
			System.out.println("[4] Blacksmith");
			System.out.print("Please enter new hero type:\t");
			int type = kb.nextInt();
			switch(type) {
				case 1:
					System.out.print("Please enter new hero power and hp:\t");
					hero = new Hero(name, kb.nextInt(), kb.nextInt());
					System.out.println("== New Hero created: " + hero.getName() + " " + hero.printStat() + " ==");
					break;
				case 2:
					System.out.print("Please enter new hero power, hp, and armor:\t");
					hero = new Tank(name, kb.nextInt(), kb.nextInt(), kb.nextInt());
					System.out.println("== New Tank created: " + hero.getName() + " " + hero.printStat() + " ==");
					break;
				case 3:
					hero = new Robot(name);
					System.out.println("== New Robot created: " + hero.getName() + " " + hero.printStat() + " ==");
					break;
				// //Uncomment this to enable Blacksmith
				 case 4:
				 	System.out.print("Please enter new hero hp and skill level:\t");
				 	hero = new Blacksmith(name, kb.nextInt(), kb.nextInt());
				 	System.out.println("== New Blacksmith created: " + hero.getName() + " " + hero.printStat() + " ==");
				 	break;
				default:
					System.out.println("### Invalid input ###");
			}
		}  catch(Exception e) {
			e.printStackTrace();
			System.out.println("### Invalid input ###");
			System.out.println("### Create a DefaultHero ###");
			kb = new Scanner(System.in);
		}
		return hero;
	}
}
