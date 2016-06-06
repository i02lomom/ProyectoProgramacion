package fecha;

import java.io.Serializable;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Clase fecha. Nos permite realizar las operaciones m�s comunes con fechas.
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class Fecha implements Serializable{
	private static final long serialVersionUID = 1L;

	public GregorianCalendar calendar;
	
	private static final Locale locale = new Locale("es", "ES");
	
	/**
	 * Constructor por defecto
	 */
	public Fecha(){
		calendar=new GregorianCalendar(locale);
	}
	
	/**
	 * Constructor que recibe como par�metros el d�a, el mes y el a�o
	 * @param dia de la fecha
	 * @param mes de la fecha
	 * @param anno de la fecha
	 * @throws FechaNoValidaException la fecha no es v�lida
	 */
	public Fecha(int dia,int mes,int anno) throws FechaNoValidaException{
		if(!esValida(dia,mes-1,anno))
			throw new FechaNoValidaException("Fecha no v�lida.");
	}
	
	/**
	 * Constructor que recibe como par�metro la fecha (como cadena)
	 * @param cadena fecha en formato String
	 * @throws FormatoNoValidoException el formato no es v�lido
	 * @throws NumberFormatException conversi�n no v�lida
	 * @throws FechaNoValidaException la fecha no es v�lida
	 */
	public Fecha(String cadena) throws FormatoNoValidoException, NumberFormatException, FechaNoValidaException{
		if(!esValidoFormato(cadena))
			throw new FormatoNoValidoException("Formato no v�lido.");
		if(!esValida(cadena))
			throw new FechaNoValidaException("Fecha no v�lida.");
	}

	/**
	 * Comprueba si el formato de la fecha es v�lido
	 * @param cadena fecha 
	 * @return true si la cadena cumple el patr�n
	 */
	private boolean esValidoFormato(String cadena){
		Pattern pattern=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])[- /](0?[1-9]|1[012])[- /](19|20)\\d\\d");
		return pattern.matcher(cadena).matches();
	}
	
	/**
	 * A partir de una cadena obtenemos un array con 3 subcadenas, el d�a el mes y el a�o
	 * @param cadena fecha
	 * @return array de cadenas
	 */
	private String[] obtenerArrayDiaMesAnno(String cadena){
		return cadena.split("[ -/]");
	}
	
	/**
	 * Comprueba si la fecha dada a trav�s de enteros (d�a, mes y a�o) es v�lida
	 * @param dia de la fecha
	 * @param mes de la fecha
	 * @param anno de la fecha
	 * @return true si es v�lida y false si no lo es
	 */
	private boolean esValida(int dia,int mes,int anno){
		try {
			setGregorianCalendar(dia,mes,anno);
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Comprueba si la fecha dada a trav�s de una cadena es v�lida
	 * @param cadena fecha
	 * @return true si es v�lida y false si no lo es
	 */
	private boolean esValida(String cadena){
		String[] array=obtenerArrayDiaMesAnno(cadena);
		try {
			return (esValida(Integer.parseInt(array[0]),
					Integer.parseInt(array[1])-1,
					Integer.parseInt(array[2])));	
		} catch (NumberFormatException e) {
			return false;
		}
	}
	
	/**
	 * Devuelve el d�a de la semana de una fecha en castellano
	 * @return cadena con el d�a de la semana
	 */
	public String getDiaDeLaSemana(){
		return calendar.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, locale);
	}
	
	/**
	 * Devuelve el mes en castellano
	 * @return cadena con el mes
	 */
	public String getMes(){
		return calendar.getDisplayName(Calendar.MONTH, Calendar.LONG, locale);
	}
	
	/**
	 * Crea una nueva fecha siempre que �sta sea v�lida
	 * @param dia de la fecha
	 * @param mes de la fecha
	 * @param anno de la fecha
	 * @throws FechaNoValidaException la fecha no es v�lida
	 */
	void setGregorianCalendar(int dia,int mes,int anno) throws FechaNoValidaException{
		try {
			calendar= new GregorianCalendar(locale);
			calendar.set(anno, mes, dia);
			calendar.setLenient(false);
			calendar.getTime();
		} catch (Exception e) {
			throw new FechaNoValidaException("Fecha no v�lida.");
		}
	}
	
	/**
	 * Obtiene la fecha
	 * @return fecha
	 */
	public GregorianCalendar getFecha() {
		return calendar;
	}

	@Override
	public String toString() {
		return calendar.get(GregorianCalendar.DAY_OF_MONTH) + 
				"/" + 
				(calendar.get(GregorianCalendar.MONTH)+1) + 
				"/" +
				calendar.get(GregorianCalendar.YEAR);
	}
}
