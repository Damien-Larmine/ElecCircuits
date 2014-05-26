	public class Circuit {

	public static void main(String args[]) {

		boolean in1 = false, in2 = false;
		boolean out1 = false;
		int x,y,z;

		CompOR or1 = new CompOR("or1");
		CompNO no1 = new CompNO("no1");

		CompLink link1 = new CompLink("link1");
		CompLink link2 = new CompLink("link2");
		CompLink link3 = new CompLink("link3");
		CompLink link4 = new CompLink("link4");

		System.out.println(" Entrées  | Sortie  ");
		System.out.println("----------|--------");

		for(int j = 0; j < 2; j++){	

   		   if(j == 0){in1 = false;}
		   if(j == 1){in1 = true;}
	
		   for(int i = 0; i < 2; i++){
			

			if(i == 0){in2 = false;}
			if(i == 1){in2 = true;}
		        no1.setIn(link1.link(in1));
		        or1.setInA(link2.link(no1.getOut()));
		        or1.setInB(link3.link(in2));

       		        out1 = link4.link(or1.getOut()); 
			
			x = in1 == true ? 1 : 0;
			y = in2 == true ? 1 : 0;
			z = out1 == true ? 1 : 0;

		        System.out.println("  "+x+" |  "+y+"  |   "+z+"  ");

                   }
		}
	}

}
