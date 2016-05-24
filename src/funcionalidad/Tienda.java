package funcionalidad;

import java.io.Serializable;
import java.util.ArrayList;

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
	 * @return modificado (true si está modificado y false si no)
	 */
	public boolean estaModificado() {
		return modificado;
	}

	/**
	 * Establece el valor de modificado (true o false)
	 * @param modificado (true o false)
	 */
	public void setModificado(boolean modificado) {
		this.modificado = modificado;
	}

	/**
	 * Añade el producto a la lista siempre que no exista previamente.
	 * @param producto a añadir
	 * @return true si se añade
	 * @throws ProductoYaExisteException ya existe el producto en la lista
	 */
	public boolean anadirProducto(Producto producto) throws ProductoYaExisteException {
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
		Producto producto = getProductoPorId(id);
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
	public Producto getProductoPorId(String id) throws ProductoNoExisteException{
		for (Producto producto: almacen) {
			if (producto.getId().equals(id))
				return producto;
		}
		throw new ProductoNoExisteException("El producto no existe");
	}
	
	/**
	 * Devuelve el producto buscando a través del nombre
	 * @param nombre del producto
	 * @return producto encontrado
	 * @throws ProductoNoExisteException el producto no existe
	 */
	public Producto getProductoPorNombre(String nombre) throws ProductoNoExisteException{
		for (Producto producto: almacen) {
			if (producto.getNombre().equals(nombre))
				return producto;
		}
		throw new ProductoNoExisteException("El producto no existe");
	}
}
