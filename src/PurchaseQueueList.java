public class PurchaseQueueList implements IPurchaseQueueList {

	private PurchaseQueue<Purchase> head;
	private int listLength;
	private String[] dates;
	public PurchaseQueueList() {
		head = null;
		listLength = 0;
		dates = new String[0];
	}

	@Override
	public PurchaseQueue<Purchase> getPurchaseQueue(String date) {
		   PurchaseQueue<Purchase> result = null;
		if (head != null) {
			PurchaseQueue<Purchase> currentPQ = head;
			while (!currentPQ.getDate().equals(date)) {
				currentPQ = currentPQ.getNext();
			}
			if (currentPQ.getDate().equals(date)) {
				result = currentPQ;
			}
		}
		return result;
	}

	@Override
	public boolean updatePurchaseQueue(String date, Purchase P) {
		boolean result = false;
		PurchaseQueue<Purchase> targetPQ = getPurchaseQueue(date);
		if (targetPQ != null) {
			targetPQ.insert(P);
			result = true;
		}
		return result;
	}

	@Override
	public void insertTo(PurchaseQueue<Purchase> PQ) {
		if (head == null) {
			head = PQ;
		} else {
			PurchaseQueue<Purchase> currentPQ = head;
			while (currentPQ.getNext() != null) {
				currentPQ = currentPQ.getNext();
			}
			currentPQ.setNext(PQ);
		}
		listLength++;
	}

	public void removePurchaseQueue() {
		if (!isEmpty()) {
			PurchaseQueue<Purchase> currentPQ = head;
			while (currentPQ.getNext() != null) {
				currentPQ.setNext(currentPQ.getNext());
			}
			currentPQ.setNext(null);
			listLength--;
		}
	}

	@Override
	public PurchaseQueue<Purchase> removePurchaseQueue(String date) {
		   PurchaseQueue<Purchase> targetPQ = null;
		if (getPurchaseQueue(date) != null) {
			PurchaseQueue<Purchase> currentPQ = head;
			while (!currentPQ.getNext().getDate().equals(date)) {
				currentPQ.setNext(currentPQ.getNext());
			}
			targetPQ = currentPQ.getNext();
			currentPQ.setNext(targetPQ.getNext());
			listLength--;
		}
		return targetPQ;
	}

	

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return listLength == 0;
	}

	@Override
	public boolean clear() {
		// TODO Auto-generated method stub
		boolean result = false;
		if (!isEmpty()) {
			while (!isEmpty()) {
				removePurchaseQueue();
			}
			result = true;
		}
		return result;
	}

	@Override
	public String toString() {
		String result = "";
		PurchaseQueue<Purchase> currentPQ = head;
		while (currentPQ != null) {
			result += currentPQ.toString() + "\n";
			currentPQ = currentPQ.getNext();
		}
		return result;
	}
	
	public String[] getDates()
	{
		return dates;
	}
	public void setDates(String[] dates) {
		this.dates = dates;
	}
	
	
	
	//Extend of length of dates array that holds unique dates in PurchaseQueueList
	public String[] extendArray(String[] array) {
		int len = array.length;
		String[] tmpArray = new String[len + 1];
		for(int i=0; i<len;i++) {
			tmpArray[i] = array[i];
		}
		return tmpArray;
 	}
	
	

}
