package funcionalidad.excepciones;

/**
 * Excepción DescripcionNoValida
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class DescripcionNoValidaException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public DescripcionNoValidaException(String string){
		super(string);
	}
}
