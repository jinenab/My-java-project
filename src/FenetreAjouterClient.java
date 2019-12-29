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
	//Les bouttons et les textes field
	 JLabel labelNom= new JLabel("nom");
	 JLabel labelPrenom= new JLabel("prenom");
	 JLabel labelCin= new JLabel("cin");
	 JTextField nom= new JTextField("nom");
	 JTextField prenom= new JTextField("prenom");
	 JTextField profession= new JTextField("profession");
	 JTextField salaire= new JTextField("0");
	 JTextField cin= new JTextField("000000");
     JButton valider = new JButton("Valider");
     JTextField entrprise= new JTextField("nom entprise");
     JTextField nombre= new JTextField("0");
     JTextField chiffreAffaires= new JTextField("0");

     Connection cn;
     JComboBox typeClient = new JComboBox( new Object[]{"Client Normal", "Client Salarie", "Client Vip"});
	 public FenetreAjouterClient(Connection cn) throws HeadlessException {
		super();	
		this.cn=cn;
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setTitle("Ajouter Client");

		this.setLocationRelativeTo(null); 
		JPanel panel = new JPanel();
		panel.setBackground(Color.RED);  
	    this.setContentPane(panel);               
	    this.setVisible(true); 
	    nom.setPreferredSize(new Dimension(150, 30));
	    prenom.setPreferredSize(new Dimension(150, 30));
	    cin.setPreferredSize(new Dimension(150, 30));
		panel.add(nom);
		panel.add(prenom);
		panel.add(cin);
		
		panel.add(typeClient);
		profession.setPreferredSize(new Dimension(150, 30));
		salaire.setPreferredSize(new Dimension(150, 30));
        profession.setVisible(false);
        salaire.setVisible(false);
		panel.add(profession);
		panel.add(salaire);
	    panel.add(valider);
	    valider.addActionListener(this);
	    typeClient.addActionListener(this);
	    typeClient.setSelectedItem("Client Normal");
	    
	    
	    entrprise.setVisible(false);
	    nombre.setVisible(false);
	    chiffreAffaires.setVisible(false);

	    panel.add(entrprise);
	    panel.add(salaire);
	    panel.add(chiffreAffaires);
	  
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println(typeClient.getSelectedItem());
		String nomm,prenomm;int cinn;
		nomm=nom.getText();
		prenomm=prenom.getText();
        cinn=Integer.parseInt(cin.getText());
		System.out.println(typeClient.getSelectedItem());
		System.out.println(nomm);
		System.out.println(prenomm);
		System.out.println(cinn);
		if(typeClient.getSelectedItem()=="Client Normal") {
			profession.setVisible(false);
			salaire.setVisible(false);
			//System.out.println("Normal");

			ClientNormal client=new ClientNormal(nomm,prenomm,cinn);

			System.out.println(client);
			
			/*
			 * try {
				client.ajouterClient(cn);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}*/
	
	}
		if(typeClient.getSelectedItem()=="Client Salarie") {
			//System.out.println("Salarie");
			profession.setVisible(true);
			salaire.setVisible(true);
			String pro;float sal=0;
			pro=profession.getText();
			sal=Float.parseFloat(salaire.getText());
			ClientSalarie clientSalarie=new ClientSalarie(nomm,prenomm,cinn,pro,sal);
			try {
				clientSalarie.ajouterClient(cn);
			} catch (SQLException e1) {
								e1.printStackTrace();
			}
		}
	if(typeClient.getSelectedItem()=="Client Vip") {
		profession.setVisible(false);
		salaire.setVisible(false);
		entrprise.setVisible(true);
	    nombre.setVisible(true);
		chiffreAffaires.setVisible(true);

	
	}
}
}
