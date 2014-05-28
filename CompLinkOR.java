public class CompLinkOR extends Component{
	
	private boolean out;
	

	public CompLinkOR(String name,CompOR a) {
		super(name);
		
		this.out = a.getOut();
	}

	public boolean link() {
		return out;
	}
}
