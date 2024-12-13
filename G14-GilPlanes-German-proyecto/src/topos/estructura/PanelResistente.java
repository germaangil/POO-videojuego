package topos.estructura;

public class PanelResistente extends PanelBasico {
	
/** Propiedades **/
	
	private static final String RUTA = "imagenes/panel-resistente.gif";
	private static final int DUREZA = 2;
	private int impactos;
	
/** Constructor **/
	
	public PanelResistente(int x, int y) {
		super(x,y);
		impactos=0;
	}
	
/** Métodos **/
	
	public void derribar() {
		if (impactos==DUREZA) {
			super.derribar();
			impactos=0;
		}
		impactos++;
		
	}
	
	@Override
	public String getRuta(){
			return RUTA;
	}
}
