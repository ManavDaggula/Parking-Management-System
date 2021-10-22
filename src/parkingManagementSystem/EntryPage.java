package parkingManagementSystem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EntryPage implements ActionListener{
	JFrame frame;
	JLabel licenseL, fNameL, lNameL, pNoL;
	JTextField licenseT, fNameT, lNameT, pNoT;
	JButton enterB, closeB;
	
	EntryPage(){
		licenseL = new JLabel("License Plate Number");
		licenseL.setBounds(10,10,200,50);
		//licenseL.setOpaque(true);
		//licenseL.setBackground(Color.BLACK);
		fNameL = new JLabel("First Name");
		fNameL.setBounds(10,70,200,50);
		//fNameL.setOpaque(true);
		//fNameL.setBackground(Color.BLACK);
		lNameL = new JLabel("Last Name");
		lNameL.setBounds(10,130,200,50);
		//lNameL.setOpaque(true);
		//lNameL.setBackground(Color.BLACK);
		pNoL = new JLabel("Phone Number");
		pNoL.setBounds(10,190,200,50);
		//pNoL.setOpaque(true);
		//pNoL.setBackground(Color.BLACK);
		licenseT = new JTextField();
		licenseT.setBounds(250,10,200,50);
		//licenseT.setOpaque(true);
		//licenseT.setBackground(Color.BLACK);
		fNameT = new JTextField();
		fNameT.setBounds(250,70,200,50);
		//fNameT.setOpaque(true);
		//fNameT.setBackground(Color.BLACK);
		lNameT = new JTextField();
		lNameT.setBounds(250,130,200,50);
		//lNameT.setOpaque(true);
		//lNameT.setBackground(Color.BLACK);
		pNoT = new JTextField();
		pNoT.setBounds(250,190,200,50);
		//pNoT.setOpaque(true);
		//pNoT.setBackground(Color.BLACK);
		enterB = new JButton("Enter");
		enterB.addActionListener(this);
		enterB.setBounds(10,250,200,50);
		closeB = new JButton("Close");
		closeB.addActionListener(this);
		closeB.setBounds(250,250,200,50);
		
		frame = new JFrame();
		frame.setLayout(null);
		frame.add(licenseL);
		frame.add(fNameL);
		frame.add(lNameL);
		frame.add(pNoL);
		frame.add(licenseT);
		frame.add(fNameT);
		frame.add(lNameT);
		frame.add(pNoT);
		frame.add(enterB);
		frame.add(closeB);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setBounds(300,200,500,400);
		frame.setVisible(true);
	}
	public boolean checkInfo(String fn,String ln, String lic,String pno) {
		fn = fn.trim();
		ln = ln.trim();
		lic = lic.trim();
		pno = pno.trim();
		if(fn.matches("[a-zA-Z]+") && ln.matches("[a-zA-Z]+") && pno.matches("[0-9]+") && pno.length()==10) {
			//Until here everything except license plate is checked
			//checking license plate validity below
			String p1 = lic.substring(0, 2);
			String p2 = lic.substring(2,4);
			String p3 = lic.substring(4,6);
			String p4 = lic.substring(6,10);
			if (lic.length()==10 && p1.matches("[A-Z]+") && p2.matches("[0-9]+") && p3.matches("[A-Z]+") && p4.matches("[0-9]+")) {
				System.out.println("correct");
				return true;
			}
		}
		JOptionPane.showMessageDialog(frame,"Enter valid inputs.");
		return false;
	}
	public void actionPerformed(ActionEvent ae) {
		if (ae.getSource()==enterB) {
			String fname,lname,licenseP, phoneNumber;
			boolean check;
			fname = fNameT.getText();
			lname = lNameT.getText();
			licenseP = licenseT.getText();
			phoneNumber = pNoT.getText();
			check = checkInfo(fname,lname,licenseP,phoneNumber);
			System.out.println(fname + " " + lname + "\n" + licenseP + "\n" + phoneNumber);
			
			
			if(check==true) {
				
				//SQL queries here
				JOptionPane.showMessageDialog(frame,"Entry for vehicle is done");
				frame.dispose();
				
			}
		}
		else if(ae.getSource()==closeB) {
			frame.dispose();
		}
	}
	
	public static void main(String args[]) {
		new EntryPage();
	}
}