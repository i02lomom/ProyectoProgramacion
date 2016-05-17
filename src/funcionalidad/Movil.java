package funcionalidad;

import java.util.regex.Pattern;

import funcionalidad.enumeraciones.MarcaMovil;
import funcionalidad.enumeraciones.ModeloMovil;
import funcionalidad.enumeraciones.SistemaOperativo;
import funcionalidad.excepciones.IdNoValidaException;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.PrecioNoValidoException;

/**
 * Clase Movil. Un móvil además de los atributos del padre tendrá:
 * <ul>
 * <li>Marca del móvil. Enumeración con varias marcas de móvil</li>
 * <li>Modelo del móvil. Enumeración basada en la marca con varios modelos por marca.</li>
 * <li>Sistema operativo. Enumeración con varios sistemas operativos.</li>
 * <li>Cámara. Número de megapíxeles de la cámara.</li>
 * <li>Memoria. Número de GB de memoria RAM</li>
 * <li>Procesador. Tipo de procesador</li>
 * </ul>
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Movil extends Producto {
	private static final long serialVersionUID = 1L;
	/**
	 * Patrón de la id para un móvil
	 */
	private static final Pattern patternID = Pattern.compile("^MO\\d{4}|mo\\d{4}$");
	/**
	 * Marca del móvil
	 */
	private MarcaMovil marcaMovil;
	
	/**
	 * Modelo del móvil
	 */
	private ModeloMovil modeloMovil;
	
	/**
	 * Sistema operativo del móvil
	 */
	private SistemaOperativo sistemaOperativo;
	
	/**
	 * Calidad de la cámara del móvil (en megapíxeles)
	 */
	private int camara;
	
	/**
	 * Memoria del teléfono (en GB)
	 */
	private int memoria;
	
	/**
	 * Procesador del móvil
	 */
	private String procesador;
	
	/**
	 * Constructor que recibe la id, el nombre, la descripción, el precio, las unidades,
	 * la marca, el modelo, el sistema operativo,la cámara, la memoria y el procesador
	 * @param id del móvil
	 * @param nombre del móvil
	 * @param descripcion del móvil
	 * @param precio del móvil
	 * @param unidades de móvil
	 * @param marcaMovil del móvil
	 * @param modeloMovil del móvil
	 * @param sistemaOperativo del móvil
	 * @param camara del móvil
	 * @param memoria del móvil
	 * @param procesador del móvil
	 * @throws IdNoValidaException id no válida
	 * @throws NumeroUnidadesNoValidoException número de unidades no válido
	 * @throws PrecioNoValidoException 
	 */
	Movil(String id,String nombre,String descripcion,float precio,int unidades,
			MarcaMovil marcaMovil,ModeloMovil modeloMovil,SistemaOperativo sistemaOperativo,
			int camara,int memoria,String procesador) 
			throws IdNoValidaException, NumeroUnidadesNoValidoException, PrecioNoValidoException{
		super(id,nombre,descripcion,precio,unidades);
		setMarcaMovil(marcaMovil);
		setModeloMovil(modeloMovil);
		setSistemaOperativo(sistemaOperativo);
		setCamara(camara);
		setMemoria(memoria);
		setProcesador(procesador);
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
	 * Obtiene la marca del móvil
	 * @return marca del móvil
	 */
	public MarcaMovil getMarcaMovil() {
		return marcaMovil;
	}

	/**
	 * Establece la marca del móvil
	 * @param marcaMovil marca del móvil
	 */
	private void setMarcaMovil(MarcaMovil marcaMovil) {
		this.marcaMovil = marcaMovil;
	}

	/**
	 * Obtiene el modelo del móvil
	 * @return modelo del móvil
	 */
	public ModeloMovil getModeloMovil() {
		return modeloMovil;
	}

	/**
	 * Establece el modelo del móvil
	 * @param modeloMovil modelo del móvil
	 */
	private void setModeloMovil(ModeloMovil modeloMovil) {
		this.modeloMovil = modeloMovil;
	}

	/**
	 * Obtiene el sistema operativo del móvil
	 * @return sistema operativo del móvil
	 */
	public SistemaOperativo getSistemaOperativo() {
		return sistemaOperativo;
	}

	/**
	 * Establece el sistema operativo del móvil
	 * @param sistemaOperativo sistema operativo del móvil
	 */
	private void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	/**
	 * Obtiene el número de megapíxeles de la cámara del móvil
	 * @return número de megapíxeles de la cámara
	 */
	public int getCamara() {
		return camara;
	}

	/**
	 * Establece el número de megapíxeles de la cámara
	 * @param camara número de megapíxeles de la cámara
	 */
	private void setCamara(int camara) {
		this.camara = camara;
	}

	/**
	 * Obtiene la cantidad de GB de RAM del móvil
	 * @return cantidad de GB de RAM del móvil
	 */
	public int getMemoria() {
		return memoria;
	}

	/**
	 * Establece la cantidad de GB de RAM del móvil
	 * @param memoria cantidad de GB de RAM del móvil
	 */
	private void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	/**
	 * Obtiene el tipo de procesador del móvil
	 * @return procesador del móvil
	 */
	public String getProcesador() {
		return procesador;
	}

	/**
	 * Establece el tipo de procesador del móvil
	 * @param procesador del móvil
	 */
	private void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	
	/**
	 * Calcula el precio del móvil. Se aplica un descuento en función de la calidad de la cámara,
	 * cuanto mayor es la calidad de la cámara menor será el descuento. Por ejemplo un móvil con
	 * cámara de 8 megapíxeles recibe un descuento del 12,5%, uno de 16 recibe 6,25% y así
	 * sucesivamente
	 */
	@Override
	public float calcularPrecio(){
		float descuento=(float) ((100/camara)*0.01);
		return (precio-(precio*descuento));
	}
}
