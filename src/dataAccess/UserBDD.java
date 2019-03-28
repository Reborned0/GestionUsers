package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import metier.User;

public class UserBDD {
	
	public Connection connect;
	
	public UserBDD () {
		connect = ConnexionBDD.getInstance();
	}
	
/**
 * @param id identifant de l'utilsateur à rechercher dans la BdD
 * @return un objet Utilisateur ou null
 */
	public User searchUser(String login, String pwd) {

		User unUtilisateur = new User();
		try {
			PreparedStatement statement = connect.prepareStatement("select id, nom, prenom from visiteur where login = ? and mdp = ?");
			statement.setString(1, login);
			statement.setString(2, pwd);
			ResultSet result = statement.executeQuery();
			if (result.first()) {
				unUtilisateur = new User(result.getString("id"), result.getString("nom"), result.getString("prenom"));
				System.out.println(unUtilisateur);
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unUtilisateur;
	}
	
}
