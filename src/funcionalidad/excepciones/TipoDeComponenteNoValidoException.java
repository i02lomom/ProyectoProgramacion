package funcionalidad.excepciones;

/**
 * Excepci�n TipoDeComponenteNoValido
 * 
 * @author Miguel Angel L�pez Moyano
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
