
public class Statistics {
	
	private IPurchaseQueueList list;
	private PurchaseQueue<Purchase> queue;
	private String[][] avenue;
	private String date;
	public Statistics(IPurchaseQueueList alist, String aDate) {
		list = alist;
		avenue = new String[5][6];
		String[] A = {"A", "U", "U", "U", "U", "U"};
		String[] B = {"B", "U", "U", "U", "U", "U"};
		String[] C = {"C", "U", "U", "U", "U", "U"};
		String[] D = {"D", "U", "U", "U", "U", "U"};
		String[] E = {"E", "U", "U", "U", "U", "U"};
		avenue[0] = A;
		avenue[1] = B;
		avenue[2] = C;
		avenue[3] = D;
		avenue[4] = E;
		this.date = aDate;
		queue = list.getPurchaseQueue(date);
	}
	
	
	public void printDay() {
		
		System.out.println("------------------------------------------------------------------------------------------");
		
		System.out.println("Day: " + date);
		System.out.println(queue.toString());//Print purchase queue for specific day
		
		int totalTickets = list.getPurchaseQueue(date).getSize();
		System.out.println("Total number of tickets sold: " + totalTickets); //prints amount of total tickets
		
		int totalWaitingTime = queue.getTotalWaitingTime();
		System.out.println("Total waiting time: " + totalWaitingTime);//prints total waiting time
		
		
		double avarageWaitingTime = queue.getAverageWaitingTime();
		System.out.println("Avarage waiting time: " + String.format("%.2f", avarageWaitingTime));//prints avarage time
		
		int goldTickets = queue.getGoldMember();
		System.out.println("Total number of tickets sold for GOLD:" + goldTickets);//prints number of gold
		
		int silverTickets = queue.getSilverMember();
		System.out.println("Total number of tickets sold for SILVER:" + silverTickets);//prints number of silver
		
		int bronzeTickets = queue.getBronzeMember();
		System.out.println("Total number of tickets sold for BRONZE:" + bronzeTickets);//prints number of bronzes
		
		int freeTickets = queue.getFreeMember();
		System.out.println("Total number of tickets sold for FREE:" + freeTickets);//prints number of frees
		
		
		//Prints for total and avarage waiting times for members
		int totalTimeGold = queue.getGoldWaitingTime();
		double avarageTimeGold = queue.getAverageGoldWaitingTime();
		System.out.println("Total waiting time for GOLD: " + totalTimeGold);
		System.out.println("Avarage waiting time for GOLD:" + String.format("%.2f", avarageTimeGold));
		
		int totalTimeSilver = queue.getSilverWaitingTime();
		double avarageTimeSilver = queue.getAverageSilverWaitingTime();
		System.out.println("Total waiting time for SILVER: " + totalTimeSilver);
		System.out.println("Avarage waiting time for SILVER:" + String.format("%.2f", avarageTimeSilver));
		
		int totalTimeBronze = queue.getBronzeWaitingTime();
		double avarageTimeBronze = queue.getAverageBronzewaitingTime();
		System.out.println("Total waiting time for BRONZE: " + totalTimeBronze);
		System.out.println("Avarage waiting time for BRONZE:" + String.format("%.2f", avarageTimeBronze));
		
		int totalTimeFree = queue.getFreeWaitingTime();
		double avarageTimeFree = queue.getAverageFreeWaitingTime();
		System.out.println("Total waiting time for FREE: " + totalTimeFree);
		System.out.println("Avarage waiting time for FREE:" + String.format("%.2f", avarageTimeFree));	
	}
	
	//Iterates heads in queue, get and stores seat no's in seats[] array and returns it.
	private String[] getSeats() {
		int len = queue.getSize();
		Purchase purchase = queue.getHead();
		String[] seats = new String[len];
		for(int i=0; i<len;i++) {
			seats[i] = purchase.getSeatNo();
			purchase = purchase.getNext();
		}
		return seats;
	}
	
	
	//First it takes one seat number element in seats array and converts it to char array.
	//For example "A1" --> {'A', '1'}
	private void fillSeats() {
		String[] seats = getSeats();
		for(int i=0; i<seats.length;i++) {
			char[] sno = seats[i].toCharArray();
			String letter = Character.toString(sno[0]);//It converts to string of first characacter of seat no.
			int number = Character.getNumericValue(sno[1]);//It converts to int of second character of seat no.
			
			//It finds position of seat no in avenue and place it with "S".
			for(int j=0;j<avenue.length;j++) {
				if(avenue[j][0].equals(letter)) {
					avenue[j][number] = "S";
				}
			}
		}
	
	}
	//Print the 2 dimension avenue array.
	public void printAvenue() {
		fillSeats();
		for(int i =0; i < avenue.length;i++) {
			for(int j=0;j<avenue[i].length;j++) {
				System.out.print(avenue[i][j] + " ");
			}
			System.out.println("");
		}

	}

}
