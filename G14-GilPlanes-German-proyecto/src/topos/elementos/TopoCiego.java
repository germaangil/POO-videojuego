package topos.elementos;

import topos.juego.*;
import java.util.Random;
import topos.estructura.*;

public class TopoCiego extends Topo{
	private static final String RUTA = "imagenes/topo-ciego.png";
	
	public boolean puedeMoverse(Escenario esc) {
		return true;
	}
	
	public Direccion getDirDesplazamiento(Escenario esc) {
		Direccion[] direcciones = Direccion.values();
		Random rand = new Random();
		int i = rand.nextInt(direcciones.length);
		if(direcciones[i] == this.getDireccionUltMovimiento()) {
			i++;
			if(i == direcciones.length) {
				i = 0;
			}
		}
		return direcciones[i];
	}
	
	public ContribucionJuego getContribucionJuego() {
		return new ContribucionJuego(2,0,0);
	}

	@Override
	public String getRuta() {
		return RUTA;
	}
	
}
