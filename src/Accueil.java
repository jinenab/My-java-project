import java.awt.Color;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
 
public class Accueil extends JFrame implements ActionListener {
	JButton button,button2;

	public Accueil(JButton button, JButton button2) throws HeadlessException {
		super();
		this.button = button;
		this.button2 = button2;
		this.setTitle("Accueil");
		this.setSize(400, 100);
		this.setLocationRelativeTo(null);  
		//Instanciation d'un objet JPanel
	    JPanel pan = new JPanel();
	    pan.setBackground(Color.RED);        
	    this.setContentPane(pan);               
	    this.setVisible(true);
	    pan.add(button);
	    pan.add(button2);
	    button.addActionListener(this);
	    button2.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	    System.out.println("Boutton cliqué : " + e.getActionCommand());
	    if(e.getActionCommand()=="Ajouter Client")
	    {this.button.setVisible(false);}
	    if(e.getActionCommand()=="Ajouter Compte")
	    {this.button2.setVisible(false);}

		
	}

}
