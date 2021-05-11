package jeucarte;

import java.util.ArrayList;
import java.util.LinkedList;

import vue.vv;

public class JoueurAI implements Player {

	private Prop pl;
	private Prop pr;
	private LinkedList<Trick> doneTrick;
	private int score;
	private String name;
	private int age;
	boolean AIupdated=false;
	private int difficulty;
	private String infoAI;
	public JoueurAI(Prop p1,Prop p2,String name,int a)
	{
		
	    this.doneTrick=  new LinkedList<Trick>();
		this.pl=p1;
		this.pr=p2;
		this.score=0;
		this.name=name;
		this.age=a;
		this.AIupdated=false;
		this.difficulty=1;
		this.infoAI=new String("name: " +name);
	}
	public void setDifficulty(int in) {
		this.difficulty=in;
	}
	public boolean getAI() {
		return this.AIupdated;
	}
	public String getinfo()
	{
		this.AIupdated=false;
		return this.infoAI;
	}
	public void setAIinfo(String s) {
		this.AIupdated=true;
		this.infoAI=s;
	}
	public boolean lastturn(int currentP, Game mygame,vv myvue) {
		 if(this.difficulty==1)
	           this.changeAI(currentP,mygame);
		   else 
			   this.changeAIeasy(currentP, mygame);
	       if(this.verifierAI(currentP,mygame)==true) {
	    	   System.out.println("Other Hat Trick!");
	    	   String s="Other Hat Trick!";
	    	   setAIinfo(s);
	    	   this.addTrickScore(mygame.getlist().get(currentP),mygame);
	    	   return true;
	       }else {
	    	this.showAI(currentP,mygame);
	    	System.out.println("For him, the game ended");
	    	String s="For him, the game ended";
	    	setAIinfo(s);
	    	return false;
	       }
	}
	public void changename(String s) {
		this.name=s;
	}
	
