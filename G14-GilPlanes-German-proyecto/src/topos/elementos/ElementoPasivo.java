package topos.elementos;

import topos.estructura.Escenario;

public abstract class ElementoPasivo extends Elemento {
	private final int cantidad;
	
	public ElementoPasivo(int cantidad) {
		super();
		this.cantidad=cantidad;
	}
	
	public int getCantidad() {
		return cantidad;
	}
	
	@Override
	public void actualizar(Escenario escenario) {
		//Implementación vacía
	}
}
