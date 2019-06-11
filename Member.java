

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.sql.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
public class Member extends JPanel implements ActionListener{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	static String day,month,year;
	JLabel l[] = new JLabel[10];
	JTextField f[] = new JTextField[10];
	JLabel l1[] = new JLabel[10];
	JTextField f1[] = new JTextField[10];
	JButton b1,b2;
 	JTabbedPane tp,tp1;
	JPanel p1,p2,pb1,pb2,df,pd,df1,pd1,upb;
	JComboBox<String> list1,list2,d1,m1,y1,d2,m2,y2;
	JPanel p[] = new JPanel[6];
	JPanel p11[] = new JPanel[12];
	JPanel p12[] = new JPanel[11];
	JLabel lid = new JLabel("member Id");
	JTextField id = new JTextField();
	String s[] = {"Create Member","Search Member","Update Member","Delete Member"}; 
	String s1[] = {"Name:","Address:","Date of Birth","Mobile no:","Sex:","Course:","Weight:","Email id:","Height:","Age:"};
	String s2[] = {"Name:","Address:","Date of Birth","Mobile no:","Sex:","Department:","Weight:","Email id:","Height:","Age:"};
	int sid=0;
	Connection conn,conn1;
	PreparedStatement stmp,stmp1;
	Statement stmt;
	ResultSet rs,rs1,rs2;
	JLabel up[] = new JLabel[3];
	JTextField uf = new JTextField();
	JButton b = new JButton("Search");
	JPanel up1[] = new JPanel[6];
	JLabel em = new JLabel("Record Not Found");
	JLabel dl[] = new JLabel[3];
	JTextField d = new JTextField();
	JButton bd = new JButton("Delete");
	JPanel del[] = new JPanel[6];
	JLabel se[] = new JLabel[3];
	JTextField sr = new JTextField();
	JButton search = new JButton("Search");
	JPanel ser[] = new JPanel[6];
	JLabel src[] = new JLabel[15];
	JPanel sm[] = new JPanel[15];
	public Member()
	{
		Font fo = new Font("Serif", Font.BOLD, 20);
		em.setFont(fo);
		id.setFont(fo);
		lid.setFont(fo);
		up[0] = new JLabel("Enter Member id");
		 up[1] = new JLabel("or");
		 up[2] = new JLabel("Member name:");
		 for(int i=0;i<3;i++)
			{
				up[i].setFont(fo);
			}
			uf.setFont(fo);
			dl[0] = new JLabel("Enter Member id");
			 dl[1] = new JLabel("or");
			 dl[2] = new JLabel("Member name:");
			 for(int i=0;i<3;i++)
				{
					dl[i].setFont(fo);
				}
				d.setFont(fo);
				se[0] = new JLabel("Enter Member id");
				 se[1] = new JLabel("or");
				 se[2] = new JLabel("Member name:");
				 for(int i=0;i<3;i++)
					{
						se[i].setFont(fo);
					}
					sr.setFont(fo);
		pb1 = new JPanel();
		pb2 = new JPanel();
		upb = new JPanel();
		pb1.setLayout(new GridLayout(1,1,15,0));
		pb2.setLayout(new GridLayout(1,1,15,0));
		p1 = new JPanel();
		p1.setLayout(new GridLayout(8,1,5,10));
		p1.setBackground(new Color(137,207,240));
		p2 = new JPanel();
		p2.setLayout(new GridLayout(8,1,5,10));
		p2.setBackground(new Color(137,207,240));
		tp = new JTabbedPane();
		//tp.setForeground(Color.white);
		
		tp1 = new JTabbedPane();
		//tp1.setForeground(Color.white);
		tp.setFont(fo);
		tp1.setFont(fo);
		tp1.setBackground(Color.CYAN);
		tp1.add("Student",p1);
		tp1.add("Staff",p2);
		tp.setBackground(Color.CYAN);
		setLayout(new BorderLayout());
		df = new JPanel();
		df.setLayout(new FlowLayout());
		df.setBackground(new Color(0,0,0,25));
		pd = new JPanel();
		pd.setLayout(new GridLayout(2,1));
		pd.setBackground(new Color(0,0,0,25));
		df1 = new JPanel();
		df1.setLayout(new FlowLayout());
		df1.setBackground(new Color(0,0,0,25));
		pd1 = new JPanel();
		pd1.setLayout(new GridLayout(2,1));
		pd1.setBackground(new Color(0,0,0,25));
		list1 = new JComboBox<String>();
		list1.setBackground(new Color(0,0,0,35));
		list1.setFont(fo);
		list1.addItem("Male");
		list1.addItem("Female");
		list1.addItem("Other");
		list2 = new JComboBox<String>();
		list2.setBackground(new Color(0,0,0,35));
		list2.setFont(fo);
		list2.addItem("Male");
		list2.addItem("Female");
		list2.addItem("Other");
		//setBackground(new Color(0,0,25));
		d1 = new JComboBox<String>();
		d1.setBackground(new Color(0,0,0,35));
		d1.setFont(fo);
		
		d2 = new JComboBox<String>();
		d2.setBackground(new Color(0,0,0,35));
		d2.setFont(fo);
		d1.setName("Day");
		d2.setName("Day");
		d1.addItem("dd");
		d2.addItem("dd");
		for(int i=1;i<=31;i++)
		{
			d1.addItem(""+i);
			d2.addItem(""+i);
		}
		m1 = new JComboBox<String>();
		m1.setBackground(new Color(0,0,0,35));
		m1.setFont(fo);
		
		m2 = new JComboBox<String>();
		m2.setBackground(new Color(0,0,0,35));
		m2.setFont(fo);
		m1.setName("Month");
		m2.setName("Month");
		m1.addItem("mm");
		m2.addItem("mm");
		for(int i=1;i<=12;i++)
		{
			m1.addItem(""+i);
			m2.addItem(""+i);
		}
		y1 = new JComboBox<String>();
		y1.setBackground(new Color(0,0,0,5));
		y1.setFont(fo);
		
		y2 = new JComboBox<String>();
		y2.setBackground(new Color(0,0,0,5));
		y2.setFont(fo);
		y1.setName("Year");
		y2.setName("Year");
		y1.addItem("yyyy");
		y2.addItem("yyyy");
		for(int i=1985;i<=2008;i++)
		{
			y1.addItem(""+i);
			y2.addItem(""+i);
		}
		d1.addActionListener(this);
		m1.addActionListener(this);
		y1.addActionListener(this);
		d2.addActionListener(this);
		m2.addActionListener(this);
		y2.addActionListener(this);
		df.add(d1);
		df.add(m1);
		df.add(y1);
		pd.add(df);
		df1.add(d2);
		df1.add(m2);
		df1.add(y2);
		pd1.add(df1);
		tp.setBackground(Color.cyan);
		setBackground(Color.cyan);
		for(int i=0;i<4;i++)
		{
			p[i] = new JPanel();
			p[i].setBackground(new Color(137,207,240));
			tp.add(s[i],p[i]);
		}
		for(int i=0;i<10;i++)
		{
			l[i] = new JLabel(s1[i]);
			l[i].setFont(new Font(l[i].getFont().getName(), l[i].getFont().getStyle(), 20));
			l[i].setForeground(Color.white);
			f[i] = new JTextField(20);
			f[i].setFont(fo);
		}
		f[0].addKeyListener(new KeyAdapter()
				{
					public void keyTyped(KeyEvent ke)
					{
						char ch=ke.getKeyChar();
						if(!Character.isLetter(ch) && ch!='\b' && ch!='.')
						{
							ke.setKeyChar('\b');
							return;
						}
						
					}
				});
		f[5].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isLetter(ch) && ch!='\b')
				{
					ke.setKeyChar('\b');
					return;
				}
				
			}
		});
		f[3].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isDigit(ch) && ch!='\b')
				{
					ke.setKeyChar('\b');
					return;
				}
				String st=f[3].getText();
				int n=st.length();
				if(ch!='\b')
				{
					n++;
					if(n>=11)
						ke.setKeyChar('\b');
				}
			}
		});
		/*f[6].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isDigit(ch) && ch!='\b')
				{
					ke.setKeyChar('\b');
					return;
				}
				String st=f[3].getText();
				int n=st.length();
				if(ch!='\b')
				{
					n++;
					if(n>=4)
						ke.setKeyChar('\b');
				}
			}
		});*/
		f[8].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isDigit(ch) && ch!='\b')
				{
					ke.setKeyChar('\b');
					return;
				}
				String st=f[8].getText();
				int n=st.length();
				if(ch!='\b')
				{
					n++;
					if(n>=4)
						ke.setKeyChar('\b');
				}
			}
		});
		f[7].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isDigit(ch) && ch!='\b' && ch!='.')
				{
					ke.setKeyChar('\b');
					return;
				}
				String st=f[7].getText();
				int n=st.length();
				if(ch!='\b')
				{
					n++;
					if(n>=4)
						ke.setKeyChar('\b');
				}
			}
		});
		f[4].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isDigit(ch) && ch!='\b')
				{
					ke.setKeyChar('\b');
					return;
				}
				String st=f[4].getText();
				int n=st.length();
				if(ch!='\b')
				{
					n++;
					if(n>=4)
						ke.setKeyChar('\b');
				}
			}
		});
		pd.add(f[2]);
		for(int i=0;i<10;i++)
		{
			l1[i] = new JLabel(s2[i]);
			l1[i].setFont(new Font(l[i].getFont().getName(), l[i].getFont().getStyle(), 20));
			l1[i].setForeground(Color.white);
			f1[i] = new JTextField(20);
			f1[i].setFont(fo);
		}
		f1[0].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isLetter(ch) && ch!='\b' && ch!='.' && ch!=' ')
				{
					ke.setKeyChar('\b');
					return;
				}
				
			}
		});
		f1[5].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isLetter(ch) && ch!='\b')
				{
					ke.setKeyChar('\b');
					return;
				}
				
			}
		});
		f1[3].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isDigit(ch) && ch!='\b')
				{
					ke.setKeyChar('\b');
					return;
				}
				String st=f1[3].getText();
				int n=st.length();
				if(ch!='\b')
				{
					n++;
					if(n>=11)
						ke.setKeyChar('\b');
				}
			}
		});
		f1[4].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isDigit(ch) && ch!='\b')
				{
					ke.setKeyChar('\b');
					return;
				}
				String st=f1[4].getText();
				int n=st.length();
				if(ch!='\b')
				{
					n++;
					if(n>=4)
						ke.setKeyChar('\b');
				}
				
			}
		});
		f1[7].addKeyListener(new KeyAdapter()
		{
			public void keyTyped(KeyEvent ke)
			{
				char ch=ke.getKeyChar();
				if(!Character.isDigit(ch) && ch!='\b' && ch!='.')
				{
					ke.setKeyChar('\b');
					return;
				}
				String st=f1[7].getText();
				int n=st.length();
				if(ch!='\b')
				{
					n++;
					if(n>=4)
						ke.setKeyChar('\b');
				}
				
			}
		});
		f1[8].addKeyListener(new KeyAdapter()
			{
				public void keyTyped(KeyEvent ke)
				{
					char ch=ke.getKeyChar();
					if(!Character.isDigit(ch) && ch!='\b')
					{
						ke.setKeyChar('\b');
						return;
					}
					String st=f1[8].getText();
					int n=st.length();
					if(ch!='\b')
					{
						n++;;
						if(n>=4)
							ke.setKeyChar('\b');
					}
				}
			});
		pd1.add(f1[2]);
		for(int i=0;i<12;i++)
		{
			p11[i] = new JPanel(new GridBagLayout());
			p11[i].setOpaque(false);
		}
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		p11[0].add(l[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.ipadx=4;
		c.ipady=8;
		p11[0].add(f[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		c.ipadx=4;
		c.ipady=8;
		p11[1].add(l[1],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		c.ipadx=4;
		c.ipady=8;
		p11[1].add(f[1],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=4;
		c.ipadx=4;
		c.ipady=8;
		p11[2].add(l[2],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=5;
		c.ipadx=4;
		c.ipady=8;
		p11[2].add(pd,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=6;
		c.ipadx=4;
		c.ipady=8;
		p11[3].add(l[3],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=7;
		c.ipadx=4;
		c.ipady=8;
		p11[3].add(f[3],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=8;
		c.ipadx=4;
		c.ipady=8;
		p11[4].add(l[4],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=9;
		c.ipadx=4;
		c.ipady=8;
		p11[4].add(list1,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=10;
		c.ipadx=4;
		c.ipady=8;
		p11[5].add(l[5],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=11;
		c.ipadx=4;
		c.ipady=8;
		p11[5].add(f[5],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=12;
		c.ipadx=4;
		c.ipady=8;
		p11[6].add(l[6],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=13;
		c.ipadx=4;
		c.ipady=8;
		p11[6].add(f[4],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=14;
		c.ipadx=4;
		c.ipady=8;
		p11[7].add(l[7],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=15;
		c.ipadx=4;
		c.ipady=8;
		p11[7].add(f[6],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=16;
		c.ipadx=4;
		c.ipady=8;
		p11[8].add(l[8],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=17;
		c.ipadx=4;
		c.ipady=8;
		p11[8].add(f[7],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=18;
		c.ipadx=4;
		c.ipady=8;
		p11[10].add(l[9],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=19;
		c.ipadx=4;
		c.ipady=8;
		p11[10].add(f[8],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=20;
		c.ipadx=4;
		c.ipady=8;
		/*p11[11].add(lid,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=21;
		c.ipadx=4;
		c.ipady=8;
		p11[11].add(id,c);*/
		b1 = new JButton("Submit");
		b1.addActionListener(this);
		b1.setBackground(new Color(128,128,128));
		b1.setForeground(Color.white);
		pb1.add(b1,BorderLayout.CENTER);
		pb1.setBackground(new Color(0,0,0,25));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=20;
		c.ipadx=24;
		c.ipady=16;
		p11[9].add(pb1,c);
		for(int i=0;i<11;i++)
		{
			p12[i] = new JPanel(new GridBagLayout());
			p12[i].setOpaque(false);
		}
		//GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		p12[0].add(l1[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.ipadx=4;
		c.ipady=8;
		p12[0].add(f1[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		c.ipadx=4;
		c.ipady=8;
		p12[1].add(l1[1],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		c.ipadx=4;
		c.ipady=8;
		p12[1].add(f1[1],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=4;
		c.ipadx=4;
		c.ipady=8;
		p12[2].add(l1[2],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=5;
		c.ipadx=4;
		c.ipady=8;
		p12[2].add(pd1,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=6;
		c.ipadx=4;
		c.ipady=8;
		p12[3].add(l1[3],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=7;
		c.ipadx=4;
		c.ipady=8;
		p12[3].add(f1[3],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=8;
		c.ipadx=4;
		c.ipady=8;
		p12[4].add(l1[4],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=9;
		c.ipadx=4;
		c.ipady=8;
		p12[4].add(list2,c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=10;
		c.ipadx=4;
		c.ipady=8;
		p12[5].add(l1[5],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=11;
		c.ipadx=4;
		c.ipady=8;
		p12[5].add(f1[5],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=12;
		c.ipadx=4;
		c.ipady=8;
		p12[6].add(l1[6],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=13;
		c.ipadx=4;
		c.ipady=8;
		p12[6].add(f1[4],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=14;
		c.ipadx=4;
		c.ipady=8;
		p12[7].add(l1[7],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=15;
		c.ipadx=4;
		c.ipady=8;
		p12[7].add(f1[6],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=16;
		c.ipadx=4;
		c.ipady=8;
		p12[8].add(l1[8],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=17;
		c.ipadx=4;
		c.ipady=8;
		p12[8].add(f1[7],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=18;
		c.ipadx=4;
		c.ipady=8;
		p12[10].add(l1[9],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=19;
		c.ipadx=4;
		c.ipady=8;
		p12[10].add(f1[8],c);
		b2 = new JButton("Submit");
		b2.addActionListener(this);
		b2.setBackground(new Color(128,128,128));
		b2.setForeground(Color.white);
		pb2.add(b2,BorderLayout.CENTER);
		pb2.setBackground(new Color(0,0,0,25));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=14;
		c.ipadx=24;
		c.ipady=16;
		p12[9].add(pb2,c);
		
		
		for(int i=0;i<11;i++)
		{
			p1.add(p11[i]);
			
		}
		for(int i=0;i<11;i++)
		{
			p2.add(p12[i]);
			
		}
		for(int i =0;i<5;i++)
		{
			up1[i] = new JPanel(new GridBagLayout());
			up1[i].setOpaque(false);
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=14;
		c.ipady=16;
		up1[0].add(up[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=0;
		c.ipadx=10;
		c.ipady=16;
		//up1[0].add(up[1],c);
		c.gridx=2;
		c.gridy=0;
		c.ipadx=10;
		c.ipady=16;
		//up1[0].add(up[2],c);
		c.gridx=3;
		c.gridy=0;
		c.ipadx=200;
		c.ipady=12;
		up1[0].add(uf,c);
		c.gridx=4;
		c.gridy=0;
		c.ipadx=20;
		c.ipady=14;
		b.setBackground(new Color(128,128,128));
		b.setForeground(Color.white);
		up1[0].add(b,c);
		p[2].setLayout(new BorderLayout());
		p[2].add(up1[0],BorderLayout.NORTH);
		b.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setSize(2000,2000);
				try
				{
					
					
					Class.forName("org.postgresql.Driver");
					conn=DriverManager.getConnection("jdbc:postgresql://localhost/gymmis","postgres","root123");
					if(conn==null)
					{
						System.out.println("Connection failed"); 
					}
					else
					{
						stmt = conn.createStatement();
						int id = Integer.parseInt(uf.getText());
						String name = uf.getText();
						rs =  stmt.executeQuery("select * from member where m_id="+id);
						MemberUpdate mu = new MemberUpdate();
						setSize(2000,2000);
						if(!rs.next())
						{
							p[2].removeAll();
							setSize(2000,2000);
							p[2].add(up1[0],BorderLayout.NORTH);
							//setSize(2000,2000);
							//p[2].remove(mu);
							p[2].setSize(1200,1200);
							p[2].add(em,BorderLayout.CENTER);
							setSize(2000,2000);
						}
						else
						{
						do
						{
						//setSize(2000,2000);
						mu.uf1[0].setText(""+rs.getInt(1));
						mu.uf1[1].setText(rs.getString(2));
						mu.uf1[2].setText(rs.getString(3));
						mu.uf1[3].setText(rs.getString(4));
						mu.uf1[4].setText(rs.getString(5));
						mu.uf1[5].setText(""+rs.getInt(6));
						mu.uf1[6].setText(rs.getString(7));
						mu.uf1[7].setText(rs.getString(8));
						mu.uf1[8].setText(rs.getString(9));
						mu.uf1[9].setText(""+rs.getDouble(10));
						mu.uf1[10].setText(""+rs.getDouble(11));
						mu.uf1[11].setText(rs.getString(12));
						mu.uf1[12].setText(rs.getString(13));
						//setSize(2000,2000);
						setSize(2000,2000);
						p[2].removeAll();
						setSize(2000,2000);
						p[2].add(up1[0],BorderLayout.NORTH);
						//setSize(2000,2000);
						//p[2].remove(mu);
						p[2].setSize(1200,1200);
						p[2].add(mu,BorderLayout.CENTER);
						setSize(2000,2000);
						}while(rs.next());
						}
						
						//setSize(2000,2000);
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
				
				
			}
		});
		for(int i =0;i<5;i++)
		{
			del[i] = new JPanel(new GridBagLayout());
			del[i].setOpaque(false);
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=14;
		c.ipady=16;
		del[0].add(dl[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=0;
		c.ipadx=10;
		c.ipady=16;
		//del[0].add(dl[1],c);
		c.gridx=2;
		c.gridy=0;
		c.ipadx=10;
		c.ipady=16;
		//del[0].add(dl[2],c);
		c.gridx=3;
		c.gridy=0;
		c.ipadx=200;
		c.ipady=12;
		del[0].add(d,c);
		c.gridx=4;
		c.gridy=0;
		c.ipadx=20;
		c.ipady=14;
		bd.setBackground(new Color(128,128,128));
		bd.setForeground(Color.white);
		del[0].add(bd,c);
		p[3].setLayout(new BorderLayout());
		p[3].add(del[0],BorderLayout.NORTH);
		bd.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setSize(2000,2000);
				try
				{
					
					
					Class.forName("org.postgresql.Driver");
					conn=DriverManager.getConnection("jdbc:postgresql://localhost/gymmis","postgres","root123");
					if(conn==null)
					{
						System.out.println("Connection failed"); 
					}
					else
					{
						//stmt = conn.createStatement();
						int id = Integer.parseInt(d.getText());
						String name = d.getText();
						JLabel s1 = new JLabel("INVALID INPUT");
						JLabel s2 = new JLabel("Record Deleted Successfully");
						s1.setFont(fo);
						s2.setFont(fo);
						PreparedStatement pstmt2 = conn.prepareStatement("delete from attendance where m_id="+id);
						PreparedStatement pstmt1 = conn.prepareStatement("delete from workout where m_id="+id);
						PreparedStatement pstmt = conn.prepareStatement("delete from member where m_id="+id);
						int rs2 = pstmt2.executeUpdate();
						int rs1 = pstmt1.executeUpdate();
						int rs = pstmt.executeUpdate();
						 System.out.println(""+rs);
						 if(rs==0)
						 {
							 	setSize(2000,2000);
							 	p[3].removeAll();
								setSize(2000,2000);
								p[3].add(del[0],BorderLayout.NORTH);
								p[3].setSize(1200,1200);
							 p[3].add(s1,BorderLayout.CENTER);
						 	setSize(2000,2000);
						 }
						 else 
						 {
							 	setSize(2000,2000);
							 	p[3].removeAll();
								setSize(2000,2000);
								p[3].add(del[0],BorderLayout.NORTH);
								p[3].setSize(1200,1200);
							 p[3].add(s2,BorderLayout.CENTER);
							 setSize(2000,2000);
						 }
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
				
				
			}
		});
		for(int i =0;i<5;i++)
		{
			ser[i] = new JPanel(new GridBagLayout());
			ser[i].setOpaque(false);
		}
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=14;
		c.ipady=16;
		ser[0].add(se[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=1;
		c.gridy=0;
		c.ipadx=10;
		c.ipady=16;
		//ser[0].add(se[1],c);
		c.gridx=2;
		c.gridy=0;
		c.ipadx=10;
		c.ipady=16;
		//ser[0].add(se[2],c);
		c.gridx=3;
		c.gridy=0;
		c.ipadx=200;
		c.ipady=12;
		ser[0].add(sr,c);
		c.gridx=4;
		c.gridy=0;
		c.ipadx=20;
		c.ipady=14;
		search.setBackground(new Color(128,128,128));
		search.setForeground(Color.white);
		ser[0].add(search,c);
		p[1].setLayout(new BorderLayout());
		p[1].add(ser[0],BorderLayout.NORTH);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(13,1,10,10));
		p1.setBackground(new Color(0,0,0,35));
		for(int i=0;i<13;i++)
		{
			sm[i] = new JPanel(new GridBagLayout());
			sm[i].setOpaque(false);
			sm[i].setBackground(new Color(0,0,0,35));
		}
		search.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				setSize(2000,2000);
				try
				{
					
					
					Class.forName("org.postgresql.Driver");
					conn=DriverManager.getConnection("jdbc:postgresql://localhost/gymmis","postgres","root123");
					if(conn==null)
					{
						System.out.println("Connection failed"); 
					}
					else
					{
						stmt = conn.createStatement();
						int id = Integer.parseInt(sr.getText());
						String name = sr.getText();
						JLabel s1 = new JLabel("Record Not Found");
						s1.setFont(fo);
						rs =  stmt.executeQuery("select * from member where m_id="+id);
						//System.out.println(""+rs);
						 if(!rs.next())
						 {
							 	setSize(2000,2000);
							 	p[1].removeAll();
								setSize(2000,2000);
								p[1].add(ser[0],BorderLayout.NORTH);
								p[1].setSize(1200,1200);
							 p[1].add(s1,BorderLayout.CENTER);
						 	setSize(2000,2000);
						 }
						 else 
						 {
							 	for(int i=0;i<13;i++)
							 	{
							 		sm[i].removeAll();
							 	}
							 	src[0] = new JLabel("Member id: "+rs.getInt(1));
							 	src[1] = new JLabel("Member name: "+rs.getString(2));
							 	src[2] = new JLabel("Member type: "+rs.getString(3));
							 	src[3] = new JLabel("Member address: "+rs.getString(4));
							 	src[4] = new JLabel("phone no.: "+rs.getString(5));
							 	src[5] = new JLabel("Member age: "+rs.getInt(6));
							 	src[6] = new JLabel("course name: "+rs.getString(7));
							 	src[7] = new JLabel("department name: "+rs.getString(8));
							 	src[8] = new JLabel("date of birth: "+rs.getString(9));
							 	src[9] = new JLabel("Member  height: "+rs.getDouble(10));
							 	src[10] = new JLabel("Member weight : "+rs.getDouble(11));
							 	src[11] = new JLabel("email id: "+rs.getString(12));
							 	src[12] = new JLabel("sex: "+rs.getString(13));
								GridBagConstraints c = new GridBagConstraints();
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=0;
								c.ipadx=4;
								c.ipady=8;
								//c.gridwidth=4;
								sm[0].add(src[0],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=1;
								c.ipadx=4;
								c.ipady=8;
								sm[1].add(src[1],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=2;
								c.ipadx=4;
								c.ipady=8;
								sm[2].add(src[2],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=3;
								c.ipadx=4;
								c.ipady=8;
								sm[3].add(src[3],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=4;
								c.ipadx=4;
								c.ipady=8;
								sm[4].add(src[4],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=5;
								c.ipadx=4;
								c.ipady=8;
								sm[5].add(src[5],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=6;
								c.ipadx=4;
								c.ipady=8;
								sm[6].add(src[6],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=7;
								c.ipadx=4;
								c.ipady=8;
								sm[3].add(src[7],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=8;
								c.ipadx=4;
								c.ipady=8;
								sm[8].add(src[8],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=9;
								c.ipadx=4;
								c.ipady=8;
								sm[9].add(src[9],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=10;
								c.ipadx=4;
								c.ipady=8;
								sm[10].add(src[10],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=11;
								c.ipadx=4;
								c.ipady=8;
								sm[11].add(src[11],c);
								c.fill = GridBagConstraints.HORIZONTAL;
								c.gridx=0;
								c.gridy=12;
								c.ipadx=4;
								c.ipady=8;
								sm[12].add(src[12],c);
								for(int i=0;i<13;i++)
								{
									src[i].setFont(fo);
								}
								p1.setSize(1200,1200);
							 	for(int i=0;i<13;i++)
								{
									setSize(2000,2000);
									p1.add(sm[i]);
									setSize(2000,2000);
								}
							 	setSize(2000,2000);
								p[1].removeAll();
								setSize(2000,2000);
								p[1].add(ser[0],BorderLayout.NORTH);
								p[1].setSize(1200,1200);
								p[1].add(p1,BorderLayout.CENTER);
								setSize(2000,2000);
						 }
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
				
				
			}
		});
		p[0].setLayout(new BorderLayout());
		p[0].add(tp1,BorderLayout.CENTER);
		add(tp,BorderLayout.CENTER);
		//setVisible(true);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setSize(2000,2000);
	}
	//public static void main(String[] args)
	//{
		//new Member();
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==d1)
		{
		   day = (String) d1.getSelectedItem();
		   String date = new String(year+"-"+month+"-"+day);
			f[2].setText(date);
		   
		}
		if(e.getSource()==m1)
		{
		   month = (String) m1.getSelectedItem();
		   String date = new String(year+"-"+month+"-"+day);
			f[2].setText(date);
		}
		if(e.getSource()==y1)
		{
			year = (String) y1.getSelectedItem();
			String date = new String(year+"-"+month+"-"+day);
			f[2].setText(date);
		}
		if(e.getSource()==d2)
		{
		   day = (String) d2.getSelectedItem();
		   String date = new String(year+"-"+month+"-"+day);
			f1[2].setText(date);
		   
		}
		if(e.getSource()==m2)
		{
		   month = (String) m2.getSelectedItem();
		   String date = new String(year+"-"+month+"-"+day);
			f1[2].setText(date);
		}
		if(e.getSource()==y2)
		{
			year = (String) y2.getSelectedItem();
			String date = new String(year+"-"+month+"-"+day);
			f1[2].setText(date);
		}
		if(e.getSource()==b1)
		{
			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
			//FileReader fr = new FileReader("m_id");
			BufferedReader br = new BufferedReader(new FileReader("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/m_id"));
			sid=Integer.parseInt(br.readLine());
			//System.out.println(""+sid);
			sid=sid+1;
			fw = new FileWriter("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/m_id",false);
			bw = new BufferedWriter(fw);
			String s = ""+sid;
			//System.out.println(s);
			bw.write(s);

			//System.out.println("Done");

		} catch (IOException e1) {

			e1.printStackTrace();

		}
			finally {

				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}
			try
			{
				
				
				Class.forName("org.postgresql.Driver");
				conn=DriverManager.getConnection("jdbc:postgresql://localhost/gymmis","postgres","root123");
				if(conn==null)
				{
					System.out.println("Connection failed"); 
				}
				else
				{
				stmp=conn.prepareStatement("insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				stmp.setInt(1,sid);
				stmp.setString(2,f[0].getText());
				stmp.setString(3,"student");
				stmp.setString(4,f[1].getText());
				stmp.setString(5,f[3].getText());
				stmp.setInt(6,Integer.parseInt(f[8].getText()));
				stmp.setString(7,f[5].getText());
				stmp.setString(8,"NULL");
				stmp.setString(9,f[2].getText());
				stmp.setFloat(10,Float.parseFloat(f[7].getText()));
				stmp.setFloat(11,Float.parseFloat(f[4].getText()));
				stmp.setString(12,f[6].getText());
				stmp.setString(13,(String) list1.getSelectedItem());
				stmp.executeUpdate();
				}
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
		if(e.getSource()==b2)
		{
			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
			//FileReader fr = new FileReader("m_id");
			BufferedReader br = new BufferedReader(new FileReader("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/m_id"));
			sid=Integer.parseInt(br.readLine());
			//System.out.println(""+sid);
			sid=sid+1;
			fw = new FileWriter("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/m_id",false);
			bw = new BufferedWriter(fw);
			String s = ""+sid;
			//id.setText(s);
			//System.out.println(s);
			bw.write(s);
			
			//System.out.println("Done");

		} catch (IOException e1) {

			e1.printStackTrace();

		}
			finally {

				try {

					if (bw != null)
						bw.close();

					if (fw != null)
						fw.close();

				} catch (IOException ex) {

					ex.printStackTrace();

				}

			}
			
			try
			{
				
				
				Class.forName("org.postgresql.Driver");
				conn1=DriverManager.getConnection("jdbc:postgresql://localhost/gymmis","postgres","root123");
				if(conn1==null)
				{
					System.out.println("Connection failed"); 
				}
				else
				{
				stmp1=conn1.prepareStatement("insert into member values(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				stmp1.setInt(1,sid);
				stmp1.setString(2,f1[0].getText());
				stmp1.setString(3,"faculty");
				stmp1.setString(4,f1[1].getText());
				stmp1.setString(5,f1[3].getText());
				stmp1.setInt(6,Integer.parseInt(f1[8].getText()));
				stmp1.setString(7,"NULL");
				stmp1.setString(8,f1[5].getText());
				stmp1.setString(9,f1[2].getText());
				stmp1.setFloat(10,Float.parseFloat(f1[7].getText()));
				stmp1.setFloat(11,Float.parseFloat(f1[4].getText()));
				stmp1.setString(12,f1[6].getText());
				stmp1.setString(13,(String) list2.getSelectedItem());
				stmp1.executeUpdate();
				id.setText(""+sid);
				}
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
				
	}
}
