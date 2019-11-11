package xmlConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class D4studentXMLAnnotationDirect {

	private int id;
	private String name;
	
	// if autowired in front of dependency no setter/constructor needed
	// behind the scenes spring will use default constructor & reflection
	@Autowired
	@Qualifier("cheat")
	private A1Cheat cheat;

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void cheating() {
		cheat.cheat();
	}

}
