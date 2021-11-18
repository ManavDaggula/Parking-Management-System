package parkingManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
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
	JLabel welcome = new JLabel("Welcome to Parking System");
	Login(){
	//this.loginScreen.setResizable(false);
	loginScreen.setLayout(null);
	backImage.setIcon(new ImageIcon(ClassLoader.getSystemResource("images/login.jpeg")));
	backImage.setBounds(0,0,600, 390);
	nextButton.setBounds(450,305,100,28);
	nextButton.setBackground(new Color(0,0,0));
	nextButton.setBorderPainted(false);
	nextButton.setForeground(new Color(255,255,255));
	welcome.setForeground(new Color(30,10,200));
	welcome.setFont(new Font("Monospaced",Font.ITALIC,30));
	welcome.setBounds(60,0,600,100);
	loginScreen.add(nextButton);
	loginScreen.add(backImage);
	backImage.add(welcome);
	nextButton.setFocusable(false);
	nextButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent ae) {
			if (ae.getSource()==nextButton) {
				new SignInScreen();
				loginScreen.setVisible(false);
			}
		}
	});
	
	loginScreen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
	loginScreen.setBounds((d.width-600)/2,(d.height-390)/2,600,37+390);
	loginScreen.setIconImage(new ImageIcon("src/images/CarParking.png").getImage());
	//this.loginScreen.setUndecorated(true);
	
	}
	
	public static void main(String[] args) {
		Login Screen1 = new Login();
		Screen1.loginScreen.setVisible(true);
		while(true) {
			Screen1.welcome.setVisible(false);
			try {Thread.sleep(500);}
			catch(Exception e) {}
			Screen1.welcome.setVisible(true);
			try {Thread.sleep(500);}
			catch(Exception e) {}
		}
	}

}
