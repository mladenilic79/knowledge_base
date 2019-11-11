package classConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

// @Component is same as bean in xml.. in means create & inject object
// if not providing name (bean id), name will be class name with small first letter
@Component("studentComponentAnnotation")
public class F2studentComponentClass {
	
	private int id;
	private String name;
	private C1cheatMathComponent mathCheatComponent;
	private A1Cheat cheat;
	
	public F2studentComponentClass() {
	}

	// izgleda autowire, qualifier i value ne mogu da idu na grupnog 
	// konstruktora ovde jedino ako je pojedinacan
	
	public F2studentComponentClass(int id, String name, C1cheatMathComponent mathCheatComponent, A1Cheat cheat) {
		this.id = id;
		this.name = name;
		this.mathCheatComponent = mathCheatComponent;
		this.cheat = cheat;
	}

	public int getId() {
		return id;
	}

	@Value("5")  // if putted before dependancy doesn't need setter/constructor
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	@Value("${randomStudent.name}")    // if putted before dependancy doesn't need setter/constructor
	public void setName(String name) {
		this.name = name;
	}

	public C1cheatMathComponent getMathCheatComponent() {
		return mathCheatComponent;
	}

	@Autowired  // if putted before dependancy doesn't need setter/constructor
	@Qualifier("c1cheatMathComponent")
	public void setMathCheatComponent(C1cheatMathComponent mathCheatComponent) {
		this.mathCheatComponent = mathCheatComponent;
	}

	public A1Cheat getCheat() {
		return cheat;
	}

	@Autowired  // if putted before dependancy doesn't need setter/constructor
	@Qualifier("c2cheatScienceComponent")
	public void setCheat(A1Cheat cheat) {
		this.cheat = cheat;
	}

	public void cheating() {
		mathCheatComponent.cheat();
		cheat.cheat();
	}

}
