package structureJeu;

import importData.LoaderProperties;

public abstract class Mode {
	
/*
 * codeSecret correspond au code secret 
 * codeJoueur 	correspond au code du joueur
 * essai correspond au nombre d'essai
 * dev est un string informant le code si il s'execute en mode développeur ou en mode normal 
 */
	protected int codeSecret ;
	protected int codeJoueur ;
	protected int essai = 1;
	protected String dev ;
	protected int longueurCombinaison;
	protected int nombreDeTentative;
	protected int bornesP [] = {10,10,10,10};
	protected int bornesM [] = {0,0,0,0};
	
	
	
	/*
	 * methode permettant de changer les variables longueurCombinaison et nombreDeTentative en appelant la classe PropertiesCache 
	 */
	public void chargerDonneesProperties() {
		LoaderProperties dbInfo = LoaderProperties.instance();
		this.longueurCombinaison  = Integer.parseInt(dbInfo.longueurCombinaison);
		this.nombreDeTentative =Integer.parseInt(dbInfo.nombreDeTentative);
		this.dev =dbInfo.dev;
		
	}
	
	
	
	
	
	/**
	 * s'occupe deroulement du mode de jeu
	 */
	public abstract  void deroulerjeu();
	
	
	/*
	 * méthode gérant l'affichage en cas de victoire
	 */
	public abstract  void affichageVictoire();
	
	/*
	 * méthode gérant l'affichage en cas de défaite
	 */
	public abstract  void affichageDefaite();
	
	
	/*
	 * affiche le nombre de tentative 
	 */

	
	public void affichageNombreDeTentative() {
		// TODO Auto-generated method stub
		System.out.println("Vous disposez de "+ nombreDeTentative + " essais");
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
 * gere le mode developpeur
 */
	public void affichageDev() {
		if (dev.equals("True")) {
			
			System.out.println("Voici le code secret de l'ordinateur " +String.valueOf(getCodeSecret()));
			}
	}
	
	/*
	 * Affiche les instruction du joueur
	 */
	public void affichageJoueur(){
		System.out.println("Tapez un code composé de " + longueurCombinaison + " chiffres");
		
	}


/*
 * affiche les instruction si la combinaison de symbole est fausse
 */


public void affichageSymboleFaux() {
	System.out.println("Vous avez noté une fausse combinaison");
	System.out.println("Entrer une combinaison de " +longueurCombinaison + " symboles");
	System.out.println("Le code secret est "+ String.valueOf(getCodeSecret()));
	
	System.out.println("Le code proposé par l'ordinateur "+ String.valueOf(getCodeJoueur()));
	
}
}


