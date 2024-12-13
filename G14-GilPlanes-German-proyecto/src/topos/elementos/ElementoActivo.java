package topos.elementos;

import topos.estructura.*;

public abstract class ElementoActivo extends Elemento {
	protected boolean desplazar(Direccion dirDest, Escenario escenario) {
		if(dirDest!=null) {
			Posicion origen = this.getPanel().getPosicion();
			Posicion destino = origen.getVecina(dirDest);
			
			boolean isPosiValida = escenario.posicionValida(destino);
			if(isPosiValida) {	
				//me elimino del panel actual
				this.getPanel().introducirElemento(this);
				
				//obtengo el panel al que me muevo
				PanelBasico panelDestino = escenario.getPanel(destino);
				
				//me agrego al panel destino
				panelDestino.introducirElemento(this);
				
				//actualizo mi referencia al panel que estoy
				this.setPanel(panelDestino);
				
				return true;
			}
			else {
				return false;
			}
		}
		return false;
	}
}
