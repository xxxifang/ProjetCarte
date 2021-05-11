package jeucarte;


import vue.vv;

public interface Player {

	public boolean turn(Game Myg,int currentP,vv myvue);
	public boolean lastturn(int currentP, Game myg,vv myvue);
	public String toString();
	public void changename(String s);
	public int getage();
	public String getname();
	public Prop getP(char c);
	public void setP(char c,Prop pin);
	public int getscore();
	public void showP(char c);
	public String toString(Player a);
	public void addT(Trick in);
	public void changescore(int a);
	public String getinfo();
	
}
