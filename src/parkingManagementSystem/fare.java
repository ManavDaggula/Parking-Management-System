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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class fare extends JFrame implements ActionListener {
	
	JLabel j1,j2,j3,j4,j5,j6,j7;
	JTextField t1,t2,t3;
	JButton b1,b2;
	String licNo;
	
	fare(String lic){
		licNo = lic;
		j1=new JLabel("Entry time");
		j1.setSize(150,30);
		j1.setLocation(50,50);
		j1.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(j1);
		
		t1=new JTextField("");
		t1.setBounds(200,50,150,30);	
		add(t1);
		
		
		
		j2=new JLabel("Exit time");
		j2.setSize(150,30);
		j2.setLocation(50,105);
		j2.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(j2);
		
		t2=new JTextField();
		t2.setBounds(200,105,150,30);	
		add(t2);
		
		j7=new JLabel("Total time");
		j7.setSize(150,30);
		j7.setLocation(50,160);
		j7.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(j7);
		
		t3=new JTextField();
		t3.setBounds(200,160,150,30);	
		add(t3);
		
		
		j3=new JLabel("You have to pay Rs. ");
		j3.setSize(370,40);
		j3.setLocation(20,220);
		j3.setFont(new Font("Tahoma",Font.PLAIN,25));
		add(j3);
		
		j5=new JLabel("Payment");
		j5.setSize(300,90);
		j5.setLocation(440,10);
		j5.setForeground(Color.blue);
		j5.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,40));
		add(j5);
		
		b1=new JButton("Done");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(50,300,130,40);
		add(b1);
		b1.addActionListener(this);
		
		
		b2=new JButton("Cancel");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(250,300,130,40);
		add(b2);
		b2.addActionListener(this);
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/money_a.png"));
		Image i2=i1.getImage().getScaledInstance(200,180,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel j4=new JLabel(i3);
	    j4.setBounds(440,160,200,180);
		add(j4);
		
		ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("images/MONEY_B.jfif"));
		Image i5=i4.getImage().getScaledInstance(200,150,Image.SCALE_DEFAULT);
		ImageIcon i6= new ImageIcon(i5);
		JLabel j6=new JLabel(i6);
	    j6.setBounds(400,100,200,150);
		add(j6);
		
		setValues();
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width-670)/2,(d.height-400)/2,670,400);
		setVisible(true);
		
	
	}
	
	public void setValues() {
		try {
			ConnectionToMySQL c = new ConnectionToMySQL();
			String query = "select entry_time from customer_info where license_plate_number='"+licNo+"';";
			ResultSet rs = c.s.executeQuery(query);
			rs.next();
			Timestamp entry,exit;
			entry=rs.getTimestamp(1);
			exit=new Timestamp(System.currentTimeMillis());
			long diff=exit.getTime()-entry.getTime();
			float hours=(float) (diff/3600000.0);
			t1.setText(""+entry);
			t2.setText(""+exit);
			t3.setText(hours+" hours");
			j3.setText(j3.getText()+hours*50);
			
		}
		catch(Exception e) {
			
		}
	}
	
public void actionPerformed(ActionEvent ae) {
	if(ae.getSource()==b1) {
		ConnectionToMySQL c=new ConnectionToMySQL();
		String query = "update parking_lot_space set occupancy=null where occupancy='"+licNo+"';";
		try {
			c.s.executeUpdate(query);
			query = "delete from customer_info where license_plate_number='"+licNo+"';";
			c.s.executeUpdate(query);
			JOptionPane.showMessageDialog(this, "Thank You for Visiting Us!");
			this.dispose();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}else if(ae.getSource()==b2) {
		this.dispose();
		new exit();
	}
		
	}

	public static void main(String[] args) {
		//new fare();

	}
	
	
}