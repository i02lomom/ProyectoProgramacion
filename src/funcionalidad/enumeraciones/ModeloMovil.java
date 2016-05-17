package funcionalidad.enumeraciones;

/**
 * Enumeraci�n ModeloMovil. Contiene los modelos de los m�viles en funci�n de la marca.
 * 
 * @author Miguel Angel L�pez Moyano
 * @version 1.0
 */
public enum ModeloMovil {
	S5(MarcaMovil.SAMSUNG),
	S6(MarcaMovil.SAMSUNG),
	S7(MarcaMovil.SAMSUNG),
	
	IPHONE5(MarcaMovil.APPLE),
	IPHONE6(MarcaMovil.APPLE),
	IPHONE7(MarcaMovil.APPLE),
	
	AQUARISA45(MarcaMovil.BQ),
	AQUARISE5S(MarcaMovil.BQ),
	AQUARISX5(MarcaMovil.BQ),
	
	Y6(MarcaMovil.HUAWEI),
	SHOTX(MarcaMovil.HUAWEI),
	G8(MarcaMovil.HUAWEI),
	
	XPERIAM4(MarcaMovil.SONY),
	XPERIAC5(MarcaMovil.SONY),
	XPERIAZ5(MarcaMovil.SONY);
	
	/**
	 * Marca del m�vil
	 */
	private MarcaMovil marcaMovil;
	
	/**
	 * Constructor que recibe la marca del m�vil
	 * @param marcaMovil marca del m�vil
	 */
	private ModeloMovil(MarcaMovil marcaMovil){
		this.marcaMovil=marcaMovil;
	}

	/**
	 * Obtiene la marca del m�vil
	 * @return marca del m�vil
	 */
	public MarcaMovil getMarcaMovil() {
		return marcaMovil;
	}
	
	public String toString() {
		return name();
	}
}
