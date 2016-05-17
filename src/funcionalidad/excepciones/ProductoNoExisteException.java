package funcionalidad.excepciones;

public class ProductoNoExisteException extends Exception {
	private static final long serialVersionUID = 1L;

	public ProductoNoExisteException(String string){
		super(string);
	}
}
