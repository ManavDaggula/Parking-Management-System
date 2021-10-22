package parkingManagementSystem;

import java.awt.Color;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

//import javax.swing.JPanel;
//just for commit
public class MenuPage implements ActionListener{

	public JFrame menuFrame = new JFrame();
    //public JPanel entryMenuPanel = new JPanel();
	public JMenuBar menuBar = new JMenuBar();
	public JMenuItem entry, exit, search;
    public JLabel imageLabel = new JLabel();
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
    	entry.addActionListener(this);
		
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
    
    public void actionPerformed(ActionEvent ae){
		if (ae.getSource()==entry){
			entry.setEnabled(false);
			EntryPage m = new EntryPage();
			//while(m.frame.isDisplayable()) {}
			m.frame.addWindowListener(new WindowListener() {
				@Override
				public void windowOpened(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowClosing(WindowEvent e) {
					entry.setEnabled(true);
					
				}

				@Override
				public void windowClosed(WindowEvent e) {
					entry.setEnabled(true);
					
				}

				@Override
				public void windowIconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeiconified(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowActivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void windowDeactivated(WindowEvent e) {
					// TODO Auto-generated method stub
					
				}
	        });
			//entry.setEnabled(false);
		}
	}
    
    public static void main(String args[]){
        new MenuPage();
    }
    
}