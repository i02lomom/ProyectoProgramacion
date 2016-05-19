package funcionalidad.excepciones;

/**
 * Excepción TipoDeComponenteNoValido
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class TipoDeComponenteNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public TipoDeComponenteNoValidoException(String string){
		super(string);
	}
}
