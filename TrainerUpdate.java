

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
import javax.swing.JTextField;

public class TrainerUpdate extends JPanel{
	JLabel ul[] = new JLabel[11];
	JTextField uf1[] = new JTextField[11];
	String us[] = {"Trainer id:","Name:","Address:","Date of Birth","Mobile no:","Sex:","Trainer Type:","Email id:","Salary:","Shift","Age:"};
	JPanel upane[] = new JPanel[15];
	JButton b1;
	JPanel p1;
	Connection conn,conn1;
	PreparedStatement stmp,stmp1;
	Statement stmt;
	
	public TrainerUpdate()
	{
		setBackground(new Color(128,128,128));
		
		Font fo = new Font("Serif", Font.BOLD, 20); 
		
		for(int i=0;i<11;i++)
		{
			ul[i] = new JLabel(us[i]);
			ul[i].setFont(new Font(ul[i].getFont().getName(),ul[i].getFont().getStyle(), 20));
			ul[i].setForeground(Color.white);
			uf1[i] = new JTextField(20);
			uf1[i].setFont(fo);
		}
		for(int i=0;i<12;i++)
		{
			upane[i] = new JPanel(new GridBagLayout());
			upane[i].setOpaque(false);
			upane[i].setBackground(new Color(0,0,0,35));
		}
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		upane[0].add(ul[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.ipadx=4;
		c.ipady=8;
		upane[0].add(uf1[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		c.ipadx=4;
		c.ipady=8;
		upane[1].add(ul[1],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		c.ipadx=4;
		c.ipady=8;
		upane[1].add(uf1[1],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=4;
		c.ipadx=4;
		c.ipady=8;
		upane[2].add(ul[2],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=5;
		c.ipadx=4;
		c.ipady=8;
		upane[2].add(uf1[2],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=6;
		c.ipadx=4;
		c.ipady=8;
		upane[3].add(ul[3],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=7;
		c.ipadx=4;
		c.ipady=8;
		upane[3].add(uf1[3],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=8;
		c.ipadx=4;
		c.ipady=8;
		upane[4].add(ul[4],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=9;
		c.ipadx=4;
		c.ipady=8;
		upane[4].add(uf1[4],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=10;
		c.ipadx=4;
		c.ipady=8;
		upane[5].add(ul[5],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=11;
		c.ipadx=4;
		c.ipady=8;
		upane[5].add(uf1[5],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=12;
		c.ipadx=4;
		c.ipady=8;
		upane[6].add(ul[6],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=13;
		c.ipadx=4;
		c.ipady=8;
		upane[6].add(uf1[6],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=14;
		c.ipadx=4;
		c.ipady=8;
		upane[7].add(ul[7],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=15;
		c.ipadx=4;
		c.ipady=8;
		upane[7].add(uf1[7],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=16;
		c.ipadx=4;
		c.ipady=8;
		upane[8].add(ul[8],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=17;
		c.ipadx=4;
		c.ipady=8;
		upane[8].add(uf1[8],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=18;
		c.ipadx=4;
		c.ipady=8;
		upane[9].add(ul[9],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=19;
		c.ipadx=4;
		c.ipady=8;
		upane[9].add(uf1[9],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=20;
		c.ipadx=4;
		c.ipady=8;
		upane[10].add(ul[10],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=21;
		c.ipadx=4;
		c.ipady=8;
		upane[10].add(uf1[10],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=22;
		c.ipadx=4;
		c.ipady=8;
		b1 = new JButton("Submit");
		//b1.addActionListener(this);
		b1.setBackground(new Color(128,128,128));
		b1.setForeground(Color.white);
		//upb.add(b1,BorderLayout.CENTER);
		//upb.setBackground(new Color(0,0,0,25));
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=26;
		c.ipadx=24;
		c.ipady=16;
		upane[11].add(b1,c);
		p1 = new JPanel();
		p1.setLayout(new GridLayout(8,2,5,10));
		p1.setBackground(new Color(0,0,0,35));
		for(int i=0;i<12;i++)
		{
			setSize(2000,2000);
			p1.add(upane[i]);
			setSize(2000,2000);
		}
		setLayout(new BorderLayout());
		setSize(2000,2000);
		add(p1,BorderLayout.CENTER);
		setSize(2000,2000);
		setVisible(true);
		b1.addActionListener(new ActionListener() {
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
					stmp=conn.prepareStatement("update trainer set tname=?,taddress=?,date_of_birth=?,mobile_no=?,sex=?,ttype=?,email_id=?,tsal=?,tshift=?,tage=? where tid="+Integer.parseInt(uf1[0].getText()));
					//stmp.setInt(1,Integer.parseInt(uf1[0].getText()));
					stmp.setString(1,uf1[1].getText());
					stmp.setString(2,uf1[2].getText());
					stmp.setString(3,uf1[3].getText());
					stmp.setString(4,uf1[4].getText());
					stmp.setString(5,uf1[5].getText());
					stmp.setString(6,uf1[6].getText());
					stmp.setString(7,uf1[7].getText());
					stmp.setDouble(8,Double.parseDouble(uf1[8].getText()));
					stmp.setString(9,uf1[9].getText());
					stmp.setInt(10,Integer.parseInt(uf1[10].getText()));
					stmp.executeUpdate();
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
		});
		//up1[1].setBackground(Color.black);
		setSize(2000,2000);
	}

}
