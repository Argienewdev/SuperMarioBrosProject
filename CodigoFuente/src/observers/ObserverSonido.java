package observers;

import javax.swing.JLabel;

import elementos.ElementoDeJuego;

@SuppressWarnings("serial")
public class ObserverSonido extends JLabel implements Observer{
	
	private ElementoDeJuego entidad_observada;

	public ObserverSonido(ElementoDeJuego entidad_observada) {
		super();
		this.entidad_observada = entidad_observada;
	}
	
	public void actualizar() {
		emitirSonido();
	}
	
	public ElementoDeJuego getEntidadObservada() {
		return this.entidad_observada;
	}
	
	public void emitirSonido(){
		
	}
	
}
