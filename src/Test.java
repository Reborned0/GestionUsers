import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;

import controleur.controle;
import metier.User;

import javax.swing.JTable;
import javax.swing.JTextField;

public class Test extends JFrame {

	private JPanel contentPane;
	private JTable table;
	
	private JTable Tableau;
	private JTextField txtRecherche;
	private controle controleur = new controle();
	private UserJTableModel userJTableModel= new UserJTableModel();
	private JTable jtable = new JTable(userJTableModel);
	private JScrollPane jscrollpane = new JScrollPane(jtable);


	/**
	 * Launch the application.
	 */
	public static void main(String[] args, User utilisateur) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test(utilisateur);
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
	public Test(User utilisateur) {
		setTitle("TEEESTs");
		setVisible(true);
		//contentPane.setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 974, 764);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		txtRecherche = new JTextField();
		txtRecherche.setToolTipText("Recherche");
		txtRecherche.setBounds(242, 45, 370, 20);
		contentPane.add(txtRecherche);
		txtRecherche.setColumns(10);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.setBounds(622, 44, 114, 23);
		contentPane.add(btnRecherche);
		
		Tableau = new JTable();
		contentPane.add(Tableau, BorderLayout.CENTER);
		getContentPane().add(jscrollpane, BorderLayout.CENTER);
		
		JButton btn_Modif_Consult = new JButton("Modifier");
		btn_Modif_Consult.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		btn_Modif_Consult.setBounds(680, 647, 165, 57);
		contentPane.add(btn_Modif_Consult);
		
		JButton button = new JButton("<<  Retour");
		button.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Retour(utilisateur);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 11, 139, 43);
		contentPane.add(button);
		
		
	
		
		table = new JTable();
		table.setBounds(153, 109, 692, 527);
		contentPane.add(table);
	}
	private void Retour(User utilisateur) {
		setVisible(false);
		Acceuil_App Accueil = new Acceuil_App(utilisateur);

	}
	protected void search(){
		List<User> lesUsers = controleur.allUsers();
		userJTableModel.loadData(lesUsers);
	}
	
}
