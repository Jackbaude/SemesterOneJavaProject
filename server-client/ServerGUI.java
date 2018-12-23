import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class ServerGUi {
	public static  Object[][] data = new Object[1000][1000];;
	public static String[] columnHeaders = new String[] {
            "Number", "I.P", "UP TIME"};
	public static void main(String[] args) {
		JFrame dashboard = new JFrame("Dashboard");
    	dashboard.setVisible(true);	
		dashboard.setTitle("Dashboard Information");
		dashboard.setBounds((960 - 250), (540 - 250), 500, 500);
		JTable table = new JTable(data, columnHeaders); 
		dashboard.add(new JScrollPane(table));
		
		for (int c = 0; c<=999; c++) {
			for (int r = 0; r==0; r++) {
				data[c][r] = c;		}
		}
		data[0][1] = Client.ipaddress();
		
		dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboard.pack();
	}

}
