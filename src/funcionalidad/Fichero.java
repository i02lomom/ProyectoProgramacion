package funcionalidad;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 * Clase Fichero. Contiene los métodos necesarios para la gestión de ficheros.
 * 
 * @author Miguel Angel López Moyano
 * @version 1.0
 */
public class Fichero {
	/**
	 * Abre un fichero y devuelve la tienda almacenada dentro de éste
	 * @param file fichero
	 * @return tienda leida del fichero
	 * @throws FileNotFoundException fichero no encontrado
	 * @throws IOException error de entrada/salida
	 * @throws ClassNotFoundException fichero con información distinta a la esperada
	 */
	@SuppressWarnings("unchecked")
	public static Tienda<Producto> leerFichero(File file) throws FileNotFoundException, IOException, ClassNotFoundException{
		file = comprobarExtension(file);
		try(ObjectInputStream in=new ObjectInputStream(
				new BufferedInputStream(new FileInputStream(file)))) {
			return (Tienda<Producto>) in.readObject();
		}
	}
	
	/**
	 * Guarda la tienda en un fichero
	 * @param file fichero
	 * @param tienda a guardar
	 * @throws FileNotFoundException fichero no encontrado
	 * @throws IOException error de entrada/salida
	 */
	public static void escribirFichero(File file, Tienda<Producto> tienda) throws FileNotFoundException, IOException{
		file=comprobarExtension(file);
		try(ObjectOutputStream out = new ObjectOutputStream(
				new BufferedOutputStream(new FileOutputStream(file)))) {
			out.writeObject(tienda);
		}
	}

	/**
	 * Comprueba si existe el fichero
	 * @param file fichero
	 * @return true si existe y false si no
	 */
	public static boolean existe(File file) {
		file=comprobarExtension(file);
		return file.exists();
	}
	
	/**
	 * Comprueba la extensión y si no es válida la cambia a obj
	 * @param file fichero
	 * @return file fichero
	 */
	static File comprobarExtension(File file) {
		String path=file.getPath();
	    if(!path.endsWith(".obj"))
	        return new File(path + ".obj");
	    return file;
	}
}
