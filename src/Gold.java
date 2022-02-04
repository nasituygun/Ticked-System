
public class Gold implements ICustomer {
	
	private String type = "GOLD";
	private int priority = 1;

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

