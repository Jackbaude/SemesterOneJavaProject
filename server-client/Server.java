import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;
//Sends date and time to client.
public class Server {
    public static int NumVMs = 0;
	public static void main(String[] args) throws IOException {
    	//Scanner scan = new Scanner(System.in);
		ServerSocket listener = new ServerSocket(9090);
        String welcome = "Thank you for connecting!";
        
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(welcome.toString());
                    ServerGUi.data[0][0] = "This some how worked";
                    NumVMs++;
                    
                } finally {
                    socket.close();    
                }
            }
        }
        finally {
            listener.close();
        }
    }
    
}
