package structureJeu;

import importData.LoaderProperties;
import outilsJeu.CodeJeu;
import outilsJeu.Symbole;
import outilsJeu.SymboleOrdi;

public class Defense extends Mode {
	
	/**
	 * methode s'occupant du deroulement du deuxieme mode de jeu
	 * modifie codeSecret
	 * modifie codeJoueur
	 * essai
	 */
	
	public  void deroulerjeu() {
		LoaderProperties pd = new LoaderProperties();
		String [] propriete = pd.configurationPropriete();
		String longueurCombinaison = propriete[0];
		int b = Integer.parseInt(longueurCombinaison);	
		String nombreDeTentative = propriete[1];
		int a = Integer.parseInt(nombreDeTentative);	
		
		
		
	    CodeJeu df = new CodeJeu(); 
	    int bornesP [] = {9,9,9,9};
	    int bornesM [] = {0,0,0,0};
		Symbole symb = new SymboleOrdi(bornesM,bornesP);
		
		
		System.out.println("Vous disposez de "+ a + " essais");
		System.out.println("Tapez un code secret" + b + " chiffres");
		setCodeSecret(df.lgCodeUti(b,b));
		System.out.println("Voici le code secret que vous venez de rentrer" + getCodeSecret());
		
		setCodeJoueur(df.lgCodeOrdi(b));
		System.out.println("le code secret est "+ getCodeSecret());
		System.out.println("le code proposé par l'ordinateur "+ getCodeJoueur());
		symb.setCodeHumain(df.getCodeUti());
		symb.setCodeOrdi(df.getCodeOrdi());
		System.out.println("le code" + symb.getCodeOrdi());
		
		
		while(getCodeSecret() != getCodeJoueur() && a!=essai){
			System.out.println("entrer une combinaison de " + b + " symboles");
			symb.chsymb();
			System.out.println("voici les 4 symboles entré" +symb.getSymb());
			symb.codeJ(b);
			setCodeJoueur(symb.getCodeOrdi());
			System.out.println("Voici le nouveu code que l'ordi a entré " + symb.getCodeOrdi());
			
			essai++;
			
			System.out.println("il ne reste plus que "+  (a-essai) +" essais a l'ordinateur");
			
		}if (essai < a) {
			System.out.println("L'ordinateur a trouvé le code secret" + getCodeSecret() + " en "+ essai + " essais");
			System.out.println("GAME OVER");
		}else {
			
			System.out.println("YOU WIN !!!!");
			
		}
		
		
	}

}
