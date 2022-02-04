public interface IPriorityQueue<T> {
	
	public void insert(T newEntry);
	public T remove();
	public boolean isEmpty();
	public void clear();
	public String toString();
	
	/*-------------------------------------------------------------------*/
	public Purchase getHead();
	public int getTotalWaitingTime();
	public int getSize();
	public String getDate() ;
	public PurchaseQueue<T> getNext();
	public int getGoldMember();
	public int getSilverMember();
	public int getBronzeMember();
	public int getFreeMember();
	public int getGoldWaitingTime();
	public int getSilverWaitingTime();
	public int getBronzeWaitingTime() ;
	public int getFreeWaitingTime();
	public double getAverageGoldWaitingTime();
	public double getAverageSilverWaitingTime();
	public double getAverageBronzewaitingTime() ;
	public double getAverageFreeWaitingTime();
	public double getAverageWaitingTime() ;
	
	/*--------------------------------------------------------------------------*/
	
	public void setNext(PurchaseQueue<T> nextPQ);
	public void setTotalMember(String type);
	public void setWaitings() ;
	
}
