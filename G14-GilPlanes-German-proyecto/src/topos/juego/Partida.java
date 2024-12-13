package topos.juego;

import topos.estructura.*;
import java.util.ArrayList;

public class Partida {
	
/** Propiedades **/

	private static final String RUTA_OBJETIVO = "imagenes/objetivo.png";
	private Escenario escenario;
	private Posicion objetivo;
	private int segundos;
	private int disparos;
	private int puntos;
	private long inicio;
	
	public int getSegundosRestantes() {
		long milisegundos_transcurridos=System.currentTimeMillis()-inicio;
		long milisegundos_restantes=(long)segundos*1000-milisegundos_transcurridos;
		if(milisegundos_restantes>0) {
			return (int)Math.ceil((double)milisegundos_restantes/1000);
		}
		else {
			return 0;
		}
	}
	
	public boolean getFinalizada() {
		return getSegundosRestantes()==0;
	}
	
	public boolean getEnJuego() {
		return !getFinalizada() && disparos>0;
	}
	
/** get **/
	
	public Escenario getEscenario() {
		return escenario;
	}
	
	public Posicion getObjetivo() {
		return objetivo;
	}
	
	public int getSegundos() {
		return segundos;
	}
	
	public int getDisparos() {
		return disparos;
	}
	
	public int getPuntos() {
		return puntos;
	}
	
	public long getInicio() {
		return inicio;
	}
	
	public ArrayList<Imagen> getImagenesEscenario() {
		ArrayList<Imagen> lista = new ArrayList<>();
		for(int i=0 ; i<escenario.getAncho() ; i++) {
			for(int j=0 ; j<escenario.getAlto() ; j++) {
				lista.addAll(escenario.getPanel(i, j).getImagenesPanel());
			}
		}
		lista.add(new Imagen(RUTA_OBJETIVO, objetivo.getX(), objetivo.getY()));
		return lista;
	}
	
/** Constructor **/

	public Partida(int ancho, int alto, int s, int d) {
		escenario = new Escenario(ancho,alto);
		segundos = s;
		disparos = d;
		puntos = 0;
		objetivo = new Posicion(0,0);
	}
	
/** Funcionalidad **/
	
	public void arrancar() {
		inicio=System.currentTimeMillis();
	}
	
	public boolean desplazarObjetivo(Direccion v) {
		if(escenario.posicionValida(objetivo.getVecina(v))) {
			objetivo.desplazar(v);
			return true;
		}
		return false;
	}
	
	public void disparar() {
		if(getEnJuego()) {
			if(!escenario.esVisible(objetivo)) {
				escenario.derribarPanel(objetivo);
			}
			else {
				for(ContribucionJuego dato : escenario.capturar(objetivo)) {
					puntos += dato.getPuntos();
					disparos += dato.getDisparos();
					segundos += dato.getTiempo();
				}
			}
		}
		disparos-=1;
	}
	
	public void actualizar() {
		escenario.actualizar();
	}
	
	public void añadirPaneles(PanelBasico a) {
		escenario.establecerPanel(a);
	}
}
