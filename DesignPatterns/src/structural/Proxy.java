package structural;

import java.util.ArrayList;
import java.util.List;

/**
 * A real world example can be a cheque or credit card is a proxy for what is in our bank account. 
 * It can be used in place of cash, and provides a means of accessing that cash when required. 
 * And that’s exactly what the Proxy pattern does – “Controls and manage access to the object they are protecting“.
 * 
 * The primary difference between both patterns are responsibilities they bear. Decorators focus on adding responsibilities,
 *  but proxies focus on controlling the access to an object.
 * 
 * https://www.geeksforgeeks.org/proxy-design-pattern/
 * @author avyas27
 *
 */
public class Proxy {

	public static void main(String[] args) {
		Internet internet = new ProxyInternet(); 
        try
        { 
            internet.connectTo("geeksforgeeks.org"); 
            internet.connectTo("abc.com"); 
        } 
        catch (Exception e) 
        { 
            System.out.println(e.getMessage()); 
        } 

	}

}

interface Internet 
{ 
    public void connectTo(String serverhost) throws Exception; 
} 

class RealInternet implements Internet 
{ 
    @Override
    public void connectTo(String serverhost) 
    { 
        System.out.println("Connecting to "+ serverhost); 
    } 
} 

class ProxyInternet implements Internet 
{ 
    private Internet internet = new RealInternet(); 
    private static List<String> bannedSites; 
      
    static
    { 
        bannedSites = new ArrayList<String>(); 
        bannedSites.add("abc.com"); 
        bannedSites.add("def.com"); 
        bannedSites.add("ijk.com"); 
        bannedSites.add("lnm.com"); 
    } 
      
    @Override
    public void connectTo(String serverhost) throws Exception 
    { 
        if(bannedSites.contains(serverhost.toLowerCase())) 
        { 
            throw new Exception("Access Denied"); 
        } 
          
        internet.connectTo(serverhost); 
    } 
  
} 