package jeucarte;

import java.util.LinkedList;


public class Deck {
	public final static int nbcarte=10;
	private LinkedList<Trick> tasDeCartes;
	private int nb=10;
	
	public Deck() {
		tasDeCartes=new LinkedList<Trick>();

		int[] t1= {1001,1010,10001,10010};
		int[] t2= {2};
		int[] t3= {11};
		int[] t4= {1010,10010};
		int[] t5= {11000};
		int[] t6= {101,110};
		int[] t7= {101};
		int[] t8= {1100,10100};
		int[] t9= {1100};
		int[] t10= {10100};
		Trick n1=new Trick(1,t1,EnumT.rocl);
		Trick n2=new Trick(2,t2,EnumT.cc);
		Trick n3=new Trick(3,t3,EnumT.cl);
		Trick n4=new Trick(4,t4,EnumT.rol);
		Trick n5=new Trick(5,t5,EnumT.ro);
		Trick n6=new Trick(2,t6,EnumT.hcl);
		Trick n7=new Trick(3,t7,EnumT.hc);
		Trick n8=new Trick(4,t8,EnumT.hro);
		Trick n9=new Trick(5,t9,EnumT.hr);
		this.tasDeCartes.add(n1);
		this.tasDeCartes.add(n2);
		this.tasDeCartes.add(n3);
		this.tasDeCartes.add(n4);
		this.tasDeCartes.add(n5);
		this.tasDeCartes.add(n6);
		this.tasDeCartes.add(n7);
		this.tasDeCartes.add(n8);
		this.tasDeCartes.add(n9);
		this.melanger();
		Trick n10=new Trick(6,t10,EnumT.ho);
		this.tasDeCartes.add(n10);
	}
	
	public void melanger() {
		for(int i=0; i<Deck.nbcarte-1;i++) {
			int position=(int)Math.round((Deck.nbcarte-2)*Math.random());
			Trick carte=tasDeCartes.pop();
			tasDeCartes.add(position,carte);
		}
	}
	
	public Trick flipnext() {
		nb=moinsun(nb);
		return tasDeCartes.pop();
	}
		
	public boolean estVide() {
		return tasDeCartes.isEmpty();
	}
	
	public String toString() {
		return tasDeCartes.toString();
	}
	
	public int getnb() {
		return this.nb;
	}
	
	public int moinsun(int nb) {
		nb=nb-1;
		return nb;
	}

}
