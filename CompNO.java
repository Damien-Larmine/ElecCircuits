public class CompNO extends Component {

	private boolean in;

	public CompNO(String name) {
		super(name, 1, 1);

		this.in = false;
	}

	public boolean getIn() {
		return this.in;
	}

	public boolean getOut() {
		return (!this.in);
	}

	public void setIn(boolean valeur) {
		this.in = valeur;
	}

}
