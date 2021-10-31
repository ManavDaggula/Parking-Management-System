package parkingManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class EntryPage implements ActionListener{
	JFrame frame;
	JLabel licenseL, fNameL, lNameL, pNoL, genderLabel, imageLabel1, imageLabel2;
	JTextField licenseT, fNameT, lNameT, pNoT;
	JButton enterB, closeB;
	JRadioButton male,female;
	ButtonGroup gender;
	
	EntryPage(){
		licenseL = new JLabel("License Plate Number");
		licenseL.setBounds(10,10,200,50);
		licenseL.setFont(new Font("Tahoma",Font.PLAIN,14));
		//licenseL.setOpaque(true);
		//licenseL.setBackground(Color.BLACK);
		fNameL = new JLabel("First Name");
		fNameL.setBounds(10,70,200,50);
		fNameL.setFont(new Font("Tahoma",Font.PLAIN,14));
		//fNameL.setOpaque(true);
		//fNameL.setBackground(Color.BLACK);
		lNameL = new JLabel("Last Name");
		lNameL.setBounds(10,130,200,50);
		lNameL.setFont(new Font("Tahoma",Font.PLAIN,14));
		//lNameL.setOpaque(true);
		//lNameL.setBackground(Color.BLACK);\
		genderLabel = new JLabel("Gender");
		genderLabel.setBounds(10,190,200,50);
		genderLabel.setFont(new Font("Tahoma",Font.PLAIN,14));
		
		pNoL = new JLabel("Phone Number");
		pNoL.setBounds(10,250,200,50);
		pNoL.setFont(new Font("Tahoma",Font.PLAIN,14));
		//pNoL.setOpaque(true);
		//pNoL.setBackground(Color.BLACK);
		imageLabel1 = new JLabel();
		ImageIcon i1 = new ImageIcon("src/images/Entry1.png");
		Image i2 = i1.getImage();
		Image i3 = i2.getScaledInstance(150,150,Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i3);
		imageLabel1.setIcon(i1);
		imageLabel1.setBounds(550,140,150,150);
		imageLabel2 = new JLabel();
		i1 = new ImageIcon("src/images/Entry2.png");
		i2 = i1.getImage();
		i3 = i2.getScaledInstance(250,100,Image.SCALE_DEFAULT);
		i1 = new ImageIcon(i3);
		imageLabel2.setIcon(i1);
		imageLabel2.setBounds(500,10,250,100);
		licenseT = new JTextField();
		licenseT.setBounds(250,10,150,45);
		licenseT.setFont(new Font("Tahoma",Font.PLAIN,14));
		//licenseT.setOpaque(true);
		//licenseT.setBackground(Color.BLACK);
		fNameT = new JTextField();
		fNameT.setBounds(250,70,150,45);
		fNameT.setFont(new Font("Tahoma",Font.PLAIN,14));
		//fNameT.setOpaque(true);
		//fNameT.setBackground(Color.BLACK);
		lNameT = new JTextField();
		lNameT.setBounds(250,130,150,45);
		lNameT.setFont(new Font("Tahoma",Font.PLAIN,14));
		//lNameT.setOpaque(true);
		//lNameT.setBackground(Color.BLACK);
		male = new JRadioButton("Male");
		female = new JRadioButton("Female");
		male.setBounds(250,190,60,45);
		female.setBounds(320,190,100,45);
		male.setBackground(Color.WHITE);
		female.setBackground(Color.WHITE);
		male.setFont(new Font("Tahoma",Font.PLAIN,14));
		female.setFont(new Font("Tahoma",Font.PLAIN,14));
		gender = new ButtonGroup();
		gender.add(male);
		gender.add(female);
		pNoT = new JTextField();
		pNoT.setBounds(250,250,150,45);
		pNoT.setFont(new Font("Tahoma",Font.PLAIN,14));
		//pNoT.setOpaque(true);
		//pNoT.setBackground(Color.BLACK);
		enterB = new JButton("Enter");
		enterB.addActionListener(this);
		enterB.setBounds(60,310,100,40);
		enterB.setBackground(Color.BLACK);
		enterB.setForeground(Color.WHITE);
		enterB.setFont(new Font("Tahoma",Font.PLAIN,14));
		closeB = new JButton("Close");
		closeB.addActionListener(this);
		closeB.setBounds(250,310,100,40);
		closeB.setBackground(Color.BLACK);
		closeB.setForeground(Color.WHITE);
		closeB.setFont(new Font("Tahoma",Font.PLAIN,14));
		
		frame = new JFrame();
		frame.setLayout(null);
		frame.add(imageLabel1);
		frame.add(imageLabel2);
		frame.add(licenseL);
		frame.add(fNameL);
		frame.add(lNameL);
		frame.add(genderLabel);
		frame.add(pNoL);
		frame.add(licenseT);
		frame.add(fNameT);
		frame.add(lNameT);
		frame.add(male);
		frame.add(female);
		frame.add(pNoT);
		frame.add(enterB);
		frame.add(closeB);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((d.width-800)/2,(d.height-410)/2,800,410);
		frame.setVisible(true);
	}
	public boolean checkInfo(String fn,String ln, String lic,String pno) {
		fn = fn.trim();
		ln = ln.trim();
		lic = lic.trim();
		pno = pno.trim();
		if(fn.matches("[a-zA-Z]+")  && ln.matches("[a-zA-Z]+") && pno.matches("[0-9]+") && pno.length()==10 && lic.length()==10 &&(male.isSelected() || female.isSelected())){
			//checking license plate validity below
			String p1 = lic.substring(0,2);
			String p2 = lic.substring(2,4);
			String p3 = lic.substring(4,6);
			String p4 = lic.substring(6,10);
			if (p1.matches("[A-Z]+") && p2.matches("[0-9]+") && p3.matches("[A-Z]+") && p4.matches("[0-9]+")) {
				//System.out.println("correct");
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
			fname = fNameT.getText().trim().toUpperCase();
			lname = lNameT.getText().trim().toUpperCase();
			licenseP = licenseT.getText().trim().toUpperCase();
			phoneNumber = pNoT.getText().trim().toUpperCase();
			check = checkInfo(fname,lname,licenseP,phoneNumber);
			char gender='\0';
			if(male.isSelected())
				gender='M';
			else if (female.isSelected())
				gender='F';
			//System.out.println(fname + " " + lname + "\n" + licenseP + "\n" + phoneNumber);
			
			
			if(check==true) {
				//System.out.println("checking done");
				//SQL queries below here
				ConnectionToMySQL c = new ConnectionToMySQL();
				String query,pid;
				Timestamp time;
				ResultSet rs;
				
				try {
					query = "select spot_name from parking_lot_space where occupancy is null;";
					rs = c.s.executeQuery(query);
					if(rs.next()){
						pid = rs.getString(1);
						//System.out.println(pid);
						/*query = "select sysdate();";
						rs = c.s.executeQuery(query);
						rs.next();
						time = rs.getTimestamp(1);*/
						time = new Timestamp(System.currentTimeMillis());
						query = "insert into customer_info values('"+licenseP+"','"+fname+"','"+lname+"','"+phoneNumber+"','"+gender+"','"+time+"');";
						//System.out.println(time);
						c.s.executeUpdate(query);
						query = "update parking_lot_space set occupancy='"+licenseP+"' where spot_name='"+pid+"';";
						c.s.executeUpdate(query);
						JOptionPane.showMessageDialog(frame,"Entry done.","",JOptionPane.INFORMATION_MESSAGE);
					}
					else {
						JOptionPane.showMessageDialog(frame,"Sorry, We are out of space!","",JOptionPane.INFORMATION_MESSAGE);
					}
					frame.dispose();
					
				} catch (Exception e) {
					e.printStackTrace();
					JOptionPane.showMessageDialog(frame,"Something went wrong. Please try again.","Error",JOptionPane.ERROR_MESSAGE);
				}
				
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