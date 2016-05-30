package gui;

import funcionalidad.Componente;
import funcionalidad.Movil;
import funcionalidad.Producto;
import funcionalidad.Tablet;
import funcionalidad.Tienda;
import funcionalidad.enumeraciones.*;
import funcionalidad.excepciones.*;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Clase a�adir. Permite a�adir un producto a la lista.
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public class Anadir extends DialogoPadre {
	private static final long serialVersionUID = 1L;
	Producto producto;
	/**
	 * Constructor que recibe el ArrayList tienda
	 * @param tienda ArrayList de productos
	 */
	public Anadir(Tienda<Producto> tienda){
		super();
		setTitle("A�adir");
		setBounds(100, 100, 455, 344);
		
		enviar.setText("A�adir");
		salir.setText("Salir");
		lblFecha.setVisible(false);
		fecha.setVisible(false);
		
		identificador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(tienda.getAlmacen().contains(tienda.getProductoPorId(identificador.getText().toUpperCase()))){
						identificador.setText("");
						JOptionPane.showMessageDialog(contentPanel,
								"Ya existe esa Id en la lista\n"
								+ "Seleccione otra Id", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (ElementoNoExisteException e1) {
				}
			}
		});
		
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(getTipo()==TipoItem.COMPONENTE){
						producto=new Componente(identificador.getText(),
								nombre.getText(),
								descripcion.getText(),
								Float.parseFloat(precio.getText()),
								Integer.parseInt(unidades.getText()),
								(TipoComponente) comboBoxMarcaOComponente.getSelectedItem(),
								fabricante.getText());
						JOptionPane.showMessageDialog(contentPanel, "Componente a�adido con �xito");
					}
					else if(getTipo()==TipoItem.MOVIL){
						producto=new Movil(identificador.getText(),
								nombre.getText(),
								descripcion.getText(),
								Float.parseFloat(precio.getText()),
								Integer.parseInt(unidades.getText()),
								(MarcaMovil)comboBoxMarcaOComponente.getSelectedItem(),
								(ModeloMovil)comboBoxModelo.getSelectedItem(),
								(SistemaOperativo)comboBoxSistemaOperativo.getSelectedItem(),
								Integer.parseInt(camaraMovilOMemoriaTablet.getText()),
								Integer.parseInt(memoriaOPantallaTablet.getText()),
								procesador.getText());
						JOptionPane.showMessageDialog(contentPanel, "M�vil a�adido con �xito");
					}
					else if(getTipo()==TipoItem.TABLET){
						producto=new Tablet(identificador.getText(),
								nombre.getText(),
								descripcion.getText(),
								Float.parseFloat(precio.getText()),
								Integer.parseInt(unidades.getText()),
								(MarcaTablet)comboBoxMarcaOComponente.getSelectedItem(),
								(ModeloTablet)comboBoxModelo.getSelectedItem(),
								procesadorTablet.getText(),
								Integer.parseInt(camaraMovilOMemoriaTablet.getText()),
								Integer.parseInt(memoriaOPantallaTablet.getText()));
						JOptionPane.showMessageDialog(contentPanel, "Tablet a�adida con �xito");
					}
					else{
						JOptionPane.showMessageDialog(contentPanel,
							"Debe seleccionar un producto.", "Error",
							JOptionPane.ERROR_MESSAGE);
						return;
					}
					tienda.anadirProducto(producto);
					tienda.setModificado(true);
					identificador.setForeground(Color.BLACK);
					clear();
				} catch (IdNoValidaException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
					identificador.setForeground(Color.RED);
				} catch (NumeroUnidadesNoValidoException
						| PrecioNoValidoException | ElementoYaExisteException |
						NombreNoValidoException | DescripcionNoValidaException |
						TipoDeComponenteNoValidoException | MarcaMovilNoValidaException | 
						ModeloMovilNoValidoException | SistemaOperativoNoValidoException | 
						MarcaTabletNoValidaException | ModeloTabletNoValidoException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);	
				} catch(NumberFormatException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							"Unidades, c�mara o memoria deben de ser enteros\n"
							+ "Precio y pantalla deben de ser decimales",
							"Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
	}
	
	/**
	 * Devuelve el tipo de producto seleccionado
	 * @return tipo de producto seleccionado
	 */
	private TipoItem getTipo() {
		if (rdbtnComponente.isSelected())
			return TipoItem.COMPONENTE;
		else if (rdbtnMovil.isSelected())
			return TipoItem.MOVIL;
		else if (rdbtnTablet.isSelected())
			return TipoItem.TABLET;
		else
			return null;
	}
}
