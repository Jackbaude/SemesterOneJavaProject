import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.URL;
import java.util.*;
//import java.net.URL;

public class Client {
	public static int vmNumber = 0;
    public static String systemipaddress = "";
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

    public static void virtualmachine() {
    	//run the VM
    	vmNumber ++;
    	
    }
    
}
