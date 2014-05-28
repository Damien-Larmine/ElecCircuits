public class CompLinkXOR extends Component{
	
private boolean out;
	

	public CompLinkXOR(String name,CompXOR a) {
		super(name);
		
		this.out = a.getOut();
	}

	public boolean link() {
		return out;
	}
}
