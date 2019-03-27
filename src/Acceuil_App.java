import java.awt.EventQueue;

import javax.swing.JFrame;

public class Acceuil_App {

	private JFrame frmAcceuil;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Acceuil_App window = new Acceuil_App();
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
	public Acceuil_App() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAcceuil = new JFrame();
		frmAcceuil.setVisible(true);
		frmAcceuil.setTitle("Acceuil");
		frmAcceuil.setBounds(100, 100, 1400, 1000);
		frmAcceuil.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
