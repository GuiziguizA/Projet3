package structureJeu;

import importData.LoaderProperties;
import outilsJeu.CodeJeu;
import outilsJeu.Symbole;
import outilsJeu.SymboleOrdi;

public class Duel extends Mode {
	
	protected int codeSecret1 ;
	protected int codeJoueur1 ;
	
	/**
	 * methode s'occupant du deroulement du troisieme mode de jeu
	 * modifie codeSecret
	 * modifie codeJoueur
	 * essai
	 */

	public  void deroulerjeu() {
		LoaderProperties pd = new LoaderProperties();
		String [] propriete = pd.configurationPropriete();
		String longueurCombinaison = propriete[0];
		int b = Integer.parseInt(longueurCombinaison);	
		
		
		
	    CodeJeu humJ = new CodeJeu(); 
	    CodeJeu ordJ = new CodeJeu();
	    
	    int bornesP [] = {9,9,9,9};
	    int bornesM [] = {0,0,0,0};
		Symbole symb = new SymboleOrdi(bornesM,bornesP);
		Symbole symb1  = new Symbole(bornesM,bornesP);
		
		
		System.out.println("Vous allé effectuer un Duel avec l'ordinateur tour par tour");
		System.out.println("L'ordinateur va commencer a chercher");
		System.out.println("Tapez un code secret " + b + " chiffres");
		setCodeSecret(ordJ.lgCodeUti(b,b));
		System.out.println("Voici le code secret que vous venez de rentrer " + getCodeSecret());
		
		setCodeJoueur(ordJ.lgCodeOrdi(b));
		symb.setCodeHumain(ordJ.getCodeUti());
		symb.setCodeOrdi(ordJ.getCodeOrdi());
		System.out.println("le code proposé par l'ordinateur "+ getCodeJoueur());
		
		
		
		System.out.println("A votre tour de jouer");
		setCodeSecret1(humJ.lgCodeOrdi(b));
		System.out.println("Voici le code secret de l'ordinateur " + getCodeSecret1());
		System.out.println("Tapez un code " + b + " chiffres");
		setCodeJoueur1(humJ.lgCodeUti(b,b));
		System.out.println("le code secret est "+ getCodeSecret1());
		System.out.println("le code proposé par le joueur est "+ getCodeJoueur1());
		symb1.setCodeHumain(humJ.getCodeUti());
		symb1.setCodeOrdi(humJ.getCodeOrdi());
		System.out.println("C'est parti le jeu commence");
		
		do {
			System.out.println("Tour " + essai);
			System.out.println("Ordinateur attaque");
			System.out.println("Voici le code secret que vous avez de rentrer " + getCodeSecret());
			System.out.println("Voici le code proposé par l'ordinateur "+ getCodeJoueur());
			System.out.println("entrer une combinaison de " + b + " symboles");
			symb.chsymb();
			System.out.println("voici les 4 symboles entré" +symb.getSymb());
			symb.codeJ(b);
			setCodeJoueur(symb.getCodeOrdi());
			System.out.println("Voici le nouveu code que l'ordi a entré " + symb.getCodeOrdi());
			
			////////////////////////////////////////////////////////////////////////////
			System.out.println("Vous attaquez");
			System.out.println("le code secret est "+ getCodeSecret1());
			System.out.println("Voici le code que vous avez proposé "+ getCodeJoueur1());
			symb1.chsymb();
			
			System.out.println("Voici les indices pour touver le code secret " + symb1.getSymb());
			
			System.out.println("entrer un code " + b + " chiffres");
			symb1.codeJ(b);
			setCodeJoueur1(symb1.getCodeHumain());
			System.out.println("Voici le nouveu code que vous avez entré " + getCodeJoueur1());
			
			essai++;
			
			
			
		}while(getCodeSecret() != getCodeJoueur() && getCodeSecret1() != getCodeJoueur1());
		
		if (getCodeSecret() == getCodeJoueur()) {
			System.out.println("GAME OVER");
		}else {
			System.out.println("YOU WIN");
		}
		
		
		
		
		
	}

	public int getCodeJoueur1() {
		return codeJoueur1;
	}
	public void setCodeJoueur1(int number) {
		this.codeJoueur1 = number;
	}
	public int getCodeSecret1() {
		return codeSecret1;
	}
	public void setCodeSecret1(int number) {
		this.codeSecret1 = number;
	}

	
}






