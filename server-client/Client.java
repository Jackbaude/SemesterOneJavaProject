import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.time.LocalDateTime;

public class Client {
    
    public static String time() {
    	LocalDateTime uptime = LocalDateTime.now();
    	return (uptime.toString());
    }
    public static void main(String[] args) throws IOException, InterruptedException {
    	System.out.println("Client Running");
    	int connattempts = 0;
    	//Socket s = new Socket("192.168.122.1", 9090);
    	try{
    		Socket s = new Socket("192.168.122.1", 9090);
    		
        	BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
            
            String welcome = input.readLine();
            System.out.println(welcome);
            
            //collect ip address
            
    		//collect time 
    		String time = time();
    		
    		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
            
    		
            out.println(time);
            s.close();
           
    	}
    	catch(Exception e) {
    		connattempts++;
    		Thread.sleep(1000);
    	}
    
    }
  
}
