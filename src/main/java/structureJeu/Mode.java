package structureJeu;

import importData.LoaderProperties;
import outilsJeu.CodeJeu;
import outilsJeu.Symbole;

public class Mode {
	
	
	protected int codeSecret ;
	protected int codeJoueur ;
	protected int essai = 1;

	
	/**
	 * methode s'occupant du deroulement du premier mode de jeu
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
	    int bornesP [] = {10,10,10,10};
	    int bornesM [] = {0,0,0,0};
		Symbole symb = new Symbole(bornesP,bornesM);
		
		System.out.println("Vous disposez de "+ a + " essais");
		
		setCodeSecret(df.lgCodeOrdi(b));
		System.out.println("Voici le code secret de l'ordinateur " + getCodeSecret());
		System.out.println("Tapez un code " + b + " chiffres");
		setCodeJoueur(df.lgCodeUti(b,b));
		System.out.println("le code secret est "+ getCodeSecret());
		System.out.println("le code proposé par le joueur est "+ getCodeJoueur());
		symb.setCodeHumain(df.getCodeUti());
		symb.setCodeOrdi(df.getCodeOrdi());
		
		while(getCodeSecret() != getCodeJoueur() && a!=essai){
			symb.chsymb();
			System.out.println("Voici les indices pour touver le code secret " + symb.getSymb());
			setCodeJoueur(symb.getCodeHumain());
			System.out.println(symb.getCodeOrdi());
			symb.codeJ(b);
			
			System.out.println("Voici le nouveu code que vous avez entré " + getCodeJoueur());
			
			essai++;
			
			System.out.println("il ne vous reste plus que "+  (a-essai) +" essais");
			
		}
		
		if (essai < a) {
			System.out.println("Bravo Vous avez trouvé le code secret" + getCodeSecret() + " en "+ essai + " essais");
			System.out.println("YOU WIN !!!!");
		}else {
			System.out.println("GAME OVER");
		}
		


	}
	

	public int getCodeJoueur() {
		return codeJoueur;
	}
	public void setCodeJoueur(int number) {
		this.codeJoueur = number;
	}
	public int getCodeSecret() {
		return codeSecret;
	}
	public void setCodeSecret(int number) {
		this.codeSecret = number;
	}

	
}

