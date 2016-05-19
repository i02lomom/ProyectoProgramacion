package funcionalidad.excepciones;

/**
 * Excepci�n MarcaTabletNoValida
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class MarcaTabletNoValidaException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public MarcaTabletNoValidaException(String string) {
		super(string);
	}

}
