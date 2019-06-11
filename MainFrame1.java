
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
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
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class MainFrame1 extends JFrame implements ActionListener
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JPanel p1,p2,p3,p4,p5,p6,p7,p8,p9,p10,p11,p12,p13;
	JPanel p[] = new JPanel[10];
	JTextField f1,f2,f3,f4,f5,f6,f7,f8;
	JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
	JButton b1,b2,b3,b4,b5,b6;
	public MainFrame1() throws IOException 
	{
		//setSize(2000,2000);
		setTitle("College GYM Management System");
		
		GridBagConstraints c = new GridBagConstraints();
		p1 = new JPanel();
		p2 = new JPanel();
		p3 = new JPanel();
		p9 = new JPanel();
		p10 = new JPanel();
		p12 = new JPanel();
		p12.setLayout(new GridLayout(1,1,15,0));
		p13 = new JPanel();
		p13.setLayout(new BorderLayout());
		p10.setLayout(new FlowLayout());
		BufferedImage image1 = ImageIO.read(new File("/home/omkar/Downloads/INDIRALOGO.gif"));
	    JLabel label1 = new JLabel(new ImageIcon(image1));
		p10.add(label1);  
		p10.setBackground(new Color(0,0,0,25));
		p11 = new JPanel();
		p11.setLayout(new GridLayout(9,1,5,10));
		p11.setBackground(new Color(0,0,0,25));
		p3.setBackground(Color.blue);
		p4 = new JPanel();
		p6 = new JPanel();
		p7 = new JPanel();
		p8 = new JPanel();
		p8.setLayout(new BorderLayout());
		p7.setLayout(new FlowLayout());
		p7.setBackground(new Color(0,0,0,65));
		Font f = new Font("Serif", Font.BOLD, 20); 
		f1 = new JTextField(20);
		f1.setFont(f);
		f2 = new JPasswordField(20);
		f2.setFont(f);
		f3 = new JTextField(20);
		f3.setFont(f);
		f4 = new JTextField(20);
		f4.setFont(f);
		f5 = new JTextField(20);
		f5.setFont(f);
		f6 = new JTextField(20);
		f6.setFont(f);
		f7 = new JTextField(20);
		f7.setFont(f);
		f8 = new JTextField(20);
		f8.setFont(f);
		setLayout(new BorderLayout());
		p9.setLayout(new GridBagLayout());
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		b1 = new JButton("Signin");
		b1.addActionListener(this);
		b1.setBackground(new Color(128,128,128));
		b1.setForeground(Color.white);
		b2 = new JButton("Registration");
		b2.addActionListener(this);
		b2.setForeground(Color.white);
		b2.setBackground(new Color(128,128,128));
		b4 = new JButton("Submit");
		b4.setFont(f);
		//b2.addActionListener(this);
		b4.setForeground(Color.white);
		b4.setBackground(new Color(128,128,128));
		b5 = new JButton("Help"); 
		b5.setForeground(Color.blue);
		b5.setBackground(new Color(0,0,0,65));
		p1.setLayout(new BorderLayout());
		p2.setLayout(new BorderLayout());
		p3.setLayout(new GridLayout(1,2,30,10));
		p3.setOpaque(false);
		//p3.add(b1);
		//p3.add(b2);
		p2.add(p3,BorderLayout.NORTH);
		p2.add(p4,BorderLayout.CENTER);
		p4.setLayout(new FlowLayout());
		//l3 = new JLabel("College GYM Management System");
		//p7.add(l3);
		//p1.add(p7,BorderLayout.NORTH);
		l1 = new JLabel("Login ID");
		l1.setFont(new Font(l1.getFont().getName(), l1.getFont().getStyle(), 20));
		l1.setForeground(Color.white);
		l2 = new JLabel("Password");
		l2.setFont(new Font(l2.getFont().getName(), l2.getFont().getStyle(), 20));
		l2.setForeground(Color.white);
		l4 = new JLabel("Name");
		l4.setFont(new Font(l2.getFont().getName(), l2.getFont().getStyle(), 20));
		l4.setForeground(Color.white);
		l5 = new JLabel("Mobile NO");
		l5.setFont(new Font(l2.getFont().getName(), l2.getFont().getStyle(), 20));
		l5.setForeground(Color.white);
		l6 = new JLabel("Login ID");
		l6.setFont(new Font(l2.getFont().getName(), l2.getFont().getStyle(), 20));
		l6.setForeground(Color.white);
		l7 = new JLabel("Password");
		l7.setFont(new Font(l2.getFont().getName(), l2.getFont().getStyle(), 20));
		l7.setForeground(Color.white);
		l8 = new JLabel("Verification Code");
		l8.setFont(new Font(l2.getFont().getName(), l2.getFont().getStyle(), 20));
		l8.setForeground(Color.white);
		l9 = new JLabel("Email Id");
		l9.setFont(new Font(l2.getFont().getName(), l2.getFont().getStyle(), 20));
		l9.setForeground(Color.white);
		b3 = new JButton("Login");
		b3.setForeground(Color.white);
		b3.setBackground(new Color(128,128,128));
		b3.setFont(f);
		b3.addActionListener(this);
		p6.setLayout(new GridLayout(1,1,15,0));
		for(int i=0;i<2;i++)
		{
			p[i] = new JPanel(new GridBagLayout());
			//p[i].setBackground(Color.blue);
			p[i].setOpaque(false);
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=8;
		c.ipady=8;
		c.gridwidth=4;
		p[0].add(l1,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.ipadx=8;
		c.ipady=18;
		p[0].add(f1,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		c.ipadx=8;
		c.ipady=8;
		p[1].add(l2,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		c.ipadx=8;
		c.ipady=18;
		p[1].add(f2,c);
		p6.setBackground(Color.blue);
		p6.setOpaque(false);
		//p6.add(p10);
		p6.add(b3);
		//p6.add(p11);
		p5 = new JPanel();
		p4.setBackground(Color.blue);
		p4.setOpaque(false);
		p5.setBackground(Color.blue);
		p5.setOpaque(false);
		p5.setLayout(new GridLayout(3,3,5,20));
		for(int i=0;i<2;i++)
		{
			p5.add(p[i]);
			
		}
		p5.add(p6);
		p4.add(p5);
		for(int i=2;i<9;i++)
		{
			p[i] = new JPanel(new GridBagLayout());
			p[i].setOpaque(false);
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		p[2].add(l4,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.ipadx=4;
		c.ipady=8;
		p[2].add(f3,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		c.ipadx=4;
		c.ipady=8;
		p[3].add(l5,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		c.ipadx=4;
		c.ipady=8;
		p[3].add(f4,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=4;
		c.ipadx=4;
		c.ipady=8;
		p[4].add(l9,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=5;
		c.ipadx=4;
		c.ipady=8;
		p[4].add(f8,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=6;
		c.ipadx=4;
		c.ipady=8;
		p[5].add(l6,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=7;
		c.ipadx=4;
		c.ipady=8;
		p[5].add(f5,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=8;
		c.ipadx=4;
		c.ipady=8;
		p[6].add(l6,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=9;
		c.ipadx=4;
		c.ipady=8;
		p[6].add(f5,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=10;
		c.ipadx=4;
		c.ipady=8;
		p[7].add(l7,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=11;
		c.ipadx=4;
		c.ipady=8;
		p[7].add(f6,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=12;
		c.ipadx=4;
		c.ipady=8;
		p[8].add(l8,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=13;
		c.ipadx=4;
		c.ipady=8;
		p[8].add(f7,c);
		for(int i=2;i<9;i++)
		{
			p11.add(p[i]);
			
		}
		p12.add(b4);
		p11.add(p12);
		p8.add(p10,BorderLayout.NORTH);
		p8.add(p2,BorderLayout.CENTER);
		p2.setBounds(20,25,550,550);
		p2.setBackground(new Color(0,0,0,25));
		//c.fill = GridBagConstraints.HORIZONTAL;
		//c.gridx=0;
		//c.gridy=0;
		//c.gridwidth=4;
		//p9.add(p7,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.ipadx=180;
		c.ipady=180;
		c.gridwidth=4;
		p9.add(p1,c);
		p9.setBackground(new Color(0,0,0,55));
		//add(p7,BorderLayout.NORTH);
		setSize(1800,1200);
		add(p9,BorderLayout.CENTER);
		//setSize(2000,2000);
		p1.add(p8,BorderLayout.CENTER);
		p8.setBackground(Color.cyan);
		p8.setBackground(new Color(0,0,0,15));
		BufferedImage image = ImageIO.read(new File("/home/omkar/Downloads/IMG_2585_2048x.JPG"));
	    JLabel label = new JLabel(new ImageIcon(image));
	    setSize(2000,2000);
		add(label,BorderLayout.CENTER); 
		setSize(2000,2000);		
		//p1.setBackground(Color.blue);
	}
	
	
	public void actionPerformed(ActionEvent e) {
	
		if(e.getSource()==b1)
		{
			p4.removeAll();
			//setSize(2000,2000);
			p4.removeAll();
			p4.add(p5);
			setSize(2000,2000);
		}
		else if(e.getSource()==b2)
		{
			//setSize(2000,2000);
			p4.removeAll();
			//setSize(2000,2000);
			p4.removeAll();
			p4.add(p11);
			setSize(2000,2000);
		}
		else if(e.getSource()==b3)
		{
			String name=f1.getText();
			String jpassword=String.valueOf(((JPasswordField) f2).getPassword());
			if(name.equals("root")&&jpassword.equals("root"))
			{
				try {
					setSize(2000,2000);
					InitialPage.main(new String[]{});
					setSize(2000,2000);
					this.dispose();
					//System.out.println(lid+" "+pass);
					setSize(2000,2000);
					
				}
				 catch (IOException e1) {
					e1.printStackTrace();
				}
				
		}
			else
			{
				JOptionPane.showMessageDialog(this, "Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
			}
	}
	}
	public static void main(String[] args) throws IOException {
		new MainFrame1();
		
	}
}
