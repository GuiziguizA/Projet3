package structureJeu;

import importData.LoaderProperties;
import outilsJeu.CodeJeu;
import outilsJeu.Symbole;

public class Mode {
	
/*
 * codeSecret correspond au code secret 
 * codeJoueur 	correspond au code du joueur
 * essai correspond au nombre d'essai
 * dev est un string informant le code si il s'execute en mode développeur ou en mode normal 
 */
	protected int codeSecret ;
	protected int codeJoueur ;
	protected int essai = 1;
	protected String dev = "False";
	
	/**
	 * methode s'occupant du deroulement du premier mode de jeu
	 * modifie codeSecret
	 * modifie codeJoueur
	 * modifie essai
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
		
		
		if (dev.equals("True")) {
		
		System.out.println("Voici le code secret de l'ordinateur " + getCodeSecret());
		}
		System.out.println("Tapez un code " + b + " chiffres");
		setCodeJoueur(df.lgCodeUti(b,b));
		
		
		
		System.out.println("le code proposé par le joueur est "+ getCodeJoueur());
		if (dev.equals("True")) {
			
			System.out.println("Voici le code secret de l'ordinateur " + getCodeSecret());
			}
		symb.setCodeHumain(df.getCodeUti());
		symb.setCodeOrdi(df.getCodeOrdi());
		
		while(getCodeSecret() != getCodeJoueur() && a!=essai){
			
			
			symb.chsymb();
			System.out.println("Voici les indices pour touver le code secret " + symb.getSymb());
			
			
			
			
			symb.codeJ(b);
			setCodeJoueur(symb.getCodeHumain());
			
			if (getCodeSecret() != getCodeJoueur() && a > essai) {
			System.out.println("Voici le nouveu code que vous avez entré " + getCodeJoueur());
			if (dev.equals("True")) {
				
				System.out.println("Voici le code secret de l'ordinateur " + getCodeSecret());
				}
			essai++;
			
			System.out.println("il ne vous reste plus que "+  (a-essai) +" essais");
			}
			
		}
		
		if (essai < a) {
			System.out.println("Bravo Vous avez trouvé le code secret" + getCodeSecret() + " en "+ essai + " essais");
			System.out.println("YOU WIN !!!!");
		}else if ( essai == a) {
			System.out.println("GAME OVER");
		}else {
			
		}
		


	}
	
	/*
	 * Fonction permettant d'appeler la variable codeJoueur
	 */
	
	public int getCodeJoueur() {
		return codeJoueur;
	}
	
	/*
	 * Fonction permettant de changer la variable codeJoueur
	 */
	
	public void setCodeJoueur(int number) {
		this.codeJoueur = number;
	}
	
	/*
	 * Fonction permettant d'appeler la variable codeSecret
	 */
	
	public int getCodeSecret() {
		return codeSecret;
	}
	/*
	 * Fonction permettant de changer la variable codeSecret
	 */
	
	public void setCodeSecret(int number) {
		this.codeSecret = number;
	}

	
	
	/*
	 * Fonction permettant de changer la variable dev avec les configuration du fichier config.properties
	 */
	
	public void setdev() {
		LoaderProperties devCondition = new LoaderProperties();
		String [] Proprietes  = devCondition.configurationPropriete();
		
		
		
		
		this.dev = Proprietes[2];
		
	}
	
	
	
}

