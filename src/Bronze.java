
public class Bronze implements ICustomer {

	private String type = "BRONZE";
	private int priority = 3;

	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

	@Override
	public int getPriority() {
		// TODO Auto-generated method stub
		return priority;
	}
	
	@Override
	public String toString() {
		return type.toUpperCase();
	}

}
