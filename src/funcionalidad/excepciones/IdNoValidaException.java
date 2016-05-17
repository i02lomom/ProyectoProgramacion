package funcionalidad.excepciones;

/**
 * Excepción IdNoValida.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class IdNoValidaException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public IdNoValidaException(String string){
		super(string);
	}
}
