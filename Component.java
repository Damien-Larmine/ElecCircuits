public class Component {

	private String name;
	private int ins;
	private int outs;

	public Component(String name, int ins, int outs) {
		this.name = name;
		this.ins = ins;
		this.outs = outs;
	}

	public String getName() {
		return this.name;
	}

	public int getIns() {
		return this.ins;
	}

	public int getOuts() {
		return this.outs;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setIns(int ins) {
		this.ins = ins;
	}

	public void setOuts(int outs) {
		this.outs = outs;
	}
}
