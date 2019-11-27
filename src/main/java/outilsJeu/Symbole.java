package outilsJeu;




import structureJeu.App;



public class Symbole {
	/**
	 * symb : chaine de caractère acueillant les signes +-= 
	 * borneP : borne maximal 
	 * borneM : borne minimal
	 * codeHumain : code du joueur
	 * codeOrdi : code de l'ordinateur
	 */
	protected String symb ;
	protected int borneP [] ;
	protected int borneM [] ;
	protected int codeHumain;
	protected int codeOrdi;
	
	
	
	
	
	/**
	 * Methode modifiant BorneM et BorneP
	 * @param borneM
	 * @param borneP
	 */
	public Symbole(int [] borneM,int [] borneP) {
		
	
		this.borneM=borneM;
		this.borneP=borneP;
	
	}
	
	/**
	 * Fonction affichant les symboles +,-,= en fonction des de chaques chiffres de la combi
	 * Le code référence etant le code secret
	 * Modifie la variable symbole 
	 * @param number code secret 
	 * @param number1 code proposer par le joueur
	 */
	public void chsymb() {
		StringBuilder symbole = new StringBuilder();
		final String SEPARATEUR = "";
		// car va avec number
		char car;
		// car1 va avec number1
		char car1;
		String code;
		
		String proposition;
		code = String.valueOf(codeOrdi);
		proposition = String.valueOf(codeHumain);
		String mot[] = proposition.split(SEPARATEUR);
		
		for (int i = 0; i < mot.length; i++) {
		car = code.charAt(i);
		car1 = proposition.charAt(i);
		
		
		if ( car > car1) {
			symbole.append("+");
		}else if (car == car1) {
			symbole.append("=");
		}else {
			symbole.append("-");
		}
	
		
		
		}
		//System.out.println("les indices sont" + arraylist.get(0) + arraylist.get(1) + arraylist.get(2) + arraylist.get(3));
		 this.symb = symbole.toString();
		 
	}
	/**
	 * fonction retournant la valeur symbole
	 * @return symb
	 */
	public String getSymb() {
		return symb;
		
		
	}
	
	
/**
 * Fonctions scanner permettant de prendre en compte la reponse du joueur
 */
public void codeJ(int number) {
	String d;
	
	//Scanner scan = new Scanner(System.in);
	do {
	do{
		
		if (App.SCANNER.hasNextInt()) {
		
		}else {
			System.out.println(" Entrez Uniquement un code a " + number + "chiffres");
			App.SCANNER.next();
		}
		
	
	}while(!App.SCANNER.hasNextInt()) ;
	this.codeHumain=App.SCANNER.nextInt();
	d = Integer.toString(codeHumain);
	
	if(d.length() != number) {
		System.out.println(" Entrez Uniquement un code a " + number + "chiffres svp" );
	}else if(d.length() == number) {
	}
	
	System.out.println("longueur " + (d.length() ));
	
	}while(d.length() != number) ;
	
	//scan.close();
	}


/**
 * Fonction retournant codeHumain
 * @return
 */
public int getCodeHumain() {
	return codeHumain;
}

/**
 * Fonction retournant codeOrdi
 * @return
 */
public int getCodeOrdi() {
	return codeOrdi;
}

/**
 * Fonction retournant borneM
 * @return
 */

public int [] getBorneM() {
	
	return borneM;
}

/**
 * Fonction modifiant borneM
 * @param tableau
 */

public void setBorneM(int [] tableau) {
	
	this.borneM = tableau ;
}

/**
 * Fonction modifiant borneP
 * @param tableau
 */
public void setBorneP(int [] tableau) {
	
	this.borneP = tableau ;
}

/**
 * Fonction retournant borneP[i]
 * @return
 */

public int [] getBorneP() {
	
	return borneP;
}

/**
 * fonction modifiant codeHumain
 * @param number premier code entré par le joueur
 */
public void setCodeHumain(int number) {
	
	this.codeHumain=number;
}

/**
 * fonction modifiant codeOrdi
 * @param number premier code entré définit par l'ordi
 */
public void setCodeOrdi(int number) {
	
	this.codeOrdi=number;
}


/**
 * Methode retournant un string en fonction de number et number 1
 * @param number
 * @param number1
 * @return
 */

public String verificationUtilisateur( int number, int number1) {
	
	final String SEPARATEUR = "";
	// car va avec number
	char car;
	// car1 va avec number1
	char car1;
	String code;
	StringBuilder codeSymbole =  new StringBuilder() ;
	
	
	
	String proposition;
	code = String.valueOf(number);
	proposition = String.valueOf(number1);
	String mot[] = proposition.split(SEPARATEUR);
	
	for (int i = 0; i < mot.length; i++) {
	car = code.charAt(i);
	car1 = proposition.charAt(i);
	
	
	if ( car > car1) {
		codeSymbole.append("+");
	}else if (car == car1) {
		codeSymbole.append("=");
	}else {
		codeSymbole.append("-");
	}

	
	
	}
	//System.out.println("les indices sont" + arraylist.get(0) + arraylist.get(1) + arraylist.get(2) + arraylist.get(3));
	
	
	System.out.println( codeSymbole.toString());
	
	return codeSymbole.toString() ;
}



}



