package structureJeu;





import org.apache.log4j.Logger;

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
		
			
		Logger log = Logger.getLogger(Parti.class);
		
		
	    CodeJeu df = new CodeJeu(); 
	    
		Symbole symb = new SymboleOrdi(bornesM,bornesP);
		
		
		System.out.println("Vous disposez de "+ nombreDeTentative + " essais");
		System.out.println("Tapez un code secret à " + longueurCombinaison + " chiffres");
		setCodeSecret(df.CodeUtilisateur(longueurCombinaison,longueurCombinaison));
		System.out.println("Voici le code secret que vous venez de proposer " + getCodeSecret());
		
		setCodeJoueur(df.CodeOrdinateur(longueurCombinaison));
		
		System.out.println("Le code proposé par l'ordinateur "+ getCodeJoueur());
		
		
		symb.setCodeHumain(df.getCodeUti());
		symb.setCodeOrdi(df.getCodeOrdi());
		
		
		
		
		
		
		while(getCodeSecret() != getCodeJoueur() && nombreDeTentative!=essai){
			affichageJoueur();
			symb.chsymb();
			int A=symb.getCodeHumain();
			int g=symb.getCodeOrdi();
			String SymboleVraie =symb.verificationUtilisateur(A,g);
			if (dev.equals("True")) {
			System.out.println(SymboleVraie);
			}
			while(!SymboleVraie.equals(symb.getSymb())){
				affichageSymboleFaux();
				symb.chsymb();
			}
			
			
			System.out.println("Voici les " + longueurCombinaison + " symboles que vous avez proposé " +symb.getSymb());
			System.out.println("Le code secret est "+ String.valueOf(getCodeSecret()));
			symb.codeJ(longueurCombinaison);
			setCodeJoueur(symb.getCodeOrdi());
			affichageDev();
			System.out.println("Voici le nouveu code que l'ordinateur a proposé " +String.valueOf( symb.getCodeOrdi()));
			
			essai++;
			if(!SymboleVraie.equals(symb.getSymb())) {
			System.out.println("Il ne reste plus que "+  (nombreDeTentative-essai) +" essais à l'ordinateur");
			}else {
				
			}
			
		}if (essai < nombreDeTentative) {
			affichageDefaite();
			log.info("le joueur a perdu");
		}else {
			
			affichageVictoire();
			log.info("le joueur a gagné");
		}
		
		
	}

	@Override
	public void affichageVictoire() {
		// TODO Auto-generated method stub
		System.out.println("YOU WIN !!!!");
		System.out.println("L'ordinateur n'a pas trouvé votre code secret");
		
	}

	@Override
	public void affichageDefaite() {
		// TODO Auto-generated method stub
		System.out.println("L'ordinateur a trouvé le code secret " + String.valueOf(getCodeSecret()) + " en "+ essai + " essais");
		System.out.println("GAME OVER");
		
	}

}
