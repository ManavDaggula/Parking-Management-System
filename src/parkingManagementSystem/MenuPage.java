package parkingManagementSystem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MenuPage implements ActionListener{

	public JFrame menuFrame = new JFrame();
    public JMenuBar menuBar = new JMenuBar();
	public JMenuItem entry, exit, search,show_parking_space;
	public JMenu display;
    public JLabel imageLabel = new JLabel();
    MenuPage(){
    	
    	entry = new JMenuItem("Entry");
    	entry.setForeground(Color.BLUE);
    	exit = new JMenuItem("Exit");
    	exit.setForeground(Color.BLUE);
    	search = new JMenuItem("Search");
    	search.setForeground(Color.BLUE);
    	show_parking_space = new JMenuItem("Show Parking Space");
    	show_parking_space.addActionListener(this);
    	
    	
    	//entry.setFocusPainted(false);
    	
    	display = new JMenu("Display");
    	display.add(show_parking_space);
    	
    	menuBar.setBackground(Color.WHITE);
    	menuBar.add(entry);
    	menuBar.add(exit);
    	menuBar.add(search);
    	menuBar.add(display);
    	//menuBar.setBorderPainted(false);
    	menuBar.setBounds(0,0,1366,50);
    	
    	//adding actionListeners to entry exit and search
    	entry.addActionListener(this);
		
    	//trying the weird color change solution
    	//entry.setOpaque(true);
    	entry.setBackground(Color.WHITE);
    	//exit.setFocusPainted(false);
    	//exit.setOpaque(true);
    	exit.setBackground(Color.WHITE);
    	//search.setFocusPainted(false);
    	//search.setOpaque(true);
    	search.setBackground(Color.WHITE);
    	menuFrame.setLayout(null);
    	menuFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);
    	
    	imageLabel = new JLabel("");
        imageLabel.setIcon(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/EmptyParkingLot.jpg")).getImage().getScaledInstance(1366,720,Image.SCALE_DEFAULT)));
        imageLabel.setSize(1366,720);
        imageLabel.setLocation(0,0);
        
        menuFrame.add(menuBar);
        menuFrame.add(imageLabel);
        menuFrame.setIconImage(new ImageIcon("src/images/CarParking.png").getImage());
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
    	menuFrame.setBounds(0,0,d.width,d.height);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
		if (ae.getSource()==entry){
			entry.setEnabled(false);
			EntryPage m = new EntryPage();
			//while(m.frame.isDisplayable()) {}
			m.frame.addWindowListener(new WindowListener() {
				@Override
				public void windowOpened(WindowEvent e) {}

				@Override
				public void windowClosing(WindowEvent e) {
					entry.setEnabled(true);
					
				}

				@Override
				public void windowClosed(WindowEvent e) {
					entry.setEnabled(true);
					
				}

				@Override
				public void windowIconified(WindowEvent e) {}

				@Override
				public void windowDeiconified(WindowEvent e) {}

				@Override
				public void windowActivated(WindowEvent e) {}

				@Override
				public void windowDeactivated(WindowEvent e) {}
	        });
			//entry.setEnabled(false);
		}
		else if(ae.getSource()==show_parking_space) {
			new DisplayParkingLot();
		}
	}
    
    public static void main(String args[]){
        new MenuPage();
    }
    
}