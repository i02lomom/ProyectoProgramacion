package fecha;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.regex.Pattern;

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
	 * @throws FechaNoValidaException 
	 */
	public Fecha(int dia,int mes,int anno) throws FechaNoValidaException{
		if(!esValida(dia,mes-1,anno))
			throw new FechaNoValidaException("Fecha no v�lida.");
	}
	
	/**
	 * Constructor que recibe como par�metro la fecha (como cadena)
	 * @throws FormatoNoValidoException 
	 * @throws NumberFormatException 
	 * @throws FechaNoValidaException 
	 */
	public Fecha(String cadena) throws FormatoNoValidoException, NumberFormatException, FechaNoValidaException{
		if(!esValidoFormato(cadena))
			throw new FormatoNoValidoException("Formato no v�lido.");
		if(!esValida(cadena))
			throw new FechaNoValidaException("Fecha no v�lida.");
	}

	/**
	 * Comprueba si el formato de la fecha es v�lido
	 * @param cadena
	 * @return true si la cadena cumple el patr�n
	 */
	private boolean esValidoFormato(String cadena){
		Pattern pattern=Pattern.compile("(0?[1-9]|[12][0-9]|3[01])[- /](0?[1-9]|1[012])[- /](19|20)\\d\\d");
		return pattern.matcher(cadena).matches();
	}
	
	/**
	 * A partir de una cadena obtenemos un array con 3 subcadenas, el d�a el mes y el a�o
	 * @param cadena
	 * @return array de cadenas
	 */
	private String[] obtenerArrayDiaMesAnno(String cadena){
		return cadena.split("[ -/]");
	}
	
	/**
	 * Suma a la fecha los d�as,meses y a�os dados
	 * @param dias
	 * @param meses
	 * @param annos
	 * @throws SumaNoValidaException
	 */
	public void sumar(int dias,int meses,int annos) throws SumaNoValidaException{
		if(dias<0 || meses<0 || annos<0)
			throw new SumaNoValidaException("Valores de suma no v�lidos.");
		
		calendar.add(GregorianCalendar.DAY_OF_MONTH, dias);
		calendar.add(GregorianCalendar.MONTH, meses);
		calendar.add(GregorianCalendar.YEAR, annos);	
	}
	
	/**
	 * Comprueba si la fecha dada a trav�s de enteros (d�a, mes y a�o) es v�lida
	 * @param dia
	 * @param mes
	 * @param anno
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
	 * @param cadena
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
	 * Calcula la diferencia en d�as entre dos fechas
	 * @param fecha
	 * @return diferencia en d�as
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
	 * Calcula la diferencia en a�os entre dos fechas 
	 * @param fecha
	 * @return diferencia en a�os
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
	 * @return true si tiene 18 o m�s y false si tiene menos
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
	 * @return
	 */
	public boolean esFuturo(){
		return calendar.after(GregorianCalendar.getInstance());
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
	 * Obtiene la edad a partir de la fecha de nacimiento
	 * @return edad
	 */
	public int obtenerEdad(){
		LocalDate fecha=LocalDate.of(calendar.get(GregorianCalendar.YEAR),
				calendar.get(GregorianCalendar.MONTH)+1,
				calendar.get(GregorianCalendar.DAY_OF_MONTH));
		
		LocalDate fecha2 = LocalDate.now();
		
		return (int)ChronoUnit.YEARS.between(fecha,fecha2);
	}
	
	/**
	 * Crea una nueva fecha siempre que �sta sea v�lida
	 * @param dia
	 * @param mes
	 * @param anno
	 * @throws FechaNoValidaException
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
