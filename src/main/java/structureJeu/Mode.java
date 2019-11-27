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
	protected String dev = "False";
	protected int longueurCombinaison=4;
	protected int nombreDeTentative=8;
	protected int bornesP [] = {10,10,10,10};
	protected int bornesM [] = {0,0,0,0};
	
	
	
	/*
	 * methode permettant de changer les variables longueurCombinaison et nombreDeTentative en appelant la classe PropertiesCache 
	 */
	public void chargerDonneesProperties() {
		
		this.longueurCombinaison  = Integer.parseInt(LoaderProperties.getInstance().getProperty("longueurCombinaison"));
		this.nombreDeTentative = Integer.parseInt(LoaderProperties.getInstance().getProperty("nombreDeTentative"));
		
	}
	
	
	
	
	
	/**
	 * s'occupe deroulement du mode de jeu
	 */
	public abstract  void deroulerjeu();
	
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
		
		
		
		
		this.dev = LoaderProperties.getInstance().getProperty("dev");
		
	}
	
	
	
}

