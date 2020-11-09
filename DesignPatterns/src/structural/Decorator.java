package structural;

/**
 * This pattern changes the functionality of objects at runtime without impacting its blueprint or the existing functionality.

	While working with these patterns, we might confuse decorators with an inheritance. However, there is a difference between the two. 
	Decorators are used when we have to add and remove responsibilities from an object dynamically.
 	Whereas, inheritance can do the same, but not at run time.
 	
 	https://dzone.com/articles/decorator-design-patterns
 * @author avyas27
 *
 */
public class Decorator {

	public static void main(String[] args) {
		Phone phone1 = new AndroidDecorator(new BasicPhone());
		phone1.printMode();
		Phone phone2 = new IPhoneDecorator(new BasicPhone());
		phone2.printMode();

	}

}
interface Phone{
	public void printMode();
}

class BasicPhone implements Phone{

	@Override
	public void printMode() {
		System.out.println("Basic Phone");
		
	}
	
}

class PhoneDecorator implements Phone{
	
	Phone phone;
	
	public PhoneDecorator(Phone phone) {
		this.phone = phone;
	}
	
	@Override
	public void printMode() {
		this.phone.printMode();
		
	}
}

class AndroidDecorator extends PhoneDecorator{

	public AndroidDecorator(Phone phone) {
		super(phone);
	}
	
	@Override
	public void printMode() {
		super.printMode();
		System.out.println("Adding Android features");
		
	}
}

class IPhoneDecorator extends PhoneDecorator{

	public IPhoneDecorator(Phone phone) {
		super(phone);
	}
	@Override
	public void printMode() {
		super.printMode();
		System.out.println("Adding IPhone features");
		
	}
}