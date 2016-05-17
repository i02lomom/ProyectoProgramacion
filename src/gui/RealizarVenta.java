package gui;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JOptionPane;

import funcionalidad.Producto;
import funcionalidad.Tienda;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.ProductoNoExisteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RealizarVenta extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	private Producto producto;
	
	public RealizarVenta(Tienda tienda){
		super();
		setTitle("Realizar venta");
		setBounds(100, 100, 455, 344);
		
		enviar.setText("Venta");
		salir.setText("Salir");
		
		botonesPorDefecto();
		
		nombre.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					producto = tienda.getProducto(nombre.getText());
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
					int unidadesAVender=Integer.parseInt((String) JOptionPane.showInputDialog(
						contentPanel,
	                    "Introduzca el n�mero de unidades a vender",
	                    "Vender unidades",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,null,null));
					if(unidadesAVender<=0 || unidadesAVender>Integer.parseInt(unidades.getText()))
						JOptionPane.showMessageDialog(contentPanel,
							"El n�mero de unidades es incorrecto", "Error",
							JOptionPane.ERROR_MESSAGE);
					
					else{
						float totalAPagar=(producto.calcularPrecio())*unidadesAVender;
						producto.setUnidades(Integer.parseInt(unidades.getText()) - unidadesAVender);	
						tienda.setModificado(true);
						JOptionPane.showMessageDialog(contentPanel, "Vendidas "+unidadesAVender+ " unidades a "
						+producto.calcularPrecio()+" euros\nEl total de la compra asciende a "+totalAPagar+""
						+ "\n\n GRACIAS POR SU VISITA");
						enviar.setEnabled(false);
						clear();
					} 
				}catch (NumberFormatException e1) {
						JOptionPane.showMessageDialog(contentPanel,
								"Las unidades deben ser n�meros enteros",
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
