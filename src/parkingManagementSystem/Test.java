package parkingManagementSystem;

import java.sql.Timestamp;

public class Test {

	public static void main(String[] args) {
		/*JFrame f = new JFrame();
		JLabel l = new JLabel();
		ImageIcon i = new ImageIcon("src/images/UserIcon.png");
		l.setIcon(i);
		l.setSize(500,500);
		f.add(l);
		f.setVisible(true);
		f.setSize(500,500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);*/
		Timestamp ts = Timestamp.valueOf(String.format("%04d-%02d-%02d 00:00:00", 
                2021, 10, 29));
		System.out.println(ts);
		//try{
		//Thread.sleep(10000);
			Timestamp tp = new Timestamp(System.currentTimeMillis());
			System.out.println(tp);
			long diff = (tp.getTime()-ts.getTime())/3600000;
			if((tp.getTime()-ts.getTime())%3600000 > 0)
				diff++;
			System.out.println(diff);
		//}
		//catch(Exception e) {
		//	e.printStackTrace();
		//}
	}

}
