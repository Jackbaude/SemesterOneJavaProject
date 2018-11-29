import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

class ServerGUi{
	public static JFrame dashboard = new JFrame("Dashboard");
	
	public static Object[][] data = new Object[][] {
        {1, "1.0.0.1", 40.0},
        {2, "1.0.0.1", 70.0},
        {3, "1.0.0.1", 60.0},
    };
    public static String[] columns = new String[] {
            "Number", "I.P", "UP TIME"};
    
    public static JTable table = new JTable(data, columns); 
	//////////////////MAIN//////////////////////
    public static void main(String[] args) {
		dashboardWindowMake();
	}	
    public static void dashboardWindowMake() {
		dashboard.setVisible(true);	
		dashboard.setTitle("Dashboard Information");
		dashboard.setBounds((960 - 250), (540 - 250), 500, 500);
		dashboard.add(new JScrollPane(table));
		
		dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboard.pack();
		
	}
}
