package excecoes;

public class ObjetoInexistente extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ObjetoInexistente(String msg){
		super(msg);
	}
}