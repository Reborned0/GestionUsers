import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controleur.controle;
import metier.User;
import modele.UserJTableModel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ListSelectionModel;


public class Recherche_Util_App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 737222297281937962L;
	private JPanel contentPane;
	private JTextField txtRecherche;
	private controle controleur = new controle();

	private UserJTableModel userJTableModel= new UserJTableModel();
	private JTable jtable = new JTable(userJTableModel);
	private JScrollPane jscrollpane = new JScrollPane(jtable);
	private String Identifiant="";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, User utilisateur, int Fenetre) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					Recherche_Util_App frame = new Recherche_Util_App(utilisateur,Fenetre);
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
	public Recherche_Util_App(User utilisateur, int Fenetre) {
		if(Fenetre == 1) {
			jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jtable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2 && !e.isConsumed()) {
						Identifiant = jtable.getValueAt(jtable.getSelectedRow(), 0).toString();
						Modifier_Consulter(Identifiant,Fenetre,utilisateur);
					}
				}
			});
			search();
			
		setTitle("Recherche pour une modification");

		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 674);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#77AADD"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtRecherche = new JTextField();
		txtRecherche.setToolTipText("Recherche");
		txtRecherche.setBounds(242, 97, 370, 20);
		contentPane.add(txtRecherche);
		txtRecherche.setColumns(10);

		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recherche();
			}
		});
		btnRecherche.setBounds(622, 96, 114, 23);
		contentPane.add(btnRecherche);


		JButton btn_Modif_Consult = new JButton("Modifier");
		btn_Modif_Consult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Identifiant = jtable.getValueAt(jtable.getSelectedRow(), 0).toString();
				Modifier_Consulter(Identifiant,Fenetre,utilisateur);
			}
		});
		btn_Modif_Consult.setBounds(571, 514, 165, 57);
		contentPane.add(btn_Modif_Consult);

		JButton button = new JButton("<<  Retour");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Retour(utilisateur);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 11, 139, 43);
		contentPane.add(button);




		jscrollpane.setBounds(126, 153, 674, 277);
		contentPane.add(jscrollpane,BorderLayout.CENTER);

			}
		else if (Fenetre == 3) {
			jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			jtable.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if(e.getClickCount() == 2 && !e.isConsumed()) {
						Identifiant = jtable.getValueAt(jtable.getSelectedRow(), 0).toString();
						Modifier_Consulter(Identifiant,Fenetre,utilisateur);
					}
				}
			});
			search();
			
			setTitle("Recherche pour une consultation");

		jtable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		jtable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2 && !e.isConsumed()) {
					Identifiant = jtable.getValueAt(jtable.getSelectedRow(), 0).toString();
					Modifier_Consulter(Identifiant,Fenetre,utilisateur);
				}
			}
		});
		search();


		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 674);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#77AADD"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtRecherche = new JTextField();
		txtRecherche.setToolTipText("Recherche");
		txtRecherche.setBounds(242, 97, 370, 20);
		contentPane.add(txtRecherche);
		txtRecherche.setColumns(10);

		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				recherche();
			}
		});
		btnRecherche.setBounds(622, 96, 114, 23);
		contentPane.add(btnRecherche);


		JButton btn_Modif_Consult = new JButton("Consulter");
		btn_Modif_Consult.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Identifiant = jtable.getValueAt(jtable.getSelectedRow(), 0).toString();
				Modifier_Consulter(Identifiant,Fenetre,utilisateur);
			}
		});
		btn_Modif_Consult.setBounds(571, 514, 165, 57);
		contentPane.add(btn_Modif_Consult);

		JButton button = new JButton("<<  Retour");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Retour(utilisateur);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 11, 139, 43);
		contentPane.add(button);




		jscrollpane.setBounds(126, 153, 674, 277);
		contentPane.add(jscrollpane,BorderLayout.CENTER);

		}

	}

	protected void search(){
		List<User> lesUsers = controleur.allUsers();
		userJTableModel.loadData(lesUsers);
	}
	
	protected void recherche() {
		String nom = txtRecherche.getText();
		if (nom == null)
		{ //afficher message erreur
			JOptionPane.showMessageDialog(this, 
					"Il faut saisir un nom !",
					"Recherche", 
					JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			List<User> lesUtilisateurs = controleur.findByNom(nom);
			if (lesUtilisateurs.size() > 0)
			{
				userJTableModel.loadData(lesUtilisateurs); //maj du contenu de la JTable
			}
			else {
				JOptionPane.showMessageDialog(this, 
						"Pas d'utilisateur avec ce nom " + nom,
						"Résultat", 
						JOptionPane.INFORMATION_MESSAGE);
			}
		}

	}

	private void Retour(User utilisateur) {
		setVisible(false);
		Acceuil_App Accueil = new Acceuil_App(utilisateur);

	}
	private void Modifier_Consulter(String identifiant, int Fenetre, User Utilisateur) {
		setVisible(false);
		Modification_App Modification = new Modification_App(identifiant,Fenetre, Utilisateur);
	}
}
