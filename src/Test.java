import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws ClassNotFoundException, SQLException, ParseException {
		String url="jdbc:mysql://localhost/banque?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
		String login="root";
		String pwd="";
		Connection cn=null;
		Statement st=null;
		ClientNormal c=new ClientNormal("trabelsi","mouna", 172535);
		ClientSalarie cs= new  ClientSalarie("jouini","imed",9800,"ingénieur",2500);
		ClientVip cv =new ClientVip("mabrouk","ahmed",125,"randa",20,(float) 220000.5);
		@SuppressWarnings("deprecation")
		//mois commence a partir de 0
		//jour commence a partir de 1
		// annee commence de 1900
		java.sql.Date date = new java.sql.Date(2019-1900,1,2);
		//System.out.println(date);
		CompteEpargne compte1=new CompteEpargne( c, 81556,   date, (float) 88700.25);
		Class.forName("com.mysql.cj.jdbc.Driver");
			cn = DriverManager.getConnection(url,login,pwd);
		    //c.ajouterClient(cn);
			//cs.ajouterClient(cn);
			//cv.ajouterClient(cn);
		   //compte1.ajouterCompte(cn);
		    JButton bouton = new JButton("Ajouter Client");
		    JButton bouton2 = new JButton("Ajouter Compte");

		    Accueil f=new Accueil(cn);
		    //FenetreAjouterClient a=new FenetreAjouterClient(cn);
       
		   // FenetreAfficherClient b=new FenetreAfficherClient(cn);
c.afficherClient(cn);
}
}