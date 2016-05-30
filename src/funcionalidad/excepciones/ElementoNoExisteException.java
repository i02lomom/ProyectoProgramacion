package funcionalidad.excepciones;

public class ElementoNoExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public ElementoNoExisteException(String string){
		super(string);
	}
}
