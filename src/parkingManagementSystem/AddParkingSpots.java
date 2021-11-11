package parkingManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AddParkingSpots extends JFrame implements ActionListener {

	JTextField t1, t2;
	JComboBox c1;
	JButton b1, b2;
	
	
	AddParkingSpots(){
		
		JLabel l1 = new JLabel("ADD PARKING SPOTS");
		l1.setBounds(100,25,350,50);
		l1.setFont(new Font ("Tahoma", Font.BOLD , 25));
		add(l1);
		
		JLabel spot = new JLabel("Parking Spot Number");
		spot.setBounds(50, 100,180,30);
		spot.setFont(new Font ("Tahoma", Font.PLAIN , 17));
		add(spot);
		
		t1 = new JTextField();
		t1.setBounds(250, 100, 150,30);
		add(t1);
		
		JLabel available = new JLabel("Available");
		available.setBounds(50, 160, 180, 30);
		available.setFont(new Font ("Tahoma", Font.PLAIN , 17));
		add(available);
		
		c1 = new JComboBox(new String[] {"Available", "Occupied"});
		c1.setEditable(false);
		//c1.setEnabled(false);
		c1.setBounds(250,160,150,30);
		c1.setBackground(Color.WHITE);
		add(c1);
		
		JLabel price = new JLabel("Price per Hour");
		price.setBounds(50, 220, 180, 30);
		price.setFont(new Font ("Tahoma", Font.PLAIN , 17));
		add(price);
		
		t2 = new JTextField("50");
		t2.setEditable(false);
		t2.setBounds(250, 220, 150,30);
		add(t2);
		
		b1 = new JButton("Add Spot");
		b1.setBounds(50, 300, 150, 30);
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.addActionListener(this);
		add(b1);
		
		b2 = new JButton("Cancel");
		b2.setBounds(250, 300, 150, 30);
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.addActionListener(this);
		add(b2);
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("images/fifth.jpeg"));
		Image i2 = i1.getImage().getScaledInstance(520, 380, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l2 = new JLabel(i3);
		l2.setBounds(450, 10, 520, 380);
		add(l2);
		
		getContentPane().setBackground(Color.WHITE);
		
		setLayout(null);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width-1000)/2,(d.height-450)/2,1000,450);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent ae) {

			if(ae.getSource()== b1) {
		
			try {
				String spot = t1.getText();
				//String available = (String) c1.getSelectedItem();
				//String price = t2.getText();
				
				ConnectionToMySQL c = new ConnectionToMySQL();
				String str = "insert into parking_lot_space values('"+spot+"',null);";
			
				c.s.executeUpdate(str);
				JOptionPane.showMessageDialog(null, "New Parking Spot Added");
				this.setVisible(false);
				
			}catch(Exception ee) {
				 System.out.println(ee);
			}
		}else if(ae.getSource() == b2) {
			this.setVisible(false);
			this.dispose();
		}

	}
	public static void main(String[] args) {
		new AddParkingSpots().setVisible(true);

	}

}
