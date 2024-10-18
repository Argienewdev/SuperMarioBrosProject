package observers;

import juego.EntidadLogica;

public class ObserverEntidades extends ObserverGrafico {
	
	public ObserverEntidades(EntidadLogica entidad_observada) {
		super(entidad_observada);
		actualizar();
	}
}
