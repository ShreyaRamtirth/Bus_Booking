package dao;

import java.time.LocalDate;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;


public class Bus {
	
	Scanner s;
	Buses paradise = new Buses();
	Buses volvo = new Buses();
	Buses imperia  = new Buses();
	Buses safedrive = new Buses();
	Buses dreamland = new Buses(); 
	Buses quantum = new Buses();
	static LinkedList<Buses> busObject = new LinkedList<>();
	static LinkedList<BookingDatabase> busDatabase = new LinkedList<>();
	String username;
	
	
	public Bus() {
		// TODO Auto-generated constructor stub
		
	}
	Bus(String username){
		this.username = username;
		
	}
	
	public void addBusDetails(){
		Buses b1 = new Buses();
		s = new Scanner(System.in);
		System.out.print("Enter bus no: ");
		int bno = s.nextInt();
		System.out.print("Enter bus name: ");
		String busName = s.next();
		System.out.print("Enter bus source: ");
		String source = s.next();
		System.out.print("Enter bus destination: ");
		String destination = s.next();
		System.out.print("Enter ticket price: ");
		int ticketPrice = s.nextInt();
		System.out.print("Enter available seats: ");
		int availableSeats = s.nextInt();
		b1.setBusData(bno, busName, source, destination, ticketPrice, availableSeats);
		busObject.add(b1);
		System.out.println("Details added Successfully....!!!");
	}
	public void setBusDetails(){
		paradise.setBusData(102425, "Paradise", "Pune", "Goa", 1400, 50);
		 volvo.setBusData(158725, "Volvo Exp", "Pune", "Mumbai", 400, 150);
		 imperia.setBusData(895425, "Imperia sea", "Pune", "Punjab", 3400, 50);
		 dreamland.setBusData(987562, "Dreamland", "Pune", "Noida", 4400, 50);
		 quantum.setBusData(874685, "Quantum bayer", "Pune", "Mathura", 1400, 30);
		 busObject.add(paradise);
		 busObject.add(volvo);
		 busObject.add(imperia);
		 busObject.add(dreamland);
		 busObject.add(quantum);

	}
	public void displayBusDetails(){
		System.out.println("x-----------------------------------------------------------------------x");
		System.out.println("|\t\t\t\tAvailable buses\t\t\t\t|");
		System.out.println("x-----------------------------------------------------------------------x");
		System.out.println("|\tNo\tBus no\t Bus Name \tSource\tDestiny\tPrice\tSeats\t|");
		System.out.println("|\t\t\t\t\t\t\t\t\t|");
		for(int i=0;i<busObject.size();i++){
			System.out.print("|\t"+ (i+1));
			busObject.get(i).getBusData();
		}
		System.out.println("x-----------------------------------------------------------------------x");

	}
	
	public void chooseBus(int no,int tickets, String username){
		if(busObject.get(no-1).availableSeats > tickets && tickets > 0){
			busObject.get(no-1).bookTickets(tickets);
			billGenerate(no-1,tickets,username);
			BookingDatabase bd = new BookingDatabase();
			String date = LocalDate.now().toString();
			bd.setBookingInfo(busObject.get(no-1).bno, busObject.get(no-1).ticketPrice * tickets, username, date, tickets);
			busDatabase.add(bd);
		}else{
			System.out.println();
			System.out.println("Seats are unavailable...!");
			System.out.println("=========================================");
		}
	}
	
	public void cancelBooking(int busNo, int cancelTicket, String username){
		boolean flag = false;
		for(int i=0;i<busDatabase.size();i++){
			
			if(busDatabase.get(i).busNo == busObject.get(busNo-1).bno && busDatabase.get(i).username.equals(username)){
				if(busDatabase.get(i).seats >= cancelTicket ){
					busObject.get(busNo-1).availableSeats +=  cancelTicket;
					busDatabase.get(i).seats -= cancelTicket;
					System.out.println("Ticket Cancellation Succesful...!");
					flag = true;
					break;
					
				}else{
					System.out.println("You haven't book that much tickets...!");
				}
			}else{
				flag = false;

			}
			
		}
		

		if(flag == false)
			System.out.println("Please book a ticket first...!");
	}
	
	public void billGenerate(int no, int tickets, String username){
		System.out.println();
		String date = LocalDate.now().toString();
		System.out.println("*********************************************************************");
		System.out.println("\tBill No: "+ 1021 + "\t\tTours & Travel Bill\t" + date );
		System.out.println("*********************************************************************");
		System.out.println("\tName: "+ username + "\t\t\t\t"+ "Bus No: " + busObject.get(no).bno);
		System.out.println("\tBus Name: "+
		busObject.get(no).busName + "\n");
		System.out.println("\tTotal No of seats: \t\t"+ tickets + " x "+ busObject.get(no).ticketPrice);
		
		System.out.println("\tTotal amount: \t\t\tRs. "+ busObject.get(no).ticketPrice * tickets);
		System.out.println("*********************************************************************");

	}
	
	public void displayBookingTransactions(){
		System.out.println("*********************************************************************");
		System.out.println("\tBus No \tUsername \tSeats  \tTotal Amount" );
		System.out.println("*********************************************************************");

		for (int i = 0; i < busDatabase.size(); i++) {
			System.out.println("\t"+busDatabase.get(i).busNo + "\t" + busDatabase.get(i).username 
					+ "\t\t" + busDatabase.get(i).seats +"\t" + busDatabase.get(i).billAmt);
		}
	}
}
