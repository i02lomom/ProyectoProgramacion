package funcionalidad.excepciones;

/**
 * Excepci�n N�meroUnidadesNoValido
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class NumeroUnidadesNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor
	 * @param string mensaje
	 */
	public NumeroUnidadesNoValidoException(String string){
		super(string);
	}
}
