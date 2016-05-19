package funcionalidad.excepciones;

/**
 * Excepci�n DescripcionNoValida
 * 
 * @author Miguel Angel L�pez Moyano
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
