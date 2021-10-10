package parkingManagementSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class SignInScreen {
	
	JLabel uname,pwd;
	JTextField unameInput;
	JPasswordField pwdInput;
	JFrame f;
	JButton subButton, closeButton;
	
	SignInScreen(){
		f = new JFrame();
		f.setBounds(200,200,500,500);
		
		uname = new JLabel("Username");
		uname.setBounds(90,100,90,40);
		f.add(uname);
		
		pwd = new JLabel("Password");
		pwd.setBounds(90,170,90,40);
		f.add(pwd);
		
		unameInput = new JTextField();
		unameInput.setBounds(190, 100, 150, 40);
		f.add(unameInput);
		
		pwdInput = new JPasswordField();
		pwdInput.setBounds(190, 170, 150, 40);
		f.add(pwdInput);
		
		subButton = new JButton("Submit");
		subButton.setBounds(100,250,100,40);
		subButton.setBackground(new Color(10,10,10));
		subButton.setForeground(new Color(240,240,240));
		f.add(subButton);
		
		closeButton = new JButton("Close");
		closeButton.setBounds(220,250,100,40);
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
