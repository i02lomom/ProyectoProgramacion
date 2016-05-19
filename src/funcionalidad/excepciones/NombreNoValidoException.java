package funcionalidad.excepciones;

/**
 * Excepción NombreNoVálido
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class NombreNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public NombreNoValidoException(String string){
		super(string);
	}
}
