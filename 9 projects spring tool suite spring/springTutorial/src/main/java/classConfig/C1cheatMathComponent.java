package classConfig;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// set specific implementation as primary for injection
@Primary
// any component can be defined as any scope same sa beans in xml configuration
// singleton or prototype
@Scope("singleton")
public class C1cheatMathComponent implements A1Cheat {
	
	@Override
	public void cheat() {
		
		System.out.println("math cheating started..");
		
	}
	
	// CYCLING (executes during bean creation/destruction)
	/*
	custom bean cycle methods are void and have no return & no parameters
	can have any access modifier
	 */
	// for prototype scoped beans spring does not call destroy method
	
	// custom init method
	@PostConstruct
	public void initBean() {
		System.out.println("init bean");
	}
	
	// custom destroy method
	@PreDestroy
	public void destroyBean() {
		System.out.println("destroy bean");
	}

}
