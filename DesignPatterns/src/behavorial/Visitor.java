package behavorial;

import junit.framework.TestCase;

/**
 * Nice explaination :  https://refactoring.guru/design-patterns/visitor
 * 
 * https://howtodoinjava.com/design-patterns/behavioral/visitor-design-pattern-example-tutorial/
 * @author avyas27
 *
 */
public class Visitor  extends TestCase{

	private MacConfigurator macConfigurator;
    private LinuxConfigurator linuxConfigurator;
    private DLinkRouter dlink;
    private TPLinkRouter tplink;
    private LinkSysRouter linksys;
     
    public void setUp()
    {
        macConfigurator = new MacConfigurator();
        linuxConfigurator = new LinuxConfigurator();
         
        dlink = new DLinkRouter();
        tplink = new TPLinkRouter();
        linksys = new LinkSysRouter();
    }
     
    public void testDlink()
    {
        dlink.accept(macConfigurator);
        dlink.accept(linuxConfigurator);
    }
     
    public void testTPLink()
    {
        tplink.accept(macConfigurator);
        tplink.accept(linuxConfigurator);
    }
     
    public void testLinkSys()
    {
        linksys.accept(macConfigurator);
        linksys.accept(linuxConfigurator);
    }

}
interface Router 
{
   public void sendData(char[] data);
   public void acceptData(char[] data);
    
   public void accept(RouterVisitor v);
}

class DLinkRouter implements Router{
	 
    @Override
    public void sendData(char[] data) {
    }
 
    @Override
    public void acceptData(char[] data) {
    }
 
    @Override
    public void accept(RouterVisitor v) {
        v.visit(this);
    }
}

class LinkSysRouter implements Router{
	 
    @Override
    public void sendData(char[] data) {
    }
 
    @Override
    public void acceptData(char[] data) {
    }
     
    @Override
    public void accept(RouterVisitor v) {
        v.visit(this);
    }
}

class TPLinkRouter implements Router{
	 
    @Override
    public void sendData(char[] data) {
    }
 
    @Override
    public void acceptData(char[] data) {
    }
     
    @Override
    public void accept(RouterVisitor v) {
        v.visit(this);
    }
}

interface RouterVisitor {
    public void visit(DLinkRouter router);
    public void visit(TPLinkRouter router);
    public void visit(LinkSysRouter router);
}

class LinuxConfigurator implements RouterVisitor{
	 
    @Override
    public void visit(DLinkRouter router) {
        System.out.println("DLinkRouter Configuration for Linux complete !!");
    }
 
    @Override
    public void visit(TPLinkRouter router) {
        System.out.println("TPLinkRouter Configuration for Linux complete !!");
    }
 
    @Override
    public void visit(LinkSysRouter router) {
        System.out.println("LinkSysRouter Configuration for Linux complete !!");
    }
}

class MacConfigurator implements RouterVisitor{
	 
    @Override
    public void visit(DLinkRouter router) {
        System.out.println("DLinkRouter Configuration for Mac complete !!");
    }
 
    @Override
    public void visit(TPLinkRouter router) {
        System.out.println("TPLinkRouter Configuration for Mac complete !!");
    }
 
    @Override
    public void visit(LinkSysRouter router) {
        System.out.println("LinkSysRouter Configuration for Mac complete !!");
    }
}