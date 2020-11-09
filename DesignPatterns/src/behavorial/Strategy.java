package behavorial;

/**
 * https://howtodoinjava.com/design-patterns/behavioral/strategy-design-pattern/
 * 
 * The Strategy pattern suggests that you take a class that does something specific in a lot of different ways and extract all of these algorithms 
 * into separate classes called strategies.

The original class, called context, must have a field for storing a reference to one of the strategies.
 The context delegates the work to a linked strategy object instead of executing it on its own.

The context isn’t responsible for selecting an appropriate algorithm for the job. Instead, the client passes the desired strategy to the context. 
In fact, the context doesn’t know much about strategies. It works with all strategies through the same generic interface, 
which only exposes a single method for triggering the algorithm encapsulated within the selected strategy.

This way the context becomes independent of concrete strategies, so you can add new algorithms or modify existing ones without changing 
the code of the context or other strategies.
 * 
 * @author avyas27
 *
 */
public class Strategy {

	public static void main(String[] args) {
		// Creating social Media Connect Object for connecting with friend by
        // any social media strategy.
        SocialMediaContext context = new SocialMediaContext();
 
        // Setting Facebook strategy.
        context.setSocialmediaStrategy(new FacebookStrategy());
        context.connect("Lokesh");
 
        System.out.println("====================");
 
        // Setting Twitter strategy.
        context.setSocialmediaStrategy(new TwitterStrategy());
        context.connect("Lokesh");
 
        System.out.println("====================");
 
        // Setting GooglePlus strategy.
        context.setSocialmediaStrategy(new GooglePlusStrategy());
        context.connect("Lokesh");
 
        System.out.println("====================");
 
        // Setting Orkut strategy.
        context.setSocialmediaStrategy(new OrkutStrategy());
        context.connect("Lokesh");

	}

}

class SocialMediaContext 
{
    ISocialMediaStrategy smStrategy;
 
    public void setSocialmediaStrategy(ISocialMediaStrategy smStrategy) 
    {
        this.smStrategy = smStrategy;
    }
 
    public void connect(String name) 
    {
        smStrategy.connectTo(name);
    }
}

interface ISocialMediaStrategy 
{
    public void connectTo(String friendName);
}

class FacebookStrategy implements ISocialMediaStrategy {
	 
    public void connectTo(String friendName) 
    {
        System.out.println("Connecting with " + friendName + " through Facebook");
    }
}

class GooglePlusStrategy implements ISocialMediaStrategy {
	 
    public void connectTo(String friendName) 
    {
        System.out.println("Connecting with " + friendName + " through GooglePlus");
    }
}

class TwitterStrategy implements ISocialMediaStrategy {
	 
    public void connectTo(String friendName) 
    {
        System.out.println("Connecting with " + friendName + " through Twitter");
    }
}

class OrkutStrategy implements ISocialMediaStrategy {
	 
    public void connectTo(String friendName) 
    {
        System.out.println("Connecting with " + friendName + " through Orkut [not possible though :)]");
    }
}