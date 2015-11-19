package trab4bim.telaLogin;

import trab4bim.Dao.DaoUsuario;
import trab4bim.telas.TelaPrincipal;

public class SistemaProxy implements Sistema{

	public SistemaProxy(String usu, String pass) {
		abrir(usu, pass);
	}

	@Override
	public void abrir(String user, String pass) {
		if (VerificaUserPass(user, pass)) {
			new TelaPrincipal().abrir(user, pass);
		} else {
			throw new RuntimeException("Usuário ou senha\nINCORRETOS\n");
		}
		
	}
	
	private boolean VerificaUserPass(String user, String pass){
		DaoUsuario d = new DaoUsuario();
		boolean v = d.Verifica(user, pass);
		return v;
	}
	
}
