package funcionalidad;

import java.util.regex.Pattern;

import funcionalidad.enumeraciones.TipoComponente;
import funcionalidad.excepciones.IdNoValidaException;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.PrecioNoValidoException;

/**
 * Clase componente. Un componente además de los atributos del padre tendrá:
 * <ul>
 * <li>Tipo de componente. Enumeración con varios tipos de componentes</li>
 * <li>Fabricante.</li>
 * </ul>
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Componente extends Producto{
	private static final long serialVersionUID = 1L;

	/**
	 * Patrón que debe seguir la id de un componente
	 */
	private static final Pattern patternID = Pattern.compile("^CO\\d{4}|co\\d{4}$");
	
	/**
	 * Tipo de componente
	 */
	private TipoComponente tipoComponente;
	
	/**
	 * Fabricante del componente
	 */
	private String fabricante;
	
	/**
	 * Constructor que recibe la id, el nombre, la descripción, el precio, las unidades,
	 * el tipo de componente y el fabricante.
	 * @param id del producto
	 * @param nombre del producto
	 * @param descripcion del producto
	 * @param precio del producto
	 * @param unidades del producto
	 * @param tipoComponente del producto
	 * @param fabricante del producto
	 * @throws IdNoValidaException id no válida
	 * @throws NumeroUnidadesNoValidoException número de unidades no válido
	 * @throws PrecioNoValidoException  precio no válido
	 */
	Componente(String id,String nombre,String descripcion,float precio,int unidades,
			TipoComponente tipoComponente,String fabricante) 
			throws IdNoValidaException, NumeroUnidadesNoValidoException, PrecioNoValidoException{
		
		super(id,nombre,descripcion,precio,unidades);
		setTipoComponente(tipoComponente);
		setFabricante(fabricante);
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
	 * Obtiene el tipo de componente
	 * @return tipo de componente
	 */
	public TipoComponente getTipoComponente() {
		return tipoComponente;
	}

	/**
	 * Establece el tipo de componente
	 * @param tipoComponente 
	 */
	private void setTipoComponente(TipoComponente tipoComponente) {
		this.tipoComponente = tipoComponente;
	}

	/**
	 * Obtiene el fabricante del producto
	 * @return fabricante del producto
	 */
	public String getFabricante() {
		return fabricante;
	}

	/**
	 * Establece el fabricante del producto
	 * @param fabricante del producto
	 */
	private void setFabricante(String fabricante) {
		this.fabricante = fabricante;
	}
	
	/**
	 * Calcula el precio del componente. En función del tipo de componente se hará un descuento
	 * u otro.
	 * @return precio del producto con el descuento aplicado.
	 */
	@Override
	public float calcularPrecio(){
		float precioConDescuento=0;
		switch(tipoComponente){
		case CAJA:
			precioConDescuento=(float)(precio-(precio*0.03));
			break;
		case GRAFICA:
			precioConDescuento=(float)(precio-(precio*0.05));
			break;
		case MEMORIA:
			precioConDescuento=(float)(precio-(precio*0.06));
			break;
		case PERIFERICO:
			precioConDescuento=(float)(precio-(precio*0.08));
			break;
		case PLACA:
			precioConDescuento=(float)(precio-(precio*0.07));
			break;
		case PROCESADOR:
			precioConDescuento=(float)(precio-(precio*0.04));
			break;
		default:
			break;
		}
		return precioConDescuento;
	}

}
