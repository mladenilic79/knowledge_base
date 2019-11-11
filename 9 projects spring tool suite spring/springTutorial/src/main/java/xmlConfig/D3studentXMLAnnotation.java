package xmlConfig;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class D3studentXMLAnnotation {
	
	private int id;
	private String name;
	private A1Cheat cheat;
	
	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	// by putting annotation we are choosing which setter/constructor spring should use
	// we can put autowire annotation in front of setter or constructor
	// if in front of constructor than autowire will be of constructor type
	// in in front of setter than autowire will be of type/name type
	// 		(first will try to match by type, if fails than by name, in case of 
	//		multiple objects of the same type)
	@Autowired
	// specify bean id for injection in case of ambiguity
	@Qualifier("cheat")
	public void setCheat(A1Cheat cheat) {
		this.cheat = cheat;
	}
	
	public void cheating() {
		cheat.cheat();
	}

}
