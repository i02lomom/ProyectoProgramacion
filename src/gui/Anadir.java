package gui;

import funcionalidad.Tienda;
import funcionalidad.enumeraciones.*;
import funcionalidad.excepciones.*;

import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

/**
 * Clase añadir. Permite añadir un producto a la lista.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Anadir extends DialogoPadre {
	private static final long serialVersionUID = 1L;

	/**
	 * Constructor que recibe el ArrayList tienda
	 * @param tienda ArrayList de productos
	 */
	public Anadir(Tienda tienda){
		super();
		setTitle("Añadir");
		setBounds(100, 100, 455, 344);
		
		enviar.setText("Añadir");
		salir.setText("Salir");
		
		identificador.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				try {
					if(tienda.getAlmacen().contains(tienda.get(identificador.getText().toUpperCase()))){
						identificador.setText("");
						JOptionPane.showMessageDialog(contentPanel,
								"Ya existe esa Id en la lista\n"
								+ "Seleccione otra Id", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} catch (ProductoNoExisteException e1) {
				}
			}
		});
		
		enviar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					if(getTipo()==TipoItem.COMPONENTE){
						tienda.anadir(identificador.getText(),
						nombre.getText(),
						descripcion.getText(),
						Float.parseFloat(precio.getText()),
						Integer.parseInt(unidades.getText()),
						(TipoComponente) comboBoxMarcaOComponente.getSelectedItem(),
						fabricante.getText());
						tienda.setModificado(true);
						JOptionPane.showMessageDialog(contentPanel, "Componente añadido con éxito");
						clear();
					}
					else if(getTipo()==TipoItem.MOVIL){
						tienda.anadir(identificador.getText(),
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
						tienda.setModificado(true);
						JOptionPane.showMessageDialog(contentPanel, "Móvil añadido con éxito");
						clear();
					}
					else if(getTipo()==TipoItem.TABLET){
						tienda.anadir(identificador.getText(),
						nombre.getText(),
						descripcion.getText(),
						Float.parseFloat(precio.getText()),
						Integer.parseInt(unidades.getText()),
						(MarcaTablet)comboBoxMarcaOComponente.getSelectedItem(),
						(ModeloTablet)comboBoxModelo.getSelectedItem(),
						procesadorTablet.getText(),
						Integer.parseInt(camaraMovilOMemoriaTablet.getText()),
						Integer.parseInt(memoriaOPantallaTablet.getText()));
						tienda.setModificado(true);
						JOptionPane.showMessageDialog(contentPanel, "Tablet añadida con éxito");
						clear();
					}
					else{
						JOptionPane.showMessageDialog(contentPanel,
							"Debe seleccionar un producto.", "Error",
							JOptionPane.ERROR_MESSAGE);
					}

				} catch (IdNoValidaException | NumeroUnidadesNoValidoException
						| PrecioNoValidoException | ProductoYaExisteException e1) {
					JOptionPane.showMessageDialog(contentPanel,
							e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);	
				} catch(NumberFormatException e2) {
					JOptionPane.showMessageDialog(contentPanel,
							"Unidades, cámara o memoria deben de ser enteros\n"
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
