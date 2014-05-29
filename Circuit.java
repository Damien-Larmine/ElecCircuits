	public class Circuit {

		private static CompIN ins[] = new CompIN[10];
		private static CompOUT outs[] = new CompOUT[10];
		
		private static CompOR compOrs[] = new CompOR[50];
		private static CompAND compAnds[]= new CompAND[50];
		private static CompNO compNos[]= new CompNO[50];
		private static CompXOR compXors[]= new CompXOR[50];
		
		private static CompLink compLink[] = new CompLink[100];
		
		private static FileReader fileReader;
		
		private static Commande[] commande = new Commande[50];
		
	public static void main(String args[]) {
		
		creerCircuit(args[0]);
		afficherCircuit();
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
	System.out.println(" Entrees  | Sortie  ");
	System.out.println("----------|--------");	


	for(int j = 0; j < 2; j++){	

   	    if(j == 0){ins[0].setInA(false);}
   	    if(j == 1){ins[0].setInA(true);}
	
   	    for(int k = 0; k < 2; k++){

	        if(k == 0){ins[1].setInA(false);}
   		if(k == 1){ins[1].setInA(true);}

		for(int i=0; i<50; i++){
	  	  if(compLink[i] != null){
	   	  effectuerLiaison(compLink[i]);
          	  }
		}
		   int x = ins[0].getOut() == true ? 1 : 0;
       		   int y = ins[1].getOut() == true ? 1 : 0;
       		   int z = outs[0].getOut() == true ? 1 : 0;

       		   System.out.println("  "+x+" |  "+y+"  |   "+z+"  ");

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
		
		for(int i=0;i<50;i++){
		  if(compLink[i] == null){
		     compLink[i] = new CompLink("link"+i,composant1,Integer.parseInt(entreeComp1),composant2,Integer.parseInt(entreeComp2));
		     return;
		  }
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

private static CompOUT rechercherOUT(String s) {
		for(int i = 0; i<10; i+=1){
			if(outs[i].getName().equals(s)){
				return outs[i];
			}
		}
		return null;
	}

private static void effectuerLiaison(CompLink liaison){

     String entree = liaison.getComp1();
     switch(entree.charAt(0)){
       case 'i':
	CompIN tempIN = rechercherIN(entree);
	if(tempIN != null){
	  linkIN(tempIN,liaison);
	}
	break;
      case 'a':
	CompAND tempAND = rechercherAND(entree);
	if(tempAND != null){
	  linkAND(tempAND,liaison);
	}
	break;
      case 'n':
	CompNO tempNO = rechercherNO(entree);
	if(tempNO != null){
	  linkNO(tempNO,liaison);
	}
	break;
      case 'x':
	CompXOR tempXOR = rechercherXOR(entree);
	if(tempXOR != null){
	  linkXOR(tempXOR,liaison);
	}
	break;
     case 'o':
	CompOR tempOR = rechercherOR(entree);
	if(tempOR != null){
	  linkOR(tempOR,liaison);
	}
	break;
}

}

private static void linkIN(CompIN in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}
  	break;
  }

}

private static void linkOR(CompOR in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}break;
       }
	
}

private static void linkAND(CompAND in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}break;
       }
	
}

private static void linkXOR(CompXOR in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}break;
       }
	
}

private static void linkNO(CompNO in,CompLink liaison){
  String sortie = liaison.getComp2();
  switch(sortie.charAt(0)){
  case 'a' :
	CompAND tempAND = rechercherAND(sortie);
  	if(tempAND != null){
	  if(liaison.getIn2() == 1){
	  tempAND.setInA(in.getOut());
	  }
	  else{
	  tempAND.setInB(in.getOut());
	  }
	}
	break;
case 'x' :
	CompXOR tempXOR = rechercherXOR(sortie);
  	if(tempXOR != null){
	  if(liaison.getIn2()== 1){
	  tempXOR.setInA(in.getOut());
	  }
	  else{
	  tempXOR.setInB(in.getOut());
	  }
	}
	break;
case 'n' :
	CompNO tempNO = rechercherNO(sortie);
  	if(tempNO != null){
	  tempNO.setInA(in.getOut());
	}
	break;
case 'o' :
	if(sortie.charAt(1) == 'r'){
	  CompOR tempOR = rechercherOR(sortie);
  	  if(tempOR != null){
	    if(liaison.getIn2() == 1){
	      tempOR.setInA(in.getOut());
	    }
	    else{
	      tempOR.setInB(in.getOut());	  
	    }
          }
	}
	else{
	  CompOUT tempOUT = rechercherOUT(sortie);
	  if(tempOUT != null){
	    tempOUT.setInA(in.getOut());
	  }
	}break;
       }
}


	
}
