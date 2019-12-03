package structureJeu;


import org.apache.log4j.Logger;

import outilsJeu.CodeJeu;
import outilsJeu.Symbole;
import outilsJeu.SymboleOrdi;

public class Duel extends Mode {
	
	/**
	 * codeSecret1 : code Secret de l'ordinateur dans la phase de jeu ou le joueur attaque
	 * codeJoueur1 : code Proposé par le joueur humain
	 */
	
	protected int codeSecret1 ;
	protected int codeJoueur1 ;
	
	/**
	 * methode s'occupant du deroulement du troisieme mode de jeu
	 * modifie codeSecret
	 * modifie codeJoueur
	 * essai
	 */

	public  void deroulerjeu() {
			
		
		Logger log = Logger.getLogger(Parti.class);
		
	    CodeJeu humJ = new CodeJeu(); 
	    CodeJeu ordJ = new CodeJeu();
	    
	  
		Symbole symb = new SymboleOrdi(bornesM,bornesP);
		Symbole symb1  = new Symbole(bornesM,bornesP);
		
		
		System.out.println("Vous allez effectuer un Duel avec l'ordinateur tour par tour");
		System.out.println("L'ordinateur va commencer à attaquer");
		affichageJoueur();
		setCodeSecret(ordJ.CodeUtilisateur(longueurCombinaison,longueurCombinaison));
		System.out.println("Voici le code secret que vous venez de rentrer : " + String.valueOf(getCodeSecret()));
		
		setCodeJoueur(ordJ.CodeOrdinateur(longueurCombinaison));
		symb.setCodeHumain(ordJ.getCodeUti());
		symb.setCodeOrdi(ordJ.getCodeOrdi());
		System.out.println("le code proposé par l'ordinateur est " + String.valueOf( getCodeJoueur()));
		
		
		
		System.out.println("A votre tour d'attaquer");
		setCodeSecret1(humJ.CodeOrdinateur(longueurCombinaison));
		
		affichageDev1();
		
		System.out.println("Tapez un code composé de " + longueurCombinaison + " chiffres");
		setCodeJoueur1(humJ.CodeUtilisateur(longueurCombinaison,longueurCombinaison));
		
		System.out.println("Le code proposé par le joueur est : "+ String.valueOf(getCodeJoueur1()));
		symb1.setCodeHumain(humJ.getCodeUti());
		symb1.setCodeOrdi(humJ.getCodeOrdi());
		System.out.println("C'est parti le jeu commence");
		
		do {
			System.out.println("Tour " + essai);
			System.out.println("L'ordinateur attaque");
			System.out.println("Voici le code secret que vous avez rentré " + String.valueOf(getCodeSecret()));
			System.out.println("Voici le code proposé par l'ordinateur "+String.valueOf( getCodeJoueur()));
			System.out.println("Entrer une combinaison de " + longueurCombinaison + " symboles");
			symb.chsymb();
			int A=ordJ.getCodeUti();
			int g=ordJ.getCodeOrdi();
			String SymboleVraie =symb.verificationUtilisateur(A,g);
			while(!SymboleVraie.equals(symb.getSymb())){
				affichageSymboleFaux();
				symb.chsymb();
			}
			
			System.out.println("voici les " + longueurCombinaison+ " symboles entré" +symb.getSymb());
			symb.codeJ(longueurCombinaison);
			setCodeJoueur(symb.getCodeOrdi());
			System.out.println("Voici le nouveu code que l'ordi a entré " + String.valueOf(symb.getCodeOrdi()));
			
			////////////////////////////////////////////////////////////////////////////
			System.out.println("Vous attaquez");
			affichageDev1();
			System.out.println("Voici le code que vous avez proposé "+ String.valueOf(getCodeJoueur1()));
			symb1.chsymb();
			
			System.out.println("Voici les indices pour touver le code secret " + symb1.getSymb());
			
			affichageJoueur();
			symb1.codeJ(longueurCombinaison);
			setCodeJoueur1(symb1.getCodeHumain());
			System.out.println("Voici le nouveu code que vous avez entré " + getCodeJoueur1());
			
			essai++;
			
			
			
		}while(getCodeSecret() != getCodeJoueur() && getCodeSecret1() != getCodeJoueur1());
		
		if (getCodeSecret() == getCodeJoueur()) {
			affichageDefaite();
			log.info("le joueur a perdu");
		}else {
			affichageVictoire();
			log.info("le joueur a gagné");
		}
		
		
		
		
		
	}

	
	/**
	 * retourne codeJoueur1
	 * @return CodeJoueur1
	 */
	public int getCodeJoueur1() {
		return codeJoueur1;
	}
	/**
	 * modifie codeJoueur1
	 * @param number
	 */
	public void setCodeJoueur1(int number) {
		this.codeJoueur1 = number;
	}
	/**
	 * retourne codeSecret1
	 * @return CodeSecret1
	 */
	
	public int getCodeSecret1() {
		return codeSecret1;
	}
	
	/**
	 * modifie codeSecret1
	 * @param number
	 */
	public void setCodeSecret1(int number) {
		this.codeSecret1 = number;
	}


	@Override
	public void affichageVictoire() {
		// TODO Auto-generated method stub
		System.out.println("YOU WIN");
	}


	@Override
	public void affichageDefaite() {
		// TODO Auto-generated method stub
		System.out.println("GAME OVER");
	}

	
	
	/*
	 * affichage codeSecret1 en mode dev
	 */
	public void affichageDev1() {
if (dev.equals("True")) {
			
			System.out.println("Voici le code secret de l'ordinateur : " + String.valueOf(getCodeSecret1()));
			}
	}
}






