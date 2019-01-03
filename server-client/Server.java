/*TODO
Finish dashboard
*/
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
public class Server {
	public static int numVMs = 0;
	public static String time;
	//private static ServerSocket server;
	public static  Object[][] data = new Object[50][3];
	public static String[] columnHeaders = new String[] {
            "Number", "I.P", "Up Time"};
	public static DefaultTableModel model = new DefaultTableModel();
	public static JTable table = new JTable(model);
	public static void dashboard() throws InterruptedException {
		JFrame dashboard = new JFrame("Dashboard");
    	dashboard.setVisible(true);	
		dashboard.setTitle("Dashboard Information");
		dashboard.setBounds((960 - 250), (540 - 250), 500, 500);
		
		dashboard.add(new JScrollPane(table));
		
		dashboard.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		dashboard.pack();
		
		model.addColumn("Number");
		model.addColumn("I.P.");
		model.addColumn("Up Time");
	}
	
	public static void main(String[] args)throws IOException, InterruptedException{ 
		dashboard();
		try {
		ServerSocket server = new ServerSocket(9090);
		System.out.println("Server Running");
			while (true) {
				try ( 	
						Socket clientSocket = server.accept();
						PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
					    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
					){
					String ip = (clientSocket.getRemoteSocketAddress().toString());
					out.println("welcome");
					numVMs++;
					time = in.readLine();
					model.addRow(new Object[] {numVMs, (ip.substring(1, (ip.indexOf(":")))), time});
				
					System.out.println("Virtual Machine Number " + numVMs);
					System.out.println(ip.substring(1, (ip.indexOf(":"))));
					System.out.println(time);
				}
				finally {
					//server.close();
				}
			}
		}
		catch(Exception e) {
			System.out.print("Sorry there is already a server runnning on this host!");
			return;
		}
		
	}

	

}
