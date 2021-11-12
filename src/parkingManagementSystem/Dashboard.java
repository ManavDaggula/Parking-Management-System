package parkingManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.event.MenuEvent;
import javax.swing.event.MenuListener;

public class Dashboard extends JFrame implements ActionListener {

	JMenuBar mb;
	JMenu m1, m2, m3, m5;
	JMenuItem i1, i2, i3,i4,i5;
	//JLabel occupancyIndicator;
	
	Dashboard(){
		
		//occupancyIndicator = new JLabel("");
		
		
		mb = new JMenuBar();
		add(mb);
		
		m2 = new JMenu("ENTRY");
		mb.add(m2);
		
		m3 = new JMenu("EXIT");
		mb.add(m3);
		
		m1 = new JMenu("PARKING MANAGEMENT");
		m1.setForeground(Color.RED);
		mb.add(m1);
		
		m5 = new JMenu("ADMIN");
		m5.setForeground(Color.BLUE);
		mb.add(m5);
		
		i1 = new JMenuItem("Add Employee");
		i1.addActionListener(this);
		m5.add(i1);
		
		i2 = new JMenuItem("Add Parking Spots");
		i2.addActionListener(this);
		m5.add(i2);
		
		i3 = new JMenuItem("More");
		i3.addActionListener(this);
		m1.add(i3);
		
		i4 = new JMenuItem("New Vehicle");
		i4.addActionListener(this);
		m2.add(i4);
		
		i5 = new JMenuItem("Checkout");
		i5.addActionListener(this);
		m3.add(i5);
		
		mb.setBounds(0,0,1950,30);
		
		ImageIcon i1 = new ImageIcon("src/images/EmptyParkingLot.jpg");
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		Image i2 = i1.getImage().getScaledInstance(d.width, d.height, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel l1 = new JLabel(i3);
		l1.setBounds(0,0,1366,720);
		add(l1);
				
		JLabel l2 = new JLabel("P A R K I N G");
		l2.setHorizontalAlignment(JLabel.CENTER);
		l2.setBounds((d.width-400)/2,5, 400, 200);
		l2.setForeground(new Color(207, 168, 54));
		l2.setFont(new Font("Seoge Script", Font.ITALIC, 60));
		l1.add(l2);
		
		setLayout(null);
		//setBounds(0,0,1530,820);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	public void actionPerformed(ActionEvent ae) {
		if(ae.getSource()==i4) {
			new EntryPage();
		}
		else if(ae.getSource()==i5) {
			new exit();
		}
		else if(ae.getActionCommand().equals("More")){
			new More().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Employee")) {
			new AddEmployee().setVisible(true);
		}
		else if(ae.getActionCommand().equals("Add Parking Spots")) {
			new AddParkingSpots().setVisible(true);
		}
	}
	public static void main(String[] args) {
		new Dashboard().setVisible(true);

	}

}
