public class Silver implements ICustomer {

	private String type = "SILVER";
	private int priority = 2;

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
