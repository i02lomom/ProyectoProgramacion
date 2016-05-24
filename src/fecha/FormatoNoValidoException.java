package fecha;

/**
 * Excepci�n FormatoNoValido.
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class FormatoNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * @param string mensaje
	 */
	public FormatoNoValidoException(String string){
		super(string);
	}
}
