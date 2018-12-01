import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

//Sends date and time to client.
public class Server {
    public static void main(String[] args) throws IOException {
    	
    	
    	
    	
    	
    	ServerSocket listener = new ServerSocket(9090);
        String hello = "Hello from the Server!";
        java.util.Date date=new java.util.Date();  
		
        try {
            while (true) {
                Socket socket = listener.accept();
                try {
                    PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(date.toString());
                    out.println(hello);
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
