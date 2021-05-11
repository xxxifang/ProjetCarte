package vue;

//import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

//import java.awt.EventQueue;

//import javax.swing.JFrame;
import javax.swing.JLabel;
//import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
//import java.awt.CardLayout;
import javax.swing.JTextField;

import jeucarte.Game;
import jeucarte.Prop;
import jeucarte.Trick;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
//import javax.swing.JTextPane;
//import java.awt.Component;
//import javax.swing.Box;
import javax.swing.SwingConstants;
import java.awt.Font;
public class vv {

	private JFrame frame;
	private JTextField Maintext;
	private JTextField leftProp;
	private JTextField rightProp;
	private JTextField leftturn;
	private JTextField rightturn;
	private JButton clic0;
	private JButton clic1;
	private JButton clic2;
	private int value=0;
	private boolean haschange=false;
	private JTextField txtScorep;
	private JTextField txtScorep_1;
	private JTextField txtScorep_2;
	private JTextField txtNamep;
	private JTextField txtNamep_1;
	private JTextField txtAgep;
	private JTextField txtAgep_1;
	private JTextField txtthprop;
	private JTextField txtNamep_2;
	private JTextField txtAgep_2;
	private JTextField txtResteTrickIn;
	private JTextField txtPilecurrentTrick;
	private JLabel lblPll;
	private JLabel lblPrr;
	private JLabel lblPlll;
	private JLabel lblPrrr;
	private JLabel lblPl;
	private JLabel lblPr;
	private JLabel lblth;
	private JLabel lblDeck;
	private JLabel lblPile;
	private ImageIcon cc;
	private ImageIcon cl;
	private ImageIcon hc;
	private ImageIcon hcl;
	private ImageIcon ho;
	private ImageIcon hr;
	private ImageIcon hro;
	private ImageIcon ro;
	private ImageIcon rocl;
	private ImageIcon rol;
	private ImageIcon C1;
	private ImageIcon L;
	private ImageIcon H;
	private ImageIcon R;
	private ImageIcon O;
	private ImageIcon white;
	private JTextField enterField;
	private JButton btnEnter;
	private String readed;
	private boolean stringChange=false;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			vv window = new vv();
			window.frame.setVisible(true);
			int i=  window.getIntAction();
			
			i=  window.getIntAction();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	public JFrame getFrame()
	{
		return this.frame;
	}

