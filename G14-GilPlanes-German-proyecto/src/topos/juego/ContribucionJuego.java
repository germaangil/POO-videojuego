package topos.juego;

public class ContribucionJuego {
	
/** Atributos **/
	
	private int puntos;
	private int tiempo;
	private int disparos;
	
/** Constructor **/
	
	public ContribucionJuego(int puntos, int tiempo, int disparos) {
		super();
		this.puntos = puntos;
		this.tiempo = tiempo;
		this.disparos = disparos;
	}
	
/**  get **/
	
	public int getPuntos() {
		return puntos;
	}
	
	public int getTiempo() {
		return tiempo;
	}
	
	public int getDisparos() {
		return disparos;
	}
}
