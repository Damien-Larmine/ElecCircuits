public class Circuit {

	public void main() {

		boolean in1 = false;
		boolean in2 = false;

		boolean out1 = false;

		CompOR or1 = new CompOR("or1");
		CompNO no1 = new CompNO("no1");

		createLink(in1, no1);
		createLink(no1.getOut(), or1);
		createLink(in2, or1);
		createLink(or1.getOut(), out1);

		System.out.println(out1);
	}

	void createLink(boolean a, CompNO c) {

	}

	void createLink(boolean a, CompOR c) {

	}

	void createLink(boolean a, boolean b) {

	}

	void createLink(boolean in1, CompAND c) {

	}

	void createLink(boolean in1, CompXOR c) {

	}

}
