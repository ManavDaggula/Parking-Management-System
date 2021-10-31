package parkingManagementSystem;
import javax.swing.*;

import java.sql.*;

import java.awt.Color;
import java.awt.event.*;
import net.proteanit.sql.*;
import java.awt.*;

public class employeeinfo extends JFrame implements ActionListener{
	// setBounds
	JTable t1;
	JButton b1,b2;
	JLabel j1,j2,j3,j4,j5,j6,j7;
	
	employeeinfo(){
		
		t1=new JTable();
		t1.setBounds(0,40,1100,450);
		add(t1);
		
		j1=new JLabel("Name");
		j1.setBounds(65,10,70,30);
		add(j1);
		
		j2=new JLabel("Age");
		j2.setBounds(225,10,70,30);
		add(j2);
		
		j3=new JLabel("Gender");
		j3.setBounds(370,10,70,30);
		add(j3);
		
		j4=new JLabel("Job");
		j4.setBounds(530,10,70,30);
		add(j4);
		
		j5=new JLabel("Phone");
		j5.setBounds(685,10,70,30);
		add(j5);
		
		j6=new JLabel("Aadhar No");
		j6.setBounds(835,10,70,30);
		add(j6);
		
		j7=new JLabel("Email Id");
		j7.setBounds(975,10,70,30);
		add(j7);
		
		
		b1=new JButton("Load Data");
		b1.setBackground(Color.BLACK);
		b1.setForeground(Color.WHITE);
		b1.setBounds(330,510,130,40);
		add(b1);
		b1.addActionListener(this);
		
		
		b2=new JButton("Back");
		b2.setBackground(Color.BLACK);
		b2.setForeground(Color.WHITE);
		b2.setBounds(530,510,130,40);
		add(b2);
		b2.addActionListener(this);
		
		getContentPane().setBackground(Color.WHITE);
		setLayout(null);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setBounds((d.width-1100)/2,(d.height-600)/2,1100,600);
		setVisible(true);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		
	}
	
	public void actionPerformed(ActionEvent ae) {
		 if(ae.getSource()==b1) {
			 
			 try {
				 ConnectionToMySQL c=new ConnectionToMySQL();
				 String str="select * from employee";
				 ResultSet rs=c.s.executeQuery(str);
				 
				 t1.setModel(DbUtils.resultSetToTableModel(rs));
			 }catch(Exception e) {
				 
			 }
			 
		 }else if(ae.getSource()==b2){
			 this.dispose();
		 }
		
	}

	public static void main(String[] args) {
		new employeeinfo().setVisible(true);

	}

}