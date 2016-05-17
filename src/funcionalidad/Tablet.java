package funcionalidad;

import java.util.regex.Pattern;

import funcionalidad.enumeraciones.MarcaTablet;
import funcionalidad.enumeraciones.ModeloTablet;
import funcionalidad.excepciones.IdNoValidaException;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.PrecioNoValidoException;

/**
 * Clase Tablet. Una tablet además de los atributos del padre tendrá:
 * <ul>
 * <li>Marca de la tablet. Enumaración con varias marcas de tablet</li>
 * <li>Modelo de la tablet. Enumeración basada en la marca con varios modelos por marca.</li>
 * <li>Memoria. Número de GB de memoria RAM</li>
 * <li>Pantalla. Tamaño de la pantalla en pulgadas</li>
 * </ul>
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Tablet extends Producto {
	private static final long serialVersionUID = 1L;

	/**
	 * Patrón de la id para una tablet
	 */
	private static final Pattern patternID = Pattern.compile("^TA\\d{4}|ta\\d{4}$");
	
	/**
	 * Marca de la tablet
	 */
	private MarcaTablet marcaTablet;
	
	/**
	 * Modelo de la tablet
	 */
	private ModeloTablet modeloTablet;
	
	/**
	 * Tipo de procesador la tablet
	 */
	private String procesador;
	
	/**
	 * Memoria de la tablet en GB
	 */
	int memoria;
	
	/**
	 * Tamaño de la pantalla en pulgadas
	 */
	float pantalla;
	
	/**
	 * Constructor que recibe la id, el nombre, la descripción, el precio, el número de unidades, la marca,
	 * el modelo, la memoria y la pantalla de la tablet.
	 * @param id
	 * @param nombre
	 * @param descripcion
	 * @param precio
	 * @param unidades
	 * @param marcaTablet
	 * @param modeloTablet
	 * @param memoria
	 * @param pantalla
	 * @throws IdNoValidaException id no válida
	 * @throws NumeroUnidadesNoValidoException número de unidades no válido
	 * @throws PrecioNoValidoException precio no válido
	 */
	Tablet(String id,String nombre,String descripcion,float precio,int unidades,
			MarcaTablet marcaTablet,ModeloTablet modeloTablet,String procesador,int memoria,float pantalla)
			throws IdNoValidaException, NumeroUnidadesNoValidoException, PrecioNoValidoException{
		super(id,nombre,descripcion,precio,unidades);
		setMarcaTablet(marcaTablet);
		setModeloTablet(modeloTablet);
		setProcesador(procesador);
		setMemoria(memoria);
		setPantalla(pantalla);
	}
	
	/**
	 * Comprueba que la id cumpla con el patrón establecido
	 * @param id del producto
	 * @return true si la id sigue el patrón
	 */
	private boolean esValidaID(String id) {
		return patternID.matcher(id).matches();
	}
	
	/**
	 * Establece la id del producto
	 */
	@Override
	protected void setId(String id) throws IdNoValidaException {
		if (!esValidaID(id))
			throw new IdNoValidaException("La id no es válida.");
		super.setId(id.toUpperCase());
	}

	/**
	 * Obtiene la marca de la tablet
	 * @return marca de la tablet
	 */
	public MarcaTablet getMarcaTablet() {
		return marcaTablet;
	}

	/**
	 * Establece la marca de la tablet
	 * @param marcaTablet marca de la tablet
	 */
	private void setMarcaTablet(MarcaTablet marcaTablet) {
		this.marcaTablet = marcaTablet;
	}

	/**
	 * Obtiene el modelo de la tablet
	 * @return modelo de la tablet
	 */
	public ModeloTablet getModeloTablet() {
		return modeloTablet;
	}

	/**
	 * Establece el modelo de la tablet 
	 * @param modeloTablet modelo de la tablet
	 */
	private void setModeloTablet(ModeloTablet modeloTablet) {
		this.modeloTablet = modeloTablet;
	}

	/**
	 * Obtiene la cantidad de memoria de la tablet
	 * @return cantidad de memoria de la tablet
	 */
	public int getMemoria() {
		return memoria;
	}

	/**
	 * Establece la cantidad de memoria de la tablet
	 * @param memoria de la tablet
	 */
	private void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	/**
	 * Obtiene el tamaño de pantalla de la tablet
	 * @return pantalla tamaño de la pantalla de la tablet
	 */
	public float getPantalla() {
		return pantalla;
	}

	/**
	 * Establece el tamaño de la pantalla
	 * @param pantalla
	 */
	private void setPantalla(float pantalla) {
		this.pantalla = pantalla;
	}
	
	/**
	 * Obtiene el tipo de procesador de la tablet
	 * @return procesador de la tablet
	 */
	public String getProcesador() {
		return procesador;
	}

	/**
	 * Establece el tipo de procesador de la tablet
	 * @param procesador de la tablet
	 */
	private void setProcesador(String procesador) {
		this.procesador = procesador;
	}

	/**
	 * Calcula el precio de la tablet. Se aplica un descuento en función del tamaño de la pantalla,
	 * cuanto mayor es el tamaño de la pantalla menor será el descuento. Por ejemplo una tablet con
	 * pantalla de 7 pulgadas recibe un descuento del 14,2%, una de 10 recibe un descuento del 10%
	 * y así sucesivamente
	 */
	@Override
	public float calcularPrecio(){
		float descuento=(float) ((100/pantalla)*0.01);
		return (precio-(precio*descuento));
	}
}
