package parkingManagementSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
//import java.awt.Insets;

public class Login {
	//ImageIcon backgroundImage = new ImageIcon("/home/manav/eclipse-workspace/ParkingManagementSystem/src/images/login.jpeg");
	JFrame loginScreen = new JFrame();
	JLabel backImage = new JLabel();
	JButton nextButton = new JButton("Next");

	Login(){
	//this.loginScreen.setResizable(false);
	this.loginScreen.setLayout(null);
	this.backImage.setIcon(new ImageIcon("/home/manav/eclipse-workspace/ParkingManagementSystem/src/images/login.jpeg"));
	this.backImage.setBounds(0,0,600, 390);
	this.nextButton.setBounds(450,305,100,28);
	this.nextButton.setBackground(new Color(0,0,0));
	this.nextButton.setBorderPainted(false);
	this.nextButton.setForeground(new Color(255,255,255));
	this.loginScreen.add(nextButton);
	this.loginScreen.add(backImage);
	this.nextButton.setFocusable(false);
	this.nextButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource()==nextButton) {
				new SignInScreen();
				loginScreen.setVisible(false);
			}
		}
	});
	//this.loginScreen.pack();
	this.loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	this.loginScreen.setSize(600, 37+ 390);
	//Insets i = loginScreen.getInsets();
	//System.out.println(i);
	//this.loginScreen.setUndecorated(true);
	}
	
	public static void main(String[] args) {
	Login Screen1 = new Login();
	Screen1.loginScreen.setVisible(true);

	}

}
