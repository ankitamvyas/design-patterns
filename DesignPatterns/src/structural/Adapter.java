package structural;

/**
 * when source and target are incompatible
 * 
 * BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
 *  System.in is static instance of InputStream declared as:
 *  BufferedReader as java docs define, reads a character stream.
 *  stem.in provides byte stream where BufferedReader expects character stream. How they will work together?

This is the ideal situation to put a adapter in between two incompatible interfaces.
 InputStreamReader does exactly this thing and works adapter between System.in and BufferedReader.
 
 other examples: java.util.Arrays#asList()
 				 java.io.OutputStreamWriter(OutputStream)	
 				 
 Ref: https://www.geeksforgeeks.org/adapter-pattern/
 https://howtodoinjava.com/design-patterns/structural/adapter-design-pattern-in-java/
 
 * @author avyas27
 *
 */
public class Adapter {

	public static void main(String[] args) {
		 Sparrow sparrow = new Sparrow(); 
	        ToyDuck toyDuck = new PlasticToyDuck(); 
	  
	        // Wrap a bird in a birdAdapter so that it  
	        // behaves like toy duck 
	        ToyDuck birdAdapter = new BirdAdapter(sparrow); 
	  
	        System.out.println("Sparrow..."); 
	        sparrow.makeSound(); 
	  
	        System.out.println("ToyDuck..."); 
	        toyDuck.squeak(); 
	  
	        // toy duck behaving like a bird  
	        System.out.println("BirdAdapter..."); 
	        birdAdapter.squeak(); 
	}

}
interface Bird{
	public void makeSound();
}

class Sparrow implements Bird{

	@Override
	public void makeSound() {
		System.out.println("Chirp!!!");
		
	}
}

interface ToyDuck{
	public void squeak();
}

class PlasticToyDuck implements ToyDuck{

	@Override
	public void squeak() {
		System.out.println("Squeak!!");
		
	}
}

class BirdAdapter implements ToyDuck{
	Bird bird;
	public BirdAdapter(Bird bird) {
		this.bird = bird;
	}
	@Override
	public void squeak() {
		bird.makeSound();
		
	}
	
}