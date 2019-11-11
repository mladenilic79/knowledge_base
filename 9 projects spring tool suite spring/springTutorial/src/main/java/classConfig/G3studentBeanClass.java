package classConfig;

public class G3studentBeanClass {
	
	private int id;
	private String name;
	private B1cheatMath mathCheat;
	private A1Cheat cheat;
	
	public G3studentBeanClass() {
	}

	public G3studentBeanClass(int id, String name, B1cheatMath mathCheat, A1Cheat cheat) {
		this.id = id;
		this.name = name;
		this.mathCheat = mathCheat;
		this.cheat = cheat;
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

	public void setCheat(A1Cheat cheat) {
		this.cheat = cheat;
	}
	
	public void cheating() {
		mathCheat.cheat();
		cheat.cheat();
	}

}
