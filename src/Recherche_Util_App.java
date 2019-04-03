import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;

import controleur.controle;
import metier.User;
import modele.UserJTableModel;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Rectangle;
import javax.swing.table.DefaultTableModel;


public class Recherche_Util_App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 737222297281937962L;
	private JPanel contentPane;
	private JTable table;
	private JTextField txtRecherche;
	private controle controleur = new controle();
	
	private UserJTableModel userJTableModel= new UserJTableModel();
	private JTable jtable = new JTable(new DefaultTableModel(
		new Object[][] {
		},
		new String[] {
			"ID", "Pr\u00E9nom", "Nom"
		}
	) {
		Class[] columnTypes = new Class[] {
			String.class, String.class, String.class
		};
		public Class getColumnClass(int columnIndex) {
			return columnTypes[columnIndex];
		}
	});
	private JScrollPane jscrollpane = new JScrollPane();

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


		//if(Fenetre == 1) {
			setTitle("Recherche pour une modification");

			setVisible(true);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1000, 674);
			contentPane = new JPanel();
			contentPane.setBackground(Color.decode("#77AADD"));
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			contentPane.setLayout(null);
			
			txtRecherche = new JTextField();
			txtRecherche.setToolTipText("Recherche");
			txtRecherche.setBounds(242, 97, 370, 20);
			contentPane.add(txtRecherche);
			txtRecherche.setColumns(10);
			
			JButton btnRecherche = new JButton("Recherche");
			btnRecherche.setBounds(622, 96, 114, 23);
			contentPane.add(btnRecherche);
			
			
			JButton btn_Modif_Consult = new JButton("Modifier");
			btn_Modif_Consult.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					
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
			contentPane.add(jscrollpane);
			jscrollpane.setViewportView(jtable);
			jtable.setBorder(new EmptyBorder(0, 0, 0, 0));
	/*	}else if (Fenetre == 3) {
			setTitle("Recherche pour une consultation");

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
			btnRecherche.setBounds(622, 96, 114, 23);
			contentPane.add(btnRecherche);
			
			
			JButton btn_Modif_Consult = new JButton("Consulter");
			btn_Modif_Consult.setBounds(571, 514, 165, 57);
			contentPane.add(btn_Modif_Consult);
			
			JButton button = new JButton("<<  Retour");
			button.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent arg0) {
					Retour(utilisateur);
				}
			});
			button.setFont(new Font("Tahoma", Font.PLAIN, 16));
			button.setBounds(10, 11, 139, 43);
			contentPane.add(button);
		}*/
		
	}
	
	protected void search(){
		List<User> lesUsers = controleur.allUsers();
		userJTableModel.loadData(lesUsers);
	}
	
	private void Retour(User utilisateur) {
		setVisible(false);
		Acceuil_App Accueil = new Acceuil_App(utilisateur);

	}
}
