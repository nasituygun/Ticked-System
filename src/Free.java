
public class Free implements ICustomer {

	private String type = "FREE";
	private int priority = 4;

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