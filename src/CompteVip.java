import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompteVip extends Compte {

	public CompteVip(ClientVip client, int rib, Date date, float solde) {
		super(client, rib, date, solde);
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean retrait(float montant) {
		if(((ClientVip) client).getChiffreAffaires()*1.05>=montant)
		{
			solde=solde-montant;
			return true;
		}
		return false;
	}

	@Override
	public boolean depot(float montant) {
		solde=solde+montant;
		return true;
	}

	@Override
	public boolean virement(Compte compte, float montant) {
			if(retrait(montant))	{
				compte.depot(montant);
				return true;
			}
				return false;
	}

	@Override
	public void ajouterCompte(Connection cn) throws SQLException {
		PreparedStatement statement;
		statement=cn.prepareStatement("INSERT INTO comptes  VALUES (null, ?,?, ?,?, ?,?)");
		statement.setInt(1,rib); 
		statement.setInt(2,client.getCin()); 
		statement.setFloat(3,solde); 
		statement.setDate(4, date);
		statement.setInt(5,3);
		statement.setInt(6,3); 


		try {
			statement.executeUpdate();
			System.out.println("compte vip  ajout�");

		} catch (SQLException e) {
			System.out.println("compte vip non ajout�");
			e.printStackTrace();
		}

		
	}


}
