import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;



import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Main_User_Connection extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_User_Connection frame = new Main_User_Connection();
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
	public Main_User_Connection() {
		setTitle("Connexion a votre espace");
		setResizable(false);
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		textField = new JTextField();
		textField.setBounds(0, 0, 202, 20);
		panel.add(textField);
				textField.setColumns(10);
		
		JButton btnValider = new JButton("Valider");

		btnValider.setBounds(556, 87, 79, 33);
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
		
		passwordField = new JPasswordField();
		passwordField.setBounds(208, 135, 202, 20);
		contentPane.add(passwordField);
	}
}
