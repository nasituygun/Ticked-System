

public class Main {

	public static void main(String[] args) {
	
	IPurchaseQueueList list = new PurchaseQueueList();
	
		
	ReadFile rf = new ReadFile("CENG112_HW3_TicketingPurchase.txt");
	rf.readAndWrite(list);//Does all implementations for every line on text.
	String[] dates = list.getDates();//All uniqu dates in one array
	
	

	//Create new statistic objects for every unique dates and print the statistics.
	for(int i=0; i < dates.length;i++) {
		Statistics statistic = new Statistics(list, dates[i]);
		statistic.printDay();
		statistic.printAvenue();
		}
	
	}
	
	
}
