package xmlConfig;

public class D2studentXMLinterface {
	
	private int id;
	private String name;
	private A1Cheat cheat;
	
	public D2studentXMLinterface() {
	}

	public D2studentXMLinterface(int id, String name, A1Cheat cheat) {
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

	public void setCheat(A1Cheat cheat) {
		this.cheat = cheat;
	}

	public void cheating() {
		cheat.cheat();
	}
	
}
