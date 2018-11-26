import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.*;


/**
 * Trivial client for the date server.
 */
public class Client {

    
    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
    	System.out.println("Enter IP Address of a machine that is \n" + "running the date service on port 9090:");
    	String serverAddress = scan.nextLine();
    	scan.close();
        
    	
    	Socket s = new Socket(serverAddress, 9090);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String answer = input.readLine();
        System.out.println(answer);
        
        s.close();
        System.exit(0);
    }
}
