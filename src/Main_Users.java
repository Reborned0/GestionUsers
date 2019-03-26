import javax.swing.JFrame;

public class Main_Users {

	public static void main(String[] args) {
		JFrame fenetre = new JFrame();
		
		//Nom de la fenetre
		fenetre.setTitle("Acceuil");
		// Taille de la fenetre 
		fenetre.setSize(1400, 1000);
		//Position central
		fenetre.setLocationRelativeTo(null);
		// Croix rouge 
		fenetre.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//Rendue visible
		fenetre.setVisible(true);
	}

}
