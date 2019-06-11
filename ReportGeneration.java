import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ReportGeneration extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JTabbedPane tp,tp1,tp2,tp3;
	String s[] = {"Member Report","Trainer Report","Machinery Report"};
	String s1[] = {"Member List","Attendance Report"};
	String s2[] = {"By Date","Individual"};
	String t[] = {"Category","Morning Shift","Evening Shift","Refresh","Save"};
	String s3[] = {"Working","Not Working","Refresh","Mainteainence","Save"};
	JPanel mm = new JPanel();
	JButton man[] = new JButton[5];
	JTextField fm = new JTextField(10);
	JTextArea main = new JTextArea();
	JTextField tf = new JTextField(10);
	JPanel  trainer = new JPanel();
	JTextArea tri = new JTextArea();
	JPanel p1[] = new JPanel[2];
	JPanel p2[] = new JPanel[3];
	JPanel p[] = new JPanel[6];
	JButton b6,b7;
	JTextArea a6;
	JButton tb[] = new JButton[6];
	JPanel button = new JPanel();
	JScrollPane scroll1[] = new JScrollPane[9];
	Connection conn,conn1;
	PreparedStatement stmp,stmp1;
	Statement stmt,stmt1;
	ResultSet rs,rs1;
	JTextField sv;
	DefaultTableModel model,model1,model2;
	JTable table,table1,table2;
	JLabel[] att=new JLabel[10];
	String a[] = {"Enter Date","Enter Member id or name:"};
	JTextField at[] = new JTextField[10];
	JTextArea ace[] = new JTextArea[4];
	JButton[] bt = new JButton[4];
	public ReportGeneration()
	{
		Font fo = new Font("Serif", Font.BOLD, 20);
		Font f = new Font("Serif", Font.BOLD,10);
		main.setFont(fo);
		for(int i=0;i<4;i++)
		{
			bt[i]= new JButton(t[i]);
			bt[i].setFont(fo);
		}
		tri.setFont(fo);
		JPanel flow = new JPanel();
		flow.setLayout(new FlowLayout());
		for(int i=0;i<5;i++)
		{
			tb[i] = new JButton(t[i]);
			tb[i].setFont(fo);
			
		}
		tf.setFont(fo);
		flow.add(tb[0]);
		flow.add(tb[1]);
		flow.add(tb[2]);
		flow.add(tb[3]);
		flow.add(tf);
		flow.add(tb[4]);
		trainer.setLayout(new BorderLayout());
		trainer.add(flow,BorderLayout.NORTH);
		scroll1[3] = new JScrollPane(tri);
		
		model = new DefaultTableModel();
		table = new JTable(model);
		table.setFont(f);
		model1 = new DefaultTableModel();
		table1 = new JTable(model1);
		table1.setFont(f);
		trainer.add(table1,BorderLayout.CENTER);
		model2 = new DefaultTableModel();
		table2 = new JTable(model2);
		table2.setFont(f);
		tp2 =new JTabbedPane();
		scroll1[4]= new JScrollPane(main);
		JPanel mach = new JPanel();
		mach.setLayout(new FlowLayout());
		for(int i=0;i<5;i++)
		{
			man[i] = new JButton(s3[i]);
			man[i].setFont(fo);
		}
		fm.setFont(fo);
		mach.add(man[0]);
		mach.add(man[1]);
		mach.add(man[2]);
		mach.add(man[3]);
		mach.add(fm);
		mach.add(man[4]);
		mm.setLayout(new BorderLayout());
		mm.add(mach,BorderLayout.NORTH);
		mm.add(table2,BorderLayout.CENTER);
		for(int i=0;i<2;i++)
		{
			ace[i] = new JTextArea();
			ace[i].setFont(fo);
			att[i] = new JLabel(a[i]);
			at[i] = new JTextField(15);
			att[i].setFont(fo);
			at[i].setFont(fo);
			p2[i] = new JPanel();
			p2[i].setLayout(new BorderLayout());
			p2[i].setBackground(new Color(137,207,240));
			tp2.add(s2[i],p2[i]);
		}
		a6  = new JTextArea();
		a6.setFont(fo);
		scroll1[0] = new JScrollPane(a6);
		scroll1[1] = new JScrollPane(ace[0]);
		scroll1[2] = new JScrollPane(ace[1]);
		
		JPanel n1 = new JPanel(new FlowLayout());
		JButton st = new JButton("Student");
		st.setFont(fo);
		JButton ft = new JButton("Faculty");
		ft.setFont(fo);
		JButton sav0 = new JButton("Save");
		sav0.setFont(fo);
		JButton sub1 = new JButton("Submit");
		sub1.setFont(fo);
		JButton sub2 = new JButton("Submit");
		sub2.setFont(fo);
		//n1.add(st);
		//n1.add(ft);
		n1.add(att[0]);
		n1.add(at[0]);
		n1.add(sub1);
		n1.add(sav0);
		p2[0].add(n1,BorderLayout.NORTH);
		p2[0].add(scroll1[1],BorderLayout.CENTER);
		JPanel n2 = new JPanel(new FlowLayout());
		JButton sav1 = new JButton("Save");
		sav1.setFont(fo);
		n2.add(att[1]);
		n2.add(at[1]);
		n2.add(sub2);
		n2.add(sav1);
		p2[1].add(n2,BorderLayout.NORTH);
		p2[1].add(scroll1[2],BorderLayout.CENTER);
		/*JPanel n3 = new JPanel(new FlowLayout());
		JButton sav2 = new JButton("Save");
		n3.add(att[2]);
		n3.add(at[2]);
		n3.add(sav2);
		p2[2].add(n3,BorderLayout.NORTH);
		p2[2].add(ace[2],BorderLayout.CENTER);*/
		b6 = new JButton("Refresh");
		b7 = new JButton("Save");
		b7.setFont(fo);
		sv = new JTextField(15);
		sv.setFont(fo);
		
		
		b6.setFont(fo);
		tp = new JTabbedPane();
		tp.setFont(fo);
		tp1 = new JTabbedPane();
		tp1.setFont(fo);
		for(int i=0;i<3;i++)
		{
			p[i] = new JPanel();
			p[i].setBackground(new Color(137,207,240));
			tp.add(s[i],p[i]);
		}
		p[1].setLayout(new BorderLayout());
		p[1].add(trainer,BorderLayout.CENTER);
		p[2].setLayout(new BorderLayout());
		p[2].add(mm);
		for(int i=0;i<2;i++)
		{
			p1[i] = new JPanel();
			p1[i].setBackground(new Color(137,207,240));
			tp1.add(s1[i],p1[i]);
		}
		p1[1].setLayout(new BorderLayout());
		p1[1].add(tp2,BorderLayout.CENTER);
		button.setLayout(new FlowLayout());
		button.add(st);
		button.add(ft);
		button.add(b6);
		button.add(sv);
		button.add(b7);
		setLayout(new BorderLayout());
		p[0].setLayout(new BorderLayout());
		p[0].add(tp1,BorderLayout.CENTER);
		add(tp,BorderLayout.CENTER);
		p1[0].setLayout(new BorderLayout());
		p1[0].add(button,BorderLayout.NORTH);
		p1[0].add(table,BorderLayout.CENTER);
		//a6.setLayout(new GridLayout(500,1));
		model.addColumn("Member id");
		model.addColumn("Name");
		model.addColumn("Type");
		model.addColumn("Address");
		model.addColumn("Phone no.");
		model.addColumn("Age");
		model.addColumn("Course namee");
		model.addColumn("Department name");
		model.addColumn("Date of Birth");
		model.addColumn("Height");
		model.addColumn("Weight");
		model.addColumn("Email id");
		model.addColumn("Sex");
		model1.addColumn("Trainer id");
		model1.addColumn("Name");
		model1.addColumn("Address");
		model1.addColumn("Date of Birth");
		model1.addColumn("Phone no.");
		model1.addColumn("Sex");
		model1.addColumn("Categoory");
		model1.addColumn("Email id");
		model1.addColumn("Salary");
		model1.addColumn("Shift");
		model1.addColumn("Age");
		model2.addColumn("Machinery id");
		model2.addColumn("Name");
		model2.addColumn("Type");
		model2.addColumn("Purcharse Date");
		model2.addColumn("Price");
		model2.addColumn("Company");
		try{
			Connection c;
			Statement stmt;
			ResultSet rs;
			Class.forName("org.postgresql.Driver");
			c=DriverManager.getConnection("jdbc:postgresql://localhost/gymmis","postgres","root123");
			stmt=c.createStatement();
			rs=stmt.executeQuery("select * from member");
			while(rs.next())
			{

				//model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12),rs.getString(13)});
				//model1.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDouble(11)});
				//model2.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7)});
			}
		}
		catch(Exception e1)
		{
			System.out.println(e1);
		}
		b6.addActionListener(new ActionListener() {
			
		
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
						stmt = conn.createStatement();
						rs =  stmt.executeQuery("select * from member");
						setSize(2000,2000);
						if(!rs.next())
						{
							p1[0].removeAll();
							setSize(2000,2000);
							p1[0].add(button,BorderLayout.NORTH);
							//setSize(2000,2000);
							//p[2].remove(mu);
							p1[0].setSize(1200,1200);
							p1[0].add(scroll1[0],BorderLayout.CENTER);
							setSize(2000,2000);
						}
						else
						{
							int i=1;
							a6.setText("");
							//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
							//a6.setText(cn);
							table.removeAll();
							model.setRowCount(0);
						do
						{
						//setSize(2000,2000);
							System.out.println(""+rs.getInt(1));
						model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12),rs.getString(13)});	
						String s="\n\t["+i+"]\n\t[Id:"+rs.getInt(1)+"]\n\t[Name:"+rs.getString(2)+"]\n\t[Type:"+rs.getString(3)+"]\n\t[Address:"+rs.getString(4)+"]\n\t[Phone no.:"+rs.getString(5)+"]\n\t[Age:"+rs.getInt(6)+"]\n\t[Course:"+rs.getString(7)+"]\n\t[Department:"+rs.getString(8)+"]\n\t[Date of Birth"+rs.getString(9)+"]\n\t[Height:"+rs.getDouble(10)+"]\n\t[Weight:"+rs.getDouble(11)+"]\n\t[Email id:"+rs.getString(12)+"]\n\t[Sex:"+rs.getString(13)+"]\n\n";
						a6.setText(a6.getText()+s);
						scroll1[0].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						i++;
						}while(rs.next());
						table.getModel();
						a6.setText(a6.getText()+"\n\n\tTotal Membert are:"+(i-1));
						//table.setFont(fo);
						//setSize(2000,2000);
						setSize(2000,2000);
						p1[0].removeAll();
						setSize(2000,2000);
						p1[0].add(button,BorderLayout.NORTH);
						//setSize(2000,2000);
						//p[2].remove(mu);
						p1[0].setSize(1200,1200);
						p1[0].add(new JScrollPane(table),BorderLayout.CENTER);
						p1[0].setSize(1200,1200);
						setSize(2000,2000);
						}
						//model.removeRow(b);
						//setSize(2000,2000);
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
				
				
			}
		});
		tb[3].addActionListener(new ActionListener() {
			
			
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
						stmt = conn.createStatement();
						rs =  stmt.executeQuery("select * from trainer");
						setSize(2000,2000);
						if(!rs.next())
						{
							trainer.removeAll();
							setSize(2000,2000);
							trainer.add(flow,BorderLayout.NORTH);
							//setSize(2000,2000);
							//p[2].remove(mu);
							trainer.setSize(1200,1200);
							p[1].setSize(1200,1200);
							trainer.add(table1,BorderLayout.CENTER);
							setSize(2000,2000);
						}
						else
						{
							int i=1;
							tri.setText("");
							//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
							//a6.setText(cn);
							model1.setRowCount(0);
							
						do
						{
							
						//setSize(2000,2000);
							System.out.println(""+rs.getInt(1));
							
							//model.addColumn("Weight");
							//model.addColumn("Email id");
							//model.addColumn("Sex");
							//model1.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDouble(11)});
							model1.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getString(10),rs.getDouble(11)});
						String s="\n\t["+i+"]\n\t[Id:"+rs.getInt(1)+"]\n\t[Name:"+rs.getString(2)+"]\n\t[address:"+rs.getString(3)+"]\n\t[Date of Birth.:"+rs.getString(4)+"]\n\t[Phone no:"+rs.getString(5)+"]\n\t[Sex:"+rs.getString(6)+"]\n\t[Category:"+rs.getString(7)+"]\n\t[Email Id"+rs.getString(8)+"]\n\t[Salary:"+rs.getString(9)+"]\n\t[Shift:"+rs.getString(10)+"]\n\t[Age:"+rs.getDouble(11)+"]\n\n";
						tri.setText(tri.getText()+s);
						scroll1[0].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						i++;
						}while(rs.next());
						tri.setText(tri.getText()+"\n\n\tTotal Trainer are:"+(i-1));
						//table.setFont(fo);
						//setSize(2000,2000);
						setSize(2000,2000);
						trainer.removeAll();
						setSize(2000,2000);
						trainer.add(flow,BorderLayout.NORTH);
						//setSize(2000,2000);
						//p[2].remove(mu);
						trainer.setSize(1200,1200);
						p[1].setSize(1200,1200);
						trainer.add(new JScrollPane(table1),BorderLayout.CENTER);
						trainer.setSize(1600,1600);
						setSize(2000,2000);
						
						}
						//setSize(2000,2000);
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
				
				
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				try {
				//FileReader fr = new FileReader("m_id");
					String fn = sv.getText();
				//BufferedReader br = new BufferedReader(new FileReader("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn));
				//sid=Integer.parseInt(br.readLine());
				//System.out.println(""+sid);
				//sid=sid+1;
				fw = new FileWriter("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn,false);
				bw = new BufferedWriter(fw);
				//String s = ""+sid;
				//System.out.println(s);
				bw.write(a6.getText());

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
			}
		});
		st.addActionListener(new ActionListener() {
			
			
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
						stmt = conn.createStatement();
						rs =  stmt.executeQuery(" select course_name,count(*) from member group by(course_name)");
						
						setSize(2000,2000);
						if(!rs.next())
						{
							p1[0].removeAll();
							setSize(2000,2000);
							p1[0].add(button,BorderLayout.NORTH);
							//setSize(2000,2000);
							//p[2].remove(mu);
							p1[0].setSize(1200,1200);
							p1[0].add(scroll1[0],BorderLayout.CENTER);
							p1[0].setSize(1200,1200);
							setSize(2000,2000);
						}
						else
						{
							int i=1;
							a6.setText("");
							//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
							//a6.setText(cn);
						do
						{
						//setSize(2000,2000);
							//System.out.println(""+rs.getInt(1));
						
						String s="\n\t["+i+"]\n\t[Course Name:"+rs.getString(1)+"]\n\t[Total Students:"+rs.getInt(2)+"]\n\n";
						/*model.addColumn("Member id");
						model.addColumn("Name");
						model.addColumn("Type");
						model.addColumn("Address");
						model.addColumn("Phone no.");
						model.addColumn("Age");
						model.addColumn("Course namee");
						model.addColumn("Department name");
						model.addColumn("Date of Birth");
						model.addColumn("Height");
						model.addColumn("Weight");
						model.addColumn("Email id");
						model.addColumn("Sex");
						model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12),rs.getString(13)});*/
						a6.setText(a6.getText()+s);
				        scroll1[0].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						//table.setFont(fo);
						//setSize(2000,2000);
						setSize(2000,2000);
						p1[0].removeAll();
						setSize(2000,2000);
						p1[0].add(button,BorderLayout.NORTH);
						//setSize(2000,2000);
						//p[2].remove(mu);
						p1[0].setSize(1200,1200);
						p1[0].add(scroll1[0],BorderLayout.CENTER);
						setSize(2000,2000);
						i++;
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
man[0].addActionListener(new ActionListener() {
			
			
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
						stmt = conn.createStatement();
						rs =  stmt.executeQuery("select machinery_id,m_name,m_type from machineries where m_status='Working'");
						
						setSize(2000,2000);
						if(!rs.next())
						{
							mm.removeAll();
							setSize(2000,2000);
							mm.add(mach,BorderLayout.NORTH);
							//setSize(2000,2000);
							//p[2].remove(mu);
							mm.setSize(1600,1600);
							mm.add(scroll1[4],BorderLayout.CENTER);
							setSize(2000,2000);
						}
						else
						{
							int i=1;
							main.setText("");
							//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
							//a6.setText(cn);
						do
						{
						//setSize(2000,2000);
							//System.out.println(""+rs.getInt(1));
						
						String s="\n\t["+i+"]\n\t[Machinery id:"+rs.getInt(1)+"]\n\t[name:"+rs.getString(2)+"]\n\t[Type:"+rs.getString(3)+"]\n";
						/*model.addColumn("Member id");
						model.addColumn("Name");
						model.addColumn("Type");
						model.addColumn("Address");
						model.addColumn("Phone no.");
						model.addColumn("Age");
						model.addColumn("Course namee");
						model.addColumn("Department name");
						model.addColumn("Date of Birth");
						model.addColumn("Height");
						model.addColumn("Weight");
						model.addColumn("Email id");
						model.addColumn("Sex");
						model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12),rs.getString(13)});*/
						main.setText(main.getText()+s);
				        scroll1[4].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				        i++;
						}while(rs.next());
						main.setText(main.getText()+"\tTotal Working machines:"+(i-1));
						//table.setFont(fo);
						//setSize(2000,2000);
						setSize(2000,2000);
						mm.removeAll();
						setSize(2000,2000);
						mm.add(mach,BorderLayout.NORTH);
						//setSize(2000,2000);
						//p[2].remove(mu);
						mm.setSize(1600,1600);
						mm.add(scroll1[4],BorderLayout.CENTER);
						setSize(2000,2000);
						}
						//setSize(2000,2000);
					}
				}catch(Exception e1)
				{
					System.out.println(e1);
				}
				
			}
		});
man[1].addActionListener(new ActionListener() {
	
	
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
				stmt = conn.createStatement();
				rs =  stmt.executeQuery("select machinery_id,m_name,m_type from machineries where m_status='Not Working'");
				
				setSize(2000,2000);
				if(!rs.next())
				{
					mm.removeAll();
					setSize(2000,2000);
					mm.add(mach,BorderLayout.NORTH);
					//setSize(2000,2000);
					//p[2].remove(mu);
					mm.setSize(1200,1200);
					mm.add(scroll1[4],BorderLayout.CENTER);
					setSize(2000,2000);
				}
				else
				{
					int i=1;
					main.setText("");
					//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
					//a6.setText(cn);
				do
				{
				//setSize(2000,2000);
					//System.out.println(""+rs.getInt(1));
				
				String s="\n\t["+i+"]\n\t[Machinery id:"+rs.getInt(1)+"]\n\t[name:"+rs.getString(2)+"]\n\t[Type:"+rs.getString(3)+"]\n";
				/*model.addColumn("Member id");
				model.addColumn("Name");
				model.addColumn("Type");
				model.addColumn("Address");
				model.addColumn("Phone no.");
				model.addColumn("Age");
				model.addColumn("Course namee");
				model.addColumn("Department name");
				model.addColumn("Date of Birth");
				model.addColumn("Height");
				model.addColumn("Weight");
				model.addColumn("Email id");
				model.addColumn("Sex");
				model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12),rs.getString(13)});*/
				main.setText(main.getText()+s);
		        scroll1[4].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        i++;
				}while(rs.next());
				main.setText(main.getText()+"\tTotal Not Working machines:"+(i-1));
				//table.setFont(fo);
				//setSize(2000,2000);
				setSize(2000,2000);
				mm.removeAll();
				setSize(2000,2000);
				mm.add(mach,BorderLayout.NORTH);
				//setSize(2000,2000);
				//p[2].remove(mu);
				mm.setSize(1600,1600);
				mm.add(scroll1[4],BorderLayout.CENTER);
				setSize(2000,2000);
				}
				//setSize(2000,2000);
			}
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
});
man[2].addActionListener(new ActionListener() {
	
	
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
				stmt = conn.createStatement();
				rs =  stmt.executeQuery("select * from machineries");
				
				setSize(2000,2000);
				if(!rs.next())
				{
					mm.removeAll();
					setSize(2000,2000);
					mm.add(mach,BorderLayout.NORTH);
					//setSize(2000,2000);
					//p[2].remove(mu);
					mm.setSize(1600,1600);
					mm.add(table2,BorderLayout.CENTER);
					setSize(2000,2000);
				}
				else
				{
					int i=1;
					main.setText("");
					//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
					//a6.setText(cn);
					model2.setRowCount(0);
				do
				{
				//setSize(2000,2000);
					//System.out.println(""+rs.getInt(1));
				model2.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(7)});
				String s="\n\t["+i+"]\n\t[Machinery id:"+rs.getInt(1)+"]\n\t[name:"+rs.getString(2)+"]\n\t[Type:"+rs.getString(3)+"]\n\t[Purchase Date:"+rs.getString(4)+"]\n\t[Price:"+rs.getString(5)+"]\n\t[Company:"+rs.getString(7)+"]\n\n";
				/*model.addColumn("Member id");
				model.addColumn("Name");
				model.addColumn("Type");
				model.addColumn("Address");
				model.addColumn("Phone no.");
				model.addColumn("Age");
				model.addColumn("Course namee");
				model.addColumn("Department name");
				model.addColumn("Date of Birth");
				model.addColumn("Height");
				model.addColumn("Weight");
				model.addColumn("Email id");
				model.addColumn("Sex");
				model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12),rs.getString(13)});*/
				main.setText(main.getText()+s);
		        scroll1[4].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        i++;
				}while(rs.next());
				main.setText(main.getText()+"\tTotal machines:"+(i-1));
				//table.setFont(fo);
				//setSize(2000,2000);
				setSize(2000,2000);
				mm.removeAll();
				setSize(2000,2000);
				mm.add(mach,BorderLayout.NORTH);
				//setSize(2000,2000);
				//p[2].remove(mu);
				mm.setSize(1600,1600);
				p[2].setSize(1200,1200);
				mm.add(new JScrollPane(table2),BorderLayout.CENTER);
				mm.setSize(1600,1600);
				setSize(2000,2000);
				}
				//setSize(2000,2000);
			}
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
});
man[3].addActionListener(new ActionListener() {
	
	
	public void actionPerformed(ActionEvent e) {
		try
		{
			
			int b=0;
			Class.forName("org.postgresql.Driver");
			conn=DriverManager.getConnection("jdbc:postgresql://localhost/gymmis","postgres","root123");
			if(conn==null)
			{
				System.out.println("Connection failed"); 
			}
			else
			{
				stmt = conn.createStatement();
				rs =  stmt.executeQuery("select * from maintainence");
				setSize(2000,2000);
				if(!rs.next())
				{
					mm.removeAll();
					setSize(2000,2000);
					mm.add(mach,BorderLayout.NORTH);
					//setSize(2000,2000);
					//p[2].remove(mu);
					mm.setSize(1600,1600);
					mm.add(scroll1[4],BorderLayout.CENTER);
					setSize(2000,2000);
				}
				else
				{
					int i=1;
					main.setText("");
					//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
					//a6.setText(cn);
				do
				{
				//setSize(2000,2000);
					//System.out.println(""+rs.getInt(1));
				
				String s="\n\t["+i+"]\n\t[Machinery id:"+rs.getInt(1)+"]\n\t[date:"+rs.getString(2)+"]\n\t[description:"+rs.getString(3)+"]\n\t[budget:"+rs.getString(4)+"]\n\n";
				/*model.addColumn("Member id");
				model.addColumn("Name");
				model.addColumn("Type");
				model.addColumn("Address");
				model.addColumn("Phone no.");
				model.addColumn("Age");
				model.addColumn("Course namee");
				model.addColumn("Department name");
				model.addColumn("Date of Birth");
				model.addColumn("Height");
				model.addColumn("Weight");
				model.addColumn("Email id");
				model.addColumn("Sex");
				model.addRow(new Object[] {rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getInt(6),rs.getString(7),rs.getString(8),rs.getString(9),rs.getDouble(10),rs.getDouble(11),rs.getString(12),rs.getString(13)});*/
				main.setText(main.getText()+s);
		        scroll1[4].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        b = b+Integer.parseInt(rs.getString(4));
		        i++;
				}while(rs.next());
				main.setText(main.getText()+"\tTotal Maintainence Budget="+b+"\n\tTotal maintained machines:"+(i-1));
				//table.setFont(fo);
				//setSize(2000,2000);
				setSize(2000,2000);
				mm.removeAll();
				setSize(2000,2000);
				mm.add(mach,BorderLayout.NORTH);
				//setSize(2000,2000);
				//p[2].remove(mu);
				mm.setSize(1600,1600);
				mm.add(scroll1[4],BorderLayout.CENTER);
				setSize(2000,2000);
				}
				//setSize(2000,2000);
			}
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
});
		ft.addActionListener(new ActionListener() {
			
			
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
						stmt = conn.createStatement();
						rs =  stmt.executeQuery(" select department_name,count(*) from member group by(department_name)");
						setSize(2000,2000);
						if(!rs.next())
						{
							p1[0].removeAll();
							setSize(2000,2000);
							p1[0].add(button,BorderLayout.NORTH);
							//setSize(2000,2000);
							//p[2].remove(mu);
							p1[0].setSize(1200,1200);
							p1[0].add(scroll1[0],BorderLayout.CENTER);
							setSize(2000,2000);
						}
						else
						{
							int i=1;
							a6.setText("");
							//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
							//a6.setText(cn);
						do
						{
						//setSize(2000,2000);
							//System.out.println(""+rs.getInt(1));
						
						String s="\n\t["+i+"]\n\t[Department Name:"+rs.getString(1)+"]\n\t[Total Staff:"+rs.getInt(2)+"]\n\n";
						a6.setText(a6.getText()+s);
				        scroll1[0].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						//table.setFont(fo);
						//setSize(2000,2000);
						setSize(2000,2000);
						p1[0].removeAll();
						setSize(2000,2000);
						p1[0].add(button,BorderLayout.NORTH);
						//setSize(2000,2000);
						//p[2].remove(mu);
						p1[0].setSize(1200,1200);
						p1[0].add(scroll1[0],BorderLayout.CENTER);
						setSize(2000,2000);
						i++;
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
sub1.addActionListener(new ActionListener() {
			
			
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
						stmt = conn.createStatement();
						rs =  stmt.executeQuery(" select member.m_id,m_name,member_type,in_time,out_time,date from member,attendance where attendance.m_id=member.m_id and date='"+at[0].getText()+"'");
						setSize(2000,2000);
						if(!rs.next())
						{
							ace[0].setText(at[0].getText()+" Record not found");
							p2[0].removeAll();
							setSize(2000,2000);
							p2[0].add(n1,BorderLayout.NORTH);
							//setSize(2000,2000);
							//p[2].remove(mu);
							p2[0].setSize(1200,1200);
							p2[0].add(scroll1[1],BorderLayout.CENTER);
							setSize(2000,2000);
						}
						else
						{
							int i=1;
							ace[0].setText("");
							//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
							//a6.setText(cn);
						do
						{
						//setSize(2000,2000);
							//System.out.println(""+rs.getInt(1));
						
						String s="\n\t["+i+"]\n\t[Member Id:"+rs.getInt(1)+"]\n\t[Member Name:"+rs.getString(2)+"]\n\t[Member Type:"+rs.getString(3)+"]\n\t[In Time:"+rs.getString(4)+"]\n\t[Out time:"+rs.getString(5)+"]\n\t[Date:"+rs.getString(6)+"]\n\n";
						ace[0].setText(ace[0].getText()+s);
				        scroll1[1].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
						//table.setFont(fo);
						//setSize(2000,2000);
						setSize(2000,2000);
						p2[0].removeAll();
						setSize(2000,2000);
						p2[0].add(n1,BorderLayout.NORTH);
						//setSize(2000,2000);
						//p[2].remove(mu);
						p2[0].setSize(1200,1200);
						p2[0].add(scroll1[1],BorderLayout.CENTER);
						setSize(2000,2000);
						i++;
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
sub2.addActionListener(new ActionListener() {
	
	
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
				stmt = conn.createStatement();
				rs =  stmt.executeQuery(" select member.m_id,m_name,member_type,in_time,out_time,date from member,attendance where attendance.m_id=member.m_id and member.m_id="+Integer.parseInt(at[1].getText()));
				setSize(2000,2000);
				if(!rs.next())
				{
					ace[1].setText(Integer.parseInt(at[1].getText())+" Record not found");
					p2[1].removeAll();
					setSize(2000,2000);
					p2[1].add(n2,BorderLayout.NORTH);
					//setSize(2000,2000);
					//p[2].remove(mu);
					p2[1].setSize(1200,1200);
					p2[1].add(scroll1[2],BorderLayout.CENTER);
					setSize(2000,2000);
				}
				else
				{
					int i=1;
					ace[1].setText("");
					//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
					//a6.setText(cn);
				do
				{
				//setSize(2000,2000);
					//System.out.println(""+rs.getInt(1));
				
				String s="\n\t["+i+"]\n\t[Member Id:"+rs.getInt(1)+"]\n\t[Member Name:"+rs.getString(2)+"]\n\t[Member Type:"+rs.getString(3)+"]\n\t[In Time:"+rs.getString(4)+"]\n\t[Out time:"+rs.getString(5)+"]\n\t[Date:"+rs.getString(6)+"]\n\n";
				ace[1].setText(ace[1].getText()+s);
		        scroll1[2].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				//table.setFont(fo);
				//setSize(2000,2000);
				setSize(2000,2000);
				p2[1].removeAll();
				setSize(2000,2000);
				p2[1].add(n2,BorderLayout.NORTH);
				//setSize(2000,2000);
				//p[2].remove(mu);
				p2[1].setSize(1200,1200);
				p2[1].add(scroll1[2],BorderLayout.CENTER);
				setSize(2000,2000);
				i++;
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
tb[0].addActionListener(new ActionListener() {
	
	
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
				stmt = conn.createStatement();
				rs =  stmt.executeQuery(" select ttype,count(*) from trainer group by(ttype)");
				setSize(2000,2000);
				if(!rs.next())
				{
					tri.setText(" Record not found");
					trainer.removeAll();
					setSize(2000,2000);
					trainer.add(flow,BorderLayout.NORTH);
					//setSize(2000,2000);
					//p[2].remove(mu);
					trainer.setSize(1200,1200);
					trainer.add(scroll1[3],BorderLayout.CENTER);
					setSize(2000,2000);
				}
				else
				{
					int i=1;
					tri.setText("");
					//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
					//a6.setText(cn);
				do
				{
				//setSize(2000,2000);
					//System.out.println(""+rs.getInt(1));
				
				String s="\n\t["+i+"]\n\t[Catagory:"+rs.getString(1)+"]\n\t[Available:"+rs.getInt(2)+"]\n\n";
				tri.setText(tri.getText()+s);
		        scroll1[3].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				//table.setFont(fo);
				//setSize(2000,2000);
				setSize(2000,2000);
				trainer.removeAll();
				setSize(2000,2000);
				trainer.add(flow,BorderLayout.NORTH);
				//setSize(2000,2000);
				//p[2].remove(mu);
				trainer.setSize(1600,1600);
				trainer.add(scroll1[3],BorderLayout.CENTER);
				setSize(2000,2000);
				i++;
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
tb[1].addActionListener(new ActionListener() {
	
	
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
				stmt = conn.createStatement();
				rs =  stmt.executeQuery(" select * from trainer where tshift='morning'");
				setSize(2000,2000);
				if(!rs.next())
				{
					tri.setText(" Record not found");
					trainer.removeAll();
					setSize(2000,2000);
					trainer.add(flow,BorderLayout.NORTH);
					//setSize(2000,2000);
					//p[2].remove(mu);
					trainer.setSize(1600,1600);
					trainer.add(scroll1[3],BorderLayout.CENTER);
					setSize(2000,2000);
				}
				else
				{
					int i=1;
					tri.setText("");
					//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
					//a6.setText(cn);
				do
				{
				//setSize(2000,2000);
					//System.out.println(""+rs.getInt(1));
				
				String s="\n\t["+i+"]\n\t[Trainer Id:"+rs.getInt(1)+"]\n\t[Name:"+rs.getString(2)+"]\n\n";
				tri.setText(tri.getText()+s);
		        scroll1[3].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        i++;
				}while(rs.next());
				tri.setText(tri.getText()+"\n\tTotal Trainers in moring batch:"+(i-1));
				//table.setFont(fo);
				//setSize(2000,2000);
				setSize(2000,2000);
				trainer.removeAll();
				setSize(2000,2000);
				trainer.add(flow,BorderLayout.NORTH);
				//setSize(2000,2000);
				//p[2].remove(mu);
				trainer.setSize(1600,1600);
				trainer.add(scroll1[3],BorderLayout.CENTER);
				setSize(2000,2000);
				
				}
				//setSize(2000,2000);
			}
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
});
tb[2].addActionListener(new ActionListener() {
	
	
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
				stmt = conn.createStatement();
				rs =  stmt.executeQuery(" select * from trainer where tshift='evening'");
				setSize(2000,2000);
				if(!rs.next())
				{
					tri.setText(" Record not found");
					trainer.removeAll();
					setSize(2000,2000);
					trainer.add(flow,BorderLayout.NORTH);
					//setSize(2000,2000);
					//p[2].remove(mu);
					trainer.setSize(1200,1200);
					trainer.add(scroll1[3],BorderLayout.CENTER);
					setSize(2000,2000);
				}
				else
				{
					int i=1;
					tri.setText("");
					//String cn="No.\tMember id\tName\t\tType\t\tAddress\t\t\tPhone no.\tAge\tCourse\tDepartment\tDate of Birth\tHeight\t\tWeight\t\tEmail id\tSex\n";
					//a6.setText(cn);
				do
				{
				//setSize(2000,2000);
					//System.out.println(""+rs.getInt(1));
				
				String s="\n\t["+i+"]\n\t[Trainer Id:"+rs.getInt(1)+"]\n\t[Name:"+rs.getString(2)+"]\n\n";
				tri.setText(tri.getText()+s);
		        scroll1[3].setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		        i++;
				}while(rs.next());
				tri.setText(tri.getText()+"\n\tTotal Trainers in evening batch:"+(i-1));
				//table.setFont(fo);
				//setSize(2000,2000);
				setSize(2000,2000);
				trainer.removeAll();
				setSize(2000,2000);
				trainer.add(flow,BorderLayout.NORTH);
				//setSize(2000,2000);
				//p[2].remove(mu);
				trainer.setSize(1600,1600);
				trainer.add(scroll1[3],BorderLayout.CENTER);
				setSize(2000,2000);
				
				}
				//setSize(2000,2000);
			}
		}catch(Exception e1)
		{
			System.out.println(e1);
		}
		
	}
});
sav0.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
		//FileReader fr = new FileReader("m_id");
			String fn = at[0].getText();
		//BufferedReader br = new BufferedReader(new FileReader("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn));
		//sid=Integer.parseInt(br.readLine());
		//System.out.println(""+sid);
		//sid=sid+1;
		fw = new FileWriter("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn,false);
		bw = new BufferedWriter(fw);
		//String s = ""+sid;
		//System.out.println(s);
		bw.write(ace[0].getText());

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
	}
});
sav1.addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
		//FileReader fr = new FileReader("m_id");
			String fn = at[1].getText();
		//BufferedReader br = new BufferedReader(new FileReader("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn));
		//sid=Integer.parseInt(br.readLine());
		//System.out.println(""+sid);
		//sid=sid+1;
		fw = new FileWriter("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn,false);
		bw = new BufferedWriter(fw);
		//String s = ""+sid;
		//System.out.println(s);
		bw.write(ace[1].getText());

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
	}
});
tb[4].addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
		//FileReader fr = new FileReader("m_id");
			String fn = tf.getText();
		//BufferedReader br = new BufferedReader(new FileReader("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn));
		//sid=Integer.parseInt(br.readLine());
		//System.out.println(""+sid);
		//sid=sid+1;
		fw = new FileWriter("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn,false);
		bw = new BufferedWriter(fw);
		//String s = ""+sid;
		//System.out.println(s);
		bw.write(tri.getText());
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
	}
});
man[4].addActionListener(new ActionListener() {
	public void actionPerformed(ActionEvent e) {
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
		//FileReader fr = new FileReader("m_id");
			String fn = fm.getText();
		//BufferedReader br = new BufferedReader(new FileReader("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn));
		//sid=Integer.parseInt(br.readLine());
		//System.out.println(""+sid);
		//sid=sid+1;
		fw = new FileWriter("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/"+fn,false);
		bw = new BufferedWriter(fw);
		//String s = ""+sid;
		//System.out.println(s);
		bw.write(main.getText());
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
	}
});
	}
}
