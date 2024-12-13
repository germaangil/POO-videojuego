package topos.pruebas;

import topos.estructura.*;

public class PruebaGestionTiempo {

	public static void main(String[] args) {
		Escenario e = new Escenario(5,5);
		e.derribarPanel(e.getPanel(2,2).getPosicion());
		System.out.println(e.esVisible(e.getPanel(2,2).getPosicion()));
		long fin = System.currentTimeMillis() + 4000;
		while (System.currentTimeMillis() < fin);
		e.actualizar();
		System.out.println(e.esVisible(e.getPanel(2,2).getPosicion()));
	}
}
