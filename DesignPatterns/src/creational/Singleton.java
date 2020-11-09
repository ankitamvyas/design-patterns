package creational;

public class Singleton {

	public static void main(String[] args) {
		//Singleton pattern is a design solution where an application wants to have one and only one instance of any class, 
		//in all possible scenarios without any exceptional condition
		
		// ALL the classes would be public. Its avoided here for example purpose as public class reuires new file.

	}
}

class LazySingleton{
	private static LazySingleton instance;
	
	private LazySingleton() {}
	
	public static LazySingleton getInstance() {
		if(instance == null) {
			instance = new LazySingleton();
		}
		return instance;
	}
}

class DoubleCheckedSingleton{
	private static volatile DoubleCheckedSingleton instance;
	
	private DoubleCheckedSingleton() {}
	
	public static DoubleCheckedSingleton getInstance() {
		if(instance == null) {
			synchronized(DoubleCheckedSingleton.class) {
				if(instance == null) {
					instance = new DoubleCheckedSingleton();
				}
			}
		}
		return instance;
	}
}

/**
 * static blocks are executed during the loading of a class, even before the constructor is called. 
 * The above code has one drawback. Suppose there are 5 static fields in a class and the application code needs to access only 2 or 3,
 *  for which instance creation is not required at all. So, if we use this static initialization, we will have one instance created though it is required or not.
 * @author avyas27
 *
 */
class StaticBlockSingleton{
	private static StaticBlockSingleton instance;
	static {
		try {
			instance = new StaticBlockSingleton();
		}
		catch(Exception e) {
			throw new RuntimeException();
		}
	}
}


/**
 * the LazyHolder class will not be initialized until required and you can still use other static members of BillPughSingleton class
 * @author avyas27
 *
 */
class BillPughSingleton{
	
	private BillPughSingleton() {}
	
	private static class LazyHolder{
		private static BillPughSingleton instance = new BillPughSingleton();
	}
	public static BillPughSingleton getInstance() {
		return LazyHolder.instance;
	}
}

/**
 * It won't be under class. 
 * Enums are defined in separate class. This is just to avoid Compilation error its put in class
 * @author avyas27
 *
 */
//class EnumSingleton{
	 enum enumSingleton{
		INSTANCE;
	}
//}
