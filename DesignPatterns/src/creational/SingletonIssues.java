package creational;

import java.io.Serializable;
import java.lang.reflect.Constructor;

public class SingletonIssues {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

/**
 *  we need to include a readResolve() method in our DemoSingleton class. 
 *  This method will be invoked when you will de-serialize the object. 
 *  Inside of this method, you must return the existing instance to ensure a single instance application wide.
 * @author avyas27
 *
 */
class SingletonSerialization{
	private static volatile SingletonSerialization instance;
	
	private SingletonSerialization() {}
	
	public static SingletonSerialization getInstance() {
		if(instance == null)
			instance = new SingletonSerialization();
		return instance;
	}
	
	protected Object readResolve() {
		return instance;
	}
}

/**
 * This is required in cases where your class structure changes between serialization and deserialization.
 *  A changed class structure will cause the JVM to give an exception in the de-serializing process.
 * @author avyas27
 *
 */
class SingletonSerialization2 implements Serializable {
    private static final long serialVersionUID = 1L;
 
    private SingletonSerialization2() {
        // private constructor
    }
 
    private static class DemoSingletonHolder {
        public static final SingletonSerialization2 INSTANCE = new SingletonSerialization2();
    }
 
    public static SingletonSerialization2 getInstance() {
        return DemoSingletonHolder.INSTANCE;
    }
 
    protected Object readResolve() {
        return getInstance();
    }
}

/**
 * When you run the below test class, you will notice that the hashcode of both the instances is not same, whcih destroys the Singleton pattern
 * Overcome reflection issue: To overcome issue raised by reflection, enums are used because java ensures internally that enum value is instantiated only once. 
 * Since java Enums are globally accessible, they can be used for singletons. 
 * Its only drawback is that it is not flexible i.e it does not allow lazy initialization.
 * 
 * As enums don’t have any constructor so it is not possible for Reflection to utilize it. Enums have their by-default constructor,
 *  we can’t invoke them by ourself. JVM handles the creation and invocation of enum constructors internally. 
 * As enums don’t give their constructor definition to the program, it is not possible for us to access them by Reflection also
 * @author avyas27
 *
 */
class DestroySingleton{
	private static DestroySingleton instance;

	private DestroySingleton() {}

	public static DestroySingleton getInstance() {
		if(instance == null) {
			instance = new DestroySingleton();
		}
		return instance;
	}
	
	class Main{
		void main(String[] args) {
			DestroySingleton inst1 = DestroySingleton.getInstance();
			DestroySingleton inst2;
			try {
				Constructor[] constructors = DestroySingleton.class.getConstructors();
				for(Constructor constructor : constructors) {
					constructor.setAccessible(true);
					inst2 = (DestroySingleton) constructor.newInstance();
					break;
				}
			}
			catch(Exception e) {
				
			}
		}
	}
}

/**
 * Overcome Cloning issue
 * @author avyas27
 *
 */
class CloneSingleton{
	private static CloneSingleton instance;

	private CloneSingleton() {}

	public static CloneSingleton getInstance() {
		if(instance == null) {
			instance = new CloneSingleton();
		}
		return instance;
	}
	
	@Override
	public Object clone() {
		return instance;
		//OR 
		//throw new CloneNotSupportedException();
	}
}