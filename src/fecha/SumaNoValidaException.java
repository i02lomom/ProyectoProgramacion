package fecha;

/**
 * Excepción SumaNoValida
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class SumaNoValidaException extends Exception {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor
	 * @param string mensaje
	 */
	public SumaNoValidaException(String string){
		super(string);
	}

}
