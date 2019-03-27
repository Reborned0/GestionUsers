import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main_UsersClass {

	private JFrame frmAcceuil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_UsersClass window = new Main_UsersClass();
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
	public Main_UsersClass() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcceuil = new JFrame();
		frmAcceuil.setTitle("Acceuil");
		frmAcceuil.setBounds(100, 100, 1400, 1000);
		frmAcceuil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
