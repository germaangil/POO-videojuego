package topos.elementos;

import topos.estructura.*;
import java.util.Random;
import topos.juego.*;
import java.util.ArrayList;

public class TopoListo extends Topo{
	private static final String RUTA_TOPO_LISTO = "imagenes/topo-listo.png";
	
	public boolean puedeMoverse(Escenario escenario) {
		return escenario.esVisible(this.getPanel().getPosicion());
	}
	
	public Direccion getDirDesplazamiento(Escenario escenario) {
		ArrayList<Direccion> lista = new ArrayList<Direccion>();
		Direccion[] direcciones = Direccion.values();
		for(Direccion dir : direcciones) {
			if(!escenario.esVisible(this.getPanel().getPosicion().getVecina(dir))) {
				lista.add(dir);
			}
		}
		
		Direccion dir = null;
		if(lista.size()>0) {
			Random rand = new Random();
			int i = rand.nextInt(lista.size());
			dir = lista.get(i);
		}
		if(dir != null) {
			return dir;
		}else {
			return this.getDireccionUltMovimiento();
		}
	}
	
	public ContribucionJuego getContribucionJuego() {
		return new ContribucionJuego(3,0,0);
	}
	
	@Override
	public String getRuta() {
		return RUTA_TOPO_LISTO;
	}
}
