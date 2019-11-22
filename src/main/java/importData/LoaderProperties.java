package importData;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

 
public class LoaderProperties{
   private final Properties configProp = new Properties();
    
   
   /*
    * Methode permettant de charger les données du fichier config.properties
    */
   
   private LoaderProperties(){
   
      InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
     
      try {
          configProp.load(in);
      } catch (IOException e) {
          e.printStackTrace();
      }
   }
 
   //Bill pugh methode
   
   /*
    * Methode intermediaire pour la methode get instance
    */
   private static class LazyHolder{
	   
      private static final LoaderProperties INSTANCE = new LoaderProperties();
   
   }
 
   /**
    * methode permettant de charger les donnée en mémoire 
    * @return les données properties
    */
   
   public static LoaderProperties getInstance(){
	   
      return LazyHolder.INSTANCE;
   }
    
   
   
   /**
    * methode permettant de retourner les valeur du fichier properties en entrant les clés
    * @param cle
    * @return valeur de la cle 
    */
   public String getProperty(String cle){
      return configProp.getProperty(cle);
   }
    
  
    
 /*
  * Methodes verifiant que les methodes de chargement des données marche
  */
   
   public static void main(String[] args){
 
     System.out.println(LoaderProperties.getInstance().getProperty("longueurCombinaison"));
     System.out.println(LoaderProperties.getInstance().getProperty("nombreDeTentative"));
     System.out.println(LoaderProperties.getInstance().getProperty("dev"));
     
   }
}



