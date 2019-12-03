package structureJeu;

import org.apache.log4j.Logger;

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
		
		Logger log = Logger.getLogger(Parti.class);
		CodeJeu df = new CodeJeu();
	    
		Symbole symb = new Symbole(bornesP,bornesM);
		
		affichageNombreDeTentative();
		
		setCodeSecret(df.CodeOrdinateur(longueurCombinaison));
		
		affichageDev();
		affichageJoueur();
		setCodeJoueur(df.CodeUtilisateur(longueurCombinaison,longueurCombinaison));
		
		
		
		//System.out.println("le code proposé par le joueur est "+ String.valueOf(getCodeJoueur()));
		affichageDev();
		symb.setCodeHumain(df.getCodeUti());
		symb.setCodeOrdi(df.getCodeOrdi());
		
		while(getCodeSecret() != getCodeJoueur() && nombreDeTentative!=essai){
			
			
			symb.chsymb();
			System.out.println("Voici les indices pour touver le code secret " + symb.getSymb());
			
			
			
			
			symb.codeJ(longueurCombinaison);
			setCodeJoueur(symb.getCodeHumain());
			
			if (getCodeSecret() != getCodeJoueur() && nombreDeTentative > essai) {
			System.out.println("Voici le nouveu code que vous avez proposé " + String.valueOf(getCodeJoueur()));
			affichageDev();
			essai++;
			
			System.out.println("il ne vous reste plus que "+  (nombreDeTentative-essai) +" essais");
			}
			
		}
		
		if (essai < nombreDeTentative) {
			affichageVictoire();
			log.info("le joueur a gagné");
		}else if ( essai == nombreDeTentative) {
			
			affichageDefaite();
			log.info("le joueur a perdu");
		}else {
			
		}
		
	
		
		
		

	}

	
public  void affichageVictoire(){
	System.out.println("Bravo Vous avez trouvé le code secret " + String.valueOf(getCodeSecret() )+ " en "+ essai + " essais");
	System.out.println("YOU WIN !!!!");
}


public  void affichageDefaite(){
	System.out.println("GAME OVER");
	System.out.println("Le code secret était "+ getCodeSecret());
	
}




}
