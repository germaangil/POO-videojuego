package topos.estructura;

import java.util.Objects;

public class Posicion implements Cloneable {
	
/** Propiedades **/
	
	private	int x;
	private int y;
	
/** Constructores **/
	
	public Posicion(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public Posicion(Posicion p) {
		this.x = p.x;
		this.y = p.y;
	}
	
/** Consulta(set) **/
	
	public int getX() {
		return x;
	}
	
	public int getY() {
		return y;
	}
	
/** Funcionalidad **/
	
	public void desplazar(int x, int y) {
		this.x += x;
		this.y += y; 	
	}
	
	public void desplazar(Direccion v) {
		switch(v) {
		case ARRIBA:
			this.desplazar(0,1);
			break;
		case ABAJO:
			this.desplazar(0,-1);
			break;
		case DERECHA:
			this.desplazar(1,0);
			break;
		case IZQUIERDA:
			this.desplazar(-1,0);
			break;
		}
	}

	public String toString() {
		return "Posicion [x="+this.x+", y="+this.y+"]";
	}
	
	public Posicion getVecina(Direccion v) {
		Posicion p=new Posicion(this);
		p.desplazar(v);
		return p;
	}

	@Override
	public int hashCode() {
		return Objects.hash(x, y);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Posicion other = (Posicion) obj;
		return x == other.x && y == other.y;
	}
	
	@Override
	protected Posicion clone() {
		// Primero copia superficial
		Posicion copia= copiaSuperficial();
		// Arreglo el aliasing -> no hay nada que hacer
		// si fuera un circulo se arregla: copia.centro = this.centro.clone()
		return copia;
	}

	private Posicion copiaSuperficial() {
		Posicion copiaSuperficial= null;
		try {
			copiaSuperficial = (Posicion) super.clone();
		} catch (CloneNotSupportedException e) {
			System.err.println("Error objeto no clonable");
			e.printStackTrace();
		} // super es de la clase obj
		return copiaSuperficial;
	}
}

