package topos.elementos;
	
import topos.estructura.*;
import topos.juego.*;
	
public abstract class Elemento {
	
	private PanelBasico panel;
	
	public PanelBasico getPanel() {
		return panel;
	}
	

	public void setPanel(PanelBasico panel) {
		this.panel = panel;
	}
	

	public Elemento() {
		panel = null;
	}
	
	public abstract ContribucionJuego getContribucionJuego();
	
	public abstract String getRuta();
	
	public abstract void actualizar(Escenario escenario);
}