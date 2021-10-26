package parkingManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Timestamp;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class EntryPage implements ActionListener{
	JFrame frame;
	JLabel licenseL, fNameL, lNameL, pNoL, imageLabel1, imageLabel2;
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
		//licenseT.setOpaque(true);
		//licenseT.setBackground(Color.BLACK);
		fNameT = new JTextField();
		fNameT.setBounds(250,70,150,45);
		//fNameT.setOpaque(true);
		//fNameT.setBackground(Color.BLACK);
		lNameT = new JTextField();
		lNameT.setBounds(250,130,150,45);
		//lNameT.setOpaque(true);
		//lNameT.setBackground(Color.BLACK);
		pNoT = new JTextField();
		pNoT.setBounds(250,190,150,45);
		//pNoT.setOpaque(true);
		//pNoT.setBackground(Color.BLACK);
		enterB = new JButton("Enter");
		enterB.addActionListener(this);
		enterB.setBounds(60,250,100,40);
		enterB.setBackground(Color.BLACK);
		enterB.setForeground(Color.WHITE);
		closeB = new JButton("Close");
		closeB.addActionListener(this);
		closeB.setBounds(250,250,100,40);
		closeB.setBackground(Color.BLACK);
		closeB.setForeground(Color.WHITE);
		
		frame = new JFrame();
		frame.setLayout(null);
		frame.add(imageLabel1);
		frame.add(imageLabel2);
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
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((d.width-800)/2,(d.height-350)/2,800,350);
		frame.setVisible(true);
	}
	public boolean checkInfo(String fn,String ln, String lic,String pno) {
		fn = fn.trim();
		ln = ln.trim();
		lic = lic.trim();
		pno = pno.trim();
		if(fn.matches("[a-zA-Z]+")  && ln.matches("[a-zA-Z]+") && pno.matches("[0-9]+") && pno.length()==10 && lic.length()==10){
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
			//System.out.println(fname + " " + lname + "\n" + licenseP + "\n" + phoneNumber);
			
			
			if(check==true) {
				//System.out.println("checking done");
				//SQL queries below here
				ConnectionToMySQL c = new ConnectionToMySQL();
				String query;
				Timestamp time;
				int cid,pid;
				ResultSet rs;
				
				try {
					//checking if customer exists
					query = "select customer_id from customer where first_name='"+fname+"' and last_name='"+lname+"' and phone_number = '"+phoneNumber+"';";
					rs = c.s.executeQuery(query);
					if(rs.next()) {
						cid = rs.getInt("customer_id");
						//System.out.println("cid ="+cid);
					}
					else {//customer does not exists, hence creating customer
						query = "select max(customer_id) as max from customer;";
						rs = c.s.executeQuery(query);
						rs.next();
						cid = rs.getInt("max");
						cid++;
						query = "insert into customer values("+cid+",'"+fname+"','"+lname+"','"+phoneNumber+"');";
						c.s.executeUpdate(query);
					}
					//checking if vehicle exits
					query = "select * from vehicle where license_plate_no = '"+licenseP+"';";
					rs = c.s.executeQuery(query);
					if(!rs.next()) {
						query = "insert into vehicle values('"+licenseP+"',"+cid+");";
						c.s.executeUpdate(query);
					}
					/*query = "select * from vehicle where license_plate_no = '"+licenseP+"';";
					 *rs = c.s.executeQuery(query);
					 *if(rs.getInt("owner")!=cid) {
					 *	//now if there are more than one people possessing the same car then there will be a problem which is not accounted for by the below solution
					 *	//you will have to create multivalued attributes in mysql to solve the problem
					 *	//for now we are doing nothing
					 *	//we simply add the vehicle
					 *}
					 */
					//to add the vehicle in parking, we check for empty spaces
					//gives error in rs.get... line
					query = "select sysdate() as time;";
					rs = c.s.executeQuery(query);
					rs.next();
					time = rs.getTimestamp("time");
					query = "select space_id from parking_space where vehicle_parked is NULL;";
					rs = c.s.executeQuery(query);
					if(rs.next()) {
						pid = rs.getInt("space_id");
						query = "update parking_space set vehicle_parked='"+licenseP+"', in_time='"+time+"' where space_id="+pid+";";
						c.s.executeUpdate(query);
						JOptionPane.showMessageDialog(frame,"Entry for vehicle is done.\n Alotted space is "+pid);
					}
					else {
						JOptionPane.showMessageDialog(frame,"Sorry, we are out of space now.");
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