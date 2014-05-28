public class CompLinkIN extends Component{

	private boolean out;
	

	public CompLinkIN(String name,CompIN a) {
		super(name);
		
		this.out = a.getOut();
	}

	public boolean link() {
		return out;
	}
}
