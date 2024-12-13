package topos.elementos;

import topos.juego.ContribucionJuego;

public class Municion extends ElementoPasivo {
	private static final String RUTA = "imagenes/municion.png";
	
	public Municion(int cantidad) {
		super(cantidad);
	}
	
	@Override
	public ContribucionJuego getContribucionJuego() {
		return new ContribucionJuego(0,0,getCantidad());
	}
	
	@Override
	public String getRuta() {
		return RUTA;
	}
}