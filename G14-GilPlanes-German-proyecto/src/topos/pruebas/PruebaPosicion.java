package topos.pruebas;

import topos.estructura.*;

public class PruebaPosicion {

	public static void main(String[] args) {
		Posicion p = new Posicion(10,10);
		System.out.println(p.toString());
		p.desplazar(Direccion.ARRIBA);
		System.out.println(p.toString());
		p.desplazar(Direccion.DERECHA);
		System.out.println(p.toString());
		p.desplazar(Direccion.ABAJO);
		System.out.println(p.toString());
		p.desplazar(Direccion.IZQUIERDA);
		System.out.println(p.toString());
		
		System.out.println(p.getVecina(Direccion.ARRIBA).toString());
		System.out.println(p.getVecina(Direccion.ABAJO).toString());
		System.out.println(p.getVecina(Direccion.DERECHA).toString());
		System.out.println(p.getVecina(Direccion.IZQUIERDA).toString());
	}	
}
