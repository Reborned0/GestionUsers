package dataAccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnexionBDD {

	/**
	 * URL de connection
	 */
	private static String url = "jdbc:mysql://localhost/sio2_GsbAppliFrais";

	/**
	 * Nom du user
	 */
	private static String user = "ts1";

	/**
	 * Mot de passe du user
	 */
	private static String passwd = "ts1";

	/**
	 * Objet Connection
	 */
	private static Connection connect = null;
	
	/**
	 * Méthode qui va nous retourner notre instance
	 * et la créer si elle n'existe pas...
	 * @return un objet connection
	 */
	public static Connection getInstance(){
		if(connect == null){
			try {
				connect = DriverManager.getConnection(url, user, passwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}	
	
	/**
	 * Méthode qui met fin à la connexion
	 */
	public static void close() {
		 if (connect != null) {
             try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
	}
	
}
