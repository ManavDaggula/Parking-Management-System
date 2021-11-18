package parkingManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
//import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInScreen {
	
	JLabel uname,pwd,userImage;
	JTextField unameInput;
	JPasswordField pwdInput;
	JFrame f;
	JButton subButton, closeButton;
	
	SignInScreen(){
		f = new JFrame();
		f.getContentPane().setBackground(Color.WHITE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		f.setBounds((d.width-550)/2,(d.height-400)/2,550,400);
		
		userImage = new JLabel();
		userImage.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/UserIcon.png")));
		userImage.setBounds(270,50,225,225);
		f.add(userImage);

		uname = new JLabel("Username");
		uname.setBounds(20,100,70,40);
		f.add(uname);
		
		pwd = new JLabel("Password");
		pwd.setBounds(20,170,70,40);
		f.add(pwd);

		unameInput = new JTextField();
		unameInput.setBounds(100, 100, 150, 40);
		f.add(unameInput);
		
		pwdInput = new JPasswordField();
		pwdInput.setBounds(100, 170, 150, 40);
		f.add(pwdInput);
		
		subButton = new JButton("Submit");
		subButton.setBounds(35,250,100,40);
		subButton.setBackground(new Color(10,10,10));
		subButton.setForeground(new Color(240,240,240));
		subButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent ae) {
				ConnectionToMySQL c = new ConnectionToMySQL();
				String usname, passwd;
				usname = unameInput.getText();
				passwd = pwdInput.getText();
				try {
					ResultSet rs = c.s.executeQuery("select * from login where username = '" + usname + "' and password = '" + passwd + "';");
					if(rs.next()) {
						//new MenuPage();
						new Dashboard().setVisible(true);
						f.dispose();
					}
					else {
						JOptionPane.showMessageDialog(f,"Enter valid credentials");
						//System.out.println("nope");
					}
				} catch (Exception e) {
					
				}
				
				
			}
		});
		f.add(subButton);
				
		closeButton = new JButton("Cancel");
		closeButton.setBounds(150,250,100,40);
		closeButton.setBackground(new Color(10,10,10));
		closeButton.setForeground(new Color(240,240,240));
		closeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				if (ae.getSource()==closeButton) {
					System.exit(0);}
				}
		});
		f.add(closeButton);
				
		f.setLayout(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String args[]) {
		new SignInScreen();
	}
}
