package topos.estructura;

import java.util.ArrayList;

import topos.juego.ContribucionJuego;

public class Escenario {
	
	
	private final int ancho;
	private final int alto;
	private PanelBasico paneles[][];
	
	
	public int getAncho() {
		return ancho;
	}
	
	public int getAlto() {
		return alto;
	}
	
	public PanelBasico getPanel(int x, int y) {
		if(x>=ancho || y>=alto || x<0 || y<0) {
			return null;
		}
		return paneles[x][y];
	}
	
	public PanelBasico getPanel(Posicion p) {
		if(p.getX()>=ancho || p.getY()>=alto || p.getX()<0 || p.getY()<0) {
			return null;
		}
		return paneles[p.getX()][p.getY()];
	}

	
	public Escenario(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;
		paneles = new PanelBasico[ancho][alto];
	}
	
	public boolean posicionValida(Posicion p) {
		if(p.getX()>=ancho || p.getY()>=alto || p.getX()<0 || p.getY()<0) {
			return false;
		}
		return true;
	}
	
	public void establecerPanel(PanelBasico a) {
		paneles[a.getPosicion().getX()][a.getPosicion().getY()] = a;
	}
	
	public boolean esVisible(Posicion posicion) {
		if(this.posicionValida(posicion)) {
			return this.paneles[posicion.getX()][posicion.getY()].esVisible();
		}
		return false;
	}
	
	public void derribarPanel(Posicion p) {
		paneles[p.getX()][p.getY()].derribar();
	}
	
	public void actualizar() {
		for(PanelBasico[] a : paneles) {
			for(PanelBasico b : a) {
				b.actualizar(this);
			}
		}
	}

	public ArrayList<ContribucionJuego> capturar(Posicion posi){
		ArrayList<ContribucionJuego> lista = new ArrayList<ContribucionJuego>();
		if(this.esVisible(posi)) {
			lista.addAll(this.paneles[posi.getX()][posi.getY()].capturar(this));
		}
		return lista;
	}
}