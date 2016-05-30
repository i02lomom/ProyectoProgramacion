package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;

import funcionalidad.Componente;
import funcionalidad.Fichero;
import funcionalidad.Movil;
import funcionalidad.Producto;
import funcionalidad.Tablet;
import funcionalidad.Tienda;
import funcionalidad.excepciones.ElementoYaExisteException;

import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.awt.event.InputEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JSeparator;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Clase principal. Desde este menú se podrá acceder a todas las opciones del programa
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Principal {
	private int returnVal;
	private File file;
	private JFileChooser fileChooser = new JFileChooser();
	private FileFilter filter = new FileNameExtensionFilter("Archivos de objeto (*.obj)", "obj");
	private Tienda<Producto> tienda=new Tienda<Producto>();
	private Tienda<Tablet> tiendaTablets;
	private Tienda<Movil> tiendaMoviles;
	private Tienda<Componente> tiendaComponentes;
	private JFrame frame;
	private Ayuda ayuda;
	private Anadir anadir;
	private Eliminar eliminar;
	private Modificar modificar;
	private AcercaDe acercaDe;
	private MostrarPorId mostrarPorId;
	private AnadirUnidades anadirUnidades;
	private MostrarPorNombre mostrarPorNombre;
	private MostrarProductos mostrarProductos;
	private MostrarTablets mostrarTablets;
	private MostrarMoviles mostrarMoviles;
	private MostrarComponentes mostrarComponentes;
	private RealizarVenta realizarVenta;

	/**
	 * Lanza la aplicación
	 * @param args argumentos que recibirá main
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Inicializa la aplicación
	 */
	public Principal() {
		initialize();
	}

	/**
	 * Inicializa los contenidos de la ventana
	 */
	private void initialize() {
		frame = new JFrame();
		frame.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				if(comprobarCambios())
					return;
				System.exit(0);
			}
		});
		frame.setBounds(100, 100, 455, 344);
		frame.setResizable(false);
		actualizarTitulo("Tienda: Sin título");
		frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		fileChooser.setFileFilter(filter);
		
		JMenuBar menuBar = new JMenuBar();
		frame.setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		mnArchivo.setMnemonic('A');
		menuBar.add(mnArchivo);
		
		JMenuItem mntmNuevo = new JMenuItem("Nuevo");
		mntmNuevo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nuevo();
			}
		});
		mntmNuevo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmNuevo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir...");
		mntmAbrir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abrirFichero();
			}
		});
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardar();
			}
		});
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmGuardarComo = new JMenuItem("Guardar como...");
		mntmGuardarComo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				guardarComo();
			}
		});
		mntmGuardarComo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK | InputEvent.ALT_MASK));
		mnArchivo.add(mntmGuardarComo);
		
		JSeparator separator = new JSeparator();
		mnArchivo.add(separator);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(tienda.estaModificado())
					guardar();
				System.exit(0);
			}
		});
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnArchivo.add(mntmSalir);
		
		JMenu mnProductos = new JMenu("Productos");
		mnProductos.setMnemonic('P');
		menuBar.add(mnProductos);
		
		JMenuItem mntmAadirProducto = new JMenuItem("A\u00F1adir producto");
		mntmAadirProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				anadir();
			}
		});
		mntmAadirProducto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnProductos.add(mntmAadirProducto);
		
		JMenuItem mntmEliminarProducto = new JMenuItem("Eliminar producto");
		mntmEliminarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				eliminar();
			}
		});
		mntmEliminarProducto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E, InputEvent.CTRL_MASK));
		mnProductos.add(mntmEliminarProducto);
		
		JMenuItem mntmModificarProducto = new JMenuItem("Modificar producto");
		mntmModificarProducto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				modificar();
			}
		});
		mntmModificarProducto.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnProductos.add(mntmModificarProducto);
		
		JMenuItem mntmAadirUnidadesDe = new JMenuItem("A\u00F1adir unidades de producto");
		mntmAadirUnidadesDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				anadirUnidades();
			}
		});
		mntmAadirUnidadesDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U, InputEvent.CTRL_MASK));
		mnProductos.add(mntmAadirUnidadesDe);
		
		JMenu mnBuscar = new JMenu("Buscar");
		mnProductos.add(mnBuscar);
		
		JMenuItem mntmPorId = new JMenuItem("Por ID...");
		mntmPorId.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorId();
			}
		});
		mntmPorId.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_I, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnBuscar.add(mntmPorId);
		
		JMenuItem mntmPorNombre = new JMenuItem("Por nombre...");
		mntmPorNombre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarPorNombre();
			}
		});
		mntmPorNombre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N, InputEvent.CTRL_MASK | InputEvent.SHIFT_MASK));
		mnBuscar.add(mntmPorNombre);
		
		JMenu mnVentas = new JMenu("Ventas");
		mnVentas.setMnemonic('V');
		menuBar.add(mnVentas);
		
		JMenuItem mntmRealizarVenta = new JMenuItem("Realizar venta");
		mntmRealizarVenta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarVenta();
			}
		});
		mntmRealizarVenta.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		mnVentas.add(mntmRealizarVenta);
		
		JMenu mnMostrar = new JMenu("Mostrar");
		menuBar.add(mnMostrar);
		
		JMenuItem mntmMostrarComponentes = new JMenuItem("Mostrar componentes");
		mntmMostrarComponentes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarComponentes();
				
			}
		});
		mntmMostrarComponentes.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C, InputEvent.CTRL_MASK));
		mnMostrar.add(mntmMostrarComponentes);
		
		JMenuItem mntmMostrarTablets = new JMenuItem("Mostrar tablets");
		mntmMostrarTablets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mostrarTablets();
			}
		});
		mntmMostrarTablets.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T, InputEvent.CTRL_MASK));
		mnMostrar.add(mntmMostrarTablets);
		
		JMenuItem mntmMostrarMviles = new JMenuItem("Mostrar m\u00F3viles");
		mntmMostrarMviles.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarMoviles();
			}
		});
		mntmMostrarMviles.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M, InputEvent.CTRL_MASK));
		mnMostrar.add(mntmMostrarMviles);
		
		JSeparator separator_1 = new JSeparator();
		mnMostrar.add(separator_1);
		
		JMenuItem mntmMostrarProductos = new JMenuItem("Mostrar productos");
		mntmMostrarProductos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarProductos();
			}
		});
		mntmMostrarProductos.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P, InputEvent.CTRL_MASK));
		mnMostrar.add(mntmMostrarProductos);
		
		JMenu mnAyuda = new JMenu("Ayuda");
		mnAyuda.setMnemonic('Y');
		menuBar.add(mnAyuda);
		
		JMenuItem mntmVerAyuda = new JMenuItem("Ver ayuda");
		mntmVerAyuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ayuda = Ayuda.getInstance();
				ayuda.setVisible(true);
			}
		});
		mntmVerAyuda.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, InputEvent.SHIFT_MASK));
		mnAyuda.add(mntmVerAyuda);
		
		JMenuItem mntmAcercaDe = new JMenuItem("Acerca de...");
		mntmAcercaDe.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				acercaDe();
			}
		});
		mntmAcercaDe.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1, 0));
		mnAyuda.add(mntmAcercaDe);
		frame.getContentPane().setLayout(null);
		
		JLabel lblImagen = new JLabel();
		lblImagen.setIcon(new ImageIcon(Principal.class.getResource("/imagenes/Tienda.png")));
		lblImagen.setBounds(0, 0, 449, 294);
		frame.getContentPane().add(lblImagen);
	}
	
	/**
	 * Actualiza el título de la ventana
	 * @param titulo que se le pondrá
	 */
	private void actualizarTitulo(String titulo){
		frame.setTitle(titulo);
	}
	
	/**
	 * Crea una nueva ventana Anadir y la pone visible
	 */
	private void anadir(){
		anadir=new Anadir(tienda);
		anadir.setVisible(true);
	}
	
	/**
	 * Crea una nueva ventana Eliminar y la pone visible
	 */
	private void eliminar(){
		if(!tiendaVacia(tienda)){
			eliminar=new Eliminar(tienda);
			eliminar.setVisible(true);
		}
	}
	
	/**
	 * Crea una nueva ventana Modificar y la pone visible
	 */
	private void modificar(){
		if(!tiendaVacia(tienda)){
			modificar=new Modificar(tienda);
			modificar.setVisible(true);
		}
	}
	
	/**
	 * Crea una nueva ventana AnadirUnidades y lo pone visible
	 */
	private void anadirUnidades(){
		if(!tiendaVacia(tienda)){
			anadirUnidades=new AnadirUnidades(tienda);
			anadirUnidades.setVisible(true);
		}
	}
	
	/**
	 * Crea una nueva ventana MostrarPorId y la pone visible
	 */
	private void mostrarPorId(){
		if(!tiendaVacia(tienda)){
			mostrarPorId=new MostrarPorId(tienda);
			mostrarPorId.setVisible(true);
		}
	}
	
	/**
	 * Crea una nueva ventana MostrarPorNombre y la pone visible
	 */
	private void mostrarPorNombre(){
		if(!tiendaVacia(tienda)){
			mostrarPorNombre=new MostrarPorNombre(tienda);
			mostrarPorNombre.setVisible(true);
		}
	}
	
	/**
	 * Crea una nueva ventana MostrarProductos y la pone visible
	 */
	private void mostrarProductos(){
		if(!tiendaVacia(tienda)){
			mostrarProductos=new MostrarProductos(tienda);
			mostrarProductos.setVisible(true);
		}
	}
	
	/**
	 * Crea una nueva ventana MostrarComponentes y la pone visible
	 */
	private void mostrarComponentes(){
		if(!tiendaVacia(tienda)){
			crearArrayComponentes(tienda);
			tiendaComponentes=new Tienda<Componente>();
			if(!tiendaComponentes.getAlmacen().isEmpty()){
				mostrarComponentes=new MostrarComponentes(tienda,tiendaComponentes);
				mostrarComponentes.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(frame,
						"No existe ningún componente en la lista", "Error",
						JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Crea una nueva ventana MostrarTablets y la pone visible
	 */
	private void mostrarTablets(){
		if(!tiendaVacia(tienda)){
			tiendaTablets=new Tienda<Tablet>();
			crearArrayTablets(tienda);
			if(!tiendaTablets.getAlmacen().isEmpty()){
				mostrarTablets=new MostrarTablets(tienda,tiendaTablets);
				mostrarTablets.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(frame,
						"No existe ninguna tablet en la lista", "Error",
						JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Crea una nueva ventana MostrarMoviles y la pone visible
	 */
	private void mostrarMoviles(){
		if(!tiendaVacia(tienda)){
			crearArrayMoviles(tienda);
			tiendaMoviles=new Tienda<Movil>();
			if(!tiendaMoviles.getAlmacen().isEmpty()){
				mostrarMoviles=new MostrarMoviles(tienda,tiendaMoviles);
				mostrarMoviles.setVisible(true);
			}
			else
				JOptionPane.showMessageDialog(frame,
						"No existe ningún móvil en la lista", "Error",
						JOptionPane.ERROR_MESSAGE);
		}
	}
	
	/**
	 * Crea una nueva ventana RealizarVenta y la pone visible
	 */
	private void realizarVenta(){
		if(!tiendaVacia(tienda)){
			realizarVenta=new RealizarVenta(tienda);
			realizarVenta.setVisible(true);
		}
	}
	
	/**
	 * Crea una nueva ventana AcercaDe y la pone visible
	 */
	private void acercaDe(){
		acercaDe=new AcercaDe();
		acercaDe.setVisible(true);
	}
	
	/**
	 * Comprueba que la tienda no esté vacía, es decir que tenga al menos algún producto.
	 * @param tienda ArrayList de productos
	 * @return true si está vacía y false si no lo está
	 */
	private boolean tiendaVacia(Tienda<Producto> tienda){
		if(tienda.getAlmacen().size()==0){
			JOptionPane.showMessageDialog(frame,
				"No existe ningún producto en la lista", "Error",
				JOptionPane.ERROR_MESSAGE);
			return true;
		}
		return false;
	}
	
	/**
	 * Crea un ArrayList donde se almacenarán solo los Componentes de tienda
	 * @param tienda ArrayList de productos
	 */
	private void crearArrayComponentes(Tienda<Producto> tienda){
		for(Producto elemento:tienda.getAlmacen()){
			if(elemento instanceof Componente)
				try {
					tiendaComponentes.anadirProducto((Componente) elemento);
				} catch (ElementoYaExisteException e) {
				}
		}
	}
	
	/**
	 * Crea un ArrayList donde se almacenarán solo las Tablets de tienda
	 * @param tienda ArrayList de productos
	 */
	private void crearArrayMoviles(Tienda<Producto> tienda){
		for(Producto elemento:tienda.getAlmacen()){
			if(elemento instanceof Movil)
				try {
					tiendaMoviles.anadirProducto((Movil) elemento);
				} catch (ElementoYaExisteException e) {
				}
		}
	}
	
	/**
	 * Crea un ArrayList donde se almacenarán solo las Tablets de tienda
	 * @param tienda ArrayList de productos
	 */
	private void crearArrayTablets(Tienda<Producto> tienda){
		for(Producto elemento:tienda.getAlmacen()){
			if(elemento instanceof Tablet)
				try {
					tiendaTablets.anadirProducto((Tablet) elemento);
				} catch (ElementoYaExisteException e) {
				}
		}
	}
	
	/**
	 * Si se ha modificado la tienda pregunta al usuario si desea guardar los cambios
	 * @return true si se guardan y false si no.
	 */
	private boolean comprobarCambios() {
		if (tienda.estaModificado()) {
			switch (JOptionPane.showOptionDialog(frame, "¿Desea guardar los cambios?", "Confirmar",
					JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null,
					null)){	
			case JOptionPane.YES_OPTION:
				guardar();
				tienda.setModificado(false);
				return false;	
			case JOptionPane.NO_OPTION:
				return false;	
			
			default:				
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Comprueba si se ha modificado la tienda, se guarda si así lo desea el usuario y crea una
	 * nueva tienda (vacía)
	 */
	private void nuevo() {
		comprobarCambios();
		inicializar();  //Creamos una tienda nueva y ponemos modificado a false
		file=null;	//Ponemos el file a null para indicar que el fichero es nuevo
		actualizarTitulo("Tienda: Sin título");
	}

	/**
	 * Crea una nueva tienda estableciendo modificado a false.
	 */
	private void inicializar() {
		tienda.setModificado(false);
		tienda = new Tienda<Producto>();
	}
	
	/**
	 * Abre el fichero seleccionado en el fileChooser
	 */
	private void abrirFichero() {
		comprobarCambios();
		returnVal = fileChooser.showOpenDialog(frame);
		if (returnVal == JFileChooser.APPROVE_OPTION){
			file=fileChooser.getSelectedFile();
			if(file.exists()&&file!=null)
				abrir(file);
			else
				JOptionPane.showMessageDialog(frame,
					    "No existe el fichero",
					    "Fichero no encontrado",
					    JOptionPane.PLAIN_MESSAGE);
		}
		else if(returnVal == JFileChooser.CANCEL_OPTION)
			return;
	}
	
	/**
	 * Nos permite leer una tienda guardada en un fichero.
	 * @param file fichero
	 */
	public void abrir(File file) {
		try {
			tienda = Fichero.leerFichero(file);
			JOptionPane.showMessageDialog(frame,
			    "Fichero cargado con éxito",
			    "Fichero cargado",
			    JOptionPane.PLAIN_MESSAGE);
			tienda.setModificado(false);
			actualizarTitulo("Tienda: "+file.getName());
		} catch (ClassCastException e) {
			JOptionPane.showMessageDialog(frame,
				    "Tipo de fichero no válido",
				    "Error",
				    JOptionPane.PLAIN_MESSAGE);
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(frame,
			    "Información distinta a la esperada",
			    "Error",
			    JOptionPane.PLAIN_MESSAGE);
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame,
				"Error al leer el fichero",
				"Error",
				JOptionPane.PLAIN_MESSAGE);
		}
	}
	
	/**
	 * Guarda en un fichero la tienda actual. Si ya se ha establecido un nombre de fichero
	 * no se le pedirá al usuario. En caso contrario el usuario deberá dar un nombre al fichero
	 * para guardarlo
	 */
	private void guardar() {
		if(file==null)	//Si no hemos guardado previamente preguntamos el nombre del fichero
			guardarComo();
		else {
			try {
				Fichero.escribirFichero(file, tienda);
				tienda.setModificado(false);
				JOptionPane.showMessageDialog(frame,
					    "Fichero guardado con éxito",
					    "Fichero guardado",
					    JOptionPane.PLAIN_MESSAGE);
				actualizarTitulo("Tienda: "+file.getName());
			} catch (IOException e) {
				JOptionPane.showMessageDialog(frame,
					"Error al escribir en el fichero",
					"Error",
					JOptionPane.PLAIN_MESSAGE);
			}
		}
	}
	
	/**
	 * Guarda en un fichero la tienda actual. Obligatoriamente se le pedirá al usuario un nombre
	 * de fichero para guardarlo.
	 */
	private void guardarComo() {
		try {
			returnVal = fileChooser.showSaveDialog(frame);
			if (returnVal == JFileChooser.APPROVE_OPTION)
				file=fileChooser.getSelectedFile();
			if(file!=null){
				if (Fichero.existe(file)) {
					switch(JOptionPane.showOptionDialog(frame,
						"¿Está seguro de que desea sobreescribirlo?", "Confirmar",
						JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE, null, null, null)){
						case JOptionPane.NO_OPTION:
							return;
					}
				}
				Fichero.escribirFichero(file, tienda);
				tienda.setModificado(false);
				JOptionPane.showMessageDialog(frame,
				    "Fichero guardado con éxito",
				    "Fichero guardado",
				    JOptionPane.PLAIN_MESSAGE);
				actualizarTitulo("Tienda: "+file.getName());
			}
		} catch (IOException e) {
			JOptionPane.showMessageDialog(frame,
				"Error al escribir en el fichero",
				"Error",
				JOptionPane.PLAIN_MESSAGE);
		}
	}
}
