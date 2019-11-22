package outilsJeu;

import java.util.Random;

import structureJeu.App;


public class CodeJeu {

	private int codeOrdi;
	private int codeUti;
	
	
	
	/**
	 * fonction retournant une combinaison au hasard a n chiffres
	 * @param nbre le parametre nbre correpond au nbre de chiffre dans la combinaison
	 * @return combinaison de l'ordinateur
	 */
	public int CodeOrdinateur (int nbre){
		double p = Math.pow(10,nbre);
		int borneP = (int)p;
		double v = Math.pow(10,nbre-1);
		int borneM = (int)v;
		
		Random r = new Random();
		
		codeOrdi = borneM +r.nextInt(borneP - borneM);
		 	
		return codeOrdi;
	}
	
	/**
	 * fonction retournant une combinaison saisi par l'utilisateur a n chiffre 
	 * @param nbre le parametre nbre correpond au nbre de chiffre dans la combinaison
	 * @return combinaison utilisateur
	 */
	
	    public int  CodeUtilisateur(int nbre, int number) {
	    
	    	
			
			
			String d ;
        
			do {
				do {
					if (App.SCANNER.hasNextInt()) {
						
					}else {
						System.out.println(" Entrez Uniquement un code a " + number + "chiffres");
						App.SCANNER.next();
					}
				}while(!App.SCANNER.hasNextInt()) ;
				codeUti = App.SCANNER.nextInt();
				d = Integer.toString(codeUti);
				if(d.length() != number) {
					System.out.println(" Entrez Uniquement un code a " + number + "chiffres svp" );
				}else if(d.length() == number) {
					
					
				}
	  
      
     
			}while(d.length() != number) ;
			//scan.close();
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
