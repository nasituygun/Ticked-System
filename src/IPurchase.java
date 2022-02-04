
public interface IPurchase {

	public String getDate();
	public int getID() ;
	public ICustomer getCustomer();
	public int getOccupation();
	public int getWaiting();
	public Purchase getNext();
	public String getSeatNo();
	
	/*---------------------------------------------------------*/

	
	public void setNext(Purchase nextPurchase);
	public void setWaiting(int waiting) ;
	
	/*----------------------------------------------------------------*/
	
	
	public String toString();
	
}
