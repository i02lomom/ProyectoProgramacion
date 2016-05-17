package funcionalidad;

import java.util.regex.Pattern;

import funcionalidad.enumeraciones.MarcaMovil;
import funcionalidad.enumeraciones.ModeloMovil;
import funcionalidad.enumeraciones.SistemaOperativo;
import funcionalidad.excepciones.IdNoValidaException;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.PrecioNoValidoException;

/**
 * Clase Movil. Un m�vil adem�s de los atributos del padre tendr�:
 * <ul>
 * <li>Marca del m�vil. Enumeraci�n con varias marcas de m�vil</li>
 * <li>Modelo del m�vil. Enumeraci�n basada en la marca con varios modelos por marca.</li>
 * <li>Sistema operativo. Enumeraci�n con varios sistemas operativos.</li>
 * <li>C�mara. N�mero de megap�xeles de la c�mara.</li>
 * <li>Memoria. N�mero de GB de memoria RAM</li>
 * <li>Procesador. Tipo de procesador</li>
 * </ul>
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class Movil extends Producto {
	private static final long serialVersionUID = 1L;
	/**
	 * Patr�n de la id para un m�vil
	 */
	private static final Pattern patternID = Pattern.compile("^MO\\d{4}|mo\\d{4}$");
	/**
	 * Marca del m�vil
	 */
	private MarcaMovil marcaMovil;
	
	/**
	 * Modelo del m�vil
	 */
	private ModeloMovil modeloMovil;
	
	/**
	 * Sistema operativo del m�vil
	 */
	private SistemaOperativo sistemaOperativo;
	
	/**
	 * Calidad de la c�mara del m�vil (en megap�xeles)
	 */
	private int camara;
	
	/**
	 * Memoria del tel�fono (en GB)
	 */
	private int memoria;
	
	/**
	 * Procesador del m�vil
	 */
	private String procesador;
	
	/**
	 * Constructor que recibe la id, el nombre, la descripci�n, el precio, las unidades,
	 * la marca, el modelo, el sistema operativo,la c�mara, la memoria y el procesador
	 * @param id del m�vil
	 * @param nombre del m�vil
	 * @param descripcion del m�vil
	 * @param precio del m�vil
	 * @param unidades de m�vil
	 * @param marcaMovil del m�vil
	 * @param modeloMovil del m�vil
	 * @param sistemaOperativo del m�vil
	 * @param camara del m�vil
	 * @param memoria del m�vil
	 * @param procesador del m�vil
	 * @throws IdNoValidaException id no v�lida
	 * @throws NumeroUnidadesNoValidoException n�mero de unidades no v�lido
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
	 * Comprueba que la id cumpla con el patr�n establecido
	 * @param id del producto
	 * @return true si la id sigue el patr�n
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
			throw new IdNoValidaException("La id no es v�lida.");
		super.setId(id.toUpperCase());
	}

	/**
	 * Obtiene la marca del m�vil
	 * @return marca del m�vil
	 */
	public MarcaMovil getMarcaMovil() {
		return marcaMovil;
	}

	/**
	 * Establece la marca del m�vil
	 * @param marcaMovil marca del m�vil
	 */
	private void setMarcaMovil(MarcaMovil marcaMovil) {
		this.marcaMovil = marcaMovil;
	}

	/**
	 * Obtiene el modelo del m�vil
	 * @return modelo del m�vil
	 */
	public ModeloMovil getModeloMovil() {
		return modeloMovil;
	}

	/**
	 * Establece el modelo del m�vil
	 * @param modeloMovil modelo del m�vil
	 */
	private void setModeloMovil(ModeloMovil modeloMovil) {
		this.modeloMovil = modeloMovil;
	}

	/**
	 * Obtiene el sistema operativo del m�vil
	 * @return sistema operativo del m�vil
	 */
	public SistemaOperativo getSistemaOperativo() {
		return sistemaOperativo;
	}

	/**
	 * Establece el sistema operativo del m�vil
	 * @param sistemaOperativo sistema operativo del m�vil
	 */
	private void setSistemaOperativo(SistemaOperativo sistemaOperativo) {
		this.sistemaOperativo = sistemaOperativo;
	}

	/**
	 * Obtiene el n�mero de megap�xeles de la c�mara del m�vil
	 * @return n�mero de megap�xeles de la c�mara
	 */
	public int getCamara() {
		return camara;
	}

	/**
	 * Establece el n�mero de megap�xeles de la c�mara
	 * @param camara n�mero de megap�xeles de la c�mara
	 */
	private void setCamara(int camara) {
		this.camara = camara;
	}

	/**
	 * Obtiene la cantidad de GB de RAM del m�vil
	 * @return cantidad de GB de RAM del m�vil
	 */
	public int getMemoria() {
		return memoria;
	}

	/**
	 * Establece la cantidad de GB de RAM del m�vil
	 * @param memoria cantidad de GB de RAM del m�vil
	 */
	private void setMemoria(int memoria) {
		this.memoria = memoria;
	}

	/**
	 * Obtiene el tipo de procesador del m�vil
	 * @return procesador del m�vil
	 */
	public String getProcesador() {
		return procesador;
	}

	/**
	 * Establece el tipo de procesador del m�vil
	 * @param procesador del m�vil
	 */
	private void setProcesador(String procesador) {
		this.procesador = procesador;
	}
	
	/**
	 * Calcula el precio del m�vil. Se aplica un descuento en funci�n de la calidad de la c�mara,
	 * cuanto mayor es la calidad de la c�mara menor ser� el descuento. Por ejemplo un m�vil con
	 * c�mara de 8 megap�xeles recibe un descuento del 12,5%, uno de 16 recibe 6,25% y as�
	 * sucesivamente
	 */
	@Override
	public float calcularPrecio(){
		float descuento=(float) ((100/camara)*0.01);
		return (precio-(precio*descuento));
	}
}
