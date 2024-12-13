package topos.elementos;

import topos.estructura.*;
import topos.juego.*;

public class Rata extends ElementoActivo{
	/* Constantes */
	private static final String RUTA_RATA = "imagenes/rata.png";
	
	/* Métodos */
	public void actualizar(Escenario esc) {
		if(!esc.esVisible(this.getPanel().getPosicion())) {
			Direccion dir = this.getPanelValido(esc);
			if(dir != null) {
				this.desplazar(dir, esc);
			}
		}
	}
	
	private Direccion getPanelValido(Escenario esc) {
		if((esc.posicionValida(this.getPanel().getPosicion().getVecina(Direccion.DERECHA)))&&(esc.esVisible(this.getPanel().getPosicion().getVecina(Direccion.DERECHA)))) {
			return Direccion.DERECHA;
		}else if(esc.posicionValida(this.getPanel().getPosicion().getVecina(Direccion.ARRIBA))&&(esc.esVisible(this.getPanel().getPosicion().getVecina(Direccion.ARRIBA)))) {
			return Direccion.ARRIBA;
		}else if(esc.posicionValida(this.getPanel().getPosicion().getVecina(Direccion.IZQUIERDA))&&(esc.esVisible(this.getPanel().getPosicion().getVecina(Direccion.IZQUIERDA)))) {
			return Direccion.IZQUIERDA;
		}else if(esc.posicionValida(this.getPanel().getPosicion().getVecina(Direccion.ABAJO))&&(esc.esVisible(this.getPanel().getPosicion().getVecina(Direccion.ABAJO)))){
			return Direccion.ABAJO; 
		}else {
			return null;
		}
	}
	
	public ContribucionJuego getContribucionJuego() {
		return new ContribucionJuego(-1,0,0);
	}
	
	/* Getters */
	public String getRuta() {
		return RUTA_RATA;
	}
}
