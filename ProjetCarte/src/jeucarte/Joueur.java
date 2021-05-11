package jeucarte;
import java.util.*;

import vue.vv;
/**
 * The class that includes all the contents of one Player of the game. It includes two Props of left and right, and all the Tricks he performed
 * as well as his score.
 * @author Liu et Zhou
 *@version 1.0F
 */
public class Joueur implements Player {
	private Prop pl;
	private Prop pr;
	private LinkedList<Trick> doneTrick;
	private int score;
	private String name;
	private int age;
	private String infoJ;
	private boolean Jupdated=false;
	//boolean isAI=false;
	
	public void setJinfo(String s) {
		this.Jupdated=true;
		this.infoJ=s;
	}
	public String getinfo() {
		this.Jupdated=false;
		return this.infoJ;
	}
	public Joueur(Prop p1,Prop p2,String name,int a)
	{
		
	    this.doneTrick=  new LinkedList<Trick>();
		this.pl=p1;
		this.pr=p2;
		this.score=0;
		this.name=name;
		this.age=a;
		this.infoJ=name; 
		//this.isAI=false;
	}
	
	
	public void changename(String s) {
		this.name=s;
	}
	
	public int getage() {
		return this.age;
	}
	
	public String getname() {
		return this.name;
	}
	
	public Prop getP(char c)
	{
		if(c=='l')
			return this.pl;
		else if(c=='r')
			return this.pr;
		else
			return this.pl;
	}
	
	public void setP(char c,Prop pin)
	{
		if(c=='l')
		{
			this.pl=pin;
		}
		else if(c=='r')
		{
			this.pr=pin;
		}
	}
	
	public int getscore() {
		return this.score;
	}
	
	public void showP(char c)
	{
		if(c=='l')
		{
			this.pl.flipup();
		}
		else
			this.pr.flipup();
	}
	public void flipTrick(Game myg,int c) {
		System.out.println("Flip trick or not?---flip:1, not:0");
		String str="Flip trick or not?---flip:1, not:0";
		setJinfo(str);
		
		
		
		if(c==1) {
			myg.getpile().addTrick(myg.getdeck().flipnext());
		}
	}	
	public void changeProp(char c1,char c2,Player p1,Player p2)
	{
		Prop inter= new Prop(EnumP.carrot);
		inter = p1.getP(c1);
	  	p1.setP(c1, p2.getP(c2));
	  	p2.setP(c2, inter);
	}
	public void change(Player p1,Player p2,vv myvue) {
		char send;
			char get;
			System.out.println("Which prop do you want to send?---left:1, right:2");
			String str="Which prop do you want to send?---left:1, right:2";
			setJinfo(str);
			
			int c = myvue.getIntAction();
			if(c==1) {
				send='l';
			}else{
				send='r';
			}
			System.out.println("Which prop do you want to get?---left:1, right:2");
			str="Which prop do you want to get?---left:1, right:2";
			setJinfo(str);
			////UpDATE
			int cc = myvue.getIntAction();	
			if(cc==1) {
				get='l';
			}else{
				get='r';
			}
			changeProp(send,get,p1,p2);
		}
	
	public void swapProp7(char c1,Player p1,Game myg)
	{
		Prop p4 = myg.get7th();
		Prop inter= new Prop(EnumP.carrot);
	  	inter = p1.getP(c1);
	  	p1.setP(c1, p4);
	  	myg.set7th(inter);
	}
	public boolean verifier(Player j,Game myg,vv myvue) {
		boolean v=false;
		int[] valeur=myg.getpile().getRequirement();
		for(int i=0;i<valeur.length;i++) {
			if(valeur[i]==j.getP('l').getid()+j.getP('r').getid()) {
				v=true;break;
			}
		}
		if(v==true) {
			System.out.println("Do trick or not?---do:1, not:0");
			String s="Do trick or not?---do:1, not:0";
			setJinfo(s);			
			int c = myvue.getIntAction();	
			if(c==0) {
				v=false;
			}
		}
		return v;
	}
	public void addTrickScore(Player j,Game myg)
	{
		Trick t = myg.getpile().sendTrick(myg.getdeck());
		j.addT(t);
	}
	public void swap(Player j,Game myg,vv myvue) {
		myg.get7th().flipup();
		System.out.println("Move 7th prop to your?---left:1, right:2, not move:0");
		String s="Move 7th prop to your?---left:1, right:2, not move:0";
		setJinfo(s);
		int c = myvue.getIntAction();	
		if(c==1) {
			this.swapProp7('l',j,myg);
			System.out.println("Do you want to move the other two props?---yes:1, no:0");
			s="Do you want to move the other two props?---yes:1, no:0";
			setJinfo(s);					
			int cc = myvue.getIntAction();
			if(cc==1) {
				this.swapProp7('r',j,myg);
			}
		}else if(c==2){
			this.swapProp7('r',j,myg);
			System.out.println("Do you want to move the other two props?---yes:1, no:0");
			s="Do you want to move the other two props?---yes:1, no:0";
			setJinfo(s);
			int cc = myvue.getIntAction();
			if(cc==1) {
				this.swapProp7('l',j,myg);
			}
		}else if(c==0) {
			System.out.println("Do you want to move the other two props?---yes:1, no:0");
			s="Do you want to move the other two props?---yes:1, no:0";
			setJinfo(s);
			int cc = myvue.getIntAction();
			if(cc==1) {
				this.changeProp('l','r',j,j);
			}
		}
		if(j.getP('l').flipstat()==true) {
			j.getP('l').flipdown();
		}
		if(j.getP('r').flipstat()==true) {
			j.getP('r').flipdown();
		}
		if(myg.get7th().flipstat()==true) {
			myg.get7th().flipdown();
		}
		
	}
	public void showprop(Player j,vv myvue) {
		if(j.getP('l').flipstat()==false && j.getP('r').flipstat()==false) {
			System.out.println("Flip left or right?---left:1, right:2");
			String s="Flip left or right?---left:1, right:2";
			setJinfo(s);
			int c = myvue.getIntAction();			
			if(c==1) {
				j.getP('l').flipup();
			}else if(c==2){
				j.getP('r').flipup();
			}
		}else if(j.getP('l').flipstat()==false && j.getP('r').flipstat()==true){
			j.getP('l').flipup();
			System.out.println("Flip your left prop already");
			String s="Flip your left prop already";
			setJinfo(s);	
		}else if(j.getP('l').flipstat()==true && j.getP('r').flipstat()==false) {
			j.getP('r').flipup();
			System.out.println("Flip your right prop already");
			String s="Flip your right prop already";
			setJinfo(s);		
		}else {
			System.out.println("No prop to flip");
			String s="No prop to flip";
			setJinfo(s);			
		}
	}
	
