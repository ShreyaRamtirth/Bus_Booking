package dao;

public class BookingDatabase {
	int busNo;
	int billAmt;
	String username;
	String date;
	int seats;
	public void getBookingInfo(){
		System.out.println(busNo + "\t" + username + "\t" + seats + "\t" + billAmt + "\t" + date);
	}
	
	public void setBookingInfo(int busNo, int billAmt, String username, String date, int seats){
		this.busNo = busNo;
		this.billAmt = billAmt;
		this.username = username;
		this.date = date;
		this.seats = seats;

	}
}
