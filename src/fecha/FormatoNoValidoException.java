package fecha;

public class FormatoNoValidoException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public FormatoNoValidoException(String string){
		super(string);
	}
}
