package topos.estructura;

public class PanelDebil extends PanelBasico{

/** Propiedades **/
	
	private static final String RUTA = "imagenes/panel-debil.gif";
	private static final int LIMITE_IMPACTOS = 3;
	private int impactos;
	
/** Constructor **/
	
	public PanelDebil(int x, int y) {
		super(x,y);
		this.impactos=0;
	}
	
/** Métodos **/
	
	public void derribar() {
		if (impactos<=LIMITE_IMPACTOS) {
			super.derribar();
			impactos++;
		}
		
	}

	public void actualizar(Escenario escenario) {
		if (impactos<=LIMITE_IMPACTOS) {
			super.actualizar(escenario);
		}
	}
	
	@Override
	public String getRuta(){
		return RUTA;
	}
}
