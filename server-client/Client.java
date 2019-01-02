import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.time.LocalDateTime;

public class Client {
    
    public static String time() {
    	LocalDateTime uptime = LocalDateTime.now();
    	return (uptime.toString());
    }
    public static Socket s;
    public static void connect() throws InterruptedException {
    	int connattempts = 0;
    	while (connattempts <= 10) {
	    	try{
	    		s = new Socket("192.168.122.1", 9090);
	    		return;
	    		//Exception would be caught right here
	    	}
	    	catch(Exception e) {
	    		connattempts++;
	    		Thread.sleep(1000);
	    	}
    	}
    	if (connattempts >= 10) {
    		System.out.println("Sorry the server is probaly not up or you have the wrong ip");
    		System.exit(0);;
    	}
    }
    public static void main(String[] args) throws IOException, InterruptedException {
    	connect();
    	System.out.println("Client Running");
    	
    	BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
    	//shows that they have connected
        String welcome = input.readLine();
        System.out.println(welcome);
        
		//collect time 
		String time = time();
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        out.println(time);
        s.close();
    }
  
}