package trab4bim.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ResetarDaos {
	
	Connection con = Conexao.getInstace().conOpen();
	
	public void resetar(String nomeDaTabela){
		try {
			PreparedStatement ps  = getCon().prepareStatement("DELETE FROM " + nomeDaTabela);
			ps.executeUpdate();
			ps  = getCon().prepareStatement("ALTER TABLE " + nomeDaTabela + " AUTO_INCREMENT = 1");
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public Connection getCon() {
		return con;
	}

	
	
}
