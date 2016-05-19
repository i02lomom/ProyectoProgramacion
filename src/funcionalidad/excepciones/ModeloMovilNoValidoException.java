package funcionalidad.excepciones;

/**
 * Excepción
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class ModeloMovilNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public ModeloMovilNoValidoException(String string) {
		super(string);
	}

}
