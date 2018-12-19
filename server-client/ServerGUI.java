import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.JScrollPane;

class ServerGUi{	
	public static Object[][] data = new Object[][] {
        {1, "1.0.0.1", 40.0},
        {2, "1.0.0.1", 70.0},
        {3, "1.0.0.1", 60.0},
        //Need to figure out how to add a row automatically.
    };
    public static String[] columnHeaders = new String[] {
            "Number", "I.P", "UP TIME"};
    
    
	//Main
    public static void main(String[] args) {
		dashboardWindowMake();
	}
    //Window Make
    public static void dashboardWindowMake() {
    	JFrame dashboard = new JFrame("Dashboard");
    	dashboard.setVisible(true);	
		dashboard.setTitle("Dashboard Information");
		dashboard.setBounds((960 - 250), (540 - 250), 500, 500);
		dashboard.add(new JScrollPane(table));
		JTable table = new JTable(data, columnHeaders); 
		dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboard.pack();
		
	}
}
