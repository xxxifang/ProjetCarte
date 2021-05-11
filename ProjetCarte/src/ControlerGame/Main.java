package ControlerGame;

//import java.util.Scanner;

import jeucarte.Game;
import jeucarte.Joueur;
import jeucarte.JoueurAI;
import vue.vv;

public class Main {
	public static void main(String[] args) {
		int age,startpos=0,nage;
		int age2,age3;
		String name2,name3;
		Game mygame=new Game();
		vv myvue = new vv();
		GameVue mvControler = new GameVue(myvue,mygame);
		mvControler.setVisible();
		System.out.println("Please select a difficulty for your AI:0 for Easy, 1 for Hard");
		myvue.setMainText("Please select a difficulty for your AI:0 for Easy, 1 for Hard");
		int difficulty=myvue.getIntAction();
		System.out.println("player1: please enter your name");
		myvue.setMainText("player1: please enter your name");
		String name1=myvue.getStringAction();
		System.out.println("player1: please enter your age");
		myvue.setMainText("player1: please enter your age");
		String an1=myvue.getStringAction();
		int age1=0;
		try {

		     age1 = Integer.parseInt(an1);

		} catch (NumberFormatException e) {

		    e.printStackTrace();

		}
		System.out.println("[player1] name:"+name1+", age:"+age1);
		Joueur j1=new Joueur(mygame.getProp().pop(),mygame.getProp().pop(),name1,age1);
		mygame.getlist().add(j1);
		System.out.println("player2: player or AI?---player:1, AI:0");
		myvue.setMainText("player2: player or AI?---player:1, AI:0");
		int p2=myvue.getIntAction();
		if(p2==1) {
		System.out.println("player2: please enter your name");
		String k2=myvue.getStringAction();
		System.out.println("player2: please enter your age");
		String an2=myvue.getStringAction();
		age2=0;
		try {

		     age2 = Integer.parseInt(an2);

		} catch (NumberFormatException e) {

		    e.printStackTrace();

		}
		System.out.println("[player2] name:"+k2+", age:"+age2);
		name2=k2;
		Joueur j2=new Joueur(mygame.getProp().pop(),mygame.getProp().pop(),name2,age2);
		mygame.getlist().add(j2);
		}else {
			name2="Computer.Pierre";
			age2=(int)Math.round((9)*Math.random()+91);
			System.out.println("[AI2] computer.Pierre, age:"+age2);
			JoueurAI j2 = new JoueurAI(mygame.getProp().pop(),mygame.getProp().pop(),name2,age2);
			j2.setDifficulty(difficulty);
			mygame.getlist().add(j2);			
		}
		
		System.out.println("player3: player or AI?---player:1, AI:0");
		myvue.setMainText("player3: player or AI?---player:1, AI:0");
		int p3=myvue.getIntAction();
		if(p3==1) {
		System.out.println("player3: please enter your name");
		String k3=myvue.getStringAction();
		System.out.println("player3: please enter your age");
		String an3 = myvue.getStringAction();
		int a3=0;
		try {

		     a3 = Integer.parseInt(an3);

		} catch (NumberFormatException e) {

		    e.printStackTrace();

		}
		System.out.println("[player3] name:"+k3+", age:"+a3);
		age3=a3;
		name3=k3;
		Joueur j3=new Joueur(mygame.getProp().pop(),mygame.getProp().pop(),"p3",age3);
		mygame.getlist().add(j3);	
		}else {
			name3="Computer.Dupont";
			age3=(int)Math.round((9)*Math.random()+91);
			System.out.println("[AI3] computer.Dupont, age:"+age3);
			JoueurAI j3 = new JoueurAI(mygame.getProp().pop(),mygame.getProp().pop(),name3,age3);
			j3.setDifficulty(difficulty);
			mygame.getlist().add(j3);
		}
		
		mygame.getlist().get(0).changename(name1);
		mygame.getlist().get(1).changename(name2);
		mygame.getlist().get(2).changename(name3);
		
		age=mygame.getlist().get(0).getage();
		for(int i=0;i<3;i++){
		    nage = mygame.getlist().get(i).getage();
			if(nage<age) {
				startpos=i;
				age=nage;
		    }
		}

		int currentP=startpos;
		
		mvControler.setMainPlayer(0);
		mygame.getpile().addTrick(mygame.getdeck().flipnext());
		boolean x=false;
		mvControler.screenActivate();
		while(mygame.getpile().lastTrick()==false) {
			  if(mygame.getlist().get(currentP) instanceof Joueur) {
				  //Player.turn
				  x=mygame.getlist().get(currentP).turn(mygame, currentP,myvue);
				  myvue.update(mygame, startpos);
				  if(x==true)break;
				    currentP=(currentP+1)%3;
				    if(mygame.getdeck().estVide()==true) {break;}
				
			  }
			  else {
				  //AI.TURN
				  x=mygame.getlist().get(currentP).turn(mygame, currentP,myvue);
				  if(x==true)break;
	              currentP=(currentP+1)%3;
			      if(mygame.getdeck().estVide()==true) {break;}
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
				System.out.println(mygame.getpile().toString());
				x=false;
			}
			if(mygame.getlist().get(currentP) instanceof Joueur) {
				 lastperform = mygame.getlist().get(currentP).lastturn(currentP, mygame,myvue);
				 if(lastperform==true)
					 break;
				 else
						currentP=(currentP+1)%3;
			}
			else {
				lastperform = mygame.getlist().get(currentP).lastturn(currentP, mygame,myvue);
				if(lastperform==true)
					 break;
				else
					currentP=(currentP+1)%3;	
			}
		}
		System.out.println("Game ended! Who is the winner?");
		Joueur j = (Joueur)mygame.getlist().get(0);
		j.setJinfo("Game ended! Who is the winner?");
		if(lastperform==false) {
			for(int i=0;i<3;i++) {
				int pl=mygame.getlist().get(i).getP('l').getid();
				int pr=mygame.getlist().get(i).getP('r').getid();
				if(pl==100||pl==10000) {
					mygame.getlist().get(i).changescore(-3);
				}
				if(pr==100||pr==10000) {
					mygame.getlist().get(i).changescore(-3);
				}
			}
		}
		int winner=0;
		int highest=-7;
		int[] score=new int[3];
		for(int i=0;i<3;i++) {
			score[i]=mygame.getlist().get(i).getscore();
			if(score[i]>highest)
			{
				winner=i;
				highest=score[i];
			}
		}
		try {
			Thread.sleep(1503);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		j.setJinfo("Winner: "+mygame.getlist().get(winner).getname()+"! Congratulations!!!");
		System.out.println("Winner: "+mygame.getlist().get(winner).getname()+"! Congratulations!!!");
		System.out.println("name: "+name1+", score: "+mygame.getlist().get(0).getscore()+"   Cards: "+mygame.getlist().get(0).getP('l').toString()+"  "+mygame.getlist().get(0).getP('r').toString());
		System.out.println("name: "+name2+", score: "+mygame.getlist().get(1).getscore()+"   Cards: "+mygame.getlist().get(1).getP('l').toString()+"  "+mygame.getlist().get(1).getP('r').toString());
		System.out.println("name: "+name3+", score: "+mygame.getlist().get(2).getscore()+"   Cards: "+mygame.getlist().get(2).getP('l').toString()+"  "+mygame.getlist().get(2).getP('r').toString());
	
}

}
