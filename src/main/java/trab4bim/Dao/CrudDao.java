package trab4bim.Dao;

/**
 * @author Alex Santos Rocha, 28/10/2015 - 01:18:30
 * 
 * Comentário: Interface genérica para implementar o CrudDao, que vai
 * 			   utilizar dados de um tipo específico.
 */
import java.util.List;

public interface CrudDao <T>{

	public int inserir(T tipo);
	
	public int atualizar(T tipo);
	
	public int deletar(int tipo);
	
	public T buscarUm(int id);
	
	public List<T> listar();  
}
