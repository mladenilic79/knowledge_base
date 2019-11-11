package xmlConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class D6studentXMLpropertiesAnnotations {
	
	private int id;
	private String name;
	private A1Cheat cheat;
	
	public D6studentXMLpropertiesAnnotations() {
	}

	public D6studentXMLpropertiesAnnotations(int id, String name, A1Cheat cheat) {
		this.id = id;
		this.name = name;
		this.cheat = cheat;
	}

	// before dependancy doesn't use setter & constructor
	@Value("2")
	public void setId(int id) {
		this.id = id;
	}

	// before dependancy doesn't use setter & constructor
	@Value("${randomStudent.name}")
	public void setName(String name) {
		this.name = name;
	}

	@Autowired
	@Qualifier("CheatScienceRef")
	public void setCheat(A1Cheat cheat) {
		this.cheat = cheat;
	}

	public void cheating() {
		cheat.cheat();
	}
	
}
