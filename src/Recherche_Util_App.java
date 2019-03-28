import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import metier.User;

import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;

public class Recherche_Util_App extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

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
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1000, 674);
		contentPane = new JPanel();
		contentPane.setBackground(Color.decode("#77AADD"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setToolTipText("Recherche");
		textField.setText("");
		textField.setBounds(242, 97, 370, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnRecherche = new JButton("Recherche");
		btnRecherche.setBounds(647, 96, 89, 23);
		contentPane.add(btnRecherche);
		
		JList list = new JList();
		list.setBounds(242, 128, 494, 362);
		contentPane.add(list);
		Vector<String> vec = new Vector();
		vec.add(new String("test"));
		
	}
}
