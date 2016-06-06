package gui;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.GregorianCalendar;

import javax.swing.JOptionPane;

import fecha.Fecha;
import funcionalidad.Producto;
import funcionalidad.Tienda;
import funcionalidad.excepciones.NumeroUnidadesNoValidoException;
import funcionalidad.excepciones.ElementoNoExisteException;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * Clase RealizarVenta. Nos permitir� realizar la venta de una serie de unidades de un producto.
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class RealizarVenta extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	private Producto producto;
	
	/**
	 * Constructor
	 * @param tienda ArrayList de productos
	 */
	public RealizarVenta(Tienda<Producto> tienda){
		super();
		setTitle("Realizar venta");
		setBounds(100, 100, 455, 344);
		
		enviar.setText("Venta");
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
			 * Busca el producto a trav�s del identificador
			 * @param tienda ArrayList de productos
			 */
			private void buscarProducto(Tienda<Producto> tienda) {
				try {
					producto = tienda.getProductoPorId(identificador.getText().toUpperCase().trim());
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
				realizarVenta(tienda);
			}

			/**
			 * Realiza la venta de un producto siempre que el n�mero de unidades sea correcto
			 * @param tienda ArrayList de productos
			 */
			private void realizarVenta(Tienda<Producto> tienda) {
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
						Fecha fecha=new Fecha();
						JOptionPane.showMessageDialog(contentPanel, "Vendidas "+unidadesAVender+ " unidades a "
								+producto.calcularPrecio()+" euros\nEl total de la compra asciende a "+totalAPagar+"\n"
								+"Fecha: "+fecha.getDiaDeLaSemana()+" "
								+fecha.getFecha().get(GregorianCalendar.DAY_OF_MONTH)+" "
								+"de "+fecha.getMes()+" de "+fecha.getFecha().get(GregorianCalendar.YEAR)
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
