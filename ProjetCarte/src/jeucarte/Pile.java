package jeucarte;
import java.util.*;
public class Pile {
	private LinkedList<Trick> trickPile;
	private int nb;
	public Pile()
	{
		this.trickPile = new LinkedList<Trick>();
		this.nb=0;
	}
	public void addTrick(Trick nT)
	{
		this.trickPile.add(0,nT);
		this.nb=this.nb+1;
	}
	public Trick sendTrick(Deck in)
	{
		 
		Trick out = this.trickPile.pop();
		this.nb=this.nb-1;
		
		if(nb==0)
		{
			Trick newt = in.flipnext();
			this.addTrick(newt);
		}
		
		return out;
	}
	public int[] getRequirement()
	{
		Trick out = this.trickPile.getFirst();
		return out.getidentity();
	}
	
	public boolean lastTrick()
	{
		boolean out = false;
		Trick last = this.trickPile.getFirst();
		if(last.getname()==EnumT.ho) out =true;
		return out;
	}
	
	public String toString()
	{
		StringBuffer sb= new StringBuffer();
		sb.append("Current Trick: "+this.topTrick().toString());
		return sb.toString();
	}
	
	public Trick topTrick()
	{
		return this.trickPile.getFirst();
	}

}
