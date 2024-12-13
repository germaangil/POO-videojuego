package topos.pruebas;

import topos.estructura.Direccion;
import topos.juego.Partida;

public class PruebaPartida {

	public static void main(String[] args) {
		Partida p = new Partida(5,5,60,3);
		p.arrancar();
		System.out.println(p.getEnJuego());
		System.out.println(p.getPuntos());
		p.desplazarObjetivo(Direccion.DERECHA);
		System.out.println(p.getObjetivo());
		p.disparar();
		p.disparar();
		System.out.println(p.getDisparos());
		long fin = System.currentTimeMillis() + 4000;
		while (System.currentTimeMillis() < fin);
		System.out.println(p.getSegundosRestantes());
		System.out.println(p.getFinalizada());
		p.disparar();
		System.out.println(p.getEnJuego());
	}

}
