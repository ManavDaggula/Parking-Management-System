package parkingManagementSystem;

import javax.swing.JFrame;
//import javax.swing.JPanel;
import javax.swing.JLabel;

//import java.awt.Image;

import javax.swing.ImageIcon;

public class MenuPage{

    public JFrame menuFrame;
    //JPanel MenuPanel;
    public JLabel imageLabel;
    MenuPage(){
    	menuFrame.setLayout(null);
    	menuFrame.setBounds(250,250,600,600);
    	imageLabel = new JLabel("");
        imageLabel.setIcon(new ImageIcon(ClassLoader.getSystemResource("/home/manav/home/manav/Documents/EmptyParkingLot.jpg")));
        imageLabel.setSize(500,500);
        imageLabel.setLocation(0,0);
        menuFrame.add(imageLabel);
        
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        menuFrame.setVisible(true);
    }
    public static void main(String args[]){
        new MenuPage();
    }
    
}