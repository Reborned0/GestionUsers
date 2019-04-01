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
	public User searchUser(String login, String pwd) {

		User unUtilisateur = new User();
		try {
			PreparedStatement statement = connect.prepareStatement("select * from visiteur where login = ? and mdp = ?");
			statement.setString(1, login);
			statement.setString(2, pwd);
			ResultSet result = statement.executeQuery();
			if (result.first()) {
				unUtilisateur = new User(result.getString("id"), result.getString("nom"), result.getString("prenom"), result.getString("login"), result.getString("mdp"), result.getString("etat"), result.getString("adresse"),result.getString("cp"), result.getString("ville"), result.getDate("dateEmbauche"));
			}
				
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return unUtilisateur;
	}
	
	public List<User> allUsers() {

		User unUtilisateur = null;
		List<User> lesUtilisateurs = new ArrayList<User>();
		try {
			System.out.println("testDepart");
			PreparedStatement statement = connect.prepareStatement("select * from visiteur");
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				System.out.println(result.getString("id"));
				unUtilisateur = new User(result.getString("id"), result.getString("nom"), result.getString("prenom"), result.getString("login"), result.getString("mdp"), result.getString("etat"), result.getString("adresse"),result.getString("cp"), result.getString("ville"), result.getDate("dateEmbauche"));
				lesUtilisateurs.add(unUtilisateur);
				System.out.println("test");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lesUtilisateurs;
	}
	public void AjoutUser(User Utilisateur) {
		try {
			PreparedStatement stattement = connect.prepareStatement("insert into visiteur (id,nom,prenom,login,mdp,adresse,cp,ville,dateEmbauche,etat) values (?,?,?,?,?,?,?,?,?)");
			stattement.setString(1, Utilisateur.getId());
			stattement.setString(2, Utilisateur.getNom());
			stattement.setString(3, Utilisateur.getPrenom());
			stattement.setString(4, Utilisateur.getLogin());
			stattement.setString(5, Utilisateur.getMdp());
			stattement.setString(6, Utilisateur.getAdresse());
			stattement.setString(7, Utilisateur.getCp());
			stattement.setString(8, Utilisateur.getVille());
			stattement.setDate(9, Utilisateur.getDateEmbauche());
			ResultSet result = stattement.executeQuery();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
