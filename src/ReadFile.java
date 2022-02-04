import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class ReadFile{
	
	private File file;
	
	
	
	public ReadFile(String fileName) {
		
		file = new File(fileName);
		
			}

	public void readAndWrite(IPurchaseQueueList aqueueList) {
		IPurchaseQueueList queueList = aqueueList;
		try(Scanner scanner = new Scanner(file) ){
			
			while(scanner.hasNextLine()) {
				
				String line = scanner.nextLine();
				
				Purchase newPurchase = createPurchase(line);
				addQueue(newPurchase, queueList);
			}
		}
		catch(FileNotFoundException e) {
			e.getMessage();
		}
		
	}
	
	//It splits all line to tokens respect to ',' and create new Purchase object.
	private Purchase createPurchase(String line) {
		
		String date, seatNo;
		ICustomer newCustomer;
		int purchaseId, occupationTime;
		
		String[] parsedLine = line.split(",");
		date = parsedLine[0];
		purchaseId = Integer.parseInt(parsedLine[1]);
		newCustomer = createCustomer(parsedLine[2]);//Create new Customer object
		seatNo = parsedLine[3];
		occupationTime = Integer.parseInt(parsedLine[4]);
		Purchase newPurchase = new Purchase(date, purchaseId, newCustomer, seatNo, occupationTime);
		
		return newPurchase;
	}
	
	//Create a new Customer object respect to type of customer.
	private ICustomer createCustomer(String customerType){
		ICustomer newCustomer;
		
		if(customerType.equals("GOLD")) {
			newCustomer = new Gold();
		}else if(customerType.equals("SILVER")) {
			newCustomer = new Silver();
		}else if(customerType.equals("BRONZE")) {
			newCustomer = new Bronze();
		}else if(customerType.equals("FREE")) {
			newCustomer = new Free();
		}else {
			newCustomer = null;
		}
		
		return newCustomer;
		
	}
	
	private void addQueue(Purchase newPurchase, IPurchaseQueueList list) {
		boolean contain = false;
		String date = newPurchase.getDate();
		String[] dates = list.getDates();
		//Checks that the date is exist in dates[] or not
		for(int i=0; i < dates.length;i++) {
			
			if(dates[i] != null) {
				if(dates[i].equals(date)) {
					contain = true;
				}
			}
			
		}
		//If a date does not contain dates array, it creates new queue for a specific date and insert it to list.
		if(!(contain)) {
			PurchaseQueue<Purchase> queue = new PurchaseQueue<Purchase>(date);
			list.insertTo(queue);
			dates = list.extendArray(dates);
			int index = dates.length-1;
			dates[index] = date;
			
			//Updates the dates array which stored in PurchaseQueueList class.
			list.setDates(dates);
		}
		
		
		//Add the new Purchase into to appropriate queue.
		list.updatePurchaseQueue(date, newPurchase);	
	}
	
	
	
	
	
	
	

}
