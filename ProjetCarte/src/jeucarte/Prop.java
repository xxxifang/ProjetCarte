package jeucarte;

public class Prop {
	private boolean flipetat;
	private int identity;
	private EnumP  name;
	
	public Prop(EnumP in)
	{
		this.name=in;
		this.identity=in.getValue();
		this.flipetat=false;
	}
	public int getid()
	{
		return this.identity;
	}
	public int getid(Prop p) 
	{
		return p.getid();
	}
	public void flipup()
	{
		this.flipetat=true;
	}
	public void flipdown()
	{
		this.flipetat=false;
	}
	
	public boolean flipstat() 
	{
		return this.flipetat;
	}
	
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.name);
		return sb.toString();
	}

}
