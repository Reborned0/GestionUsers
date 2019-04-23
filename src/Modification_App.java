import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controleur.controle;

import java.awt.Cursor;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;
import javax.swing.JTextField;
import datechooser.beans.DateChooserCombo;
import metier.User;

import javax.swing.JButton;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Modification_App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4650192894098161118L;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private ArrayList<JTextField>TableaudesText = new ArrayList<JTextField>();
	private JDateChooser dateChooser;

	private User UtilAppli;
	private User Utilisateur;
	private controle controleur = new controle();

	/**
	 * Launch the application.
	 */
	public void main(String[] args, User UtilAppli, String Identifiant,int Fenetre) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Modification_App frame = new Modification_App(Identifiant, Fenetre, UtilAppli);
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
	public Modification_App(String Identifiant, int Fenetre, User UtilAppli) {
		unUtilisateur(Identifiant);
		if (Fenetre == 1) {
			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			setVisible(true);
			setTitle("Modification de l'utilisateur");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 1000, 570);
			contentPane = new JPanel();
			contentPane.setBackground(Color.decode("#77AADD"));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblIdentifiant = new JLabel("Identifiant :");
			lblIdentifiant.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblIdentifiant.setBounds(83, 75, 112, 32);
			contentPane.add(lblIdentifiant);

			JLabel lblNewLabel = new JLabel("Nom :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(83, 110, 112, 26);
			contentPane.add(lblNewLabel);

			JLabel lblPrenom = new JLabel("Prenom :");
			lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPrenom.setBounds(83, 147, 112, 26);
			contentPane.add(lblPrenom);

			JLabel lblLogin = new JLabel("Login :");
			lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLogin.setBounds(83, 184, 112, 26);
			contentPane.add(lblLogin);

			JLabel lblMotDePasse = new JLabel("Mot de passe :");
			lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMotDePasse.setBounds(83, 221, 112, 26);
			contentPane.add(lblMotDePasse);

			JLabel lblAdresse = new JLabel("Adresse :");
			lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAdresse.setBounds(566, 86, 112, 26);
			contentPane.add(lblAdresse);

			JLabel lblCodePostale = new JLabel("Code Postal :");
			lblCodePostale.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCodePostale.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCodePostale.setBounds(566, 118, 112, 26);
			contentPane.add(lblCodePostale);

			JLabel lblVille = new JLabel("Ville :");
			lblVille.setHorizontalAlignment(SwingConstants.RIGHT);
			lblVille.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblVille.setBounds(566, 155, 112, 26);
			contentPane.add(lblVille);

			JLabel lblDate = new JLabel("Date d'embauche :");
			lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDate.setBounds(546, 192, 132, 26);
			contentPane.add(lblDate);

			textField = new JTextField();
			textField.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(!textField.getText().isEmpty()) {
						textField.setToolTipText("Entrez un mot de passe");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(textField.getText().isEmpty()) {
						textField.setToolTipText("Entrez un mot de passe");
					}
				}
			});
			textField.setBounds(205, 226, 236, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(!textField_1.getText().isEmpty()) {
						textField_1.setToolTipText("Entrez un login");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(textField_1.getText().isEmpty()) {
						textField_1.setToolTipText("Entrez un login");
					}
				}
			});
			textField_1.setColumns(10);
			textField_1.setBounds(205, 189, 236, 20);
			contentPane.add(textField_1);

			textField_2 = new JTextField();
			textField_2.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(!textField_2.getText().isEmpty()) {
						textField_2.setToolTipText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(textField_2.getText().isEmpty()) {
						textField_2.setToolTipText("Entrez un prénom");
					}
				}
			});
			textField_2.setColumns(10);
			textField_2.setBounds(205, 152, 236, 20);
			contentPane.add(textField_2);

			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.addFocusListener(new FocusAdapter() {
				@Override
				public void focusLost(FocusEvent e) {
					if(textField_3.getText().isEmpty()) {
						textField_3.setToolTipText("Entrez un nom");
					}
				}
				@Override
				public void focusGained(FocusEvent e) {
					if(!textField_3.getText().isEmpty()) {
						textField_3.setToolTipText("");
					}
				}
			});
			textField_3.setColumns(10);
			textField_3.setBounds(205, 115, 236, 20);
			contentPane.add(textField_3);

			textField_4 = new JTextField();
			textField_4.setEditable(false);
			textField_4.setColumns(10);
			textField_4.setBounds(205, 83, 236, 20);
			contentPane.add(textField_4);

			textField_5 = new JTextField();
			textField_5.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(!textField_5.getText().isEmpty()) {
						textField_5.setToolTipText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(textField_5.getText().isEmpty()) {
						textField_5.setToolTipText("Entrez une adresse");
					}
				}
			});
			textField_5.setColumns(10);
			textField_5.setBounds(688, 87, 236, 20);
			contentPane.add(textField_5);

			textField_6 = new JTextField();
			textField_6.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(!textField_6.getText().isEmpty()) {
						textField_6.setToolTipText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(textField_6.getText().isEmpty()) {
						textField_6.setToolTipText("Entrez un code postal");
					}
				}
			});
			textField_6.setColumns(10);
			textField_6.setBounds(688, 123, 236, 20);
			contentPane.add(textField_6);

			textField_7 = new JTextField();
			textField_7.addFocusListener(new FocusAdapter() {
				@Override
				public void focusGained(FocusEvent arg0) {
					if(!textField_7.getText().isEmpty()) {
						textField_7.setToolTipText("");
					}
				}
				@Override
				public void focusLost(FocusEvent e) {
					if(textField_7.getText().isEmpty()) {
						textField_7.setToolTipText("Entrez une ville");
					}
				}
			});
			textField_7.setColumns(10);
			textField_7.setBounds(688, 160, 236, 20);
			contentPane.add(textField_7);

			JButton btnNewButton = new JButton("Valider");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Date date1 = new java.sql.Date(dateChooser.getDate().getTime());
					Utilisateur = new User(textField_4.getText(), textField_3.getText(), textField_2.getText(), textField_1.getText(), textField.getText(), null, textField_5.getText(), textField_6.getText(), textField_7.getText(), date1);
					modifBDD(Utilisateur);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnNewButton.setBounds(388, 363, 213, 73);
			contentPane.add(btnNewButton);

			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd MM yyyy");
			dateChooser.setBounds(688, 198, 236, 20);
			contentPane.add(dateChooser);

			JButton button = new JButton("<<  Retour");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Retour(UtilAppli);
				}
			});
			button.setFont(new Font("Tahoma", Font.PLAIN, 16));
			button.setBounds(12, 476, 139, 43);
			contentPane.add(button);


		}else if (Fenetre == 3) {


			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			setVisible(true);
			setTitle("Consultation de l'utilisateur");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 1000, 570);
			contentPane = new JPanel();
			contentPane.setBackground(Color.decode("#77AADD"));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblIdentifiant = new JLabel("Identifiant :");
			lblIdentifiant.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblIdentifiant.setBounds(83, 75, 112, 32);
			contentPane.add(lblIdentifiant);

			JLabel lblNewLabel = new JLabel("Nom :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(83, 110, 112, 26);
			contentPane.add(lblNewLabel);

			JLabel lblPrenom = new JLabel("Prenom :");
			lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPrenom.setBounds(83, 147, 112, 26);
			contentPane.add(lblPrenom);

			JLabel lblLogin = new JLabel("Login :");
			lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLogin.setBounds(83, 184, 112, 26);
			contentPane.add(lblLogin);

			JLabel lblMotDePasse = new JLabel("Mot de passe :");
			lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMotDePasse.setBounds(83, 221, 112, 26);
			contentPane.add(lblMotDePasse);

			JLabel lblAdresse = new JLabel("Adresse :");
			lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAdresse.setBounds(566, 86, 112, 26);
			contentPane.add(lblAdresse);

			JLabel lblCodePostale = new JLabel("Code Postal :");
			lblCodePostale.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCodePostale.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCodePostale.setBounds(566, 118, 112, 26);
			contentPane.add(lblCodePostale);

			JLabel lblVille = new JLabel("Ville :");
			lblVille.setHorizontalAlignment(SwingConstants.RIGHT);
			lblVille.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblVille.setBounds(566, 155, 112, 26);
			contentPane.add(lblVille);

			JLabel lblDate = new JLabel("Date d'embauche :");
			lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDate.setBounds(546, 192, 132, 26);
			contentPane.add(lblDate);

			textField = new JTextField();
			textField.setEditable(false);
			textField.setBounds(205, 226, 236, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setEditable(false);
			textField_1.setColumns(10);
			textField_1.setBounds(205, 189, 236, 20);
			contentPane.add(textField_1);

			textField_2 = new JTextField();
			textField_2.setEditable(false);
			textField_2.setColumns(10);
			textField_2.setBounds(205, 152, 236, 20);
			contentPane.add(textField_2);

			textField_3 = new JTextField();
			textField_3.setEditable(false);
			textField_3.setColumns(10);
			textField_3.setColumns(10);
			textField_3.setBounds(205, 115, 236, 20);
			contentPane.add(textField_3);

			textField_4 = new JTextField();
			textField_4.setEditable(false);
			textField_4.setColumns(10);
			textField_4.setBounds(205, 83, 236, 20);
			contentPane.add(textField_4);

			textField_5 = new JTextField();
			textField_5.setEditable(false);
			textField_5.setColumns(10);
			textField_5.setBounds(688, 87, 236, 20);
			contentPane.add(textField_5);

			textField_6 = new JTextField();
			textField_6.setEditable(false);
			textField_6.setColumns(10);
			textField_6.setBounds(688, 123, 236, 20);
			contentPane.add(textField_6);

			textField_7 = new JTextField();
			textField_7.setEditable(false);
			textField_7.setColumns(10);
			textField_7.setBounds(688, 160, 236, 20);
			contentPane.add(textField_7);

			dateChooser = new JDateChooser();
			dateChooser.setFocusable(false);
			dateChooser.setDateFormatString("dd MM yyyy");
			dateChooser.setBounds(688, 198, 236, 20);
			contentPane.add(dateChooser);

			JButton button = new JButton("<<  Retour");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Retour(UtilAppli);
					setVisible(false);
				}
			});
			button.setFont(new Font("Tahoma", Font.PLAIN, 16));
			button.setBounds(12, 476, 139, 43);
			contentPane.add(button);
		}else if(Fenetre == 2) {

			setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
			setVisible(true);
			setTitle("Modification de l'utilisateur");
			setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 1000, 570);
			contentPane = new JPanel();
			contentPane.setBackground(Color.decode("#77AADD"));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			JLabel lblIdentifiant = new JLabel("Identifiant :");
			lblIdentifiant.setHorizontalAlignment(SwingConstants.RIGHT);
			lblIdentifiant.setFont(new Font("Tahoma", Font.BOLD, 16));
			lblIdentifiant.setBounds(83, 75, 112, 32);
			contentPane.add(lblIdentifiant);

			JLabel lblNewLabel = new JLabel("Nom :");
			lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
			lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblNewLabel.setBounds(83, 110, 112, 26);
			contentPane.add(lblNewLabel);

			JLabel lblPrenom = new JLabel("Prenom :");
			lblPrenom.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPrenom.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblPrenom.setBounds(83, 147, 112, 26);
			contentPane.add(lblPrenom);

			JLabel lblLogin = new JLabel("Login :");
			lblLogin.setHorizontalAlignment(SwingConstants.RIGHT);
			lblLogin.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblLogin.setBounds(83, 184, 112, 26);
			contentPane.add(lblLogin);

			JLabel lblMotDePasse = new JLabel("Mot de passe :");
			lblMotDePasse.setHorizontalAlignment(SwingConstants.RIGHT);
			lblMotDePasse.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblMotDePasse.setBounds(83, 221, 112, 26);
			contentPane.add(lblMotDePasse);

			JLabel lblAdresse = new JLabel("Adresse :");
			lblAdresse.setHorizontalAlignment(SwingConstants.RIGHT);
			lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblAdresse.setBounds(566, 86, 112, 26);
			contentPane.add(lblAdresse);

			JLabel lblCodePostale = new JLabel("Code Postal :");
			lblCodePostale.setHorizontalAlignment(SwingConstants.RIGHT);
			lblCodePostale.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblCodePostale.setBounds(566, 118, 112, 26);
			contentPane.add(lblCodePostale);

			JLabel lblVille = new JLabel("Ville :");
			lblVille.setHorizontalAlignment(SwingConstants.RIGHT);
			lblVille.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblVille.setBounds(566, 155, 112, 26);
			contentPane.add(lblVille);

			JLabel lblDate = new JLabel("Date d'embauche :");
			lblDate.setHorizontalAlignment(SwingConstants.RIGHT);
			lblDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
			lblDate.setBounds(546, 192, 132, 26);
			contentPane.add(lblDate);

			textField = new JTextField();
			textField.setBounds(205, 226, 236, 20);
			contentPane.add(textField);
			textField.setColumns(10);

			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(205, 189, 236, 20);
			contentPane.add(textField_1);

			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(205, 152, 236, 20);
			contentPane.add(textField_2);

			textField_3 = new JTextField();
			textField_3.setColumns(10);
			textField_3.setBounds(205, 115, 236, 20);
			contentPane.add(textField_3);

			textField_4 = new JTextField();
			textField_4.setColumns(10);
			textField_4.setBounds(205, 83, 236, 20);
			contentPane.add(textField_4);

			textField_5 = new JTextField();
			textField_5.setColumns(10);
			textField_5.setBounds(688, 87, 236, 20);
			contentPane.add(textField_5);

			textField_6 = new JTextField();
			textField_6.setColumns(10);
			textField_6.setBounds(688, 123, 236, 20);
			contentPane.add(textField_6);

			textField_7 = new JTextField();
			textField_7.setColumns(10);
			textField_7.setBounds(688, 160, 236, 20);
			contentPane.add(textField_7);			
			
			
			JButton btnNewButton = new JButton("Ajouter");
			btnNewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					Date date1 = new java.sql.Date(dateChooser.getDate().getTime());
					//User u1= new User(id, nom, prenom, login, mdp, etat, adresse, cp, ville, Dateemb);
					Utilisateur = new User(textField_4.getText(), textField_3.getText(), textField_2.getText(), textField_1.getText(), textField.getText(), null, textField_5.getText(), textField_6.getText(), textField_7.getText(), date1);
					ajoutBDD(Utilisateur);
				}
			});
			btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 16));
			btnNewButton.setBounds(388, 363, 213, 73);
			contentPane.add(btnNewButton);

			dateChooser = new JDateChooser();
			dateChooser.setDateFormatString("dd MM yyyy");
			dateChooser.setBounds(688, 198, 236, 20);
			contentPane.add(dateChooser);

			JButton button = new JButton("<<  Retour");
			button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent arg0) {
					Retour(UtilAppli);
				}
			});
			button.setFont(new Font("Tahoma", Font.PLAIN, 16));
			button.setBounds(12, 476, 139, 43);
			contentPane.add(button);
		}
		else{
			JOptionPane.showMessageDialog(this, "Erreur lors du choix de la fenetre","Erreur", JOptionPane.ERROR_MESSAGE);
		}



		setText(Utilisateur);
	}
	private void unUtilisateur(String Identifiant) {
		Utilisateur = null;
		try {
			Utilisateur= controleur.UnUtilisateur(Identifiant);
		} catch (Exception e) {
			e.getMessage();
		}
	}

	private void setText(User Util) {
		if (Util!=null) {
			textField.setText(Util.getMdp());
			textField_1.setText(Util.getLogin());
			textField_2.setText(Util.getPrenom());
			textField_3.setText(Util.getNom());
			textField_4.setText(Util.getId());
			textField_5.setText(Util.getAdresse());
			textField_6.setText(Util.getCp());
			textField_7.setText(Util.getVille());
			dateChooser.setDate(Util.getDateEmbauche());
		}else
		{
			Calendar c= Calendar.getInstance();

			textField.setText("");
			textField_1.setText("");
			textField_2.setText("");
			textField_3.setText("");
			textField_4.setText("");
			textField_5.setText("");
			textField_6.setText("");
			textField_7.setText("");
			dateChooser.setDate(new java.sql.Date(0));
		}
	}
	private void modifBDD(User Utilisateur) {
		controleur.editUser(Utilisateur);
	}
	private void ajoutBDD(User utilisateur) {
		JOptionPane.showConfirmDialog(this, "Voulez-vous vraiment ajouter l'utilisateur" + "\n"+ utilisateur.getPrenom() + utilisateur.getNom());
		//controleur.addUser(utilisateur);
	}
	private void Retour(User utilisateur) {
		this.setVisible(false);
		setVisible(false);
		Acceuil_App Accueil = new Acceuil_App(utilisateur);

	}
}
