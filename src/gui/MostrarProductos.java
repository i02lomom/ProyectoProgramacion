package gui;

import funcionalidad.Producto;
import funcionalidad.Tienda;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.ListIterator;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

/**
 * Clase MostrarProductos. Muestra todos los productos de la tienda.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class MostrarProductos<E extends Producto>extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	
	private JButton btnAnterior;
	private JButton btnSiguiente;
	private Producto productoAMostrar;
	
	/**
	 * Constructor que recibe el ArrayList tienda
	 * @param tienda ArrayList de productos
	 */
	public MostrarProductos(Tienda<E> tienda){
		super();
		ListIterator<E> listIterator=tienda.getAlmacen().listIterator();
		setTitle("Mostrar Productos");
		setBounds(100, 100, 455, 390);
		buttonPane.setVisible(false);
		
		botonesPorDefecto();
		nombre.setEnabled(false);
		
		btnAnterior = new JButton("");
		btnAnterior.setIcon(new ImageIcon(MostrarProductos.class.getResource("/imagenes/anterior.png")));
		btnAnterior.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!productoAMostrar.equals(listIterator.previous()))	
					listIterator.next();			
				mostrarAnterior(listIterator);					
			}
		});
		btnAnterior.setBounds(43, 250, 68, 57);
		contentPanel.add(btnAnterior);
		
		btnSiguiente = new JButton("");
		btnSiguiente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!productoAMostrar.equals(listIterator.next()))
					listIterator.previous();
				mostrarSiguiente(listIterator);		
			}
		});
		btnSiguiente.setIcon(new ImageIcon(MostrarProductos.class.getResource("/imagenes/siguiente.png")));
		btnSiguiente.setBounds(129, 250, 68, 57);
		contentPanel.add(btnSiguiente);
		
		mostrarSiguiente(listIterator);
		
		btnAnterior.setEnabled(false);
	}
	
	/**
	 * Muestra el anterior producto de la tienda
	 * @param listIterator iterador del ArrayList
	 */
	private void mostrarAnterior(ListIterator<E> listIterator){		
		productoAMostrar=listIterator.previous();
		mostrarProducto(productoAMostrar);
		comprobarBotones(listIterator);	
	}
	
	/**
	 * Muestra el siguiente producto de la tienda
	 * @param listIterator iterador del ArrayList
	 */
	private void mostrarSiguiente(ListIterator<E> listIterator){
		productoAMostrar=listIterator.next();
		mostrarProducto(productoAMostrar);
		comprobarBotones(listIterator);		
	}
	
	/**
	 * Comprueba si es el primer o el último producto y habilita o deshabilta los botones anterior y
	 * siguiente en función de esto.
	 * @param listIterator iterador del ArrayList
	 */
	private void comprobarBotones(ListIterator<E> listIterator){
		if(!listIterator.hasNext()){
			btnSiguiente.setEnabled(false);
			listIterator.previous();
		}
		else
			btnSiguiente.setEnabled(true);
		
		if(!listIterator.hasPrevious()){
			btnAnterior.setEnabled(false);
			listIterator.next();
		}
		else
			btnAnterior.setEnabled(true);
	}
}