	public void addTrickScore(Player j,Game myg)
	{
		Trick t = myg.getpile().sendTrick(myg.getdeck());
		j.addT(t);
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
	///EASYMODE
	public void flipAIeasy(int p,Game mygame)
	{
		int a=(int)Math.round((1)*Math.random()+1);
		if(a==1) {
			String s=mygame.getlist().get(p).getname()+" decided to flip the next Trick Card.";
			this.setAIinfo(s);
			System.out.println(mygame.getlist().get(p).getname()+" decided to flip the next Trick Card.");
			mygame.getpile().addTrick(mygame.getdeck().flipnext());
		}else {
			String s=mygame.getlist().get(p).getname()+" decided to flip the next Trick Card.";
			this.setAIinfo(s);
			System.out.println(mygame.getlist().get(p).getname()+" did not flip the next Trick Card.");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void changeAIeasy(int p,Game mygame)
	{
		boolean fornot = false;
		if(fornot==false) {
			int r1=(int)Math.round((1)*Math.random()+1);
			int r2=(int)Math.round((1)*Math.random()+1);
			int r3=(int)Math.round((1)*Math.random()+1);
			char a,b;
			if(r1==1) {
				a='l';
			}else {
				a='r';
			}
			if(r2==1) {
				b='l';
			}else {
				b='r';
			}
			mygame.changeProp(a,b,mygame.getlist().get(p),mygame.getlist().get((p+r3)%3));
			if(a=='l'&& b=='l')
			{
				System.out.println(mygame.getlist().get(p).getname()+" decided to change his LEFT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s LEFT card.");
			    String s=mygame.getlist().get(p).getname()+" decided to change his LEFT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s LEFT card.";
			    this.setAIinfo(s);
			}else if(a=='l'&& b=='r'){
				System.out.println(mygame.getlist().get(p).getname()+" decided to change his LEFT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s RIGHT card.");
				String s=mygame.getlist().get(p).getname()+" decided to change his LEFT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s RIGHT card.";
			    this.setAIinfo(s);
			}else if(a=='r'&& b=='l'){
				System.out.println(mygame.getlist().get(p).getname()+" decided to change his RIGHT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s LEFT card.");
				String s=mygame.getlist().get(p).getname()+" decided to change his RIGHT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s LEFT card.";
			    this.setAIinfo(s);
			}else {
				System.out.println(mygame.getlist().get(p).getname()+" decided to change his RIGHT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s RIGHT card.");
				String s=mygame.getlist().get(p).getname()+" decided to change his RIGHT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s RIGHT card.";
				this.setAIinfo(s);	
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	///ESAYMODE
	public void flipAI(int p,Game mygame)
	{
		int[] require = mygame.getpile().getRequirement();
		int pr = mygame.getlist().get(p).getP('r').getid();
		int pl = mygame.getlist().get(p).getP('l').getid();
		int[] pothers = new int[4];
		int id = 0;
		ArrayList<Player> jlist = mygame.getlist();
		if(jlist.get((p+1)%3).getP('l').flipstat()) 
			id =1;
		pothers[0]=jlist.get((p+1)%3).getP('l').getid() * id;
		id=0;
		if(jlist.get((p+1)%3).getP('r').flipstat()) 
			id =1;
		pothers[1]=jlist.get((p+1)%3).getP('r').getid() * id;
		id=0;
		if(jlist.get((p+2)%3).getP('l').flipstat()) 
			id =1;
		pothers[2]=jlist.get((p+2)%3).getP('l').getid() * id;
		id=0;
		if(jlist.get((p+2)%3).getP('r').flipstat()) 
			id =1;
		pothers[3]=jlist.get((p+2)%3).getP('r').getid() * id;
		boolean fornot = false;
		for(int i = 0;i<require.length;i++) {
			for(int j=0;j<4;j++) {
				if(pothers[j]+pl==require[i]) {
					fornot=true;break;
				}
				if(pothers[j]+pr==require[i]) {
					fornot=true;break;
				}
			}
		}
		if(fornot==false) {
			String s = jlist.get(p).getname()+" decided to flip the next Trick Card.";
			this.setAIinfo(s);
			System.out.println(jlist.get(p).getname()+" decided to flip the next Trick Card.");
			mygame.getpile().addTrick(mygame.getdeck().flipnext());
		}else {
			String s = jlist.get(p).getname()+" did not flip the next Trick Card.";
			this.setAIinfo(s);
			System.out.println(jlist.get(p).getname()+" did not flip the next Trick Card.");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public void changeAI(int p,Game mygame)
	{
		int[] require = mygame.getpile().getRequirement();
		ArrayList<Player> jlist = mygame.getlist();
		int pr = jlist.get(p).getP('r').getid();
		int pl = jlist.get(p).getP('l').getid();
		int[] pothers = new int[4];
		int id = 0;
		if(jlist.get((p+1)%3).getP('l').flipstat()) 
			id =1;
		pothers[0]=jlist.get((p+1)%3).getP('l').getid() * id;
		id=0;
		if(jlist.get((p+1)%3).getP('r').flipstat()) 
			id =1;
		pothers[1]=jlist.get((p+1)%3).getP('r').getid() * id;
		id=0;
		if(jlist.get((p+2)%3).getP('l').flipstat()) 
			id =1;
		pothers[2]=jlist.get((p+2)%3).getP('l').getid() * id;
		id=0;
		if(jlist.get((p+2)%3).getP('r').flipstat()) 
			id =1;
		pothers[3]=jlist.get((p+2)%3).getP('r').getid() * id;
		boolean fornot = false;
		char lr;
		int player;
		for(int i = 0;i<require.length;i++) {
			for(int j=0;j<4;j++) {
				if(pothers[j]+pl==require[i]) {
					fornot=true;
					if(j==0||j==2) {
						lr='l';
					}else {
						lr='r';
					}
					if(j==0||j==1) {
						player = (p+1)%3;
					}
					else {
						player = (p+2)%3;	
					}
					mygame.changeProp('r',lr,jlist.get(p),jlist.get(player));
					if(lr=='l') {
						System.out.println(jlist.get(p).getname()+" decided to change his RIGHT card with "+jlist.get(player).getname()+"'s LEFT card.");
						String s = jlist.get(p).getname()+" decided to change his RIGHT card with "+jlist.get(player).getname()+"'s LEFT card.";
					    this.setAIinfo(s);
					    break;
					}else {
						String s=jlist.get(p).getname()+" decided to change his RIGHT card with "+jlist.get(player).getname()+"'s RIGHT card.";
						System.out.println(jlist.get(p).getname()+" decided to change his RIGHT card with "+jlist.get(player).getname()+"'s RIGHT card.");
						this.setAIinfo(s);
					    break;
					}
				}
				if(pothers[j]+pr==require[i]) {
					fornot=true;
					if(j==0||j==2) {
						lr='l';
					}else {
						lr='r';
					}
					if(j==0||j==1) {
						player = (p+1)%3;
					}
					else {
						player = (p+2)%3;	
					}
					mygame.changeProp('l',lr,jlist.get(p),jlist.get(player));
					if(lr=='l') {
						System.out.println(jlist.get(p).getname()+" decided to change his LEFT card with "+jlist.get(player).getname()+"'s LEFT card.");
						String s = jlist.get(p).getname()+" decided to change his LEFT card with "+jlist.get(player).getname()+"'s LEFT card.";
					    this.setAIinfo(s);
					    break;
					}else {
						String s=jlist.get(p).getname()+" decided to change his LEFT card with "+jlist.get(player).getname()+"'s RIGHT card.";
						System.out.println(jlist.get(p).getname()+" decided to change his LEFT card with "+jlist.get(player).getname()+"'s RIGHT card.");
						this.setAIinfo(s);
					    break;
					}
					
				}
			}
		}
		if(fornot==false) {
			int r1=(int)Math.round((1)*Math.random()+1);
			int r2=(int)Math.round((1)*Math.random()+1);
			int r3=(int)Math.round((1)*Math.random()+1);
			char a,b;
			if(r1==1) {
				a='l';
			}else {
				a='r';
			}
			if(r2==1) {
				b='l';
			}else {
				b='r';
			}
			mygame.changeProp(a,b,jlist.get(p),jlist.get((p+r3)%3));
			if(a=='l'&& b=='l')
			{
				System.out.println(mygame.getlist().get(p).getname()+" decided to change his LEFT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s LEFT card.");
			    String s=mygame.getlist().get(p).getname()+" decided to change his LEFT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s LEFT card.";
			    this.setAIinfo(s);
			}else if(a=='l'&& b=='r'){
				System.out.println(mygame.getlist().get(p).getname()+" decided to change his LEFT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s RIGHT card.");
				String s=mygame.getlist().get(p).getname()+" decided to change his LEFT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s RIGHT card.";
			    this.setAIinfo(s);
			}else if(a=='r'&& b=='l'){
				System.out.println(mygame.getlist().get(p).getname()+" decided to change his RIGHT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s LEFT card.");
				String s=mygame.getlist().get(p).getname()+" decided to change his RIGHT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s LEFT card.";
			    this.setAIinfo(s);
			}else {
				System.out.println(mygame.getlist().get(p).getname()+" decided to change his RIGHT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s RIGHT card.");
				String s=mygame.getlist().get(p).getname()+" decided to change his RIGHT card with "+mygame.getlist().get((p+r3)%3).getname()+"'s RIGHT card.";
				this.setAIinfo(s);	
			}
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void showAI(int p,Game mygame) {
		ArrayList<Player> jlist = mygame.getlist();
		if(jlist.get(p).getP('l').flipstat()==false && jlist.get(p).getP('r').flipstat()==false) {
		   int r1=(int)Math.round((1)*Math.random()+1);
		   char a;
		   if(r1==1) {
			   a='l';
		   }else {
			   a='r';
		   }
		   jlist.get(p).getP(a).flipup();
		}else if(jlist.get(p).getP('l').flipstat()==false && jlist.get(p).getP('r').flipstat()==true){
			jlist.get(p).getP('l').flipup();
			String s = "Flip AI's left prop already";
			this.setAIinfo(s);
			System.out.println("Flip AI's left prop already");
		}else if(jlist.get(p).getP('l').flipstat()==true && jlist.get(p).getP('r').flipstat()==false) {
			jlist.get(p).getP('r').flipup();
			String s = "Flip AI's right prop already";
			this.setAIinfo(s);
			System.out.println("Flip AI's right prop already");
		}else {
			String s = "No AI's prop to flip";
			this.setAIinfo(s);
			System.out.println("No AI's prop to flip");
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public void swapAI(int p,Game mygame) {
		int c = (int)Math.round(Math.random()*2);
		int cc = (int)Math.round(Math.random());
		ArrayList<Player> jlist = mygame.getlist();
		if(c==1) {
			mygame.swapProp7('l',jlist.get(p));
			if(cc==1) 
			{
				mygame.swapProp7('r',jlist.get(p));
			}	
		}
		else if(c==2){
			mygame.swapProp7('r',jlist.get(p));
			if(cc==1) {
				mygame.swapProp7('l',jlist.get(p));
			}
		}
		else if(c==0) {
			if(cc==1)
				mygame.changeProp('l','r',jlist.get(p),jlist.get(p));
			
		}
		mygame.get7th().flipdown();
		if(jlist.get(p).getP('l').flipstat()==true) {
			jlist.get(p).getP('l').flipdown();
		}
		if(jlist.get(p).getP('r').flipstat()==true) {
			jlist.get(p).getP('r').flipdown();
		}
		String s = jlist.get(p).getname()+" made his decision and swapped Cards";
		this.setAIinfo(s);
		System.out.println(jlist.get(p).getname()+" made his decision and swapped Cards");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean verifierAI(int p,Game mygame)
	{
		boolean v=false;
		int[] valeur = mygame.getpile().getRequirement();
		ArrayList<Player> jlist = mygame.getlist();
		for(int i=0;i<valeur.length;i++) {
			if(valeur[i]==jlist.get(p).getP('l').getid()+jlist.get(p).getP('r').getid()) {
				v=true;break;
			}
		}
		return v;
	}
	public boolean turn(Game mygame,int currentP,vv myvue) {
		boolean x=false;
	    System.out.println(mygame.getpile().toString());
	    System.out.println(mygame.getlist().get(currentP).toString());	    
		System.out.println((mygame.getlist().get(currentP)).toString(mygame.getlist().get((currentP+1)%3)));
		System.out.println(mygame.getlist().get(currentP).toString(mygame.getlist().get((currentP+2)%3)));
	    //Markkkk
		if(this.difficulty==1)
	        this.flipAI(currentP,mygame);
		else
			this.flipAIeasy(currentP, mygame);
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    if(mygame.getdeck().estVide()==true) {
			x=true;
			return x;
			//break;
		}else {
			   System.out.println(mygame.getpile().toString());
			   if(this.difficulty==1)
		           this.changeAI(currentP,mygame);
			   else 
				   this.changeAIeasy(currentP, mygame);
			   try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       if(this.verifierAI(currentP,mygame)==true) {
		    	   System.out.println(mygame.getlist().get(currentP).getname()+" success!");
		    	   String s=mygame.getlist().get(currentP).getname()+" success!";
		    	   setAIinfo(s);
		    	   try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
		    	   this.addTrickScore(mygame.getlist().get(currentP),mygame);
		    	   this.swapAI(currentP,mygame);
		       }else {
		    	this.showAI(currentP,mygame);
		       }
		       try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		       String s=mygame.getlist().get(currentP).getname()+"'s turn ended. He is waiting.";
		       setAIinfo(s);
		       return x;
		       //currentP=(currentP+1)%3;
		    // if(mygame.getdeck().estVide()==true) {break;}
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
