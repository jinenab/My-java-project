import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
 
public class Fenetre extends JFrame  implements ActionListener,MouseListener{
  public Fenetre(){             
    this.setTitle("Ma première fenêtre Java");
    this.setSize(400, 100);
    this.setLocationRelativeTo(null);               
    //Instanciation d'un objet JPanel
    JPanel pan = new JPanel();
    //Définition de sa couleur de fond
    pan.setBackground(Color.ORANGE);        
    //On prévient notre JFrame que notre JPanel sera son content pane
    this.setContentPane(pan);               
    this.setVisible(true);
  //Possibilité 1 : instanciation avec le libellé
    JButton bouton = new JButton("Ajouter Client");
    //Possibilité 2 : instanciation puis définition du libellé
    JButton bouton2 = new JButton();
    bouton2.setText("Ajouter Compte");
    pan.add(bouton);
    pan.add(bouton2);
    //JTextArea grandeZone = new JTextArea(4, 10);
    //pan.add(grandeZone);
    
	/*
    JComboBox liste1;
	Object[] elements = new Object[]{"Element 1", "Element 2", "Element 3", "Element 4", "Element 5"};
	liste1 = new JComboBox(elements);
	pan.add(liste1);
	*/
    bouton.addActionListener(this);
    bouton.addMouseListener(this);
 }

 
@Override
public void actionPerformed(ActionEvent e) {
    System.out.println("Clic sur le bouton : " + e.getActionCommand());
  
}
@Override
public void mouseClicked(MouseEvent event) {
	 System.out.println("Mouse clicked : ");    
  }



@Override
public void mousePressed(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseReleased(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseEntered(MouseEvent e) {
	// TODO Auto-generated method stub
	
}


@Override
public void mouseExited(MouseEvent e) {
	// TODO Auto-generated method stub
	
}




      
}