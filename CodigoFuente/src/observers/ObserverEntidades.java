package observers;

import elementos.entidades.Entidad;

public class ObserverEntidades extends ObserverGrafico {
	
	public ObserverEntidades(Entidad entidad_observada) {
		super(entidad_observada);
		actualizar();
	}
}
