import java.awt.Color;
import java.awt.HeadlessException;
import java.sql.Connection;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class FenetreAfficherClient extends JFrame {
	 public FenetreAfficherClient(Connection cn) throws HeadlessException {
		super();
		Object[][] data = {
			      {"Cysboy", "28 ans", "1.80 m"},
			      {"BZHHydde", "28 ans", "1.80 m"},
			      {"IamBow", "24 ans", "1.90 m"},
			      {"FunMan", "32 ans", "1.85 m"}
			    };

			    //Les titres des colonnes
			    String  title[] = {"Pseudo", "Age", "Taille"};
			    JTable tableau = new JTable(data, title);
			    tableau.setBackground(Color.RED);
			    JPanel pan = new JPanel();
				pan.setBackground(Color.RED);
			    this.setContentPane(pan);               

				this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
			   pan.add(new JScrollPane(tableau));
				this.setVisible(true);
	}
	
}
