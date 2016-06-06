package gui;

import funcionalidad.Producto;
import funcionalidad.Tienda;
import funcionalidad.excepciones.ElementoNoExisteException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;

/**
 * Clase MostrarPorId. Muestra el producto a través de su Id.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class MostrarPorId extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	
	/**
	 * Constructor que recibe el ArrayList tienda
	 * @param tienda ArrayList de productos
	 */
	public MostrarPorId(Tienda<Producto> tienda){
		super();
		setTitle("Buscar por Id");
		setBounds(100, 100, 455, 344);
		
		enviar.setVisible(false);
		salir.setText("Salir");
		
		botonesPorDefecto();
		identificador.setEnabled(true);
		nombre.setEnabled(false);
		
		identificador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				buscarProducto(tienda);
			}

			/**
			 * Busca el producto a través del identificador
			 * @param tienda ArrayList de productos
			 */
			private void buscarProducto(Tienda<Producto> tienda) {
				try {
					Producto producto=tienda.getProductoPorId(identificador.getText().toUpperCase().trim());
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
