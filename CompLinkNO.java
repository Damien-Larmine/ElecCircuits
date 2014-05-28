public class CompLinkNO extends Component{
	
private boolean out;
	

	public CompLinkNO(String name,CompNO a) {
		super(name);
		
		this.out = a.getOut();
	}

	public boolean link() {
		return out;
	}
	
}
