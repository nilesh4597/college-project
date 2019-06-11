
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class InitialPage extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p[] = new JPanel[10];
	JButton b[] = new JButton[10];
	JPanel p1,p2,p3,p4;
	JButton b1;
	Options o = new Options();
	public InitialPage() throws IOException
	{
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		setTitle("College GYM Management System");
		p[0] = new JPanel();
		p[0].setLayout(new BorderLayout());
		//GridBagConstraints c = new GridBagConstraints();
		p[1] = new JPanel();
		p[1].setLayout(new GridLayout(13,1));
		p[2]= new JPanel();
		p[2].setLayout(new BorderLayout());
		p[3] = new JPanel();
		p[4] = new JPanel();
		p[0].setBackground(new Color(0, 0, 139));
		p[0].add(p[1],BorderLayout.WEST);
		p[1].setPreferredSize(new Dimension(350,200));
		p[2].add(p[3],BorderLayout.NORTH);
		p[3].setPreferredSize(new Dimension(1000,50));
		p[3].setLayout(new GridLayout(1,3));
		p[2].add(p[4],BorderLayout.CENTER);
		p[0].add(p[2],BorderLayout.CENTER);
		b[0] = new JButton("Previous");
		b[1] = new JButton("Next");
		b[2] = new JButton("Home_Page");
		b[2].addActionListener(this);
		b[3] = new JButton("Member Options");
		b[3].addActionListener(this);
		b[4] = new JButton("Trainer Options");
		b[4].addActionListener(this);
		b[5] = new JButton("Machinery Options");
		b[5].addActionListener(this);
		//b[7] = new JButton("Settings");
		//b[7].addActionListener(this);
		b[8] = new JButton("Report Generation");
		b[8].addActionListener(this);
		b[9] = new JButton("Exit");
		b[9].addActionListener(this);
		b[6] = new JButton("Routines");
		b[6].addActionListener(this);
		p1 = new JPanel();
		p1.setLayout(new FlowLayout());
		p1.setOpaque(false);
		p3 = new JPanel();
		p3.setLayout(new FlowLayout());
		p3.setOpaque(false);
		b1 = new JButton("Account");
		b1.setForeground(Color.WHITE);
		b1.setBackground(new Color(0,0,0,20));
		p2 = new JPanel(); 
		p2.setLayout(new BorderLayout());
		p2.setOpaque(false);
		p4 = new JPanel(); 
		p4.setLayout(new BorderLayout());
		p4.setOpaque(false);
		for(int i=0;i<2;i++)
		{
			b[i].setBackground(new Color(0,0,0,45));
			b[i].setForeground(Color.WHITE);
		//p3.add(b[i]);
		}
		for(int i=3;i<6;i++)
		{
			b[i].setBackground(new Color(0,0,0,45));
			b[i].setForeground(Color.WHITE);
			p[1].add(b[i]);
		}
		for(int i=8;i<10;i++)
		{
			b[i].setBackground(new Color(0,0,0,45));
			b[i].setForeground(Color.WHITE);
		}
		p[1].add(b[8]);
		p[1].add(b[9]);
		b[2].setBackground(new Color(0,0,0,45));
		b[2].setForeground(Color.WHITE);
		p1.add(b[2]);
		//p2.add(b1,BorderLayout.CENTER);
		p[3].add(p1);
		p[3].add(p3);
		p[3].add(p4);
		p[3].add(p2);
		/*c.fill = GridBagConstraints.HORIZONTAL;  
		c.gridx=0;
		c.gridy=0;
		c.gridheight=100;
		c.gridwidth=20;
		c.ipady=1000;
		c.ipadx=200;
		p[0].add(p[1],c);
		c.fill = GridBagConstraints.HORIZONTAL; 
		c.gridx=20;
		c.gridy=0;
		c.gridheight=100;
		c.ipady=1000;
		c.gridwidth=80;
		c.ipadx=500;
		p[0].add(p[2],c);*/
		setSize(2000,2000);
		add(p[0],BorderLayout.CENTER);
		setSize(2000,2000);
		BufferedImage image = ImageIO.read(new File("/home/omkar/Downloads/TheMacauRoosevelt_TheGym.jpg"));
	    JLabel label = new JLabel(new ImageIcon(image));
	    setSize(2000,2000);
		p[4].add(label,BorderLayout.CENTER); 
		setSize(2000,2000);
	    //p[0].setBackground(Color.cyan);
		//p[0].setBackground(new Color(0,0,0,130));
		p[1].setBackground(new Color(0,0,0,30));
		p[2].setBackground(new Color(0,0,0,30));
		p[3].setBackground(new Color(0,0,0,100));
		p[4].setBackground(new Color(0,0,0,70));
		setSize(2000,2000);
	}

	public static void main(String[] args) throws IOException {
		new InitialPage();

	}
	public void actionPerformed(ActionEvent e) 
	{
		if(e.getSource()==b[9])
		{
			int confirmed = JOptionPane.showConfirmDialog(null, "Exit Program?","EXIT",JOptionPane.YES_NO_OPTION);
	        if(confirmed == JOptionPane.YES_OPTION)
	        {
	            dispose();
	        }
		}
		if(e.getSource()==b[3])
		{
			//p[2].removeAll();
			p[2].remove(o.r);
			setSize(2000,2000);
			p[2].remove(p[4]);
			setSize(2000,2000);
			p[2].remove(o.t);
			setSize(2000,2000);
			p[2].remove(o.me);
			setSize(2000,2000);
			p[2].remove(o.rg);
			setSize(2000,2000);
			p[2].remove(o.s);
			setSize(2000,2000);
			p[2].add(o.m,BorderLayout.CENTER);
			//System.out.println("Hi");
			setSize(2000,2000);
		}
		else if(e.getSource()==b[2])
		{
			setSize(2000,2000);
			p[2].remove(o.t);
			setSize(2000,2000);
			p[2].remove(o.r);
			setSize(2000,2000);
			p[2].remove(o.m);
			setSize(2000,2000);
			p[2].remove(o.me);
			setSize(2000,2000);
			p[2].remove(o.rg);
			setSize(2000,2000);
			p[2].remove(o.s);
			setSize(2000,2000);
			p[2].add(p[4],BorderLayout.CENTER);
			setSize(2000,2000);
		}
		else if(e.getSource()==b[4])
		{
			setSize(2000,2000);
			p[2].remove(p[4]);
			setSize(2000,2000);
			p[2].remove(o.r);
			setSize(2000,2000);
			p[2].remove(o.m);
			setSize(2000,2000);
			p[2].remove(o.me);
			setSize(2000,2000);
			p[2].remove(o.rg);
			setSize(2000,2000);
			p[2].remove(o.s);
			setSize(2000,2000);
			p[2].add(o.t,BorderLayout.CENTER);
			setSize(2000,2000);
		}
		else if(e.getSource()==b[5])
		{
			setSize(2000,2000);
			p[2].remove(p[4]);
			setSize(2000,2000);
			p[2].remove(o.r);
			setSize(2000,2000);
			p[2].remove(o.m);
			setSize(2000,2000);
			p[2].remove(o.t);
			setSize(2000,2000);
			p[2].remove(o.rg);
			setSize(2000,2000);
			p[2].remove(o.s);
			setSize(2000,2000);
			p[2].add(o.me,BorderLayout.CENTER);
			setSize(2000,2000);
		}
		else if(e.getSource()==b[6])
		{
			setSize(2000,2000);
			p[2].remove(p[4]);
			setSize(2000,2000);
			p[2].remove(o.me);
			setSize(2000,2000);
			p[2].remove(o.m);
			setSize(2000,2000);
			p[2].remove(o.t);
			setSize(2000,2000);
			p[2].remove(o.rg);
			setSize(2000,2000);
			p[2].remove(o.s);
			setSize(2000,2000);
			p[2].add(o.r,BorderLayout.CENTER);
			setSize(2000,2000);
		}
		else if(e.getSource()==b[8])
		{
			setSize(2000,2000);
			p[2].remove(p[4]);
			setSize(2000,2000);
			p[2].remove(o.me);
			setSize(2000,2000);
			p[2].remove(o.m);
			setSize(2000,2000);
			p[2].remove(o.t);
			setSize(2000,2000);
			p[2].remove(o.r);
			setSize(2000,2000);
			p[2].remove(o.s);
			setSize(2000,2000);
			p[2].add(o.rg,BorderLayout.CENTER);
			setSize(2000,2000);
		}
		//if(e.getSource()==b[7])
		//{
			//setSize(2000,2000);
			//p[2].remove(p[4]);
			//setSize(2000,2000);
			//p[2].remove(o.me);
			//setSize(2000,2000);
			//p[2].remove(o.m);
			//setSize(2000,2000);
			//p[2].remove(o.t);
			//setSize(2000,2000);
			//p[2].remove(o.r);
			//setSize(2000,2000);
			//p[2].remove(o.rg);
			//setSize(2000,2000);
			//p[2].add(o.s,BorderLayout.CENTER);
			//setSize(2000,2000);
		//}
		
	}

}
class Options extends JPanel
{
	Member m = new Member();
	Trainer t = new Trainer();
	Machinery me = new Machinery();
	Routines r = new Routines();
	ReportGeneration rg = new ReportGeneration();
	Settings s = new Settings();
}
