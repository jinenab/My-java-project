import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Accueil extends JFrame implements ActionListener {
	JButton button,button2;
	JButton button3;
	Connection cn;
	public Accueil(Connection cn) throws HeadlessException {
		super();

		button=new JButton("Ajouter Client");
		button2=new JButton("Ajouter Compte");
		button3=new JButton("Afficher Clients");		
		
		this.cn=cn;
		this.setTitle("Accueil");
		this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		this.setLocationRelativeTo(null);  
		//Instanciation d'un objet JPanel
	    JPanel pan = new JPanel();
	    pan.setBackground(Color.RED);        
	    this.setContentPane(pan);               
	    this.setVisible(true);
	    pan.add(button);
	    pan.add(button2);
	    pan.add(button3);

	    button.addActionListener(this);
	    button3.addActionListener(this);

	    button2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
	    System.out.println("Boutton cliqué : " + e.getActionCommand());
	    if(e.getActionCommand()=="Ajouter Client")
	    {this.setVisible(false);
	    FenetreAjouterClient a=new FenetreAjouterClient(cn);
	    }
	    if(e.getActionCommand()=="Ajouter Compte")
	    {this.button2.setVisible(false);}
	    if(e.getActionCommand()=="Afficher Clients")
	    {this.setVisible(false);
	    FenetreAfficherClient b=new FenetreAfficherClient(cn);

	    }
		
	}

}
