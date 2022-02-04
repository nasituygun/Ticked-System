
public class Purchase implements IPurchase{
	private String date;
	private int id;
	private ICustomer customer;
	private int occupation;
	private int waiting;
	private String seatNo;
	private Purchase next;

public Purchase(String date, int id, ICustomer customer, String seatNo, int occupation) {
	this.date = date;
	this.id = id;
	this.customer = customer;
	this.occupation = occupation;
	this.waiting = 0;
	this.seatNo = seatNo;
}

public void setNext(Purchase nextPurchase) {
	next = nextPurchase;
}

public int getID() {
	return id;
}

public ICustomer getCustomer() {
	return customer;
}

public int getOccupation() {
	return occupation;
}

public int getWaiting() {
	return waiting;
}

public Purchase getNext() {
	return next;
}

public void setWaiting(int waiting) {
	this.waiting = waiting;
}

public String toString() {
	return id + "," + customer.toString() + "," + seatNo + "," + occupation;
}

public String getSeatNo() {
	return seatNo;
}

public String getDate() {
	return date;
}


}


