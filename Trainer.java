

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Trainer extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane tp;
	JLabel l[] = new JLabel[10];
	JTextField f[] = new JTextField[10];
	JPanel p[] = new JPanel[6];
	String s[] = {"Create Trainer","Search trainer","Update Trainer","Delete Trainer"}; 
	JButton b1;
	JPanel p1,p2,pb1,df,pd;
	String s1[] = {"Name:","Address:","Date of Birth","Mobile no:","Sex:","Trainer Type:","Email id:","Salary:","Shift","Age:"};
	JPanel p11[] = new JPanel[11];
	int tid=0;
	Connection conn;
	PreparedStatement stmp;
	JComboBox<String> list1,list2,d1,m1,y1;
	static String day,month,year;
	Statement stmt;
	ResultSet rs;
	JLabel up[] = new JLabel[3];
	JTextField uf = new JTextField();
	JButton b = new JButton("Submit");
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
	public Trainer()
	{
		Font fo = new Font("Serif", Font.BOLD, 20); 
		em.setFont(fo);
		up[0] = new JLabel("Enter Trainer  id");
		 up[1] = new JLabel("or");
		 up[2] = new JLabel("Trainer name:");
		 for(int i=0;i<3;i++)
			{
				up[i].setFont(fo);
			}
			uf.setFont(fo);
			dl[0] = new JLabel("Enter Trainer id");
			 dl[1] = new JLabel("or");
			 dl[2] = new JLabel("Member name:");
			 for(int i=0;i<3;i++)
				{
					dl[i].setFont(fo);
				}
				d.setFont(fo);
				se[0] = new JLabel("Enter Trainer id");
				 se[1] = new JLabel("or");
				 se[2] = new JLabel("Member name:");
				 for(int i=0;i<3;i++)
					{
						se[i].setFont(fo);
					}
					sr.setFont(fo);
		pb1 = new JPanel();
		pb1.setLayout(new GridLayout(1,1,15,0));
		p1 = new JPanel();
		p1.setLayout(new GridLayout(8,1,5,10));
		p1.setBackground(new Color(137,207,240));
		df = new JPanel();
		df.setLayout(new FlowLayout());
		df.setBackground(new Color(0,0,0,25));
		pd = new JPanel();
		pd.setLayout(new GridLayout(2,1));
		pd.setBackground(new Color(0,0,0,25));
		list1 = new JComboBox<String>();
		list1.setBackground(new Color(0,0,0,35));
		list1.setFont(fo);
		list1.addItem("Male");
		list1.addItem("Female");
		list1.addItem("Other");
		d1 = new JComboBox<String>();
		d1.setBackground(new Color(0,0,0,35));
		d1.setFont(fo);
		d1.addItem("dd");
		for(int i=1;i<=31;i++)
		{
			d1.addItem(""+i);
		}
		m1 = new JComboBox<String>();
		m1.setBackground(new Color(0,0,0,35));
		m1.setFont(fo);
		m1.addItem("mm");
		for(int i=1;i<=12;i++)
		{
			m1.addItem(""+i);
		}
		y1 = new JComboBox<String>();
		y1.setBackground(new Color(0,0,0,5));
		y1.setFont(fo);
		y1.addItem("yyyy");
		for(int i=1985;i<=2008;i++)
		{
			y1.addItem(""+i);
		}
		d1.addActionListener(this);
		m1.addActionListener(this);
		y1.addActionListener(this);
		df.add(d1);
		df.add(m1);
		df.add(y1);
		pd.add(df);
		GridBagConstraints c = new GridBagConstraints();
		tp = new JTabbedPane();
		tp.setBackground(Color.CYAN);
		tp.setFont(fo);
		setLayout(new BorderLayout());
		setBackground(new Color(0,0,25));
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
f[7].addKeyListener(new KeyAdapter()
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
/*f[7].addKeyListener(new KeyAdapter()
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
			if(n>=6)
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
f[6].addKeyListener(new KeyAdapter()
{
	public void keyTyped(KeyEvent ke)
	{
		char ch=ke.getKeyChar();
		if(!Character.isDigit(ch) && ch!='\b' && ch!='.')
		{
			ke.setKeyChar('\b');
			return;
		}
		String st=f[6].getText();
		int n=st.length();
		if(ch!='\b')
		{
			n++;
			if(n>=6)
				ke.setKeyChar('\b');
		}
	}
});
/*f[8].addKeyListener(new KeyAdapter()
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
});*/
		pd.add(f[2]);
		for(int i=0;i<11;i++)
		{
			p11[i] = new JPanel(new GridBagLayout());
			p11[i].setOpaque(false);
		}
		
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
			p1.add(p11[i]);
			
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
		p[0].setLayout(new BorderLayout());
		p[0].add(p1,BorderLayout.CENTER);
		add(tp,BorderLayout.CENTER);
		setBackground(Color.CYAN);
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
						rs =  stmt.executeQuery("select * from trainer where tid="+id);
						TrainerUpdate mu = new TrainerUpdate();
						setBackground(Color.CYAN);
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
						mu.uf1[5].setText(rs.getString(6));
						mu.uf1[6].setText(rs.getString(7));
						mu.uf1[7].setText(rs.getString(8));
						mu.uf1[8].setText(""+rs.getDouble(9));
						mu.uf1[9].setText(rs.getString(10));
						mu.uf1[10].setText(""+rs.getInt(11));
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
						PreparedStatement pstmt = conn.prepareStatement("delete from trainer where tid="+id);
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
						rs =  stmt.executeQuery("select * from trainer where tid="+id);
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
							 	for(int i=0;i<11;i++)
							 	{
							 		sm[i].removeAll();
							 	}
							 	src[0] = new JLabel("Trainer id: "+rs.getInt(1));
							 	src[1] = new JLabel("Trainer name: "+rs.getString(2));
							 	src[2] = new JLabel("Trainer address: "+rs.getString(3));
							 	src[3] = new JLabel(" Date of Birth"+rs.getString(4));
							 	src[4] = new JLabel("Phone no.: "+rs.getString(5));
							 	src[5] = new JLabel("Sex: "+rs.getString(6));
							 	src[6] = new JLabel("Trainer Type: "+rs.getString(7));
							 	src[7] = new JLabel("email id: "+rs.getString(8));
							 	src[8] = new JLabel("Trainer Salary: "+rs.getDouble(9));
							 	src[9] = new JLabel("Shift: "+rs.getString(10));
							 	src[10] = new JLabel("Age: "+rs.getInt(11));
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
								for(int i=0;i<11;i++)
								{
									src[i].setFont(fo);
								}
								p1.setSize(1200,1200);
							 	for(int i=0;i<11;i++)
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
		
	}
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
		if(e.getSource()==b1)
		{
			FileWriter fw = null;
			BufferedWriter bw = null;
			try {
			//FileReader fr = new FileReader("m_id");
			BufferedReader br = new BufferedReader(new FileReader("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/t_id"));
			tid=Integer.parseInt(br.readLine());
			//System.out.println(""+sid);
			tid=tid+1;
			fw = new FileWriter("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/t_id",false);
			bw = new BufferedWriter(fw);
			String s = ""+tid;
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
				stmp=conn.prepareStatement("insert into trainer values(?,?,?,?,?,?,?,?,?,?,?)");
				stmp.setInt(1,tid);
				stmp.setString(2,f[0].getText());
				stmp.setString(3,f[1].getText());
				stmp.setString(4,f[2].getText());
				stmp.setString(5,f[3].getText());
				stmp.setString(6,(String) list1.getSelectedItem());
				stmp.setString(7,f[5].getText());
				stmp.setString(8,f[4].getText());
				stmp.setFloat(9,Float.parseFloat(f[6].getText()));
				stmp.setString(10,f[7].getText());
				stmp.setInt(11,Integer.parseInt(f[8].getText()));
				stmp.executeUpdate();
				}
			}catch(Exception e1)
			{
				System.out.println(e1);
			}
			
		}
		
	}
}