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
import javax.swing.table.DefaultTableCellRenderer;

public class DisplayParkingLot {
	
	JFrame frame;
	JLabel label,temp1,temp2,temp3;
	JTable table;
	JScrollPane sp;
	
	public String[][] getDataMatrix(){
		String[][] data= {{"","",""}};
		int count=0,i=0;
		
		ConnectionToMySQL c = new ConnectionToMySQL();
		String query;
		try{
			query = "select count(spot_name) from parking_lot_space;";
			ResultSet rs = c.s.executeQuery(query);
			rs.next();
			count = rs.getInt(1);
			data = new String[count][3];
			query = "select spot_name, occupancy from parking_lot_space;";
			rs = c.s.executeQuery(query);
			while(rs.next()) {
				data[i][0] = rs.getString(1);
				data[i][2] = rs.getString(2);
				if(data[i][2]==null)
					data[i][1]="Available";
				else
					data[i][1]="Occupied";
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
		label.setFont(new Font("Tahoma",Font.BOLD,25));
		label.setHorizontalAlignment(JLabel.CENTER);
		
		temp1 = new JLabel();
		temp2 = new JLabel();
		temp3 = new JLabel();
		
		String[] columns = {"Spot","Occupancy","Vehicle_Parked"};
		String rows[][] = this.getDataMatrix();
		
		table = new JTable(rows,columns);
		table.setFillsViewportHeight(true);
		//table.setEnabled(false);
		table.setDefaultEditor(Object.class, null);
		
		DefaultTableCellRenderer r = new DefaultTableCellRenderer();
		r.setBackground(new Color(0,200,220));
		table.getColumnModel().getColumn(1).setCellRenderer(r);
		//table.getColumnModel().getColumn(2).setCellRenderer(r);
		
		sp = new JScrollPane(table);
		
		frame = new JFrame();
		frame.setLayout(new BorderLayout(10,10));
		
		frame.add(label,BorderLayout.NORTH);
		frame.add(sp,BorderLayout.CENTER);
		frame.add(temp1,BorderLayout.EAST);
		frame.add(temp2,BorderLayout.WEST);
		frame.add(temp3,BorderLayout.SOUTH);
		
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
