package topos.elementos;

import java.util.Random;
import topos.estructura.*;
import topos.juego.*;

public class TopoTorpe extends Topo{
	private static final String RUTA_IMAGEN_TOPO_TORPE = "imagenes/topo-torpe.png";
	
	public boolean puedeMoverse(Escenario esc) {
		//return this.getPanel().isVisible();
		Posicion posi = this.getPanel().getPosicion();
		return esc.esVisible(posi);
	}
	
	public Direccion getDirDesplazamiento(Escenario esc) {
		Direccion[] direcciones = Direccion.values();
		Random rand = new Random();
		int i = rand.nextInt(direcciones.length);
		return direcciones[i];
	}
	 
	public ContribucionJuego getContribucionJuego() {
		return new ContribucionJuego(1,0,0);
	}
	
	@Override
	public String getRuta() {
		return RUTA_IMAGEN_TOPO_TORPE;
	}
}
