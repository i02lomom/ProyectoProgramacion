package gui;

import funcionalidad.Producto;
import funcionalidad.Tienda;
import funcionalidad.excepciones.ProductoNoExisteException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;

/**
 * Clase MostrarPorNombre. Muestra el producto a través de su nombre.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class MostrarPorNombre extends DialogoPadre {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe el ArrayList tienda
	 * @param tienda ArrayList de productos
	 */
	public MostrarPorNombre(Tienda tienda){
		super();
		setTitle("Buscar por Id");
		setBounds(100, 100, 455, 344);
		
		enviar.setVisible(false);
		salir.setText("Salir");
		
		botonesPorDefecto();
		
		nombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Producto producto=tienda.getProducto(nombre.getText());
					mostrarProducto(producto);
				} catch (ProductoNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
}
