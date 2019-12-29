import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.SQLException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FenetreAjouterClient extends JFrame implements MouseListener,ActionListener {
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
     JTextField chiffreAffaires= new JTextField("0.0");

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
		//panel.setLayout(gl);
		BoxLayout gl = new BoxLayout(panel, 0);
		
	    this.setContentPane(panel); 

	    this.setVisible(true); 
	    nom.setPreferredSize(new Dimension(100,30));
		panel.add(nom);
		 prenom.setPreferredSize(new Dimension(100,30));

		panel.add(prenom);
		 cin.setPreferredSize(new Dimension(100,30));

		panel.add(cin);
		typeClient.setPreferredSize(new Dimension(100,30));

		panel.add(typeClient);
	
        profession.setVisible(false);
        salaire.setVisible(false);
		profession.setPreferredSize(new Dimension(100,30));

		panel.add(profession);
		salaire.setPreferredSize(new Dimension(100,30));

		panel.add(salaire);
		entrprise.setPreferredSize(new Dimension(100,30));

		panel.add(entrprise);
		salaire.setPreferredSize(new Dimension(100,30));

	    panel.add(salaire);
		chiffreAffaires.setPreferredSize(new Dimension(100,30));

	    panel.add(chiffreAffaires);
		nombre.setPreferredSize(new Dimension(100,30));

	    panel.add(nombre);
		valider.setPreferredSize(new Dimension(100,30));

	    panel.add(valider);
	    
	    typeClient.setSelectedItem("Client Normal");
	    
	    entrprise.setVisible(false);
	    nombre.setVisible(false);

	    chiffreAffaires.setVisible(false);

	    //Ajouter un mouseListner pour le boutton valider
	    typeClient.addActionListener(this);  
	    valider.addMouseListener(this); 
	}

	@Override
	public void mouseClicked(MouseEvent e) {
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
		
			ClientNormal client=new ClientNormal(nomm,prenomm,cinn);

			 try {
				client.ajouterClient(cn);
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
	
		if(typeClient.getSelectedItem()=="Client Salarie") {
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
        ClientVip clientVip=new ClientVip(nomm,prenomm,cinn,entrprise.getText(),Integer.parseInt(nombre.getText()),Float.parseFloat(chiffreAffaires.getText()));
        try {
			clientVip.ajouterClient(cn);
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void actionPerformed(ActionEvent e) {
	    System.out.println("Select : " + e.getActionCommand());

			if(typeClient.getSelectedItem()=="Client Normal") {
				profession.setVisible(false);
				salaire.setVisible(false);
				
		}
	
			if(typeClient.getSelectedItem()=="Client Salarie") {
				profession.setVisible(true);
				salaire.setVisible(true);
				entrprise.setVisible(false);
			    nombre.setVisible(false);
				chiffreAffaires.setVisible(false);
					
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
