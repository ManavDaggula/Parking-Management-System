package parkingManagementSystem;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Test {

	public static void main(String[] args) {
		JFrame f = new JFrame();
		JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("src/images/UserIcon.png");
		l.setIcon(i);
		l.setSize(500,500);
		f.add(l);
		f.setVisible(true);
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
