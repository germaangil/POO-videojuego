package topos.estructura;

import java.util.Random;

public class PanelAleatorio extends PanelBasico {
	
/** Propiedades **/
	
		private static final String RUTA = "imagenes/panel-aleatorio.png";
		
/** Constructor **/
		
		public PanelAleatorio(int x, int y) {
			super(x,y);
		}
		
/** Métodos **/
		
		public void derribar() {
			Random random = new Random();
			if(random.nextBoolean()) {
				super.derribar();
			}	
		}
		
		@Override
		public String getRuta() {
			return RUTA;
		}
}
