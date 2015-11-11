package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 28/10/2015 - 23:06:41
 * 
 * Comentario: Classe Conexão implementa o padrão singleton de somente uma instacia
 * 			   Ela vai permitir abrir conexao com o bando de dados mysql
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {
	private Connection con;
	
	private static Conexao inst;
	private Conexao(){}	
	public static Conexao getInstace(){
		if(inst == null )
			return inst = new Conexao();
		return inst;
	}
	
	public Connection conOpen(){
		String driverName = "com.mysql.jdbc.Driver";
		String url = "jdbc:mysql://localhost/tb4bim";
		String user = "root";
		String pass = "'123'";
		try {
			Class.forName(driverName);
			return con = DriverManager.getConnection(url, user, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean conClose(){
		try {			
			con.close();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
		
}
