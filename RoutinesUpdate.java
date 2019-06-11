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
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
public class RoutinesUpdate extends JPanel{
	JScrollPane scroll[] = new JScrollPane[9];
	JTextArea wo[] = new JTextArea[9];
	JTextField d[] = new JTextField[10];
	JPanel p11[] = new JPanel[10];
	JButton b;
	JPanel pb;
	Connection conn,conn1;
	PreparedStatement stmp[] = new PreparedStatement[10];
	public RoutinesUpdate()
	{
		Font fo = new Font("Serif", Font.BOLD, 20);
		pb = new JPanel();
		pb.setLayout(new GridLayout(1,1,15,0));
		setLayout(new GridLayout(10,1,5,5));
	for(int i=0;i<9;i++)
	{
		wo[i] = new JTextArea();
		d[i] = new JTextField();
		wo[i].setSize(80, 400);
		 scroll[i] = new JScrollPane(wo[i]);
          scroll[i].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
          wo[i].setFont(fo);
          d[i].setFont(fo);
          
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
	c.gridy=1;
	c.ipadx=200;
	c.ipady=8;
	p11[0].add(d[0],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=1;
	c.gridy=1;
	c.ipadx=400;
	c.ipady=80;
	p11[0].add(scroll[0],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=0;
	c.gridy=2;
	c.ipadx=200;
	c.ipady=8;
	p11[1].add(d[1],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=1;
	c.gridy=2;
	c.ipadx=400;
	c.ipady=80;
	p11[1].add(scroll[1],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=0;
	c.gridy=3;
	c.ipadx=200;
	c.ipady=8;
	p11[2].add(d[2],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=1;
	c.gridy=3;
	c.ipadx=400;
	c.ipady=80;
	p11[2].add(scroll[2],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=0;
	c.gridy=4;
	c.ipadx=200;
	c.ipady=8;
	p11[3].add(d[3],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=1;
	c.gridy=4;
	c.ipadx=400;
	c.ipady=80;
	p11[3].add(scroll[3],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=0;
	c.gridy=5;
	c.ipadx=200;
	c.ipady=8;
	p11[4].add(d[4],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=1;
	c.gridy=5;
	c.ipadx=400;
	c.ipady=80;
	p11[4].add(scroll[4],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=0;
	c.gridy=6;
	c.ipadx=200;
	c.ipady=8;
	p11[5].add(d[5],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=1;
	c.gridy=6;
	c.ipadx=400;
	c.ipady=80;
	p11[5].add(scroll[5],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=0;
	c.gridy=7;
	c.ipadx=200;
	c.ipady=8;
	p11[6].add(d[6],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=1;
	c.gridy=7;
	c.ipadx=400;
	c.ipady=80;
	p11[6].add(scroll[6],c);
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=1;
	c.gridy=8;
	c.ipadx=200;
	c.ipady=80;
	p11[7].add(d[8],c);
	b = new JButton("Submit");
	b.setFont(fo);
	b.setBackground(new Color(128,128,128));
	b.setForeground(Color.white);
	pb.add(b,BorderLayout.CENTER);
	pb.setBackground(new Color(0,0,0,25));
	c.fill = GridBagConstraints.HORIZONTAL;
	c.gridx=0;
	c.gridy=9;
	c.ipadx=24;
	c.ipady=16;
	p11[8].add(pb,c);
	setBackground(new Color(0,0,0,25));
	for(int i=0;i<9;i++)
	{
		add(p11[i]);
	}
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
								Routines t = new Routines();
								int id = Integer.parseInt(d[8].getText());
							stmp[0]=conn.prepareStatement("update workout set day=?,description=? where m_id="+id+" and day='Monday'");
							stmp[1]=conn.prepareStatement("update workout set day=?,description=? where m_id="+id+" and day='Tuesday'");
							stmp[2]=conn.prepareStatement("update workout set day=?,description=? where m_id="+id+" and day='Wednesday'");
							stmp[3]=conn.prepareStatement("update workout set day=?,description=? where m_id="+id+" and day='Thursday'");
							stmp[4]=conn.prepareStatement("update workout set day=?,description=? where m_id="+id+" and day='Friday'");
							stmp[5]=conn.prepareStatement("update workout set day=?,description=? where m_id="+id+" and day='Saturday'");
							stmp[6]=conn.prepareStatement("update workout set day=?,description=? where m_id="+id+" and day='Sunday'");
							//stmp.setInt(1,Integer.parseInt(uf1[0].getText()));
							stmp[0].setString(1,d[0].getText());
							stmp[0].setString(2,wo[0].getText());
							stmp[1].setString(1,d[1].getText());
							stmp[1].setString(2,wo[1].getText());
							stmp[2].setString(1,d[2].getText());
							stmp[2].setString(2,wo[2].getText());
							stmp[3].setString(1,d[3].getText());
							stmp[3].setString(2,wo[3].getText());
							stmp[4].setString(1,d[4].getText());
							stmp[4].setString(2,wo[4].getText());
							stmp[5].setString(1,d[5].getText());
							stmp[5].setString(2,wo[5].getText());
							stmp[6].setString(1,d[6].getText());
							stmp[6].setString(2,wo[6].getText());
							stmp[0].executeUpdate();
							stmp[1].executeUpdate();
							stmp[2].executeUpdate();
							stmp[3].executeUpdate();
							stmp[4].executeUpdate();
							stmp[5].executeUpdate();
							stmp[6].executeUpdate();
							}
						}catch(Exception e1)
						{
							System.out.println(e1);
						}
						
					}
				});
	}
	}
