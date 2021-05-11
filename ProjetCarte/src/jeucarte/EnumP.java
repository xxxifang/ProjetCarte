package jeucarte;

public enum EnumP {

	carrot(1),lettuce(10),hat(100),rabbit(1000),other(10000);
	
	private final int value;
	private EnumP(int i) {
		this.value=i;
	}
	
	public int getValue() {
		return value;
	}
}
