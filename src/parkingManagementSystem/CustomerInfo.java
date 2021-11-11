package parkingManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.Toolkit;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

public class CustomerInfo {
	JFrame frame;
	JScrollPane sp;
	JTable table;
	JLabel header,temp1,temp2,temp3;
	
	CustomerInfo(){
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout(10,10));
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((d.width-500)/2,(d.height-500)/2,500,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.getContentPane().setBackground(Color.WHITE);
		
		header = new JLabel("Customer Details");
		header.setFont(new Font("Tahoma",Font.BOLD,20));
		header.setHorizontalAlignment(JLabel.CENTER);
		frame.add(header,BorderLayout.NORTH);
		
		table = new JTable();
		table.setFillsViewportHeight(true);
		
		sp = new JScrollPane();
		sp.add(table);
		frame.add(sp,BorderLayout.CENTER);

		frame.setVisible(true);
	}

	public static void main(String args[]){
		new CustomerInfo();
	}
}
