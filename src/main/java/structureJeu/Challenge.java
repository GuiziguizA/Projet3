package structureJeu;

import outilsJeu.CodeJeu;
import outilsJeu.Symbole;

public class Challenge extends Mode {

	/**
	 * s'occupant du deroulement du premier mode de jeu
	 * modifie codeSecret
	 * modifie codeJoueur
	 * modifie essai
	 */
public  void deroulerjeu() {
		
		
		CodeJeu df = new CodeJeu();
	    
		Symbole symb = new Symbole(bornesP,bornesM);
		
		System.out.println("Vous disposez de "+ nombreDeTentative + " essais");
		
		setCodeSecret(df.CodeOrdinateur(longueurCombinaison));
		
		
		if (dev.equals("True")) {
		
		System.out.println("Voici le code secret de l'ordinateur " +String.valueOf(getCodeSecret()));
		}
		System.out.println("Tapez un code " + longueurCombinaison + " chiffres");
		setCodeJoueur(df.CodeUtilisateur(longueurCombinaison,longueurCombinaison));
		
		
		
		System.out.println("le code proposé par le joueur est "+ String.valueOf(getCodeJoueur()));
		if (dev.equals("True")) {
			
			System.out.println("Voici le code secret de l'ordinateur " + String.valueOf(getCodeSecret()));
			}
		symb.setCodeHumain(df.getCodeUti());
		symb.setCodeOrdi(df.getCodeOrdi());
		
		while(getCodeSecret() != getCodeJoueur() && nombreDeTentative!=essai){
			
			
			symb.chsymb();
			System.out.println("Voici les indices pour touver le code secret " + symb.getSymb());
			
			
			
			
			symb.codeJ(longueurCombinaison);
			setCodeJoueur(symb.getCodeHumain());
			
			if (getCodeSecret() != getCodeJoueur() && nombreDeTentative > essai) {
			System.out.println("Voici le nouveu code que vous avez entré " + String.valueOf(getCodeJoueur()));
			if (dev.equals("True")) {
				
				System.out.println("Voici le code secret de l'ordinateur " + String.valueOf(getCodeSecret()));
				}
			essai++;
			
			System.out.println("il ne vous reste plus que "+  (nombreDeTentative-essai) +" essais");
			}
			
		}
		
		if (essai < nombreDeTentative) {
			System.out.println("Bravo Vous avez trouvé le code secret" + String.valueOf(getCodeSecret() )+ " en "+ essai + " essais");
			System.out.println("YOU WIN !!!!");
		}else if ( essai == nombreDeTentative) {
			System.out.println("GAME OVER");
		}else {
			
		}
		


	}






}
