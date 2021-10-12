package parkingManagementSystem;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.Image;

import javax.swing.ImageIcon;

public class MenuPage{

    JFrame menuFrame;
    JPanel MenuPanel;
    JLabel imageLabel;
    MenuPage(){
        imageLabel = new JLabel();
        imageLabel.setIcon(new ImageIcon(new ImageIcon("/home/manav/home/manav/Documents/EmptyParkingLot.jpg").getImage().getScaledInstance(500, 500, Image.SCALE_DEFAULT)));
        imageLabel.setSize(500,500);
        imageLabel.setLocation(0,0);
        menuFrame.add(imageLabel);
        
        menuFrame.setLayout(null);
        menuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menuFrame.setBounds(250,250,600,600);
        menuFrame.setVisible(true);
    }
    public static void main(String args[]){
        new MenuPage();
    }
    
}