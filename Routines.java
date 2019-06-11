
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Routines extends JPanel implements ActionListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane tp;
	JPanel p[] = new JPanel[6];
	String s[] = {"Plan new Workout","Prospect a Workout","Customize a Workout","destory a Workout"}; 
	JLabel member = new JLabel("Enter Member id to set WorkOut:");
	JTextField mem = new JTextField();
	JComboBox<String> day[] = new JComboBox[7];
	String sday[] = {"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
	JTextArea wo[] = new JTextArea[7];
	JPanel p11[] = new JPanel[10];
	JPanel p1,pb;
	JButton b;
	JScrollPane scroll[] = new JScrollPane[8];
	JPanel up1[] = new JPanel[6];
	Connection conn,conn1;
	PreparedStatement stmp,stmp1;
	Statement stmt[] = new Statement[10];
	ResultSet rs,rs1,rs2,rs3,rs4,rs5,rs6,r,r1,r2,r3,r4,r5,r6;
	JLabel se[] = new JLabel[3];
	JTextField sr = new JTextField();
	JButton search = new JButton("Search");
	JPanel ser[] = new JPanel[6];
	JLabel src[] = new JLabel[20];
	JPanel sm[] = new JPanel[20];
	JLabel up[] = new JLabel[3];
	JTextField uf; 
	JButton bu = new JButton("Search");
	JLabel em = new JLabel("Record Not Found");
	JLabel dl[] = new JLabel[3];
	JTextField d = new JTextField();
	JButton bd = new JButton("Delete");
	JPanel del[] = new JPanel[6];
	public Routines()
	{
		 uf = new JTextField();
		pb = new JPanel();
		pb.setLayout(new GridLayout(1,1,15,0));
		p1 = new JPanel();
		
		setLayout(new BorderLayout());
		Font fo = new Font("Serif", Font.BOLD, 20);
		em.setFont(fo);
		dl[0] = new JLabel("Enter Member id");
		 dl[1] = new JLabel("or");
		 dl[2] = new JLabel("Member name:");
		 for(int i=0;i<3;i++)
			{
				dl[i].setFont(fo);
			}
			d.setFont(fo);
		up[0] = new JLabel("Enter Member id");
		 up[1] = new JLabel("or");
		 up[2] = new JLabel("Member name:");
		 for(int i=0;i<3;i++)
			{
				up[i].setFont(fo);
			}
			uf.setFont(fo);
		se[0] = new JLabel("Enter Member id");
		 se[1] = new JLabel("or");
		 se[2] = new JLabel("Member name:");
		 for(int i=0;i<3;i++)
			{
				se[i].setFont(fo);
			}
			sr.setFont(fo);
		member.setFont(fo);
		mem.setFont(fo);
		tp = new JTabbedPane();
		tp.setBackground(Color.CYAN);
		tp.setFont(fo);
		setBackground(Color.CYAN);
		for(int i=0;i<4;i++)
		{
			p[i] = new JPanel();
			//p[i].setOpaque(false);
			p[i].setBackground(new Color(137,207,240));
			tp.add(s[i],p[i]);
		}
		p[0].setLayout(new GridLayout(10,1,5,5));
		add(tp,BorderLayout.CENTER);
		for(int i=0;i<7;i++)
		{
			wo[i] = new JTextArea();
			wo[i].setSize(80, 400);
			 scroll[i] = new JScrollPane(wo[i]);
	          scroll[i].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

			wo[i].setFont(fo);
			day[i] = new JComboBox<String>();
			for(int j=0;j<7;j++)
			{
				day[i].addItem(sday[j]);
			}
			day[i].setFont(fo);
		}
		for(int i=0;i<9;i++)
		{
			p11[i] =new JPanel();
			p11[i].setLayout(new GridBagLayout());
			p11[i].setOpaque(false);
		}
			GridBagConstraints c = new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=0;
			c.ipadx=4;
			c.ipady=8;
			p11[0].add(member,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=0;
			c.ipadx=200;
			c.ipady=8;
			p11[0].add(mem,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=1;
			c.ipadx=4;
			c.ipady=8;
			p11[1].add(day[1],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=1;
			c.ipadx=400;
			c.ipady=80;
			p11[1].add(scroll[1],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=2;
			c.ipadx=4;
			c.ipady=8;
			p11[2].add(day[2],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=2;
			c.ipadx=400;
			c.ipady=80;
			p11[2].add(scroll[2],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=3;
			c.ipadx=4;
			c.ipady=8;
			p11[3].add(day[3],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=3;
			c.ipadx=400;
			c.ipady=80;
			p11[3].add(scroll[3],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=4;
			c.ipadx=4;
			c.ipady=8;
			p11[4].add(day[4],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=4;
			c.ipadx=400;
			c.ipady=80;
			p11[4].add(scroll[4],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=5;
			c.ipadx=4;
			c.ipady=8;
			p11[5].add(day[5],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=5;
			c.ipadx=400;
			c.ipady=80;
			p11[5].add(scroll[5],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=6;
			c.ipadx=4;
			c.ipady=8;
			p11[6].add(day[6],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=6;
			c.ipadx=400;
			c.ipady=80;
			p11[6].add(scroll[6],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=7;
			c.ipadx=4;
			c.ipady=8;
			p11[7].add(day[0],c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=7;
			c.ipadx=400;
			c.ipady=80;
			p11[7].add(scroll[0],c);
			b = new JButton("Submit");
			b.addActionListener(new ActionListener() {
				
		
				public void actionPerformed(ActionEvent e) {
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
						stmp=conn.prepareStatement("insert into workout values(?,?,?)");
						stmp.setInt(1,Integer.parseInt(mem.getText()));
						stmp.setString(2,(String) day[1].getSelectedItem());
						stmp.setString(3,wo[1].getText());
						stmp.executeUpdate();
						stmp.setInt(1,Integer.parseInt(mem.getText()));
						stmp.setString(2,(String) day[2].getSelectedItem());
						stmp.setString(3,wo[2].getText());
						stmp.executeUpdate();
						stmp.setInt(1,Integer.parseInt(mem.getText()));
						stmp.setString(2,(String) day[3].getSelectedItem());
						stmp.setString(3,wo[3].getText());
						stmp.executeUpdate();
						stmp.setInt(1,Integer.parseInt(mem.getText()));
						stmp.setString(2,(String) day[4].getSelectedItem());
						stmp.setString(3,wo[4].getText());
						stmp.executeUpdate();
						stmp.setInt(1,Integer.parseInt(mem.getText()));
						stmp.setString(2,(String) day[5].getSelectedItem());
						stmp.setString(3,wo[5].getText());
						stmp.executeUpdate();
						stmp.setInt(1,Integer.parseInt(mem.getText()));
						stmp.setString(2,(String) day[6].getSelectedItem());
						stmp.setString(3,wo[6].getText());
						stmp.executeUpdate();
						stmp.setInt(1,Integer.parseInt(mem.getText()));
						stmp.setString(2,(String) day[0].getSelectedItem());
						stmp.setString(3,wo[0].getText());
						stmp.executeUpdate();
						}
					}catch(Exception e1)
					{
						System.out.println(e1);
					}
					
				}
			});
			b.setFont(fo);
			b.setBackground(new Color(128,128,128));
			b.setForeground(Color.white);
			pb.add(b,BorderLayout.CENTER);
			pb.setBackground(new Color(0,0,0,25));
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=8;
			c.ipadx=24;
			c.ipady=16;
			p11[8].add(pb,c);
			for(int i=0;i<9;i++)
			{
				p[0].add(p11[i]);
			}
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
			ser[0].add(se[1],c);
			c.gridx=2;
			c.gridy=0;
			c.ipadx=10;
			c.ipady=16;
			ser[0].add(se[2],c);
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
			p1.setLayout(new GridLayout(1,1,10,10));
			p1.setBackground(new Color(0,0,0,35));
			for(int i=0;i<16;i++)
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
							stmt[0] = conn.createStatement();
							stmt[1] = conn.createStatement();
							stmt[2] = conn.createStatement();
							stmt[3] = conn.createStatement();
							stmt[4] = conn.createStatement();
							stmt[5] = conn.createStatement();
							stmt[6] = conn.createStatement();
							int id = Integer.parseInt(sr.getText());
							String name = sr.getText();
							JLabel s1 = new JLabel("Record Not Found");
							s1.setFont(fo);
							rs =  stmt[0].executeQuery("select * from workout where m_id="+id+" and day='Monday'");
							rs1 =  stmt[1].executeQuery("select * from workout where m_id="+id+" and day='Tuesday'");
							rs2 =  stmt[2].executeQuery("select * from workout where m_id="+id+" and day='Wednesday'");
							rs3 =  stmt[3].executeQuery("select * from workout where m_id="+id+" and day='Thursday'");
							rs4 =  stmt[4].executeQuery("select * from workout where m_id="+id+" and day='Friday'");
							rs5=  stmt[5].executeQuery("select * from workout where m_id="+id+" and day='Saturday'");
							rs6 =  stmt[6].executeQuery("select * from workout where m_id="+id+" and day='Sunday'");
							//System.out.println(""+rs);
							 if(!rs.next() || !rs1.next() || !rs2.next() || !rs3.next() || !rs4.next() || !rs5.next() || !rs6.next())
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
								 	for(int i=0;i<1;i++)
								 	{
								 		sm[i].removeAll();
								 	}
								 	src[0] = new JLabel(""+rs.getString(2));
								 	src[1] = new JLabel(""+rs.getString(3));
								 	src[4] = new JLabel(""+rs1.getString(2));
								 	src[5] = new JLabel(""+rs1.getString(3));
								 	src[6] = new JLabel(""+rs2.getString(2));
								 	src[7] = new JLabel(""+rs2.getString(3));
								 	src[8] = new JLabel(""+rs3.getString(2));
								 	src[9] = new JLabel(""+rs3.getString(3));
								 	src[10] = new JLabel(""+rs4.getString(2));
								 	src[11] = new JLabel(""+rs4.getString(3));
								 	src[12] = new JLabel(""+rs5.getString(2));
								 	src[13] = new JLabel(""+rs5.getString(3));
								 	src[14] = new JLabel(""+rs6.getString(2));
								 	src[15] = new JLabel(""+rs6.getString(3));
								 	src[2] = new JLabel("Day");
								 	src[3] = new JLabel("Workout");
								 	GridBagConstraints c = new GridBagConstraints();
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=0;
									c.gridy=0;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[2],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=1;
									c.gridy=0;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[3],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=0;
									c.gridy=1;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[0],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=1;
									c.gridy=1;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[1],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=0;
									c.gridy=2;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[4],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=1;
									c.gridy=2;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[5],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=0;
									c.gridy=3;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[6],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=1;
									c.gridy=3;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[7],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=0;
									c.gridy=4;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[8],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=1;
									c.gridy=4;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[9],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=0;
									c.gridy=5;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[10],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=1;
									c.gridy=5;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[11],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=0;
									c.gridy=6;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[12],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=1;
									c.gridy=6;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[13],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=0;
									c.gridy=7;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[14],c);
									c.fill = GridBagConstraints.HORIZONTAL;
									c.gridx=1;
									c.gridy=7;
									c.ipadx=4;
									c.ipady=8;
									sm[0].add(src[15],c);
									for(int i=0;i<16;i++)
									{
										src[i].setFont(fo);
									}
									p1.setSize(1200,1200);
								 	for(int i=0;i<1;i++)
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
			up1[0].add(up[1],c);
			c.gridx=2;
			c.gridy=0;
			c.ipadx=10;
			c.ipady=16;
			up1[0].add(up[2],c);
			c.gridx=3;
			c.gridy=0;
			c.ipadx=200;
			c.ipady=12;
			up1[0].add(uf,c);
			c.gridx=4;
			c.gridy=0;
			c.ipadx=20;
			c.ipady=14;
			bu.setBackground(new Color(128,128,128));
			bu.setForeground(Color.white);
			up1[0].add(bu,c);
			p[2].setLayout(new BorderLayout());
			p[2].add(up1[0],BorderLayout.NORTH);
			bu.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e)
				{
					try {
					Class.forName("org.postgresql.Driver");
					conn=DriverManager.getConnection("jdbc:postgresql://localhost/gymmis","postgres","root123");
					if(conn==null)
					{
						System.out.println("Connection failed"); 
					}
					else
					{
						stmt[0] = conn.createStatement();
						stmt[1] = conn.createStatement();
						stmt[2] = conn.createStatement();
						stmt[3] = conn.createStatement();
						stmt[4] = conn.createStatement();
						stmt[5] = conn.createStatement();
						stmt[6] = conn.createStatement();
						int id = Integer.parseInt(uf.getText());
						String name = uf.getText();
						JLabel s1 = new JLabel("Record Not Found");
						s1.setFont(fo);
						r =  stmt[0].executeQuery("select * from workout where m_id="+id+" and day='Monday'");
						r1 =  stmt[1].executeQuery("select * from workout where m_id="+id+" and day='Tuesday'");
						r2 =  stmt[2].executeQuery("select * from workout where m_id="+id+" and day='Wednesday'");
						r3 =  stmt[3].executeQuery("select * from workout where m_id="+id+" and day='Thursday'");
						r4 =  stmt[4].executeQuery("select * from workout where m_id="+id+" and day='Friday'");
						r5=  stmt[5].executeQuery("select * from workout where m_id="+id+" and day='Saturday'");
						r6 =  stmt[6].executeQuery("select * from workout where m_id="+id+" and day='Sunday'");
						RoutinesUpdate mu =new RoutinesUpdate();
						setSize(2000,2000);
						if(!r.next() || !r1.next() || !r2.next() || !r3.next() || !r4.next() || !r5.next() || !r6.next())
						{
							p[2].removeAll();
							setSize(2000,2000);
							p[2].add(up1[0],BorderLayout.NORTH);
							//setSize(2000,2000);
							//p[2].remove(mu);
							p[2].setSize(1200,1200);
							p[2].add(s1,BorderLayout.CENTER);
							setSize(2000,2000);
						}
						else
						{
						//setSize(2000,2000);
						mu.d[8].setText(""+id);
						mu.d[0].setText(r.getString(2));
						mu.wo[0].setText(r.getString(3));
						mu.d[1].setText(r1.getString(2));
						mu.wo[1].setText(r1.getString(3));
						mu.d[2].setText(r2.getString(2));
						mu.wo[2].setText(r2.getString(3));
						mu.d[3].setText(r3.getString(2));
						mu.wo[3].setText(r3.getString(3));
						mu.d[4].setText(r4.getString(2));
						mu.wo[4].setText(r4.getString(3));
						mu.d[5].setText(r5.getString(2));
						mu.wo[5].setText(r5.getString(3));
						mu.d[6].setText(r6.getString(2));
						mu.wo[6].setText(r6.getString(3));
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
					}
					}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
							
			}});
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
			del[0].add(dl[1],c);
			c.gridx=2;
			c.gridy=0;
			c.ipadx=10;
			c.ipady=16;
			del[0].add(dl[2],c);
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
							PreparedStatement pstmt1 = conn.prepareStatement("delete from workout where m_id="+id);
							//PreparedStatement pstmt = conn.prepareStatement("delete from member where m_id="+id);
							int rs1 = pstmt1.executeUpdate();
							//int rs = pstmt.executeUpdate();
							 System.out.println(""+rs);
							 if(rs1==0)
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
			//p[0].add(p1);
	}
	public void actionPerformed(ActionEvent e) {
	
		
	}
}