package structureJeu;





import outilsJeu.CodeJeu;
import outilsJeu.Symbole;
import outilsJeu.SymboleOrdi;

public class Defense extends Mode {
	
	/**
	 * methode s'occupant du deroulement du deuxieme mode de jeu
	 * modifie codeSecret
	 * modifie codeJoueur
	 * modifie essai
	 */
	
	public  void deroulerjeu() {
		
			
		
		
		
	    CodeJeu df = new CodeJeu(); 
	    
		Symbole symb = new SymboleOrdi(bornesM,bornesP);
		
		
		System.out.println("Vous disposez de "+ nombreDeTentative + " essais");
		System.out.println("Tapez un code secret a " + longueurCombinaison + " chiffres");
		setCodeSecret(df.CodeUtilisateur(longueurCombinaison,longueurCombinaison));
		System.out.println("Voici le code secret que vous venez de entré " + getCodeSecret());
		
		setCodeJoueur(df.CodeOrdinateur(longueurCombinaison));
		System.out.println("le code secret est "+ getCodeSecret());
		System.out.println("le code proposé par l'ordinateur "+ getCodeJoueur());
		
		
		symb.setCodeHumain(df.getCodeUti());
		symb.setCodeOrdi(df.getCodeOrdi());
		
		
		
		
		
		
		while(getCodeSecret() != getCodeJoueur() && nombreDeTentative!=essai){
			System.out.println("entrer une combinaison de " + longueurCombinaison + " symboles");
			symb.chsymb();
			int A=symb.getCodeHumain();
			int g=symb.getCodeOrdi();
			String SymboleVraie =symb.verificationUtilisateur(A,g);
			if (dev.equals("True")) {
			System.out.println(SymboleVraie);
			}
			while(!SymboleVraie.equals(symb.getSymb())){
				System.out.println("Vous avez noté une combinaison mauvaise");
				System.out.println("entrer une combinaison de " +longueurCombinaison + " symboles");
				System.out.println("le code secret est "+ String.valueOf(getCodeSecret()));
				
				System.out.println("le code proposé par l'ordinateur "+ String.valueOf(getCodeJoueur()));
				symb.chsymb();
			}
			
			
			System.out.println("voici les 4 symboles entré " +symb.getSymb());
			symb.codeJ(longueurCombinaison);
			setCodeJoueur(symb.getCodeOrdi());
			if (dev.equals("True")) {
			System.out.println("le code secret est "+String.valueOf( getCodeSecret()));
			}
			System.out.println("Voici le nouveu code que l'ordinateur a entré " +String.valueOf( symb.getCodeOrdi()));
			
			essai++;
			
			System.out.println("il ne reste plus que "+  (nombreDeTentative-essai) +" essais a l'ordinateur");
			
		}if (essai < nombreDeTentative) {
			System.out.println("L'ordinateur a trouvé le code secret" + String.valueOf(getCodeSecret()) + " en "+ essai + " essais");
			System.out.println("GAME OVER");
		}else {
			
			System.out.println("YOU WIN !!!!");
			
		}
		
		
	}

}
