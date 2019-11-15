package importData;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class LoaderProperties {

	
	/**
	 * fonction important les données du config.properties 
	 * @return un tableau contenant les informations contenus dans le config.properties
	 */

	public  String[] configurationPropriete() {

		 try (InputStream input = LoaderProperties.class.getClassLoader().getResourceAsStream("config.properties")) {

	            Properties prop = new Properties();

	           

	            //load a properties file from class path, inside static method
	            prop.load(input);

	            //get the property value and print it out
	            String longueurCombinaison = prop.getProperty("db.longueurCombinaison");
	            String nombreDeTentative = prop.getProperty("db.nombreDeTentative");
	            String dev = prop.getProperty("db.dev");
	            

	           String [] proprietes = {longueurCombinaison,nombreDeTentative,dev} ; 
	           return proprietes;

	        } catch (IOException ex) {
	            ex.printStackTrace();
	            String [] proprietes = {"4","4","False"};
	            return proprietes;
	        }

	    }
}
