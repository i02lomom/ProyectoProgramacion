package gui;

import funcionalidad.Producto;
import funcionalidad.Tienda;
import funcionalidad.excepciones.DescripcionNoValidaException;
import funcionalidad.excepciones.PrecioNoValidoException;
import funcionalidad.excepciones.ElementoNoExisteException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase Modificar. Permite modificar un producto. Solo se podrá modificar:
 * <ul>
 * <li>Precio</li>
 * <li>Descripción</li>
 * </ul>
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Modificar extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	private Producto producto;
	
	/**
	 * Constructor que recibe el ArrayList tienda
	 * @param tienda ArrayList de productos
	 */
	public Modificar(Tienda<Producto> tienda){
		super();
		setTitle("Modificar");
		setBounds(100, 100, 455, 344);
		
		enviar.setText("Modificar");
		salir.setText("Salir");
		
		botonesPorDefecto();
		
		nombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					producto = tienda.getProductoPorNombre(nombre.getText());
					mostrarProducto(producto);
					
					precio.setEnabled(true);
					descripcion.setEnabled(true);
					enviar.setEnabled(true);
				} catch (ElementoNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gestionarRespuesta(tienda);
			}
		});
	}
	
	/**
	 * Pregunta al usuario si realmente desea modificar el producto
	 * @param tienda ArrayList de productos
	 */
	private void gestionarRespuesta(Tienda<Producto> tienda){
		switch(JOptionPane.showOptionDialog(contentPanel,
				"¿Está seguro de que desea modificarlo?", "Confirmar",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null)){

		case JOptionPane.YES_OPTION:
			try {
				producto.setPrecio(Float.parseFloat(precio.getText()));
				producto.setDescripcion(descripcion.getText());
				tienda.getAlmacen().set(tienda.getAlmacen().indexOf(producto), producto);
				tienda.setModificado(true);
				JOptionPane.showMessageDialog(contentPanel, "Producto modificado con éxito");
				clear();
			} catch (NumberFormatException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						"Las unidades deben ser números enteros",
						"Error", JOptionPane.ERROR_MESSAGE);
			} catch (PrecioNoValidoException | DescripcionNoValidaException e1) {
				JOptionPane.showMessageDialog(contentPanel,
						e1.getMessage(),
						"Error", JOptionPane.ERROR_MESSAGE);
			}
			break;
		case JOptionPane.NO_OPTION:
			break;
		
		default:
			clear();
			botonesPorDefecto();
		}
		
		precio.setEnabled(false);
		descripcion.setEnabled(false);
	}
}
