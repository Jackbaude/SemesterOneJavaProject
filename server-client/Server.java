import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	public static int numVMs = 0;
	public static String ip;
	public static String time;
	private static ServerSocket server;
	public static void main(String[] args)throws IOException { 
		ServerSocket server = new ServerSocket(9090);
		try ( 	
			    
			    Socket clientSocket = server.accept();
			    PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
			    BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			){
			out.println("welcome");
			ip = in.readLine();
			time = in.readLine();
			//out.println(numVMs);
			numVMs++;
			System.out.println(ip);
			System.out.println(time);
			
		}
		
		finally {
			server.close();
		}
		}
        

	

}
