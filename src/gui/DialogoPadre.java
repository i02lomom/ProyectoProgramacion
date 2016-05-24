package gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import funcionalidad.*;
import funcionalidad.enumeraciones.*;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.border.TitledBorder;
import javax.swing.JComboBox;

/**
 * Clase DialogoPadre. Este diálogo contendrá todos los botones usados en el programa. Los botones
 * estarán visibles o no en función del hijo.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
@SuppressWarnings("rawtypes")
public class DialogoPadre extends JDialog implements ChangeListener {
	private static final long serialVersionUID = 1L;
	protected JPanel contentPanel = new JPanel();
	protected JPanel panel;
	protected final ButtonGroup buttonGroup = new ButtonGroup();
	protected JTextField identificador;
	protected JTextField nombre;
	protected JTextField precio;
	protected JTextField unidades;
	protected JTextField descripcion;
	protected JTextField camaraMovilOMemoriaTablet;
	protected JTextField memoriaOPantallaTablet;
	protected JTextField procesador;
	protected JTextField procesadorTablet;
	protected JTextField fabricante;
	protected JTextField fecha;
	protected JLabel lblIdentificador;
	protected JLabel lblNombre;
	protected JLabel lblPrecio;
	protected JLabel lblUnidades;
	protected JLabel lblDescripcin;
	protected JLabel lblFecha;
	protected JLabel lblMarcaOComponente;
	protected JLabel lblModeloOFabricante;
	protected JLabel lblSOperativoOProcesador;
	protected JLabel lblCamaraMovilOMemoriaTablet;
	protected JLabel lblMemoriaMovilOPantallaTablet;
	protected JLabel lblProcesadorMovil;
	protected JPanel buttonPane;
	protected JButton enviar;
	protected JButton salir;
	protected JRadioButton rdbtnComponente;
	protected JRadioButton rdbtnMovil;
	protected JRadioButton rdbtnTablet;
	protected JComboBox comboBoxMarcaOComponente;
	protected JComboBox comboBoxModelo;
	protected JComboBox comboBoxSistemaOperativo;
	
	/**
	 * Constructor para DialogoPadre
	 */
	public DialogoPadre() {
		super();
		setResizable(false);
		setModal(true);
		getContentPane().setLayout(null);
		contentPanel.setSize(444, 268);
		contentPanel.setLayout(null);
		
		panel = new JPanel();
		panel.setBounds(16, 0, 417, 46);
		panel.setBorder(new TitledBorder(null, "Producto", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPanel.add(panel);
		panel.setLayout(null);
		
		rdbtnComponente = new JRadioButton("Componente");
		rdbtnComponente.addChangeListener(this);
		rdbtnComponente.setBounds(6, 16, 109, 23);
		panel.add(rdbtnComponente);
		buttonGroup.add(rdbtnComponente);
		
		rdbtnMovil = new JRadioButton("M\u00F3vil");
		rdbtnMovil.addChangeListener(this);
		rdbtnMovil.setBounds(157, 16, 109, 23);
		panel.add(rdbtnMovil);
		buttonGroup.add(rdbtnMovil);
		
		rdbtnTablet = new JRadioButton("Tablet");
		rdbtnTablet.addChangeListener(this);
		rdbtnTablet.setBounds(302, 16, 109, 23);
		panel.add(rdbtnTablet);
		buttonGroup.add(rdbtnTablet);
		
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		lblIdentificador = new JLabel("Identificador");
		lblIdentificador.setBounds(23, 59, 79, 14);
		contentPanel.add(lblIdentificador);
		
		identificador = new JTextField();
		identificador.setBounds(129, 56, 86, 20);
		contentPanel.add(identificador);
		identificador.setColumns(10);
		
		lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(23, 90, 79, 14);
		contentPanel.add(lblNombre);
		
		nombre = new JTextField();
		nombre.setBounds(129, 87, 86, 20);
		contentPanel.add(nombre);
		nombre.setColumns(10);
		
		lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(23, 121, 69, 14);
		contentPanel.add(lblPrecio);
		
		precio = new JTextField();
		precio.setBounds(129, 118, 86, 20);
		contentPanel.add(precio);
		precio.setColumns(10);
		
		lblUnidades = new JLabel("Unidades");
		lblUnidades.setBounds(23, 152, 69, 14);
		contentPanel.add(lblUnidades);
		
		unidades = new JTextField();
		unidades.setBounds(129, 149, 86, 20);
		contentPanel.add(unidades);
		unidades.setColumns(10);
		
		lblDescripcin = new JLabel("Descripci\u00F3n");
		lblDescripcin.setBounds(23, 183, 79, 14);
		contentPanel.add(lblDescripcin);
		
		descripcion = new JTextField();
		descripcion.setBounds(129, 180, 86, 20);
		contentPanel.add(descripcion);
		descripcion.setColumns(10);
		
		lblMarcaOComponente = new JLabel("Marca M\u00F3vil");
		lblMarcaOComponente.setVisible(false);
		lblMarcaOComponente.setBounds(245, 59, 79, 14);
		contentPanel.add(lblMarcaOComponente);
		
		comboBoxMarcaOComponente = new JComboBox<Object>();
		comboBoxMarcaOComponente.setVisible(false);
		comboBoxMarcaOComponente.setBounds(328, 56, 86, 20);
		contentPanel.add(comboBoxMarcaOComponente);
		
		lblModeloOFabricante = new JLabel("Modelo M\u00F3vil");
		lblModeloOFabricante.setVisible(false);
		lblModeloOFabricante.setBounds(245, 90, 79, 14);
		contentPanel.add(lblModeloOFabricante);
		
		comboBoxModelo = new JComboBox<ModeloMovil>();
		comboBoxModelo.setVisible(false);
		comboBoxModelo.setBounds(328, 87, 86, 20);
		contentPanel.add(comboBoxModelo);
		
		lblSOperativoOProcesador = new JLabel("S. Operativo");
		lblSOperativoOProcesador.setVisible(false);
		lblSOperativoOProcesador.setBounds(245, 121, 79, 14);
		contentPanel.add(lblSOperativoOProcesador);
		
		comboBoxSistemaOperativo = new JComboBox<SistemaOperativo>();
		comboBoxSistemaOperativo.setVisible(false);
		comboBoxSistemaOperativo.setBounds(328, 118, 86, 20);
		contentPanel.add(comboBoxSistemaOperativo);
		
		lblCamaraMovilOMemoriaTablet = new JLabel("C\u00E1mara");
		lblCamaraMovilOMemoriaTablet.setVisible(false);
		lblCamaraMovilOMemoriaTablet.setBounds(245, 152, 79, 14);
		contentPanel.add(lblCamaraMovilOMemoriaTablet);
		
		camaraMovilOMemoriaTablet = new JTextField();
		camaraMovilOMemoriaTablet.setVisible(false);
		camaraMovilOMemoriaTablet.setBounds(328, 149, 86, 20);
		contentPanel.add(camaraMovilOMemoriaTablet);
		camaraMovilOMemoriaTablet.setColumns(10);
		
		lblMemoriaMovilOPantallaTablet = new JLabel("Memoria");
		lblMemoriaMovilOPantallaTablet.setVisible(false);
		lblMemoriaMovilOPantallaTablet.setBounds(245, 183, 79, 14);
		contentPanel.add(lblMemoriaMovilOPantallaTablet);
		
		memoriaOPantallaTablet = new JTextField();
		memoriaOPantallaTablet.setVisible(false);
		memoriaOPantallaTablet.setBounds(328, 180, 86, 20);
		contentPanel.add(memoriaOPantallaTablet);
		memoriaOPantallaTablet.setColumns(10);
		
		lblProcesadorMovil = new JLabel("Procesador");
		lblProcesadorMovil.setVisible(false);
		lblProcesadorMovil.setBounds(245, 214, 79, 14);
		contentPanel.add(lblProcesadorMovil);
		
		procesador = new JTextField();
		procesador.setVisible(false);
		procesador.setBounds(328, 211, 86, 20);
		contentPanel.add(procesador);
		procesador.setColumns(10);
		
		procesadorTablet = new JTextField();
		procesadorTablet.setVisible(false);
		procesadorTablet.setBounds(328, 118, 86, 20);
		contentPanel.add(procesadorTablet);
		procesadorTablet.setColumns(10);
		
		fabricante = new JTextField();
		fabricante.setVisible(false);
		fabricante.setBounds(328, 87, 86, 20);
		contentPanel.add(fabricante);
		fabricante.setColumns(10);
		
		lblFecha = new JLabel("Fecha");
		lblFecha.setBounds(23, 212, 79, 14);
		contentPanel.add(lblFecha);
		
		fecha = new JTextField();
		fecha.setBounds(129, 211, 86, 20);
		contentPanel.add(fecha);
		fecha.setColumns(10);
		{
			buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				enviar = new JButton("Enviar");
				enviar.setActionCommand("Enviar");
				buttonPane.add(enviar);
				getRootPane().setDefaultButton(enviar);
			}
			{
				salir = new JButton("Salir");
				salir.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						dispose();
					}
				});
				salir.setActionCommand("Salir");
				buttonPane.add(salir);
			}
		}	
	}
	
	@Override
	public void stateChanged(ChangeEvent e) {
		if(rdbtnComponente.isSelected())
			activarBotonesComponente();
		if(rdbtnMovil.isSelected())
			activarBotonesMovil();
		if(rdbtnTablet.isSelected())
			activarBotonesTablet();
	}
	
	/**
	 * Activa los botones necesarios para añadir un componente y desactiva los demás
	 */
	@SuppressWarnings("unchecked")
	private void activarBotonesComponente(){
		lblMarcaOComponente.setVisible(true);
		lblMarcaOComponente.setText("Componente");
		lblModeloOFabricante.setVisible(true);
		lblModeloOFabricante.setText("Fabricante");
		fabricante.setVisible(true);
		camaraMovilOMemoriaTablet.setVisible(false);
		memoriaOPantallaTablet.setVisible(false);
		comboBoxMarcaOComponente.setModel(new DefaultComboBoxModel<TipoComponente>(TipoComponente.values()));
		comboBoxMarcaOComponente.setVisible(true);
		comboBoxModelo.setVisible(false);
		lblSOperativoOProcesador.setVisible(false);
		comboBoxSistemaOperativo.setVisible(false);
		lblCamaraMovilOMemoriaTablet.setVisible(false);
		camaraMovilOMemoriaTablet.setVisible(false);
		lblMemoriaMovilOPantallaTablet.setVisible(false);
		memoriaOPantallaTablet.setVisible(false);
		lblProcesadorMovil.setVisible(false);
		procesador.setVisible(false);
		procesadorTablet.setVisible(false);
	}
	
	/**
	 * Activa los botones necesarios para añadir un móvil y desactiva los demás
	 */
	@SuppressWarnings("unchecked")
	private void activarBotonesMovil(){
		lblMarcaOComponente.setVisible(true);
		lblMarcaOComponente.setText("Marca Móvil");
		lblModeloOFabricante.setVisible(true);
		lblModeloOFabricante.setText("Modelo Móvil");
		comboBoxMarcaOComponente.setModel(new DefaultComboBoxModel<MarcaMovil>(MarcaMovil.values()));
		comboBoxMarcaOComponente.setVisible(true);
		comboBoxModelo.setModel(new DefaultComboBoxModel<ModeloMovil>(ModeloMovil.values()));
		comboBoxModelo.setVisible(true);
		lblSOperativoOProcesador.setVisible(true);
		lblSOperativoOProcesador.setText("S. Operativo");
		comboBoxSistemaOperativo.setModel(new DefaultComboBoxModel<SistemaOperativo>(SistemaOperativo.values()));
		comboBoxSistemaOperativo.setVisible(true);
		procesadorTablet.setVisible(false);
		lblCamaraMovilOMemoriaTablet.setVisible(true);
		lblCamaraMovilOMemoriaTablet.setText("Cámara");
		camaraMovilOMemoriaTablet.setVisible(true);
		lblMemoriaMovilOPantallaTablet.setVisible(true);
		lblMemoriaMovilOPantallaTablet.setText("Memoria");
		memoriaOPantallaTablet.setVisible(true);
		lblProcesadorMovil.setVisible(true);
		procesador.setVisible(true);
	}
	
	/**
	 * Activa los botones necesarios para añadir una tablet y desactiva los demás
	 */
	@SuppressWarnings("unchecked")
	private void activarBotonesTablet(){
		lblMarcaOComponente.setVisible(true);
		lblMarcaOComponente.setText("Marca Tablet");
		lblModeloOFabricante.setVisible(true);
		lblModeloOFabricante.setText("Modelo Tablet");
		comboBoxMarcaOComponente.setModel(new DefaultComboBoxModel<MarcaTablet>(MarcaTablet.values()));
		comboBoxMarcaOComponente.setVisible(true);
		comboBoxModelo.setModel(new DefaultComboBoxModel<ModeloTablet>(ModeloTablet.values()));
		comboBoxModelo.setVisible(true);
		lblSOperativoOProcesador.setVisible(true);
		lblSOperativoOProcesador.setText("Procesador");
		comboBoxSistemaOperativo.setVisible(false);
		procesadorTablet.setVisible(true);
		lblCamaraMovilOMemoriaTablet.setVisible(true);
		lblCamaraMovilOMemoriaTablet.setText("Memoria");
		camaraMovilOMemoriaTablet.setVisible(true);
		lblMemoriaMovilOPantallaTablet.setVisible(true);
		lblMemoriaMovilOPantallaTablet.setText("Pantalla");
		memoriaOPantallaTablet.setVisible(true);
		lblProcesadorMovil.setVisible(false);
		procesador.setVisible(false);
	}
	
	/**
	 * Limpia los textos y opciones seleccionadas anteriormente.
	 */
	protected void clear(){
		rdbtnComponente.setSelected(false);
		rdbtnMovil.setSelected(false);
		rdbtnTablet.setSelected(false);
		identificador.setText("");
		nombre.setText("");
		precio.setText("");
		unidades.setText("");
		descripcion.setText("");
		comboBoxMarcaOComponente.setSelectedItem(null);
		comboBoxModelo.setSelectedItem(null);
		comboBoxSistemaOperativo.setSelectedItem(null);
		camaraMovilOMemoriaTablet.setText("");
		memoriaOPantallaTablet.setText("");
		fabricante.setText("");
		procesador.setText("");
		procesadorTablet.setText("");
	}
	
	/**
	 * Muestra el producto pasado como argumento
	 * @param producto a mostrar
	 */
	@SuppressWarnings("unchecked")
	protected void mostrarProducto(Producto producto){
		if(producto instanceof Componente){
			Componente componente= (Componente)producto;
			rdbtnComponente.setSelected(true);
			identificador.setText(componente.getId());
			nombre.setText(componente.getNombre());
			precio.setText(String.valueOf(componente.getPrecio()));
			unidades.setText(String.valueOf(componente.getUnidades()));
			descripcion.setText(componente.getDescripcion());
			fecha.setText(componente.getFechaRecepcion().toString());
			comboBoxMarcaOComponente.addItem(componente.getTipoComponente());
			comboBoxMarcaOComponente.setSelectedItem(componente.getTipoComponente());
			fabricante.setText(componente.getFabricante());
		}
		else if(producto instanceof Movil){
			Movil movil=(Movil)producto;
			rdbtnMovil.setSelected(true);
			identificador.setText(movil.getId());
			nombre.setText(movil.getNombre());
			precio.setText(String.valueOf(movil.getPrecio()));
			unidades.setText(String.valueOf(movil.getUnidades()));
			descripcion.setText(movil.getDescripcion());
			fecha.setText(movil.getFechaRecepcion().toString());
			comboBoxMarcaOComponente.addItem(movil.getMarcaMovil());
			comboBoxMarcaOComponente.setSelectedItem(movil.getMarcaMovil());
			comboBoxModelo.addItem(movil.getModeloMovil());
			comboBoxModelo.setSelectedItem(movil.getModeloMovil());
			comboBoxSistemaOperativo.addItem(movil.getSistemaOperativo());
			comboBoxSistemaOperativo.setSelectedItem(movil.getSistemaOperativo());
			camaraMovilOMemoriaTablet.setText(String.valueOf(movil.getCamara()));
			memoriaOPantallaTablet.setText(String.valueOf(movil.getMemoria()));
			procesador.setText(movil.getProcesador());
		}
		else{
			Tablet tablet=(Tablet)producto;
			rdbtnTablet.setSelected(true);
			identificador.setText(tablet.getId());
			nombre.setText(tablet.getNombre());
			precio.setText(String.valueOf(tablet.getPrecio()));
			unidades.setText(String.valueOf(tablet.getUnidades()));
			descripcion.setText(tablet.getDescripcion());
			fecha.setText(tablet.getFechaRecepcion().toString());
			comboBoxMarcaOComponente.addItem(tablet.getMarcaTablet());
			comboBoxMarcaOComponente.setSelectedItem(tablet.getMarcaTablet());
			comboBoxModelo.addItem(tablet.getModeloTablet());
			comboBoxModelo.setSelectedItem(tablet.getModeloTablet());
			procesadorTablet.setText(tablet.getProcesador());
			camaraMovilOMemoriaTablet.setText(String.valueOf(tablet.getMemoria()));
			memoriaOPantallaTablet.setText(String.valueOf(tablet.getPantalla()));
		}
	}
	
	/**
	 * Habilita y deshabilita botones dejándolos como deben estar inicialmente en esta ventana
	 */
	protected void botonesPorDefecto(){
		enviar.setEnabled(false);
		rdbtnComponente.setEnabled(false);
		rdbtnMovil.setEnabled(false);
		rdbtnTablet.setEnabled(false);
		identificador.setEnabled(false);
		precio.setEnabled(false);
		unidades.setEnabled(false);
		descripcion.setEnabled(false);
		fecha.setEnabled(false);
		comboBoxMarcaOComponente.setEnabled(false);
		comboBoxModelo.setEnabled(false);
		comboBoxSistemaOperativo.setEnabled(false);
		camaraMovilOMemoriaTablet.setEnabled(false);
		memoriaOPantallaTablet.setEnabled(false);
		procesador.setEnabled(false);
		procesadorTablet.setEnabled(false);
		fabricante.setEnabled(false);
	}
}
