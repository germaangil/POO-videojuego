package topos.juego;

public class Imagen {

/** Propiedades **/
	
	private final String ruta;
	private final int x;
	private final int y;
	
/** Constructor **/
	
	public Imagen(String ruta, int x, int y) {
		this.ruta = ruta;
		this.x = x;
		this.y = y;
	}

/** get **/
	
	public String getRuta() {
		return ruta;
	}
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
}
