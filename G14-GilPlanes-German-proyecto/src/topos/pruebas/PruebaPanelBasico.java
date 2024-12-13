package topos.pruebas;

import topos.estructura.*;

public class PruebaPanelBasico {

	public static void main(String[] args) {
		PanelBasico panel = new PanelBasico(0,0);
		System.out.println(panel.toString());
		Posicion p = new Posicion(panel.getPosicion());
		p.desplazar(Direccion.DERECHA);
		System.out.println(panel.toString());
		System.out.println(p.toString());
		panel.derribar();
		System.out.println(panel.toString());
	}
}
