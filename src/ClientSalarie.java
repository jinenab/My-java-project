import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientSalarie extends Client {
	String profession;
	float salaire;
    public ClientSalarie(String nom, String prenom, int cin,String profession,float salaire) {
		super(nom, prenom, cin);
		this.profession=profession;
		this.salaire=salaire;

    }

	public void ajouterClient(Connection cn) throws SQLException  {
		PreparedStatement statement,st=null;
		statement=cn.prepareStatement("INSERT INTO clientsalarie VALUES (null, ?, ?, ?,?,?)");
		st=cn.prepareStatement("INSERT INTO client VALUES (null, ?, ?)");
		st.setInt(1, cin);
		st.setInt(2, 2);
		statement.setString(1,nom); 
		statement.setString(2,prenom); 
		statement.setString(3,profession);
		statement.setInt(4,cin);
		statement.setFloat(5,salaire);

		
		
		try {
			st.executeUpdate();
			statement.executeUpdate();
			System.out.println("client salarie  ajouté");

		} catch (SQLException e) {
			System.out.println("client salarie non ajouté");
			e.printStackTrace();
		}

		
	}
}
