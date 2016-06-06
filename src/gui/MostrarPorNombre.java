package gui;

import funcionalidad.Producto;
import funcionalidad.Tienda;
import funcionalidad.excepciones.ElementoNoExisteException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;

/**
 * Clase MostrarPorNombre. Muestra el producto a trav�s de su nombre.
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class MostrarPorNombre extends DialogoPadre {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe el ArrayList tienda
	 * @param tienda ArrayList de productos
	 */
	public MostrarPorNombre(Tienda<Producto> tienda){
		super();
		setTitle("Buscar por Nombre");
		setBounds(100, 100, 455, 344);
		
		enviar.setVisible(false);
		salir.setText("Salir");
		
		botonesPorDefecto();
		
		nombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarProducto(tienda);
			}

			/**
			 * Busca el producto a trav�s del nombre
			 * @param tienda ArrayList de productos
			 */
			private void buscarProducto(Tienda<Producto> tienda) {
				try {
					Producto producto=tienda.getProductoPorNombre(nombre.getText());
					mostrarProducto(producto);
				} catch (ElementoNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
