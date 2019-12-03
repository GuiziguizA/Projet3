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
		int version=1;
		int d = 0 ;
		int rejouer = 0;
		
		do {
		if (version!=0) {
		System.out.println("entrer 1 pour jouer au mode Challenge");
		System.out.println("entrer 2 pour jouer au mode Defense");
		System.out.println("entrer 3 pour jouer au mode Duel");
		
		
		do {
			
		do{
			
			if (App.SCANNER.hasNextInt()) {
			
			}else {
				System.out.println(" Entrez Uniquement 1 ,2 ou 3 dans la console");
				log.warn("le joueur a rentré une mauvaise combinaison lors du choix du mode");
				App.SCANNER.next();
			}
			
		
		}while(!App.SCANNER.hasNextInt()) ;
		d = App.SCANNER.nextInt();
		
		if (d<=0 || d>=4 ) {
		System.out.println(" Entrez Uniquement 1 ,2 ou 3 dans la console svp");
		log.warn("le joueur a rentré une mauvaise combinaison lors du choix du mode");
		}
		}while(d<=0 || d>=4 ) ;
		
		}else {
		d = rejouer;
		}
		
		
		
		Mode challenge = new Challenge();
		
		Mode defense = new Defense();
		
		Mode duel = new Duel();
		
		if (d == 1) {
		
			System.out.println("Vous jouez au mode Challenge");
			log.info("le joueur joue au mode Challenge");
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
	System.out.println("entrer 0 si vous voulez rejouer 1 si vous voulez retourner au menu principal ou 2 si vous voulez arrêter");
		version = App.SCANNER.nextInt();
		//scan.close();
		if( version == 0 ) {
		rejouer = d;
		 version = 0;
		}else {
			d = 1;
			version = 1;
		}
		} while(version != 2);
	}
	
	
}
