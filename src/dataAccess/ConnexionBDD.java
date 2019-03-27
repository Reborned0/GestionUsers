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
	 * MÃ©thode qui va nous retourner notre instance
	 * et la crÃ©er si elle n'existe pas...
	 * @return un objet connection
	 */
	public static Connection getInstance(){
		if(connect == null){
			try {
				try {
					Class.forName("com.mysql.jdbc.Driver");
					connect = DriverManager.getConnection(url, user, passwd);
				} catch (ClassNotFoundException e) {
					// TODO Bloc catch généré automatiquement
					e.printStackTrace();
				} 
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}		
		return connect;	
	}	
	
	/**
	 * MÃ©thode qui met fin Ã  la connexion
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
