package dao;

import java.util.HashMap;
import java.util.Scanner;

public class Customer {
	static HashMap<String, String> user = new HashMap<>();
	Scanner sc;
	
	static String username;
	Bus bus = new Bus();
	public void Login(){
		sc= new Scanner(System.in);
		System.out.println("\n=====================================================================================================");

		System.out.print("Please enter Username: ");
		username = sc.nextLine();
		System.out.print("Please enter Password: ");
		String password = sc.nextLine();
		if(username.equals("admin")&& password.equals("admin")){
			displayScreen(username);
			menu();	
		}
		
		else if(user.containsKey(username)){
				if(user.get(username).equals(password)){
				System.out.println("Login Succesfull...!");
				displayScreen(username);
				menuCustomer();
				}
			
			else{
				System.out.println("Invalid Credentials...!");
				BusBooking busBooking = new BusBooking();
				busBooking.mainMethod();
			}
		}else{
			System.out.println("User not Found...");
			BusBooking busBooking = new BusBooking();
			busBooking.mainMethod();

		}
		
	}
	public void displayScreen(String username){
		System.out.println("\t\t\t\t******************************");
		System.out.println("\t\t\t\t*                            *");
		System.out.println("\t\t\t\t* Welcome to Bus Booking App *");
		System.out.println("\t\t\t\t*                            *");
		System.out.println("\t\t\t\t******************************");
		System.out.println("\t\t\t\t\tHello "+ username);
		System.out.println("=====================================================================================================");
		System.out.println();
	}
	public void menu(){
		int n;
		do{
		System.out.println("[1] Transactions");
		System.out.println("[2] Add Bus");
		System.out.println("[3] Display Customers Name");
		System.out.println("[4] Display Buses");
		System.out.print("Enter your choice: ");
		n = sc.nextInt();
		
			switch(n){
			case 1 :
			bus.displayBookingTransactions();
				break;
			case 2 : 
					bus.addBusDetails();
					bus.displayBusDetails();
					break;
			case 3 : 
				System.out.println("------------------x Users x----------------- ");
				for(String keys : user.keySet()){
				    System.out.println( keys );
				}
				break;
			case 4 : bus.displayBusDetails();
				break;
			
			default: System.out.println("Enter valid no...! ");

			}
		}while(n!=5);
	}
	
	public void menuCustomer(){
		int ch;
		bus.setBusDetails();
		do{
		System.out.println("[1] Book a Ticket");
		System.out.println("[2] Cancel Ticket");
		System.out.println("[3] Exit");
		System.out.print("Enter your choice: ");
		ch = sc.nextInt();
		switch(ch){
		case 1: 
			bus.displayBusDetails();
			System.out.print("Enter no which bus you want to book: ");
			int no = sc.nextInt();
			System.out.print("Enter no of tickets: ");
			int tickets = sc.nextInt();
			bus.chooseBus(no, tickets, username);
			break;
		case 2: 
			bus.displayBusDetails();
			System.out.print("Enter no which bus you want to cancel: ");
			int busno = sc.nextInt();
			System.out.print("Enter how many tickets you want to cancel: ");
			int cancelTickets = sc.nextInt();
			bus.cancelBooking(busno, cancelTickets, username); 
			break;
		default: System.out.println("Please enter appropriate number...!");
		}
		
		}while(ch!=3);
	}
	
	public void Register(){
		

		sc = new Scanner(System.in);
		System.out.print("Please enter Username: ");
		String username = sc.nextLine();
		System.out.print("Please enter Password: ");
		String password = sc.nextLine();
		user.put(username, password);
		System.out.println("Registeration Succesfull...!");
		BusBooking busBooking = new BusBooking();
		busBooking.mainMethod();
		
	}
	
}
