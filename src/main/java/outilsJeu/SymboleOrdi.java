package outilsJeu;



import java.util.Random;
import java.util.Scanner;

//import structureJeu.App;





public class SymboleOrdi extends Symbole {
	
	
	
	/**
	 * 
	 * @param borneM
	 * @param borneP
	 */
	public SymboleOrdi(int[] borneM, int[] borneP) {
		super(borneM, borneP);
	}

	/**
	 * fonction premettant a l'utilisateur d'entrer une combinaison de symbole
	 */

	public void chsymb() {
		Scanner scan = new Scanner(System.in);
		 //App.SCANNER.next();
		this.symb  = scan.nextLine();
		
		
	}

	 /**
	  * fonction proposant pour chaque chiffre, un chiffre au hasard  en prenant en compte les BornesP et les Bornes M 
	  * cette fonction initialise les bornes tour a tour en fonction des signe 
	  * si le signe est plus la borneM change et prend la valeur du chiffre de l'ancienne combi
	  * si le signe est moins c'est l'inverse
	  * si le signe est egale le chiffre ne change pas
	  * 
	  */
	public void codeJ(int number) {
	
		//String combisymb = mot ;
		String anciencombi = String.valueOf(codeOrdi);
		int chiffre;
		String A ;
		String B ;
		
		StringBuilder symbole =  new StringBuilder() ;
		
for (int i=0; i<=anciencombi.length()-1;i++) {
			
			char v = symb.charAt(i);
			String vv = String.valueOf(v);
			char car = anciencombi.charAt(i);
			String car1 = String.valueOf(car);
			int car2 = Integer.parseInt(car1);
			Random rand = new Random();
			if ( vv.equals("+")) {
			
			
			
			
			this.borneM[i]=car2;
			
			//chiffre = rand.nextInt(borneP[i] - borneM[i] + 1) + borneM[i] ;
			chiffre = borneM[i] + rand.nextInt(borneP[i] - borneM[i] );
			while(chiffre==borneM[i]) {
				chiffre=borneM[i] + rand.nextInt(borneP[i] - borneM[i] );
			}
			A = Integer.toString(chiffre);
			symbole.append(A);
			
			}else if (vv.equals("-")) {
				
				
				this.borneP[i]=car2;
				
			//	int valeur = valeurMin + r.nextInt(valeurMax - valeurMin)
				chiffre = borneM[i] + rand.nextInt(borneP[i] - borneM[i] ) ;
				
				A = Integer.toString(chiffre);
				symbole.append(A);
				
			}else {
				
				chiffre = car2;
				A = Integer.toString(chiffre);
				symbole.append(A);
			}
			//System.out.println(vv+" "+car2+" "+borneP[i]+" "+ borneM[i] +" "+ chiffre);
			
			
			
			
		}
		B = symbole.toString();
	
		this.codeOrdi= Integer.parseInt(B);
		
		
			
		
	}
	
	
	
	
	
	
	
}
