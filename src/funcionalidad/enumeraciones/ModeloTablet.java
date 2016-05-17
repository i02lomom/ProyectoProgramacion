package funcionalidad.enumeraciones;

/**
 * Enumeraci�n Modelo Tablet. Contiene los modelos de las tablets en funci�n de la marca.
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public enum ModeloTablet {
	GALAXYTABA(MarcaTablet.SAMSUNG),
	GALAXYTAB4(MarcaTablet.SAMSUNG),
	
	IPADAIR2(MarcaTablet.APPLE),
	IPADPRO(MarcaTablet.APPLE),
	IPADMINI(MarcaTablet.APPLE),
	
	TAB2(MarcaTablet.LENOVO),
	YOGATAB3(MarcaTablet.LENOVO),
	
	XPERIAZ4(MarcaTablet.SONY),
	
	SX100(MarcaTablet.WOXTER);
	
	private MarcaTablet marcaTablet;
	
	private ModeloTablet(MarcaTablet marcaTablet){
		this.marcaTablet=marcaTablet;
	}

	public MarcaTablet getMarcaTablet() {
		return marcaTablet;
	}
	
	public String toString() {
		return name();
	}
}
