package fecha;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Pattern;

/**
 * Clase fecha. Nos permite realizar las operaciones más comunes con fechas.
 * 
 * @author Miguel Angel López Moyano
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
	 * Constructor que recibe como parámetros el día, el mes y el año
	 * @param dia de la fecha
	 * @param mes de la fecha
	 * @param anno de la fecha
	 * @throws FechaNoValidaException la fecha no es válida
	 */
	public Fecha(int dia,int mes,int anno) throws FechaNoValidaException{
		if(!esValida(dia,mes-1,anno))
			throw new FechaNoValidaException("Fecha no válida.");
	}
	
	/**
	 * Constructor que recibe como parámetro la fecha (como cadena)
	 * @param cadena fecha en formato String
	 * @throws FormatoNoValidoException el formato no es válido
	 * @throws NumberFormatException conversión no válida
	 * @throws FechaNoValidaException la fecha no es válida
	 */
	public Fecha(String cadena) throws FormatoNoValidoException, NumberFormatException, FechaNoValidaException{
		if(!esValidoFormato(cadena))
			throw new FormatoNoValidoException("Formato no válido.");
		if(!esValida(cadena))
			throw new FechaNoValidaException("Fecha no válida.");
	}

	/**
	 * Comprueba si el formato de la fecha es válido
	 * @param cadena fecha 
	 * @return true si la cadena cumple el patrón
	 */
	private boolean esValidoFormato(String cadena){
		Pattern pattern=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])[- /](0?[1-9]|1[012])[- /](19|20)\\d\\d");
		return pattern.matcher(cadena).matches();
	}
	
	/**
	 * A partir de una cadena obtenemos un array con 3 subcadenas, el día el mes y el año
	 * @param cadena fecha
	 * @return array de cadenas
	 */
	private String[] obtenerArrayDiaMesAnno(String cadena){
		return cadena.split("[ -/]");
	}
	
	/**
	 * Suma a la fecha los días,meses y años dados
	 * @param dias los días de la fecha
	 * @param meses los meses de la fecha
	 * @param annos los años de la fecha 
	 * @throws SumaNoValidaException la suma no es válida
	 */
	public void sumar(int dias,int meses,int annos) throws SumaNoValidaException{
		if(dias<0 || meses<0 || annos<0)
			throw new SumaNoValidaException("Valores de suma no válidos.");
		
		calendar.add(GregorianCalendar.DAY_OF_MONTH, dias);
		calendar.add(GregorianCalendar.MONTH, meses);
		calendar.add(GregorianCalendar.YEAR, annos);	
	}
	
	/**
	 * Comprueba si la fecha dada a través de enteros (día, mes y año) es válida
	 * @param dia de la fecha
	 * @param mes de la fecha
	 * @param anno de la fecha
	 * @return true si es válida y false si no lo es
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
	 * Comprueba si la fecha dada a través de una cadena es válida
	 * @param cadena fecha
	 * @return true si es válida y false si no lo es
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
	 * Calcula la diferencia en días entre dos fechas
	 * @param fecha de la que calcularemos los días
	 * @return diferencia en días
	 */
	public long calcularDiasTranscurridos(Fecha fecha){
		LocalDate fecha1=LocalDate.of(fecha.calendar.get(GregorianCalendar.YEAR),
				fecha.calendar.get(GregorianCalendar.MONTH)+1,
				fecha.calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		LocalDate fecha2=LocalDate.of(calendar.get(GregorianCalendar.YEAR),
				calendar.get(GregorianCalendar.MONTH)+1,
				calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		return Math.abs(ChronoUnit.DAYS.between(fecha1, fecha2));
	}
	
	/**
	 * Calcula la diferencia en años entre dos fechas 
	 * @param fecha de la que calcularemos los años transcurridos
	 * @return diferencia en años
	 */
	public long calcularAnnosTranscurridos(Fecha fecha){
		LocalDate fecha1=LocalDate.of(fecha.calendar.get(GregorianCalendar.YEAR),
				fecha.calendar.get(GregorianCalendar.MONTH)+1,
				fecha.calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		LocalDate fecha2=LocalDate.of(calendar.get(GregorianCalendar.YEAR),
				calendar.get(GregorianCalendar.MONTH)+1,
				calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		return Math.abs(ChronoUnit.YEARS.between(fecha1, fecha2));
	}
	
	/**
	 * Comprueba si la fecha de nacimiento y nos indica si la persona es mayor de edad
	 * @return true si tiene 18 o más y false si tiene menos
	 */
	public boolean esMayorDeEdad(){
		LocalDate fecha=LocalDate.of(calendar.get(GregorianCalendar.YEAR),
				calendar.get(GregorianCalendar.MONTH)+1,
				calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		LocalDate fecha2 = LocalDate.now();
		
		if(ChronoUnit.YEARS.between(fecha,fecha2)<18)
			return false;
		return true;
			
	}
	
	/**
	 * Comprueba si una fecha es posterior a la actual
	 * @return true si la fecha es posterior y false si no.
	 */
	public boolean esFuturo(){
		return calendar.after(GregorianCalendar.getInstance());
	}
	
	/**
	 * Devuelve el día de la semana de una fecha en castellano
	 * @return cadena con el día de la semana
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
	 * Obtiene la edad a partir de la fecha de nacimiento
	 * @return edad obtenida a través de la fecha de nacimiento
	 */
	public int obtenerEdad(){
		LocalDate fecha=LocalDate.of(calendar.get(GregorianCalendar.YEAR),
				calendar.get(GregorianCalendar.MONTH)+1,
				calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		LocalDate fecha2 = LocalDate.now();
		
		return (int)ChronoUnit.YEARS.between(fecha,fecha2);
	}
	
	/**
	 * Crea una nueva fecha siempre que ésta sea válida
	 * @param dia de la fecha
	 * @param mes de la fecha
	 * @param anno de la fecha
	 * @throws FechaNoValidaException la fecha no es válida
	 */
	void setGregorianCalendar(int dia,int mes,int anno) throws FechaNoValidaException{
		try {
			calendar= new GregorianCalendar(locale);
			calendar.set(anno, mes, dia);
			calendar.setLenient(false);
			calendar.getTime();
		} catch (Exception e) {
			throw new FechaNoValidaException("Fecha no válida.");
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
