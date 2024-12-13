package topos.estructura;

import java.util.ArrayList;
import java.util.Random;

import topos.juego.*;

import topos.elementos.*;

public class PanelBasico {
	
	private static final String RUTA_PANEL = "imagenes/panel-basico.gif"; 
	private static final long TIEMPO_RESTAURACION = 3000;
	private Posicion p;
	private Estado e;
	private ArrayList<Elemento> elementos;
	private long tiempo;

	
	public Posicion getPosicion() {
		return this.p;
	}
	
	public int getX() {
		return p.getX();
	}
	
	public int getY() {
		return p.getY();
	}
	
	public Estado getEstado() {
		return this.e;
	}
	
	public ArrayList<Elemento> getElementos(){
		return elementos;
	}
	
	public String getRuta() {
		return RUTA_PANEL;
	}

	
	public void setElementos(ArrayList<Elemento> lista) {
		elementos = lista;
	}

	
	public PanelBasico(int x, int y) {
		p = new Posicion(x,y);
		e = Estado.LEVANTADO;
		elementos = new ArrayList<Elemento>();
	}
	
	public void derribar() {
		e = Estado.DERRIBADO;
		tiempo = System.currentTimeMillis();
	}
	
	public String toString() {
		return "[Posicion=("+this.p.getX()+","+this.p.getY()+"), Estado="+ this.e+"]";
	}
	
	public boolean introducirElemento(Elemento dato) {
		for(Elemento k : elementos) {
			if(dato == k) {
				return false;
			}
		}
		elementos.add(dato);
		dato.setPanel(this);
		return true;
	}
	
	public boolean quitarElemento(Elemento dato) {
		if(elementos.remove(dato)) {
			dato.setPanel(null);
			return true;
		}
		return false;
	}
	
	public ArrayList<Imagen> getImagenesPanel(){
		ArrayList<Imagen> lista = new ArrayList<>();
		if(e == Estado.LEVANTADO) {
			lista.add(new Imagen(this.getRuta(), p.getX(), p.getY()));
		}
		else
		for(Elemento elemento : elementos) {
			Imagen imagen = new Imagen(elemento.getRuta(), elemento.getPanel().getX(), elemento.getPanel().getY());
			lista.add(0,imagen);
		}
		return lista;
	}
	
	public ArrayList<ContribucionJuego> capturar(Escenario escenario){
		ArrayList<ContribucionJuego> contribuciones = new ArrayList<ContribucionJuego>();
		for(Elemento elemento : elementos) {
			contribuciones.add(elemento.getContribucionJuego());
			//Hemos considerado que es mejor asignarle un nuevo panel random del escenario al elemento
			Random random = new Random();
			int i = random.nextInt(escenario.getAncho());
			int j = random.nextInt(escenario.getAlto());
			PanelBasico panelNuevo = escenario.getPanel(i,j);
			panelNuevo.introducirElemento(elemento);
		}
		return contribuciones;
	}
	
	public void actualizar(Escenario escenario) {
		if(e==Estado.DERRIBADO && System.currentTimeMillis()-tiempo>=TIEMPO_RESTAURACION) {
			e=Estado.LEVANTADO;
			tiempo=0;
		}
		for(Elemento elemento : elementos) {
			elemento.actualizar(escenario);
		}
	}
	
	public boolean esVisible() {
		return this.e == Estado.DERRIBADO;
	}
}
