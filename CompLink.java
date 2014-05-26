public class CompLink extends Component{

	private boolean in;
	

	public CompLink(String name) {
		super(name, 1, 1);

		this.in = false;
	}

	public boolean link(boolean a) {
		return a;
	}
}
