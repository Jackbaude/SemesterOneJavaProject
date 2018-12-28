import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.*;

public class Client {
	//public static int vmNumber = 
	
	public static String ipin() {
		Scanner scanip = new Scanner(System.in);
		String ip = scanip.nextLine();
		scanip.close();
		return ip;
	}

    public static String getmyipaddress() {
        try 
        {
            URL url_name = new URL("http://bot.whatismyipaddress.com");
            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));
            String systemipaddress = sc.readLine().trim();
            return systemipaddress;   
        }    
        catch (Exception e2) 
        {
            return "Cannot get IP address";
        }   
    }
    public static String time() {
    	LocalDateTime uptime = LocalDateTime.now();
    	return (uptime.toString());
    }
    public static void main(String[] args) throws IOException {
    	System.out.println("Enter IP Address of a machine that is \n" + "running the VM service on port 9090:");
    	Socket s = new Socket(ipin(), 9090);
        BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
        
        String welcome = input.readLine();
        System.out.println(welcome);
        
        //collect ip address
        String systemipaddress = getmyipaddress();
		//collect time 
		String time = time();
		
		PrintWriter out = new PrintWriter(s.getOutputStream(), true);
        
		out.println(systemipaddress);
        out.println(time);
        //start VM
        /*if (somthing){
        	shutdown the VM
    	}
    */
    }
    /*
    public static int vmNumber() {
 	   BufferedReader input = new BufferedReader(new InputStreamReader(s.getInputStream()));
 	   return 0;
 	   
    }
    */
}
