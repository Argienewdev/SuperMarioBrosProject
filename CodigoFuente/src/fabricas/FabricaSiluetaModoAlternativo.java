package fabricas;

import elementos.Silueta;

public class FabricaSiluetaModoAlternativo extends FabricaSilueta {

	public FabricaSiluetaModoAlternativo(String rutaACarpeta) {
		super(rutaACarpeta);
	}

	@Override
	public Silueta obtenerSilueta() {
		return new Silueta(rutaACarpeta + "/siluetaModoAlternativo/silueta.png");
	}

}
