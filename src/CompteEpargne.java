import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CompteEpargne extends Compte {

	public CompteEpargne(Client client, int rib, Date date, float solde) {
		super(client, rib, date, solde);
	}

	@Override
	public boolean retrait(float montant) {
		if(solde<2000 )
		return true;
		return false;
	}

	@Override
	public boolean depot(float montant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean virement(Compte compte, float montant) {
		return false;
	}

	@Override
	public void ajouterCompte(Connection cn) throws SQLException {
		PreparedStatement statement;
		statement=cn.prepareStatement("INSERT INTO comptes  VALUES (null, ?, ?, ?,?,?,?)");
		statement.setInt(1,rib); 
		statement.setInt(2,client.getCin()); 
		statement.setFloat(3,solde); 
		statement.setDate(4, date);
		statement.setInt(5, 4);

		if(client instanceof ClientNormal)
		{
			statement.setInt(6, 1);
		}
		if(client instanceof ClientSalarie)
		{
			statement.setInt(6, 2);
		}
		try {

			statement.executeUpdate();
			System.out.println("compte epargne  ajouté");

		} catch (SQLException e) {
			System.out.println("compte epargne non ajouté");
			e.printStackTrace();
		}

		
	}


}
