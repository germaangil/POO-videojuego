package topos.pruebas;

import topos.estructura.*;

public class PruebaEscenario {

	public static void main(String[] args) {
		Escenario e = new Escenario(5,6);
		System.out.println("Alto="+e.getAlto()+". "+"Ancho="+e.getAncho());
		System.out.println("La posicion (1,2) pertenece al escenario. "+e.posicionValida(new Posicion(1,2)));
		System.out.println("La posicion (5,1) pertenece al escenario. "+e.posicionValida(new Posicion(5,1)));
		PanelBasico panel1 = new PanelBasico(2,3);
		e.establecerPanel(panel1);
		System.out.println("panel1= "+panel1.toString());
		System.out.println("Panel situado en (2,3)= "+e.getPanel(2,3).toString());
		System.out.println("El panel situado en (2,3) es visible. "+e.esVisible(e.getPanel(2,3).getPosicion()));
		e.derribarPanel(e.getPanel(2,3).getPosicion());
		System.out.println("El panel situado en (2,3) es visible. "+e.esVisible(e.getPanel(2,3).getPosicion()));
	}
}
