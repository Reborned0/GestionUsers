import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.User;
import sun.swing.AccumulativeRunnable;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Recherche_Util_App extends JFrame {

	private JPanel contentPane;
	private JTextField txtRecherche;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, User utilisateur) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Recherche_Util_App frame = new Recherche_Util_App(utilisateur);
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
	public Recherche_Util_App(User utilisateur) {
		setTitle("Changement entre Modif et consulter");
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
		
		JList list = new JList();
		list.setBounds(242, 128, 494, 362);
		contentPane.add(list);
		
		JButton btn_Modif_Consult = new JButton("");
		btn_Modif_Consult.setBounds(571, 514, 165, 57);
		contentPane.add(btn_Modif_Consult);
		
		JButton button = new JButton("<<  Retour");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Retour(utilisateur);
			}
		});
		button.setFont(new Font("Tahoma", Font.PLAIN, 16));
		button.setBounds(10, 11, 139, 43);
		contentPane.add(button);
	}
	
	private void Retour(User utilisateur) {
		Acceuil_App Accueil = new Acceuil_App(utilisateur);
	}
}
