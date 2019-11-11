package classConfig;

import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
// set specific implementation as primary for injection
@Primary
// any component can be defined as any scope same sa beans in xml configuration
// singleton or prototype
@Scope("singleton")
public class C2cheatScienceComponent implements A1Cheat {
	
	@Override
	public void cheat() {
		
		System.out.println("science cheating started..");
		
	}

}
