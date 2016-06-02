package funcionalidad;

import java.io.Serializable;
import java.util.ArrayList;

import funcionalidad.excepciones.ElementoNoExisteException;
import funcionalidad.excepciones.ElementoYaExisteException;


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
public class Tienda<E> implements Serializable{
	private static final long serialVersionUID = 1L;

	/**
	 * Lista de productos.
	 */
	private ArrayList<E> almacen=new ArrayList<E>();
	
	/**
	 * Atributo que indica si se ha modificado la lista
	 */
	public boolean modificado=false;
	
	/**
	 * Devuelve la lista de productos
	 * @return almacen lista de productos
	 */
	public ArrayList<E> getAlmacen(){
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
	 * @param elemento a añadir
	 * @return true si se añade
	 * @throws ElementoYaExisteException ya existe el producto en la lista
	 */
	public boolean anadirProducto(E elemento) throws ElementoYaExisteException {
		if (almacen.contains(elemento))
			throw new ElementoYaExisteException("El producto ya existe");
		return almacen.add(elemento);
	}
	
	/**
	 * Elimina un producto a través de la id
	 * @param id del producto
	 * @return true si se elimina correctamente
	 * @throws ElementoNoExisteException el producto no existe en la lista
	 */
	public boolean eliminar(String id) throws ElementoNoExisteException{
		E elemento = getProductoPorId(id);
		if (!almacen.contains(elemento))
			throw new ElementoNoExisteException("El elemento no existe");
		return almacen.remove(elemento);
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
	 * @throws ElementoNoExisteException el producto no existe en la lista
	 */
	public E getProductoPorId(String id) throws ElementoNoExisteException{
		for (E elemento: almacen) {
			if (((Producto) elemento).getId().equals(id))
				return elemento;
		}
		throw new ElementoNoExisteException("El elemento no existe");
	}
	
	/**
	 * Devuelve el producto buscando a través del nombre
	 * @param nombre del producto
	 * @return producto encontrado
	 * @throws ElementoNoExisteException el producto no existe
	 */
	public E getProductoPorNombre(String nombre) throws ElementoNoExisteException{
		for (E elemento: almacen) {
			if (((Producto) elemento).getNombre().equals(nombre))
				return elemento;
		}
		throw new ElementoNoExisteException("El elemento no existe");
	}
}
