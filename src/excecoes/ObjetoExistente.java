package excecoes;

public class ObjetoExistente extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ObjetoExistente(String msg){
		super(msg);
	}
}