	public boolean turn(Game mygame,int currentP,vv myvue ) { 
		boolean x = false;
		System.out.println(mygame.getpile().toString());
		System.out.println(mygame.getlist().get(currentP).toString());	    
		System.out.println((mygame.getlist().get(currentP)).toString(mygame.getlist().get((currentP+1)%3)));
		System.out.println(mygame.getlist().get(currentP).toString(mygame.getlist().get((currentP+2)%3)));
		//Mark///
		//myvue.setMainText("Flip trick or not?---flip:1, not:0");
		System.out.println("Flip trick or not?---flip:1, not:0");
		String s="Flip trick or not?---flip:1, not:0";
		setJinfo(s);
		int input = myvue.getIntAction();
		this.flipTrick(mygame,input);
		if(mygame.getdeck().estVide()==true) {
			x=true;
			return x;
			//break;
		}else {
			System.out.println(mygame.getpile().toString());
		    System.out.println("Change card with the ___ player?---next(right):1, previous(left):2");
		    s="Change card with the ___ player?---next(right):1, previous(left):2";
			setJinfo(s);
		    int c = myvue.getIntAction();
		    this.change(mygame.getlist().get(currentP), mygame.getlist().get((currentP+c)%3),myvue);
		    if(this.verifier(mygame.getlist().get(currentP),mygame,myvue)==true) {
			this.addTrickScore(mygame.getlist().get(currentP),mygame);
			this.swap(mygame.getlist().get(currentP),mygame,myvue);
		    }else {
			this.showprop(mygame.getlist().get(currentP),myvue);
		    }
		}
		s="Waiting...others turn. Don't press the botton!";
		setJinfo(s);
		return x;
	}
	public boolean lastturn(int currentP, Game mygame,vv myvue) {
		 System.out.println("Change card with the ___ player?---next:1, previous:2");
		 String s="Change card with the ___ player?---next:1, previous:2";
		 setJinfo(s);
		 int c=myvue.getIntAction();
		 Joueur jojo = (Joueur)(mygame.getlist().get(currentP));
		 jojo.change(mygame.getlist().get(currentP), mygame.getlist().get((currentP+c)%3),myvue);
		 if(jojo.verifier(mygame.getlist().get(currentP),mygame,myvue)==true) {
				jojo.addTrickScore(mygame.getlist().get(currentP),mygame);
				System.out.println("Other hat trick!");
				s="Other hat trick!";
				setJinfo(s);
				return true;	
			    }else {
				jojo.showprop(mygame.getlist().get(currentP),myvue);
				currentP=(currentP+1)%3;
				System.out.println("For you, the game ended");
				s="For you, the game ended";
				setJinfo(s);
				return false;
			    }
	}
	public String toString()
	{
		StringBuffer sb = new StringBuffer();
		sb.append(this.name);
		sb.append(" is your turn---");
		sb.append("Props in hand: "+this.pl.toString()+" "+this.pr.toString()+"\n");
		sb.append("Score: "+this.score+"\n");
		return sb.toString();	
	}
	/**
	 * We seperate the toString of one player itself and the toString of other players during a certain player's turn. The latter will not display the
	 * cards that are not fliped.
	 * @param a
	 * @return
	 */
	public String toString(Player a)
	{
		StringBuffer sb = new StringBuffer();
		Prop pl = a.getP('l');
		Prop pr = a.getP('r');
		sb.append(a.getname()+" Cards: ");
		sb.append("Props in hand: ");
		if(pl.flipstat()==true) {
			sb.append(pl.toString()+" ");
		}else {
			sb.append("*** ");
		}
		if(pr.flipstat()==true) {
			sb.append(pr+" ");
		}else {
			sb.append("*** ");
		}
		sb.append("\nScore: "+a.getscore()+"\n");
		return sb.toString();
	}
	
	public void addT(Trick in)
	{
		this.score=this.score+in.getscore();
		this.doneTrick.add(in);
	}
	
	
	public void changescore(int a) {
		this.score=this.score+a;
	}

}
