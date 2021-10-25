package parkingManagementSystem;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

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
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((d.width-500)/2,(d.height-400)/2,500,400);
		frame.setVisible(true);
	}
	public boolean checkInfo(String fn,String ln, String lic,String pno) {
		fn = fn.trim();
		ln = ln.trim();
		lic = lic.trim();
		pno = pno.trim();
		if(fn.matches("[a-zA-Z]+")  && ln.matches("[a-zA-Z]+") && pno.matches("[0-9]+") && pno.length()==10 && lic.length()==10){
			//Until here everything except license plate is checked
			//checking license plate validity below
			String p1 = lic.substring(0,2);
			String p2 = lic.substring(2,4);
			String p3 = lic.substring(4,6);
			String p4 = lic.substring(6,10);
			if (p1.matches("[A-Z]+") && p2.matches("[0-9]+") && p3.matches("[A-Z]+") && p4.matches("[0-9]+")) {
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
			fname = fNameT.getText().trim().toUpperCase();
			lname = lNameT.getText().trim().toUpperCase();
			licenseP = licenseT.getText().trim().toUpperCase();
			phoneNumber = pNoT.getText().trim().toUpperCase();
			check = checkInfo(fname,lname,licenseP,phoneNumber);
			System.out.println(fname + " " + lname + "\n" + licenseP + "\n" + phoneNumber);
			
			
			if(check==true) {
				System.out.println("checking done");
				//SQL queries below here
				ConnectionToMySQL c = new ConnectionToMySQL();
				String query,time;
				int cid,pid;
				ResultSet rs;
				
				try {
					//checking if customer exists
					query = "select customer_id from customer where first_name='"+fname+"' and last_name='"+lname+"' and phone_number = '"+phoneNumber+"';";
					rs = c.s.executeQuery(query);
					if(rs.next()) {
						cid = rs.getInt("customer_id");
					}
					else {//customer does not exists, hence creating customer
						query = "select max(customer_id) from customer;";
						rs = c.s.executeQuery(query);
						cid = rs.getInt("max(customer_id)");
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
					query = "select sysdate();";
					rs = c.s.executeQuery(query);
					time = rs.getString("sysdate()");
					query = "select space_id from parking_space where vehicle_parked=null;";
					rs = c.s.executeQuery(query);
					if(rs.next()) {
						pid = rs.getInt("space_id");
						query = "update parking_space set vehicle_parked='"+licenseP+"', in_time='"+time+"' where space_id="+pid+";";
						JOptionPane.showMessageDialog(frame,"Entry for vehicle is done");
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