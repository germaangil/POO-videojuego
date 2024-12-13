package topos.elementos;

import topos.juego.ContribucionJuego;

public class Moneda extends ElementoPasivo {
	private static final String RUTA = "imagenes/monedas.png";
	
	public Moneda(int cantidad) {
		super(cantidad);
	}
	
	@Override
	public ContribucionJuego getContribucionJuego() {
		return new ContribucionJuego(getCantidad(),0,0);
	}
	
	@Override
	public String getRuta() {
		return RUTA;
	}
}
