package jeucarte;

import java.util.*;
/**
 * The class that contains all the components and fonctions for the game to operate. Also includes the Main fonction of the game.
 * @author Nanzhi FANG
 *@version 0.99FiniAI
 *
 */
public class Game {
	public final static int nbprop=7;
	private LinkedList<Prop> tasDeProps;
	private Deck gamedeck;
	private Pile gamepile;
	private int[] valeur;
	private ArrayList<Player> jlist;
	private Prop p4;
	private int currentP;
	public Game() {
	
		tasDeProps=new LinkedList<Prop>();
		
		Prop n1=new Prop(EnumP.carrot);
		Prop n2=new Prop(EnumP.carrot);
		Prop n3=new Prop(EnumP.carrot);
		Prop n4=new Prop(EnumP.lettuce);
		Prop n5=new Prop(EnumP.hat);
		Prop n6=new Prop(EnumP.rabbit);
		Prop n7=new Prop(EnumP.other);
		this.tasDeProps.add(n1);
		this.tasDeProps.add(n2);
		this.tasDeProps.add(n3);
		this.tasDeProps.add(n4);
		this.tasDeProps.add(n5);
		this.tasDeProps.add(n6);
		this.tasDeProps.add(n7);
		this.melangerP();
		jlist = new ArrayList<Player>();	
		this.p4=tasDeProps.pop();
		this.gamedeck=new Deck();
		this.gamepile=new Pile();
		this.valeur=new int[4];
		this.currentP=0;
	}
	public Pile getpile() {
		return this.gamepile;
	}
	public Deck getdeck() {
		return this.gamedeck;
	}
	public ArrayList<Player> getlist(){
		return this.jlist;
	}
	public Prop get7th() {
		return this.p4;
	}
	public void set7th(Prop np) {
		this.p4=np;
	}
	public LinkedList<Prop> getProp()
	{
		return this.tasDeProps;
	}
	/**
	 * This is the AI version of the function filp in Game class. The AI will see if there are already a possible performance of a Trick with all the 
	 * cards that it can see. If not, it will chose to flip.
	 */
	
	/**
	 * This is the AI version of change. It follows the same way of thinking as flipAI. When there is no avalible Trick to perform, it will choose
	 * randomly.
	 * @param p representing the code for the current player(0,1,2)
	 */
	
	
	/**
	 * This is the show function for a AI, it generates the choices randomly.
	 * @param p
	 */
	
	
	
	
	
	
	public void melangerP() {
		for(int i=0; i<Game.nbprop;i++) {
			int position=(int)Math.round((Game.nbprop-1)*Math.random());
			Prop carte=tasDeProps.pop();
			tasDeProps.add(position,carte);
		}
	}
	/**
	 * This is the first step that all player will do in his turn, dicide if he will flip the next Trick or not.
	 */
	
	/**
	 * Then We enter the change phase. The current player will decide to swap props with another player.
	 * @param c1
	 * @param c2
	 * @param p1
	 * @param p2
	 */
	public void changeProp(char c1,char c2,Player p1,Player p2)
	{
		Prop inter= new Prop(EnumP.carrot);
		inter = p1.getP(c1);
	  	p1.setP(c1, p2.getP(c2));
	  	p2.setP(c2, inter);
	}
	/**
	 * The method that is used to get response of which to change and what to get.
	 * @param p1
	 * @param p2
	 */
	public void swapProp7(char c1,Player p1)
	{
		Prop inter= new Prop(EnumP.carrot);
	  	inter = p1.getP(c1);
	  	p1.setP(c1, this.p4);
	  	this.p4=inter;
	}
	/**
	 * Verify is a certain player's Props in hand correspond with the Trick on top of the Pile
	 * @param j
	 * @return
	 */
	
	
	public void addTrickScore(Joueur j)
	{
		Trick t = this.gamepile.sendTrick(this.gamedeck);
		j.addT(t);
	}
	/**
	 * When a player succeded in performing a certain Trick, he will have to swap cards with the 7th Prop in the middle.
	 * @param j
	 */
	
	
	/**
	 * If a player fails to perform a Trick, he has to show one card. If the card selected is already shown, the system automatically shows the other.
	 * @param j
	 */
	
