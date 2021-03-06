package funcionalidad;

import java.util.regex.Pattern;

import funcionalidad.enumeraciones.MarcaTablet;
import funcionalidad.enumeraciones.ModeloTablet;
import funcionalidad.excepciones.DescripcionNoValidaException;
import funcionalidad.excepciones.IdNoValidaException;
import funcionalidad.excepciones.MarcaTabletNoValidaException;
import funcionalidad.excepciones.ModeloTabletNoValidoException;
import funcionalidad.excepciones.NombreNoValidoException;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.PrecioNoValidoException;

/**
 * Clase Tablet. Una tablet adem�s de los atributos del padre tendr�:
 * <ul>
 * <li>Marca de la tablet. Enumaraci�n con varias marcas de tablet</li>
 * <li>Modelo de la tablet. Enumeraci�n basada en la marca con varios modelos por marca.</li>
 * <li>Memoria. N�mero de GB de memoria RAM</li>
 * <li>Pantalla. Tama�o de la pantalla en pulgadas</li>
 * </ul>
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class Tablet extends Producto {
	private static final long serialVersionUID = 1L;

	/**
	 * Patr�n de la id para una tablet
	 */
	private static final Pattern patternID = Pattern.compile("^ta\\d{4}$",Pattern.CASE_INSENSITIVE);
	
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
	 * Tama�o de la pantalla en pulgadas
	 */
	float pantalla;
	
	/**
	 * Constructor que recibe la id, el nombre, la descripci�n, el precio, el n�mero de unidades, la marca,
	 * el modelo, la memoria y la pantalla de la tablet.
	 * @param id del producto
	 * @param nombre del producto
	 * @param descripcion del producto
	 * @param precio del producto
	 * @param unidades del producto
	 * @param marcaTablet marca del producto
	 * @param modeloTablet modelo del producto
	 * @param memoria del producto
	 * @param procesador del producto
	 * @param pantalla del producto
	 * @throws IdNoValidaException id no v�lida
	 * @throws NumeroUnidadesNoValidoException n�mero de unidades no v�lido
	 * @throws PrecioNoValidoException precio no v�lido
	 * @throws NombreNoValidoException nombre no v�lido
	 * @throws DescripcionNoValidaException descripci�n no v�lida
	 * @throws MarcaTabletNoValidaException marca no v�lida
	 * @throws ModeloTabletNoValidoException modelo no v�lido
	 */
	public Tablet(String id,String nombre,String descripcion,float precio,int unidades,
			MarcaTablet marcaTablet,ModeloTablet modeloTablet,String procesador,int memoria,float pantalla)
			throws IdNoValidaException, NumeroUnidadesNoValidoException, PrecioNoValidoException, 
				NombreNoValidoException, DescripcionNoValidaException, MarcaTabletNoValidaException,
				ModeloTabletNoValidoException{
		super(id,nombre,descripcion,precio,unidades);
		setMarcaTablet(marcaTablet);
		setModeloTablet(modeloTablet);
		setProcesador(procesador);
		setMemoria(memoria);
		setPantalla(pantalla);
	}
	
	/**
	 * Comprueba que la id cumpla con el patr�n establecido
	 * @param id del producto
	 * @return true si la id sigue el patr�n
	 */
	private boolean esValidaID(String id) {
		return patternID.matcher(id).matches();
	}
	
	/**
	 * Establece la id del producto
	 * @throws IdNoValidaException id no v�lida
	 */
	@Override
	protected void setId(String id) throws IdNoValidaException {
		if (!esValidaID(id))
			throw new IdNoValidaException("La id no es v�lida.");
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
	 * @throws MarcaTabletNoValidaException marca no v�lida
	 */
	private void setMarcaTablet(MarcaTablet marcaTablet) throws MarcaTabletNoValidaException {
		if(marcaTablet==null)
			throw new MarcaTabletNoValidaException("La marca de la tablet no puede estar vac�a");
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
	 * @throws ModeloTabletNoValidoException modelo no v�lido
	 */
	private void setModeloTablet(ModeloTablet modeloTablet) throws ModeloTabletNoValidoException {
		if(modeloTablet==null)
			throw new ModeloTabletNoValidoException("El modelo de la tablet no puede estar vac�o");
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
	 * Obtiene el tama�o de pantalla de la tablet
	 * @return pantalla tama�o de la pantalla de la tablet
	 */
	public float getPantalla() {
		return pantalla;
	}

	/**
	 * Establece el tama�o de la pantalla
	 * @param pantalla tama�o de la pantalla
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
	 * Calcula el precio de la tablet. Se aplica un descuento en funci�n del tama�o de la pantalla,
	 * cuanto mayor es el tama�o de la pantalla menor ser� el descuento. Por ejemplo una tablet con
	 * pantalla de 7 pulgadas recibe un descuento del 14,2%, una de 10 recibe un descuento del 10%
	 * y as� sucesivamente
	 * @return precio con descuento ya aplicado
	 */
	@Override
	public float calcularPrecio(){
		float descuento=(float) ((100/pantalla)*0.01);
		return (precio-(precio*descuento));
	}
}
