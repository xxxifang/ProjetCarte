package ControlerGame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import jeucarte.Game;
import jeucarte.Joueur;
import vue.vv;

public class GameVue implements Runnable{

	private Game mygame;
	private vv vue;
	private int value;
	private int MainPlayer;
	private boolean hasChanged = false;
	private boolean active = true;
	
	public GameVue(vv vue, Game myg) {
		this.vue=vue;
		this.mygame=myg; 
		this.value=0;
	};
	public vv getvue() {
		return this.vue;
	}
	public Game getgame() {
		return this.mygame;
	}
	public void updateview()
	{
		//Gets all the new info from Game and transfer into view
	}
	public void setMainPlayer(int mp) {
		this.MainPlayer=mp;
	}
	public void update()
	{
		this.vue.update(mygame,MainPlayer);
	}
	public boolean turnAI(Game mygame,int currentP,vv myvue) {
		boolean x = mygame.getlist().get(currentP).turn(mygame, currentP,myvue);
		return x;
	}
	public boolean turnJ(Game mygame,int currentP,vv myvue) {
		boolean x =mygame.getlist().get(currentP).turn(mygame, currentP, myvue);
		return x;
		}
	public void setVisible() {
			this.vue.getFrame().setVisible(true);
		}
	public void deactivate() {
		this.active=false;
	}
	public void screenActivate(){
		Thread myt = new Thread(this);
		myt.start();
	}
	public void run() {
		while(this.active==true) {
			this.update();
		}
		
	}

	
}
