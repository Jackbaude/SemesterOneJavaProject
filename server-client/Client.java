import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.util.*;

public class Client {
	public static int vmNumber = Server.NumVMs;
	public static String ipin() {
		Scanner scanip = new Scanner(System.in);
		String ip = scanip.nextLine();
		scanip.close();
		return ip;
	}
    public static String systemipaddress = "";
    public static void main(String[] args) throws IOException {
    	System.out.println("Enter IP Address of a machine that is \n" + "running the date service on port 9090:");
    	Socket s = new Socket(ipin(), 9090);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String welcome = input.readLine();
        System.out.println(welcome);
        s.close();
        
    }
    public static String ipaddress() {
        try 
        {
            URL url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
            systemipaddress = sc.readLine().trim();
            return systemipaddress;   
        }    
        catch (Exception e2) 
        {
            return "Cannot get IP address";
        }   
    }
    public static long timer() {
    	long start = System.currentTimeMillis();
    	long stop = System.currentTimeMillis();
    	long elapsed = stop - start;
    	return elapsed;
    }
    
    
    public static void virtualmachine() {
    	
    	while (true) {
    		timer();
    	}
    	
    	
    }
    
}
