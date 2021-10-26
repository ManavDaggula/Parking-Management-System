package parkingManagementSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class DisplayParkingLot {
	
	JFrame frame;
	JLabel label;
	JTable table;
	JScrollPane sp;
	
	public String[][] getDataMatrix(){
		String[][] data= {{"","","",""}};
		int count=0,i=0;
		
		ConnectionToMySQL c = new ConnectionToMySQL();
		String query;
		try{
			query = "select count(space_id) from parking_space;";
			ResultSet rs = c.s.executeQuery(query);
			rs.next();
			count = rs.getInt(1);
			data = new String[count][4];
			query = "select space_id,name,vehicle_parked from parking_space;";
			rs = c.s.executeQuery(query);
			while(rs.next()) {
				data[i][0] = ""+rs.getInt(1);
				data[i][1] = rs.getString(2);
				data[i][3] = rs.getString(3);
				if(data[i][3]==null)
					data[i][2]="Available";
				else
					data[i][2]="Occupied";
				i++;
			}
			
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
		return data;
	}
	
	
	DisplayParkingLot(){
		
		label = new JLabel("Parking slots");
		label.setFont(new Font("Tahoma",Font.BOLD,20));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		String[] columns = {"Customer ID","Name","Occupancy","Vehicle_Parked"};
		String rows[][] = this.getDataMatrix();
		
		table = new JTable(rows,columns);
		table.setFillsViewportHeight(true);
		//table.setEnabled(false);
		table.setDefaultEditor(Object.class, null);
		
		sp = new JScrollPane(table);
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout(50,50));
		
		frame.add(label,BorderLayout.NORTH);
		frame.add(sp,BorderLayout.CENTER);
		
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setVisible(true);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		frame.setBounds((d.width-500)/2,(d.height-500)/2,500,500);
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public static void main(String args[]){
		new DisplayParkingLot();
	}
}
