package funcionalidad;

import java.io.Serializable;
import java.util.ArrayList;

import funcionalidad.enumeraciones.MarcaMovil;
import funcionalidad.enumeraciones.MarcaTablet;
import funcionalidad.enumeraciones.ModeloMovil;
import funcionalidad.enumeraciones.ModeloTablet;
import funcionalidad.enumeraciones.SistemaOperativo;
import funcionalidad.enumeraciones.TipoComponente;
import funcionalidad.excepciones.IdNoValidaException;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.PrecioNoValidoException;
import funcionalidad.excepciones.ProductoNoExisteException;
import funcionalidad.excepciones.ProductoYaExisteException;

/**
 * Clase Tienda. Envoltorio de ArrayList de productos. Contiene los métodos:
 * <ul>
 * <li>Añadir. Uno por cada tipo de producto</li>
 * <li>Eliminar.</li>
 * <li>Get. Obtenemos el producto a través de la id.</li>
 * <li>GetProducto. Obtenemos el producto a través del nombre.</li>
 * </ul>
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Tienda implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * Lista de productos.
	 */
	private ArrayList<Producto> almacen=new ArrayList<Producto>();
	
	/**
	 * Atributo que indica si se ha modificado la lista
	 */
	public boolean modificado=false;
	
	/**
	 * Devuelve la lista de productos
	 * @return almacen lista de productos
	 */
	public ArrayList<Producto> getAlmacen(){
		return almacen;
	}
	
	/**
	 * Comprueba si la lista de prodcutos está modificada
	 * @return modificado
	 */
	public boolean estaModificado() {
		return modificado;
	}

	/**
	 * Establece el valor de modificado (true o false)
	 * @param modificado
	 */
	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}
	
	/**
	 * Añade un producto de tipo componente
	 * @param id del producto
	 * @param nombre del producto
	 * @param descripcion del producto
	 * @param precio del producto
	 * @param unidades del producto
	 * @param tipoComponente del producto
	 * @param fabricante del producto
	 * @return true si se añade correctamente
	 * @throws IdNoValidaException id no válida
	 * @throws NumeroUnidadesNoValidoException número de unidades no válido
	 * @throws PrecioNoValidoException precio no válido
	 * @throws ProductoYaExisteException ya existe el producto en la lista
	 */
	public boolean anadir(String id,String nombre,String descripcion,float precio,
			int unidades,TipoComponente tipoComponente,String fabricante) 
			throws IdNoValidaException, NumeroUnidadesNoValidoException,
			PrecioNoValidoException, ProductoYaExisteException{
		Producto producto=new Componente(id,nombre,descripcion,precio,unidades,tipoComponente,fabricante);
		return anadirProducto(producto);
	}
	
	/**
	 * Añade un producto de tipo móvil
	 * @param id del producto
	 * @param nombre del producto
	 * @param descripcion del producto
	 * @param precio del producto
	 * @param unidades del producto
	 * @param marcaMovil del producto
	 * @param modeloMovil del producto
	 * @param sistemaOperativo del producto
	 * @param camara del producto
	 * @param memoria del producto
	 * @param procesador del producto
	 * @return true si se añade correctamente
	 * @throws IdNoValidaException id no válida
	 * @throws NumeroUnidadesNoValidoException número de unidades no válido
	 * @throws PrecioNoValidoException precio no válido
	 * @throws ProductoYaExisteException ya existe el producto en la lista
	 */
	public boolean anadir(String id,String nombre,String descripcion,float precio,int unidades,
			MarcaMovil marcaMovil,ModeloMovil modeloMovil,SistemaOperativo sistemaOperativo,
			int camara,int memoria,String procesador) 
			throws IdNoValidaException, NumeroUnidadesNoValidoException,
			PrecioNoValidoException, ProductoYaExisteException{
		Producto producto=new Movil(id,nombre,descripcion,precio,unidades,marcaMovil,
				modeloMovil,sistemaOperativo,camara,memoria,procesador);
		return anadirProducto(producto);
	}
	
	/**
	 * Añade un producto de tipo tablet
	 * @param id del producto
	 * @param nombre del producto
	 * @param descripcion del producto
	 * @param precio del producto
	 * @param unidades del producto
	 * @param marcaTablet del producto
	 * @param modeloTablet del producto
	 * @param memoria del producto
	 * @param pantalla del producto
	 * @return true si se añade correctamente
	 * @throws IdNoValidaException id no válida
	 * @throws NumeroUnidadesNoValidoException número de unidades no válido
	 * @throws PrecioNoValidoException precio no válido
	 * @throws ProductoYaExisteException ya existe el producto en la lista
	 */
	public boolean anadir(String id,String nombre,String descripcion,float precio,int unidades,
			MarcaTablet marcaTablet,ModeloTablet modeloTablet,String procesador,int memoria,float pantalla)
			throws IdNoValidaException, NumeroUnidadesNoValidoException, 
			PrecioNoValidoException, ProductoYaExisteException{
		Producto producto=new Tablet(id,nombre,descripcion,precio,unidades,marcaTablet,
				modeloTablet,procesador,memoria,pantalla);
		return anadirProducto(producto);
	}

	/**
	 * Añade el producto a la lista siempre que no exista previamente.
	 * @param producto a añadir
	 * @return true si se añade
	 * @throws ProductoYaExisteException ya existe el producto en la lista
	 */
	private boolean anadirProducto(Producto producto) throws ProductoYaExisteException {
		if (almacen.contains(producto))
			throw new ProductoYaExisteException("El producto ya existe");
		return almacen.add(producto);
	}
	
	/**
	 * Elimina un producto a través de la id
	 * @param id del producto
	 * @return true si se elimina correctamente
	 * @throws ProductoNoExisteException el producto no existe en la lista
	 */
	public boolean eliminar(String id) throws ProductoNoExisteException{
		Producto producto = get(id);
		if (!almacen.contains(producto))
			throw new ProductoNoExisteException("El producto no existe");
		return almacen.remove(producto);
	}
	
	/**
	 * Devuelve el número de productos en el almacén
	 * @return número de producto
	 */
	int size() {
		return almacen.size();
	}
	
	/**
	 * Devuelve el producto buscando a través de la id.
	 * @param id del producto
	 * @return producto
	 * @throws ProductoNoExisteException el producto no existe en la lista
	 */
	public Producto get(String id) throws ProductoNoExisteException{
		for (Producto producto: almacen) {
			if (producto.getId().equals(id))
				return producto;
		}
		throw new ProductoNoExisteException("El producto no existe");
	}
	
	/**
	 * Devuelve el producto buscando a través del nombre
	 * @param nombre del producto
	 * @return producto
	 * @throws ProductoNoExisteException el producto no existe
	 */
	public Producto getProducto(String nombre) throws ProductoNoExisteException{
		for (Producto producto: almacen) {
			if (producto.getNombre().equals(nombre))
				return producto;
		}
		throw new ProductoNoExisteException("El producto no existe");
	}
}
