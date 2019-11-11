package xmlConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class D5studentXMLproperties {
	
	private int id;
	private String name;
	private A1Cheat cheat;
	
	public D5studentXMLproperties() {
	}

	public D5studentXMLproperties(int id, String name, A1Cheat cheat) {
		this.id = id;
		this.name = name;
		this.cheat = cheat;
	}

	public void setId(int id) {
		this.id = id;
	}

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
