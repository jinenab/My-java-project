import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientNormal extends Client {
public ClientNormal(String nom, String prenom, int cin) {
		super(nom, prenom, cin);
	}

@Override
public String toString() {
	return "ClientNormal [nom=" + nom + ", prenom=" + prenom + ", cin=" + cin + "]";
}

public void ajouterClient(Connection cn) throws SQLException  {
	PreparedStatement statement,st=null;
	statement=cn.prepareStatement("INSERT INTO clientnormal  VALUES (null, ?, ?, ?)");
	/*st=cn.prepareStatement("INSERT INTO client VALUES (null, ?, ?)");
	st.setInt(1, cin);
	st.setInt(2, 1);*/
	statement.setString(1,nom); 
	statement.setString(2,prenom); 
	statement.setInt(3,cin); 
	try {
	//	st.executeUpdate();

		statement.executeUpdate();
		System.out.println("compte normal  ajouté");

	} catch (SQLException e) {
		System.out.println("compte normal non ajouté");
		e.printStackTrace();
	}

	
}

}

