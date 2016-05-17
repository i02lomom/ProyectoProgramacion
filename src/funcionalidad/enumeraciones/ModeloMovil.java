package funcionalidad.enumeraciones;

/**
 * Enumeración ModeloMovil. Contiene los modelos de los móviles en función de la marca.
 * 
 * @author Miguel Angel López Moyano
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
	 * Marca del móvil
	 */
	private MarcaMovil marcaMovil;
	
	/**
	 * Constructor que recibe la marca del móvil
	 * @param marcaMovil marca del móvil
	 */
	private ModeloMovil(MarcaMovil marcaMovil){
		this.marcaMovil=marcaMovil;
	}

	/**
	 * Obtiene la marca del móvil
	 * @return marca del móvil
	 */
	public MarcaMovil getMarcaMovil() {
		return marcaMovil;
	}
	
	public String toString() {
		return name();
	}
}
