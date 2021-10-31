package parkingManagementSystem;
import java.awt.event.*;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.*;



import java.sql.*;

public class exit extends JFrame implements ActionListener {


	JLabel j1,j2,j3,j4,j6,j8,j9;
	JComboBox c1;
    JTextField t1,t2,t5,t6;
    JButton b1,b2,b3;
    
    
    exit(){
		j1=new JLabel("License Plate No.");
		j1.setSize(150,30);
		j1.setLocation(60,30);
		j1.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(j1);
		
		
		
		c1=new JComboBox();
		try {
			ConnectionToMySQL c=new ConnectionToMySQL();
			ResultSet rs=c.s.executeQuery("select occupancy from parking_lot_space where occupancy is not null;");
			while (rs.next()){
				c1.addItem(rs.getString(1));
			}
				}catch(Exception e){
					e.printStackTrace();
				}
		
		c1.setBounds(250,30,150,30);
		add(c1);
		
		
		
		j2=new JLabel("First Name");
		j2.setSize(150,30);
		j2.setLocation(60,80);
		j2.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(j2);
		
		t1=new JTextField();
		t1.setBounds(250,80,150,30);	
		t1.setEditable(false);
		add(t1);
		
		j9=new JLabel("Last Name");
		j9.setSize(150,30);
		j9.setLocation(60,130);
		j9.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(j9);
		
		t6=new JTextField();
		t6.setBounds(250,130,150,30);	
		t6.setEditable(false);
		add(t6);
		
		j3=new JLabel("Phone No.");
		j3.setSize(150,30);
		j3.setLocation(60,180);
		j3.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(j3);
		
		t2=new JTextField();
		t2.setBounds(250,180,150,30);	
		t2.setEditable(false);
		add(t2);
		
		j8=new JLabel("Alloted Lot");
		j8.setSize(150,30);
		j8.setLocation(60,230);
		j8.setFont(new Font("Tahoma",Font.PLAIN,17));
		add(j8);
		
		t5=new JTextField();
		t5.setBounds(250,230,150,30);	
		t5.setEditable(false);
		add(t5);
		
		
		j4=new JLabel("EXIT TO PARKING LOT");
		j4.setSize(430,25);
		j4.setLocation(450,30);
		j4.setForeground(Color.blue);
		j4.setFont(new Font("Tahoma",Font.ROMAN_BASELINE,25));
		add(j4);
		
		b2=new JButton("Next");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(60,300,130,40);
		b2.setEnabled(false);
		add(b2);
		b2.addActionListener(this);
		
		b3=new JButton("Cancel");
		b3.setBackground(Color.BLACK);
		b3.setForeground(Color.WHITE);
		b3.setBounds(260,300,130,40);
		add(b3);
		b3.addActionListener(this);
		
		
		
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("images/exit_f.jpeg"));
		Image i2=i1.getImage().getScaledInstance(280,260,Image.SCALE_DEFAULT);
		ImageIcon i3= new ImageIcon(i2);
		JLabel j6=new JLabel(i3);
	    j6.setBounds(430,80,280,260);
		add(j6);
		
		ImageIcon i4= new ImageIcon(ClassLoader.getSystemResource("images/tick.png"));
		Image i5=i4.getImage().getScaledInstance(20,20,Image.SCALE_DEFAULT);
		ImageIcon i6= new ImageIcon(i5);
	    b1=new JButton(i6);
	    b1.setBounds(410,30,20,20);
		add(b1);
		b1.addActionListener(this);
		
	
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width-750)/2,(d.height-400)/2,750,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
    
    public void actionPerformed(ActionEvent ae) {
    	if(ae.getSource()==b1){
    		ConnectionToMySQL c=new ConnectionToMySQL();
    		String no=(String) c1.getSelectedItem();
    		try {
    		ResultSet rs=c.s.executeQuery("select first_name,last_name,phone,spot_name from parking_lot_space,customer_info where occupancy='"+no+"' and occupancy=license_plate_number;");
    		while (rs.next()){
    			t1.setText(rs.getString(1));
    			t6.setText(rs.getString(2));
    			t2.setText(rs.getString(3));
    			t5.setText(rs.getString(4));
    			
    		}
    		b2.setEnabled(true);
    		
    	}
    		catch(Exception e) {e.printStackTrace();}
    	}
    	else if(ae.getSource()==b2){
    		//new fare((String) c1.getSelectedItem()).setVisible(true);
    		new fare((String) c1.getSelectedItem()).setVisible(true);
    		this.dispose();
    	}
    	else if(ae.getSource()==b3) {
    		this.dispose();
    	}	
    }
	public static void main(String[] args) {
		new exit();

	}




}
