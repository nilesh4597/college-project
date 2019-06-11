import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.imageio.IIOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import java.time.LocalTime;
import java.time.LocalDate;

public class Attendance extends JFrame{
		JTabbedPane tp = new  JTabbedPane();
		JPanel p[] = new JPanel[2];
		String s[] = {"Attendance","Workout"};
		JTextField f = new  JTextField(10);
		JTextField f1 = new JTextField(10);
		JButton b[] = new JButton[3];
		String sb[]= {"In","Out","Search"};
		JLabel l = new JLabel("Member Id:");
		JPanel fl[] = new JPanel[5];
		 Connection conn,conn1;
	        PreparedStatement stmp,stmp1;
	        Statement stmt;
		public Attendance() throws IOException,IIOException
		{
			//setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(" setContentPane(new JLabel(new ImageIcon(ImageIO.read(new File(\"/home/omkar/Downloads/WHYWORLDGYM11.jpg")))));
			Font fo = new Font("Serif", Font.BOLD, 20);
			tp.setFont(fo);
			l.setFont(fo);
			for(int i=0;i<2;i++)
			{
				p[i] = new JPanel();
				p[i].setBackground(new Color(0,0,0,10));
				tp.add(s[i],p[i]);
			}
			tp.setBackground(new Color(0,0,0,10));
			for(int i=0;i<3;i++)
			{
				b[i] = new JButton(sb[i]);
				b[i].setFont(fo);
				b[i].setBackground(new Color(128,128,128));
				b[i].setForeground(Color.white);
			}
				fl[0] = new JPanel();
				fl[0].setBackground(new Color(0,0,0,10));
				fl[0].setLayout(new GridBagLayout());
				fl[1] = new JPanel();
				fl[1].setBackground(new Color(0,0,0,10));
				fl[1].setLayout(new GridLayout(1,2,10,10));
				fl[1].add(b[0]);
				fl[1].add(b[1]);
				
			f.setFont(fo);
			f1.setFont(fo);
			setLayout(new BorderLayout());
			add(tp,BorderLayout.CENTER);
			GridBagConstraints c= new GridBagConstraints();
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=0;
			c.ipadx=14;
			c.ipady=28;
			fl[0].add(l,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=2;
			c.ipadx=14;
			c.ipady=28;
			fl[0].add(f,c);
			c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=0;
			c.gridy=4;
			c.ipadx=12;
			c.ipady=28;
			fl[0].add(fl[1],c);
			/*c.fill = GridBagConstraints.HORIZONTAL;
			c.gridx=1;
			c.gridy=2;
			c.ipadx=2;
			c.ipady=8;
			fl[0].add(b[1],c);*/
			p[0].setLayout(new BorderLayout());
			//p[0].add(f);
			//p[0].add(b[0]);
			//p[0].add(b[1]);
			//for(int i=0;i<3;i++)
			//{
				p[0].add(fl[0],BorderLayout.CENTER);
			//}
			setVisible(true);
			setSize(2000,2000);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			b[0].addActionListener(new ActionListener() {
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

                                     int id = Integer.parseInt(f.getText());
                                     LocalTime c= LocalTime.now();
                                        String c1=c.toString();
				    System.out.println("Out time:"+c1);

                                         LocalDate d= LocalDate.now();
                                        String c2=d.toString();

                                     stmp = conn.prepareStatement("insert into attendance values(?,?,?,?)");
                                     stmp.setInt(1,id);
                                     stmp.setString(2,c1);
                                     stmp.setString(3,"");
                                     stmp.setString(4,c2);
                                     stmp.executeUpdate();
                             }
                     }catch(Exception e1)
		{
                             System.out.println(e1);
                     }

					
				}
			});
			b[1].addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
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

                                     int id = Integer.parseInt(f.getText());
                                     LocalTime c= LocalTime.now();
                                        String c1=c.toString();
				   System.out.println("Out time:"+c1);
                                         LocalDate d= LocalDate.now();
                                        String c2=d.toString();

                                     stmp1 = conn1.prepareStatement("update attendance set out_time=? where m_id="+id);
				 stmp1.setString(1,c1);
				 stmp1.executeUpdate();
                             }
                     }catch(Exception e1)
                     {
                             System.out.println(e1);
                     }
				}
			});
		}
		public static void main(String[] a)throws IOException,IIOException {
			new Attendance();
		}
}
