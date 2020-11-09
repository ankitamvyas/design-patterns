package structural;

/**
 * The bridge pattern allows the Abstraction and the Implementation to be developed independently 
 * and the client code can access only the Abstraction part without being concerned about the Implementation part.
 * It increases the loose coupling between class abstraction and it’s implementation.
 * 
 * https://www.geeksforgeeks.org/bridge-design-pattern/
 * @author avyas27
 *
 */
public class Bridge {

	public static void main(String[] args) {
		Vehicle vehicle1 = new Car(new Produce(), new Assemble()); 
        vehicle1.manufacture(); 
        Vehicle vehicle2 = new Bike(new Produce(), new Assemble()); 
        vehicle2.manufacture(); 
        Vehicle vehicle3 = new Bike(new Produce(), new Assemble2()); 
        vehicle3.manufacture(); 

	}

}
abstract class Vehicle { 
    protected Workshop workShop1; 
    protected Workshop workShop2; 
  
    protected Vehicle(Workshop workShop1, Workshop workShop2) 
    { 
        this.workShop1 = workShop1; 
        this.workShop2 = workShop2; 
    } 
  
    abstract public void manufacture(); 
} 
  
// Refine abstraction 1 in bridge pattern 
class Car extends Vehicle { 
    public Car(Workshop workShop1, Workshop workShop2) 
    { 
        super(workShop1, workShop2); 
    } 
  
    @Override
    public void manufacture() 
    { 
        System.out.print("Car "); 
        workShop1.work(); 
        workShop2.work(); 
    } 
} 
  
// Refine abstraction 2 in bridge pattern 
class Bike extends Vehicle { 
    public Bike(Workshop workShop1, Workshop workShop2) 
    { 
        super(workShop1, workShop2); 
    } 
  
    @Override
    public void manufacture() 
    { 
        System.out.print("Bike "); 
        workShop1.work(); 
        workShop2.work(); 
    } 
} 
  
// Implementor for bridge pattern 
interface Workshop 
{ 
    abstract public void work(); 
} 
  
// Concrete implementation 1 for bridge pattern 
class Produce implements Workshop { 
    @Override
    public void work() 
    { 
        System.out.print("Produced"); 
    } 
} 
  
// Concrete implementation 2 for bridge pattern 
class Assemble implements Workshop { 
    @Override
    public void work() 
    { 
        System.out.print(" And"); 
        System.out.println(" Assembled."); 
    } 
} 

class Produce2 implements Workshop { 
    @Override
    public void work() 
    { 
        System.out.print("Produced"); 
    } 
} 

class Assemble2 implements Workshop { 
    @Override
    public void work() 
    { 
        System.out.print(" And"); 
        System.out.println(" Assembled."); 
    } 
} 
  