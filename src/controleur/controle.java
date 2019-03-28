package controleur;

import java.util.List;

import dataAccess.UserBDD;
import metier.User;

public class controle {
	
	private UserBDD bdd;
	
	public controle() {
		super();
		bdd = new UserBDD();
	}
	
	public UserBDD getBdd(){
		return bdd;
	}
	
	public User searchUser(String login, String pwd){
		return bdd.searchUser(login, pwd);
	}
	
	public List<User> allUsers(){
		return bdd.allUsers();
	}
}
