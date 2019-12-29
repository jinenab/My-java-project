import java.awt.Color;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreAjouterClient extends JFrame implements ActionListener {
	 JLabel labelNom= new JLabel("nom");
	 JLabel labelPrenom= new JLabel("prenom");
	 JLabel labelCin= new JLabel("cin");
	 JTextField nom= new JTextField("nom");
	 JTextField prenom= new JTextField("prenom");
	 JTextField cin= new JTextField("000000");
     JButton valider = new JButton("Valider");
     Connection cn;
     JComboBox typeClient = new JComboBox( new Object[]{"Client Normal", "Client Salarie", "Client Vip"});
	public FenetreAjouterClient(Connection cn) throws HeadlessException {
		
		super();	
		this.cn=cn;
		this.setSize(400, 100);
		this.setLocationRelativeTo(null); 
		JPanel panel = new JPanel();
		panel.setBackground(Color.GREEN);  
	    this.setContentPane(panel);               
	    this.setVisible(true); 
	    nom.setPreferredSize(new Dimension(150, 30));
	    prenom.setPreferredSize(new Dimension(150, 30));
	    cin.setPreferredSize(new Dimension(150, 30));
		panel.add(nom);
		panel.add(prenom);
		panel.add(cin);
		
	
		panel.add(typeClient);
	    panel.add(valider);
	    valider.addActionListener(this);
	    typeClient.setSelectedItem("Client Normal");
	    
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String nomm,prenomm;int cinn;
		nomm=nom.getText();
		prenomm=prenom.getText();
        cinn=Integer.parseInt(cin.getText());
		System.out.println(typeClient.getSelectedItem());
		System.out.println(nomm);
		System.out.println(prenomm);
		System.out.println(cinn);
		if(typeClient.getSelectedItem()=="Client Normal") {
			ClientNormal client=new ClientNormal(nomm,prenomm,cinn);

			System.out.println(client);
			try {
				client.ajouterClient(cn);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
}
