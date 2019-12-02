package importData;


import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import structureJeu.Parti;

public class LoaderProperties {
	
	Logger log = Logger.getLogger(Parti.class);
	
    static private LoaderProperties _instance = null;
    static public String longueurCombinaison = "4";
    static public String nombreDeTentative = "6";
    static public String dev = "False";
   
    protected LoaderProperties(){
    try{
    	  InputStream in = this.getClass().getClassLoader().getResourceAsStream("config.properties");
    	  Properties props = new Properties();
        props.load(in);
        longueurCombinaison = props.getProperty("longueurCombinaison");
        nombreDeTentative = props.getProperty("nombreDeTentative");
        dev = props.getProperty("dev");
       
       } 
    catch(Exception e){
        System.out.println("error" + e);
        log.warn("le fichier properties ne se charge pas");
       }	 
    }
	 
    static public LoaderProperties instance(){
        if (_instance == null) {
            _instance = new LoaderProperties();
        }
        return _instance;
    }
}