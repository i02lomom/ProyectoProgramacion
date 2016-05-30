package gui;

import funcionalidad.Producto;
import funcionalidad.Tienda;
import funcionalidad.excepciones.ElementoNoExisteException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase eliminar. Permite eliminar un producto de la lista.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Eliminar extends DialogoPadre {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe el ArrayList tienda
	 * @param tienda ArrayList de productos
	 */
	public Eliminar(Tienda<Producto> tienda){
		super();
		setTitle("Eliminar");
		setBounds(100, 100, 455, 344);
		
		enviar.setText("Eliminar");
		salir.setText("Salir");
		
		botonesPorDefecto();
		
		nombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					Producto producto=tienda.getProductoPorNombre(nombre.getText());
					mostrarProducto(producto);
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
				try {
					gestionarRespuesta(tienda);
				} catch (ElementoNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Pregunta al usuario si realmente desea eliminar el producto
	 * @param tienda ArrayList de productos
	 * @throws ElementoNoExisteException no existe el producto en la lista
	 */
	private void gestionarRespuesta(Tienda<Producto> tienda) throws ElementoNoExisteException{
		switch(JOptionPane.showOptionDialog(contentPanel,
				"¿Está seguro de que desea eliminarlo?", "Confirmar",
				JOptionPane.YES_NO_CANCEL_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, null, null)){

		case JOptionPane.YES_OPTION:
			tienda.eliminar(identificador.getText());
			tienda.setModificado(true);
			clear();
			botonesPorDefecto();
			break;
					
		case JOptionPane.NO_OPTION:
			break;
					
		default:
			clear();
			botonesPorDefecto();
		}
	}
}
