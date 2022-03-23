package PraxisphaseCalcGradle;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
//Author: Markus Schattauer
public class GuiTaschenrechner extends JFrame implements ActionListener{
	
	private JFrame root;
	public JLabel rechnungslabel,ergebnislabel,filler,filler2,filler3;
	private JButton c,erg,but9,but8,but7,but6,but5,but4,but3,but2,but1,but0,butneg,butkom,butplus,butminus,butmal,butgeteilt;
	private String numb;
	private ArrayList<String> rechnung;
	public Rechnungen re;
	
	public static void main(String[] args) {
		GuiTaschenrechner gt= new GuiTaschenrechner();
		
	}
	
	public GuiTaschenrechner(){
		root=new JFrame();
		root.setLayout(new GridLayout(0, 4));
		numb="";
		rechnung=new ArrayList<String>(10);
		rechnungslabel = new JLabel("");
		
		ergebnislabel= new JLabel("");
		
		filler=new JLabel("");
		filler2=new JLabel("");
		filler3=new JLabel("");
		
		c= new JButton("C");
		c.addActionListener(this);
		c.setActionCommand("c");
		
		erg= new JButton("=");
		erg.addActionListener(this);
		erg.setActionCommand("erg");
		
		but9=new JButton("9");
		but9.addActionListener(this);
		but9.setActionCommand("9");
		
		but8=new JButton("8");
		but8.addActionListener(this);
		but8.setActionCommand("8");
		
		but7=new JButton("7");		
		but7.addActionListener(this);
		but7.setActionCommand("7");
		
		but6=new JButton("6");
		but6.addActionListener(this);
		but6.setActionCommand("6");
		
		but5=new JButton("5");
		but5.addActionListener(this);
		but5.setActionCommand("5");
		
		but4=new JButton("4");
		but4.addActionListener(this);
		but4.setActionCommand("4");
		
		but3=new JButton("3");
		but3.addActionListener(this);
		but3.setActionCommand("3");
		
		but2=new JButton("2");
		but2.addActionListener(this);
		but2.setActionCommand("2");
		
		but1=new JButton("1");
		but1.addActionListener(this);
		but1.setActionCommand("1");
		
		butneg=new JButton("-");
		butneg.addActionListener(this);
		butneg.setActionCommand("neg");
		
		but0=new JButton("0");
		but0.addActionListener(this);
		but0.setActionCommand("0");
		
		butkom=new JButton(",");
		butkom.addActionListener(this);
		butkom.setActionCommand(".");
		
		butplus=new JButton("+");
		butplus.addActionListener(this);
		butplus.setActionCommand("+");
		
		butminus=new JButton("-");
		butminus.addActionListener(this);
		butminus.setActionCommand("-");
		
		butmal=new JButton("*");
		butmal.addActionListener(this);
		butmal.setActionCommand("*");
		
		butgeteilt=new JButton("/");
		butgeteilt.addActionListener(this);
		butgeteilt.setActionCommand("/");
		
		root.add(rechnungslabel);
		root.add(filler);
		root.add(ergebnislabel);
		root.add(filler3);
		root.add(c);
		root.add(filler2);
		root.add(erg);
		root.add(butplus);
		root.add(but9);
		root.add(but8);
		root.add(but7);
		root.add(butminus);
		root.add(but6);
		root.add(but5);
		root.add(but4);
		root.add(butmal);
		root.add(but3);
		root.add(but2);
		root.add(but1);
		root.add(butgeteilt);
		root.add(butneg);
		root.add(but0);
		root.add(butkom);
		
		
		root.setSize(400,500);
		root.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		double numbde=0;
		double numbdz=0;
		
		try {
			if (command.contentEquals("erg")) {
				Rechnungen re= new Rechnungen();
				rechnung.add(numb);
				numb="";
				double erg=0;
				int m=rechnung.indexOf("*");
				int d=rechnung.indexOf("/");
				while (m!=-1 || d!=-1) {
					if (m!=-1 && d!=-1) {
						if (m<d) {
							numbde=Double.parseDouble(rechnung.get(m-1));
							numbdz=Double.parseDouble(rechnung.get(m+1));
//							erg=numbde*numbdz;
							erg=re.calculate(numbde,numbdz,"*");
							rechnung.set(m-1, Double.toString(erg));
							rechnung.remove(m+1);
							rechnung.remove(m);
												}
						else {
							numbde=Double.parseDouble(rechnung.get(d-1));
							numbdz=Double.parseDouble(rechnung.get(d+1));
//							erg=numbde/numbdz;
							erg=re.calculate(numbde,numbdz,"/");
							rechnung.set(d-1, Double.toString(erg));
							rechnung.remove(d+1);
							rechnung.remove(d);
						}
					}
					else {
						if (m!=-1) {
							numbde=Double.parseDouble(rechnung.get(m-1));
							numbdz=Double.parseDouble(rechnung.get(m+1));
//							erg=numbde*numbdz;
							erg=re.calculate(numbde,numbdz,"*");
							rechnung.set(m-1, Double.toString(erg));
							rechnung.remove(m+1);
							rechnung.remove(m);
						}
						else {
							numbde=Double.parseDouble(rechnung.get(d-1));
							numbdz=Double.parseDouble(rechnung.get(d+1));
//							erg=numbde/numbdz;
							erg=re.calculate(numbde,numbdz,"/");
							rechnung.set(d-1, Double.toString(erg));
							rechnung.remove(d+1);
							rechnung.remove(d);
						}
					}
					m=rechnung.indexOf("*");
					d=rechnung.indexOf("/");
				}

				// + und -
				int a=rechnung.indexOf("+");
				int s=rechnung.indexOf("-");
				while (a!=-1 || s!=-1) {
					if (a>s) {
						numbde=Double.parseDouble(rechnung.get(a-1));
						numbdz=Double.parseDouble(rechnung.get(a+1));
//						erg=numbde+numbdz;
						erg=re.calculate(numbde,numbdz,"+");
						rechnung.set(a-1, Double.toString(erg));
						rechnung.remove(a+1);
						rechnung.remove(a);
					}
					else {
						numbde=Double.parseDouble(rechnung.get(s-1));
						numbdz=Double.parseDouble(rechnung.get(s+1));
//						erg=numbde-numbdz;
						erg=re.calculate(numbde,numbdz,"-");
						rechnung.set(s-1, Double.toString(erg));
						rechnung.remove(s+1);
						rechnung.remove(s);
					}
					a=rechnung.indexOf("+");
					s=rechnung.indexOf("-");
				}
				ergebnislabel.setText(rechnung.get(0));
				rechnungslabel.setText("");
				rechnung.clear();
				rechnung.add(Double.toString(erg));
				
			}
			else if (command.contentEquals("c")) {
				numb="";
				numbde=0;
				numbdz=0;
				rechnung.clear();
				rechnungslabel.setText("");
				ergebnislabel.setText("");
			}
			else if (command.contentEquals("+")||command.contentEquals("-")||command.contentEquals("*")||command.contentEquals("/")) {
				if (!numb.equals("")) {
					rechnung.add(numb);
				}
				rechnung.add(command);
				numb="";
				rechnungslabel.setText(rechnungslabel.getText()+command);
			}
			else {
				if (command.contentEquals("neg")) {
					numb=numb+"-";
					rechnungslabel.setText(rechnungslabel.getText()+"-");
				}
				else {
				numb=numb+command;
				rechnungslabel.setText(rechnungslabel.getText()+command);
				}
				
			}
			
		}
		catch (Exception ex) {
			JOptionPane.showMessageDialog(null, "Fehler");
		}
		
	} 

}
