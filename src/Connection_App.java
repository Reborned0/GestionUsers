import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.controle;
import metier.User;

import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.JButton;



import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Connection_App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6280739219974180942L;

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;
	private controle controleur;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		controle controleur = new controle();
		
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Connection_App frame = new Connection_App(controleur);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Connection_App(controle controleur) {
		setBackground(Color.decode("#77AADD"));
		this.controleur = controleur;
		setTitle("Connexion a votre espace");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 790, 292);
		contentPane = new JPanel();
		contentPane.setOpaque(false);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(208, 66, 202, 20);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField = new JTextField(10);
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				valider();
			}
		});
		textField.setBounds(0, 0, 202, 20);
		panel.add(textField);
				textField.setColumns(10);
		
		JButton btnValider = new JButton("Valider");
		btnValider.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				valider();
			}
		});

		btnValider.setBounds(504, 165, 167, 41);
		contentPane.add(btnValider);
		
		JLabel lblIdentifiant = new JLabel("Identifiant");
		lblIdentifiant.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblIdentifiant.setToolTipText("");
		lblIdentifiant.setBounds(65, 63, 113, 27);
		contentPane.add(lblIdentifiant);
		
		JLabel lblMotDePasse = new JLabel("Mot de passe");
		lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblMotDePasse.setToolTipText("");
		lblMotDePasse.setBounds(65, 130, 113, 27);
		contentPane.add(lblMotDePasse);
		
		passwordField = new JPasswordField(10);
		passwordField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				valider();
			}
		});
		passwordField.setBounds(208, 135, 202, 20);
		contentPane.add(passwordField);
	}
	
	protected void valider(){
		String login = textField.getText();
		@SuppressWarnings("deprecation")
		String pwd = passwordField.getText();
		
		if(login.isEmpty())
		{ //affiche message erreur
			
			JOptionPane.showMessageDialog(this, "Saisissez un nom", "Erreur", JOptionPane.INFORMATION_MESSAGE);
		}
		else if (pwd.isEmpty()){
			JOptionPane.showMessageDialog(this, "Saisissez un mot de passe !", "Erreur", JOptionPane.INFORMATION_MESSAGE);
			
		}
		else {
			User utilisateur = controleur.searchUser(login, pwd);
			
			try {
				if (utilisateur.getLogin().equals(login.toLowerCase()) && utilisateur.getMdp().equals(pwd)){
					if (utilisateur.getEtat().equals("administrateur")){
						accueil(utilisateur);
					}
					else {
						JOptionPane.showMessageDialog(this, "Vous n'avez pas l'autorisation d'accéder à ce contenu");
					}
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(this, "Login ou Mot de passe incorrect. Erreur :"+ " "+e.getMessage());
			}

		}
	}
	
	private void accueil(User utilisateur){
		setVisible(false);
		Acceuil_App acc = new Acceuil_App(utilisateur);
		
	}
}
