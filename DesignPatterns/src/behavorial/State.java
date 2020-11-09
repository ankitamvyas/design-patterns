package behavorial;

/**
 * https://www.geeksforgeeks.org/state-design-pattern/
 * 
 * f we have to change behavior of an object based on its state, we can have a state variable in the Object 
 * and use if-else condition block to perform different actions based on the state. State pattern is used to provide a systematic 
 * and lose-coupled way to achieve this through Context and State implementations.
 * @author avyas27
 *
 */
public class State {

	public static void main(String[] args) {
		AlertStateContext stateContext = new AlertStateContext(); 
        stateContext.alert(); 
        stateContext.alert(); 
        stateContext.setState(new Silent()); 
        stateContext.alert(); 
        stateContext.alert(); 
        stateContext.alert(); 

	}

}
interface MobileAlertState  
{ 
    public void alert(AlertStateContext ctx); 
} 
  
class AlertStateContext  
{ 
    private MobileAlertState currentState; 
  
    public AlertStateContext()  
    { 
        currentState = new Vibration(); 
    } 
  
    public void setState(MobileAlertState state)  
    { 
        currentState = state; 
    } 
  
    public void alert()  
    { 
        currentState.alert(this); 
    } 
} 
  
class Vibration implements MobileAlertState  
{ 
    @Override
    public void alert(AlertStateContext ctx)  
    { 
         System.out.println("vibration..."); 
    } 
  
} 
  
class Silent implements MobileAlertState 
{ 
    @Override
    public void alert(AlertStateContext ctx)  
    { 
        System.out.println("silent..."); 
    } 
  
} 