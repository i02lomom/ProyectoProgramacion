package funcionalidad.excepciones;

/**
 * Excepción SistemaOperativoNoValido
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class SistemaOperativoNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public SistemaOperativoNoValidoException(String string) {
		super(string);
	}

}