	/**
	 * Create the application.
	 */
	public vv() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(new Color(128, 0, 128));
		frame.getContentPane().setBackground(new Color(255, 240, 245));
		frame.setBounds(100, 100, 1300, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		lblPl = new JLabel("pl");
		lblPl.setLabelFor(frame.getContentPane());
		lblPl.setIcon(new ImageIcon("src\\images\\Propdown.jpg"));
		lblPl.setBounds(30, 154, 140, 200);
		frame.getContentPane().add(lblPl);
		
		lblPr = new JLabel("pr");
		lblPr.setIcon(new ImageIcon("src\\images\\Propdown.jpg"));
		lblPr.setBounds(184, 154, 140, 200);
		frame.getContentPane().add(lblPr);
		
		lblPll = new JLabel("pll");
		lblPll.setIcon(new ImageIcon("src\\images\\Propdown.jpg"));
		lblPll.setBounds(481, 366, 140, 200);
		frame.getContentPane().add(lblPll);
		
		lblPrr = new JLabel("prr");
		lblPrr.setIcon(new ImageIcon("src\\images\\Propdown.jpg"));
		lblPrr.setBounds(635, 366, 140, 200);
		frame.getContentPane().add(lblPrr);
		
		lblPlll = new JLabel("plll");
		lblPlll.setIcon(new ImageIcon("src\\images\\Propdown.jpg"));
		lblPlll.setBounds(943, 154, 140, 200);
		frame.getContentPane().add(lblPlll);
		
		lblPrrr = new JLabel("prrr");
		lblPrrr.setIcon(new ImageIcon("src\\images\\Propdown.jpg"));
		lblPrrr.setBounds(1097, 154, 140, 200);
		frame.getContentPane().add(lblPrrr);
		
		lblth = new JLabel("7th");
		lblth.setIcon(new ImageIcon("src\\images\\Propdown.jpg"));
		lblth.setBounds(564, 154, 140, 200);
		frame.getContentPane().add(lblth);
		
		lblDeck = new JLabel("deck");
		lblDeck.setIcon(new ImageIcon("src\\images\\Trickdown.png"));
		lblDeck.setBounds(397, 13, 200, 140);
		frame.getContentPane().add(lblDeck);
		
		lblPile = new JLabel("pile");
		lblPile.setIcon(new ImageIcon("src\\images\\Trickdown.png"));
		lblPile.setBounds(671, 13, 200, 140);
		frame.getContentPane().add(lblPile);
		
		Image cc=Toolkit.getDefaultToolkit().getImage("src\\images\\cc.png");
		this.cc=new ImageIcon(cc);
		Image cl=Toolkit.getDefaultToolkit().getImage("src\\images\\cl.png");
		this.cl=new ImageIcon(cl);
		Image hc=Toolkit.getDefaultToolkit().getImage("src\\images\\hc.png");
		this.hc=new ImageIcon(hc);
		Image hcl=Toolkit.getDefaultToolkit().getImage("src\\images\\hcl.png");
		this.hcl=new ImageIcon(hcl);
		Image ho=Toolkit.getDefaultToolkit().getImage("src\\images\\ho.png");
		this.ho=new ImageIcon(ho);
		Image hr=Toolkit.getDefaultToolkit().getImage("src\\images\\hr.png");
		this.hr=new ImageIcon(hr);
		Image hro=Toolkit.getDefaultToolkit().getImage("src\\images\\hro.png");
		this.hro=new ImageIcon(hro);
		Image ro=Toolkit.getDefaultToolkit().getImage("src\\images\\ro.png");
		this.ro=new ImageIcon(ro);
		Image rol=Toolkit.getDefaultToolkit().getImage("src\\images\\rol.png");
		this.rol=new ImageIcon(rol);
		Image rocl=Toolkit.getDefaultToolkit().getImage("src\\images\\rocl.png");
		this.rocl=new ImageIcon(rocl);
		Image C1=Toolkit.getDefaultToolkit().getImage("src\\images\\C1.png");
		this.C1=new ImageIcon(C1);
		Image L=Toolkit.getDefaultToolkit().getImage("src\\images\\L.png");
		this.L=new ImageIcon(L);
		Image H=Toolkit.getDefaultToolkit().getImage("src\\images\\H.png");
		this.H=new ImageIcon(H);
		Image R=Toolkit.getDefaultToolkit().getImage("src\\images\\R.png");
		this.R=new ImageIcon(R);
		Image O=Toolkit.getDefaultToolkit().getImage("src\\images\\O.png");
		this.O=new ImageIcon(O);
		Image white=Toolkit.getDefaultToolkit().getImage("src\\images\\white.png");
		this.white=new ImageIcon(white);
		
		
		leftturn = new JTextField();
		leftturn.setHorizontalAlignment(SwingConstants.CENTER);
		leftturn.setSelectedTextColor(new Color(250, 128, 114));
		leftturn.setText("left player:");
		leftturn.setBounds(0, 366, 480, 24);
		frame.getContentPane().add(leftturn);
		leftturn.setColumns(10);
		
		rightturn = new JTextField();
		rightturn.setHorizontalAlignment(SwingConstants.CENTER);
		rightturn.setText("right player:");
		rightturn.setBounds(777, 366, 492, 24);
		frame.getContentPane().add(rightturn);
		rightturn.setColumns(10);
		
		Maintext = new JTextField();
		Maintext.setFont(new Font("Arial", Font.PLAIN, 20));
		Maintext.setHorizontalAlignment(SwingConstants.CENTER);
		Maintext.setText("gamestart");
		Maintext.setBounds(197, 571, 886, 35);
		frame.getContentPane().add(Maintext);
		Maintext.setColumns(15);
		
		leftProp = new JTextField();
		leftProp.setHorizontalAlignment(SwingConstants.CENTER);
		leftProp.setText("carrot");
		leftProp.setBounds(435, 496, 45, 24);
		frame.getContentPane().add(leftProp);
		leftProp.setColumns(10);
		
		rightProp = new JTextField();
		rightProp.setHorizontalAlignment(SwingConstants.CENTER);
		rightProp.setText("hat");
		rightProp.setBounds(777, 496, 45, 24);
		frame.getContentPane().add(rightProp);
		rightProp.setColumns(10);
		
		this.clic0 = new JButton("0");
		clic0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setValue(0);
				setChange(true);
			}
		});
		clic0.setBounds(345, 613, 113, 27);
		frame.getContentPane().add(clic0);
		
		clic2 = new JButton("2");
		clic2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setValue(2);
				setChange(true);
			}
		});
		clic2.setBounds(595, 613, 113, 27);
		frame.getContentPane().add(clic2);
		
		clic1 = new JButton("1");
		clic1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setValue(1);
				setChange(true);
			}
		});
		clic1.setBounds(468, 613, 113, 27);
		frame.getContentPane().add(clic1);
		
		txtScorep = new JTextField();
		txtScorep.setHorizontalAlignment(SwingConstants.CENTER);
		txtScorep.setName("scorep3");
		txtScorep.setText("score-p3");
		txtScorep.setBounds(267, 403, 57, 24);
		frame.getContentPane().add(txtScorep);
		txtScorep.setColumns(10);
		
		txtScorep_1 = new JTextField();
		txtScorep_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtScorep_1.setName("scorep1");
		txtScorep_1.setText("score-p1");
		txtScorep_1.setBounds(410, 542, 57, 24);
		frame.getContentPane().add(txtScorep_1);
		txtScorep_1.setColumns(10);
		
		txtScorep_2 = new JTextField();
		txtScorep_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtScorep_2.setName("scorep1");
		txtScorep_2.setText("score-p2");
		txtScorep_2.setBounds(1180, 403, 57, 24);
		frame.getContentPane().add(txtScorep_2);
		txtScorep_2.setColumns(10);
		
		txtNamep = new JTextField();
		txtNamep.setHorizontalAlignment(SwingConstants.CENTER);
		txtNamep.setName("namep3");
		txtNamep.setText("name-p3");
		txtNamep.setBounds(30, 403, 153, 24);
		frame.getContentPane().add(txtNamep);
		txtNamep.setColumns(10);
		
		txtNamep_1 = new JTextField();
		txtNamep_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtNamep_1.setName("namep2");
		txtNamep_1.setText("name-p2");
		txtNamep_1.setBounds(943, 403, 152, 24);
		frame.getContentPane().add(txtNamep_1);
		txtNamep_1.setColumns(10);
		
		txtAgep = new JTextField();
		txtAgep.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgep.setName("agep3");
		txtAgep.setText("age-p3");
		txtAgep.setBounds(197, 403, 57, 24);
		frame.getContentPane().add(txtAgep);
		txtAgep.setColumns(10);
		
		txtAgep_1 = new JTextField();
		txtAgep_1.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgep_1.setName("age-p2");
		txtAgep_1.setText("age-p2");
		txtAgep_1.setBounds(1109, 403, 57, 24);
		frame.getContentPane().add(txtAgep_1);
		txtAgep_1.setColumns(10);
		
		txtthprop = new JTextField();
		txtthprop.setHorizontalAlignment(SwingConstants.CENTER);
		txtthprop.setName("7th");
		txtthprop.setText("7th-prop");
		txtthprop.setBounds(706, 242, 57, 24);
		frame.getContentPane().add(txtthprop);
		txtthprop.setColumns(10);
		
		txtNamep_2 = new JTextField();
		txtNamep_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtNamep_2.setName("namep1");
		txtNamep_2.setText("name-p1");
		txtNamep_2.setBounds(197, 542, 140, 24);
		frame.getContentPane().add(txtNamep_2);
		txtNamep_2.setColumns(10);
		
		txtAgep_2 = new JTextField();
		txtAgep_2.setHorizontalAlignment(SwingConstants.CENTER);
		txtAgep_2.setName("agep1");
		txtAgep_2.setText("age-p1");
		txtAgep_2.setBounds(345, 542, 57, 24);
		frame.getContentPane().add(txtAgep_2);
		txtAgep_2.setColumns(10);
		
		txtResteTrickIn = new JTextField();
		txtResteTrickIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtResteTrickIn.setName("nbtrick");
		txtResteTrickIn.setText("Remaining Trick in Deck: ");
		txtResteTrickIn.setBounds(397, 154, 153, 24);
		frame.getContentPane().add(txtResteTrickIn);
		txtResteTrickIn.setColumns(10);
		
		txtPilecurrentTrick = new JTextField();
		txtPilecurrentTrick.setHorizontalAlignment(SwingConstants.CENTER);
		txtPilecurrentTrick.setText("Pile--current Trick!");
		txtPilecurrentTrick.setBounds(758, 154, 113, 24);
		frame.getContentPane().add(txtPilecurrentTrick);
		txtPilecurrentTrick.setColumns(10);
		
		JLabel label = new JLabel(".");
		label.setBounds(1097, 13, 2, 1);
		frame.getContentPane().add(label);
		
		enterField = new JTextField();
		enterField.setBounds(722, 614, 109, 24);
		frame.getContentPane().add(enterField);
		enterField.setColumns(10);
		
		btnEnter = new JButton("Enter");
		btnEnter.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String s = enterField.getText();
				setString(s);
				setChange(true);
				setStringChange();
			}
		});
		btnEnter.setBounds(845, 613, 73, 27);
		frame.getContentPane().add(btnEnter);
	}
	public void setTXT(String p,String k,String c,String l,String r,String sp,String sr,String sl,String np,String nr,String nl,String ap,String ar,String al,String nb) {
		this.Maintext.setText(p);
		this.leftProp.setText(k);
		this.rightProp.setText(c);
		this.leftturn.setText(l);
		this.rightturn.setText(r);
		this.txtScorep_1.setText(sp);
		this.txtScorep_2.setText(sr);
		this.txtScorep.setText(sl);
		this.txtNamep_2.setText(np);
		this.txtNamep_1.setText(nr);
		this.txtNamep.setText(nl);
		this.txtAgep_2.setText(ap);
		this.txtAgep_1.setText(ar);
		this.txtAgep.setText(al);
		this.txtResteTrickIn.setText(nb);
	}
	public void updateTrick(Trick t,JLabel jl) {
		String name=t.getname().toString();
		switch(name) {
		case "cc":
			jl.setIcon(cc);break;
		case "cl":
			jl.setIcon(cl);break;
		case "hc":
			jl.setIcon(hc);break;
		case "hcl":
			jl.setIcon(hcl);break;
		case "ho":
			jl.setIcon(ho);break;
		case "hro":
			jl.setIcon(hro);break;
		case "hr":
			jl.setIcon(hr);break;
		case "ro":
			jl.setIcon(ro);break;
		case "rocl":
			jl.setIcon(rocl);break;
		case "rol":
			jl.setIcon(rol);break;
		default:
			break;
		}
	}
	
	public void updateProp(Prop p,JLabel jl) {
		int id = p.getid();
		if(p.flipstat()==true) {
		switch(id) {
		case 1:
		jl.setIcon(C1);break;
		case 10:
			jl.setIcon(L);break;
		case 100:
			jl.setIcon(H);break;
		case 1000:
			jl.setIcon(R);break;
		case 10000:
			jl.setIcon(O);break;
		default:
			break;
		}
		}
		else
			jl.setIcon(new ImageIcon("src\\images\\Propdown.jpg"));
	}
	public void update(Game mygame,int currentP) {
		Prop propl=mygame.getlist().get(currentP).getP('l');
		Prop prop2=mygame.getlist().get(currentP).getP('r');
		String namep1=mygame.getlist().get(currentP).getP('l').toString();
		String namep2=mygame.getlist().get(currentP).getP('r').toString();
		Prop prop3=mygame.getlist().get(currentP+1).getP('l');
		Prop prop4=mygame.getlist().get(currentP+1).getP('r');
		Prop prop5=mygame.getlist().get(currentP+2).getP('l');
		Prop prop6=mygame.getlist().get(currentP+2).getP('r');
		Prop prop7=mygame.get7th();

		int scorep=mygame.getlist().get(currentP).getscore();
		int scoreright=mygame.getlist().get(currentP+1).getscore();
		int scoreleft=mygame.getlist().get(currentP+2).getscore();
		String nameplayer=mygame.getlist().get(currentP).getname();
		String nameright=mygame.getlist().get(currentP+1).getname();
		String nameleft=mygame.getlist().get(currentP+2).getname();
		int ageplayer=mygame.getlist().get(currentP).getage();
		int ageright=mygame.getlist().get(currentP+1).getage();
		int ageleft=mygame.getlist().get(currentP+2).getage();
		String maintext = mygame.getlist().get(currentP).getinfo();
		String righttext=mygame.getlist().get(currentP+1).getinfo();
		String lefttext=mygame.getlist().get(currentP+2).getinfo();
		int nbdeck=mygame.getdeck().getnb(); 
		
		this.setTXT(maintext, namep1, namep2, lefttext, righttext,"score: "+scorep,"score: "+scoreright,"score: "+scoreleft,"name: "+nameplayer,"name: "+nameright,"name: "+nameleft,"age: "+ageplayer,"age: "+ageright,"age: "+ageleft,"Remaining Trick in Deck: "+nbdeck);
		this.updateProp(propl, lblPll);
		this.updateProp(prop2, lblPrr);
		this.updateProp(prop3, lblPlll);
		this.updateProp(prop4, lblPrrr);
		this.updateProp(prop5, lblPl);
		this.updateProp(prop6, lblPr);
		this.updateProp(prop7, lblth);
		Trick pilefirst = mygame.getpile().topTrick();
		this.updateTrick(pilefirst, lblPile);
		if(nbdeck==0) {
			lblDeck.setIcon(white);
		}
		
		
	}
	void addClic1Listener(ActionListener listenr1) {
		clic1.addActionListener(listenr1);
	}
	void addClic2Listener(ActionListener listenr1) {
		clic2.addActionListener(listenr1);
	}
	void addClic0Listener(ActionListener listenr1) {
		clic0.addActionListener(listenr1);
	}
	public int getIntAction() {
		while(this.haschange==false) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(this.stringChange==false) {
		this.setChange(false);
		return this.value;
		}
		else {
			int a=0;
			try {

			     a = Integer.parseInt(this.readed);

			} catch (NumberFormatException e) {

			    e.printStackTrace();

			}
			this.stringChange=false;
			return a;
		}
	}
	public void setChange(boolean b) {
		this.haschange=b;
	}
	public void setValue(int i) {
		this.value=i;
	}
	public void setMainText(String s) {
		this.Maintext.setText(s);
	}
	public void setString(String s) {
		this.readed=s;
	}
	public String getStringAction() {
		while(this.haschange==false) {
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		this.setChange(false);
		return this.readed;
	}
	public void setStringChange() {
		this.stringChange=true;
	}
}