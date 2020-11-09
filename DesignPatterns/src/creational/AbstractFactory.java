package creational;

/**
 * Abstract factory pattern implementation provides us a framework that allows us to create objects that follow a general pattern. 
 * So at runtime, abstract factory is coupled with any desired concrete factory which can create objects of desired type.
 * 
 * The main difference between a “factory method” and an “abstract factory” is that the factory method is a single method,
 *  and an abstract factory is an object.
 *  
 *  Ref: https://howtodoinjava.com/design-patterns/creational/abstract-factory-pattern-in-java/
 * @author avyas27
 *
 */
public class AbstractFactory {

	public static void main(String[] args) {
		System.out.println(CarFactory.buildCar(CarType.SMALL));
	    System.out.println(CarFactory.buildCar(CarType.SEDAN));
	    System.out.println(CarFactory.buildCar(CarType.LUXURY));
	}

}
enum Location {
	  DEFAULT, USA, ASIA
	}
abstract class Car {
	 
	  public Car(CarType model, Location location){
	    this.model = model;
	    this.location = location;
	  }
	 
	  protected abstract void construct();
	 
	  private CarType model = null;
	  private Location location = null;
	 
	  //getters and setters
	 
	  @Override
	  public String toString() {
	    return "Model- "+model + " built in "+location;
	  }
	}
class LuxuryCar extends Car
{
  public LuxuryCar(Location location)
  {
    super(CarType.LUXURY, location);
    construct();
  }
 
  @Override
  protected void construct() {
    System.out.println("Building luxury car");
    //add accessories
  }
}
class SmallCar extends Car {
	 
    SmallCar() {
        super(CarType.SMALL);
        construct();
    }
 
    @Override
    protected void construct() {
        System.out.println("Building small car");
        // add accessories
    }
}

class SedanCar extends Car {
	 
    SedanCar() {
        super(CarType.SEDAN);
        construct();
    }
 
    @Override
    protected void construct() {
        System.out.println("Building sedan car");
        // add accessories
    }
}

class AsiaCarFactory
{
  public static Car buildCar(CarType model)
  {
    Car car = null;
    switch (model)
    {
      case SMALL:
      car = new SmallCar(Location.ASIA);
      break;
 
      case SEDAN:
      car = new SedanCar(Location.ASIA);
      break;
 
      case LUXURY:
      car = new LuxuryCar(Location.ASIA);
      break;
 
      default:
      //throw some exception
      break;
    }
    return car;
  }
}

class DefaultCarFactory
{
  public static Car buildCar(CarType model)
  {
    Car car = null;
    switch (model)
    {
      case SMALL:
      car = new SmallCar(Location.DEFAULT);
      break;
 
      case SEDAN:
      car = new SedanCar(Location.DEFAULT);
      break;
 
      case LUXURY:
      car = new LuxuryCar(Location.DEFAULT);
      break;
 
      default:
      //throw some exception
      break;
    }
    return car;
  }
}

class USACarFactory
{
  public static Car buildCar(CarType model)
  {
    Car car = null;
    switch (model)
    {
      case SMALL:
      car = new SmallCar(Location.USA);
      break;
 
      case SEDAN:
      car = new SedanCar(Location.USA);
      break;
 
      case LUXURY:
      car = new LuxuryCar(Location.USA);
      break;
 
      default:
      //throw some exception
      break;
    }
  return car;
  }
}

class CarFactory
{
  private CarFactory() {
    //Prevent instantiation
  }
 
  public static Car buildCar(CarType type)
  {
    Car car = null;
    Location location = Location.ASIA; //Read location property somewhere from configuration
    //Use location specific car factory
    switch(location)
    {
      case USA:
        car = USACarFactory.buildCar(type);
        break;
      case ASIA:
        car = AsiaCarFactory.buildCar(type);
        break;
      default:
        car = DefaultCarFactory.buildCar(type);
    }
  return car;
  }
}