	/*public static void main(String[] args) {
		int age,startpos=0,nage;
		int age2,age3;
		String name2,name3;
		Game mygame=new Game();
		Scanner s=new Scanner(System.in);
		System.out.println("Please select a difficulty for your AI:0 for Easy, 1 for Hard");
		int difficulty=s.nextInt();
		s.nextLine();
		System.out.println("player1: please enter your name");
		String name1=s.nextLine();
		System.out.println("player1: please enter your age");
		int age1=s.nextInt();
		s.nextLine();
		System.out.println("[player1] name:"+name1+", age:"+age1);
		Joueur j1=new Joueur(mygame.getProp().pop(),mygame.getProp().pop(),name1,age1);
		mygame.jlist.add(j1);
		System.out.println("player2: player or AI?---player:1, AI:0");
		int p2=s.nextInt();
		s.nextLine();
		if(p2==1) {
		System.out.println("player2: please enter your name");
		String k2=s.nextLine();
		System.out.println("player2: please enter your age");
		int a2=s.nextInt();
		s.nextLine();
		System.out.println("[player2] name:"+k2+", age:"+a2);
		age2=a2;
		name2=k2;
		Joueur j2=new Joueur(mygame.getProp().pop(),mygame.getProp().pop(),name2,age2);
		mygame.jlist.add(j2);
		}else {
			name2="Computer.Pierre";
			age2=(int)Math.round((99)*Math.random()+1);
			System.out.println("[AI2] computer.Pierre, age:"+age2);
			JoueurAI j2 = new JoueurAI(mygame.getProp().pop(),mygame.getProp().pop(),name2,age2);
			j2.setDifficulty(difficulty);
			mygame.jlist.add(j2);			
		}
		
		System.out.println("player3: player or AI?---player:1, AI:0");
		int p3=s.nextInt();
		s.nextLine();
		if(p3==1) {
		System.out.println("player3: please enter your name");
		String k3=s.nextLine();
		System.out.println("player3: please enter your age");
		int a3=s.nextInt();
		s.nextLine();
		System.out.println("[player3] name:"+k3+", age:"+a3);
		age3=a3;
		name3=k3;
		Joueur j3=new Joueur(mygame.getProp().pop(),mygame.getProp().pop(),"p3",age3);
		mygame.jlist.add(j3);	
		}else {
			name3="Computer.Dupont";
			age3=(int)Math.round((99)*Math.random()+1);
			System.out.println("[AI3] computer.Dupont, age:"+age3);
			JoueurAI j3 = new JoueurAI(mygame.getProp().pop(),mygame.getProp().pop(),name3,age3);
			j3.setDifficulty(difficulty);
			mygame.jlist.add(j3);
		}
		
		mygame.jlist.get(0).changename(name1);
		mygame.jlist.get(1).changename(name2);
		mygame.jlist.get(2).changename(name3);
		
		age=mygame.jlist.get(0).getage();
		for(int i=0;i<3;i++){
		    nage = mygame.jlist.get(i).getage();
			if(nage<age) {
				startpos=i;
				age=nage;
		    }
		}
		
		int currentP=startpos;
		mygame.gamepile.addTrick(mygame.gamedeck.flipnext());
		boolean x=false;
		while(mygame.gamepile.lastTrick()==false) {
		  if(mygame.jlist.get(currentP) instanceof Joueur) {
			  ///Player.turn
			  x=mygame.jlist.get(currentP).turn(mygame, currentP);
			  if(x==true)break;
			    currentP=(currentP+1)%3;
			    if(mygame.gamedeck.estVide()==true) {break;}
			
		  }
		  else {
			  ////AI.TURN
			  x=mygame.jlist.get(currentP).turn(mygame, currentP);
			  if(x==true)break;
              currentP=(currentP+1)%3;
		      if(mygame.gamedeck.estVide()==true) {break;}
				}
		  }
		boolean lastperform=false;
		for(int j=0;j<3;j++) {
			if(x==false) {
				System.out.println(mygame.getpile().toString());
				System.out.println(mygame.getlist().get(currentP).toString());	    
				System.out.println((mygame.getlist().get(currentP)).toString(mygame.getlist().get((currentP+1)%3)));
				System.out.println(mygame.getlist().get(currentP).toString(mygame.getlist().get((currentP+2)%3)));
			}else {
				System.out.println(mygame.gamepile.toString());
				x=false;
			}
			if(mygame.getlist().get(currentP) instanceof Joueur) {
				 lastperform = mygame.getlist().get(currentP).lastturn(currentP, mygame);
				 if(lastperform==true)
					 break;
				 else
						currentP=(currentP+1)%3;
			}
			else {
				lastperform = mygame.getlist().get(currentP).lastturn(currentP, mygame);
				if(lastperform==true)
					 break;
				else
					currentP=(currentP+1)%3;	
			}
		}
		
        s.close();
		
		System.out.println("Game ended! Who is the winner?");
		if(lastperform==false) {
			for(int i=0;i<3;i++) {
				int pl=mygame.jlist.get(i).getP('l').getid();
				int pr=mygame.jlist.get(i).getP('r').getid();
				if(pl==100||pl==10000) {
					mygame.jlist.get(i).changescore(-3);
				}
				if(pr==100||pr==10000) {
					mygame.jlist.get(i).changescore(-3);
				}
			}
		}
		int winner=0;
		int highest=-7;
		int[] score=new int[3];
		for(int i=0;i<3;i++) {
			score[i]=mygame.jlist.get(i).getscore();
			if(score[i]>highest)
			{
				winner=i;
				highest=score[i];
			}
		}
		System.out.println("Winner: "+mygame.jlist.get(winner).getname()+"! Congratulations!!!");
		System.out.println("name: "+name1+", score: "+mygame.jlist.get(0).getscore()+"   Cards: "+mygame.jlist.get(0).getP('l').toString()+"  "+mygame.jlist.get(0).getP('r').toString());
		System.out.println("name: "+name2+", score: "+mygame.jlist.get(1).getscore()+"   Cards: "+mygame.jlist.get(1).getP('l').toString()+"  "+mygame.jlist.get(1).getP('r').toString());
		System.out.println("name: "+name3+", score: "+mygame.jlist.get(2).getscore()+"   Cards: "+mygame.jlist.get(2).getP('l').toString()+"  "+mygame.jlist.get(2).getP('r').toString());
	}*/
}
