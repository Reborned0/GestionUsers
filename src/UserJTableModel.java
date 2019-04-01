import java.util.List;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;

import metier.User;

public class UserJTableModel extends AbstractTableModel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8772110109294138474L;
	private String[] nomColonnes;
	private Vector<String []> Vec;

	public UserJTableModel () {
		nomColonnes = new String[] {
				"Id",
				"Prénom",
				"Nom"
		};
		Vec = new Vector<String []>() ;
	}
	
	@Override
	public int getColumnCount() {
		
		return nomColonnes.length;
	}

	/**
	 * @ return nombre de lignes dans l'objet JTable
	 */
	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		
		return Vec.get(rowIndex)[columnIndex];
	}
	
	@Override
	public int getRowCount() {
		// TODO Stub de la m�thode g�n�r� automatiquement
		return Vec.size();
	}
	
	public void loadData(List<User> lesUsers) {
		Vec = new Vector<String[]>(); // vider le contenu
		for (User unUtilisateur : lesUsers) {
			//Chaque ligne du JTable est un tableau de String
			Vec.add(new String[] { unUtilisateur.getId(), unUtilisateur.getPrenom(), unUtilisateur.getNom() });
		}
		fireTableChanged(null); // prévient que les données ont changé

	}


}
