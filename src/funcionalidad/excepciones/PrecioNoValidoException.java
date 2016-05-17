package funcionalidad.excepciones;

/**
 * Excepción PrecioNoValido
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class PrecioNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * @param string mensaje
	 */
	public PrecioNoValidoException(String string){
		super(string);
	}
}
