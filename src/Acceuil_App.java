import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.GridLayout;
import net.miginfocom.swing.MigLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import metier.User;

import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.Box;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Color;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class Acceuil_App {

	private JFrame frmAcceuil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args, User utilisateur) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil_App window = new Acceuil_App(utilisateur);
					window.frmAcceuil.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Acceuil_App(User utilisateur) {
		initialize(utilisateur);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(User utilisateur) {
		frmAcceuil = new JFrame();
		frmAcceuil.getContentPane().setBackground(Color.decode("#77AADD"));
		frmAcceuil.getContentPane().setForeground(new Color(173, 255, 47));
		frmAcceuil.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmAcceuil.setVisible(true);
		frmAcceuil.setTitle("Acceuil");
		frmAcceuil.setBounds(100, 100, 830, 778);
		frmAcceuil.getContentPane().setLayout(null);
		
		JButton btnModifier = new JButton("Modifier");
		btnModifier.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Modifier(utilisateur);
			}
		});
		btnModifier.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnModifier.setBounds(281, 211, 257, 101);
		frmAcceuil.getContentPane().add(btnModifier);
		
		JButton btnAjouter = new JButton("Ajouter");
		btnAjouter.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnAjouter.setBounds(281, 323, 257, 101);
		frmAcceuil.getContentPane().add(btnAjouter);
		
		JButton btnConsulter = new JButton("Consulter");
		btnConsulter.setFont(new Font("Tahoma", Font.BOLD, 20));
		btnConsulter.setBounds(281, 435, 257, 101);
		frmAcceuil.getContentPane().add(btnConsulter);
		
		JLabel lblBonjour = new JLabel("Bonjour :");
		lblBonjour.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblBonjour.setBounds(10, 11, 74, 30);
		frmAcceuil.getContentPane().add(lblBonjour);
		
		JLabel lblNompersonne = new JLabel(utilisateur.getPrenom() + " " + utilisateur.getNom());
		lblNompersonne.setFont(new Font("Tahoma", Font.ITALIC, 17));
		lblNompersonne.setBounds(94, 8, 172, 36);
		frmAcceuil.getContentPane().add(lblNompersonne);
	}
	private void Modifier(User utilisateur) {
		frmAcceuil.setVisible(false);
		Recherche_Util_App rech= new Recherche_Util_App(utilisateur);

	}
}
