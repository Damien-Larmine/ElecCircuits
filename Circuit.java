	public class Circuit {

		private static CompIN ins[] = new CompIN[10];
		private static CompOUT outs[] = new CompOUT[10];
		
		private static CompOR compOrs[] = new CompOR[50];
		private static CompAND compAnds[]= new CompAND[50];
		private static CompNO compNos[]= new CompNO[50];
		private static CompXOR compXors[]= new CompXOR[50];
		
		private static CompLinkIN compLinkIns[] = new CompLinkIN[50];
		private static CompLinkAND compLinkAnds[] = new CompLinkAND[50];
		private static CompLinkOR compLinkOrs[] = new CompLinkOR[50];
		private static CompLinkXOR compLinkXors[] = new CompLinkXOR[50];
		private static CompLinkNO compLinkNos[] = new CompLinkNO[50];
		
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
		for(int i = 0; i < 50; i++){
			if(ins[i] != null){
				System.out.println(ins[i].getName());
			}
			if(outs[i] != null){
				System.out.println(outs[i].getName());
			}
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
			if(outs[i] != null){
				System.out.println(outs[i].getInA());
			}
		}
	}
	
	public static void traiterCommande(Commande c){

		String motCommande = c.getMotCommande();
		if (motCommande.equals("composant")) {
			creerComposant(c);
		}
		else if (motCommande.equals("liaison")){
			creerLiaison(c);
		}
	}
	
	public static void creerComposant(Commande c){
		String nomComposant = c.getMot2();
		String typeComposant = c.getMot3();
		if(typeComposant.equals("IN")){
			for(int i = 0; i < 10; i++){
				if(ins[i] == null){
					ins[i] = new CompIN(nomComposant);
					return;
				}
			}
		}
		else if (typeComposant.equals("OUT")){
			for(int i = 0; i < 10; i++){
				if(outs[i] == null){
					outs[i] = new CompOUT(nomComposant);
					return;
				}
			};
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
	
	private static void creerLiaison(Commande c) {
		String composant1 = c.getMot2();
		String entreeComp1 = c.getMot3();
		String composant2 = c.getMot4();
		String entreeComp2 = c.getMot5();
		
		int nbin = 1,nbor = 1, nband = 1, nbno = 1,nbxor = 1;
		
		
		switch(composant1.charAt(0)){
		   case 'i':
			   for(int i = 0; i < 50; i++){
					if(compLinkIns[i] == null){
						CompIN inRech = rechercherIN(composant1);
						if(inRech != null){
						compLinkIns[i] = new CompLinkIN("link"+nbin,inRech);
						nbin += 1;
						break;
						}
					}
				}
			   break;
		   case 'x':
			   for(int i = 0; i < 50; i++){
					if(compLinkXors[i] == null){
						CompXOR inRech = rechercherXOR(composant1);
						if(inRech != null){
						compLinkXors[i] = new CompLinkXOR("link"+nbxor,inRech);
						nbxor += 1;
						break;
						}
					}
				}
			   break;
		   case 'a':
			   for(int i = 0; i < 50; i++){
					if(compLinkAnds[i] == null){
						CompAND inRech = rechercherAND(composant1);
						if(inRech != null){
						compLinkAnds[i] = new CompLinkAND("link"+nband,inRech);
						nband += 1;
						break;
						}
					}
				}
			   break;
		   case 'n':
			   for(int i = 0; i < 50; i++){
					if(compLinkNos[i] == null){
						CompNO inRech = rechercherNO(composant1);
						if(inRech != null){
						compLinkNos[i] = new CompLinkNO("link"+nbno,inRech);
						nbno += 1;
						break;
						}
					}
				}
			   break;
		   case 'o':
			   for(int i = 0; i < 50; i++){
					if(compLinkOrs[i] == null){
						CompOR inRech = rechercherOR(composant1);
						if(inRech != null){
						compLinkOrs[i] = new CompLinkOR("link"+nbor,inRech);
						nbor += 1;
						break;
						}
					}
				}
			   break;
		   default:
			   break;
		}
		
		
		
		
	}

	private static CompIN rechercherIN(String s) {
		for(int i = 0; i<10; i+=1){
			if(ins[i].getName().equals(s)){
				return ins[i];
			}
		}
		return null;
	}
	

	private static CompXOR rechercherXOR(String s) {
		for(int i = 0; i<50; i+=1){
			if(compXors[i].getName().equals(s)){
				return compXors[i];
			}
		}
		return null;
	}
	
	private static CompAND rechercherAND(String s) {
		for(int i = 0; i<50; i+=1){
			if(compAnds[i].getName().equals(s)){
				return compAnds[i];
			}
		}
		return null;
	}
	
	private static CompOR rechercherOR(String s) {
		for(int i = 0; i<50; i+=1){
			if(compOrs[i].getName().equals(s)){
				return compOrs[i];
			}
		}
		return null;
	}
	
	private static CompNO rechercherNO(String s) {
		for(int i = 0; i<50; i+=1){
			if(compNos[i].getName().equals(s)){
				return compNos[i];
			}
		}
		return null;
	}

	
}
