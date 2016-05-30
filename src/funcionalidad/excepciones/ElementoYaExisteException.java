package funcionalidad.excepciones;

/**
 * Excepción ProductoYaExiste
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class ElementoYaExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public ElementoYaExisteException(String string){
		super(string);
	}
}
