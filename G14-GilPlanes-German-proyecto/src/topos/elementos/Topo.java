package topos.elementos;

import topos.estructura.*;

public abstract class Topo extends ElementoActivo{
	private static final long TIEMPO_ESPERA = 3000;
	
	private long tiempoUltMovimiento;
	private Direccion direccionUltMovimiento;
	
	public Direccion getDireccionUltMovimiento() {
		return direccionUltMovimiento;
	}

	public void actualizar(Escenario escenario) {
		if(this.puedeMoverse(escenario)) {
			long tiempoActual = System.currentTimeMillis();
			long tiempoTranscurrido = tiempoActual - this.tiempoUltMovimiento;
			if(tiempoTranscurrido >= TIEMPO_ESPERA) {
				Direccion dir = this.getDirDesplazamiento(escenario);
				boolean isMovido;
				isMovido = this.desplazar(dir, escenario);
				if(isMovido) {
					this.direccionUltMovimiento = dir;
					this.tiempoUltMovimiento = tiempoActual;
				}
			}
		}
	}
	
	protected abstract boolean puedeMoverse(Escenario escenario);
	
	protected abstract Direccion getDirDesplazamiento(Escenario escenario);
}
