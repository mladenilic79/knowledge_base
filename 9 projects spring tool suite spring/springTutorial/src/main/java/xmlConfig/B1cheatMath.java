package xmlConfig;

public class B1cheatMath implements A1Cheat {
	
	@Override
	public void cheat() {
		
		System.out.println("math cheating started..");
		
	}
	
	// CYCLING
	/*
	custom bean cycle methods are void and have no return & no parameters
	can have any access modifier
	 */
	// for prototype scoped beans spring does not call destruct method
	
	// custom init method
	public void initBean() {
		System.out.println("init bean");
	}
	
	// custom destroy method
	public void destroyBean() {
		System.out.println("destroy bean");
	}

}
