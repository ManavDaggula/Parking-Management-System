package parkingManagementSystem;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class SearchVehicle implements ActionListener{
    JFrame frame;
    JLabel licenseL,message;
    JTextField licenseT;
    JButton search;
    Dimension d;
    JScrollPane sp;
    
    SearchVehicle(){
        frame = new JFrame();
        licenseL = new JLabel("License Number");
        licenseT = new JTextField();

        licenseL.setBounds(20,20,120,30);
        frame.add(licenseL);
        
        licenseT.setBounds(150,20,120,30);
        frame.add(licenseT);

        search = new JButton("Search");
        search.setBounds(280,20,80,30);
        search.addActionListener(this);
        frame.add(search);
        
        message = new JLabel("Vehicle NOT Found.");
        message.setBounds(100,70,250,50);
		message.setFont(new Font("Tohoma",Font.BOLD,20));
		message.setForeground(Color.RED);
		frame.add(message);
		message.setVisible(false);
		
		sp = new JScrollPane();
		sp.setBounds(20,90,500,39);
		frame.add(sp);
		sp.setVisible(false);
        
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((d.width-450)/2,(d.height-100)/2,450,100);
        frame.getContentPane().setBackground(Color.WHITE);
        frame.setVisible(true);

    }
    
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==search) {
    		String lic = licenseT.getText().trim().toUpperCase();
    		if (lic.length()==10 && lic.substring(0,2).matches("[A-Z]+") && lic.substring(2,4).matches("[0-9]+") && lic.substring(4,6).matches("[A-Z]+") && lic.substring(6,10).matches("[0-9]+")) {
				try{
					ConnectionToMySQL c=new ConnectionToMySQL();
					ResultSet rs;
					String query="select first_name,last_name,phone,gender,spot_name from customer_info,parking_lot_space where license_plate_number=occupancy and occupancy='"+lic+"';";
					rs=c.s.executeQuery(query);
					if(rs.next()) {
						String columns[] = {"License No","First Name","Last Name","Phone","Gender","Parked At"};
						String rows[][] = {{lic,rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5)}};
						JTable table = new JTable(rows,columns);
						table.setDefaultEditor(Object.class, null);
						sp.setViewportView(table);
						message.setVisible(false);
						sp.setVisible(true);
						frame.setBounds((d.width-550)/2,(d.height-200)/2,550,200);
					}
					else {
						//System.out.println("Not found");
						sp.setVisible(false);
						message.setVisible(true);
						frame.setBounds((d.width-450)/2,(d.height-200)/2,450,200);
					}
				}
				catch(Exception e) {
					e.printStackTrace();
				}
			}
			else {
				JOptionPane.showMessageDialog(frame, "Enter valid inputs.");
			}
    	}
    }

    public static void main(String args[]){
        new SearchVehicle();
    }
}
