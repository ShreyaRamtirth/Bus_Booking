package dao;

import java.util.Scanner;

public class BusBooking {

	public void mainMethod(){
		int n;
		do{
		System.out.println("\t\t\t\tx-x-x-x-x-x-x-x-x-x-x-x-x-x-x");
		System.out.println("\t\t\t\tx                           x");
		System.out.println("\t\t\t\tx\t1: Log In           x"
				+ "\n\t\t\t\tx\t2: Register         x"+ "\n\t\t\t\tx\t3: Exit             x");
		System.out.println("\t\t\t\tx                           x");

		System.out.println("\t\t\t\tx-x-x-x-x-x-x-x-x-x-x-x-x-x-x\n");

		System.out.print("\t\t\t\tEnter Your Choice: ");

		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();

		Customer customer = new Customer();
		switch(n){
		case 1: customer.Login(); break;
		case 2: customer.Register(); break;
		default: System.out.println("Please enter appropriate number...!");
		}
		}while(n!=3);

	}
	public static void main(String[] args) {

		System.out.println("\n\t\t\t-:-:-:-: Welcome to Tours & Travel :-:-:-:-\n");
		BusBooking busBooking = new BusBooking();
		busBooking.mainMethod();

	}

}
