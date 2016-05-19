package funcionalidad.excepciones;

/**
 * Excepci�n MarcaMovilNoValida
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class MarcaMovilNoValidaException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public MarcaMovilNoValidaException(String string) {
		super(string);
	}

}
