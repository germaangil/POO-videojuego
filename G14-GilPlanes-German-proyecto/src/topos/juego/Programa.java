package topos.juego;


import topos.elementos.*;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Random;

import topos.estructura.*;
import topos.vista1.*;

public class Programa {
	
	private static final int ANCHO = 7;
	private static final int ALTO = 7;
	private static final int SEGUNDOS = 120;
	private static final int DISPAROS = 100;
	private static final int TAMAÑO_LADO = 50;
	private static final Color COLOR = Color.GREEN;
	private static final int TIEMPO_ACTUALIZACION = 200; //Tiempo utilizado para la Alarma
	
	public static void main(String[] args) {
		
		Partida partida = new Partida(ANCHO, ALTO, SEGUNDOS, DISPAROS);
		Pantalla pantalla = new Pantalla(partida.getEscenario().getAncho(), partida.getEscenario().getAlto(), TAMAÑO_LADO, COLOR);
		
		Moneda mon1 = new Moneda(3);
		Moneda mon2 = new Moneda(1);
		Municion mun1 = new Municion(3);
		Municion mun2 = new Municion(1);
		Rata rat1 = new Rata();
		Rata rat2 = new Rata();
		Reloj rej1 = new Reloj(10);
		Reloj rej2 = new Reloj(5);
		TopoCiego top1 = new TopoCiego();
		TopoCiego top2 = new TopoCiego();
		TopoTorpe top3 = new TopoTorpe();
		TopoTorpe top4 = new TopoTorpe();
		TopoListo top5 = new TopoListo();
		TopoListo top6 = new TopoListo();
		
		for(int i=0 ; i<partida.getEscenario().getAncho() ; ++i) {
			for(int j=0 ; j<partida.getEscenario().getAlto() ; ++j) {		
				Random random = new Random();
				// Retorna un entero entre 0 y 3
				int valorAleatorio = random.nextInt(4);
				switch(valorAleatorio) {
					case(0):
						PanelBasico nuevo_basico = new PanelBasico(i,j);
						partida.getEscenario().establecerPanel(nuevo_basico);
						break;
					case(1):
						PanelDebil nuevo_debil = new PanelDebil(i,j);
						partida.getEscenario().establecerPanel(nuevo_debil);
						break;
					case(2):
						PanelResistente nuevo_resistente = new PanelResistente(i,j);
						partida.getEscenario().establecerPanel(nuevo_resistente);
						break;
					case(3):
						PanelAleatorio nuevo_aleatorio = new PanelAleatorio(i,j);
						partida.getEscenario().establecerPanel(nuevo_aleatorio);
						break;					
				}
			}
		}
		
		ArrayList<Elemento> lista = new ArrayList<Elemento>();
		lista.add(mun1);
		lista.add(mun2);
		lista.add(rej1);
		lista.add(rej2);
		lista.add(rat1);
		lista.add(rat2);
		lista.add(top1);
		lista.add(top2);
		lista.add(top3);
		lista.add(top4);
		lista.add(top5);
		lista.add(top6);
		lista.add(mon1);
		lista.add(mon2);
		
		for(Elemento elemento : lista) {
			ArrayList<Elemento> nueva = new ArrayList<Elemento>();
			nueva.add(elemento);
			Random random = new Random();
			int i = random.nextInt(partida.getEscenario().getAncho());
			int j = random.nextInt(partida.getEscenario().getAlto());
			elemento.setPanel(partida.getEscenario().getPanel(i,j));
			partida.getEscenario().getPanel(i,j).setElementos(nueva);
		}
		
		partida.arrancar();
		
		while(partida.getEnJuego()) {
			
			pantalla.resetear();
			
			if(pantalla.hayTecla()) {
				Posicion vecina;
                switch(pantalla.leerTecla()) {
                case "i":
                	vecina = partida.getObjetivo().getVecina(Direccion.ARRIBA);
                	if(partida.getEscenario().posicionValida(vecina)) {
                		partida.getObjetivo().desplazar(Direccion.ARRIBA);
                	}
                    break;
                case "j":
                	vecina = partida.getObjetivo().getVecina(Direccion.IZQUIERDA);
                	if(partida.getEscenario().posicionValida(vecina)) {
                		partida.getObjetivo().desplazar(Direccion.IZQUIERDA);
                	}
                    break;
                case "k":
                	vecina = partida.getObjetivo().getVecina(Direccion.ABAJO);
                	if(partida.getEscenario().posicionValida(vecina)) {
                		partida.getObjetivo().desplazar(Direccion.ABAJO);
                	}
                    break;
                case "l":
                	vecina = partida.getObjetivo().getVecina(Direccion.DERECHA);
                	if(partida.getEscenario().posicionValida(vecina)) {
                		partida.getObjetivo().desplazar(Direccion.DERECHA);
                	}	
                    break;
                case "d":
                    partida.disparar();
                    break;
                }
            }
			
			partida.actualizar();
			
			for (Imagen img : partida.getImagenesEscenario()) {
				pantalla.addImagen(img.getX(), img.getY(), img.getRuta());
			}
			
			String s = "Tiempo restante:"+partida.getSegundosRestantes()+"-Disparos:"+partida.getDisparos()+"-Puntos:"+partida.getPuntos();
			pantalla.setBarraEstado(s);
			
			pantalla.dibujar();
			Alarma.dormir(TIEMPO_ACTUALIZACION);
		}
		
		String s = "Fin del juego. Puntos conseguidos:"+partida.getPuntos();
		pantalla.setBarraEstado(s);
	}
}