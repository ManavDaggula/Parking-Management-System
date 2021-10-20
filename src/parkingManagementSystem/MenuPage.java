package parkingManagementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;
//import javax.swing.JPanel;

public class MenuPage {

	public JFrame menuFrame = new JFrame();
    //public JPanel entryMenuPanel = new JPanel();
	public JMenuBar menuBar = new JMenuBar();
	public JMenuItem entry, exit, search;
    public JLabel imageLabel = new JLabel();
	public JLabel l1 = new JLabel();
	public JLabel l2 = new JLabel();
	public JLabel l3 = new JLabel();
	public JTextField t1 = new JTextField();
    MenuPage(){
    	
    	entry = new JMenuItem("Entry");
    	exit = new JMenuItem("Exit");
    	search = new JMenuItem("Search");
    	menuBar.setBackground(new Color(128,50,200));
    	entry.setForeground(Color.YELLOW);
    	exit.setForeground(Color.YELLOW);
    	search.setForeground(Color.YELLOW);
    	entry.setFocusPainted(false);
    	menuBar.add(entry);
    	menuBar.add(exit);
    	menuBar.add(search);
    	//menuBar.setBorderPainted(false);
    	menuBar.setBounds(0,0,1366,50);
    	
    	//adding actionListeners to entry exit and search
    	entry.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				l1.setText("License Number");
				l1.setBounds(100, 100, 150, 50);
				l1.setOpaque(true);
				l1.setVisible(true);
				l2.setText("Name");
				l2.setBounds(100,200,150,50);
				l2.setOpaque(true);
				l2.setVisible(true);
				l3.setText("Phone Number");
				l3.setBounds(100,300,150,50);
				l3.setOpaque(true);
				l3.setVisible(true);
				
				
				imageLabel.add(l1);
				imageLabel.add(l2);
				imageLabel.add(l3);
				//menuFrame.pack();
				menuFrame.setSize(1366,719);
				menuFrame.setSize(1366,720);
				//menuFrame.setVisible(false);
				//menuFrame.setVisible(true);
			}
		});
    	
    	//trying the weird color change solution
    	entry.setOpaque(true);
    	entry.setBackground(new Color(128,50,200));
    	exit.setFocusPainted(false);
    	exit.setOpaque(true);
    	exit.setBackground(new Color(128,50,200));
    	search.setFocusPainted(false);
    	search.setOpaque(true);
    	search.setBackground(new Color(128,50,200));
    	//entryMenuPanel.setLayout(null);
    	//entryMenuPanel.setBounds(0,50,1366,670);
    	//entryMenuPanel.setOpaque(true);
    	//entryMenuPanel.setBackground(new Color(0,0,0,0));
    	menuFrame.setLayout(null);
    	menuFrame.setBounds(0,0,1366,720);
    	imageLabel = new JLabel("");
        imageLabel.setIcon(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("images/EmptyParkingLot.jpg")).getImage().getScaledInstance(1366,720,Image.SCALE_DEFAULT)));
        imageLabel.setSize(1366,720);
        imageLabel.setLocation(0,0);
        
        
        menuFrame.add(menuBar);
        menuFrame.add(imageLabel);
        //imageLabel.add(entryMenuPanel);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setVisible(true);
    }
    
    
    public static void main(String args[]){
        new MenuPage();
    }
    
}