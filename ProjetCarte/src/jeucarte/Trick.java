package jeucarte;

public class Trick {
	private int score;
	private int[] identity;
	private EnumT name;
	
	public Trick(int s, int[] i, EnumT n) {
		this.score=s;
		this.identity=i;
		this.name=n;
	}
	
	public int getscore() {
		return this.score;
	}
	
	public int[] getidentity() {
		return this.identity;
	}
	
	public EnumT getname() {
		return this.name;
	}
	
	public String toString()
	{
		StringBuffer sb= new StringBuffer();
		sb.append(this.name);
		return sb.toString();
	}

}

	