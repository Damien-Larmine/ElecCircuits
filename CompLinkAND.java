public class CompLinkAND extends Component{

private boolean out;
	

	public CompLinkAND(String name,CompAND a) {
		super(name);
		
		this.out = a.getOut();
	}

	public boolean link() {
		return out;
	}
}
