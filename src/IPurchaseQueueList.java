
public interface IPurchaseQueueList {
	
	
	public PurchaseQueue<Purchase> getPurchaseQueue(String date);
	public String[] getDates();
	/*----------------------------------------------------------------------------*/
	
	public boolean updatePurchaseQueue(String date, Purchase PQ);
	public void insertTo(PurchaseQueue<Purchase> PQ);
	
	/*----------------------------------------------------------------------------*/
	
	public void removePurchaseQueue();
	public PurchaseQueue<Purchase> removePurchaseQueue(String date);

	/*----------------------------------------------------------------------------*/
	
	public boolean isEmpty();
	public boolean clear();
	public String toString();
	public String[] extendArray(String[] array);
	public void setDates(String[] dates);
	
	
	}


