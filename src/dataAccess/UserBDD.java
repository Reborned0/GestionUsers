package dataAccess;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	public User findById(String id) {

		User unUtilisateur = null;
		try {
			PreparedStatement statement = connect.prepareStatement("select * from visiteur where id =  ?");
			statement.setString(1, id);
			ResultSet result = statement.executeQuery();
			if (result.first())
				unUtilisateur = new User(id, result.getString("nom"), result.getString("prenom"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unUtilisateur;
	}
	
	/**
	 * @param filtreNom nom de l'utilisateur à rechercher dans la BdD
	 * @return une liste d'objets Utilisateur 
	 */
	public List<User> findByNom(String filtreNom) {

		User unUtilisateur = null;
		List<User> lesUtilisateurs = new ArrayList<User>();
		try {
			PreparedStatement statement = connect.prepareStatement("select * from visiteur where nom like  ?");
			statement.setString(1, filtreNom);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("id"));
				unUtilisateur = new User(result.getString("id"), result.getString("nom"),
						result.getString("prenom"));
				lesUtilisateurs.add(unUtilisateur);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesUtilisateurs;
	}
}
