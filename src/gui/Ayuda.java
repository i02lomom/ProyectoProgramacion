package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

/**
 * Clase Ayuda. Muestra la ayuda al usuario
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Ayuda extends JDialog {
	private static final long serialVersionUID = 1L;

	private final JPanel contentPanel = new JPanel();
	private static Ayuda ayuda = null;
	
	/**
	 * Constructor
	 */
	private Ayuda() {
		setTitle("Ver ayuda");
		setResizable(false);
		setBounds(100, 100, 592, 427);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				ayuda = null;
				dispose();
			}
		});
		
		final JTextPane textPane = new JTextPane();
		textPane.setBackground(new Color(220, 220, 220));
		textPane.setEditable(false);
		textPane.setBounds(246, 11, 330, 340);
		textPane.setContentType("text/html");
		
		JLabel lblFicheros = new JLabel();
		lblFicheros.setBounds(10, 11, 180, 35);
		lblFicheros.setText("<html><body><h2>Ficheros</h2></body></html>");
		
		JLabel lblNuevo = new JLabel();
		lblNuevo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				textPane.setText("<html><body><h2>Crear nueva tienda:</h2><p>Para crear una nueva"
						+ " tienda vaya a <b>Archivo --> Nuevo</b> o pulse <b>Ctrl+N</b>.</body></html>");
			}
		});
		lblNuevo.setBounds(10, 41, 180, 35);
		lblNuevo.setText("<html><body><ul><li>Nuevo</ul></body></html>");
		
		JLabel lblAbrir = new JLabel();
		lblAbrir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("<html><body><h2>Abrir tienda:</h2><p>Para abrir una tienda existente "
						+ "vaya a <b>Archivo --> Abrir</b> o pulse <b>Ctrl+A</b>.</body></html>");
			}
		});
		lblAbrir.setBounds(10, 61, 180, 35);
		lblAbrir.setText("<html><body><ul><li>Abrir</ul></body></html>");
		
		JLabel lblGuardar = new JLabel();
		lblGuardar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("<html><body><h2>Guardar/Guardar como... tienda:</h2><p>Para guardar "
						+ "una tienda se puede hacer de varias maneras.<ul><li>La forma predeterminada "
						+ "es seleccionando <b>Archivo --> Guardar</b> o pulsando <b>Ctrl+G</b>. "
						+ "Si se trata de una tienda existente se sobrescribirá con el contenido actual."
						+ "</li><li>Si la tienda todavía no tiene nombre (por ejemplo, si ha creado una nueva"
						+ " tienda) o ha seleccionado <b>Archivo --> Guardar como...</b>, aparecerá el diálogo"
						+ " de guardar pidiéndole el nombre de la tienda.</ul></body></html>");
			}
		});
		lblGuardar.setBounds(10, 81, 226, 35);
		lblGuardar.setText("<html><body><ul><li>Guardar/Guardar como...</ul></body></html>");
		
		JLabel lblProductos = new JLabel();
		lblProductos.setBounds(10, 110, 180, 35);
		lblProductos.setText("<html><body><h2>Productos</h2></body></html>");
		
		JLabel lblAnnadir = new JLabel();
		lblAnnadir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("<html><body><h2>Añadir nuevo producto:</h2><p>Para añadir nuevos"
						+ " productos se debe de cumplir una serie de requisitos:<ol><li>El identificador"
						+ " debe estar formado un grupo de dos caracteres y cuatro dígitos .<ul><li>CO, si"
						+ " el producto es un componente.<li>MO, si el producto es un móvil.<li>TA, si el "
						+ "producto es una tablet.</ul></li><li>El precio debe ser mayor que cero</li><li>"
						+ "Las unidades deben ser mayor que cero.</li></ol></body></html>");
			}
		});
		lblAnnadir.setBounds(10, 140, 180, 35);
		lblAnnadir.setText("<html><body><ul><li>Añadir producto</ul></body></html>");
		
		JLabel lblEliminar = new JLabel();
		lblEliminar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("<html><body><h2>Eliminar producto:</h2><p>Los productos se eliminaran "
						+ "introduciendo el nombre de dicho producto y haciendo clic en \"Eliminar\".</body></html>");
			}
		});
		lblEliminar.setBounds(10, 160, 180, 35);
		lblEliminar.setText("<html><body><ul><li>Eliminar producto</ul></body></html>");
		
		JLabel lblBuscar = new JLabel();
		lblBuscar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("<html><body><h2>Búsqueda de productos:</h2><p>La búsqueda de productos "
						+ "se podrá realizar a través de dos opciones:<ol><li><b>Buscar por id</b>, se "
						+ "introducirá la id del producto a buscar.</li><li><b>Buscar por nombre</b>, se "
						+ "introducirá el nombre del producto a buscar.</li></ol></body></html>");
			}
		});
		lblBuscar.setBounds(10, 180, 226, 35);
		lblBuscar.setText("<html><body><ul><li>Buscar por id/por nombre...</ul></body></html>");
		
		JLabel lblMostrar = new JLabel();
		lblMostrar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("<html><body><h2>Mostrar productos:</h2><p>Se mostrarán todos los productos "
						+ "de la tienda.</body></html>");
			}
		});
		lblMostrar.setBounds(10, 200, 180, 35);
		lblMostrar.setText("<html><body><ul><li>Mostrar productos</ul></body></html>");
		
		JLabel lblModificar = new JLabel();
		lblModificar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("<html><body><h2>Modificar productos:</h2><p>Se podrá modificar"
						+ " solo el precio y la descrición.</body></html>");
			}
		});
		lblModificar.setBounds(10, 220, 180, 35);
		lblModificar.setText("<html><body><ul><li>Modificar productos</ul></body></html>");
		
		JLabel lblVentas = new JLabel();
		lblVentas.setBounds(10, 273, 180, 35);
		lblVentas.setText("<html><body><h2>Ventas</h2></body></html>");
		
		JLabel lblVenta = new JLabel();
		lblVenta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("<html><body><h2>Realizar venta:</h2><p>Se introducirá el nombre del"
						+ " producto y a continuación las unidades que se van a vender. Las unidades que"
						+ "se van a vender deben ser menores o iguales a las unidades existentes en la"
						+ "tienda.<p></body></html>");
			}
		});
		lblVenta.setBounds(10, 305, 180, 35);
		lblVenta.setText("<html><body><ul><li>Realizar venta</ul></body></html>");
		
		contentPanel.setLayout(null);
		contentPanel.add(textPane);
		contentPanel.add(lblFicheros);
		contentPanel.add(lblNuevo);
		contentPanel.add(lblAbrir);
		contentPanel.add(lblGuardar);
		contentPanel.add(lblProductos);
		contentPanel.add(lblAnnadir);
		contentPanel.add(lblEliminar);
		contentPanel.add(lblBuscar);
		contentPanel.add(lblMostrar);
		contentPanel.add(lblModificar);
		contentPanel.add(lblVentas);
		contentPanel.add(lblVenta);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		
		JLabel labelAnnadirUnidades = new JLabel();
		labelAnnadirUnidades.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textPane.setText("<html><body><h2>Añadir unidades</h2><p>Se podrán añadir unidades "
						+ "al producto siempre que el número sea mayor que cero.</p></body></html>");
			}
		});
		labelAnnadirUnidades.setText("<html><body><ul><li>Añadir unidades</ul></body></html>");
		labelAnnadirUnidades.setBounds(10, 240, 180, 35);
		contentPanel.add(labelAnnadirUnidades);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton aceptar = new JButton("Aceptar");
				aceptar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						ayuda = null;
						dispose();
					}
				});
				aceptar.setActionCommand("Aceptar");
				buttonPane.add(aceptar);
				getRootPane().setDefaultButton(aceptar);
			}
		}
	}
	
	/**
	 * Instancia la clase Ayuda
	 * 
	 * @return Instancia de la clase Ayuda
	 */
	public static synchronized Ayuda getInstance() {
		if (ayuda == null) {
			ayuda = new Ayuda();
		}
		return ayuda;
	}
}
