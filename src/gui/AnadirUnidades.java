package gui;

import funcionalidad.Producto;
import funcionalidad.Tienda;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.ProductoNoExisteException;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase AnadirUnidades. Permite añadir unidades de un producto que se busca a través del nombre.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class AnadirUnidades extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	private Producto producto;
	
	/**
	 * Constructor que recibe el ArrayList tienda
	 * @param tienda ArrayList de productos
	 */
	public AnadirUnidades(Tienda tienda){
		super();
		setTitle("Añadir unidades");
		setBounds(100, 100, 455, 344);
		
		enviar.setText("Añadir");
		salir.setText("Salir");
		
		botonesPorDefecto();
		
		nombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					producto = tienda.getProductoPorNombre(nombre.getText());
					mostrarProducto(producto);
					enviar.setEnabled(true);
				} catch (ProductoNoExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error",
							JOptionPane.ERROR_MESSAGE);
				}		
			}
		});
		
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					int unidadesAAnadir=Integer.parseInt((String) JOptionPane.showInputDialog(
						contentPanel,
	                    "Introduzca el número de unidades a añadir",
	                    "Añadir unidades",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,null,null));
					if(unidadesAAnadir<=0)
						JOptionPane.showMessageDialog(contentPanel,
							"El número de unidades debe ser mayor que cero", "Error",
							JOptionPane.ERROR_MESSAGE);
					
					else{
						producto.setUnidades(Integer.parseInt(unidades.getText()) + unidadesAAnadir);
						tienda.setModificado(true);
						JOptionPane.showMessageDialog(contentPanel, "Unidades añadidas con éxito");
						enviar.setEnabled(false);
						clear();
					} 
				}catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(contentPanel,
								"Las unidades deben ser números enteros",
								"Error", JOptionPane.ERROR_MESSAGE);
				} catch (NumeroUnidadesNoValidoException e1) {
						JOptionPane.showMessageDialog(contentPanel,
								e1.getMessage(),
								"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}	
}
