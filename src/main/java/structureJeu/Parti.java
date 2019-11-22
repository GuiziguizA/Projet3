package structureJeu;



import org.apache.log4j.Logger;


public class Parti {

	Logger log = Logger.getLogger(Parti.class);
	/**
	 * Methode lancant les différents mode de jeu
	 */
	
	public void game() {
		
		
		System.out.println("Bonjour et bienvenue dans ce jeu de hasard");
		System.out.println("Vous disposez de trois mode de jeu : ");
		System.out.println("Le mode Challenge");
		System.out.println("Le mode Defense");
		System.out.println("Le mode Duel");	
		int version;
		
		
		do {
		
		System.out.println("entrer 1 pour jouer au mode Challenge");
		System.out.println("entrer 2 pour jouer au mode Defense");
		System.out.println("entrer 3 pour jouer au mode Duel");
		int d = 0 ;
		
		do {
		do{
			
			if (App.SCANNER.hasNextInt()) {
			
			}else {
				System.out.println(" Entrez Uniquement 1 ,2 ou 3 dans la console");
				App.SCANNER.next();
			}
			
		
		}while(!App.SCANNER.hasNextInt()) ;
		d = App.SCANNER.nextInt();
		
		if (d<=0 || d>=4 ) {
		System.out.println(" Entrez Uniquement 1 ,2 ou 3 dans la console svp");
		}
		}while(d<=0 || d>=4 ) ;
		
		
		
		
		
		Mode challenge = new Challenge();
		challenge.setdev();
		Mode defense = new Defense();
		defense.setdev();
		Mode duel = new Duel();
		duel.setdev();
		if (d == 1) {
		
			System.out.println("Vous jouez au mode Challenge");
			log.info("le joueur joue au mode challenge");
			challenge.chargerDonneesProperties();
			challenge.deroulerjeu();
		}else if (d== 2) {
			System.out.println("Vous jouez au mode Defense");
			log.info("le joueur joue au mode Defense");
			defense.chargerDonneesProperties();
			defense.deroulerjeu();
		}else if (d==3) {
			System.out.println("Vous jouez au mode Duel");
			log.info("le joueur joue au mode Duel");
			duel.chargerDonneesProperties();
			duel.deroulerjeu();
		}
	System.out.println("entrer 0 si vous voulez rejouer ou 1 si vous voulez arreter");
		version = App.SCANNER.nextInt();
		//scan.close();
		} while(version != 1);
	}
	
	
}
