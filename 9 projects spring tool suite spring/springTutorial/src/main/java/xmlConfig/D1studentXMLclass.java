package xmlConfig;

public class D1studentXMLclass {
	
	private int id;
	private String name;
	private B1cheatMath mathCheat;
	
	public D1studentXMLclass() {
	}

	public D1studentXMLclass(int id, String name, B1cheatMath mathCheat) {
		this.id = id;
		this.name = name;
		this.mathCheat = mathCheat;
	}

	public void setId(int id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMathCheat(B1cheatMath mathCheat) {
		this.mathCheat = mathCheat;
	}

	public void cheating() {
		mathCheat.cheat();
	}
	
}
