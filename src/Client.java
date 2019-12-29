import java.sql.Connection;
import java.sql.SQLException;

public abstract class Client {
	String nom,prenom;
	int cin;
	public Client(String nom, String prenom, int cin) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.cin = cin;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public int getCin() {
		return cin;
	}
	public void setCin(int cin) {
		this.cin = cin;
	}
	abstract public void ajouterClient(Connection cn) throws SQLException;
}
