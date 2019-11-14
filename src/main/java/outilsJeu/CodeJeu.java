package outilsJeu;

import java.util.Random;
import java.util.Scanner;

public class CodeJeu {

	private int codeOrdi;
	private int codeUti;
	
	
	
	/**
	 * fonction retournant une combinaison au hasard a n chiffres
	 * @param nbre le parametre nbre correpond au nbre de chiffre dans la combinaison
	 * @return combinaison de l'ordinateur
	 */
	public int lgCodeOrdi (int nbre){
		double p = Math.pow(10,nbre);
		int borneP = (int)p;
		double v = Math.pow(10,nbre-1);
		int borneM = (int)v;
		
		Random r = new Random();
		
		codeOrdi = borneM +r.nextInt(borneP - borneM);
		 	
		return codeOrdi;
	}
	
	/**
	 * fonction retournant une combinaison saisi par l'utilisateur a n chiffre a n chiffres
	 * @param nbre le parametre nbre correpond au nbre de chiffre dans la combinaison
	 * @return combinaison utilisateur
	 */
	
	    public int  lgCodeUti(int nbre, int number) {
	    
	    	double p = Math.pow(10,nbre);
			int borneP = (int)p;
			double v = Math.pow(10,nbre-1);
			int borneM = (int)v;
			Scanner scan = new Scanner(System.in);
			String d ;
        
			do {
				do {
					if (scan.hasNextInt()) {
						
					}else {
						System.out.println(" Entrez Uniquement un code a " + number + "chiffres");
						scan.next();
					}
				}while(!scan.hasNextInt()) ;
				codeUti = scan.nextInt();
				d = Integer.toString(codeUti);
				if(d.length() != number) {
					System.out.println(" Entrez Uniquement un code a " + number + "chiffres svp" );
				}else if(d.length() == number) {
					
					System.out.println("c'est bon " );
				}
	  
      
     
			}while(d.length() != number) ;
			return  codeUti;     
    }
	    
	    
	/**
	 * fonction retourne codeOrdi   
	 * @return
	 */
	    
	    public int getCodeOrdi() {
			return codeOrdi;
		}

	 /**
	  * fonctions modifi code ordi   
	  * @param codeOrdi
	  */
		public void setCodeOrdi(int codeOrdi) {
			this.codeOrdi = codeOrdi;
		}
		
		
		/**
		 * fonction retourne codeUti   
		 * @return
		 */
		
		public int getCodeUti() {
			return codeUti;
		}
		
		
		/**
		 * fonction retourne codeUti   
		 * @return
		 */

		public void setCodeUti(int codeUti) {
			this.codeUti = codeUti;
		}
	
	
	
	
	
	
}
