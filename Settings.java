import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class Settings extends JPanel implements ActionListener{
	JLabel l[] = new JLabel[8];
	JTextField f[] = new JTextField[8];
	JButton b[] = new JButton[8];
	JPanel p[] = new JPanel[8];
	String s[]= {"Change Login Id","Reset Password"};
	String s1[]= {"Enter previous login id","Enter new login id","Enter password"};
	String s2[]= {"Enter precvious password:","Enter new password","ReEnter new password:"};
	JTabbedPane tp =new JTabbedPane();
	public Settings()
	{
		Font fo =new Font("serif",Font.BOLD,20);
		tp.setFont(fo);
		for(int i=0;i<2;i++)
		{
			p[i]=new JPanel();
			tp.add(p[i],s[i]);
		}
		for(int i=0;i<3;i++)
		{
			l[i] = new JLabel(s1[i]);
			f[i] = new JTextField(15);
			l[i].setFont(fo);
			f[i].setFont(fo);
		}	
		b[0]=new JButton("Save");
		b[0].setFont(fo);
		b[0].setBackground(new Color(128,128,128));
		b[0].setForeground(Color.white);
		p[0].setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=0;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		p[0].add(l[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=1;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		p[0].add(f[0],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=2;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		p[0].add(l[1],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=3;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		p[0].add(f[1],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=4;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		p[0].add(l[2],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=5;
		c.ipadx=4;
		c.ipady=8;
		//c.gridwidth=4;
		p[0].add(f[2],c);
		c.fill = GridBagConstraints.HORIZONTAL;
		c.gridx=0;
		c.gridy=8;
		c.ipadx=2;
		c.ipady=4;
		//c.gridwidth=4;
		p[0].add(b[0],c);
		setLayout(new BorderLayout());
		add(tp,BorderLayout.CENTER);
		b[0].addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				FileWriter fw = null;
				BufferedWriter bw = null;
				try {
				//FileReader fr = new FileReader("m_id");
				BufferedReader br = new BufferedReader(new FileReader("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/login"));
				String s=br.readLine();
				//System.out.println(""+sid);
				if(f[1].getText()==s)
				{
				fw = new FileWriter("/home/omkar/eclipse-workspace/FirstProject/src/BetaVersions/m_id",false);
				bw = new BufferedWriter(fw);
				String s11 = ""+f[1].getText();
				
				//System.out.println(s);
				bw.write(s11);
				}
				else
				{
					//JOptionPane.showMessageDialog(this,"Sorry, Username or Password Error","Login Error!", JOptionPane.ERROR_MESSAGE);
				}
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
	public void actionPerformed(ActionEvent e) {
		
	}

}
