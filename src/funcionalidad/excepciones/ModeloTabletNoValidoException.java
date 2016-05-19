package funcionalidad.excepciones;

/**
 * Excepción ModeloTabletNoValido
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 *
 */
public class ModeloTabletNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public ModeloTabletNoValidoException(String string) {
		super(string);
	}

}
