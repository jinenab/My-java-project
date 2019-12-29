import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;


abstract public class Compte {
Client client;
int rib;
Date date;
float solde;




public Compte(Client client, int rib, Date date, float solde) {
	super();
	this.client = client;
	this.rib = rib;
	this.date =   date;
	this.solde = solde;
}

public Client getClient() {
	return client;
}

public void setClient(Client client) {
	this.client = client;
}

public int getRib() {
	return rib;
}

public void setRib(int rib) {
	this.rib = rib;
}

public Date getDate() {
	return date;
}

public void setDate(Date date) {
	this.date =  date;
}

public float getSolde() {
	return solde;
}

public void setSolde(float solde) {
	this.solde = solde;
}
abstract public boolean retrait(float montant); 
abstract public boolean depot(float montant); 
abstract public boolean virement(Compte compte,float montant);  
abstract public void ajouterCompte(Connection cn) throws SQLException;
}
