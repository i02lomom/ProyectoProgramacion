package funcionalidad;

import java.io.Serializable;

import fecha.Fecha;
import funcionalidad.excepciones.DescripcionNoValidaException;
import funcionalidad.excepciones.IdNoValidaException;
import funcionalidad.excepciones.NombreNoValidoException;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.PrecioNoValidoException;

/**
 * Clase producto. Un producto se compone de:
 * <ul>
 * <li>Id. Identificador que se compone de dos letras seguidas de cuatro números, siendo las letras:</li>
 * <ul>
 * <li>CO si el producto es un componente</li>
 * <li>MO si el producto es un móvil</li>
 * <li>TA si el producto es una tablet</li>
 * </ul>
 * <li>Nombre. Nombre del producto</li>
 * <li>Descripción. Descripción del producto</li>
 * <li>Precio. Precio del producto</li>
 * <li>Fecha de recepción. Fecha de recepción del producto (fecha en la que se añade al ArrayList)</li>
 * <li>Unidades. Número de unidades (no puede ser menor que uno)</li>
 * </ul>
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public abstract class Producto implements Serializable, Descuentable{
	private static final long serialVersionUID = 1L;

	/**
	 * Identificador del producto
	 */
	private String id;
	
	/**
	 * Nombre del producto
	 */
	private String nombre;
	
	/**
	 * Descripcion del producto
	 */
	private String descripcion;
	
	/**
	 * Precio del producto
	 */
	protected float precio;
	
	/**
	 * Fecha de recepción del producto
	 */
	private Fecha fechaRecepcion;
	
	/**
	 * Número de unidades del producto
	 */
	private int unidades;

	/**
	 * Constructor que recibe la id del producto
	 * @param id del producto
	 * @throws IdNoValidaException id no válida
	 */
	Producto(String id) throws IdNoValidaException{
		super();
		setId(id);
	}
	
	/**
	 * Contructor que recibe la id, el nombre, la descripción, el precio y las unidades
	 * @param id del producto
	 * @param nombre del producto
	 * @param descripcion del producto
	 * @param precio del producto
	 * @param unidades del producto
	 * @throws IdNoValidaException id no válida
	 * @throws NumeroUnidadesNoValidoException número de unidades no válido
	 * @throws PrecioNoValidoException 
	 * @throws NombreNoValidoException 
	 * @throws DescripcionNoValidaException 
	 */
	Producto(String id,String nombre,String descripcion,float precio,int unidades) throws
			IdNoValidaException, NumeroUnidadesNoValidoException, PrecioNoValidoException, 
			NombreNoValidoException, DescripcionNoValidaException{
		super();
		setId(id);
		setNombre(nombre);
		setDescripcion(descripcion);
		setPrecio(precio);
		setFechaRecepcion(new Fecha());
		setUnidades(unidades);
	}
	
	
	/**
	 * Obtiene la id del producto
	 * @return id del producto
	 */
	public String getId() {
		return id;
	}

	/**
	 * Obtiene el nombre del producto
	 * @return nombre del producto
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * Obtiene la descripción del producto
	 * @return
	 */
	public String getDescripcion() {
		return descripcion;
	}

	/**
	 * Obtiene el precio del producto
	 * @return
	 */
	public float getPrecio() {
		return precio;
	}

	/**
	 * Obtiene la fecha de recepción
	 * @return fecha de recepción
	 */
	public Fecha getFechaRecepcion() {
		return fechaRecepcion;
	}

	/**
	 * Obtiene las unidades del producto
	 * @return
	 */
	public int getUnidades() {
		return unidades;
	}

	/**
	 * Establece la id del producto
	 * @param id del producto
	 * @throws IdNoValidaException id no válida
	 */
	protected void setId(String id) throws IdNoValidaException{
		this.id = id;
	}

	/**
	 * Establece el nombre del producto
	 * @param nombre del producto
	 * @throws NombreNoValidoException 
	 */
	private void setNombre(String nombre) throws NombreNoValidoException {
		if(nombre.equals(""))
			throw new NombreNoValidoException("El nombre no puede estar vacío.");
		this.nombre = nombre;
	}

	/**
	 * Establece la descripción del producto
	 * @param descripcion del producto
	 * @throws DescripcionNoValidaException 
	 */
	public void setDescripcion(String descripcion) throws DescripcionNoValidaException {
		if(descripcion.equals(""))
			throw new DescripcionNoValidaException("La descripción no puede estar vacía.");
		this.descripcion = descripcion;
	}

	/**
	 * Establece el precio del producto
	 * @param precio del producto
	 * @throws PrecioNoValidoException 
	 */
	public void setPrecio(float precio) throws PrecioNoValidoException {
		if(precio<=0)
			throw new PrecioNoValidoException("El precio debe de ser mayor que cero.");
		this.precio = precio;
	}

	/**
	 * Estable la fecha de recepción (fecha actual)
	 * @param fechaRecepcion del producto
	 */
	private void setFechaRecepcion(Fecha fechaRecepcion) {
		this.fechaRecepcion = fechaRecepcion;
	}

	/**
	 * Establece las unidades de producto (siempre que sean maor que cero)
	 * @param unidades del producto
	 * @throws NumeroUnidadesNoValidoException número de unidades no válido
	 */
	public void setUnidades(int unidades) throws NumeroUnidadesNoValidoException {
		if(unidades<0)
			throw new NumeroUnidadesNoValidoException("Las unidades deben de ser mayores que cero.");
		this.unidades = unidades;
	}

	/**
	 * Método abstracto que calculará el precio (con descuento incluido). Será redefinido en cada
	 * uno de los hijos.
	 * @return precio del producto
	 */
	@Override
	public abstract float calcularPrecio();

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Producto other = (Producto) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		return true;
	}
}
