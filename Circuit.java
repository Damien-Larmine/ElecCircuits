	public class Circuit {

		private static int ins = 0;
		private static int outs = 0;
		
		private static CompOR compOrs[] = new CompOR[50];
		private static CompAND compAnds[]= new CompAND[50];
		private static CompNO compNos[]= new CompNO[50];
		private static CompXOR compXors[]= new CompXOR[50];
		private static CompLink compLinks[]= new CompLink[100];
		
		private static FileReader fileReader;
		
		private static Commande[] commande = new Commande[50];
		
	public static void main(String args[]) {

		/*boolean in1 = false, in2 = false;
		boolean out1 = false;
		int x,y,z;*/

		
		creerCircuit("hey");
		afficherCircuit();
		/*CompOR or1 = new CompOR("or1");
		CompNO no1 = new CompNO("no1");

		CompLink link1 = new CompLink("link1");
		CompLink link2 = new CompLink("link2");
		CompLink link3 = new CompLink("link3");
		CompLink link4 = new CompLink("link4");

		System.out.println(" Entrees  | Sortie  ");
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
			}*/
		}
	
	public static void creerCircuit(String s){
		fileReader = new FileReader();
		commande = fileReader.lectureFichier(s);
		
		for(int i = 0;i<50;i++){
			if(commande[i] != null){
				traiterCommande(commande[i]);
			}
		}
	}

	public static void afficherCircuit(){
		System.out.println(ins);
		System.out.println(outs);
		for(int i = 0; i < 50; i++){
			if(compOrs[i] != null){
			System.out.println(compOrs[i].getName());
			}
			if(compXors[i] != null){
			System.out.println(compXors[i].getName());
			}
			if(compAnds[i] != null){
			System.out.println(compAnds[i].getName());
			}
			if(compNos[i] != null){
			System.out.println(compNos[i].getName());
			}
		}
	}
	
	public static void traiterCommande(Commande c){

		String motCommande = c.getMotCommande();
		if (motCommande.equals("composant")) {
			creerComposant(c);
		}
		else if (motCommande.equals("liaison")){
			//creerLiaison(c);
		}
	}
	
	public static void creerComposant(Commande c){
		String nomComposant = c.getMot2();
		String typeComposant = c.getMot3();
		if(typeComposant.equals("IN")){
			ins += 1;
		}
		else if (typeComposant.equals("OUT")){
			outs += 1;
		}
		else if (typeComposant.equals("OR")){
			for(int i = 0; i < 50; i++){
				if(compOrs[i] == null){
					compOrs[i] = new CompOR(nomComposant);
					return;
				}
			}
		}
		else if (typeComposant.equals("AND")){
			for(int i = 0; i < 50; i++){
				if(compAnds[i] == null){
					compAnds[i] = new CompAND(nomComposant);
					return;
				}
			}
		}
		else if (typeComposant.equals("XOR")){
			for(int i = 0; i < 50; i++){
				if(compXors[i] == null){
					compXors[i] = new CompXOR(nomComposant);
					return;
				}
			}
		}
		else if (typeComposant.equals("NO")){
			for(int i = 0; i < 50; i++){
				if(compNos[i] == null){
					compNos[i] = new CompNO(nomComposant);
					return;
				}
			}
		}
	}
	
	}
