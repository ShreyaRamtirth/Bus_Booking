package dao;


public class Buses {
	
	public int bno = 0;
	public String busName = "";
	public String source = "";
	public String destination = "";
	public int ticketPrice = 0;
	public int availableSeats = 0;
	public void setBusData(int bno, String busName, String source, String destination,int ticketPrice, int availableSeats){
		this.bno = bno;
		this.busName = busName;
		this.source = source;
		this.destination = destination;
		this.ticketPrice = ticketPrice;
		this.availableSeats = availableSeats;
	}
	public void getBusData(){
		System.out.println("\t"+bno+ "\t"+ busName + "\t"+ source +"\t" 
	+destination + "\t"+ ticketPrice +"\t"+ availableSeats + "\t|" );
	}
	public void bookTickets(int tickets){
		availableSeats = availableSeats - tickets;
		System.out.println("Ticket Booked Succesfully....!");
	}
	
}
