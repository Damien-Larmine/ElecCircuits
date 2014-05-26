public class CompAND extends Component {

	private boolean inA;
	private boolean inB;

	public CompAND(String name) {
		super(name, 2, 1);

		this.inA = false;
		this.inB = false;
	}

	public boolean getInA() {
		return this.inA;
	}

	public boolean getInB() {
		return this.inB;
	}

	public boolean getOut() {
		return (this.inA & this.inB);
	}

	public void setInA(boolean valeur) {
		this.inA = valeur;
	}

	public void setInB(boolean valeur) {
		this.inB = valeur;
	}

}