import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClientVip extends Client {
	
	String entreprise;
	int nbEmploye;
	float chiffreAffaires;
	public ClientVip(String nom, String prenom, int cin,String entreprise,int nbEmploye,float chiffreAffaires) {
		super(nom, prenom, cin);
		this.entreprise=entreprise;
		this.nbEmploye=nbEmploye;
		this.chiffreAffaires=chiffreAffaires;
	}
	
		public String getEntreprise() {
		return entreprise;
	}

	public void setEntreprise(String entreprise) {
		this.entreprise = entreprise;
	}

	public int getNbEmploye() {
		return nbEmploye;
	}

	public void setNbEmploye(int nbEmploye) {
		this.nbEmploye = nbEmploye;
	}

	public float getChiffreAffaires() {
		return chiffreAffaires;
	}

	public void setChiffreAffaires(float chiffreAffaires) {
		this.chiffreAffaires = chiffreAffaires;
	}

		public void ajouterClient(Connection cn) throws SQLException  {
		PreparedStatement statement=null;
		PreparedStatement st=null;

		st=cn.prepareStatement("INSERT INTO client VALUES (null, ?, ?)");
		st.setInt(1, cin);
		st.setInt(2, 3);
		statement=cn.prepareStatement("INSERT INTO clientvip VALUES (null,?,?,?,?,?,?)");
		statement.setString(1,nom); 
		statement.setString(2,prenom); 
		statement.setString(3,entreprise);
		statement.setInt(4,cin);
		statement.setInt(5,nbEmploye);
		statement.setFloat(6, chiffreAffaires);
		
		try {
			st.executeUpdate();
			statement.executeUpdate();
			System.out.println("client vip  ajouté");
		} catch (SQLException e) {
			System.out.println("client vip non ajouté");
			e.printStackTrace();
		}

		
	}
}
