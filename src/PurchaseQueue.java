public class PurchaseQueue<T> implements IPriorityQueue<T> {

	private Purchase head;
	private int queueLength;
	private int totalWaitingTime,goldWaitingTime,silverWaitingTime,bronzeWaitingTime,freeWaitingTime;
	private String date;
	private PurchaseQueue<T> next;
	private int goldMember, bronzeMember,silverMember,freeMember ;

	public PurchaseQueue(String date) {
		head = null;
		queueLength = 0;
		totalWaitingTime = 0;
		this.date = date;
		next = null;
		goldMember = 0;
		bronzeMember = 0;
		silverMember = 0;
		freeMember = 0;
	}

	
	public void insert(T newEntry) {
		Purchase newPurchase = (Purchase ) newEntry;
		if (queueLength == 0) {
			head = newPurchase;
		} else if (newPurchase.getCustomer().getPriority() < head.getCustomer().getPriority()) {
			newPurchase.setNext(head);
			head = newPurchase;
		} else {
			Purchase currentPurchase = head;
			while (currentPurchase.getNext() != null) {
				if (newPurchase.getCustomer().getPriority() < currentPurchase.getNext().getCustomer()
						.getPriority()) {
					break;
				}
				currentPurchase = currentPurchase.getNext();
			}
			if (currentPurchase.getNext() == null) {
				currentPurchase.setNext(newPurchase);
			} else {
				Purchase tempT = currentPurchase.getNext();
				currentPurchase.setNext(newPurchase);
				currentPurchase.getNext().setNext(tempT);
			}
		}
		
		setWaitings();
		setTotalMember(newPurchase.getCustomer().toString());
		queueLength++;
		}
	

	public void setWaitings() {
		Purchase currentPurchase = head;
		totalWaitingTime = 0;
		goldWaitingTime=0;
		silverWaitingTime=0;
		bronzeWaitingTime=0;
		freeWaitingTime=0;
				
		int waiting = 0;
		while (currentPurchase.getNext() != null) {
			waiting += currentPurchase.getOccupation();
			

			
			
			switch (currentPurchase.getCustomer().toString()) {
			case "GOLD":
				goldWaitingTime+=currentPurchase.getOccupation();
				break;
			case "SILVER":
				silverWaitingTime+=currentPurchase.getOccupation();
				break;
			case "BRONZE":
				bronzeWaitingTime+=currentPurchase.getOccupation();
				break;
			case "FREE":
				freeWaitingTime+=currentPurchase.getOccupation();
				break;

			default:
				break;
			
		}
		currentPurchase.setWaiting(waiting);
		currentPurchase = currentPurchase.getNext();
		
		}
		waiting += currentPurchase.getOccupation();
		totalWaitingTime = waiting;
		switch (currentPurchase.getCustomer().toString()) {
		case "GOLD":
			goldWaitingTime+=currentPurchase.getOccupation();
			break;
		case "SILVER":
			silverWaitingTime+=currentPurchase.getOccupation();
			break;
		case "BRONZE":
			bronzeWaitingTime+=currentPurchase.getOccupation();
			break;
		case "FREE":
			freeWaitingTime+=currentPurchase.getOccupation();
			break;

		default:
			break;}
		
		
		 
		
		
	}

	public int getTotalWaitingTime() {
		
		return totalWaitingTime;
	}

	
	
	@SuppressWarnings("unchecked")
	
	public T remove() {
		T result = (T) head;
		head = head.getNext();
		queueLength--;
		return result;
	}


	
	public boolean isEmpty() {
		return queueLength == 0;
	}

	
	
	public int getSize() {
		return queueLength;
	}

	public String getDate() {
		return date;
	}

	public PurchaseQueue<T> getNext() {
		return next;
	}


	public void setNext(PurchaseQueue<T> nextPQ) {
		next = nextPQ;
	}

	
	public void clear() {
		while (!isEmpty()) {
			remove();
		}
	}
	
	public void setTotalMember(String type) {
		switch (type) {
		case "GOLD":
			goldMember++;
			break;
		case "SILVER":
			silverMember++;
			break;
		case "BRONZE":
			bronzeMember++;
			break;
		case "FREE":
			freeMember++;
			break;

		default:
			break;
		
	}
	}

	public int getGoldMember() {
		return goldMember;
	}
	
	public int getSilverMember() {
		return silverMember;
	}
	
	public int getBronzeMember() {
		return bronzeMember;
	}
	
	public int getFreeMember() {
		return freeMember;
	}
	
	public int getGoldWaitingTime() {
		return goldWaitingTime;
	}
	
	public int getSilverWaitingTime() {
		return silverWaitingTime;
	}
	
	public int getBronzeWaitingTime() {
		return bronzeWaitingTime;
	}
	
	public int getFreeWaitingTime() {
		return freeWaitingTime;
	}
	
	public double getAverageGoldWaitingTime() {
		if (getGoldMember()==0) {
				return 0.0;}
		return ((double) getGoldWaitingTime()/getGoldMember());
		}
	
	public double getAverageSilverWaitingTime() {
		if (getSilverMember()==0) {
			return 0.0;}
		return ((double) getSilverWaitingTime()/getSilverMember());}
	
	public double getAverageBronzewaitingTime() {
		if (getBronzeMember()==0) {
			return 0.0;}
		return ((double) getBronzeWaitingTime()/getBronzeMember());}
	
	public double getAverageFreeWaitingTime() {
		if (getFreeMember()==0) {
			return 0.0;}
		return ((double) getFreeWaitingTime()/getFreeMember());}
	
	public double getAverageWaitingTime() {
		if (getSize()==0) {
			return 0.0;}
		return ((double) getTotalWaitingTime()/getSize());
		
	}
	public String toString() {
		String result = date ;
		Purchase currentT = head;
		while (currentT != null) {
			result += " <- " + currentT.toString();
			currentT = currentT.getNext();
		}
		return result;
	}
	
	public Purchase getHead() {
		return head;
	}
	

}	