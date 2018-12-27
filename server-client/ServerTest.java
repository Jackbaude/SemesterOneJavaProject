import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
public class ServerTest {
	public static void main(String[] args) throws IOException{
	

		String welcome = "Welcome";
		try (var listener = new ServerSocket(9090)) {
            System.out.println("Server is running");
            while (true) {
                try (var socket = listener.accept()) {
                    var out = new PrintWriter(socket.getOutputStream(), true);
                    out.println(welcome.toString());
                }
                finally {
                	System.out.println("Message recieved");
                	
                	
                }
            }
        }

	}

}
